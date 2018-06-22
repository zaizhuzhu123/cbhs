package com.server.exception.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.server.exception.command.AbstractCommand;
import com.server.view.InternalErrorView;

/**
 * 未知异常拦截
 * @author laiiihan
 *
 */
public class UnknowCommand extends AbstractCommand{

	//private static final String UNKNOW_EXCEPTION = "系统出现未知异常，请联系管理员。";

	@Override
	public Object onException(Exception exception,HttpServletResponse response) throws IOException {
		System.out.println(exception.getMessage());
		return new InternalErrorView(exception.getMessage(),100000);
	}

}
