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
@Table(name = "CbhsDaysJjcb")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel(value="间接成本每日成本对象",description="间接成本每日成本对象")
public class CbhsDaysJjcb implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键（间接成本）(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 主键（间接成本）(创建不填|修改必填)
	@Column(name = "projectOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|所属工程项目ID CbhsProject",required=false)
	private Integer projectOid= 0;// 必填|所属工程项目ID CbhsProject
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
	@ApiModelProperty(value = "必填|合计",required=false)
	private BigDecimal total= new BigDecimal(0);// 必填|合计
	@Column(name = "glry_gz",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|管理人员-工资",required=false)
	private BigDecimal glry_gz= new BigDecimal(0);// 必填|管理人员-工资
	@Column(name = "glry_zjjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|管理人员-职教经费",required=false)
	private BigDecimal glry_zjjf= new BigDecimal(0);// 必填|管理人员-职教经费
	@Column(name = "glry_ghjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|管理人员-工会经费",required=false)
	private BigDecimal glry_ghjf= new BigDecimal(0);// 必填|管理人员-工会经费
	@Column(name = "glry_dwbx",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|管理人员-单位保险",required=false)
	private BigDecimal glry_dwbx= new BigDecimal(0);// 必填|管理人员-单位保险
	@Column(name = "glry_qt",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|管理人员-其他",required=false)
	private BigDecimal glry_qt= new BigDecimal(0);// 必填|管理人员-其他
	@Column(name = "glry_wp_gz",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|管理人员-外聘-工资",required=false)
	private BigDecimal glry_wp_gz= new BigDecimal(0);// 必填|管理人员-外聘-工资
	@Column(name = "glry_wp_zjjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|管理人员-外聘-职教经费",required=false)
	private BigDecimal glry_wp_zjjf= new BigDecimal(0);// 必填|管理人员-外聘-职教经费
	@Column(name = "glry_wp_ghjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|管理人员-外聘-工会经费",required=false)
	private BigDecimal glry_wp_ghjf= new BigDecimal(0);// 必填|管理人员-外聘-工会经费
	@Column(name = "glry_wp_qt",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|管理人员-外聘-其他",required=false)
	private BigDecimal glry_wp_qt= new BigDecimal(0);// 必填|管理人员-外聘-其他
	@Column(name = "scry_gz",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|生产人员-工资",required=false)
	private BigDecimal scry_gz= new BigDecimal(0);// 必填|生产人员-工资
	@Column(name = "scry_zjjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|生产人员-职教经费",required=false)
	private BigDecimal scry_zjjf= new BigDecimal(0);// 必填|生产人员-职教经费
	@Column(name = "scry_ghjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|生产人员-工会经费",required=false)
	private BigDecimal scry_ghjf= new BigDecimal(0);// 必填|生产人员-工会经费
	@Column(name = "scry_dwbx",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|生产人员-单位保险",required=false)
	private BigDecimal scry_dwbx= new BigDecimal(0);// 必填|生产人员-单位保险
	@Column(name = "scry_qt",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|生产人员-其他",required=false)
	private BigDecimal scry_qt= new BigDecimal(0);// 必填|生产人员-其他
	@Column(name = "scry_wp_gz",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|生产人员-外聘-工资",required=false)
	private BigDecimal scry_wp_gz= new BigDecimal(0);// 必填|生产人员-外聘-工资
	@Column(name = "scry_wp_zjjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|生产人员-外聘-职教经费",required=false)
	private BigDecimal scry_wp_zjjf= new BigDecimal(0);// 必填|生产人员-外聘-职教经费
	@Column(name = "scry_wp_ghjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|生产人员-外聘-工会经费",required=false)
	private BigDecimal scry_wp_ghjf= new BigDecimal(0);// 必填|生产人员-外聘-工会经费
	@Column(name = "scry_wp_qt",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|生产人员-外聘-其他",required=false)
	private BigDecimal scry_wp_qt= new BigDecimal(0);// 必填|生产人员-外聘-其他
	@Column(name = "bg_bgyp",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|办公-办公用品",required=false)
	private BigDecimal bg_bgyp= new BigDecimal(0);// 必填|办公-办公用品
	@Column(name = "bg_txf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|办公-通讯费",required=false)
	private BigDecimal bg_txf= new BigDecimal(0);// 必填|办公-通讯费
	@Column(name = "bg_dnhc",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|办公-电脑耗材",required=false)
	private BigDecimal bg_dnhc= new BigDecimal(0);// 必填|办公-电脑耗材
	@Column(name = "bg_qt",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|办公-其他",required=false)
	private BigDecimal bg_qt= new BigDecimal(0);// 必填|办公-其他
	@Column(name = "xlf_dxf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|修理费-大修费",required=false)
	private BigDecimal xlf_dxf= new BigDecimal(0);// 必填|修理费-大修费
	@Column(name = "xlf_ybxlf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|修理费-一般修理费",required=false)
	private BigDecimal xlf_ybxlf= new BigDecimal(0);// 必填|修理费-一般修理费
	@Column(name = "xlf_clf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|修理费-差旅费",required=false)
	private BigDecimal xlf_clf= new BigDecimal(0);// 必填|修理费-差旅费
	@Column(name = "xlf_cailiaofei",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|修理费-材料费",required=false)
	private BigDecimal xlf_cailiaofei= new BigDecimal(0);// 必填|修理费-材料费
	@Column(name = "xlf_flf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|修理费-福利费",required=false)
	private BigDecimal xlf_flf= new BigDecimal(0);// 必填|修理费-福利费
	@Column(name = "xlf_ywjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|修理费-业务经费",required=false)
	private BigDecimal xlf_ywjf= new BigDecimal(0);// 必填|修理费-业务经费
	@Column(name = "xlf_sdf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|修理费-水电费",required=false)
	private BigDecimal xlf_sdf= new BigDecimal(0);// 必填|修理费-水电费
	@Column(name = "xlf_scf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|修理费-审车费",required=false)
	private BigDecimal xlf_scf= new BigDecimal(0);// 必填|修理费-审车费
	@Column(name = "xlf_kyjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|修理费-科研经费",required=false)
	private BigDecimal xlf_kyjf= new BigDecimal(0);// 必填|修理费-科研经费
	@Column(name = "xlf_cljbxf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|修理费-车辆及保险费",required=false)
	private BigDecimal xlf_cljbxf= new BigDecimal(0);// 必填|修理费-车辆及保险费
	@Column(name = "xlf_qt",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|修理费-其他",required=false)
	private BigDecimal xlf_qt= new BigDecimal(0);// 必填|修理费-其他
	@Column(name = "aqfy_ygsz",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|安全费用-一岗双责",required=false)
	private BigDecimal aqfy_ygsz= new BigDecimal(0);// 必填|安全费用-一岗双责
	@Column(name = "aqfy_ygsztc",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|安全费用-一岗双责调差",required=false)
	private BigDecimal aqfy_ygsztc= new BigDecimal(0);// 必填|安全费用-一岗双责调差
	@Column(name = "aqfy_qt",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|安全费用-其他",required=false)
	private BigDecimal aqfy_qt= new BigDecimal(0);// 必填|安全费用-其他
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
	@Column(name = "shId", length = 100, nullable = true, unique = false,columnDefinition="varchar(100) default ''")
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

	public BigDecimal getGlry_gz() { 

    	return this.glry_gz;

	}

	public void setGlry_gz(BigDecimal glry_gz) {
 
        this.glry_gz = glry_gz;

	}

	public BigDecimal getGlry_zjjf() { 

    	return this.glry_zjjf;

	}

	public void setGlry_zjjf(BigDecimal glry_zjjf) {
 
        this.glry_zjjf = glry_zjjf;

	}

	public BigDecimal getGlry_ghjf() { 

    	return this.glry_ghjf;

	}

	public void setGlry_ghjf(BigDecimal glry_ghjf) {
 
        this.glry_ghjf = glry_ghjf;

	}

	public BigDecimal getGlry_dwbx() { 

    	return this.glry_dwbx;

	}

	public void setGlry_dwbx(BigDecimal glry_dwbx) {
 
        this.glry_dwbx = glry_dwbx;

	}

	public BigDecimal getGlry_qt() { 

    	return this.glry_qt;

	}

	public void setGlry_qt(BigDecimal glry_qt) {
 
        this.glry_qt = glry_qt;

	}

	public BigDecimal getGlry_wp_gz() { 

    	return this.glry_wp_gz;

	}

	public void setGlry_wp_gz(BigDecimal glry_wp_gz) {
 
        this.glry_wp_gz = glry_wp_gz;

	}

	public BigDecimal getGlry_wp_zjjf() { 

    	return this.glry_wp_zjjf;

	}

	public void setGlry_wp_zjjf(BigDecimal glry_wp_zjjf) {
 
        this.glry_wp_zjjf = glry_wp_zjjf;

	}

	public BigDecimal getGlry_wp_ghjf() { 

    	return this.glry_wp_ghjf;

	}

	public void setGlry_wp_ghjf(BigDecimal glry_wp_ghjf) {
 
        this.glry_wp_ghjf = glry_wp_ghjf;

	}

	public BigDecimal getGlry_wp_qt() { 

    	return this.glry_wp_qt;

	}

	public void setGlry_wp_qt(BigDecimal glry_wp_qt) {
 
        this.glry_wp_qt = glry_wp_qt;

	}

	public BigDecimal getScry_gz() { 

    	return this.scry_gz;

	}

	public void setScry_gz(BigDecimal scry_gz) {
 
        this.scry_gz = scry_gz;

	}

	public BigDecimal getScry_zjjf() { 

    	return this.scry_zjjf;

	}

	public void setScry_zjjf(BigDecimal scry_zjjf) {
 
        this.scry_zjjf = scry_zjjf;

	}

	public BigDecimal getScry_ghjf() { 

    	return this.scry_ghjf;

	}

	public void setScry_ghjf(BigDecimal scry_ghjf) {
 
        this.scry_ghjf = scry_ghjf;

	}

	public BigDecimal getScry_dwbx() { 

    	return this.scry_dwbx;

	}

	public void setScry_dwbx(BigDecimal scry_dwbx) {
 
        this.scry_dwbx = scry_dwbx;

	}

	public BigDecimal getScry_qt() { 

    	return this.scry_qt;

	}

	public void setScry_qt(BigDecimal scry_qt) {
 
        this.scry_qt = scry_qt;

	}

	public BigDecimal getScry_wp_gz() { 

    	return this.scry_wp_gz;

	}

	public void setScry_wp_gz(BigDecimal scry_wp_gz) {
 
        this.scry_wp_gz = scry_wp_gz;

	}

	public BigDecimal getScry_wp_zjjf() { 

    	return this.scry_wp_zjjf;

	}

	public void setScry_wp_zjjf(BigDecimal scry_wp_zjjf) {
 
        this.scry_wp_zjjf = scry_wp_zjjf;

	}

	public BigDecimal getScry_wp_ghjf() { 

    	return this.scry_wp_ghjf;

	}

	public void setScry_wp_ghjf(BigDecimal scry_wp_ghjf) {
 
        this.scry_wp_ghjf = scry_wp_ghjf;

	}

	public BigDecimal getScry_wp_qt() { 

    	return this.scry_wp_qt;

	}

	public void setScry_wp_qt(BigDecimal scry_wp_qt) {
 
        this.scry_wp_qt = scry_wp_qt;

	}

	public BigDecimal getBg_bgyp() { 

    	return this.bg_bgyp;

	}

	public void setBg_bgyp(BigDecimal bg_bgyp) {
 
        this.bg_bgyp = bg_bgyp;

	}

	public BigDecimal getBg_txf() { 

    	return this.bg_txf;

	}

	public void setBg_txf(BigDecimal bg_txf) {
 
        this.bg_txf = bg_txf;

	}

	public BigDecimal getBg_dnhc() { 

    	return this.bg_dnhc;

	}

	public void setBg_dnhc(BigDecimal bg_dnhc) {
 
        this.bg_dnhc = bg_dnhc;

	}

	public BigDecimal getBg_qt() { 

    	return this.bg_qt;

	}

	public void setBg_qt(BigDecimal bg_qt) {
 
        this.bg_qt = bg_qt;

	}

	public BigDecimal getXlf_dxf() { 

    	return this.xlf_dxf;

	}

	public void setXlf_dxf(BigDecimal xlf_dxf) {
 
        this.xlf_dxf = xlf_dxf;

	}

	public BigDecimal getXlf_ybxlf() { 

    	return this.xlf_ybxlf;

	}

	public void setXlf_ybxlf(BigDecimal xlf_ybxlf) {
 
        this.xlf_ybxlf = xlf_ybxlf;

	}

	public BigDecimal getXlf_clf() { 

    	return this.xlf_clf;

	}

	public void setXlf_clf(BigDecimal xlf_clf) {
 
        this.xlf_clf = xlf_clf;

	}

	public BigDecimal getXlf_cailiaofei() { 

    	return this.xlf_cailiaofei;

	}

	public void setXlf_cailiaofei(BigDecimal xlf_cailiaofei) {
 
        this.xlf_cailiaofei = xlf_cailiaofei;

	}

	public BigDecimal getXlf_flf() { 

    	return this.xlf_flf;

	}

	public void setXlf_flf(BigDecimal xlf_flf) {
 
        this.xlf_flf = xlf_flf;

	}

	public BigDecimal getXlf_ywjf() { 

    	return this.xlf_ywjf;

	}

	public void setXlf_ywjf(BigDecimal xlf_ywjf) {
 
        this.xlf_ywjf = xlf_ywjf;

	}

	public BigDecimal getXlf_sdf() { 

    	return this.xlf_sdf;

	}

	public void setXlf_sdf(BigDecimal xlf_sdf) {
 
        this.xlf_sdf = xlf_sdf;

	}

	public BigDecimal getXlf_scf() { 

    	return this.xlf_scf;

	}

	public void setXlf_scf(BigDecimal xlf_scf) {
 
        this.xlf_scf = xlf_scf;

	}

	public BigDecimal getXlf_kyjf() { 

    	return this.xlf_kyjf;

	}

	public void setXlf_kyjf(BigDecimal xlf_kyjf) {
 
        this.xlf_kyjf = xlf_kyjf;

	}

	public BigDecimal getXlf_cljbxf() { 

    	return this.xlf_cljbxf;

	}

	public void setXlf_cljbxf(BigDecimal xlf_cljbxf) {
 
        this.xlf_cljbxf = xlf_cljbxf;

	}

	public BigDecimal getXlf_qt() { 

    	return this.xlf_qt;

	}

	public void setXlf_qt(BigDecimal xlf_qt) {
 
        this.xlf_qt = xlf_qt;

	}

	public BigDecimal getAqfy_ygsz() { 

    	return this.aqfy_ygsz;

	}

	public void setAqfy_ygsz(BigDecimal aqfy_ygsz) {
 
        this.aqfy_ygsz = aqfy_ygsz;

	}

	public BigDecimal getAqfy_ygsztc() { 

    	return this.aqfy_ygsztc;

	}

	public void setAqfy_ygsztc(BigDecimal aqfy_ygsztc) {
 
        this.aqfy_ygsztc = aqfy_ygsztc;

	}

	public BigDecimal getAqfy_qt() { 

    	return this.aqfy_qt;

	}

	public void setAqfy_qt(BigDecimal aqfy_qt) {
 
        this.aqfy_qt = aqfy_qt;

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