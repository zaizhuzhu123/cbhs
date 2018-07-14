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
@Table(name = "CbhsZdgxhsMachine")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel(value="重点工序核算-机械设备对象",description="重点工序核算-机械设备对象")
public class CbhsZdgxhsMachine implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键(重点工序核算)(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 主键(重点工序核算)(创建不填|修改必填)
	@Column(name = "zytjOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "(重点工序核算)",required=false)
	private Integer zytjOid= 0;// (重点工序核算)
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
	@ApiModelProperty(value = "必填|折旧费",required=false)
	private BigDecimal p_zjf= new BigDecimal(0);// 必填|折旧费
	@Column(name = "p_zpf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|租赁费",required=false)
	private BigDecimal p_zpf= new BigDecimal(0);// 必填|租赁费
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
	@Column(name = "p_total",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|机械总价",required=false)
	private BigDecimal p_total= new BigDecimal(0);// 必填|机械总价

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getZytjOid() { 

    	return this.zytjOid;

	}

	public void setZytjOid(Integer zytjOid) {
 
        this.zytjOid = zytjOid;

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

	public BigDecimal getP_zpf() { 

    	return this.p_zpf;

	}

	public void setP_zpf(BigDecimal p_zpf) {
 
        this.p_zpf = p_zpf;

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

	public BigDecimal getP_total() { 

    	return this.p_total;

	}

	public void setP_total(BigDecimal p_total) {
 
        this.p_total = p_total;

	}


}