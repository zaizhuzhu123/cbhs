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

@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "CbhsHt")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsHt implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键ID",required=false)
	private Integer oid= 0;// 主键ID
	@Column(name = "htId", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "合同编号",required=false)
	private String htId= "";// 合同编号
	@Column(name = "htName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "合同名称",required=false)
	private String htName= "";// 合同名称
	@Column(name = "fbCompanyOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "分包商ID",required=false)
	private Integer fbCompanyOid= 0;// 分包商ID
	@Column(name = "fbCompanyName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "分包商名称",required=false)
	private String fbCompanyName= "";// 分包商名称
	@Column(name = "status",updatable = false, nullable = true, unique = false)
	@ApiModelProperty(value = "删除标识 true正常状态，未删除 false 已被删除",hidden=true,required=false)
	private Boolean status=true;// 删除标识 true正常状态，未删除 false 已被删除

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public String getHtId() { 

    	return this.htId;

	}

	public void setHtId(String htId) {
 
        this.htId = htId;

	}

	public String getHtName() { 

    	return this.htName;

	}

	public void setHtName(String htName) {
 
        this.htName = htName;

	}

	public Integer getFbCompanyOid() { 

    	return this.fbCompanyOid;

	}

	public void setFbCompanyOid(Integer fbCompanyOid) {
 
        this.fbCompanyOid = fbCompanyOid;

	}

	public String getFbCompanyName() { 

    	return this.fbCompanyName;

	}

	public void setFbCompanyName(String fbCompanyName) {
 
        this.fbCompanyName = fbCompanyName;

	}

	public Boolean getStatus() { 

    	return this.status;

	}

	public void setStatus(Boolean status) {
 
        this.status = status;

	}


}