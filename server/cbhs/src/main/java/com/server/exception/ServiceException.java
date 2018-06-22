package com.server.exception;

/**
 * 错误提示
 * 
 * @author laiiihan
 * 
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private ExceptionResponse response;

	public ServiceException(ExceptionResponse response) {
		super(response.getErrorMessage());
		this.response = response;
	}

	public ExceptionResponse getResponse() {
		return response;
	}

	public void setResponse(ExceptionResponse response) {
		this.response = response;
	}
	
}
