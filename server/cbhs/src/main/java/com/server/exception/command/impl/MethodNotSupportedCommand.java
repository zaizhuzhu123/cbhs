package com.server.exception.command.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestMethodNotSupportedException;

import com.server.exception.command.AbstractCommand;
import com.server.view.UnsupportMethmod;

public class MethodNotSupportedCommand extends AbstractCommand{

	@Override
	public Object onException(Exception exception, HttpServletResponse response) throws IOException {
		HttpRequestMethodNotSupportedException e = (HttpRequestMethodNotSupportedException) exception;
		Set<String> methmods = new HashSet<>(Arrays.asList(e.getSupportedMethods()));
		return new UnsupportMethmod("不支持: "+e.getMethod(),methmods);
	}

}
