package com.server.exception.command.impl;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotSupportedException;

import com.server.exception.command.AbstractCommand;
import com.server.view.UnsupportContentType;
/**
 * Content-Type不正确
 * @author laiiihan
 *
 */
public class MediaTypeNotSupportedCommand extends AbstractCommand{

	private static final String SUPPORT_CONTENT_TYPE = "Content-Type 不支持: ";

	@Override
	public Object onException(Exception exception,HttpServletResponse response) throws IOException {
		HttpMediaTypeNotSupportedException e= (HttpMediaTypeNotSupportedException) exception;
		Set<String> values = new HashSet<>();
		List<MediaType> mediaTypes = e.getSupportedMediaTypes();
		for (MediaType mediaType : mediaTypes) {
			values.add(mediaType.toString());
		}
		return new UnsupportContentType(SUPPORT_CONTENT_TYPE+e.getContentType().toString(),values);
	}

}
