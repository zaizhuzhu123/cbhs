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
@Table(name = "CbhsTest1")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsTest1 implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键",required=false)
	private Integer oid= 0;// 主键
	@Column(name = "test1name", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "名称",required=false)
	private String test1name= "";// 名称
	@Column(name = "createTime",updatable = false, nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "创建时间",required=false)
	private Long createTime= 0L;// 创建时间
	@Column(name = "updateTime", nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "修改时间",required=false)
	private Long updateTime= 0L;// 修改时间

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public String getTest1name() { 

    	return this.test1name;

	}

	public void setTest1name(String test1name) {
 
        this.test1name = test1name;

	}

	public Long getCreateTime() { 

    	return this.createTime;

	}

	public void setCreateTime(Long createTime) {
 
        this.createTime = createTime;

	}

	public Long getUpdateTime() { 

    	return this.updateTime;

	}

	public void setUpdateTime(Long updateTime) {
 
        this.updateTime = updateTime;

	}


}