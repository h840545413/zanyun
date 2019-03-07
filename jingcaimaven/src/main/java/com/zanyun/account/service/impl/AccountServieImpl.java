package com.zanyun.account.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Service;







import com.zanyun.model.Render;
import com.zanyun.model.PageInfo;
import com.zanyun.account.model.RenderSubmit;
import com.zanyun.account.service.AccountService;
import com.zanyun.alipay.model.TMoneyDetails;
import com.zanyun.service.BaseService;
@Service
public class AccountServieImpl extends BaseService implements AccountService {
	@Override
	public  Map<String,Object> moneydetails(TMoneyDetails moneyDetails,Integer start,Integer limit)
	{
		Map<String,Object> resultMap=new HashMap<String,Object>();
		Map<String,String> sumbitMap= super.objectToMap(moneyDetails);
		sumbitMap.put("start", String.valueOf(start));
		sumbitMap.put("limit", String.valueOf(limit));
		PageInfo<TMoneyDetails> moneydetails=super.httpListByPagePrase(COMMURL+"money/findmoneydetails", sumbitMap, TMoneyDetails.class);
		if(moneydetails==null||moneydetails.getPageNum()==0)
		{
			resultMap.put("moneydetails", "");
			resultMap.put("pageNum", "");
			return resultMap;
		}
		List<TMoneyDetails> list= moneydetails.getList();
		if(list==null)
		{
			resultMap.put("moneydetails", "");
			resultMap.put("pageNum", "");
			return resultMap;
		}
		StringBuffer sbf=new StringBuffer();
		sbf.append("<tr><td style=\"width: 25%\">记录时间</td><td style=\"width: 25%\">金额</td><td style=\"width: 25%\">记录类型</td><td style=\"width: 25%\">备注</td></tr>");
		for(int i=0;i<list.size();i++)
		{	
			Long time=list.get(i).getCreatedate();
			Date date=new Date(time);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			sbf.append("<tr><td>"+sdf.format(date)+"</td><td>"+list.get(i).getMoney().toString()+"</td><td>"+list.get(i).getZjx()+"</td><td>"+list.get(i).getMemo()+"</td></tr>");
			}
		resultMap.put("moneydetails", sbf.toString());
		resultMap.put("pageNum", super.createPageDiv(start, moneydetails.getPages(), "finddetails"));
		return resultMap;
		
	}
	@Override
	public Map<String,Object> findRenderList(RenderSubmit submit) {
		
		Map<String,Object> resultMap=new HashMap<String,Object>();
		
		PageInfo<Render> render=super.httpListByPagePrase(COMMURL+"/render/getrender", super.objectToMap(submit), Render.class);
		if(render==null||render.getPageNum()==0)
		{
			resultMap.put("moneydetails", "");
			resultMap.put("pageNum", "");
			return resultMap;
		}
		List<Render> renderList =render.getList();
		if(renderList==null)
		{
			resultMap.put("renders", "");
			resultMap.put("pageNum", "");
			return resultMap;
		}
		StringBuffer renderstr=new StringBuffer();
		renderstr.append("<tr><td style=\"width:15%\">渲染订单号</td><td style=\"width:25%\">渲染开始时间</td><td style=\"width:25%\">渲染结束时间</td><td style=\"width:15%\">渲染结果</td><td style=\"width:10%\">价格</td><td style=\"width:10%\">退款</td></tr>");
		for(int i=0;i<renderList.size();i++)
		{	
			
			renderstr.append("<tr><td>"+renderList.get(i).getOrderId()+"</td><td>"+(renderList.get(i).getStartTime()==null?"--":renderList.get(i).getStartTime())+"</td><td>"+(renderList.get(i).getEndTime()==null?"--":renderList.get(i).getEndTime())+"</td><td>"+(renderList.get(i).getOrderstate()==null?"--":renderList.get(i).getOrderstate())+"</td><td>"+(renderList.get(i).getYkmoney()==null?"--":renderList.get(i).getYkmoney().toString())+"</td><td>--</td></tr>");
			/*renderstr.append("<div class=\"record\"><div class=\"left\"> <ul class=\"left_ul\"><li class=\"li1\">订单号："+renderList.get(i).getOrderId()+"</li><li class=\"li2\">"+renderList.get(i).getOrderId()+"</li> <li class=\"li1\">开始时间："+renderList.get(i).getStartTime()+"</br>结束时间："+renderList.get(i).getEndTime()+"</li><li class=\"money_li\">￥"+renderList.get(i).getCost()"10.00"+"</li></ul></div> <div class=\"right\"><a href=\"![http://backups.yjia88.com:8080/zanyun/zanyun/order/"+renderList.get(i).getOrderId()+".html]!\" ><img src=\"/zanyun/img/ckclose.png\"/></br>查看图片</a></div> </div>");*/
		}
		resultMap.put("renders",renderstr.toString() );
		resultMap.put("pageNum", super.createPageDiv(submit.getStart(), render.getPages(), "findrenders"));
		///resultMap.put("render", renderstr.toString());
		//resultMap.put("pageNum", super.createPageDiv(render.getPageNum(), render.getPages(),"/zanyun/zanyun/renderapge/0-",""));
		return resultMap;
	}

	@Override
	public Integer addMoneyDetails(TMoneyDetails moneyDetails)
	{JSONObject jsb=new JSONObject().fromObject(moneyDetails);
	
	System.out.println(jsb.toString());
		Integer flag=super.httpInsertOrUpdate(COMMURL+"money/addmoneydetail", super.objectToMap(moneyDetails));
		
		return flag;
	}
}
