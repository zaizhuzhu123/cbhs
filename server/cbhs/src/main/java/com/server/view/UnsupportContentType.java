package com.server.view;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UnsupportContentType",description="请求ContentType不支持")
public class UnsupportContentType extends View{
	@ApiModelProperty(name="message",value="错误信息",example="错误信息",dataType="string")
	private String message;
	@ApiModelProperty(name="status",value="视图状态",example="406",dataType="int")
	private int status;
	@ApiModelProperty(name="supportContentTypes",value="支持的ContentType列表",dataType="array",allowableValues=MediaType.APPLICATION_JSON_UTF8_VALUE)
	private Set<String> supportContentTypes;
	public UnsupportContentType(String message,Set<String> supportContentTypes) {
		this.status = HttpStatus.METHOD_NOT_ALLOWED.value();
		this.message = message;
		this.supportContentTypes = supportContentTypes;
	}
	public String getMessage() {
		return message;
	}
	public int getStatus() {
		return status;
	}
	public Set<String> getSupportContentTypes() {
		return supportContentTypes;
	}
	
}
