package com.server.pojo.url.monthMbYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseMbYsFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "间接成本总量")
	private CbhsMonthJjcbYs  jjcbTotal;
	@ApiModelProperty(value = "管理费用总量")
	private CbhsMonthGlfyYs  glfyTotal;
	@ApiModelProperty(value = "直接成本总量")
	private uiCbhsMonthZjCbTotal  zjcbTotal;

	public CbhsMonthJjcbYs getJjcbTotal() { 

    	return this.jjcbTotal;

	}

	public void setJjcbTotal(CbhsMonthJjcbYs jjcbTotal) {
 
        this.jjcbTotal = jjcbTotal;

	}

	public CbhsMonthGlfyYs getGlfyTotal() { 

    	return this.glfyTotal;

	}

	public void setGlfyTotal(CbhsMonthGlfyYs glfyTotal) {
 
        this.glfyTotal = glfyTotal;

	}

	public uiCbhsMonthZjCbTotal getZjcbTotal() { 

    	return this.zjcbTotal;

	}

	public void setZjcbTotal(uiCbhsMonthZjCbTotal zjcbTotal) {
 
        this.zjcbTotal = zjcbTotal;

	}


}