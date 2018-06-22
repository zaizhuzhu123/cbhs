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
public class uiClhxTj implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "gclName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "工程量名称",required=false)
	private String gclName= "";// 工程量名称
	@Column(name = "gclOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "工程量id",required=false)
	private Integer gclOid= 0;// 工程量id
	@Column(name = "monthStr", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "月份",required=false)
	private String monthStr= "";// 月份
	@Column(name = "cailiaoKemuName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "材料科目名称",required=false)
	private String cailiaoKemuName= "";// 材料科目名称
	@Column(name = "cailiaoOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "材料ID",required=false)
	private Integer cailiaoOid= 0;// 材料ID
	@Column(name = "cailiaoName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "材料名称",required=false)
	private String cailiaoName= "";// 材料名称
	@Column(name = "style", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "材料规格",required=false)
	private String style= "";// 材料规格
	@Column(name = "unit", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "材料单位",required=false)
	private String unit= "";// 材料单位
	@Column(name = "ysCount",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "预算用量",required=false)
	private BigDecimal ysCount= new BigDecimal(0);// 预算用量
	@Column(name = "cbCount",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "实际用量",required=false)
	private BigDecimal cbCount= new BigDecimal(0);// 实际用量

	public String getGclName() { 

    	return this.gclName;

	}

	public void setGclName(String gclName) {
 
        this.gclName = gclName;

	}

	public Integer getGclOid() { 

    	return this.gclOid;

	}

	public void setGclOid(Integer gclOid) {
 
        this.gclOid = gclOid;

	}

	public String getMonthStr() { 

    	return this.monthStr;

	}

	public void setMonthStr(String monthStr) {
 
        this.monthStr = monthStr;

	}

	public String getCailiaoKemuName() { 

    	return this.cailiaoKemuName;

	}

	public void setCailiaoKemuName(String cailiaoKemuName) {
 
        this.cailiaoKemuName = cailiaoKemuName;

	}

	public Integer getCailiaoOid() { 

    	return this.cailiaoOid;

	}

	public void setCailiaoOid(Integer cailiaoOid) {
 
        this.cailiaoOid = cailiaoOid;

	}

	public String getCailiaoName() { 

    	return this.cailiaoName;

	}

	public void setCailiaoName(String cailiaoName) {
 
        this.cailiaoName = cailiaoName;

	}

	public String getStyle() { 

    	return this.style;

	}

	public void setStyle(String style) {
 
        this.style = style;

	}

	public String getUnit() { 

    	return this.unit;

	}

	public void setUnit(String unit) {
 
        this.unit = unit;

	}

	public BigDecimal getYsCount() { 

    	return this.ysCount;

	}

	public void setYsCount(BigDecimal ysCount) {
 
        this.ysCount = ysCount;

	}

	public BigDecimal getCbCount() { 

    	return this.cbCount;

	}

	public void setCbCount(BigDecimal cbCount) {
 
        this.cbCount = cbCount;

	}


}