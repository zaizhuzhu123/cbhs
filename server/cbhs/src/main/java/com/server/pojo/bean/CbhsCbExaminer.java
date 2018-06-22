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
@Table(name = "CbhsCbExaminer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsCbExaminer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键（审核信息）",required=false)
	private Integer oid= 0;// 主键（审核信息）
	@Column(name = "projectOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "所属工程项目ID CbhsProject",required=false)
	private Integer projectOid= 0;// 所属工程项目ID CbhsProject
	@Column(name = "type", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核类型 1间接成本 2管理费用 3零星用工 4机械成本 5自营其他费用 6自营材料成本 7分包临建项目",required=false)
	private Integer type= 0;// 审核类型 1间接成本 2管理费用 3零星用工 4机械成本 5自营其他费用 6自营材料成本 7分包临建项目
	@Column(name = "cbOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "对应的成本ID",required=false)
	private Integer cbOid= 0;// 对应的成本ID
	@Column(name = "deptOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "部门ID",required=false)
	private Integer deptOid= 0;// 部门ID
	@Column(name = "deptName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "部门名称",required=false)
	private String deptName= "";// 部门名称
	@Column(name = "extStr", length = 2000, nullable = true, unique = false,columnDefinition="varchar(2000) default ''")
	@ApiModelProperty(value = "额外信息",required=false)
	private String extStr= "";// 额外信息
	@Column(name = "completeState", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "完成状态 1、审核中 2、审核通过 3、审核拒绝 4、撤销",required=false)
	private Integer completeState= 0;// 完成状态 1、审核中 2、审核通过 3、审核拒绝 4、撤销
	@Column(name = "title", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "标题",required=false)
	private String title= "";// 标题
	@Column(name = "alert", length = 200, nullable = true, unique = false,columnDefinition="varchar(200) default ''")
	@ApiModelProperty(value = "内容",required=false)
	private String alert= "";// 内容
	@Column(name = "personOid",updatable = false, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "创建成本的人员Oid",hidden=true,required=false)
	private Integer personOid= 0;// 创建成本的人员Oid
	@Column(name = "personName", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "创建人名称",hidden=true,required=false)
	private String personName= "";// 创建人名称
	@Column(name = "createTimeStr", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "创建时间",hidden=true,required=false)
	private String createTimeStr= "";// 创建时间
	@Column(name = "createTime",updatable = false, nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "创建时间",hidden=true,required=false)
	private Long createTime= 0L;// 创建时间
	@Column(name = "shPersonOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "当前审核人ID",required=false)
	private Integer shPersonOid= 0;// 当前审核人ID
	@Column(name = "shorder", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "当前审核顺序",required=false)
	private Integer shorder= 0;// 当前审核顺序

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

	public Integer getType() { 

    	return this.type;

	}

	public void setType(Integer type) {
 
        this.type = type;

	}

	public Integer getCbOid() { 

    	return this.cbOid;

	}

	public void setCbOid(Integer cbOid) {
 
        this.cbOid = cbOid;

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

	public String getExtStr() { 

    	return this.extStr;

	}

	public void setExtStr(String extStr) {
 
        this.extStr = extStr;

	}

	public Integer getCompleteState() { 

    	return this.completeState;

	}

	public void setCompleteState(Integer completeState) {
 
        this.completeState = completeState;

	}

	public String getTitle() { 

    	return this.title;

	}

	public void setTitle(String title) {
 
        this.title = title;

	}

	public String getAlert() { 

    	return this.alert;

	}

	public void setAlert(String alert) {
 
        this.alert = alert;

	}

	public Integer getPersonOid() { 

    	return this.personOid;

	}

	public void setPersonOid(Integer personOid) {
 
        this.personOid = personOid;

	}

	public String getPersonName() { 

    	return this.personName;

	}

	public void setPersonName(String personName) {
 
        this.personName = personName;

	}

	public String getCreateTimeStr() { 

    	return this.createTimeStr;

	}

	public void setCreateTimeStr(String createTimeStr) {
 
        this.createTimeStr = createTimeStr;

	}

	public Long getCreateTime() { 

    	return this.createTime;

	}

	public void setCreateTime(Long createTime) {
 
        this.createTime = createTime;

	}

	public Integer getShPersonOid() { 

    	return this.shPersonOid;

	}

	public void setShPersonOid(Integer shPersonOid) {
 
        this.shPersonOid = shPersonOid;

	}

	public Integer getShorder() { 

    	return this.shorder;

	}

	public void setShorder(Integer shorder) {
 
        this.shorder = shorder;

	}


}