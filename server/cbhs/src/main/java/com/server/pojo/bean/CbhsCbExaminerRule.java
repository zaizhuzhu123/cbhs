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
@Table(name = "CbhsCbExaminerRule")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsCbExaminerRule implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键(成本审核规则)",required=false)
	private Integer oid= 0;// 主键(成本审核规则)
	@Column(name = "projectOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "所属工程项目ID CbhsProject",required=false)
	private Integer projectOid= 0;// 所属工程项目ID CbhsProject
	@Column(name = "deptOid", length = 500, nullable = true, unique = false)
	@ApiModelProperty(value = "部门ID 数字",required=false)
	private int  deptOid;// 部门ID 数字
	@Column(name = "deptNames", length = 500, nullable = true, unique = false,columnDefinition="varchar(500) default ''")
	@ApiModelProperty(value = "部门名称",required=false)
	private String deptNames= "";// 部门名称
	@Column(name = "personOid1", length = 500, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核人1ID",required=false)
	private Integer personOid1= 0;// 审核人1ID
	@Column(name = "personName1", length = 500, nullable = true, unique = false,columnDefinition="varchar(500) default ''")
	@ApiModelProperty(value = "审核人1名称",required=false)
	private String personName1= "";// 审核人1名称
	@Column(name = "personOid2", length = 500, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核人2ID",required=false)
	private Integer personOid2= 0;// 审核人2ID
	@Column(name = "personName2", length = 500, nullable = true, unique = false,columnDefinition="varchar(500) default ''")
	@ApiModelProperty(value = "审核人2名称",required=false)
	private String personName2= "";// 审核人2名称
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

	public int getDeptOid() { 

    	return this.deptOid;

	}

	public void setDeptOid(int deptOid) {
 
        this.deptOid = deptOid;

	}

	public String getDeptNames() { 

    	return this.deptNames;

	}

	public void setDeptNames(String deptNames) {
 
        this.deptNames = deptNames;

	}

	public Integer getPersonOid1() { 

    	return this.personOid1;

	}

	public void setPersonOid1(Integer personOid1) {
 
        this.personOid1 = personOid1;

	}

	public String getPersonName1() { 

    	return this.personName1;

	}

	public void setPersonName1(String personName1) {
 
        this.personName1 = personName1;

	}

	public Integer getPersonOid2() { 

    	return this.personOid2;

	}

	public void setPersonOid2(Integer personOid2) {
 
        this.personOid2 = personOid2;

	}

	public String getPersonName2() { 

    	return this.personName2;

	}

	public void setPersonName2(String personName2) {
 
        this.personName2 = personName2;

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