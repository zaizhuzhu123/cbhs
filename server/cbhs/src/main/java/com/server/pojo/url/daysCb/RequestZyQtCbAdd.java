package com.server.pojo.url.daysCb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestZyQtCbAdd implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "自营机械成本")
	private CbhsDaysZyQtCb  cb;
	@ApiModelProperty(value = "提交方式(0默认提交 1审核提交)")
	private Integer submitType= 0;

	public CbhsDaysZyQtCb getCb() { 

    	return this.cb;

	}

	public void setCb(CbhsDaysZyQtCb cb) {
 
        this.cb = cb;

	}

	public Integer getSubmitType() { 

    	return this.submitType;

	}

	public void setSubmitType(Integer submitType) {
 
        this.submitType = submitType;

	}


}