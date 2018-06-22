package com.server.exception.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.MissingServletRequestParameterException;

import com.server.exception.command.AbstractCommand;
import com.server.view.BadRequestView;
/**
 * 参数缺失
 * @author laiiihan
 *
 */
public class MissingParameterCommand extends AbstractCommand{

	private static final String MISS_PARAMETER = "缺少参数{ %s }";

	@Override
	public Object onException(Exception exception,HttpServletResponse response) throws IOException {
		MissingServletRequestParameterException e = (MissingServletRequestParameterException) exception;
		return new BadRequestView(String.format(MISS_PARAMETER, e.getParameterName()));
	}

}
