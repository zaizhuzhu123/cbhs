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
@Table(name = "CbhsZdgxhsGZ")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsZdgxhsGZ implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键",required=false)
	private Integer oid= 0;// 主键
	@Column(name = "zytjOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "(重点工序核算)",required=false)
	private Integer zytjOid= 0;// (重点工序核算)
	@Column(name = "gzOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "工种编号",required=false)
	private Integer gzOid= 0;// 工种编号
	@Column(name = "grCount", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "工人数量",required=false)
	private Integer grCount= 0;// 工人数量
	@Column(name = "gzprice",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "工资",required=false)
	private BigDecimal gzprice= new BigDecimal(0);// 工资
	@Column(name = "gzhj",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "工资合计",required=false)
	private BigDecimal gzhj= new BigDecimal(0);// 工资合计

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

	public Integer getGzOid() { 

    	return this.gzOid;

	}

	public void setGzOid(Integer gzOid) {
 
        this.gzOid = gzOid;

	}

	public Integer getGrCount() { 

    	return this.grCount;

	}

	public void setGrCount(Integer grCount) {
 
        this.grCount = grCount;

	}

	public BigDecimal getGzprice() { 

    	return this.gzprice;

	}

	public void setGzprice(BigDecimal gzprice) {
 
        this.gzprice = gzprice;

	}

	public BigDecimal getGzhj() { 

    	return this.gzhj;

	}

	public void setGzhj(BigDecimal gzhj) {
 
        this.gzhj = gzhj;

	}


}