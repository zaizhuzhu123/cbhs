package com.server.pojo.url.monthMbYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseGlfyYsFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "管理费用集合")
	private List<CbhsMonthGlfyYs> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;
	@ApiModelProperty(value = "合计")
	private CbhsMonthGlfyYs  hj;

	public List<CbhsMonthGlfyYs> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsMonthGlfyYs> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}

	public CbhsMonthGlfyYs getHj() { 

    	return this.hj;

	}

	public void setHj(CbhsMonthGlfyYs hj) {
 
        this.hj = hj;

	}


}