package com.server.view;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UnAuthorized",description="鉴权失败")
public class UnAuthorized extends View{
	@ApiModelProperty(name="message",value="错误信息",example="错误信息",dataType="string")
	private String message;
	@ApiModelProperty(name="status",value="视图状态",example="401",dataType="int")
	private int status;
	public UnAuthorized(String message) {
		status = HttpStatus.UNAUTHORIZED.value();
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
	public int getStatus() {
		return status;
	}
}
