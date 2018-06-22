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
@Table(name = "CbhsZytjFC")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsZytjFC implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键",required=false)
	private Integer oid= 0;// 主键
	@Column(name = "zytjOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "(资源统计)",required=false)
	private Integer zytjOid= 0;// (资源统计)
	@Column(name = "clOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "材料编号",required=false)
	private Integer clOid= 0;// 材料编号
	@Column(name = "clName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "材料名称",required=false)
	private String clName= "";// 材料名称
	@Column(name = "clUnitPrice",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "单价",required=false)
	private BigDecimal clUnitPrice= new BigDecimal(0);// 单价
	@Column(name = "clUnit", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "单位",required=false)
	private String clUnit= "";// 单位
	@Column(name = "clStyle", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "规格",required=false)
	private String clStyle= "";// 规格
	@Column(name = "clCount",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "材料数量",required=false)
	private BigDecimal clCount= new BigDecimal(0);// 材料数量
	@Column(name = "clTotalPrice",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "材料金额",required=false)
	private BigDecimal clTotalPrice= new BigDecimal(0);// 材料金额

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

	public Integer getClOid() { 

    	return this.clOid;

	}

	public void setClOid(Integer clOid) {
 
        this.clOid = clOid;

	}

	public String getClName() { 

    	return this.clName;

	}

	public void setClName(String clName) {
 
        this.clName = clName;

	}

	public BigDecimal getClUnitPrice() { 

    	return this.clUnitPrice;

	}

	public void setClUnitPrice(BigDecimal clUnitPrice) {
 
        this.clUnitPrice = clUnitPrice;

	}

	public String getClUnit() { 

    	return this.clUnit;

	}

	public void setClUnit(String clUnit) {
 
        this.clUnit = clUnit;

	}

	public String getClStyle() { 

    	return this.clStyle;

	}

	public void setClStyle(String clStyle) {
 
        this.clStyle = clStyle;

	}

	public BigDecimal getClCount() { 

    	return this.clCount;

	}

	public void setClCount(BigDecimal clCount) {
 
        this.clCount = clCount;

	}

	public BigDecimal getClTotalPrice() { 

    	return this.clTotalPrice;

	}

	public void setClTotalPrice(BigDecimal clTotalPrice) {
 
        this.clTotalPrice = clTotalPrice;

	}


}