package com.server.interceptor;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.google.common.collect.Lists;
import com.server.common.CbhsTokenInfos;
import com.server.common.TokenUtils;
import com.server.pojo.bean.CbhsLog;
import com.server.runner.QuartzService;

public class LogInterceptor implements HandlerInterceptor {

	private final static String LOG_NAME = "LOG_NAME";
	private final static String LOG_TIME = "LOG_TIME";
	public final static String LOG_BODY = "LOG_BODY";
	private final List<String> requests = Lists.newArrayList();
	private Executor executor = Executors.newFixedThreadPool(50);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		if (request.getMethod().toUpperCase().trim().equals("POST")) {
			CbhsLog log = new CbhsLog();
			log.setUserOid(getUserOid(request));
			log.setIp(getIpAddress(request));
			log.setUrl(request.getRequestURI());
			log.setMethod(request.getMethod());
			log.setParamQuery(JSON.toJSONString(request.getParameterMap(), SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteMapNullValue));
			String body = (String) request.getAttribute(LOG_BODY);
			log.setParamBody(body);
			long logTime = System.currentTimeMillis();
			log.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(logTime)));
			request.setAttribute(LOG_NAME, log);
			request.setAttribute(LOG_TIME, logTime);
			synchronized (this) {
				String token = TokenUtils.getTokenByHttpServletRequest(request);
				String key = log.getUrl() + "@" + token + log.getParamQuery();
				if (requests.contains(key)) {
					return false;
				} else {
					requests.add(key);
					return true;
				}
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		// TODO Auto-generated method stub
		if (request.getMethod().toUpperCase().trim().equals("POST")) {
			CbhsLog log = (CbhsLog) request.getAttribute(LOG_NAME);
			log.setTimeUse(System.currentTimeMillis() - (Long) request.getAttribute(LOG_TIME));
			QuartzService.quene.add(log);
			synchronized (this) {
				String token = TokenUtils.getTokenByHttpServletRequest(request);
				String key = log.getUrl() + "@" + token + log.getParamQuery();
				if (requests.contains(key)) {
					requests.remove(key);
				}
			}
		}
	}

	public void setTimeoutRemove(Object key, long time) {
		executor.execute(new Runnable() {
			@SuppressWarnings("static-access")
			@Override
			public void run() {
				try {
					Thread.currentThread().sleep(time);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				requests.remove(key);
			}
		});
	}

	public String getIpAddress(HttpServletRequest request) {
		try {
			String ipAddress = request.getHeader("x-forwarded-for");
			if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader("Proxy-Client-IP");
			}
			if (ipAddress == null || ipAddress.length() == 0 || "unknow".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getHeader("WL-Proxy-Client-IP");
			}
			if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
				ipAddress = request.getRemoteAddr();

				if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
					// 根据网卡获取本机配置的IP地址
					InetAddress inetAddress = null;
					try {
						inetAddress = InetAddress.getLocalHost();
					} catch (UnknownHostException e) {
						e.printStackTrace();
					}
					ipAddress = inetAddress.getHostAddress();
				}
			}
			// 对于通过多个代理的情况，第一个IP为客户端真实的IP地址，多个IP按照','分割
			if (null != ipAddress && ipAddress.length() > 15) {
				// "***.***.***.***".length() = 15
				if (ipAddress.indexOf(",") > 0) {
					ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
				}
			}
			return ipAddress;
		} catch (Exception e) {
			return "未知";
		}

	}

	public Integer getUserOid(HttpServletRequest request) {
		String token = TokenUtils.getTokenByHttpServletRequest(request);
		if (token != null) {
			try {
				CbhsTokenInfos info = TokenUtils.ObjectByToken(token);
				return info.getUserOid();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
}
