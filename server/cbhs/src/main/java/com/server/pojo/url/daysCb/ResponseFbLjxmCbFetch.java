package com.server.pojo.url.daysCb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseFbLjxmCbFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "分包临建项目集合")
	private List<CbhsDaysFbLjxmCb> result= new ArrayList<>();;
	@ApiModelProperty(value = "总条数")
	private Long total= 0L;
	@ApiModelProperty(value = "合计")
	private CbhsDaysFbLjxmCb  hj;

	public List<CbhsDaysFbLjxmCb> getResult() {
    	return this.result;
	}
	public void setResult(List<CbhsDaysFbLjxmCb> result) {
    this.result =result;
	}

	public Long getTotal() { 

    	return this.total;

	}

	public void setTotal(Long total) {
 
        this.total = total;

	}

	public CbhsDaysFbLjxmCb getHj() { 

    	return this.hj;

	}

	public void setHj(CbhsDaysFbLjxmCb hj) {
 
        this.hj = hj;

	}


}