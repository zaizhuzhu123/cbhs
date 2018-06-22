package com.server.pojo.url.cw;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestSettlementDownAdd implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "")
	private CbhsSettleDown  settle;
	@ApiModelProperty(value = "")
	private Integer submitType= 0;

	public CbhsSettleDown getSettle() { 

    	return this.settle;

	}

	public void setSettle(CbhsSettleDown settle) {
 
        this.settle = settle;

	}

	public Integer getSubmitType() { 

    	return this.submitType;

	}

	public void setSubmitType(Integer submitType) {
 
        this.submitType = submitType;

	}


}