package com.server.pojo.url.common;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseLogin implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "账号主键")
	private String accountKey= "";
	@ApiModelProperty(value = "token")
	private String tokenId= "";
	@ApiModelProperty(value = "用户信息")
	private CbhsUser  user;
	@ApiModelProperty(value = "可操作的菜单")
	private String menuids= "";
	@ApiModelProperty(value = "可操作的部门")
	private List<CbhsDept> depts= new ArrayList<>();;
	@ApiModelProperty(value = "最新版本信息")
	private CbhsVersion  lastVersion;

	public String getAccountKey() { 

    	return this.accountKey;

	}

	public void setAccountKey(String accountKey) {
 
        this.accountKey = accountKey;

	}

	public String getTokenId() { 

    	return this.tokenId;

	}

	public void setTokenId(String tokenId) {
 
        this.tokenId = tokenId;

	}

	public CbhsUser getUser() { 

    	return this.user;

	}

	public void setUser(CbhsUser user) {
 
        this.user = user;

	}

	public String getMenuids() { 

    	return this.menuids;

	}

	public void setMenuids(String menuids) {
 
        this.menuids = menuids;

	}

	public List<CbhsDept> getDepts() {
    	return this.depts;
	}
	public void setDepts(List<CbhsDept> depts) {
    this.depts =depts;
	}

	public CbhsVersion getLastVersion() { 

    	return this.lastVersion;

	}

	public void setLastVersion(CbhsVersion lastVersion) {
 
        this.lastVersion = lastVersion;

	}


}