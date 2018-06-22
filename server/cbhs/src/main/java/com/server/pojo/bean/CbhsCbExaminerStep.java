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
@Table(name = "CbhsCbExaminerStep")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsCbExaminerStep implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键（审核信息）",required=false)
	private Integer oid= 0;// 主键（审核信息）
	@Column(name = "taskOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核任务ID",required=false)
	private Integer taskOid= 0;// 审核任务ID
	@Column(name = "shorder", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核顺序",required=false)
	private Integer shorder= 0;// 审核顺序
	@Column(name = "shPersonOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核人ID",required=false)
	private Integer shPersonOid= 0;// 审核人ID
	@Column(name = "shPersonName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "审核人名称",required=false)
	private String shPersonName= "";// 审核人名称
	@Column(name = "remark", length = 200, nullable = true, unique = false,columnDefinition="varchar(200) default ''")
	@ApiModelProperty(value = "审核人批注",required=false)
	private String remark= "";// 审核人批注
	@Column(name = "stepStatus", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "步骤状态 1、等待 2、待审核 3、审核通过 4、审核拒绝",required=false)
	private Integer stepStatus= 0;// 步骤状态 1、等待 2、待审核 3、审核通过 4、审核拒绝
	@Column(name = "opTimeStr", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "操作时间",required=false)
	private String opTimeStr= "";// 操作时间
	@Column(name = "opTime", nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "操作时间",required=false)
	private Long opTime= 0L;// 操作时间

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getTaskOid() { 

    	return this.taskOid;

	}

	public void setTaskOid(Integer taskOid) {
 
        this.taskOid = taskOid;

	}

	public Integer getShorder() { 

    	return this.shorder;

	}

	public void setShorder(Integer shorder) {
 
        this.shorder = shorder;

	}

	public Integer getShPersonOid() { 

    	return this.shPersonOid;

	}

	public void setShPersonOid(Integer shPersonOid) {
 
        this.shPersonOid = shPersonOid;

	}

	public String getShPersonName() { 

    	return this.shPersonName;

	}

	public void setShPersonName(String shPersonName) {
 
        this.shPersonName = shPersonName;

	}

	public String getRemark() { 

    	return this.remark;

	}

	public void setRemark(String remark) {
 
        this.remark = remark;

	}

	public Integer getStepStatus() { 

    	return this.stepStatus;

	}

	public void setStepStatus(Integer stepStatus) {
 
        this.stepStatus = stepStatus;

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