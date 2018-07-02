package com.server.pojo.url.tjbb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestCbAnalyze implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "工程项目ID")
	private Integer projectOid= 0;
	@ApiModelProperty(value = "开始月份")
	private Long monthStart= 0L;
	@ApiModelProperty(value = "结束月份")
	private Long monthEnd= 0L;

	public Integer getProjectOid() { 

    	return this.projectOid;

	}

	public void setProjectOid(Integer projectOid) {
 
        this.projectOid = projectOid;

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


}