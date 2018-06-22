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
@Table(name = "CbhsMonthZyQtfyYs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsMonthZyQtfyYs implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键（机械成本）(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 主键（机械成本）(创建不填|修改必填)
	@Column(name = "projectOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|所属工程项目ID CbhsProject",required=false)
	private Integer projectOid= 0;// 必填|所属工程项目ID CbhsProject
	@Column(name = "deptOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|部门编号",required=false)
	private Integer deptOid= 0;// 必填|部门编号
	@Column(name = "deptName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|部门名称",required=false)
	private String deptName= "";// 必填|部门名称
	@Column(name = "monthStr", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|月份 yyyy-MM 便于展示",required=false)
	private String monthStr= "";// 必填|月份 yyyy-MM 便于展示
	@Column(name = "monthTimeStamp", nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "必填|月份 时间戳 用于后期数据统计",required=false)
	private Long monthTimeStamp= 0L;// 必填|月份 时间戳 用于后期数据统计
	@Column(name = "total",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|总金额 产生费用",required=false)
	private BigDecimal total= new BigDecimal(0);// 必填|总金额 产生费用
	@Column(name = "name", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|项目名称",required=false)
	private String name= "";// 必填|项目名称
	@Column(name = "remark", length = 2000, nullable = true, unique = false,columnDefinition="varchar(2000) default ''")
	@ApiModelProperty(value = "选填|产生原因",required=false)
	private String remark= "";// 选填|产生原因
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

	public String getRemark() { 

    	return this.remark;

	}

	public void setRemark(String remark) {
 
        this.remark = remark;

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


}