package com.server.pojo.url.cw;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestReimShe implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "财务报销ID")
	private Integer oid= 0;
	@ApiModelProperty(value = "批准金额")
	private BigDecimal cwTotal= new BigDecimal(0);
	@ApiModelProperty(value = "审核通过(1批准 2拒绝)")
	private Integer shStatus= 0;

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public BigDecimal getCwTotal() { 

    	return this.cwTotal;

	}

	public void setCwTotal(BigDecimal cwTotal) {
 
        this.cwTotal = cwTotal;

	}

	public Integer getShStatus() { 

    	return this.shStatus;

	}

	public void setShStatus(Integer shStatus) {
 
        this.shStatus = shStatus;

	}


}