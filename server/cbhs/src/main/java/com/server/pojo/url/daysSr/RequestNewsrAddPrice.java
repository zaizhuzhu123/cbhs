package com.server.pojo.url.daysSr;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestNewsrAddPrice implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "数量收入ID")
	private Integer cbhsDaysQtSrOid= 0;
	@ApiModelProperty(value = "总金额")
	private BigDecimal price= new BigDecimal(0);
	@ApiModelProperty(value = "单价")
	private BigDecimal unitPrice= new BigDecimal(0);

	public Integer getCbhsDaysQtSrOid() { 

    	return this.cbhsDaysQtSrOid;

	}

	public void setCbhsDaysQtSrOid(Integer cbhsDaysQtSrOid) {
 
        this.cbhsDaysQtSrOid = cbhsDaysQtSrOid;

	}

	public BigDecimal getPrice() { 

    	return this.price;

	}

	public void setPrice(BigDecimal price) {
 
        this.price = price;

	}

	public BigDecimal getUnitPrice() { 

    	return this.unitPrice;

	}

	public void setUnitPrice(BigDecimal unitPrice) {
 
        this.unitPrice = unitPrice;

	}


}