package com.server.pojo.url.monthMbYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseFbCailiaoCbYsAdd implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "分包材料成本")
	private List<CbhsMonthFbCailiaoCbYs> yss= new ArrayList<>();;

	public List<CbhsMonthFbCailiaoCbYs> getYss() {
    	return this.yss;
	}
	public void setYss(List<CbhsMonthFbCailiaoCbYs> yss) {
    this.yss =yss;
	}


}