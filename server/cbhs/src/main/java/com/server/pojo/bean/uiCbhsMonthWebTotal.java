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
public class uiCbhsMonthWebTotal implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "monthStr", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "月份",required=false)
	private String monthStr= "";// 月份
	@Column(name = "deptOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "部门ID",required=false)
	private Integer deptOid= 0;// 部门ID
	@Column(name = "deptName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "部门名称",required=false)
	private String deptName= "";// 部门名称
	@Column(name = "jjcbTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "间接成本汇总",required=false)
	private BigDecimal jjcbTotal= new BigDecimal(0);// 间接成本汇总
	@Column(name = "fbgcTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包成本汇总",required=false)
	private BigDecimal fbgcTotal= new BigDecimal(0);// 分包成本汇总
	@Column(name = "fbcailiaoCbTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包材料汇总",required=false)
	private BigDecimal fbcailiaoCbTotal= new BigDecimal(0);// 分包材料汇总
	@Column(name = "fbljxmTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包临建项目汇总",required=false)
	private BigDecimal fbljxmTotal= new BigDecimal(0);// 分包临建项目汇总
	@Column(name = "zycailiaoCbTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "自营材料汇总",required=false)
	private BigDecimal zycailiaoCbTotal= new BigDecimal(0);// 自营材料汇总
	@Column(name = "zylxygTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "自营零星工程汇总",required=false)
	private BigDecimal zylxygTotal= new BigDecimal(0);// 自营零星工程汇总
	@Column(name = "zyjxcbTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "自营机械成本",required=false)
	private BigDecimal zyjxcbTotal= new BigDecimal(0);// 自营机械成本
	@Column(name = "qtfy",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "其他费用",required=false)
	private BigDecimal qtfy= new BigDecimal(0);// 其他费用
	@Column(name = "glfy",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "管理费用",required=false)
	private BigDecimal glfy= new BigDecimal(0);// 管理费用
	@Column(name = "deptYsTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "部门月预算总金额",required=false)
	private BigDecimal deptYsTotal= new BigDecimal(0);// 部门月预算总金额

	public String getMonthStr() { 

    	return this.monthStr;

	}

	public void setMonthStr(String monthStr) {
 
        this.monthStr = monthStr;

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

	public BigDecimal getJjcbTotal() { 

    	return this.jjcbTotal;

	}

	public void setJjcbTotal(BigDecimal jjcbTotal) {
 
        this.jjcbTotal = jjcbTotal;

	}

	public BigDecimal getFbgcTotal() { 

    	return this.fbgcTotal;

	}

	public void setFbgcTotal(BigDecimal fbgcTotal) {
 
        this.fbgcTotal = fbgcTotal;

	}

	public BigDecimal getFbcailiaoCbTotal() { 

    	return this.fbcailiaoCbTotal;

	}

	public void setFbcailiaoCbTotal(BigDecimal fbcailiaoCbTotal) {
 
        this.fbcailiaoCbTotal = fbcailiaoCbTotal;

	}

	public BigDecimal getFbljxmTotal() { 

    	return this.fbljxmTotal;

	}

	public void setFbljxmTotal(BigDecimal fbljxmTotal) {
 
        this.fbljxmTotal = fbljxmTotal;

	}

	public BigDecimal getZycailiaoCbTotal() { 

    	return this.zycailiaoCbTotal;

	}

	public void setZycailiaoCbTotal(BigDecimal zycailiaoCbTotal) {
 
        this.zycailiaoCbTotal = zycailiaoCbTotal;

	}

	public BigDecimal getZylxygTotal() { 

    	return this.zylxygTotal;

	}

	public void setZylxygTotal(BigDecimal zylxygTotal) {
 
        this.zylxygTotal = zylxygTotal;

	}

	public BigDecimal getZyjxcbTotal() { 

    	return this.zyjxcbTotal;

	}

	public void setZyjxcbTotal(BigDecimal zyjxcbTotal) {
 
        this.zyjxcbTotal = zyjxcbTotal;

	}

	public BigDecimal getQtfy() { 

    	return this.qtfy;

	}

	public void setQtfy(BigDecimal qtfy) {
 
        this.qtfy = qtfy;

	}

	public BigDecimal getGlfy() { 

    	return this.glfy;

	}

	public void setGlfy(BigDecimal glfy) {
 
        this.glfy = glfy;

	}

	public BigDecimal getDeptYsTotal() { 

    	return this.deptYsTotal;

	}

	public void setDeptYsTotal(BigDecimal deptYsTotal) {
 
        this.deptYsTotal = deptYsTotal;

	}


}