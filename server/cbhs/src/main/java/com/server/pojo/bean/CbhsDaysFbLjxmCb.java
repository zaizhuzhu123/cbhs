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
@Table(name = "CbhsDaysFbLjxmCb")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel(value="临建项目每日成本对象",description="临建项目每日成本对象")
public class CbhsDaysFbLjxmCb implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键（临建项目）(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 主键（临建项目）(创建不填|修改必填)
	@Column(name = "projectOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|所属工程项目ID CbhsProject",required=false)
	private Integer projectOid= 0;// 必填|所属工程项目ID CbhsProject
	@Column(name = "ljxmYsOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|所属的临建项目",required=false)
	private Integer ljxmYsOid= 0;// 必填|所属的临建项目
	@Column(name = "ljxmYsName", length = 100, nullable = true, unique = false,columnDefinition="varchar(100) default ''")
	@ApiModelProperty(value = "必填|所属的临建项目名称",required=false)
	private String ljxmYsName= "";// 必填|所属的临建项目名称
	@Column(name = "fbCompanyOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|分包公司ID",required=false)
	private Integer fbCompanyOid= 0;// 必填|分包公司ID
	@Column(name = "fbCompanyName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|分包公司名称",required=false)
	private String fbCompanyName= "";// 必填|分包公司名称
	@Column(name = "deptOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|部门编号",required=false)
	private Integer deptOid= 0;// 必填|部门编号
	@Column(name = "deptName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|部门名称",required=false)
	private String deptName= "";// 必填|部门名称
	@Column(name = "monthStr", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|月份 yyyy-MM 便于展示",hidden=true,required=false)
	private String monthStr= "";// 必填|月份 yyyy-MM 便于展示
	@Column(name = "monthTimeStamp",updatable = false, nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "必填|月份 时间戳 用于后期数据统计",hidden=true,required=false)
	private Long monthTimeStamp= 0L;// 必填|月份 时间戳 用于后期数据统计
	@Column(name = "dateStr", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "日期 yyyy-MM-dd 便于展示",hidden=true,required=false)
	private String dateStr= "";// 日期 yyyy-MM-dd 便于展示
	@Column(name = "dateTimeStamp",updatable = false, nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "日期 每天00:00:00的时间戳 用于后期数据统计",required=false)
	private Long dateTimeStamp= 0L;// 日期 每天00:00:00的时间戳 用于后期数据统计
	@Column(name = "total",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|总金额",required=false)
	private BigDecimal total= new BigDecimal(0);// 必填|总金额
	@Column(name = "name", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|项目名称",required=false)
	private String name= "";// 必填|项目名称
	@Column(name = "unit", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|单位",required=false)
	private String unit= "";// 必填|单位
	@Column(name = "unitPrice",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|单价",required=false)
	private BigDecimal unitPrice= new BigDecimal(0);// 必填|单价
	@Column(name = "count",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|工程量",required=false)
	private BigDecimal count= new BigDecimal(0);// 必填|工程量
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
	@Column(name = "shStatus",updatable = false, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核状态 0 可用 1 审核中 2 审核不通过",hidden=true,required=false)
	private Integer shStatus= 0;// 审核状态 0 可用 1 审核中 2 审核不通过
	@Column(name = "shId", length = 100,updatable = false, nullable = true, unique = false,columnDefinition="varchar(100) default ''")
	@ApiModelProperty(value = "审核标识 表示这是一个需要审核的操作 同一个操作由多条记录组成 通过这个表示审核的是一个操作",hidden=true,required=false)
	private String shId= "";// 审核标识 表示这是一个需要审核的操作 同一个操作由多条记录组成 通过这个表示审核的是一个操作

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

	public Integer getLjxmYsOid() { 

    	return this.ljxmYsOid;

	}

	public void setLjxmYsOid(Integer ljxmYsOid) {
 
        this.ljxmYsOid = ljxmYsOid;

	}

	public String getLjxmYsName() { 

    	return this.ljxmYsName;

	}

	public void setLjxmYsName(String ljxmYsName) {
 
        this.ljxmYsName = ljxmYsName;

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

	public String getMonthStr() { 

    	return this.monthStr;

	}

	public void setMonthStr(String monthStr) {
 
        this.monthStr = monthStr;

	}

	public Long getMonthTimeStamp() { 

    	return this.monthTimeStamp;

	}

	public void setMonthTimeStamp(Long monthTimeStamp) {
 
        this.monthTimeStamp = monthTimeStamp;

	}

	public String getDateStr() { 

    	return this.dateStr;

	}

	public void setDateStr(String dateStr) {
 
        this.dateStr = dateStr;

	}

	public Long getDateTimeStamp() { 

    	return this.dateTimeStamp;

	}

	public void setDateTimeStamp(Long dateTimeStamp) {
 
        this.dateTimeStamp = dateTimeStamp;

	}

	public BigDecimal getTotal() { 

    	return this.total;

	}

	public void setTotal(BigDecimal total) {
 
        this.total = total;

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

	public BigDecimal getUnitPrice() { 

    	return this.unitPrice;

	}

	public void setUnitPrice(BigDecimal unitPrice) {
 
        this.unitPrice = unitPrice;

	}

	public BigDecimal getCount() { 

    	return this.count;

	}

	public void setCount(BigDecimal count) {
 
        this.count = count;

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

	public Integer getShStatus() { 

    	return this.shStatus;

	}

	public void setShStatus(Integer shStatus) {
 
        this.shStatus = shStatus;

	}

	public String getShId() { 

    	return this.shId;

	}

	public void setShId(String shId) {
 
        this.shId = shId;

	}


}