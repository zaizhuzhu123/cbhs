package com.server.pojo.url.monthMbYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestMbYsTotalFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "工程项目ID")
	private Integer projectOid= 0;
	@ApiModelProperty(value = "部门编号 0为所有部门汇总")
	private Integer deptOid= 0;
	@ApiModelProperty(value = "月份")
	private Long month= 0L;

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


}