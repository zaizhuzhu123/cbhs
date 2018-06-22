package com.server.pojo.url.daysCb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseZyCailiaoCbAdd implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "自营材料成本集合")
	private List<CbhsDaysZyCailiaoCb> yss= new ArrayList<>();;

	public List<CbhsDaysZyCailiaoCb> getYss() {
    	return this.yss;
	}
	public void setYss(List<CbhsDaysZyCailiaoCb> yss) {
    this.yss =yss;
	}


}