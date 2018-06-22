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
public class uiDaysCbDetailTj implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "jjcb",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "间接成本",required=false)
	private BigDecimal jjcb= new BigDecimal(0);// 间接成本
	@Column(name = "zycailiaocb",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "自营材料成本",required=false)
	private BigDecimal zycailiaocb= new BigDecimal(0);// 自营材料成本
	@Column(name = "zyjxcb",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "自营机械成本",required=false)
	private BigDecimal zyjxcb= new BigDecimal(0);// 自营机械成本
	@Column(name = "lxyg",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "零星用工",required=false)
	private BigDecimal lxyg= new BigDecimal(0);// 零星用工
	@Column(name = "qtfy",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "其他费用",required=false)
	private BigDecimal qtfy= new BigDecimal(0);// 其他费用
	@Column(name = "fbcb",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包成本费用",required=false)
	private BigDecimal fbcb= new BigDecimal(0);// 分包成本费用
	@Column(name = "fbcailiaocb",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包材料成本",required=false)
	private BigDecimal fbcailiaocb= new BigDecimal(0);// 分包材料成本
	@Column(name = "ljxm",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "临建项目",required=false)
	private BigDecimal ljxm= new BigDecimal(0);// 临建项目
	@Column(name = "glfy",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "管理费用",required=false)
	private BigDecimal glfy= new BigDecimal(0);// 管理费用
	@Column(name = "cbTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "总支出",required=false)
	private BigDecimal cbTotal= new BigDecimal(0);// 总支出
	@Column(name = "srTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "总收入",required=false)
	private BigDecimal srTotal= new BigDecimal(0);// 总收入
	@Column(name = "ykTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "总盈亏",required=false)
	private BigDecimal ykTotal= new BigDecimal(0);// 总盈亏

	public BigDecimal getJjcb() { 

    	return this.jjcb;

	}

	public void setJjcb(BigDecimal jjcb) {
 
        this.jjcb = jjcb;

	}

	public BigDecimal getZycailiaocb() { 

    	return this.zycailiaocb;

	}

	public void setZycailiaocb(BigDecimal zycailiaocb) {
 
        this.zycailiaocb = zycailiaocb;

	}

	public BigDecimal getZyjxcb() { 

    	return this.zyjxcb;

	}

	public void setZyjxcb(BigDecimal zyjxcb) {
 
        this.zyjxcb = zyjxcb;

	}

	public BigDecimal getLxyg() { 

    	return this.lxyg;

	}

	public void setLxyg(BigDecimal lxyg) {
 
        this.lxyg = lxyg;

	}

	public BigDecimal getQtfy() { 

    	return this.qtfy;

	}

	public void setQtfy(BigDecimal qtfy) {
 
        this.qtfy = qtfy;

	}

	public BigDecimal getFbcb() { 

    	return this.fbcb;

	}

	public void setFbcb(BigDecimal fbcb) {
 
        this.fbcb = fbcb;

	}

	public BigDecimal getFbcailiaocb() { 

    	return this.fbcailiaocb;

	}

	public void setFbcailiaocb(BigDecimal fbcailiaocb) {
 
        this.fbcailiaocb = fbcailiaocb;

	}

	public BigDecimal getLjxm() { 

    	return this.ljxm;

	}

	public void setLjxm(BigDecimal ljxm) {
 
        this.ljxm = ljxm;

	}

	public BigDecimal getGlfy() { 

    	return this.glfy;

	}

	public void setGlfy(BigDecimal glfy) {
 
        this.glfy = glfy;

	}

	public BigDecimal getCbTotal() { 

    	return this.cbTotal;

	}

	public void setCbTotal(BigDecimal cbTotal) {
 
        this.cbTotal = cbTotal;

	}

	public BigDecimal getSrTotal() { 

    	return this.srTotal;

	}

	public void setSrTotal(BigDecimal srTotal) {
 
        this.srTotal = srTotal;

	}

	public BigDecimal getYkTotal() { 

    	return this.ykTotal;

	}

	public void setYkTotal(BigDecimal ykTotal) {
 
        this.ykTotal = ykTotal;

	}


}