package com.server.pojo.url.cbshe;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseExamTaskStepFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "审核任务步骤")
	private List<CbhsCbExaminerStep> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;

	public List<CbhsCbExaminerStep> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsCbExaminerStep> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}


}