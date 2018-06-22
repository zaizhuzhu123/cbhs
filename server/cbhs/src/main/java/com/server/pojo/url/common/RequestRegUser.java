package com.server.pojo.url.common;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestRegUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "账号(蹇呭～)")
	@NotBlank(message="帐号不能为空")
	@Pattern(regexp="^[a-zA-Z0-9_-]{4,12}$",message="帐号必须为4-12位")
	private String account= "";
	@ApiModelProperty(value = "密码(蹇呭～)")
	@NotBlank(message="密码不能为空")
	@Size(min=6, max=12,message="密码长度必须为6-12位之间")
	private String password= "";
	@ApiModelProperty(value = "名称(蹇呭～)")
	@NotBlank(message="姓名不能为空")
	@Size(min=1, max=5,message="姓名长度必须为1-5位之间")
	private String name= "";
	@ApiModelProperty(value = "手机号码")
	private String phoneNumber= "";
	@ApiModelProperty(value = "性别")
	private Boolean sex;
	@ApiModelProperty(value = "自定义菜单")
	private String menuids= "";
	@ApiModelProperty(value = "角色")
	private String roleids= "";
	@ApiModelProperty(value = "角色名称")
	private String roleNames= "";
	@ApiModelProperty(value = "部门")
	private Integer deptOid= 0;
	@ApiModelProperty(value = "部门名称")
	private String deptName= "";
	@ApiModelProperty(value = "是否可操作所有部门")
	private Boolean isAllDept;

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

	public String getMenuids() { 

    	return this.menuids;

	}

	public void setMenuids(String menuids) {
 
        this.menuids = menuids;

	}

	public String getRoleids() { 

    	return this.roleids;

	}

	public void setRoleids(String roleids) {
 
        this.roleids = roleids;

	}

	public String getRoleNames() { 

    	return this.roleNames;

	}

	public void setRoleNames(String roleNames) {
 
        this.roleNames = roleNames;

	}

	public Integer getDeptOid() { 

    	return this.deptOid;

	}

	public void setDeptOid(Integer deptOid) {
 
        this.deptOid = deptOid;

	}

	public String getDeptName() { 

    	return this.deptName;

	}

	public void setDeptName(String deptName) {
 
        this.deptName = deptName;

	}

	public Boolean getIsAllDept() { 

    	return this.isAllDept;

	}

	public void setIsAllDept(Boolean isAllDept) {
 
        this.isAllDept = isAllDept;

	}


}