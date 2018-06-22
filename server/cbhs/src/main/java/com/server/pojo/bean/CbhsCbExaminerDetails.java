package com.server.pojo.bean;

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
@Table(name = "CbhsCbExaminerDetails")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsCbExaminerDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键(成本审查详情)")
	private Integer oid= 0;// 主键(成本审查详情)
	@Column(name = "examOid",updatable = false, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核任务ID")
	private Integer examOid= 0;// 审核任务ID
	@Column(name = "type",updatable = false, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核类型 1间接成本 2管理费用 3零星用工 4机械成本 5自营其他费用 6自营材料成本 7分包临建项目")
	private Integer type= 0;// 审核类型 1间接成本 2管理费用 3零星用工 4机械成本 5自营其他费用 6自营材料成本 7分包临建项目
	@Column(name = "shUName", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "审核人姓名")
	private String shUName= "";// 审核人姓名
	@Column(name = "shStatus",updatable = false, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核人 审核状态  1 批准 2 不批准")
	private Integer shStatus= 0;// 审核人 审核状态  1 批准 2 不批准
	@Column(name = "shRemark", length = 200,updatable = false, nullable = true, unique = false,columnDefinition="varchar(200) default ''")
	@ApiModelProperty(value = "审核人 注明")
	private String shRemark= "";// 审核人 注明
	@Column(name = "opUserOid",updatable = false, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "操作人ID")
	private Integer opUserOid= 0;// 操作人ID
	@Column(name = "opUserName", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "操作人姓名")
	private String opUserName= "";// 操作人姓名
	@Column(name = "opTimeStr", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "操作时间")
	private String opTimeStr= "";// 操作时间
	@Column(name = "opTime",updatable = false, nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "操作时间")
	private Long opTime= 0L;// 操作时间

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getExamOid() { 

    	return this.examOid;

	}

	public void setExamOid(Integer examOid) {
 
        this.examOid = examOid;

	}

	public Integer getType() { 

    	return this.type;

	}

	public void setType(Integer type) {
 
        this.type = type;

	}

	public String getShUName() { 

    	return this.shUName;

	}

	public void setShUName(String shUName) {
 
        this.shUName = shUName;

	}

	public Integer getShStatus() { 

    	return this.shStatus;

	}

	public void setShStatus(Integer shStatus) {
 
        this.shStatus = shStatus;

	}

	public String getShRemark() { 

    	return this.shRemark;

	}

	public void setShRemark(String shRemark) {
 
        this.shRemark = shRemark;

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