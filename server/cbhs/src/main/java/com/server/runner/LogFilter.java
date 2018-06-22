package com.server.runner;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.server.interceptor.BodyReaderHttpServletRequestWrapper;
import com.server.interceptor.HttpHelper;
import com.server.interceptor.LogInterceptor;

@Component
public class LogFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		if (httpServletRequest.getMethod().toUpperCase().trim().equals("POST")) {
			ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(httpServletRequest);
			String body = HttpHelper.getBodyString(requestWrapper);
			requestWrapper.setAttribute(LogInterceptor.LOG_BODY, body);
			chain.doFilter(requestWrapper, response);
		} else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
