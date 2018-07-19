package com.server.pojo.url.daysCb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseZyLxygCbFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "自营零星用工成本集合")
	private List<CbhsDaysZyLxygCb> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;
	@ApiModelProperty(value = "合计")
	private CbhsDaysZyLxygCb  hj;

	public List<CbhsDaysZyLxygCb> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsDaysZyLxygCb> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}

	public CbhsDaysZyLxygCb getHj() { 

    	return this.hj;

	}

	public void setHj(CbhsDaysZyLxygCb hj) {
 
        this.hj = hj;

	}


}