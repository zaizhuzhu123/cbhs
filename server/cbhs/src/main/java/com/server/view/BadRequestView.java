package com.server.view;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="BadRequestView",description="输入教研错误视图")
public class BadRequestView extends View{
	@ApiModelProperty(name="message",value="错误信息",example="错误信息",dataType="string")
	private String message;
	@ApiModelProperty(name="status",value="视图状态",example="400",dataType="int")
	private int status;
	public BadRequestView(String message) {
		this.status = HttpStatus.BAD_REQUEST.value();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
	public int getStatus() {
		return status;
	}
}
