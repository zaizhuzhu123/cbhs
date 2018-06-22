package com.server.pojo.url.monthMbYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestGlfyYsDel implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "管理经费主键集合(蹇呭～)")
	@NotNull(message="管理经费ID不能为空")
	private List<Integer> oids= new ArrayList<>();;

	public List<Integer> getOids() {
    	return this.oids;
	}
	public void setOids(List<Integer> oids) {
    this.oids =oids;
	}


}