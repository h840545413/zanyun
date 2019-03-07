package com.zanyun.service;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;











import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.http.client.ClientProtocolException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zanyun.common.base.HttpClientUtils;
import com.zanyun.model.PageInfo;

@Component
public class BaseService {

	@Autowired(required = false)
	private HttpClientUtils httpClientUtils;
	public final Logger log = Logger.getLogger(this.getClass());
	//protected static final String COMMURL = "http://localhost:8080/zyhome/";
	protected static final String COMMURL = "http://www.zanyunjia.com:8083/zyhome/";
	//protected static final String COMMURL = "http://backups.yjia88.com:8080/zyhome/";
	/**
	 * json字符串转对象（map）
	 * 
	 * @param url
	 * @param map
	 * @param valueType
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public static <T> T httpObjectPrase(String url, Map<String, String> map,
			Class<T> valueType) {
		try {
			T t = valueType.newInstance();
			String jsonStr = HttpClientUtils.mPost(url, map);
		
			JSONObject jsb = new JSONObject().fromObject(jsonStr);
			t = (T) JSONObject.toBean(jsb, valueType);
			return t;
		} catch (Exception e) {
			return null;
		}

	}
	
	public static String httpIpGet(String url, Map<String, String> map,Map<String, String> headers)
	{
		
		String jsonStr=null;
		try {
			jsonStr = HttpClientUtils.mGet(url, map, headers, "utf-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonStr;
	}
	
	public static String httpPost(String url, Map<String, String> map)
	{
		
		String jsonStr=null;
		try {
			jsonStr = HttpClientUtils.mPost(url, map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonStr;
	}
	/**
	 * 
	 * @param url
	 * @param map
	 * @return
	 */
	public static String httpstr(String url, Map<String, String> map) {
		try {
			
			String jsonStr = HttpClientUtils.mGet(url, map);
			return jsonStr;
		} catch (Exception e) {

			return null;
		}

	}
	
	/**
	 * 
	 * @param url
	 * @param map
	 * @return
	 */
	public static String httpstr2(String url, Map<String, String> map) {
		try {
			
			String jsonStr = HttpClientUtils.mPost(url, map);
			return jsonStr;
		} catch (Exception e) {

			return null;
		}

	}
	/**
	 * json字符串转对象（key,value）
	 * 
	 * @param url
	 * @param key
	 * @param value
	 * @param valueType
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public static <T> T httpObjectPrase(String url, String key, String value,
			Class<T> valueType) {
		try {
			T t = valueType.newInstance();
			String jsonStr = HttpClientUtils.mPost(url, key, value);
			System.out.println(jsonStr);
			JSONObject jsb = new JSONObject().fromObject(jsonStr);
			t = (T) JSONObject.toBean(jsb, valueType);
			return t;
		} catch (Exception e) {

			return null;
		}

	}
	//{"id":156,"operatorId":"mtjj","name":null,"password":"0e8473be9e9fb4068e5675a6e7791c5a","orgid":"140001","mobile":"1391111","phone":null,"mailbox":"111@111","status":"1","usertype":null,"email":null,"createdate":1449039963000,"dz":null,"money":"CZWmBZ0W","num":null,"orgname":"","level":0,"vip":null,"dj":0,"staffId":"156"}
	//{"id":203,"operatorId":"wangchao0322","name":"王超","password":"e10adc3949ba59abbe56e057f20f883e","orgid":"140001","mobile":"","phone":"","mailbox":"","status":"1","usertype":null,"email":"","createdate":null,"dz":null,"money":"DIusD20W","num":null,"orgname":null,"level":0,"vip":1513900315000,"dj":0,"staffId":"203"}
	/**
	 * json字符串转对象列表
	 * 
	 * @param url
	 * @param map
	 * @param valueType
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public static <T> List<T> httpListPrase(String url,
			Map<String, String> map, Class<T> valueType) {

		try {
			List<T> list = new ArrayList<T>();
			String jsonStr = HttpClientUtils.mPost(url, map);
			JSONArray jsa = JSONArray.fromObject(jsonStr);
			/* Collection collection = JSONArray.toCollection(jsa, valueType); */
			list = JSONArray.toList(jsa, valueType);
			return list;
		} catch (Exception e) {

			return null;
		}

	}

	/**
	 * json字符串转分页对象
	 * 
	 * @param url
	 * @param map
	 * @param valueType
	 * @return
	 */
	@SuppressWarnings({ "static-access", "unchecked", "rawtypes" })
	public static <T> PageInfo<T> httpListByPagePrase(String url,
			Map<String, String> map, Class<T> valueType) {
		try {
			String jsonStr = HttpClientUtils.mPost(url, map);
			JSONObject jsb = new JSONObject().fromObject(jsonStr);
			Map<String, Class> classMap = new HashMap<String, Class>();
			classMap.put("list", valueType);
			classMap.put("navigatepageNums", Integer.class);
			PageInfo<T> pageInfo = (PageInfo<T>) JSONObject.toBean(jsb,
					PageInfo.class, classMap);
			return pageInfo;
		} catch (Exception e) {

			return null;
		}

	}
	
	public static Integer httpInsertOrUpdate(String url,Map<String, String> map)
	{
		
		String jsonStr="0";
		try {
			jsonStr = HttpClientUtils.mPost(url, map);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Integer.valueOf(jsonStr);
	}
	  public static Map<String, String> objectToMap(Object obj)  {      
	        if(obj == null)    
	            return null;        
	    
	        Map<String, String> map = new HashMap<String, String>();     
	    
	        BeanInfo beanInfo=null;
			try {
				beanInfo = Introspector.getBeanInfo(obj.getClass());
				PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();      
		        for (PropertyDescriptor property : propertyDescriptors) {      
		            String key = property.getName();      
		            if (key.compareToIgnoreCase("class") == 0) {     
		                continue;    
		            }    
		            Method getter = property.getReadMethod();    
		            Object value = getter!=null ? getter.invoke(obj) : null;    
		            if(value==null){continue;}
		            map.put(key, String.valueOf(value));    
		        }      
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}      
	        return map;    
	    }  

	public static String createPageDiv(Integer start, Integer totalPage,String method) {

			Integer s=	start-2;
			Integer e=	start+2;
			
			if(totalPage-start<3)
			{
				s=totalPage-4;
				e=totalPage;
			}
			if(start<3)
			{
				s=1;
				e=5;
			}
			if(totalPage<6)
			{
				s=1;
				e=totalPage;
			}
			
			StringBuffer sbf = new StringBuffer();
			if(s==1){sbf.append("<li><a href=\"javascript:void(0);\" >&laquo;</a></li>");}else{sbf.append("<li><a href=\"javascript:void(0);\" onclick=\""+method+"("+(s-1)+")\">&laquo;</a></li>");}
	for(int i=s;i<e+1;i++)
	{
		if(i==start){sbf.append("<li><a href=\"javascript:void(0);\" onclick=\""+method+"("+i+")\" class=\"active\">"+i+"</a></li>");continue;}
		sbf.append("<li><a href=\"javascript:void(0);\" onclick=\""+method+"("+i+")\">"+i+"</a></li>");
	}
			if(e==totalPage){sbf.append("<li><a href=\"javascript:void(0);\">&raquo;</a></li>");}else{sbf.append("<li><a href=\"javascript:void(0);\" onclick=\""+method+"("+(e+1)+")\">&raquo;</a></li>");}
			return sbf.toString();

		}
}
