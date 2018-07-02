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
public class uiAbnormal implements Serializable {
	private static final long serialVersionUID = 1L;
	@Column(name = "srTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "总收入",required=false)
	private BigDecimal srTotal= new BigDecimal(0);// 总收入
	@Column(name = "cbTotal",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "总支出",required=false)
	private BigDecimal cbTotal= new BigDecimal(0);// 总支出
	@Column(name = "tjTime", nullable = true, unique = false)
	@ApiModelProperty(value = "统计时间",required=false)
	private long  tjTime;// 统计时间
	@Column(name = "abnormal", nullable = true, unique = false)
	@ApiModelProperty(value = "是否异常",required=false)
	private Boolean abnormal;// 是否异常

	public BigDecimal getSrTotal() { 

    	return this.srTotal;

	}

	public void setSrTotal(BigDecimal srTotal) {
 
        this.srTotal = srTotal;

	}

	public BigDecimal getCbTotal() { 

    	return this.cbTotal;

	}

	public void setCbTotal(BigDecimal cbTotal) {
 
        this.cbTotal = cbTotal;

	}

	public long getTjTime() { 

    	return this.tjTime;

	}

	public void setTjTime(long tjTime) {
 
        this.tjTime = tjTime;

	}

	public Boolean getAbnormal() { 

    	return this.abnormal;

	}

	public void setAbnormal(Boolean abnormal) {
 
        this.abnormal = abnormal;

	}


}