package com.server.pojo.url.tjbb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestFbCompanyTj implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "工程项目ID")
	private Integer projectOid= 0;
	@ApiModelProperty(value = "开始日期")
	private Long daysStart= 0L;
	@ApiModelProperty(value = "结束日期")
	private Long daysEnd= 0L;
	@ApiModelProperty(value = "分包商ID")
	private Integer fbCompanyOid= 0;
	@ApiModelProperty(value = "分包工程ID")
	private Integer fbGclYsOid= 0;
	@ApiModelProperty(value = "页码")
	private Integer pageNum= 0;
	@ApiModelProperty(value = "数量")
	private Integer pageSize= 0;
	@ApiModelProperty(value = "开始编号")
	private Integer startOid= 0;

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

	public Integer getFbCompanyOid() { 

    	return this.fbCompanyOid;

	}

	public void setFbCompanyOid(Integer fbCompanyOid) {
 
        this.fbCompanyOid = fbCompanyOid;

	}

	public Integer getFbGclYsOid() { 

    	return this.fbGclYsOid;

	}

	public void setFbGclYsOid(Integer fbGclYsOid) {
 
        this.fbGclYsOid = fbGclYsOid;

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