package com.server.pojo.url.tjbb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseFbCompanyTj implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "")
	private List<uiFbCompanyTj> result= new ArrayList<>();;
	@ApiModelProperty(value = "")
	private Long total= 0L;
	@ApiModelProperty(value = "")
	private uiFbCompanyTj  hj;

	public List<uiFbCompanyTj> getResult() {
    	return this.result;
	}
	public void setResult(List<uiFbCompanyTj> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}

	public uiFbCompanyTj getHj() { 

    	return this.hj;

	}

	public void setHj(uiFbCompanyTj hj) {
 
        this.hj = hj;

	}


}