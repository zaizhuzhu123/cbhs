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
@Table(name = "CbhsCailiao")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsCailiao implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "材料主键ID(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 材料主键ID(创建不填|修改必填)
	@Column(name = "kemuOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|所属科目",required=false)
	private Integer kemuOid= 0;// 必填|所属科目
	@Column(name = "kemuName", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|科目名称",required=false)
	private String kemuName= "";// 必填|科目名称
	@Column(name = "name", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|材料名称",required=false)
	private String name= "";// 必填|材料名称
	@Column(name = "style", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|规格",required=false)
	private String style= "";// 必填|规格
	@Column(name = "unit", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|单位",required=false)
	private String unit= "";// 必填|单位
	@Column(name = "unitPrice",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|单价",required=false)
	private BigDecimal unitPrice= new BigDecimal(0);// 必填|单价
	@Column(name = "status",updatable = false, nullable = true, unique = false)
	@ApiModelProperty(value = "删除标识 true正常状态，未删除 false 已被删除",hidden=true,required=false)
	private Boolean status=true;// 删除标识 true正常状态，未删除 false 已被删除

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getKemuOid() { 

    	return this.kemuOid;

	}

	public void setKemuOid(Integer kemuOid) {
 
        this.kemuOid = kemuOid;

	}

	public String getKemuName() { 

    	return this.kemuName;

	}

	public void setKemuName(String kemuName) {
 
        this.kemuName = kemuName;

	}

	public String getName() { 

    	return this.name;

	}

	public void setName(String name) {
 
        this.name = name;

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

	public BigDecimal getUnitPrice() { 

    	return this.unitPrice;

	}

	public void setUnitPrice(BigDecimal unitPrice) {
 
        this.unitPrice = unitPrice;

	}

	public Boolean getStatus() { 

    	return this.status;

	}

	public void setStatus(Boolean status) {
 
        this.status = status;

	}


}