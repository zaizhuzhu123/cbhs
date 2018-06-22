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
@Table(name = "CbhsGlfyRule")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel(value="管理费用上缴公式对象",description="管理费用上缴公式对象")
public class CbhsGlfyRule implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键（临建项目）(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 主键（临建项目）(创建不填|修改必填)
	@Column(name = "projectOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|所属工程项目ID CbhsProject",required=false)
	private Integer projectOid= 0;// 必填|所属工程项目ID CbhsProject
	@Column(name = "p_sjgs_rule",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|上缴公司 ",required=false)
	private BigDecimal p_sjgs_rule= new BigDecimal(0);// 必填|上缴公司 
	@Column(name = "p_ztbfy_rule",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|招投标费用 ",required=false)
	private BigDecimal p_ztbfy_rule= new BigDecimal(0);// 必填|招投标费用 
	@Column(name = "p_kdqqysds_rule",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|跨地区企业所得税 ",required=false)
	private BigDecimal p_kdqqysds_rule= new BigDecimal(0);// 必填|跨地区企业所得税 
	@Column(name = "p_yhsjqtsj_rule",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|印花税及其他税金 ",required=false)
	private BigDecimal p_yhsjqtsj_rule= new BigDecimal(0);// 必填|印花税及其他税金 

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getProjectOid() { 

    	return this.projectOid;

	}

	public void setProjectOid(Integer projectOid) {
 
        this.projectOid = projectOid;

	}

	public BigDecimal getP_sjgs_rule() { 

    	return this.p_sjgs_rule;

	}

	public void setP_sjgs_rule(BigDecimal p_sjgs_rule) {
 
        this.p_sjgs_rule = p_sjgs_rule;

	}

	public BigDecimal getP_ztbfy_rule() { 

    	return this.p_ztbfy_rule;

	}

	public void setP_ztbfy_rule(BigDecimal p_ztbfy_rule) {
 
        this.p_ztbfy_rule = p_ztbfy_rule;

	}

	public BigDecimal getP_kdqqysds_rule() { 

    	return this.p_kdqqysds_rule;

	}

	public void setP_kdqqysds_rule(BigDecimal p_kdqqysds_rule) {
 
        this.p_kdqqysds_rule = p_kdqqysds_rule;

	}

	public BigDecimal getP_yhsjqtsj_rule() { 

    	return this.p_yhsjqtsj_rule;

	}

	public void setP_yhsjqtsj_rule(BigDecimal p_yhsjqtsj_rule) {
 
        this.p_yhsjqtsj_rule = p_yhsjqtsj_rule;

	}


}