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
public class uiDeptGrandTotalTj implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "cbTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "总支出",required=false)
	private BigDecimal cbTotal= new BigDecimal(0);// 总支出
	@Column(name = "deptOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "部门ID",required=false)
	private Integer deptOid= 0;// 部门ID
	@Column(name = "deptName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "部门名称",required=false)
	private String deptName= "";// 部门名称
	@Column(name = "personCount", nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "人数",required=false)
	private Long personCount= 0L;// 人数

	public BigDecimal getCbTotal() { 

    	return this.cbTotal;

	}

	public void setCbTotal(BigDecimal cbTotal) {
 
        this.cbTotal = cbTotal;

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

	public Long getPersonCount() { 

    	return this.personCount;

	}

	public void setPersonCount(Long personCount) {
 
        this.personCount = personCount;

	}


}