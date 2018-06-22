package com.server.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.server.api.static_.HttpConstants;
import com.server.api.static_.SimpleWebCommandOperationInfo;
import com.server.common.TokenUtils;
import com.server.exception.ExceptionResponse;
import com.server.exception.ServiceException;
import com.server.jpa.MyQueryFactory;
import com.server.manager.TokenManager;
import com.server.pojo.bean.CbhsAccount;
import com.server.pojo.bean.QCbhsAccount;
import com.server.runner.BeanTools;

/**
 * 权限拦截器
 * 
 * @ClassName: PermissionsInterceptor
 * @Description: TODO(校验是否登录 以及用户是否具有操作权限等等。。。)
 * @author 青明锋
 * @date 2017年12月18日 下午9:02:01
 *
 */
public class PermissionsInterceptor implements HandlerInterceptor {

	private String notAuthOpCode = "-1"; // 不需要权限拦截

	@Override
	public void afterCompletion(HttpServletRequest req, HttpServletResponse resp, Object obj, Exception arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("===========HandlerInterceptor1 afterCompletion");
	}

	@Override
	public void postHandle(HttpServletRequest req, HttpServletResponse resp, Object obj, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object obj) throws Exception {
		// TODO Auto-generated method stub
		// 判断是否需要认证权限
		try {
			if (isAuth(req)) {
				if (!checkToken(req)) {
					resp.setStatus(HttpStatus.BAD_REQUEST.value());
					String errorMsg = "鉴权失败!";
					ExceptionResponse exception = new ExceptionResponse(-2, errorMsg);
					resp.setContentType("application/json;charset=utf-8");
					resp.getWriter().write(JSON.toJSONString(exception));
					return false;
				}
			}
		} catch (Exception e) {
			throw new ServiceException(new ExceptionResponse(-2, "非法请求!"));
		}
		return true;
	}

	/**
	 * 校验请求是否需要认证权限 @Title: isAuth @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param req @param @return 设定文件 @return
	 * boolean 返回类型 @throws
	 */
	private boolean isAuth(HttpServletRequest req) {
		String uri = req.getRequestURI();
		if (uri.indexOf("/cbhs/") == -1) {
			uri = "/cbhs" + uri;
		}
		if (HttpConstants.webCommands.containsKey(uri)) {
			SimpleWebCommandOperationInfo webcommand = HttpConstants.webCommands.get(uri);
			if (notAuthOpCode.equals(webcommand.getOpCode())) {
				return false; // 直接放行
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	/**
	 * 获取token信息 @Title: getTokenInfos @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param req @param @return 设定文件 @return
	 * YqtTokenInfos 返回类型 @throws
	 */
	private boolean checkToken(HttpServletRequest req) {
		String token = TokenUtils.getTokenByHttpServletRequest(req);
		if (token != null) {
			boolean flag = TokenManager.getInstance().checkToken(token);
			if (flag) {
				return true;
			} else {
				MyQueryFactory queryFtory = (MyQueryFactory) BeanTools.getBean(MyQueryFactory.class);
				CbhsAccount account = queryFtory.findOne(QCbhsAccount.cbhsAccount, QCbhsAccount.cbhsAccount.token.eq(token).or(QCbhsAccount.cbhsAccount.webtoken.eq(token)));
				if (account != null) {
					TokenManager.getInstance().addToken(account.getAccountKey(), token);
					return true;
				} else {
					return false;
				}
			}
		} else {
			return false;
		}
	}

}
