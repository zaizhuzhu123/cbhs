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
public class uiCbhsMonthZjCbTotal implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "p_zyCailiaoCb",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "自营材料费",required=false)
	private BigDecimal p_zyCailiaoCb= new BigDecimal(0);// 自营材料费
	@Column(name = "p_zyJxCb",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "机械费",required=false)
	private BigDecimal p_zyJxCb= new BigDecimal(0);// 机械费
	@Column(name = "p_zyJxCb_zjf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "折旧费",required=false)
	private BigDecimal p_zyJxCb_zjf= new BigDecimal(0);// 折旧费
	@Column(name = "p_zyJxCb_zpf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "租赁费",required=false)
	private BigDecimal p_zyJxCb_zpf= new BigDecimal(0);// 租赁费
	@Column(name = "p_zyJxCb_clysf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "车辆运输费",required=false)
	private BigDecimal p_zyJxCb_clysf= new BigDecimal(0);// 车辆运输费
	@Column(name = "p_zyJxCb_jxdxf",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "机械大修费",required=false)
	private BigDecimal p_zyJxCb_jxdxf= new BigDecimal(0);// 机械大修费
	@Column(name = "p_zyLxygCb",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "零星用工",required=false)
	private BigDecimal p_zyLxygCb= new BigDecimal(0);// 零星用工
	@Column(name = "p_zyQtfyCb",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "其他费用",required=false)
	private BigDecimal p_zyQtfyCb= new BigDecimal(0);// 其他费用
	@Column(name = "p_fbGcCb",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包工程成本",required=false)
	private BigDecimal p_fbGcCb= new BigDecimal(0);// 分包工程成本
	@Column(name = "p_fbCailiaoCb",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包材料成本",required=false)
	private BigDecimal p_fbCailiaoCb= new BigDecimal(0);// 分包材料成本
	@Column(name = "p_fbLjxmCb",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包临建项目",required=false)
	private BigDecimal p_fbLjxmCb= new BigDecimal(0);// 分包临建项目
	@Column(name = "opUserOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "操作人ID",required=false)
	private Integer opUserOid= 0;// 操作人ID
	@Column(name = "opUserName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "操作人姓名",required=false)
	private String opUserName= "";// 操作人姓名
	@Column(name = "opTimeStr", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "操作时间",required=false)
	private String opTimeStr= "";// 操作时间
	@Column(name = "opTime", nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "操作时间",required=false)
	private Long opTime= 0L;// 操作时间

	public BigDecimal getP_zyCailiaoCb() { 

    	return this.p_zyCailiaoCb;

	}

	public void setP_zyCailiaoCb(BigDecimal p_zyCailiaoCb) {
 
        this.p_zyCailiaoCb = p_zyCailiaoCb;

	}

	public BigDecimal getP_zyJxCb() { 

    	return this.p_zyJxCb;

	}

	public void setP_zyJxCb(BigDecimal p_zyJxCb) {
 
        this.p_zyJxCb = p_zyJxCb;

	}

	public BigDecimal getP_zyJxCb_zjf() { 

    	return this.p_zyJxCb_zjf;

	}

	public void setP_zyJxCb_zjf(BigDecimal p_zyJxCb_zjf) {
 
        this.p_zyJxCb_zjf = p_zyJxCb_zjf;

	}

	public BigDecimal getP_zyJxCb_zpf() { 

    	return this.p_zyJxCb_zpf;

	}

	public void setP_zyJxCb_zpf(BigDecimal p_zyJxCb_zpf) {
 
        this.p_zyJxCb_zpf = p_zyJxCb_zpf;

	}

	public BigDecimal getP_zyJxCb_clysf() { 

    	return this.p_zyJxCb_clysf;

	}

	public void setP_zyJxCb_clysf(BigDecimal p_zyJxCb_clysf) {
 
        this.p_zyJxCb_clysf = p_zyJxCb_clysf;

	}

	public BigDecimal getP_zyJxCb_jxdxf() { 

    	return this.p_zyJxCb_jxdxf;

	}

	public void setP_zyJxCb_jxdxf(BigDecimal p_zyJxCb_jxdxf) {
 
        this.p_zyJxCb_jxdxf = p_zyJxCb_jxdxf;

	}

	public BigDecimal getP_zyLxygCb() { 

    	return this.p_zyLxygCb;

	}

	public void setP_zyLxygCb(BigDecimal p_zyLxygCb) {
 
        this.p_zyLxygCb = p_zyLxygCb;

	}

	public BigDecimal getP_zyQtfyCb() { 

    	return this.p_zyQtfyCb;

	}

	public void setP_zyQtfyCb(BigDecimal p_zyQtfyCb) {
 
        this.p_zyQtfyCb = p_zyQtfyCb;

	}

	public BigDecimal getP_fbGcCb() { 

    	return this.p_fbGcCb;

	}

	public void setP_fbGcCb(BigDecimal p_fbGcCb) {
 
        this.p_fbGcCb = p_fbGcCb;

	}

	public BigDecimal getP_fbCailiaoCb() { 

    	return this.p_fbCailiaoCb;

	}

	public void setP_fbCailiaoCb(BigDecimal p_fbCailiaoCb) {
 
        this.p_fbCailiaoCb = p_fbCailiaoCb;

	}

	public BigDecimal getP_fbLjxmCb() { 

    	return this.p_fbLjxmCb;

	}

	public void setP_fbLjxmCb(BigDecimal p_fbLjxmCb) {
 
        this.p_fbLjxmCb = p_fbLjxmCb;

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