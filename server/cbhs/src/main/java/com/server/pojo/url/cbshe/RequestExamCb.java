package com.server.pojo.url.cbshe;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestExamCb implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "审核任务ID")
	private Integer examOid= 0;
	@ApiModelProperty(value = "审核通过(1批准 2拒绝)")
	private Integer shStatus= 0;
	@ApiModelProperty(value = "备注说明")
	private String remark= "";

	public Integer getExamOid() { 

    	return this.examOid;

	}

	public void setExamOid(Integer examOid) {
 
        this.examOid = examOid;

	}

	public Integer getShStatus() { 

    	return this.shStatus;

	}

	public void setShStatus(Integer shStatus) {
 
        this.shStatus = shStatus;

	}

	public String getRemark() { 

    	return this.remark;

	}

	public void setRemark(String remark) {
 
        this.remark = remark;

	}


}