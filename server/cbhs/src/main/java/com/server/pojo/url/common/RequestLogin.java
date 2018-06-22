package com.server.pojo.url.common;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "账号(蹇呭～)")
	@NotBlank(message="帐号不能为空")
	@Pattern(regexp="^[a-zA-Z0-9_-]{4,12}$",message="帐号必须为4-12位")
	private String account= "";
	@ApiModelProperty(value = "密码(蹇呭～)")
	@NotBlank(message="密码不能为空")
	@Size(min=6, max=12,message="密码长度必须为6-12位之间")
	private String password= "";
	@ApiModelProperty(value = "登录方式(pwd 密码登录|phone 手机号码登录)(蹇呭～)")
	@NotBlank(message="登录类型不能为空")
	private String loginType= "";
	@ApiModelProperty(value = "登录平台(app|web 默认为app)")
	private String platform= "";

	public String getAccount() { 

    	return this.account;

	}

	public void setAccount(String account) {
 
        this.account = account;

	}

	public String getPassword() { 

    	return this.password;

	}

	public void setPassword(String password) {
 
        this.password = password;

	}

	public String getLoginType() { 

    	return this.loginType;

	}

	public void setLoginType(String loginType) {
 
        this.loginType = loginType;

	}

	public String getPlatform() { 

    	return this.platform;

	}

	public void setPlatform(String platform) {
 
        this.platform = platform;

	}


}