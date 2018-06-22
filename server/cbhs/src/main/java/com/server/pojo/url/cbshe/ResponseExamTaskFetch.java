package com.server.pojo.url.cbshe;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseExamTaskFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "审核任务集合")
	private List<CbhsCbExaminer> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;

	public List<CbhsCbExaminer> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsCbExaminer> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}


}