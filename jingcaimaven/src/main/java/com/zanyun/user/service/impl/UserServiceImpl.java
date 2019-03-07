package com.zanyun.user.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import com.zanyun.common.base.EnDecode64;
import com.zanyun.common.base.RandomValue;
import com.zanyun.index.model.User;
import com.zanyun.model.HttpUtils;
import com.zanyun.model.IpUtils;
import com.zanyun.model.TUser;
import com.zanyun.model.TUserOther;
import com.zanyun.model.ZyZanyunLogin;
import com.zanyun.org.model.ZyDongleKey;
import com.zanyun.render.model.TUserXy;
import com.zanyun.service.BaseService;
import com.zanyun.user.service.UserService;

@Service
public class UserServiceImpl extends BaseService implements UserService {
	@Resource
	private EnDecode64 code;

	@Override
	public User checkUserLogin(User tUser) {

		User user = super.httpObjectPrase(COMMURL + "user/finduser", super.objectToMap(tUser), User.class);

		return user;

	}

	@Override
	public String findUserMoney(String operatorId) {

		Map<String, String> map = new HashMap<String, String>();
		map.put("operatorId", operatorId);
		TUser user = super.httpObjectPrase(COMMURL + "user/finduser", map,
				TUser.class);
		String money = code.decode64(user.getMoney());

		return money;
	}

	@SuppressWarnings("static-access")
	@Override
	public User finUser(String operatorId) {

		User user = super.httpObjectPrase(COMMURL + "user/finduser",
				"operatorId", operatorId, User.class);
		if (user == null) {
			return null;
		}
		if (user.getMoney() != null && !"".equals(user.getMoney())) {
			String money = String.valueOf(new BigDecimal(code.decode64(user
					.getMoney())).setScale(2, BigDecimal.ROUND_HALF_UP));
			user.setMoney(money);
		}

		return user;
	}

	@Override
	public User finUser(TUser user) {

		User newuser = super.httpObjectPrase(COMMURL + "user/finduser",
				super.objectToMap(user), User.class);
		return newuser;
	}

	@SuppressWarnings("static-access")
	@Override
	public String updateUserMoney(TUser tUser, String v) {

		Map<String, String> submitMap = super.objectToMap(tUser);
		submitMap.remove("money");
		// 获取旧金额
		User user = super.httpObjectPrase(COMMURL + "user/finduser",
				submitMap, User.class);
		String odlMoney = code.decode64(user.getMoney());
		BigDecimal totalMoney = null;
		if (v.equals("delete")) {
			totalMoney = new BigDecimal(odlMoney).subtract(
					new BigDecimal(tUser.getMoney())).setScale(2,
					BigDecimal.ROUND_HALF_UP);

		} else {
			totalMoney = new BigDecimal(odlMoney).add(
					new BigDecimal(tUser.getMoney())).setScale(2,
					BigDecimal.ROUND_HALF_UP);
		}
		
		TUser newuser=new TUser();
		newuser.setOperatorId(user.getOperatorId());
		newuser.setMoney(code.encode64(totalMoney.toString()));
		newuser.setPassword(null);
		Integer flag = super.httpInsertOrUpdate(COMMURL + "user/updateuser",
				super.objectToMap(newuser));
		// 更新新金额
		if (flag < 1) {
			return "error";

		}
		if (totalMoney.compareTo(new BigDecimal(0)) < 0) {
			return "arrears";
		}
		return user.getOperatorId();

	}

	@SuppressWarnings("static-access")
	@Override
	public Integer addUser(User tuser,HttpServletRequest request) {
		tuser.setMoney(code.encode64("0.00"));
		tuser.setStatus("1");
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		Map<String, String> map = new HashMap<String, String>();
		map.put("ip", ip);
		Map<String, String> headers = new HashMap<String, String>();
		// 最后在header中的格式(中间是英文空格)为Authorization:APPCODE
		// 83359fd73fe94948385f570e3c139105
try{
	String host = "https://api01.aliyun.venuscn.com";
    String path = "/ip";
    String method = "GET";
    String appcode = "86d0b14c4edf4e199608c7c0a17d9002";
    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
    headers.put("Authorization", "APPCODE " + appcode);
	HttpResponse response = HttpUtils.doGet(host, path, method, headers, map);			
	/*String returnstr = super.httpIpGet(
			"https://api01.aliyun.venuscn.com", map,
			headers);*/
	//System.out.println(response.toString());
	JSONObject jsb = JSONObject.fromObject(EntityUtils.toString(response.getEntity()));
	Object o=jsb.get("data");
	JSONObject jsonObject2=JSONObject.fromObject(o);
	IpUtils iputils=(IpUtils) JSONObject.toBean(jsonObject2, IpUtils.class);
	tuser.setIpaddress(iputils.getRegion()+" "+iputils.getCity());
		}catch(Exception e){
			tuser.setIpaddress("获取IP接口错误");
		}
		//TUserRegisterIP registerIP = new TUserRegisterIP();
		//tuser.setOperatorId(user.getOperatorId());
		Date date = new Date();
		//tuser.setCreatedate(date.getTime());
		tuser.setIp(ip);
		tuser.setIpaddress(tuser.getIpaddress());
		tuser.setUserType("3");
		tuser.setOrgId("10000");
		RandomValue value = new RandomValue();
		tuser.setXyLoginName("zy" + value.getFive() + value.getFive() + "zy");
		
		
		Integer flag = super.httpInsertOrUpdate(COMMURL + "user/adduser",
				super.objectToMap(tuser));
						return flag;

	}


