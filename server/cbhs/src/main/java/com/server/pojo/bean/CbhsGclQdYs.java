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
@Table(name = "CbhsGclQdYs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsGclQdYs implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "全局工程量清单主键ID(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 全局工程量清单主键ID(创建不填|修改必填)
	@Column(name = "projectOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|所属工程项目ID CbhsProject",required=true)
	private Integer projectOid= 0;// 必填|所属工程项目ID CbhsProject
	@Column(name = "isGlobal", nullable = true, unique = false)
	@ApiModelProperty(value = "全局预算项目",hidden=true,required=false)
	private Boolean isGlobal;// 全局预算项目
	@Column(name = "deptOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|部门编号",required=true)
	private Integer deptOid= 0;// 必填|部门编号
	@Column(name = "deptName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|部门名称",required=true)
	private String deptName= "";// 必填|部门名称
	@Column(name = "month", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|月份",required=true)
	private String month= "";// 必填|月份
	@Column(name = "fbcompanyOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|分包公司编号 分包公司项目",required=true)
	private Integer fbcompanyOid= 0;// 必填|分包公司编号 分包公司项目
	@Column(name = "nodeId", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|项目编号",required=true)
	private String nodeId= "";// 必填|项目编号
	@Column(name = "name", length = 100, nullable = true, unique = false,columnDefinition="varchar(100) default ''")
	@ApiModelProperty(value = "必填|项目名称",required=true)
	private String name= "";// 必填|项目名称
	@Column(name = "unit", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "选填|单位",required=false)
	private String unit= "";// 选填|单位
	@Column(name = "count",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "选填|合同工程量",required=false)
	private BigDecimal count= new BigDecimal(0);// 选填|合同工程量
	@Column(name = "unitPrice",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "选填|单价",required=false)
	private BigDecimal unitPrice= new BigDecimal(0);// 选填|单价
	@Column(name = "totaPrice",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "选填|总金额",required=false)
	private BigDecimal totaPrice= new BigDecimal(0);// 选填|总金额
	@Column(name = "pNodeId", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "选填|父节点编号",required=false)
	private String pNodeId= "";// 选填|父节点编号
	@Column(name = "opUserOid",updatable = false, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "操作人ID",hidden=true,required=false)
	private Integer opUserOid= 0;// 操作人ID
	@Column(name = "opUserName", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "操作人姓名",hidden=true,required=false)
	private String opUserName= "";// 操作人姓名
	@Column(name = "opTimeStr", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "操作时间",hidden=true,required=false)
	private String opTimeStr= "";// 操作时间
	@Column(name = "opTime",updatable = false, nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "操作时间",hidden=true,required=false)
	private Long opTime= 0L;// 操作时间
	@Column(name = "completeCount",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "累计完成工程量",required=false)
	private BigDecimal completeCount= new BigDecimal(0);// 累计完成工程量

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getProjectOid() { 

    	return this.projectOid;

	}

	public void setProjectOid(Integer projectOid) {
 
        this.projectOid = projectOid;

	}

	public Boolean getIsGlobal() { 

    	return this.isGlobal;

	}

	public void setIsGlobal(Boolean isGlobal) {
 
        this.isGlobal = isGlobal;

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

	public String getMonth() { 

    	return this.month;

	}

	public void setMonth(String month) {
 
        this.month = month;

	}

	public Integer getFbcompanyOid() { 

    	return this.fbcompanyOid;

	}

	public void setFbcompanyOid(Integer fbcompanyOid) {
 
        this.fbcompanyOid = fbcompanyOid;

	}

	public String getNodeId() { 

    	return this.nodeId;

	}

	public void setNodeId(String nodeId) {
 
        this.nodeId = nodeId;

	}

	public String getName() { 

    	return this.name;

	}

	public void setName(String name) {
 
        this.name = name;

	}

	public String getUnit() { 

    	return this.unit;

	}

	public void setUnit(String unit) {
 
        this.unit = unit;

	}

	public BigDecimal getCount() { 

    	return this.count;

	}

	public void setCount(BigDecimal count) {
 
        this.count = count;

	}

	public BigDecimal getUnitPrice() { 

    	return this.unitPrice;

	}

	public void setUnitPrice(BigDecimal unitPrice) {
 
        this.unitPrice = unitPrice;

	}

	public BigDecimal getTotaPrice() { 

    	return this.totaPrice;

	}

	public void setTotaPrice(BigDecimal totaPrice) {
 
        this.totaPrice = totaPrice;

	}

	public String getPNodeId() { 

    	return this.pNodeId;

	}

	public void setPNodeId(String pNodeId) {
 
        this.pNodeId = pNodeId;

	}

	public Integer getOpUserOid() { 

    	return this.opUserOid;

	}

	public void setOpUserOid(Integer opUserOid) {
 
        this.opUserOid = opUserOid;

	}

	public String getOpUserName() { 

    	return this.opUserName;

	}

	public void setOpUserName(String opUserName) {
 
        this.opUserName = opUserName;

	}

	public String getOpTimeStr() { 

    	return this.opTimeStr;

	}

	public void setOpTimeStr(String opTimeStr) {
 
        this.opTimeStr = opTimeStr;

	}

	public Long getOpTime() { 

    	return this.opTime;

	}

	public void setOpTime(Long opTime) {
 
        this.opTime = opTime;

	}

	public BigDecimal getCompleteCount() { 

    	return this.completeCount;

	}

	public void setCompleteCount(BigDecimal completeCount) {
 
        this.completeCount = completeCount;

	}


}