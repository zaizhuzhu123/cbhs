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
public class uiCbAnalyze implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "cbTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "总支出",required=false)
	private BigDecimal cbTotal= new BigDecimal(0);// 总支出
	@Column(name = "srTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "总收入",required=false)
	private BigDecimal srTotal= new BigDecimal(0);// 总收入
	@Column(name = "rlTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "人力总支出",required=false)
	private BigDecimal rlTotal= new BigDecimal(0);// 人力总支出
	@Column(name = "rlSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "人力占的比重",required=false)
	private BigDecimal rlSpecific= new BigDecimal(0);// 人力占的比重
	@Column(name = "cailiaoTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "材料总支出",required=false)
	private BigDecimal cailiaoTotal= new BigDecimal(0);// 材料总支出
	@Column(name = "cailiaoSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "材料占的比重",required=false)
	private BigDecimal cailiaoSpecific= new BigDecimal(0);// 材料占的比重
	@Column(name = "jxTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "机械总支出",required=false)
	private BigDecimal jxTotal= new BigDecimal(0);// 机械总支出
	@Column(name = "jxSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "机械占的比重",required=false)
	private BigDecimal jxSpecific= new BigDecimal(0);// 机械占的比重
	@Column(name = "qttotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "其他直接成本总支出",required=false)
	private BigDecimal qttotal= new BigDecimal(0);// 其他直接成本总支出
	@Column(name = "qtSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "其他直接占的比重",required=false)
	private BigDecimal qtSpecific= new BigDecimal(0);// 其他直接占的比重
	@Column(name = "fbgctotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包工程总支出",required=false)
	private BigDecimal fbgctotal= new BigDecimal(0);// 分包工程总支出
	@Column(name = "fbgcSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包工程占的比重",required=false)
	private BigDecimal fbgcSpecific= new BigDecimal(0);// 分包工程占的比重
	@Column(name = "fbljxmtotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包临建项目总支出",required=false)
	private BigDecimal fbljxmtotal= new BigDecimal(0);// 分包临建项目总支出
	@Column(name = "fbljxmSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包临建项目占的比重",required=false)
	private BigDecimal fbljxmSpecific= new BigDecimal(0);// 分包临建项目占的比重
	@Column(name = "rygztotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "人员工资总支出",required=false)
	private BigDecimal rygztotal= new BigDecimal(0);// 人员工资总支出
	@Column(name = "rygzSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "人员工资占的比重",required=false)
	private BigDecimal rygzSpecific= new BigDecimal(0);// 人员工资占的比重
	@Column(name = "clftotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "差旅费总支出",required=false)
	private BigDecimal clftotal= new BigDecimal(0);// 差旅费总支出
	@Column(name = "clfSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "差旅费占的比重",required=false)
	private BigDecimal clfSpecific= new BigDecimal(0);// 差旅费占的比重
	@Column(name = "bgftotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "办公费总支出",required=false)
	private BigDecimal bgftotal= new BigDecimal(0);// 办公费总支出
	@Column(name = "bgfSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "办公费占的比重",required=false)
	private BigDecimal bgfSpecific= new BigDecimal(0);// 办公费占的比重
	@Column(name = "ywjftotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "业务经费总支出",required=false)
	private BigDecimal ywjftotal= new BigDecimal(0);// 业务经费总支出
	@Column(name = "ywjfSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "业务经费占的比重",required=false)
	private BigDecimal ywjfSpecific= new BigDecimal(0);// 业务经费占的比重
	@Column(name = "xlftotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "修理费总支出",required=false)
	private BigDecimal xlftotal= new BigDecimal(0);// 修理费总支出
	@Column(name = "xlfSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "修理费占的比重",required=false)
	private BigDecimal xlfSpecific= new BigDecimal(0);// 修理费占的比重
	@Column(name = "qtfytotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "其他费用总支出",required=false)
	private BigDecimal qtfytotal= new BigDecimal(0);// 其他费用总支出
	@Column(name = "qtfySpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "其他费用占的比重",required=false)
	private BigDecimal qtfySpecific= new BigDecimal(0);// 其他费用占的比重
	@Column(name = "qyjgfytotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "企业经管费用总支出",required=false)
	private BigDecimal qyjgfytotal= new BigDecimal(0);// 企业经管费用总支出
	@Column(name = "qyjgfySpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "企业经管费用占的比重",required=false)
	private BigDecimal qyjgfySpecific= new BigDecimal(0);// 企业经管费用占的比重
	@Column(name = "sjtotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "税金总支出",required=false)
	private BigDecimal sjtotal= new BigDecimal(0);// 税金总支出
	@Column(name = "sjSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "税金占的比重",required=false)
	private BigDecimal sjSpecific= new BigDecimal(0);// 税金占的比重
	@Column(name = "fbstjtotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包商统计总支出",required=false)
	private BigDecimal fbstjtotal= new BigDecimal(0);// 分包商统计总支出
	@Column(name = "fbstjSpecific",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "分包商统计占的比重",required=false)
	private BigDecimal fbstjSpecific= new BigDecimal(0);// 分包商统计占的比重

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

	public BigDecimal getRlTotal() { 

    	return this.rlTotal;

	}

	public void setRlTotal(BigDecimal rlTotal) {
 
        this.rlTotal = rlTotal;

	}

	public BigDecimal getRlSpecific() { 

    	return this.rlSpecific;

	}

	public void setRlSpecific(BigDecimal rlSpecific) {
 
        this.rlSpecific = rlSpecific;

	}

	public BigDecimal getCailiaoTotal() { 

    	return this.cailiaoTotal;

	}

	public void setCailiaoTotal(BigDecimal cailiaoTotal) {
 
        this.cailiaoTotal = cailiaoTotal;

	}

	public BigDecimal getCailiaoSpecific() { 

    	return this.cailiaoSpecific;

	}

	public void setCailiaoSpecific(BigDecimal cailiaoSpecific) {
 
        this.cailiaoSpecific = cailiaoSpecific;

	}

	public BigDecimal getJxTotal() { 

    	return this.jxTotal;

	}

	public void setJxTotal(BigDecimal jxTotal) {
 
        this.jxTotal = jxTotal;

	}

	public BigDecimal getJxSpecific() { 

    	return this.jxSpecific;

	}

	public void setJxSpecific(BigDecimal jxSpecific) {
 
        this.jxSpecific = jxSpecific;

	}

	public BigDecimal getQttotal() { 

    	return this.qttotal;

	}

	public void setQttotal(BigDecimal qttotal) {
 
        this.qttotal = qttotal;

	}

	public BigDecimal getQtSpecific() { 

    	return this.qtSpecific;

	}

	public void setQtSpecific(BigDecimal qtSpecific) {
 
        this.qtSpecific = qtSpecific;

	}

	public BigDecimal getFbgctotal() { 

    	return this.fbgctotal;

	}

	public void setFbgctotal(BigDecimal fbgctotal) {
 
        this.fbgctotal = fbgctotal;

	}

	public BigDecimal getFbgcSpecific() { 

    	return this.fbgcSpecific;

	}

	public void setFbgcSpecific(BigDecimal fbgcSpecific) {
 
        this.fbgcSpecific = fbgcSpecific;

	}

	public BigDecimal getFbljxmtotal() { 

    	return this.fbljxmtotal;

	}

	public void setFbljxmtotal(BigDecimal fbljxmtotal) {
 
        this.fbljxmtotal = fbljxmtotal;

	}

	public BigDecimal getFbljxmSpecific() { 

    	return this.fbljxmSpecific;

	}

	public void setFbljxmSpecific(BigDecimal fbljxmSpecific) {
 
        this.fbljxmSpecific = fbljxmSpecific;

	}

	public BigDecimal getRygztotal() { 

    	return this.rygztotal;

	}

	public void setRygztotal(BigDecimal rygztotal) {
 
        this.rygztotal = rygztotal;

	}

	public BigDecimal getRygzSpecific() { 

    	return this.rygzSpecific;

	}

	public void setRygzSpecific(BigDecimal rygzSpecific) {
 
        this.rygzSpecific = rygzSpecific;

	}

	public BigDecimal getClftotal() { 

    	return this.clftotal;

	}

	public void setClftotal(BigDecimal clftotal) {
 
        this.clftotal = clftotal;

	}

	public BigDecimal getClfSpecific() { 

    	return this.clfSpecific;

	}

	public void setClfSpecific(BigDecimal clfSpecific) {
 
        this.clfSpecific = clfSpecific;

	}

	public BigDecimal getBgftotal() { 

    	return this.bgftotal;

	}

	public void setBgftotal(BigDecimal bgftotal) {
 
        this.bgftotal = bgftotal;

	}

	public BigDecimal getBgfSpecific() { 

    	return this.bgfSpecific;

	}

	public void setBgfSpecific(BigDecimal bgfSpecific) {
 
        this.bgfSpecific = bgfSpecific;

	}

	public BigDecimal getYwjftotal() { 

    	return this.ywjftotal;

	}

	public void setYwjftotal(BigDecimal ywjftotal) {
 
        this.ywjftotal = ywjftotal;

	}

	public BigDecimal getYwjfSpecific() { 

    	return this.ywjfSpecific;

	}

	public void setYwjfSpecific(BigDecimal ywjfSpecific) {
 
        this.ywjfSpecific = ywjfSpecific;

	}

	public BigDecimal getXlftotal() { 

    	return this.xlftotal;

	}

	public void setXlftotal(BigDecimal xlftotal) {
 
        this.xlftotal = xlftotal;

	}

	public BigDecimal getXlfSpecific() { 

    	return this.xlfSpecific;

	}

	public void setXlfSpecific(BigDecimal xlfSpecific) {
 
        this.xlfSpecific = xlfSpecific;

	}

	public BigDecimal getQtfytotal() { 

    	return this.qtfytotal;

	}

	public void setQtfytotal(BigDecimal qtfytotal) {
 
        this.qtfytotal = qtfytotal;

	}

	public BigDecimal getQtfySpecific() { 

    	return this.qtfySpecific;

	}

	public void setQtfySpecific(BigDecimal qtfySpecific) {
 
        this.qtfySpecific = qtfySpecific;

	}

	public BigDecimal getQyjgfytotal() { 

    	return this.qyjgfytotal;

	}

	public void setQyjgfytotal(BigDecimal qyjgfytotal) {
 
        this.qyjgfytotal = qyjgfytotal;

	}

	public BigDecimal getQyjgfySpecific() { 

    	return this.qyjgfySpecific;

	}

	public void setQyjgfySpecific(BigDecimal qyjgfySpecific) {
 
        this.qyjgfySpecific = qyjgfySpecific;

	}

	public BigDecimal getSjtotal() { 

    	return this.sjtotal;

	}

	public void setSjtotal(BigDecimal sjtotal) {
 
        this.sjtotal = sjtotal;

	}

	public BigDecimal getSjSpecific() { 

    	return this.sjSpecific;

	}

	public void setSjSpecific(BigDecimal sjSpecific) {
 
        this.sjSpecific = sjSpecific;

	}

	public BigDecimal getFbstjtotal() { 

    	return this.fbstjtotal;

	}

	public void setFbstjtotal(BigDecimal fbstjtotal) {
 
        this.fbstjtotal = fbstjtotal;

	}

	public BigDecimal getFbstjSpecific() { 

    	return this.fbstjSpecific;

	}

	public void setFbstjSpecific(BigDecimal fbstjSpecific) {
 
        this.fbstjSpecific = fbstjSpecific;

	}


}