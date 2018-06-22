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
@Table(name = "CbhsMachinery")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsMachinery implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "机械设备主键ID(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 机械设备主键ID(创建不填|修改必填)
	@Column(name = "machineryTypeName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|种类名称",required=false)
	private String machineryTypeName= "";// 必填|种类名称
	@Column(name = "machineryTypeOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|种类ID",required=false)
	private Integer machineryTypeOid= 0;// 必填|种类ID
	@Column(name = "name", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|机械设备名称",required=false)
	private String name= "";// 必填|机械设备名称
	@Column(name = "status",updatable = false, nullable = true, unique = false)
	@ApiModelProperty(value = "删除标识 true正常状态，未删除 false 已被删除",hidden=true,required=false)
	private Boolean status=true;// 删除标识 true正常状态，未删除 false 已被删除
	@Column(name = "style", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|设备规格型号",required=false)
	private String style= "";// 必填|设备规格型号
	@Column(name = "selfOrLease", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|设备归属 1自有 2租赁",required=false)
	private Integer selfOrLease= 0;// 必填|设备归属 1自有 2租赁
	@Column(name = "p_zjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|折旧费",required=false)
	private BigDecimal p_zjf= new BigDecimal(0);// 必填|折旧费
	@Column(name = "p_zpf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|租赁费",required=false)
	private BigDecimal p_zpf= new BigDecimal(0);// 必填|租赁费
	@Column(name = "used", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|使用状态 1使用中 2未使用",required=false)
	private Integer used= 0;// 必填|使用状态 1使用中 2未使用

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public String getMachineryTypeName() { 

    	return this.machineryTypeName;

	}

	public void setMachineryTypeName(String machineryTypeName) {
 
        this.machineryTypeName = machineryTypeName;

	}

	public Integer getMachineryTypeOid() { 

    	return this.machineryTypeOid;

	}

	public void setMachineryTypeOid(Integer machineryTypeOid) {
 
        this.machineryTypeOid = machineryTypeOid;

	}

	public String getName() { 

    	return this.name;

	}

	public void setName(String name) {
 
        this.name = name;

	}

	public Boolean getStatus() { 

    	return this.status;

	}

	public void setStatus(Boolean status) {
 
        this.status = status;

	}

	public String getStyle() { 

    	return this.style;

	}

	public void setStyle(String style) {
 
        this.style = style;

	}

	public Integer getSelfOrLease() { 

    	return this.selfOrLease;

	}

	public void setSelfOrLease(Integer selfOrLease) {
 
        this.selfOrLease = selfOrLease;

	}

	public BigDecimal getP_zjf() { 

    	return this.p_zjf;

	}

	public void setP_zjf(BigDecimal p_zjf) {
 
        this.p_zjf = p_zjf;

	}

	public BigDecimal getP_zpf() { 

    	return this.p_zpf;

	}

	public void setP_zpf(BigDecimal p_zpf) {
 
        this.p_zpf = p_zpf;

	}

	public Integer getUsed() { 

    	return this.used;

	}

	public void setUsed(Integer used) {
 
        this.used = used;

	}


}