	@Override
	public Integer addLoginRecord(HttpServletRequest request, String operatorId) {

		ZyZanyunLogin login = new ZyZanyunLogin();
		Date date = new Date();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}

		login.setLoginTime(date.getTime());
		login.setOperatorId(operatorId);
		login.setIp(ip);
		Integer flag = super.httpInsertOrUpdate(
				COMMURL + "user/addzanyunlogin", super.objectToMap(login));
		return flag;
	}

	@Override
	public Integer addUserXy(TUser user) {

		RandomValue value = new RandomValue();

		TUserXy userxy = new TUserXy();
		userxy.setXyloginname("zy" + value.getFive() + value.getFive() + "zy");
		userxy.setOperatorId(user.getOperatorId());
		Integer flag = super.httpInsertOrUpdate(COMMURL + "user/adduserxy",
				super.objectToMap(userxy));
		return flag;
	}

	@Override
	public Integer updateUser(TUser user) {
		Integer flag = super.httpInsertOrUpdate(COMMURL + "user/updateuser",
				super.objectToMap(user));
		return flag;
	}

	@Override
	public ZyDongleKey findUserDongleKey(ZyDongleKey donglekey) {
		ZyDongleKey dongleKey = super.httpObjectPrase(COMMURL
				+ "donglekey/findzydonglekey", super.objectToMap(donglekey),
				ZyDongleKey.class);
		return dongleKey;

	}

	@Override
	public String addQjMember(User user) {
		Map<String, String> submitMap = new HashMap<String, String>();
		submitMap.put("operatorId", user.getOperatorId());
		submitMap.put("password", user.getPassword());
		String result = super.httpstr2("http://360zy.yjia88.com/member/div/addmember", submitMap);
		return result;

	}

	@Override
	public String changeQjPassword(String operatorId, String password) {

		Map<String, String> submitMap = new HashMap<String, String>();
		submitMap.put("operatorId", operatorId);
		submitMap.put("newpassword", password);
	
		String result = super.httpstr2("http://360zy.yjia88.com/member/div/changepassword", submitMap);
		return result;

	}

	public Integer deleteDonglekey(String operatorId) {
		Map<String, String> submitMap = new HashMap<String, String>();
		submitMap.put("operatorId", "");
		submitMap.put("status", "0");
		Integer flag = super.httpInsertOrUpdate(COMMURL
				+ "donglekey/fidnzydonglekey", submitMap);
		return flag;

	}

	/*
	 * @Override public Integer addDongkekey() {}
	 */

	@Override
	public Integer updateUserByOperatorId(TUser user) {
		Integer flag = super.httpInsertOrUpdate(COMMURL
				+ "user/updateuser", super.objectToMap(user));

		return flag;
	}

	@SuppressWarnings("unused")
	@Override
	public String dongleKeyBinding(String donglekey, String operatorId, String orgId) {
		Map<String, String> submitMap2 = new HashMap<String, String>();
		submitMap2.put("operatorId", operatorId);
		submitMap2.put("state", "2");
		Integer flag = super.httpInsertOrUpdate(COMMURL + "donglekey/updatedonglekey", submitMap2);
		Map<String, String> submitMap = new HashMap<String, String>();
		submitMap.put("dongleKey", donglekey);
		submitMap.put("orgNum", "140001");
		ZyDongleKey key = super.httpObjectPrase(COMMURL + "donglekey/findzydonglekey", submitMap, ZyDongleKey.class);
		// ZyDongleKey key=super.httpObjectPrase(COMMURL, submitMap,
		// ZyDongleKey.class);
		if (key == null) {
			return "加密狗不存在";
		}
		if (key.getState() != 0) {
			return "加密狗已经被使用";
		}
		if (!orgId.equals("140001") && !key.getOrgNum().equals(orgId)) {
			return "加密狗与账号不匹配";
		}
	//	submitMap.put("operatorId", operatorId);
		// RandomValue value = new RandomValue();
		submitMap.put("operatorId", operatorId);
		submitMap.put("state", "1");
		 flag = super.httpInsertOrUpdate(COMMURL + "donglekey/updatedonglekey", submitMap);
		return "success";
	}
	@Override
	public String studentRegist(TUser user,TUserOther userOther)
	{
		userOther.setOperatorId(user.getOperatorId());
		super.httpInsertOrUpdate(COMMURL+"user/addother", super.objectToMap(userOther));
		return "success";
	}



}
