package com.server.pojo.url.common;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseDeptFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "部门信息集合")
	private List<CbhsDept> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;

	public List<CbhsDept> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsDept> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}


}