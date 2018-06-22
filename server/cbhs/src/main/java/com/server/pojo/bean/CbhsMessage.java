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
@Table(name = "CbhsMessage")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键",required=false)
	private Integer oid= 0;// 主键
	@Column(name = "personOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "用户ID",required=false)
	private Integer personOid= 0;// 用户ID
	@Column(name = "type", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "1 普通的文本消息 2 审核消息",required=false)
	private Integer type= 0;// 1 普通的文本消息 2 审核消息
	@Column(name = "title", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "标题",required=false)
	private String title= "";// 标题
	@Column(name = "message", length = 200, nullable = true, unique = false,columnDefinition="varchar(200) default ''")
	@ApiModelProperty(value = "内容",required=false)
	private String message= "";// 内容
	@Column(name = "alreadyRead", nullable = true, unique = false)
	@ApiModelProperty(value = "已阅读",required=false)
	private Boolean alreadyRead;// 已阅读
	@Column(name = "timeStr", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "消息时间",required=false)
	private String timeStr= "";// 消息时间
	@Column(name = "time", nullable = true, unique = false)
	@ApiModelProperty(value = "消息时间",required=false)
	private long  time;// 消息时间
	@Column(name = "examinerOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核ID",required=false)
	private Integer examinerOid= 0;// 审核ID
	@Column(name = "extStr", length = 500, nullable = true, unique = false,columnDefinition="varchar(500) default ''")
	@ApiModelProperty(value = "额外信息",required=false)
	private String extStr= "";// 额外信息

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getPersonOid() { 

    	return this.personOid;

	}

	public void setPersonOid(Integer personOid) {
 
        this.personOid = personOid;

	}

	public Integer getType() { 

    	return this.type;

	}

	public void setType(Integer type) {
 
        this.type = type;

	}

	public String getTitle() { 

    	return this.title;

	}

	public void setTitle(String title) {
 
        this.title = title;

	}

	public String getMessage() { 

    	return this.message;

	}

	public void setMessage(String message) {
 
        this.message = message;

	}

	public Boolean getAlreadyRead() { 

    	return this.alreadyRead;

	}

	public void setAlreadyRead(Boolean alreadyRead) {
 
        this.alreadyRead = alreadyRead;

	}

	public String getTimeStr() { 

    	return this.timeStr;

	}

	public void setTimeStr(String timeStr) {
 
        this.timeStr = timeStr;

	}

	public long getTime() { 

    	return this.time;

	}

	public void setTime(long time) {
 
        this.time = time;

	}

	public Integer getExaminerOid() { 

    	return this.examinerOid;

	}

	public void setExaminerOid(Integer examinerOid) {
 
        this.examinerOid = examinerOid;

	}

	public String getExtStr() { 

    	return this.extStr;

	}

	public void setExtStr(String extStr) {
 
        this.extStr = extStr;

	}


}