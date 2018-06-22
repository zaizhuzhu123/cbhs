package com.server.pojo.url.monthMbYs;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
public class RequestMonthMbYsFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	private String month;
	private Integer deptOid;
	private Integer pageNum;
	private Integer pageSize;
	private Integer startOid;

	public String getMonth() { 

    	return this.month;

	}

	public void setMonth(String month) {
 
        this.month = month;

	}

	public Integer getDeptOid() { 

    	return this.deptOid;

	}

	public void setDeptOid(Integer deptOid) {
 
        this.deptOid = deptOid;

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


}