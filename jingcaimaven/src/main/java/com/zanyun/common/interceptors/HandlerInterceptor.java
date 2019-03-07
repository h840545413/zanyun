package com.zanyun.common.interceptors;





import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;



public class HandlerInterceptor extends HandlerInterceptorAdapter {

	/**
	 * 免登入 免检查地址
	 */


	// preHandle()方法在业务处理器处理请求之前被调用
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
			return true;
	}
	}

