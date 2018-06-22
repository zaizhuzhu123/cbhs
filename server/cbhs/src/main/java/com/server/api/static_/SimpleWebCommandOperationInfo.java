package com.server.api.static_;

public class SimpleWebCommandOperationInfo {
	private String url;

	private String method;

	private int msgCode;

	private String msgResponse;

	private String responseDepict;

	private String msgReaquest;

	private String reaquestDepict;

	private String workClass;

	private String opCode;

	private String restClass;
	private boolean transation;

	public String getResponseDepict() {
		return responseDepict;
	}

	public void setResponseDepict(String responseDepict) {
		this.responseDepict = responseDepict;
	}

	public String getReaquestDepict() {
		return reaquestDepict;
	}

	public void setReaquestDepict(String reaquestDepict) {
		this.reaquestDepict = reaquestDepict;
	}

	public String getMsgReaquest() {
		return msgReaquest;
	}

	public void setMsgReaquest(String msgReaquest) {
		this.msgReaquest = msgReaquest;
	}

	public String getWorkClass() {
		return workClass;
	}

	public void setWorkClass(String workClass) {
		this.workClass = workClass;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public int getMsgCode() {
		return msgCode;
	}

	public void setMsgCode(int msgCode) {
		this.msgCode = msgCode;
	}

	public String getMsgResponse() {
		return msgResponse;
	}

	public void setMsgResponse(String msgResponse) {
		this.msgResponse = msgResponse;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public boolean isTransation() {
		return transation;
	}

	public void setTransation(boolean transation) {
		this.transation = transation;
	}

	public String getRestClass() {
		return restClass;
	}

	public void setRestClass(String restClass) {
		this.restClass = restClass;
	}

}
