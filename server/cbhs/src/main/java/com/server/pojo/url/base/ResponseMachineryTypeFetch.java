package com.server.pojo.url.base;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseMachineryTypeFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "机械设备种类集合")
	private List<CbhsMachineryType> result= new ArrayList<>();;
	@ApiModelProperty(value = "总数")
	private Long total= 0L;

	public List<CbhsMachineryType> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsMachineryType> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}


}