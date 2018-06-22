package com.server.pojo.url.base;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseCailiaoKemuFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "材料科目集合")
	private List<CbhsCailiaoKemu> result= new ArrayList<>();;
	@ApiModelProperty(value = "总数")
	private Long total= 0L;

	public List<CbhsCailiaoKemu> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsCailiaoKemu> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}


}