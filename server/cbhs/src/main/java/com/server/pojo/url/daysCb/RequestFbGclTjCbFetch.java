package com.server.pojo.url.daysCb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestFbGclTjCbFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "主键")
	private Integer oid= 0;
	@ApiModelProperty(value = "部门ID")
	private Integer deptOid= 0;
	@ApiModelProperty(value = "工程量ID")
	private Integer fbGclYsOid= 0;
	@ApiModelProperty(value = "工程项目ID")
	private Integer projectOid= 0;
	@ApiModelProperty(value = "开始日期")
	private Long daysStart= 0L;
	@ApiModelProperty(value = "结束日期")
	private Long daysEnd= 0L;
	@ApiModelProperty(value = "页码")
	private Integer pageNum= 0;
	@ApiModelProperty(value = "数量")
	private Integer pageSize= 0;
	@ApiModelProperty(value = "开始ID")
	private Integer startOid= 0;
	@ApiModelProperty(value = "类型(1:大项|2:有单价的项)")
	private Integer type= 0;
	@ApiModelProperty(value = "审核状态 0所有 1 审核通过的")
	private Integer shStatus= 0;
	@ApiModelProperty(value = "合同ID")
	private Integer htID= 0;
	@ApiModelProperty(value = "合同名称")
	private String htName= "";
	@ApiModelProperty(value = "分包商ID")
	private Integer fbCompanyOid= 0;
	@ApiModelProperty(value = "分包商名称")
	private String fbCompanyName= "";
	@ApiModelProperty(value = "分包工程名称")
	private String fbGclYsName= "";

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getDeptOid() { 

    	return this.deptOid;

	}

	public void setDeptOid(Integer deptOid) {
 
        this.deptOid = deptOid;

	}

	public Integer getFbGclYsOid() { 

    	return this.fbGclYsOid;

	}

	public void setFbGclYsOid(Integer fbGclYsOid) {
 
        this.fbGclYsOid = fbGclYsOid;

	}

	public Integer getProjectOid() { 

    	return this.projectOid;

	}

	public void setProjectOid(Integer projectOid) {
 
        this.projectOid = projectOid;

	}

	public Long getDaysStart() { 

    	return this.daysStart;

	}

	public void setDaysStart(Long daysStart) {
 
        this.daysStart = daysStart;

	}

	public Long getDaysEnd() { 

    	return this.daysEnd;

	}

	public void setDaysEnd(Long daysEnd) {
 
        this.daysEnd = daysEnd;

	}

	public Integer getPageNum() { 

    	return this.pageNum;

	}

	public void setPageNum(Integer pageNum) {
 
        this.pageNum = pageNum;

	}

	public Integer getPageSize() { 

    	return this.pageSize;

	}

	public void setPageSize(Integer pageSize) {
 
        this.pageSize = pageSize;

	}

	public Integer getStartOid() { 

    	return this.startOid;

	}

	public void setStartOid(Integer startOid) {
 
        this.startOid = startOid;

	}

	public Integer getType() { 

    	return this.type;

	}

	public void setType(Integer type) {
 
        this.type = type;

	}

	public Integer getShStatus() { 

    	return this.shStatus;

	}

	public void setShStatus(Integer shStatus) {
 
        this.shStatus = shStatus;

	}

	public Integer getHtID() { 

    	return this.htID;

	}

	public void setHtID(Integer htID) {
 
        this.htID = htID;

	}

	public String getHtName() { 

    	return this.htName;

	}

	public void setHtName(String htName) {
 
        this.htName = htName;

	}

	public Integer getFbCompanyOid() { 

    	return this.fbCompanyOid;

	}

	public void setFbCompanyOid(Integer fbCompanyOid) {
 
        this.fbCompanyOid = fbCompanyOid;

	}

	public String getFbCompanyName() { 

    	return this.fbCompanyName;

	}

	public void setFbCompanyName(String fbCompanyName) {
 
        this.fbCompanyName = fbCompanyName;

	}

	public String getFbGclYsName() { 

    	return this.fbGclYsName;

	}

	public void setFbGclYsName(String fbGclYsName) {
 
        this.fbGclYsName = fbGclYsName;

	}


}