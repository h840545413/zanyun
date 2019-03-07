package com.zanyun.model.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.zanyun.model.PageInfo;
import com.zanyun.model.TLayoutModel;
import com.zanyun.model.TLayoutModelSucai;
import com.zanyun.model.TVideo;
import com.zanyun.model.service.ModelService;
import com.zanyun.service.BaseService;

@Service
public class ModelServiceImpl extends BaseService implements ModelService {
	@Override
	public String topThreeModels() {
		Map<String, String> submitMap = new HashMap<String, String>();
		submitMap.put("start", "1");
		submitMap.put("limit", "3");
		submitMap.put("orgId", "150021");
		PageInfo<TLayoutModelSucai> page = super.httpListByPagePrase(COMMURL
				+ "/layout/findmodelsforsucai", submitMap,
				TLayoutModelSucai.class);
		List<TLayoutModelSucai> list = page.getList();
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			sbf.append("<div class=\"ps1\" ><div class=\"ps2\">");
			sbf.append("<div class=\"pic\"><img src=\"http://sucaiku.yjia88.com:8888"
					+ list.get(i).getIcon()
					+ "\" style=\"height: 100%;width: 100%;z-index: -1;\"></div>");
			sbf.append("<div class=\"picword\" style=\"border-bottom: 2px solid #46dcff\"> <div class=\"pword1\">"
					/*+ list.get(i).getModelStyle()*/
					+ "</div><div class=\"pword2\">"
					+ list.get(i).getModelName() + "</div></div></div>");
			sbf.append("<div class=\"ps3 display\"><div class=\"pic1\">");
			sbf.append("<div class=\"pic\" style=\"position:relative;z-index: 10;height: 100%\"><a href=\"http://360zy.yjia88.com"+list.get(i).getFileName()+"\" target=\"_blank\"><button class=\"pic1_btn\"> <img src=\"/jingcaimaven/images/caseshow/play.png\" style=\"width: 100%;height: 100%\"> </button></a></div>");
			
			sbf.append("</div></div></div>");

		}
		return sbf.toString();
	}

	@Override
	public Map<String, Object> findModels(Integer start, Integer limit,
			String key) {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, String> submitMap = new HashMap<String, String>();
		submitMap.put("start", String.valueOf(start));
		submitMap.put("limit", String.valueOf(limit));
		submitMap.put("orgId", "150021");
		if (key != null && !"".equals(key)) {
			submitMap.put("modelName", key);
		}
		PageInfo<TLayoutModelSucai> page = super.httpListByPagePrase(COMMURL
				+ "/layout/findmodelsforsucai", submitMap,
				TLayoutModelSucai.class);
		List<TLayoutModelSucai> list = page.getList();
		StringBuffer sbf = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			TLayoutModelSucai layoutModel = list.get(i);
			sbf.append("<div class=\"case_main_pic_div\"><div class=\"case_main_pic_div_pic\"><a href=\"http://360zy.yjia88.com"
					+ layoutModel.getFileName()
					+ "\" target=\"_blank\"><img src=\"http://sucaiku.yjia88.com:8888"
					+ layoutModel.getIcon() + "\"></div>");
			sbf.append("<div class=\"case_main_pic_div_head\">"
					/*+ layoutModel.getModelStyle()*/ +"&nbsp;&nbsp;&nbsp;" +layoutModel.getModelName()
					+ "</div></div>");
		}
		returnMap.put("models", sbf.toString());
		returnMap.put("pageNum",
				super.createPageDiv(start, page.getPages(), "findmodels"));
		return returnMap;
	}
	@Override
	public Map<String,Object> findVideos(Integer start,Integer limit)
	{
		Map<String, Object> returnMap = new HashMap<String, Object>();
		Map<String, String> submitMap = new HashMap<String, String>();
		submitMap.put("start", String.valueOf(start));
		submitMap.put("limit", String.valueOf(limit));
		submitMap.put("status", "1");
		submitMap.put("type", "3");
		PageInfo<TVideo> videos=super.httpListByPagePrase(COMMURL+"other/findvideosbypage", submitMap, TVideo.class);
		
		
		List<TVideo> list=videos.getList();
		StringBuffer sbf=new StringBuffer();
		for(int i=0;i<list.size();i++)
		{
			sbf.append("<li><a href=\""+list.get(i).getVideourl()+"\" target=\"_blank\"><img src=\""+list.get(i).getVideofile()+"\"></a></li>");
			
		}
		
		returnMap.put("videos", sbf.toString());
		returnMap.put("pageNum",
				super.createPageDiv(start, videos.getPages(), "findvideos"));
		return returnMap;
		
	}

}
