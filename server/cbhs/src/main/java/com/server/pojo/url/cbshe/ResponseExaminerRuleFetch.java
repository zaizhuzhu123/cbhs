package com.server.pojo.url.cbshe;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseExaminerRuleFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "审核规则集合")
	private List<CbhsCbExaminerRule> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;

	public List<CbhsCbExaminerRule> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsCbExaminerRule> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}


}