package com.server.exception;

public class ExceptionResponse {
	private int errorCode;
	private String errorMessage;
	private String ext;

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public ExceptionResponse(int errorCode, String errorMessage) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public ExceptionResponse(int errorCode, String errorMessage, String ext) {
		super();
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.ext = ext;
	}

}
