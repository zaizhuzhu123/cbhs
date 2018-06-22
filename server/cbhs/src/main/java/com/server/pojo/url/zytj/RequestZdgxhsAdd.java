package com.server.pojo.url.zytj;

import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestZdgxhsAdd implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "重点工序核算")
	private CbhsZdgxhs  cb;
	@ApiModelProperty(value = "提交方式(0默认提交 1审核提交)")
	private Integer submitType= 0;

	public CbhsZdgxhs getCb() { 

    	return this.cb;

	}

	public void setCb(CbhsZdgxhs cb) {
 
        this.cb = cb;

	}

	public Integer getSubmitType() { 

    	return this.submitType;

	}

	public void setSubmitType(Integer submitType) {
 
        this.submitType = submitType;

	}


}