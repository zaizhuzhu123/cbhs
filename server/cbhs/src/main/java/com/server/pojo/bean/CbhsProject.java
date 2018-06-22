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
@Table(name = "CbhsProject")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsProject implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "工程项目主键ID(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 工程项目主键ID(创建不填|修改必填)
	@Column(name = "name", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|项目名称",required=false)
	private String name= "";// 必填|项目名称
	@Column(name = "startUpDate", nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "项目启动时间",required=false)
	private Long startUpDate= 0L;// 项目启动时间
	@Column(name = "state", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "项目状态 1进行中 2已结束",required=false)
	private Integer state= 0;// 项目状态 1进行中 2已结束
	@Column(name = "status",updatable = false, nullable = true, unique = false)
	@ApiModelProperty(value = "删除标识 true正常状态，未删除 false 已被删除",hidden=true,required=false)
	private Boolean status=true;// 删除标识 true正常状态，未删除 false 已被删除

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

	public Long getStartUpDate() { 

    	return this.startUpDate;

	}

	public void setStartUpDate(Long startUpDate) {
 
        this.startUpDate = startUpDate;

	}

	public Integer getState() { 

    	return this.state;

	}

	public void setState(Integer state) {
 
        this.state = state;

	}

	public Boolean getStatus() { 

    	return this.status;

	}

	public void setStatus(Boolean status) {
 
        this.status = status;

	}


}