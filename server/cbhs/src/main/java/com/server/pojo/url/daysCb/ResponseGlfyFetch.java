package com.server.pojo.url.daysCb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseGlfyFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "管理费用集合")
	private List<CbhsDaysGlfyYs> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;

	public List<CbhsDaysGlfyYs> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsDaysGlfyYs> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}


}