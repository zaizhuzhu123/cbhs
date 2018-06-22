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
@Table(name = "CbhsResource")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsResource implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键(资源ID)",required=false)
	private Integer oid= 0;// 主键(资源ID)
	@Column(name = "filePath", length = 2000, nullable = true, unique = false,columnDefinition="varchar(2000) default ''")
	@ApiModelProperty(value = "文件路径",required=false)
	private String filePath= "";// 文件路径
	@Column(name = "url", length = 2000, nullable = true, unique = false,columnDefinition="varchar(2000) default ''")
	@ApiModelProperty(value = "访问路径",required=false)
	private String url= "";// 访问路径
	@Column(name = "oldFileName", length = 2000, nullable = true, unique = false,columnDefinition="varchar(2000) default ''")
	@ApiModelProperty(value = "上传的原文件名",required=false)
	private String oldFileName= "";// 上传的原文件名
	@Column(name = "fileSize", nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "文件大小",required=false)
	private Long fileSize= 0L;// 文件大小
	@Column(name = "contentType", length = 500, nullable = true, unique = false,columnDefinition="varchar(500) default ''")
	@ApiModelProperty(value = "contentType",required=false)
	private String contentType= "";// contentType
	@Column(name = "prefix", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "后缀名",required=false)
	private String prefix= "";// 后缀名
	@Column(name = "opUserOid",updatable = false, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "操作人ID",hidden=true,required=false)
	private Integer opUserOid= 0;// 操作人ID
	@Column(name = "opUserName", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "操作人姓名",hidden=true,required=false)
	private String opUserName= "";// 操作人姓名
	@Column(name = "opTimeStr", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "操作时间",hidden=true,required=false)
	private String opTimeStr= "";// 操作时间
	@Column(name = "opTime",updatable = false, nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "操作时间",hidden=true,required=false)
	private Long opTime= 0L;// 操作时间

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public String getFilePath() { 

    	return this.filePath;

	}

	public void setFilePath(String filePath) {
 
        this.filePath = filePath;

	}

	public String getUrl() { 

    	return this.url;

	}

	public void setUrl(String url) {
 
        this.url = url;

	}

	public String getOldFileName() { 

    	return this.oldFileName;

	}

	public void setOldFileName(String oldFileName) {
 
        this.oldFileName = oldFileName;

	}

	public Long getFileSize() { 

    	return this.fileSize;

	}

	public void setFileSize(Long fileSize) {
 
        this.fileSize = fileSize;

	}

	public String getContentType() { 

    	return this.contentType;

	}

	public void setContentType(String contentType) {
 
        this.contentType = contentType;

	}

	public String getPrefix() { 

    	return this.prefix;

	}

	public void setPrefix(String prefix) {
 
        this.prefix = prefix;

	}

	public Integer getOpUserOid() { 

    	return this.opUserOid;

	}

	public void setOpUserOid(Integer opUserOid) {
 
        this.opUserOid = opUserOid;

	}

	public String getOpUserName() { 

    	return this.opUserName;

	}

	public void setOpUserName(String opUserName) {
 
        this.opUserName = opUserName;

	}

	public String getOpTimeStr() { 

    	return this.opTimeStr;

	}

	public void setOpTimeStr(String opTimeStr) {
 
        this.opTimeStr = opTimeStr;

	}

	public Long getOpTime() { 

    	return this.opTime;

	}

	public void setOpTime(Long opTime) {
 
        this.opTime = opTime;

	}


}