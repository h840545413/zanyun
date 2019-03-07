package com.zanyun.user.service;



import javax.servlet.http.HttpServletRequest;

import com.zanyun.index.model.User;
import com.zanyun.model.TUser;
import com.zanyun.model.TUserOther;
import com.zanyun.org.model.ZyDongleKey;

public interface UserService {
	//public TUser checkUserLogin(TUser tUser);
	public String findUserMoney(String operatorId);
	User finUser(String operatorId);
	String updateUserMoney(TUser tUser, String v);
	/*String addRegistUserIp(HttpServletRequest request);*/
	//Integer addUser(TUser tuser);
	//String addRegistUserIp(HttpServletRequest request, TUser user);
	Integer addUserXy(TUser user);
	Integer updateUser(TUser user);
	//ZyDongleKey findUserDongleKey(String operatorId);
	User finUser(TUser user);
	Integer addLoginRecord(HttpServletRequest request, String operatorId);
	//String addQjMember(TUser user);
	String changeQjPassword(String operatorId, String password);
	Integer updateUserByOperatorId(TUser user);
	String dongleKeyBinding(String donglekey, String operatorId,String orgId);
	ZyDongleKey findUserDongleKey(ZyDongleKey donglekey);
	String studentRegist(TUser user, TUserOther userOther);
	User checkUserLogin(User tUser);

	String addQjMember(User user);
	Integer addUser(User tuser, HttpServletRequest request);
}
