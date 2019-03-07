package com.zanyun.org.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zanyun.common.base.ZsEnDecode64;
import com.zanyun.index.model.User;
import com.zanyun.model.PageInfo;
import com.zanyun.model.Render;
import com.zanyun.model.TUser;
import com.zanyun.org.model.ZsOrg;
import com.zanyun.org.service.OrgService;
import com.zanyun.user.service.UserService;

@Controller
@RequestMapping("/org")
public class OrgController {
	@Resource
	private UserService userService;
	@Resource
	private OrgService orgService;
	
	//加密狗认证\
	@RequestMapping(value="/zsdonglekeycheck",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> zsDongleKeyCheck(@ModelAttribute ZsOrg org)
	{
		return orgService.zsDongleKeyBinding(org);
		
	}
	//中山修改密码
	@RequestMapping(value="/zschangepassword",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> zschangepassword(String oldpassword,String loginname,String newpassword)
	{
		Map<String, String> returnMap = new HashMap<String, String>();
		returnMap.put("code", "9999");
		returnMap.put("details", "error");
		TUser user=new TUser();
		user.setOperatorId(loginname);
		ZsEnDecode64 code=new ZsEnDecode64();
		user.setPassword(code.decode64(newpassword));
	
		if(userService.updateUserByOperatorId(user)==1)
		{
			returnMap.put("code", "0000");
			returnMap.put("details", "success");
			return returnMap;
			
		}
	
		return returnMap;
	}
	//中山获取用户余额
	@RequestMapping(value="/zsfindmoney",method=RequestMethod.POST)
	@ResponseBody
		public Map<String, String> zsfindusermoney(String loginname)
		{
			Map<String, String> returnMap = new HashMap<String, String>();
			User user=userService.finUser(loginname);
			/*returnMap.put("code", "9999");
			returnMap.put("details", "not exist");*/
			if(user==null)
			{
				returnMap.put("money", "");
			return returnMap;	
			}
			returnMap.put("money", ZsEnDecode64.encode64(user.getMoney()));
			//this.writeJsonData(outerService.findUserMoney(request));
			return returnMap;
		}
	@RequestMapping(value="/findzsfindmoney",method=RequestMethod.GET)
	@ResponseBody
	public  String  findzsfindmoney()
	{
		return orgService.findzsmoney();
		
	}
	
	//中山获取用户渲染信息
		@RequestMapping(value="/zsrenderlist",method=RequestMethod.POST)
		@ResponseBody
		public PageInfo<Render> zsrenderlist(@ModelAttribute ZsOrg org)
		{
			//Map<String, String> returnMap = new HashMap<String, String>();
			
			User tUser=userService.finUser(org.getLoginname());
			return orgService.zsRenderList(org,tUser);
			//this.writeText(outerService.findUserRenderList(request));
		
		}
		
		
/*public Map<String,String> donglekeyActivation(String donglekey,String loginname,String password)
{
Integer 	

}*/
}
