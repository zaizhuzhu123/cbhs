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
@Table(name = "CbhsUser")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel(value="用户对象",description="用户对象")
public class CbhsUser implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键",required=false)
	private Integer oid= 0;// 主键
	@Column(name = "name", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "名称",required=false)
	private String name= "";// 名称
	@Column(name = "phoneNumber", length = 11, nullable = true, unique = false,columnDefinition="varchar(11) default ''")
	@ApiModelProperty(value = "手机号码",required=false)
	private String phoneNumber= "";// 手机号码
	@Column(name = "sex", nullable = true, unique = false)
	@ApiModelProperty(value = "性别 true 男 false 女",required=false)
	private Boolean sex;// 性别 true 男 false 女
	@Column(name = "menuids", length = 5000, nullable = true, unique = false,columnDefinition="varchar(5000) default ''")
	@ApiModelProperty(value = "可操作的菜单集合(直接对账号分配的菜单权限)",required=false)
	private String menuids= "";// 可操作的菜单集合(直接对账号分配的菜单权限)
	@Column(name = "roleids", length = 2000, nullable = true, unique = false,columnDefinition="varchar(2000) default ''")
	@ApiModelProperty(value = "拥有的角色",required=false)
	private String roleids= "";// 拥有的角色
	@Column(name = "roleNames", length = 2000, nullable = true, unique = false,columnDefinition="varchar(2000) default ''")
	@ApiModelProperty(value = "拥有的角色名称",required=false)
	private String roleNames= "";// 拥有的角色名称
	@Column(name = "deptOid", length = 2000, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "所属部门ID",required=false)
	private Integer deptOid= 0;// 所属部门ID
	@Column(name = "deptName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "部门名称",required=false)
	private String deptName= "";// 部门名称
	@Column(name = "isAdmin",updatable = false, nullable = true, unique = false)
	@ApiModelProperty(value = "管理员账号 true 管理员 ",hidden=true,required=false)
	private Boolean isAdmin;// 管理员账号 true 管理员 
	@Column(name = "status",updatable = false, nullable = true, unique = false)
	@ApiModelProperty(value = "删除标识 true正常状态，未删除 false 已被删除",hidden=true,required=false)
	private Boolean status=true;// 删除标识 true正常状态，未删除 false 已被删除
	@Column(name = "avatarOid",updatable = false, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "头像对应的资源ID",required=false)
	private Integer avatarOid= 0;// 头像对应的资源ID
	@Column(name = "avatar", length = 500,updatable = false, nullable = true, unique = false,columnDefinition="varchar(500) default ''")
	@ApiModelProperty(value = "头像URL",required=false)
	private String avatar= "";// 头像URL
	@Column(name = "isAllDept", nullable = true, unique = false)
	@ApiModelProperty(value = "是否可查看所有部门信息",required=false)
	private Boolean isAllDept;// 是否可查看所有部门信息

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

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

	public Boolean getIsAdmin() { 

    	return this.isAdmin;

	}

	public void setIsAdmin(Boolean isAdmin) {
 
        this.isAdmin = isAdmin;

	}

	public Boolean getStatus() { 

    	return this.status;

	}

	public void setStatus(Boolean status) {
 
        this.status = status;

	}

	public Integer getAvatarOid() { 

    	return this.avatarOid;

	}

	public void setAvatarOid(Integer avatarOid) {
 
        this.avatarOid = avatarOid;

	}

	public String getAvatar() { 

    	return this.avatar;

	}

	public void setAvatar(String avatar) {
 
        this.avatar = avatar;

	}

	public Boolean getIsAllDept() { 

    	return this.isAllDept;

	}

	public void setIsAllDept(Boolean isAllDept) {
 
        this.isAllDept = isAllDept;

	}


}