package com.server.pojo.url.cw;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestReimAdd implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "")
	private CbhsReim  reim;
	@ApiModelProperty(value = "")
	private Integer submitType= 0;

	public CbhsReim getReim() { 

    	return this.reim;

	}

	public void setReim(CbhsReim reim) {
 
        this.reim = reim;

	}

	public Integer getSubmitType() { 

    	return this.submitType;

	}

	public void setSubmitType(Integer submitType) {
 
        this.submitType = submitType;

	}


}