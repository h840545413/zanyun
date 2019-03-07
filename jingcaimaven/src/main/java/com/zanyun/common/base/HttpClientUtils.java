package com.zanyun.common.base;



import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
@Component
public class HttpClientUtils {

	public static String mGet(String path, String key, String value)
			throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put(key, value);
		return mGet(path, params, "utf-8");
	}

	public static String mPost(String path, String key, String value)
			throws ClientProtocolException, IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put(key, value);
		return mPost(path, params, "utf-8");
	}

	public static String mGet(String path, Map<String, String> params)
			throws IOException {
		return mGet(path, params, "utf-8");
	}

	public static String mPost(String path, Map<String, String> params)
			throws ClientProtocolException, IOException {
		return mPost(path, params, "utf-8");
	}

	public static String mGet(String path, String key, String value,
			String encoding) throws IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put(key, value);
		return mGet(path, params, encoding);
	}

	public static String mPost(String path, String key, String value,
			String encoding) throws ClientProtocolException, IOException {
		Map<String, String> params = new HashMap<String, String>();
		params.put(key, value);
		return mPost(path, params, encoding);
	}

	public static String mGet(String path, Map<String, String> params, String encoding) throws IOException {

		StringBuilder url = new StringBuilder(path);
		if (params != null) {
			url.append("?");
			for (Map.Entry<String, String> entry : params.entrySet()) {
				url.append(entry.getKey()).append("=");
				if (encoding != null && !"".equals(encoding)) {
					url.append(URLEncoder.encode(entry.getValue(), encoding));
				} else {
					url.append(entry.getValue());
				}
				url.append("&");
			}
			url.deleteCharAt(url.length() - 1);
		}

		
		CloseableHttpClient httpclient = HttpClients.createDefault();
	

		try {
			HttpGet httpGet = new HttpGet(url.toString());
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				// System.out.println(response.getStatusLine());
				HttpEntity entity = response.getEntity();

				// do something useful with the response body
				String retJsonStr = EntityUtils.toString(entity);

				// and ensure it is fully consumed
				EntityUtils.consume(entity);

				return retJsonStr;
			} finally {
				response.close();
			}

		} finally {
			httpclient.close();
		}
	}
	public static String mGet(String path, Map<String, String> params, Map<String, String> headers,String encoding) throws IOException {

		StringBuilder url = new StringBuilder(path);
		if (params != null) {
			url.append("?");
			for (Map.Entry<String, String> entry : params.entrySet()) {
				url.append(entry.getKey()).append("=");
				if (encoding != null && !"".equals(encoding)) {
					url.append(URLEncoder.encode(entry.getValue(), encoding));
				} else {
					url.append(entry.getValue());
				}
				url.append("&");
			}
			url.deleteCharAt(url.length() - 1);
		}

		
		CloseableHttpClient httpclient = HttpClients.createDefault();
	

		try {
			HttpGet httpGet = new HttpGet(url.toString());
			for (Map.Entry<String, String> entry : headers.entrySet()) {
				httpGet.setHeader(entry.getKey(), entry.getValue());
			}
			//HttpMessage message=
			
			CloseableHttpResponse response = httpclient.execute(httpGet);
		
			try {
				// System.out.println(response.getStatusLine());
				HttpEntity entity = response.getEntity();

				// do something useful with the response body
				String retJsonStr = EntityUtils.toString(entity);

				// and ensure it is fully consumed
				EntityUtils.consume(entity);

				return retJsonStr;
			} finally {
				response.close();
			}

		} finally {
			httpclient.close();
		}
	}
	public static String mPost(String path, Map<String, String> params,
			String encoding) throws ClientProtocolException, IOException {

		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			HttpPost httpPost = new HttpPost(path);
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();

			if (params != null) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					nvps.add(new BasicNameValuePair(entry.getKey(), entry
							.getValue()));
				}
			}
			if (encoding != null && !"".equals(encoding)) {
				httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));
			} else {
				httpPost.setEntity(new UrlEncodedFormEntity(nvps));
			}
			CloseableHttpResponse response = httpclient.execute(httpPost);

			try {
				// System.out.println(response.getStatusLine());
				HttpEntity entity = response.getEntity();

				// do something useful with the response body
				String retJsonStr = EntityUtils.toString(entity);

				// and ensure it is fully consumed
				EntityUtils.consume(entity);

				return retJsonStr;
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}
	}
}
