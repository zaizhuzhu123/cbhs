package com.server.pojo.url.daysCb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseFbGclTjCbFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "分包工程量集合")
	private List<CbhsDaysFbGclTj> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;
	@ApiModelProperty(value = "合计")
	private CbhsDaysFbGclTj  hj;

	public List<CbhsDaysFbGclTj> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsDaysFbGclTj> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}

	public CbhsDaysFbGclTj getHj() { 

    	return this.hj;

	}

	public void setHj(CbhsDaysFbGclTj hj) {
 
        this.hj = hj;

	}


}