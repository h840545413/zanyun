package com.zanyun.news.service;

import java.util.Map;

import com.zanyun.model.NewsModel;
import com.zanyun.model.TNewsInformation;

public interface NewsService {

	Map<String,Object> findNewsList(NewsModel model);

	TNewsInformation findNews(Integer id);

	Map<String, Object> findTopNewsList();

	String findIndexTopNewsList();

}
