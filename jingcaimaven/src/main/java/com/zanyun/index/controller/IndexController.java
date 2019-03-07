package com.zanyun.index.controller;


import java.io.Serializable;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.zanyun.account.model.RenderSubmit;
import com.zanyun.account.service.AccountService;
import com.zanyun.alipay.model.TMoneyDetails;
import com.zanyun.common.base.RandomValue;
import com.zanyun.index.model.User;
import com.zanyun.mail.JavaMailHelper;
import com.zanyun.model.TUser;
import com.zanyun.model.service.ModelService;
import com.zanyun.news.service.NewsService;
import com.zanyun.org.model.ZyDongleKey;
import com.zanyun.user.service.UserService;
/**
 *
 * 
 * @author lankepc
 *
 */
@Controller
@RequestMapping("/index")
@SessionAttributes("user")
public class IndexController  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private NewsService newsService;
	@Resource
	private UserService userService;
	@Resource
	private AccountService accountService;
	@Resource
	private ModelService modelService;

	/**
	 * 首页
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request, HttpSession session) {
		request.setAttribute("models", modelService.topThreeModels() );
		request.setAttribute("news", newsService.findIndexTopNewsList());
		User user = (User) session.getAttribute("user");
		if (user == null || "".equals(user.getOperatorId())) {
			request.setAttribute("loginFlag", "0");
			return "index/index";
		}
		request.setAttribute("loginFlag", "1");
		return "index/index";
	}

	/**
	 * 注册
	 * 
	 * @param tUser
	 * @param request
	 * @return
	 */
	
	  @RequestMapping(value = "/regist", method = RequestMethod.POST)
	  @ResponseBody
	  public String regist(User tUser, HttpServletRequest request,HttpSession session,String email,String yzm,HttpServletResponse response) { 
		  String registmail=(String) session.getAttribute("registmail");
		  String registyzm=(String) session.getAttribute("registyzm");
		
			Cookie cookie = new Cookie("jsessionid", "2jcligmgi6fh");
			cookie.setMaxAge(Integer.MAX_VALUE);
			
			response.addCookie(cookie);
			
		  if(email==null||yzm==null||registmail==null||registyzm==null||!email.equals(registmail)||!yzm.equals(registyzm))
		  {
			  
			  return "注册验证码失效，请重新注册！";
		  }
		  
	  if(userService.finUser(tUser.getOperatorId())!=null) { return "账号已经存在！"; }
	  tUser.setEmail(email);
	  tUser.setMailBox(email);
	  if(userService.addUser(tUser,request)==1){
		
		  userService.addQjMember(tUser);
		//  session.invalidate();
		  return "success";
	  }
	  session.invalidate();
	 return "账号添加失败，请联系客服！";
	  
	  }
	  
	  @RequestMapping(value = "/sregist", method = RequestMethod.GET)
	  public String student()
	  {
		  return "index/studentregist";
		  
	  }
	  
	/*  @RequestMapping(value = "/studentregist", method = RequestMethod.POST)
	  @ResponseBody
	  public String studentRegist(@ModelAttribute TUser tUser, @ModelAttribute TUserOther other,HttpServletRequest request,HttpSession session,String email,String yzm,String studentNo,String majorClass,String school,HttpServletResponse response) { 
	 
		  
		 // String registmail=(String) session.getAttribute("registmail");
		 // String registyzm=(String) session.getAttribute("registyzm");
		 
			Cookie cookie = new Cookie("jsessionid", "2jcligmgi6fh");
			cookie.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(cookie);
			 session.invalidate();
		//  if(email==null||yzm==null||registmail==null||registyzm==null||!email.equals(registmail)||!yzm.equals(registyzm))
		//  {
			//  
			//  return "注册验证码失效，请重新注册！";
		 // }
		  
	  if(userService.finUser(tUser.getOperatorId())!=null) { return "账号已经存在！"; }
	  tUser.setEmail(email);
	  tUser.setMailBox(email);
	  tUser.setUserType("3");
	  if(userService.addUser(tUser)==1){
		  userService.addRegistUserIp(request, tUser);
		  userService.addUserXy(tUser);
		  userService.addQjMember(tUser);
		  userService.studentRegist(tUser, other);
		  return "success";
	  }
	 return "账号添加失败，请联系客服！";
	  }*/
	  
	  

	@RequestMapping(value = "/recharge.html", method = RequestMethod.GET)
	public String recharge(HttpSession session,HttpServletRequest request,HttpServletResponse response) {
		User user = (User) session.getAttribute("user");
		if (user == null || "".equals(user.getOperatorId())) {
			Cookie cookie = new Cookie("jsessionid", "2jcligmgi6fh");
			cookie.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(cookie);
			return "redirect:/";
		}
		request.setAttribute("loginFlag", "1");
		return "index/recharge";
	}

	/**
	 * 主页
	 * 
	 * @param request
	 * @param session
	 * @return
	 */

	@ResponseBody
	@RequestMapping(value = "/checklogin", method = RequestMethod.POST)
	public Integer checklogin(HttpSession session, HttpServletRequest request,
			 User user, String loginName, ModelMap model) {
		user.setOperatorId(loginName);
		 user = userService.checkUserLogin(user);
		if (user != null && !"".equals(user.getOperatorId())) {
			model.addAttribute("user", user);
			session.setMaxInactiveInterval(3600);
			userService.addLoginRecord(request, user.getOperatorId());
			return 1;
		}
		return 9;

	}

	@RequestMapping(value = "/details.html", method = RequestMethod.GET)
	public String details(HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if(user!=null&&user.getOperatorId()!=null)
		{
			
			request.setAttribute("loginFlag", "1");
		}
	
		return "index/details";
	}

	/**
	 * 个人中心页面
	 * 
	 * @param request
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/personalcenter.html", method = RequestMethod.GET)
	public String personalCenter(HttpServletRequest request, HttpSession session,HttpServletResponse response) {
		User user = (User) session.getAttribute("user");
		if (user == null || "".equals(user.getOperatorId())) {
			Cookie cookie = new Cookie("jsessionid", "2jcligmgi6fh");
			cookie.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(cookie);
			return "redirect:/";
		}
		request.setAttribute("account", userService.finUser(user.getOperatorId()));

		//request.setAttribute("donglekey", "");
		//ZyDongleKey dongle=new ZyDongleKey();
	//	dongle.setOperatorId(user.getOperatorId());
		/*if (userService.findUserDongleKey(dongle) != null) {
			request.setAttribute("donglekey", "1");
		}*/
		return "index/personalCenter";

	}

	/**
	 * 查找用户订单信息
	 * 
	 * @param submit
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/findrenders", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findRender(@ModelAttribute RenderSubmit submit,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null || "".equals(user.getOperatorId())) {

			return null;
		}
		submit.setUserId(String.valueOf(user.getId()));
		return accountService.findRenderList(submit);

	}

	/**
	 * 查找账号资金信息
	 * 
	 * @param moneyDetails
	 * @param start
	 * @param limit
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/finddetails", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> findDetails(
			@ModelAttribute TMoneyDetails moneyDetails, Integer start,
			Integer limit, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null || "".equals(user.getOperatorId())) {

			return null;
		}
		moneyDetails.setOperatorId(user.getOperatorId());

		return accountService.moneydetails(moneyDetails, start, limit);

	}
	@RequestMapping(value = "/resetpassword.html", method = RequestMethod.GET)
	public String resetpassword(HttpServletRequest request,HttpSession session,HttpServletResponse response)
	{
		User user = (User) session.getAttribute("user");
		if (user != null && !"".equals(user.getOperatorId())) {

			
			Cookie cookie = new Cookie("jsessionid", "2jcligmgi6fh");
			cookie.setMaxAge(Integer.MAX_VALUE);
			response.addCookie(cookie);
			return "redirect:/";
		}
		
		return "index/forgetpassword";
	}
	/**
	 * 创建重置验证码
	 * @param Mailbox
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/createresetpasswordyzm", method = RequestMethod.POST)
	@ResponseBody
	public String createForgetPasswordYZM(String email, HttpSession session) {
	
		RandomValue value = new RandomValue();
		JavaMailHelper se = new JavaMailHelper(false);
		String yzm = value.getNumber(6);
		StringBuffer memo = new StringBuffer();
		session.setAttribute("forgetyzm", yzm);
		session.setAttribute("forgetmail", email);
		session.setMaxInactiveInterval(5 * 60);
		memo.append("赞云·云家重置密码邮箱验证码：【"+yzm+"】5分钟之内有效");
		se.doSendHtmlEmail("赞云验证码", memo.toString(), email);
		return yzm;
	}
	@RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
	@ResponseBody
	public String checkforgetpassword(@ModelAttribute TUser tUser,String yzm, HttpSession session,HttpServletResponse response) {
		TUser sessionuser = (TUser) session.getAttribute("user");
		if (sessionuser != null && !"".equals(sessionuser.getOperatorId())) {	
		return "当前用户已经登录";
		}
		String oldYzm = (String) session.getAttribute("forgetyzm");
		String mail = (String) session.getAttribute("forgetmail");
		if (yzm.equals(oldYzm)&&tUser.getEmail().equals(mail)) {
		User  user=userService.finUser(tUser);
		if(user!=null){
			
			tUser.setMailBox(tUser.getEmail());
			tUser.setPassword("123456");
			tUser.setOperatorId(user.getOperatorId());
			userService.updateUser(tUser);
			userService.changeQjPassword(user.getOperatorId(), "123456");
			session.removeAttribute("registYzm");
			session.removeAttribute("mail");
			return "success";
		}
		return "邮箱不存在";
		}
		return "提交数据错误";
	}
	
	
	/**
	 * 创建邮箱注册验证码
	 * 
	 * @param Mailbox
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/creatregistemailyzm", method = RequestMethod.POST)
	@ResponseBody
	public String emailYZMByRegist(String Mailbox, HttpSession session) {
	
		RandomValue value = new RandomValue();
		JavaMailHelper se = new JavaMailHelper(false);
		String yzm = value.getNumber(6);
		StringBuffer memo = new StringBuffer();
		session.setAttribute("registyzm", yzm);
		session.setAttribute("registmail", Mailbox);
		session.setMaxInactiveInterval(5 * 60);
		memo.append("赞云·云家注册验证码：【"+yzm+"】5分钟之内有效");
		se.doSendHtmlEmail("赞云验证码", memo.toString(), Mailbox);
		return yzm;
	}
	/**
	 * 创建邮箱验证码
	 * 
	 * @param Mailbox
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/createmailyzm", method = RequestMethod.POST)
	@ResponseBody
	public String emailYZM(String Mailbox, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null || "".equals(user.getOperatorId())) {

			return null;
		}
		RandomValue value = new RandomValue();
		JavaMailHelper se = new JavaMailHelper(false);
		String yzm = value.getNumber(6);
		StringBuffer memo = new StringBuffer();
		session.setAttribute("yzm", yzm);
		session.setAttribute("mail", Mailbox);
		session.setMaxInactiveInterval(5 * 60);
		memo.append("赞云·云家邮箱验证码：【"+yzm+"】5分钟之内有效");
		se.doSendHtmlEmail("赞云验证码", memo.toString(), Mailbox);
		return yzm;
	}
	
	/**
	 * 验证邮箱验证码
	 * @param yzm
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/checkyzm", method = RequestMethod.POST)
	@ResponseBody
	public String checkYzm(String yzm,String email, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null || "".equals(user.getOperatorId())) {

			return null;
		}
		String oldYzm = (String) session.getAttribute("yzm");
		String mail = (String) session.getAttribute("mail");
		if (yzm.equals(oldYzm)&&email.equals(mail)) {
			TUser tu=new TUser();
			tu.setOperatorId(user.getOperatorId());
			tu.setPassword(null);
			tu.setMoney(null);
			tu.setMailBox(mail);
			tu.setEmail(mail);
			user.setCreateDate(null);
			userService.updateUser(tu);
			session.removeAttribute("yzm");
			session.removeAttribute("mail");
			return "success";
		}
		return "error";
	}

	/**
	 * 修改密码
	 * 
	 * @param oldpassword
	 * @param password
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/changepassword", method = RequestMethod.POST)
	@ResponseBody
	public String changePassword(String oldpassword, String password,
			HttpSession session) {
		if (password == null || "".equals(password)) {
			return "error";
		}
		User user = (User) session.getAttribute("user");
		if (user == null || "".equals(user.getOperatorId())) {

			return "error";
		}
		TUser tu=new TUser(); 
		tu.setPassword(password);
		tu.setMoney(null);
		tu.setCreateDate(null);
		tu.setOperatorId(user.getOperatorId());
		userService.updateUser(tu);
		userService.changeQjPassword(user.getOperatorId(), user.getPassword());
		return "success";
	}

	/**
	 * 注销
	 * 
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/layout.html", method = RequestMethod.GET)
	public String layout(HttpSession session,HttpServletResponse response) {
		session.invalidate();
		Cookie cookie = new Cookie("jsessionid", "2jcligmgi6fh");
		cookie.setMaxAge(Integer.MAX_VALUE);
		response.addCookie(cookie);
		return "redirect:/";

	}

	@RequestMapping(value = "/findemail", method = RequestMethod.POST)
	@ResponseBody
	public String findemail(String email) {

		/*
		 * User user = (User) session.getAttribute("user"); if (user == null
		 * || "".equals(user.getOperatorId())) {
		 * 
		 * return null; }
		 */
		TUser tuser = new TUser();
		tuser.setEmail(email);
		if (userService.finUser(tuser) == null) {
			return "1";
		}

		return "0";
	}
	@RequestMapping(value = "/bindingdonglekey", method = RequestMethod.POST)
	@ResponseBody
	public String bindingDonglekey(String donglekey,HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		if (user == null || "".equals(user.getOperatorId())) {

			return "error";
		}
		return userService.dongleKeyBinding(donglekey, user.getOperatorId(), user.getOrgId());
		
		
		
		
	}
	@RequestMapping(value = "/video.html", method = RequestMethod.GET)
	public String video(HttpServletRequest request,HttpSession session)
	{
		User user = (User) session.getAttribute("user");
		if(user!=null&&user.getOperatorId()!=null)
		{
			
			request.setAttribute("loginFlag", "1");
		}
		
		return "index/videos";
	}
	@RequestMapping(value = "/findvideos", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> findVideos(Integer start,Integer limit)
	{
		return modelService.findVideos(start, limit);
	}
	//注册验证账号是否已经被注册
	@RequestMapping(value = "/checkloginname", method = RequestMethod.POST)
	@ResponseBody
	public Integer checkLoginName(String loginname)
	{
		User user=userService.finUser(loginname);
		if(user!=null&&user.getOperatorId()!=null)
		{
			
			return 1;
		}
		return 0;
		
	}

	/*@RequestMapping(value="/checkdonglekey",method = RequestMethod.POST)	
	@ResponseBody
	public Integer findDonglekey(ZyDongleKey dongleKey)
	{
		
		ZyDongleKey donglekey=userService.findUserDongleKey(dongleKey);
		if(donglekey==null){return 9;}
		if(donglekey.getOperatorId()!=null&&!"".equals(donglekey.getOperatorId())){return 1;}
		
		return 0;
	}*/
	
	@RequestMapping(value="/checkdonglekey",method = RequestMethod.POST)	
	@ResponseBody
	public Integer addUser(User user,HttpServletRequest request)
	{
		
		
		
	return	userService.addUser(user, request);
		
	}
}

