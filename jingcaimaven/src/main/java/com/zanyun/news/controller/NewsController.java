package com.zanyun.news.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zanyun.model.NewsModel;
import com.zanyun.model.TUser;
import com.zanyun.news.service.NewsService;

@Controller
@RequestMapping("/news")
public class NewsController {
	@Resource
	private NewsService service;
@RequestMapping(value="/newslist.html",method=RequestMethod.GET)
public String newsList(HttpServletRequest request,HttpSession session)
{
	TUser user = (TUser) session.getAttribute("user");
	if(user!=null&&user.getOperatorId()!=null)
	{
		
		request.setAttribute("loginFlag", "1");
	}

	Map<String,Object> map=service.findTopNewsList();
	request.setAttribute("topnews", map.get("topnews"));
		//top3
		//limit 7,from 3
	return "news/newslist";
}
	@RequestMapping(value="/news/{id}.html",method=RequestMethod.GET)
	public String news(@PathVariable Integer id,HttpServletRequest request,HttpSession session)
	{
		TUser user = (TUser) session.getAttribute("user");
		if(user!=null&&user.getOperatorId()!=null)
		{
			
			request.setAttribute("loginFlag", "1");
		}
		
		request.setAttribute("news", service.findNews(id));
		return "news/news";
	}
	
@RequestMapping(value="findnewslist",method=RequestMethod.POST)
@ResponseBody
	public Map<String,Object> findNewsList(NewsModel model)
	{
		
	return service.findNewsList(model);
	}
}
