package com.server.pojo.url.monthMbYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseFbCailiaoCbYsFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "分包材料成本集合")
	private List<CbhsMonthFbCailiaoCbYs> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;
	@ApiModelProperty(value = "合计")
	private CbhsMonthFbCailiaoCbYs  hj;

	public List<CbhsMonthFbCailiaoCbYs> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsMonthFbCailiaoCbYs> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}

	public CbhsMonthFbCailiaoCbYs getHj() { 

    	return this.hj;

	}

	public void setHj(CbhsMonthFbCailiaoCbYs hj) {
 
        this.hj = hj;

	}


}