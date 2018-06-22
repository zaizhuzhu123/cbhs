package com.server.pojo.url.clhx;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestZyGclFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "工程项目ID")
	private Integer projectOid= 0;
	@ApiModelProperty(value = "部门ID")
	private Integer deptOid= 0;
	@ApiModelProperty(value = "月份")
	private Long monthStart= 0L;
	@ApiModelProperty(value = "页码")
	private Long monthEnd= 0L;
	@ApiModelProperty(value = "数量")
	private Integer pageNum= 0;
	@ApiModelProperty(value = "开始ID")
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

	public Long getMonthStart() { 

    	return this.monthStart;

	}

	public void setMonthStart(Long monthStart) {
 
        this.monthStart = monthStart;

	}

	public Long getMonthEnd() { 

    	return this.monthEnd;

	}

	public void setMonthEnd(Long monthEnd) {
 
        this.monthEnd = monthEnd;

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