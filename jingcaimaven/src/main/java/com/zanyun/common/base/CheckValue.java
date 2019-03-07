package com.zanyun.common.base;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Component;


@Component
public class CheckValue {
	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	public String checkSign(Map requestMap,Enumeration enu,String sign) {

		//Map requestMap = request.getParameterMap();
		Map newMap = new HashMap();
		String resultStr = null;
		//String sign = req.getAjaxValue(request, "sign");
		String xyValue = "d9c3200560009e7c0104827fe7ed2fca";
		Set keSet = requestMap.entrySet();

		for (Iterator itr = keSet.iterator(); itr.hasNext();) {
			Map.Entry me = (Map.Entry) itr.next();
			Object ok = me.getKey();
			Object ov = me.getValue();
			String[] value = new String[1];
			if (ov instanceof String[]) {
				value = (String[]) ov;
			} else {
				value[0] = ov.toString();
			}

			for (int k = 0; k < value.length; k++) {
				newMap.put(ok, value[k]);

			}

		}

		List<String> list = new ArrayList<String>();

		StringBuffer sbf = new StringBuffer();
		// = request.getParameterNames();
		while (enu.hasMoreElements()) {
			String paraName = (String) enu.nextElement();
			list.add(paraName);
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			// System.out.println(list.get(i));
			if (list.get(i).equals("sign") || newMap.get(list.get(i)) == null) {
				continue;

			}
			sbf.append(list.get(i) + "=" + newMap.get(list.get(i)));

			if (i != list.size() - 1) {

				sbf.append("&");
			}
		}
		try {
			//MessageDigest md = MessageDigest.getInstance("MD5");
			
			resultStr = getMd5(sbf.toString() + xyValue);
			System.out.println(resultStr);
			if (!sign.equals(resultStr)) {
				return "";

			}

			return resultStr;

		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}
	public String getMd5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes("UTF-8"));
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			// 32位加密

			return buf.toString();
			// 16位的加密
			// return buf.toString().substring(8, 24);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

	}

}
