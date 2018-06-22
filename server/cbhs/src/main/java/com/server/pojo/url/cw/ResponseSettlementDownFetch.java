package com.server.pojo.url.cw;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseSettlementDownFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "对下结算集合")
	private List<CbhsSettleDown> result= new ArrayList<>();;
	@ApiModelProperty(value = "总数")
	private Long total= 0L;

	public List<CbhsSettleDown> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsSettleDown> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}


}