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
@Table(name = "CbhsTest")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsTest implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键",required=false)
	private Integer oid= 0;// 主键
	@Column(name = "name", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "名称",required=false)
	private String name= "";// 名称
	@Column(name = "createTime",updatable = false, nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "创建时间",required=false)
	private Long createTime= 0L;// 创建时间
	@Column(name = "updateTime", nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "修改时间",required=false)
	private Long updateTime= 0L;// 修改时间
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "test1_oid", foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT) )
	@ApiModelProperty(value = "test1",required=false)
	private CbhsTest1  test1;// test1

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

	public CbhsTest1 getTest1() { 

    	return this.test1;

	}

	public void setTest1(CbhsTest1 test1) {
 
        this.test1 = test1;

	}


}