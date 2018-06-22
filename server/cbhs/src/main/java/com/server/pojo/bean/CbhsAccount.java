package com.server.pojo.bean;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.persistence.*;
import java.math.BigDecimal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.DynamicInsert;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiModel;

@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "CbhsAccount")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel(value="账号对象",description="账号对象")
public class CbhsAccount implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@ApiModelProperty(value = "帐号主键",required=false)
	private String accountKey= "";// 帐号主键
	@Column(name = "account", length = 20, nullable = true ,unique = true,columnDefinition="varchar(20) default ''")
	@ApiModelProperty(value = "登录帐号",hidden=true,required=false)
	private String account= "";// 登录帐号
	@Column(name = "password", length = 32, nullable = true, unique = false,columnDefinition="varchar(32) default ''")
	@ApiModelProperty(value = "密码",hidden=true,required=false)
	private String password= "";// 密码
	@Column(name = "ryToken", length = 200, nullable = true, unique = false,columnDefinition="varchar(200) default ''")
	@ApiModelProperty(value = "融云Token",hidden=true,required=false)
	private String ryToken= "";// 融云Token
	@Column(name = "token", length = 1000, nullable = true, unique = false,columnDefinition="varchar(1000) default ''")
	@ApiModelProperty(value = "app登录令牌",hidden=true,required=false)
	private String token= "";// app登录令牌
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_oid", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT) )
	@Fetch(FetchMode.JOIN)
	@ApiModelProperty(value = "用户",required=false)
	private CbhsUser  user;// 用户
	@Column(name = "webtoken", length = 1000, nullable = true, unique = false,columnDefinition="varchar(1000) default ''")
	@ApiModelProperty(value = "web登录令牌",hidden=true,required=false)
	private String webtoken= "";// web登录令牌

	public String getAccountKey() { 

    	return this.accountKey;

	}

	public void setAccountKey(String accountKey) {
 
        this.accountKey = accountKey;

	}

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

	public String getRyToken() { 

    	return this.ryToken;

	}

	public void setRyToken(String ryToken) {
 
        this.ryToken = ryToken;

	}

	public String getToken() { 

    	return this.token;

	}

	public void setToken(String token) {
 
        this.token = token;

	}

	public CbhsUser getUser() { 

    	return this.user;

	}

	public void setUser(CbhsUser user) {
 
        this.user = user;

	}

	public String getWebtoken() { 

    	return this.webtoken;

	}

	public void setWebtoken(String webtoken) {
 
        this.webtoken = webtoken;

	}


}