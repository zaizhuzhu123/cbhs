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
@Table(name = "CbhsZdgxhs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsZdgxhs implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键(重点工序核算)(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 主键(重点工序核算)(创建不填|修改必填)
	@Column(name = "projectOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|所属工程项目ID CbhsProject",required=false)
	private Integer projectOid= 0;// 必填|所属工程项目ID CbhsProject
	@Column(name = "globalGclYsOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|对应的分包工程量ID 大项",required=false)
	private Integer globalGclYsOid= 0;// 必填|对应的分包工程量ID 大项
	@Column(name = "globaGclYsName", length = 200, nullable = true, unique = false,columnDefinition="varchar(200) default ''")
	@ApiModelProperty(value = "必填|对应的分包工程量大项 名称",required=false)
	private String globaGclYsName= "";// 必填|对应的分包工程量大项 名称
	@Column(name = "fbGclYsOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|对应的分包工程量ID 小项",required=false)
	private Integer fbGclYsOid= 0;// 必填|对应的分包工程量ID 小项
	@Column(name = "fbGclYsName", length = 200, nullable = true, unique = false,columnDefinition="varchar(200) default ''")
	@ApiModelProperty(value = "必填|对应的分包工程量 名称",required=false)
	private String fbGclYsName= "";// 必填|对应的分包工程量 名称
	@Column(name = "fbcompanyOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|分包公司编号 分包公司项目",required=false)
	private Integer fbcompanyOid= 0;// 必填|分包公司编号 分包公司项目
	@Column(name = "fbcompanyName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|分包公司名称",required=false)
	private String fbcompanyName= "";// 必填|分包公司名称
	@Column(name = "deptOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|部门编号",required=false)
	private Integer deptOid= 0;// 必填|部门编号
	@Column(name = "deptName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|部门名称",required=false)
	private String deptName= "";// 必填|部门名称
	@Column(name = "machineryOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|设备ID",required=false)
	private Integer machineryOid= 0;// 必填|设备ID
	@Column(name = "machineryName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|设备名称",required=false)
	private String machineryName= "";// 必填|设备名称
	@Column(name = "completeTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|完成方量",required=false)
	private BigDecimal completeTotal= new BigDecimal(0);// 必填|完成方量
	@Column(name = "workTime", nullable = true, unique = false,columnDefinition="float(11) default 0")
	@ApiModelProperty(value = "必填|工作时间",required=false)
	private float  workTime;// 必填|工作时间
	@Column(name = "p_zjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|折旧费或租赁费",required=false)
	private BigDecimal p_zjf= new BigDecimal(0);// 必填|折旧费或租赁费
	@Column(name = "p_jxysf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|机械运输费",required=false)
	private BigDecimal p_jxysf= new BigDecimal(0);// 必填|机械运输费
	@Column(name = "p_jxdxf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|机械大修费",required=false)
	private BigDecimal p_jxdxf= new BigDecimal(0);// 必填|机械大修费
	@Column(name = "ryID", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|燃油ID",required=false)
	private Integer ryID= 0;// 必填|燃油ID
	@Column(name = "ryKemuName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "选填|燃油科目名称",required=false)
	private String ryKemuName= "";// 选填|燃油科目名称
	@Column(name = "ryName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|燃油名称",required=false)
	private String ryName= "";// 必填|燃油名称
	@Column(name = "ryUseCount",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|燃油使用量 单位L",required=false)
	private BigDecimal ryUseCount= new BigDecimal(0);// 必填|燃油使用量 单位L
	@Column(name = "ryStyle", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "选填|燃油规格",required=false)
	private String ryStyle= "";// 选填|燃油规格
	@Column(name = "ryUnit", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|燃油单位",required=false)
	private String ryUnit= "";// 必填|燃油单位
	@Column(name = "ryUnitPrice",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|燃油单价",required=false)
	private BigDecimal ryUnitPrice= new BigDecimal(0);// 必填|燃油单价
	@Column(name = "ryPrice",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|燃油金额",required=false)
	private BigDecimal ryPrice= new BigDecimal(0);// 必填|燃油金额
	@Column(name = "total",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|总金额",required=false)
	private BigDecimal total= new BigDecimal(0);// 必填|总金额
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
	@Transient
	@ApiModelProperty(value = "必填|工种集合",required=false)
	private ArrayList<CbhsZdgxhsGZ>  gzs;// 必填|工种集合
	@Column(name = "gzTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|工种总金额",required=false)
	private BigDecimal gzTotal= new BigDecimal(0);// 必填|工种总金额
	@Transient
	@ApiModelProperty(value = "必填|主材集合",required=false)
	private ArrayList<CbhsZdgxhsZC>  zcs;// 必填|主材集合
	@Column(name = "zcTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|主材总金额",required=false)
	private BigDecimal zcTotal= new BigDecimal(0);// 必填|主材总金额
	@Transient
	@ApiModelProperty(value = "必填|辅材集合",required=false)
	private ArrayList<CbhsZdgxhsFC>  fcs;// 必填|辅材集合
	@Column(name = "fcTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|辅材总金额",required=false)
	private BigDecimal fcTotal= new BigDecimal(0);// 必填|辅材总金额
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

	public Integer getGlobalGclYsOid() { 

    	return this.globalGclYsOid;

	}

	public void setGlobalGclYsOid(Integer globalGclYsOid) {
 
        this.globalGclYsOid = globalGclYsOid;

	}

	public String getGlobaGclYsName() { 

    	return this.globaGclYsName;

	}

	public void setGlobaGclYsName(String globaGclYsName) {
 
        this.globaGclYsName = globaGclYsName;

	}

	public Integer getFbGclYsOid() { 

    	return this.fbGclYsOid;

	}

	public void setFbGclYsOid(Integer fbGclYsOid) {
 
        this.fbGclYsOid = fbGclYsOid;

	}

	public String getFbGclYsName() { 

    	return this.fbGclYsName;

	}

	public void setFbGclYsName(String fbGclYsName) {
 
        this.fbGclYsName = fbGclYsName;

	}

	public Integer getFbcompanyOid() { 

    	return this.fbcompanyOid;

	}

	public void setFbcompanyOid(Integer fbcompanyOid) {
 
        this.fbcompanyOid = fbcompanyOid;

	}

	public String getFbcompanyName() { 

    	return this.fbcompanyName;

	}

	public void setFbcompanyName(String fbcompanyName) {
 
        this.fbcompanyName = fbcompanyName;

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

	public Integer getMachineryOid() { 

    	return this.machineryOid;

	}

	public void setMachineryOid(Integer machineryOid) {
 
        this.machineryOid = machineryOid;

	}

	public String getMachineryName() { 

    	return this.machineryName;

	}

	public void setMachineryName(String machineryName) {
 
        this.machineryName = machineryName;

	}

	public BigDecimal getCompleteTotal() { 

    	return this.completeTotal;

	}

	public void setCompleteTotal(BigDecimal completeTotal) {
 
        this.completeTotal = completeTotal;

	}

	public float getWorkTime() { 

    	return this.workTime;

	}

	public void setWorkTime(float workTime) {
 
        this.workTime = workTime;

	}

	public BigDecimal getP_zjf() { 

    	return this.p_zjf;

	}

	public void setP_zjf(BigDecimal p_zjf) {
 
        this.p_zjf = p_zjf;

	}

	public BigDecimal getP_jxysf() { 

    	return this.p_jxysf;

	}

	public void setP_jxysf(BigDecimal p_jxysf) {
 
        this.p_jxysf = p_jxysf;

	}

	public BigDecimal getP_jxdxf() { 

    	return this.p_jxdxf;

	}

	public void setP_jxdxf(BigDecimal p_jxdxf) {
 
        this.p_jxdxf = p_jxdxf;

	}

	public Integer getRyID() { 

    	return this.ryID;

	}

	public void setRyID(Integer ryID) {
 
        this.ryID = ryID;

	}

	public String getRyKemuName() { 

    	return this.ryKemuName;

	}

	public void setRyKemuName(String ryKemuName) {
 
        this.ryKemuName = ryKemuName;

	}

	public String getRyName() { 

    	return this.ryName;

	}

	public void setRyName(String ryName) {
 
        this.ryName = ryName;

	}

	public BigDecimal getRyUseCount() { 

    	return this.ryUseCount;

	}

	public void setRyUseCount(BigDecimal ryUseCount) {
 
        this.ryUseCount = ryUseCount;

	}

	public String getRyStyle() { 

    	return this.ryStyle;

	}

	public void setRyStyle(String ryStyle) {
 
        this.ryStyle = ryStyle;

	}

	public String getRyUnit() { 

    	return this.ryUnit;

	}

	public void setRyUnit(String ryUnit) {
 
        this.ryUnit = ryUnit;

	}

	public BigDecimal getRyUnitPrice() { 

    	return this.ryUnitPrice;

	}

	public void setRyUnitPrice(BigDecimal ryUnitPrice) {
 
        this.ryUnitPrice = ryUnitPrice;

	}

	public BigDecimal getRyPrice() { 

    	return this.ryPrice;

	}

	public void setRyPrice(BigDecimal ryPrice) {
 
        this.ryPrice = ryPrice;

	}

	public BigDecimal getTotal() { 

    	return this.total;

	}

	public void setTotal(BigDecimal total) {
 
        this.total = total;

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

	public ArrayList<CbhsZdgxhsGZ> getGzs() { 

    	return this.gzs;

	}

	public void setGzs(ArrayList<CbhsZdgxhsGZ> gzs) {
 
        this.gzs = gzs;

	}

	public BigDecimal getGzTotal() { 

    	return this.gzTotal;

	}

	public void setGzTotal(BigDecimal gzTotal) {
 
        this.gzTotal = gzTotal;

	}

	public ArrayList<CbhsZdgxhsZC> getZcs() { 

    	return this.zcs;

	}

	public void setZcs(ArrayList<CbhsZdgxhsZC> zcs) {
 
        this.zcs = zcs;

	}

	public BigDecimal getZcTotal() { 

    	return this.zcTotal;

	}

	public void setZcTotal(BigDecimal zcTotal) {
 
        this.zcTotal = zcTotal;

	}

	public ArrayList<CbhsZdgxhsFC> getFcs() { 

    	return this.fcs;

	}

	public void setFcs(ArrayList<CbhsZdgxhsFC> fcs) {
 
        this.fcs = fcs;

	}

	public BigDecimal getFcTotal() { 

    	return this.fcTotal;

	}

	public void setFcTotal(BigDecimal fcTotal) {
 
        this.fcTotal = fcTotal;

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


}