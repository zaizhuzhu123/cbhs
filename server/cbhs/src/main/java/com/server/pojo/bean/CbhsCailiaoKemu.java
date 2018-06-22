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
@Table(name = "CbhsCailiaoKemu")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsCailiaoKemu implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "材料科目主键ID(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 材料科目主键ID(创建不填|修改必填)
	@Column(name = "name", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|材料科目名称",required=false)
	private String name= "";// 必填|材料科目名称
	@Column(name = "status",updatable = false, nullable = true, unique = false)
	@ApiModelProperty(value = "删除标识 true正常状态，未删除 false 已被删除",hidden=true,required=false)
	private Boolean status=true;// 删除标识 true正常状态，未删除 false 已被删除
	@Column(name = "isRy",updatable = false, nullable = true, unique = false)
	@ApiModelProperty(value = "必填|是否属于燃油类别",required=false)
	private Boolean isRy;// 必填|是否属于燃油类别

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public String getName() { 

    	return this.name;

	}

	public void setName(String name) {
 
        this.name = name;

	}

	public Boolean getStatus() { 

    	return this.status;

	}

	public void setStatus(Boolean status) {
 
        this.status = status;

	}

	public Boolean getIsRy() { 

    	return this.isRy;

	}

	public void setIsRy(Boolean isRy) {
 
        this.isRy = isRy;

	}


}