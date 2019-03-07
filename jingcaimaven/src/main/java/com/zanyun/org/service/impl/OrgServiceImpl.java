package com.zanyun.org.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;






import com.zanyun.common.base.EnDecode64;
import com.zanyun.common.base.ZsEnDecode64;
import com.zanyun.index.model.User;
import com.zanyun.model.PageInfo;
import com.zanyun.model.Render;
import com.zanyun.model.TUser;
import com.zanyun.org.model.ZsOrg;
import com.zanyun.org.model.ZyDongleKey;
import com.zanyun.org.service.OrgService;
import com.zanyun.service.BaseService;
@Service
public class OrgServiceImpl extends BaseService implements OrgService {
	//中山注册
	@Override
	public Map<String,String> zsOrgRegist(ZsOrg org)
	{
		Map<String,String> returnMap=new HashMap<String, String>();
		returnMap.put("code", "9999");
		Map<String,String> submitMap=new HashMap<String, String>();
		submitMap.put("operatorId", org.getLoginname());
		
		TUser findUser=super.httpObjectPrase(COMMURL +"/user/finduser",submitMap, TUser.class);
		if(findUser!=null)
		{
			returnMap.put("details", "exist");
			return returnMap;
			
		}
		submitMap.put("password", org.getPassword());
		submitMap.put("orgid", "140000");
		submitMap.put("mailbox", org.getEmail());
		submitMap.put("email", org.getEmail());
		submitMap.put("level", "1");
		submitMap.put("status", "1");
		Integer flag=super.httpObjectPrase(COMMURL, submitMap, Integer.class);
		returnMap.put("code", "0000");
		returnMap.put("details", "success");
		return returnMap;
	}
	//中山加密狗认证
	@SuppressWarnings("unused")
	@Override
	public Map<String,String> zsDongleKeyBinding(ZsOrg org)
	{
		Map<String, String> submitMap = new HashMap<String, String>();
		Map<String, String> returnMap = new HashMap<String, String>();
		returnMap.put("code", "9999");
		submitMap.put("dongleKey", org.getDonglekey());
		submitMap.put("orgNum", "140001");
		ZyDongleKey key = super.httpObjectPrase(COMMURL
				+ "donglekey/findzydonglekey",submitMap ,
				ZyDongleKey.class);
		//ZyDongleKey key=super.httpObjectPrase(COMMURL, submitMap, ZyDongleKey.class);
		if(key==null){
			returnMap.put("details", "donglekey is not exist");
			return returnMap;
		}else if(key.getState()==1)
		{
			returnMap.put("details", "donglekey is used");
			return returnMap;
		}else if(key.getState()==2)
		{
			returnMap.put("details", "donglekey is invalid");
			return returnMap;
		}
		submitMap.put("operatorId", org.getLoginname());
		
		//RandomValue value = new RandomValue();
		submitMap.put("operatorId", org.getLoginname());
		submitMap.put("state", "1");
		Integer flag=super.httpInsertOrUpdate(COMMURL+"donglekey/updatedonglekey", submitMap);
		returnMap.put("code", "0000");
		returnMap.put("details", "success");
		return returnMap;
	}
	//中山密码修改
	public Map<String,String> zsChangePassword(ZsOrg org)
	{
		
		Map<String, String> submitMap = new HashMap<String, String>();
		Map<String, String> returnMap = new HashMap<String, String>();
		
		ZsEnDecode64 code=new ZsEnDecode64();
		submitMap.put("operatorId", org.getLoginname());
		submitMap.put("password", code.decode64(org.getNewpassword()));
		Integer flag=super.httpObjectPrase(COMMURL+"user/updateuserbyoperatorid", submitMap, Integer.class);
		returnMap.put("code", "0000");
		returnMap.put("details", "success");
		return returnMap;
		
	}
	
	//中山获取用户余额
	@SuppressWarnings("static-access")
	@Override
	public String zsFindMoney(TUser user)
	{
		/*Map<String, String> submitMap = new HashMap<String, String>();
		Map<String, String> returnMap = new HashMap<String, String>();
		submitMap.put("loginName", org.getLoginname());
		TUser user=super.httpObjectPrase(COMMURL, submitMap, TUser.class);*/
		EnDecode64 code=new EnDecode64();
		ZsEnDecode64 zscode=new ZsEnDecode64();
		//returnMap.put("money",zscode.encode64( code.decode64(user.getMoney())));
		return zscode.encode64( user.getMoney());
		
	}
	//中山获取用户渲染信息
	@Override
	public PageInfo<Render> zsRenderList(ZsOrg org,User user)
	{
	
		Map<String, String> submitMap = new HashMap<String, String>();
		submitMap.put("operatorId", org.getLoginname());
		submitMap.put("start", org.getStart());
		submitMap.put("limit", org.getLimit());
		submitMap.put("userId",String.valueOf( user.getId()));
		PageInfo<Render> render=super.httpListByPagePrase(COMMURL+"/render/getrender", submitMap, Render.class);
		
	
		return render;
	}
	/*public static void main(String args[])
	{
		ZsEnDecode64 code=new ZsEnDecode64();
		System.out.println(code.decode64("Kmj7Fm0j"));
		
	}
*/
	@Override
	public String findzsmoney()
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("loginname", "yf111111");
		String value=super.httpPost("http://www.zanyunjia.com/org/zsfindmoney", map);
		//String value=super.httpGet("http://www.zanyunjia.com/org/zsfindmoney", map);
		return value;
		
		
	}
	
	@Override
	public Integer donglekeyActivation(String donglekey,String loginname,String password)
	{
		
		ZyDongleKey key = super.httpObjectPrase(COMMURL
				+ "donglekey/findzydonglekey","dongleKey" ,donglekey,
				ZyDongleKey.class);
		if(key.getOrgNum().equals("")){return 7;}
		if(key.getState()!=0){return 8;}
		key.setDongleKey(donglekey);key.setId(null);key.setCheckTime(null);key.setCreateTime(null);key.setState(1);
		Integer flag=super.httpInsertOrUpdate(COMMURL, super.objectToMap(key));
	
		return flag;
	}
	
}
