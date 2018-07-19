package com.server.pojo.url.daysCb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseZyJxCbFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "")
	private List<CbhsDaysZyJxCb> result= new ArrayList<>();;
	@ApiModelProperty(value = "")
	private Long total= 0L;
	@ApiModelProperty(value = "")
	private CbhsDaysZyJxCb  hj;

	public List<CbhsDaysZyJxCb> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsDaysZyJxCb> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}

	public CbhsDaysZyJxCb getHj() { 

    	return this.hj;

	}

	public void setHj(CbhsDaysZyJxCb hj) {
 
        this.hj = hj;

	}


}