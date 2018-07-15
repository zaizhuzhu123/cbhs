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
public class uiFbCompanyTj implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键(重点工序核算)(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 主键(重点工序核算)(创建不填|修改必填)
	@Column(name = "dateStr", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "日期 yyyy-MM-dd 便于展示",required=false)
	private String dateStr= "";// 日期 yyyy-MM-dd 便于展示
	@Column(name = "dateTimeStamp", nullable = true, unique = false)
	@ApiModelProperty(value = "日期 每天00:00:00的时间戳 用于后期数据统计",required=false)
	private long  dateTimeStamp;// 日期 每天00:00:00的时间戳 用于后期数据统计
	@Column(name = "fbcompanyOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "分包公司编号 分包公司项目",required=false)
	private Integer fbcompanyOid= 0;// 分包公司编号 分包公司项目
	@Column(name = "fbcompanyName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "分包公司名称",required=false)
	private String fbcompanyName= "";// 分包公司名称
	@Column(name = "globalGclYsOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "对应的分包工程量ID 大项",required=false)
	private Integer globalGclYsOid= 0;// 对应的分包工程量ID 大项
	@Column(name = "globaGclYsName", length = 200, nullable = true, unique = false,columnDefinition="varchar(200) default ''")
	@ApiModelProperty(value = "对应的分包工程量大项 名称",required=false)
	private String globaGclYsName= "";// 对应的分包工程量大项 名称
	@Column(name = "fbGclYsOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "对应的分包工程量ID 小项",required=false)
	private Integer fbGclYsOid= 0;// 对应的分包工程量ID 小项
	@Column(name = "fbGclYsName", length = 200, nullable = true, unique = false,columnDefinition="varchar(200) default ''")
	@ApiModelProperty(value = "对应的分包工程量 名称",required=false)
	private String fbGclYsName= "";// 对应的分包工程量 名称
	@Column(name = "gzTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "人力费用",required=false)
	private BigDecimal gzTotal= new BigDecimal(0);// 人力费用
	@Column(name = "zcTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "主材费用",required=false)
	private BigDecimal zcTotal= new BigDecimal(0);// 主材费用
	@Column(name = "fcTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "辅材费用",required=false)
	private BigDecimal fcTotal= new BigDecimal(0);// 辅材费用
	@Column(name = "machinerTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "机械费用",required=false)
	private BigDecimal machinerTotal= new BigDecimal(0);// 机械费用
	@Column(name = "machinerRyTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "机械燃油",required=false)
	private BigDecimal machinerRyTotal= new BigDecimal(0);// 机械燃油
	@Column(name = "total",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "合计",required=false)
	private BigDecimal total= new BigDecimal(0);// 合计

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

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

	public BigDecimal getGzTotal() { 

    	return this.gzTotal;

	}

	public void setGzTotal(BigDecimal gzTotal) {
 
        this.gzTotal = gzTotal;

	}

	public BigDecimal getZcTotal() { 

    	return this.zcTotal;

	}

	public void setZcTotal(BigDecimal zcTotal) {
 
        this.zcTotal = zcTotal;

	}

	public BigDecimal getFcTotal() { 

    	return this.fcTotal;

	}

	public void setFcTotal(BigDecimal fcTotal) {
 
        this.fcTotal = fcTotal;

	}

	public BigDecimal getMachinerTotal() { 

    	return this.machinerTotal;

	}

	public void setMachinerTotal(BigDecimal machinerTotal) {
 
        this.machinerTotal = machinerTotal;

	}

	public BigDecimal getMachinerRyTotal() { 

    	return this.machinerRyTotal;

	}

	public void setMachinerRyTotal(BigDecimal machinerRyTotal) {
 
        this.machinerRyTotal = machinerRyTotal;

	}

	public BigDecimal getTotal() { 

    	return this.total;

	}

	public void setTotal(BigDecimal total) {
 
        this.total = total;

	}


}