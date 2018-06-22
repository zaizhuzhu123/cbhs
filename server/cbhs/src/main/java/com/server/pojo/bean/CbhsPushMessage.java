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
@Table(name = "CbhsPushMessage")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsPushMessage implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键",required=false)
	private Integer oid= 0;// 主键
	@Column(name = "state", nullable = true, unique = false)
	@ApiModelProperty(value = "推送状态 1 已推送 0未推送",required=false)
	private Boolean state;// 推送状态 1 已推送 0未推送
	@Column(name = "title", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "标题",required=false)
	private String title= "";// 标题
	@Column(name = "alert", length = 200, nullable = true, unique = false,columnDefinition="varchar(200) default ''")
	@ApiModelProperty(value = "内容",required=false)
	private String alert= "";// 内容
	@Column(name = "message", length = 200, nullable = true, unique = false,columnDefinition="varchar(200) default ''")
	@ApiModelProperty(value = "内容",required=false)
	private String message= "";// 内容
	@Column(name = "timeStr", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "消息时间",required=false)
	private String timeStr= "";// 消息时间
	@Column(name = "time", nullable = true, unique = false)
	@ApiModelProperty(value = "消息时间",required=false)
	private long  time;// 消息时间
	@Column(name = "pushedStr", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "推送时间",required=false)
	private String pushedStr= "";// 推送时间
	@Column(name = "pushedTime", nullable = true, unique = false)
	@ApiModelProperty(value = "推送时间",required=false)
	private long  pushedTime;// 推送时间
	@Column(name = "extStr", length = 500, nullable = true, unique = false,columnDefinition="varchar(500) default ''")
	@ApiModelProperty(value = "额外信息",required=false)
	private String extStr= "";// 额外信息
	@Column(name = "personOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "用户ID",required=false)
	private Integer personOid= 0;// 用户ID
	@Column(name = "examinerOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "审核ID",required=false)
	private Integer examinerOid= 0;// 审核ID

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Boolean getState() { 

    	return this.state;

	}

	public void setState(Boolean state) {
 
        this.state = state;

	}

	public String getTitle() { 

    	return this.title;

	}

	public void setTitle(String title) {
 
        this.title = title;

	}

	public String getAlert() { 

    	return this.alert;

	}

	public void setAlert(String alert) {
 
        this.alert = alert;

	}

	public String getMessage() { 

    	return this.message;

	}

	public void setMessage(String message) {
 
        this.message = message;

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

	public String getPushedStr() { 

    	return this.pushedStr;

	}

	public void setPushedStr(String pushedStr) {
 
        this.pushedStr = pushedStr;

	}

	public long getPushedTime() { 

    	return this.pushedTime;

	}

	public void setPushedTime(long pushedTime) {
 
        this.pushedTime = pushedTime;

	}

	public String getExtStr() { 

    	return this.extStr;

	}

	public void setExtStr(String extStr) {
 
        this.extStr = extStr;

	}

	public Integer getPersonOid() { 

    	return this.personOid;

	}

	public void setPersonOid(Integer personOid) {
 
        this.personOid = personOid;

	}

	public Integer getExaminerOid() { 

    	return this.examinerOid;

	}

	public void setExaminerOid(Integer examinerOid) {
 
        this.examinerOid = examinerOid;

	}


}