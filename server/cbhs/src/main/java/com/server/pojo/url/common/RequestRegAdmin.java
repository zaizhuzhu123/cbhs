package com.server.pojo.url.common;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestRegAdmin implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "账号(蹇呭～)")
	@NotBlank(message="帐号不能为空")
	@Pattern(regexp="^[a-zA-Z0-9_-]{4,12}$",message="帐号必须为4-12位")
	private String account= "";
	@ApiModelProperty(value = "密码(蹇呭～)")
	@NotBlank(message="密码不能为空")
	@Size(min=6, max=12,message="密码长度必须为6-12位之间")
	private String password= "";
	@ApiModelProperty(value = "名称")
	private String name= "";
	@ApiModelProperty(value = "手机号码")
	private String phoneNumber= "";
	@ApiModelProperty(value = "性别")
	private Boolean sex;

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

	public String getName() { 

    	return this.name;

	}

	public void setName(String name) {
 
        this.name = name;

	}

	public String getPhoneNumber() { 

    	return this.phoneNumber;

	}

	public void setPhoneNumber(String phoneNumber) {
 
        this.phoneNumber = phoneNumber;

	}

	public Boolean getSex() { 

    	return this.sex;

	}

	public void setSex(Boolean sex) {
 
        this.sex = sex;

	}


}