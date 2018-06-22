package com.server.pojo.url.globalYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseGlobalFyzYsFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "费用总预算集合")
	private List<CbhsGlobalFyzYs> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;
	@ApiModelProperty(value = "总费用")
	private BigDecimal priceTotal= new BigDecimal(0);

	public List<CbhsGlobalFyzYs> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsGlobalFyzYs> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}

	public BigDecimal getPriceTotal() { 

    	return this.priceTotal;

	}

	public void setPriceTotal(BigDecimal priceTotal) {
 
        this.priceTotal = priceTotal;

	}


}