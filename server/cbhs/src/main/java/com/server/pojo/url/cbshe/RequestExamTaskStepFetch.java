package com.server.pojo.url.cbshe;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestExamTaskStepFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "审核任务ID")
	private Integer examOid= 0;
	@ApiModelProperty(value = "页码")
	private Integer pageNum= 0;
	@ApiModelProperty(value = "数量")
	private Integer pageSize= 0;
	@ApiModelProperty(value = "开始ID")
	private Integer startOid= 0;

	public Integer getExamOid() { 

    	return this.examOid;

	}

	public void setExamOid(Integer examOid) {
 
        this.examOid = examOid;

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