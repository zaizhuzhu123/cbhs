package com.server.pojo.url.daysCb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestFbLjxmCbJgAdd implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "数量统计ID")
	private Integer daysFbLjxmCbOid= 0;
	@ApiModelProperty(value = "总金额")
	private BigDecimal fbPrice= new BigDecimal(0);
	@ApiModelProperty(value = "单价")
	private BigDecimal fbUnitPrice= new BigDecimal(0);
	@ApiModelProperty(value = "提交方式(0默认提交 1审核提交)")
	private Integer submitType= 0;

	public Integer getDaysFbLjxmCbOid() { 

    	return this.daysFbLjxmCbOid;

	}

	public void setDaysFbLjxmCbOid(Integer daysFbLjxmCbOid) {
 
        this.daysFbLjxmCbOid = daysFbLjxmCbOid;

	}

	public BigDecimal getFbPrice() { 

    	return this.fbPrice;

	}

	public void setFbPrice(BigDecimal fbPrice) {
 
        this.fbPrice = fbPrice;

	}

	public BigDecimal getFbUnitPrice() { 

    	return this.fbUnitPrice;

	}

	public void setFbUnitPrice(BigDecimal fbUnitPrice) {
 
        this.fbUnitPrice = fbUnitPrice;

	}

	public Integer getSubmitType() { 

    	return this.submitType;

	}

	public void setSubmitType(Integer submitType) {
 
        this.submitType = submitType;

	}


}