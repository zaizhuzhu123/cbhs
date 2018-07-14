package com.server.pojo.url.monthMbYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestFbGcCbYsAdd implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "分包工程")
	private List<CbhsMonthFbGcCbYs> yss= new ArrayList<>();;

	public List<CbhsMonthFbGcCbYs> getYss() {
    	return this.yss;
	}
	public void setYss(List<CbhsMonthFbGcCbYs> yss) {
    this.yss =yss;
	}


}