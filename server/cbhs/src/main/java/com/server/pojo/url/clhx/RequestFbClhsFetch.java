package com.server.pojo.url.clhx;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestFbClhsFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "")
	private Integer projectOid= 0;
	@ApiModelProperty(value = "")
	private Integer deptOid= 0;
	@ApiModelProperty(value = "")
	private Long month= 0L;
	@ApiModelProperty(value = "")
	private Integer globalGclYsOid= 0;
	@ApiModelProperty(value = "")
	private Integer pageNum= 0;
	@ApiModelProperty(value = "")
	private Integer pageSize= 0;

	public Integer getProjectOid() { 

    	return this.projectOid;

	}

	public void setProjectOid(Integer projectOid) {
 
        this.projectOid = projectOid;

	}

	public Integer getDeptOid() { 

    	return this.deptOid;

	}

	public void setDeptOid(Integer deptOid) {
 
        this.deptOid = deptOid;

	}

	public Long getMonth() { 

    	return this.month;

	}

	public void setMonth(Long month) {
 
        this.month = month;

	}

	public Integer getGlobalGclYsOid() { 

    	return this.globalGclYsOid;

	}

	public void setGlobalGclYsOid(Integer globalGclYsOid) {
 
        this.globalGclYsOid = globalGclYsOid;

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


}