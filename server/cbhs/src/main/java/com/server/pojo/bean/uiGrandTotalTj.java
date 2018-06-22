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
public class uiGrandTotalTj implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "cbTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "总支出",required=false)
	private BigDecimal cbTotal= new BigDecimal(0);// 总支出
	@Column(name = "srTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "总收入",required=false)
	private BigDecimal srTotal= new BigDecimal(0);// 总收入
	@Column(name = "ykTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "总盈亏",required=false)
	private BigDecimal ykTotal= new BigDecimal(0);// 总盈亏
	@Column(name = "deptGrandTotals", nullable = true, unique = false)
	@ApiModelProperty(value = "部门明细",required=false)
	private ArrayList<uiDeptGrandTotalTj>  deptGrandTotals;// 部门明细

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

	public ArrayList<uiDeptGrandTotalTj> getDeptGrandTotals() { 

    	return this.deptGrandTotals;

	}

	public void setDeptGrandTotals(ArrayList<uiDeptGrandTotalTj> deptGrandTotals) {
 
        this.deptGrandTotals = deptGrandTotals;

	}


}