package com.base.app.application.web.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Component("requestTimeInterceptor")
@Slf4j
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setAttribute("startTime", System.currentTimeMillis());
		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		String path = request.getRequestURI().substring(request.getContextPath().length());
		if(!path.contains("css/") && !path.contains("images/") && !path.contains("js/") && !path.contains("locale/") && !path.contains("locales/")) {
			long startTime = (long) request.getAttribute("startTime");
	 		log.info("URL to: '" + request.getRequestURL().toString() + "' in: '" + (System.currentTimeMillis() - startTime) + "'ms");
		}
	}

}