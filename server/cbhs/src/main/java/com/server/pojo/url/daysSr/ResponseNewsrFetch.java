package com.server.pojo.url.daysSr;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseNewsrFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "新增收入集合")
	private List<CbhsDaysQtSr> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;
	@ApiModelProperty(value = "合计")
	private CbhsDaysQtSr  hj;

	public List<CbhsDaysQtSr> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsDaysQtSr> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}

	public CbhsDaysQtSr getHj() { 

    	return this.hj;

	}

	public void setHj(CbhsDaysQtSr hj) {
 
        this.hj = hj;

	}


}