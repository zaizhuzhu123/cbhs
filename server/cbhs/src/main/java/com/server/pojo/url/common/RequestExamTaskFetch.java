package com.server.pojo.url.common;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestExamTaskFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "任务ID")
	private Integer oid= 0;
	@ApiModelProperty(value = "部门ID")
	private Integer deptOid= 0;
	@ApiModelProperty(value = "成本创建人ID")
	private Integer personOid= 0;
	@ApiModelProperty(value = "页码")
	private Integer pageNum= 0;
	@ApiModelProperty(value = "数量")
	private Integer pageSize= 0;
	@ApiModelProperty(value = "开始ID")
	private Integer startOid= 0;
	@ApiModelProperty(value = "当前审核人")
	private Integer examPersonOid= 0;
	@ApiModelProperty(value = "任务状态")
	private Integer completeState= 0;
	@ApiModelProperty(value = "参与人员的ID")
	private Integer cyExamPersonOid= 0;

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

	public Integer getPersonOid() { 

    	return this.personOid;

	}

	public void setPersonOid(Integer personOid) {
 
        this.personOid = personOid;

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

	public Integer getExamPersonOid() { 

    	return this.examPersonOid;

	}

	public void setExamPersonOid(Integer examPersonOid) {
 
        this.examPersonOid = examPersonOid;

	}

	public Integer getCompleteState() { 

    	return this.completeState;

	}

	public void setCompleteState(Integer completeState) {
 
        this.completeState = completeState;

	}

	public Integer getCyExamPersonOid() { 

    	return this.cyExamPersonOid;

	}

	public void setCyExamPersonOid(Integer cyExamPersonOid) {
 
        this.cyExamPersonOid = cyExamPersonOid;

	}


}