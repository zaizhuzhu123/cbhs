package com.server.pojo.url.globalYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestGlobalFyzYsDel implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "费用总预算主键集合(蹇呭～)")
	@NotNull(message="预算ID不能为空")
	private List<Integer> oids= new ArrayList<>();;

	public List<Integer> getOids() {
    	return this.oids;
	}
	public void setOids(List<Integer> oids) {
    this.oids =oids;
	}


}