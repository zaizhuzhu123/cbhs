package com.server.pojo.url.monthMbYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseZyCailiaoCbYsFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "自营材料成本集合")
	private List<CbhsMonthZyCailiaoCbYs> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;
	@ApiModelProperty(value = "合计")
	private CbhsMonthZyCailiaoCbYs  hj;

	public List<CbhsMonthZyCailiaoCbYs> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsMonthZyCailiaoCbYs> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}

	public CbhsMonthZyCailiaoCbYs getHj() { 

    	return this.hj;

	}

	public void setHj(CbhsMonthZyCailiaoCbYs hj) {
 
        this.hj = hj;

	}


}