package com.server.pojo.url.common;
import java.util.List;import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestExaminerRuleDel implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "部门ID集合(必填)")
	@NotNull(message="审核规则ID不能为空")
	private List<Integer> oids= new ArrayList<>();;

	public List<Integer> getOids() {
    	return this.oids;
	}
	public void setOids(List<Integer> oids) {
    this.oids =oids;
	}


}