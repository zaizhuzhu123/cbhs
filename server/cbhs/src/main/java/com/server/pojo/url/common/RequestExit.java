package com.server.pojo.url.common;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestExit implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "账号标识(蹇呭～)")
	@NotBlank(message="帐号标识不能为空")
	private String accountKey= "";
	@ApiModelProperty(value = "token(蹇呭～)")
	@NotBlank(message="token不能为空")
	private String token= "";
	@ApiModelProperty(value = "登录平台(app|web 默认为app)")
	private String platform= "";

	public String getAccountKey() { 

    	return this.accountKey;

	}

	public void setAccountKey(String accountKey) {
 
        this.accountKey = accountKey;

	}

	public String getToken() { 

    	return this.token;

	}

	public void setToken(String token) {
 
        this.token = token;

	}

	public String getPlatform() { 

    	return this.platform;

	}

	public void setPlatform(String platform) {
 
        this.platform = platform;

	}


}