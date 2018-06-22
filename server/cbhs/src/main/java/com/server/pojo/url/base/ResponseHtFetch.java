package com.server.pojo.url.base;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseHtFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "合同集合")
	private List<CbhsHt> result= new ArrayList<>();;
	@ApiModelProperty(value = "总数")
	private Long total= 0L;

	public List<CbhsHt> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsHt> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}


}