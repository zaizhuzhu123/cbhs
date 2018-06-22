package com.server.view;

import java.util.Set;

import org.springframework.http.HttpStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="UnsupportMethmod",description="请求方法错误")
public class UnsupportMethmod extends View{
	@ApiModelProperty(name="message",value="错误信息",example="错误信息",dataType="string")
	private String message;
	@ApiModelProperty(name="status",value="视图状态",example="405",dataType="int")
	private int status;
	@ApiModelProperty(name="supportMethmods",value="支持的Methmod列表",dataType="array",allowableValues="POST")
	private Set<String> supportMethmods;
	public UnsupportMethmod(String message,Set<String> supportMethmods) {
		this.status = HttpStatus.METHOD_NOT_ALLOWED.value();
		this.message = message;
		this.supportMethmods = supportMethmods;
	}
	public String getMessage() {
		return message;
	}
	public int getStatus() {
		return status;
	}
	public Set<String> getSupportMethmods() {
		return supportMethmods;
	}
}
