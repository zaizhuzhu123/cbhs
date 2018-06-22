package com.server.view;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="InternalErrorView",description="内部错误视图")
public class InternalErrorView extends View{
	@ApiModelProperty(name="message",value="错误信息",example="错误信息",dataType="string")
	private String message;
	@ApiModelProperty(name="status",value="视图状态",example="500",dataType="int")
	private int status;
	@ApiModelProperty(name="errorCode",value="错误状态",example="100000",dataType="int")
	private long errorCode;
	public InternalErrorView(String message,long errorCode) {
		status = HttpStatus.INTERNAL_SERVER_ERROR.value();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
	public int getStatus() {
		return status;
	}
	public long getErrorCode() {
		return errorCode;
	}
}
