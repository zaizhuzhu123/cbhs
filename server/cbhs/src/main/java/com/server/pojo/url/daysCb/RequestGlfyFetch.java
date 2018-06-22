package com.server.pojo.url.daysCb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestGlfyFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "主键")
	private Integer oid= 0;
	@ApiModelProperty(value = "部门ID")
	private Integer deptOid= 0;
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


}