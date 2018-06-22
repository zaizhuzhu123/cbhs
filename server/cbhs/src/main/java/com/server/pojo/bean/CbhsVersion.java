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
@Table(name = "CbhsVersion")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@ApiModel(value="版本信息对象",description="版本信息对象")
public class CbhsVersion implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "主键ID",required=false)
	private Integer oid= 0;// 主键ID
	@Column(name = "opTimeStr", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "操作时间",required=false)
	private String opTimeStr= "";// 操作时间
	@Column(name = "opTime",updatable = false, nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "操作时间",required=false)
	private Long opTime= 0L;// 操作时间
	@Column(name = "versionCode", length = 50, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "版本号(例如1.0.0 就填100 这样 三位数)",required=false)
	private Integer versionCode= 0;// 版本号(例如1.0.0 就填100 这样 三位数)
	@Column(name = "pushtitle", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "推送标题",required=false)
	private String pushtitle= "";// 推送标题
	@Column(name = "pushAlert", length = 500, nullable = true, unique = false,columnDefinition="varchar(500) default ''")
	@ApiModelProperty(value = "推送内容",required=false)
	private String pushAlert= "";// 推送内容
	@Column(name = "remark", length = 2000, nullable = true, unique = false,columnDefinition="varchar(2000) default ''")
	@ApiModelProperty(value = "更新详情",required=false)
	private String remark= "";// 更新详情
	@Column(name = "fileOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "资源Oid 调用上传接口后 返回的文件ID",required=false)
	private Integer fileOid= 0;// 资源Oid 调用上传接口后 返回的文件ID

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

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

	public Integer getVersionCode() { 

    	return this.versionCode;

	}

	public void setVersionCode(Integer versionCode) {
 
        this.versionCode = versionCode;

	}

	public String getPushtitle() { 

    	return this.pushtitle;

	}

	public void setPushtitle(String pushtitle) {
 
        this.pushtitle = pushtitle;

	}

	public String getPushAlert() { 

    	return this.pushAlert;

	}

	public void setPushAlert(String pushAlert) {
 
        this.pushAlert = pushAlert;

	}

	public String getRemark() { 

    	return this.remark;

	}

	public void setRemark(String remark) {
 
        this.remark = remark;

	}

	public Integer getFileOid() { 

    	return this.fileOid;

	}

	public void setFileOid(Integer fileOid) {
 
        this.fileOid = fileOid;

	}


}