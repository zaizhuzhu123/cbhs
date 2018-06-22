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
@Table(name = "CbhsReimTerm")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel(value="财务报销详情对象",description="财务报销详情对象")
public class CbhsReimTerm implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键(报销ID)(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 主键(报销ID)(创建不填|修改必填)
	@Column(name = "reimOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "报销单ID",required=false)
	private Integer reimOid= 0;// 报销单ID
	@Column(name = "name", length = 100, nullable = true, unique = false,columnDefinition="varchar(100) default ''")
	@ApiModelProperty(value = "费用项目",required=false)
	private String name= "";// 费用项目
	@Column(name = "content", length = 500, nullable = true, unique = false,columnDefinition="varchar(500) default ''")
	@ApiModelProperty(value = "费用内容",required=false)
	private String content= "";// 费用内容
	@Column(name = "price",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "费用金额",required=false)
	private BigDecimal price= new BigDecimal(0);// 费用金额

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getReimOid() { 

    	return this.reimOid;

	}

	public void setReimOid(Integer reimOid) {
 
        this.reimOid = reimOid;

	}

	public String getName() { 

    	return this.name;

	}

	public void setName(String name) {
 
        this.name = name;

	}

	public String getContent() { 

    	return this.content;

	}

	public void setContent(String content) {
 
        this.content = content;

	}

	public BigDecimal getPrice() { 

    	return this.price;

	}

	public void setPrice(BigDecimal price) {
 
        this.price = price;

	}


}