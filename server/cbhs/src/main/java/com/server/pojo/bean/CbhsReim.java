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
@Table(name = "CbhsReim")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel(value="财务报销对象",description="财务报销对象")
public class CbhsReim implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键(报销ID)(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 主键(报销ID)(创建不填|修改必填)
	@Column(name = "orderOid", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "报销编号",required=false)
	private String orderOid= "";// 报销编号
	@Column(name = "projectOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|所属工程项目ID CbhsProject",required=false)
	private Integer projectOid= 0;// 必填|所属工程项目ID CbhsProject
	@Column(name = "dateStr", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "日期 yyyy-MM-dd 便于展示",hidden=true,required=false)
	private String dateStr= "";// 日期 yyyy-MM-dd 便于展示
	@Column(name = "dateTimeStamp",updatable = false, nullable = true, unique = false)
	@ApiModelProperty(value = "日期 每天00:00:00的时间戳 用于后期数据统计",required=false)
	private long  dateTimeStamp;// 日期 每天00:00:00的时间戳 用于后期数据统计
	@Column(name = "monthStr", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|月份 yyyy-MM 便于展示",hidden=true,required=false)
	private String monthStr= "";// 必填|月份 yyyy-MM 便于展示
	@Column(name = "monthTimeStamp",updatable = false, nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "必填|月份 时间戳 用于后期数据统计",hidden=true,required=false)
	private Long monthTimeStamp= 0L;// 必填|月份 时间戳 用于后期数据统计
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
	@Column(name = "deptOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|部门编号",required=false)
	private Integer deptOid= 0;// 必填|部门编号
	@Column(name = "deptName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|部门名称",required=false)
	private String deptName= "";// 必填|部门名称
	@Column(name = "shStatus",updatable = false, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核状态 0 可用 1 审核中 2 审核不通过",hidden=true,required=false)
	private Integer shStatus= 0;// 审核状态 0 可用 1 审核中 2 审核不通过
	@Column(name = "total",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "合计金额",required=false)
	private BigDecimal total= new BigDecimal(0);// 合计金额
	@Column(name = "attachmentCount", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "附件张数",required=false)
	private Integer attachmentCount= 0;// 附件张数
	@Column(name = "cwPersonName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "财务审核时服务端加入|财务审核人姓名",required=false)
	private String cwPersonName= "";// 财务审核时服务端加入|财务审核人姓名
	@Column(name = "cwTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "财务审核时服务端加入|财务同意报销金额",required=false)
	private BigDecimal cwTotal= new BigDecimal(0);// 财务审核时服务端加入|财务同意报销金额
	@Column(name = "process", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "服务端用于流程步骤的状态 0 待部门领导审批 1待财务审批 2待项目经理审批 3結束 部门领导和项目经理为审核规则中配置的人 财务为财务部的员工",required=false)
	private Integer process= 0;// 服务端用于流程步骤的状态 0 待部门领导审批 1待财务审批 2待项目经理审批 3結束 部门领导和项目经理为审核规则中配置的人 财务为财务部的员工
	@Column(name = "examOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审批任务编号，用于部门经理和项目经理审批 调用接口时使用",required=false)
	private Integer examOid= 0;// 审批任务编号，用于部门经理和项目经理审批 调用接口时使用
	@OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "reimOid", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT) )
	@ApiModelProperty(value = "项目",required=false)
	private List<CbhsReimTerm> terms= new ArrayList<>();;// 项目
	@Column(name = "projectManagerName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "项目经理名称",required=false)
	private String projectManagerName= "";// 项目经理名称

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public String getOrderOid() { 

    	return this.orderOid;

	}

	public void setOrderOid(String orderOid) {
 
        this.orderOid = orderOid;

	}

	public Integer getProjectOid() { 

    	return this.projectOid;

	}

	public void setProjectOid(Integer projectOid) {
 
        this.projectOid = projectOid;

	}

	public String getDateStr() { 

    	return this.dateStr;

	}

	public void setDateStr(String dateStr) {
 
        this.dateStr = dateStr;

	}

	public long getDateTimeStamp() { 

    	return this.dateTimeStamp;

	}

	public void setDateTimeStamp(long dateTimeStamp) {
 
        this.dateTimeStamp = dateTimeStamp;

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

	public Integer getShStatus() { 

    	return this.shStatus;

	}

	public void setShStatus(Integer shStatus) {
 
        this.shStatus = shStatus;

	}

	public BigDecimal getTotal() { 

    	return this.total;

	}

	public void setTotal(BigDecimal total) {
 
        this.total = total;

	}

	public Integer getAttachmentCount() { 

    	return this.attachmentCount;

	}

	public void setAttachmentCount(Integer attachmentCount) {
 
        this.attachmentCount = attachmentCount;

	}

	public String getCwPersonName() { 

    	return this.cwPersonName;

	}

	public void setCwPersonName(String cwPersonName) {
 
        this.cwPersonName = cwPersonName;

	}

	public BigDecimal getCwTotal() { 

    	return this.cwTotal;

	}

	public void setCwTotal(BigDecimal cwTotal) {
 
        this.cwTotal = cwTotal;

	}

	public Integer getProcess() { 

    	return this.process;

	}

	public void setProcess(Integer process) {
 
        this.process = process;

	}

	public Integer getExamOid() { 

    	return this.examOid;

	}

	public void setExamOid(Integer examOid) {
 
        this.examOid = examOid;

	}

	public List<CbhsReimTerm> getTerms() {
    	return this.terms;
	}
	public void setTerms(List<CbhsReimTerm> terms) {
    this.terms =terms;
	}

	public String getProjectManagerName() { 

    	return this.projectManagerName;

	}

	public void setProjectManagerName(String projectManagerName) {
 
        this.projectManagerName = projectManagerName;

	}


}