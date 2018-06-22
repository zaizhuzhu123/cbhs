package com.server.pojo.url.monthMbYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseMbYsTotalFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "结果")
	private List<uiCbhsMonthWebTotal> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;
	@ApiModelProperty(value = "月份所有部门总预算")
	private BigDecimal monthYsTotal= new BigDecimal(0);

	public List<uiCbhsMonthWebTotal> getResult() {
    	return this.result;
	}
	public void setResult(List<uiCbhsMonthWebTotal> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}

	public BigDecimal getMonthYsTotal() { 

    	return this.monthYsTotal;

	}

	public void setMonthYsTotal(BigDecimal monthYsTotal) {
 
        this.monthYsTotal = monthYsTotal;

	}


}