package com.server.pojo.url.tjbb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestCbsrtj implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "工程项目ID")
	private Integer projectOid= 0;
	@ApiModelProperty(value = "开始日期")
	private Long daysStart= 0L;
	@ApiModelProperty(value = "结束日期")
	private Long daysEnd= 0L;

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


}