package com.server.pojo.url.monthMbYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestZyCailiaoCbYsAdd implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "自营材料成本集合 可批量添加")
	private List<CbhsMonthZyCailiaoCbYs> yss= new ArrayList<>();;

	public List<CbhsMonthZyCailiaoCbYs> getYss() {
    	return this.yss;
	}
	public void setYss(List<CbhsMonthZyCailiaoCbYs> yss) {
    this.yss =yss;
	}


}