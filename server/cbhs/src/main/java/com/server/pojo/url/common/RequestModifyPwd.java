package com.server.pojo.url.common;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestModifyPwd implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "账号标识(蹇呭～)")
	@NotBlank(message="帐号标识不能为空")
	private String accountKey= "";
	@ApiModelProperty(value = "旧密码(蹇呭～)")
	@NotBlank(message="旧密码不能为空")
	private String oldPwd= "";
	@ApiModelProperty(value = "新密码(蹇呭～)")
	@NotBlank(message="新密码不能为空")
	private String newPwd= "";

	public String getAccountKey() { 

    	return this.accountKey;

	}

	public void setAccountKey(String accountKey) {
 
        this.accountKey = accountKey;

	}

	public String getOldPwd() { 

    	return this.oldPwd;

	}

	public void setOldPwd(String oldPwd) {
 
        this.oldPwd = oldPwd;

	}

	public String getNewPwd() { 

    	return this.newPwd;

	}

	public void setNewPwd(String newPwd) {
 
        this.newPwd = newPwd;

	}


}