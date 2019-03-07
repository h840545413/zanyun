package com.zanyun.model.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zanyun.index.model.User;

import com.zanyun.model.service.ModelService;

@Controller
@RequestMapping("/model")
public class ModelController {
	@Resource
	private ModelService modelService;
	@RequestMapping(value="/modellist.html",method=RequestMethod.GET)
	public String modellist(HttpServletRequest request,HttpSession session)
	{User user = (User) session.getAttribute("user");
	if(user!=null&&user.getOperatorId()!=null)
	{
		request.setAttribute("loginFlag", "1");
	}
		return "model/modellist";
	}
	@RequestMapping(value="/findmodels",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> findModels(Integer limit,Integer start,String key,HttpServletRequest request)
	{
		
		return modelService.findModels(start,limit,key);
	}
	

}
