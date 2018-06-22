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
@Table(name = "CbhsLog")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsLog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键",required=false)
	private Integer oid= 0;// 主键
	@Column(name = "userOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "用户ID",required=false)
	private Integer userOid= 0;// 用户ID
	@Column(name = "ip", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "IP",required=false)
	private String ip= "";// IP
	@Column(name = "url", length = 1000, nullable = true, unique = false,columnDefinition="varchar(1000) default ''")
	@ApiModelProperty(value = "URL",required=false)
	private String url= "";// URL
	@Column(name = "method", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "请求方式",required=false)
	private String method= "";// 请求方式
	@Column(name = "paramQuery", length = 1000, nullable = true, unique = false,columnDefinition="varchar(1000) default ''")
	@ApiModelProperty(value = "query请求参数",required=false)
	private String paramQuery= "";// query请求参数
	@Column(name = "paramBody", length = 2000, nullable = true, unique = false,columnDefinition="varchar(2000) default ''")
	@ApiModelProperty(value = "body请求参数",required=false)
	private String paramBody= "";// body请求参数
	@Column(name = "time", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "请求发起时间",required=false)
	private String time= "";// 请求发起时间
	@Column(name = "timeUse", nullable = true, unique = false)
	@ApiModelProperty(value = "请求耗时 单位ms",required=false)
	private long  timeUse;// 请求耗时 单位ms

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getUserOid() { 

    	return this.userOid;

	}

	public void setUserOid(Integer userOid) {
 
        this.userOid = userOid;

	}

	public String getIp() { 

    	return this.ip;

	}

	public void setIp(String ip) {
 
        this.ip = ip;

	}

	public String getUrl() { 

    	return this.url;

	}

	public void setUrl(String url) {
 
        this.url = url;

	}

	public String getMethod() { 

    	return this.method;

	}

	public void setMethod(String method) {
 
        this.method = method;

	}

	public String getParamQuery() { 

    	return this.paramQuery;

	}

	public void setParamQuery(String paramQuery) {
 
        this.paramQuery = paramQuery;

	}

	public String getParamBody() { 

    	return this.paramBody;

	}

	public void setParamBody(String paramBody) {
 
        this.paramBody = paramBody;

	}

	public String getTime() { 

    	return this.time;

	}

	public void setTime(String time) {
 
        this.time = time;

	}

	public long getTimeUse() { 

    	return this.timeUse;

	}

	public void setTimeUse(long timeUse) {
 
        this.timeUse = timeUse;

	}


}