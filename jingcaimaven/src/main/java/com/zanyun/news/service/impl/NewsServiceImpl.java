package com.zanyun.news.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zanyun.model.NewsModel;
import com.zanyun.model.PageInfo;
import com.zanyun.model.TNewsInformation;
import com.zanyun.news.service.NewsService;
import com.zanyun.service.BaseService;
@Service
public class NewsServiceImpl extends BaseService implements NewsService {
	@Override
	public Map<String,Object> findTopNewsList()
	{
		Map<String,String> submitMap=new HashMap<String, String>();
		submitMap.put("start", "1");
		submitMap.put("limit", "3");
		Map<String,Object> resultMap=new HashMap<String, Object>();
 		PageInfo<TNewsInformation>  page=super.httpListByPagePrase(COMMURL+"news/findnewslistbyyunsu", submitMap, TNewsInformation.class);
 		if (page==null) {
			Map<String,Object> Map=new HashMap<String, Object>();
			Map.put("newsList", "");
			Map.put("pageNum", "");
			return Map;
		}
 		List<TNewsInformation> list=page.getList();
		StringBuffer sbfTopThree=new StringBuffer();
		for(int i=0;i<list.size();i++)
		{ TNewsInformation info=list.get(i);
			Date date=new Date(info.getCreatedate());
			sbfTopThree.append("<div class=\"news_tittle_div\"><div style=\"width: 392px;height: 60px\"><div style=\"height: 60px;width: 60px;float: left;background-color:#e1f0f8; \"><div class=\"news_month\">"+(date.getDate())+"</div><div class=\"news_date\">"+(1900+date.getYear())+"."+(date.getMonth()+1)+"</div></div>");
			sbfTopThree.append("<div class=\"news_jianjie\"> <a href=\"/zanyunmaven/news/news/"+info.getId()+".html\" target=\"_blank\">"+info.getTitle()+"</a></div></div>");
			sbfTopThree.append("<div style=\"width: 100%;height:200px;margin-top: 16px;\"><div class=\"news_img\"><img src=\"http://www.zanyunjia.com"+info.getIocn()+"\"></div></div>");
			sbfTopThree.append("<div style=\"width: 392px;height: 60px;\"><div class=\"new_neirong_div\">"+info.getMemo()+"</div></div></div>");
		}
		resultMap.put("topnews", sbfTopThree.toString());
		resultMap.put("newsId", list.get(2).getId());
		return resultMap;
	}
	@Override
	public String findIndexTopNewsList()
	{
		Map<String,String> submitMap=new HashMap<String, String>();
		submitMap.put("start", "1");
		submitMap.put("limit", "3");
 		PageInfo<TNewsInformation>  page=super.httpListByPagePrase(COMMURL+"news/findnewslist", submitMap, TNewsInformation.class);
 		StringBuffer sbfTopThree=new StringBuffer();
 		if (page==null) {
			return sbfTopThree.toString();
		}
 		List<TNewsInformation> list=page.getList();
		for(int i=0;i<list.size();i++)
		{ 
		TNewsInformation info=list.get(i);
		sbfTopThree.append("<a href=\"/yunsumaven/news/news/"+info.getId()+".html\" target=\"_blank\">"+info.getTitle()+"</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		}
		/*Map<String,Object> resultMap=new HashMap<String, Object>();
		resultMap.put("topnews", sbfTopThree.toString());*/
		/*resultMap.put("newsId", list.get(2).getId());*/
		return sbfTopThree.toString();
	}
	@SuppressWarnings("deprecation")
	@Override
	public Map<String,Object> findNewsList(NewsModel model)
	{
		Map<String,String> submitMap=new HashMap<String, String>();
		submitMap.put("start", String.valueOf(model.getStart()));
		submitMap.put("limit",  String.valueOf(model.getLimit()));
		submitMap.put("id",String.valueOf( model.getId()));
		PageInfo<TNewsInformation>  page=super.httpListByPagePrase(COMMURL+"news/findnewslistbyyunsu", submitMap, TNewsInformation.class);
		StringBuffer sbfNews=new StringBuffer();
		if (page==null) {
			Map<String,Object> resultMap=new HashMap<String, Object>();
			resultMap.put("newsList", "");
			resultMap.put("pageNum", "");
			return resultMap;
		}
		List<TNewsInformation> list=page.getList();
		for(int i=0;i<list.size();i++)
		{
			TNewsInformation info=list.get(i);
			Date date=new Date(info.getCreatedate());
			String time=(date.getYear()+1900)+"/"+(date.getMonth()+1)+"/"+date.getDate();
			sbfNews.append("<li class=\"news_main\"><ul  style=\"list-style:none;\">");
			sbfNews.append("<li class=\"news_biaoti1\"><a href=\"/zanyunmaven/news/news/"+info.getId()+".html\">"+info.getTitle()+"</a></li>");
			sbfNews.append("<li class=\"news_biaoti2\">"+info.getTitle()+"</li>");
			sbfNews.append("<li class=\"news_biaoti3\">"+time+"</li></ul></li>");
		}
		
		Map<String,Object> resultMap=new HashMap<String, Object>();
		resultMap.put("newsList", sbfNews.toString());
		resultMap.put("pageNum", super.createPageDiv(model.getStart(), page.getPages(),"findnews"));
		return resultMap;
	}
	
	
	@SuppressWarnings({ "deprecation", "unused" })
	@Override
	public TNewsInformation findNews(Integer id)
	{
		TNewsInformation news=super.httpObjectPrase(COMMURL+"news/findnewsbyyunsu", "id", String.valueOf(id), TNewsInformation.class);
	Date date=new Date(news.getCreatedate());
	SimpleDateFormat sbf=new SimpleDateFormat("yyyy-MM-dd");
	news.setYear(String.valueOf(date.getYear()+1900));
	news.setMonth(String.valueOf(date.getMonth()+1));
	news.setDay(String.valueOf(date.getDate()));
	
		return news;
	}

	
}
