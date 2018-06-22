package com.server.pojo.url.tjbb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestDaysDetails implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "部门ID")
	private Integer deptOid= 0;
	@ApiModelProperty(value = "工程项目ID")
	private Integer projectOid= 0;
	@ApiModelProperty(value = "日期时间戳")
	private Long daysTimeStamp= 0L;

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

	public Long getDaysTimeStamp() { 

    	return this.daysTimeStamp;

	}

	public void setDaysTimeStamp(Long daysTimeStamp) {
 
        this.daysTimeStamp = daysTimeStamp;

	}


}