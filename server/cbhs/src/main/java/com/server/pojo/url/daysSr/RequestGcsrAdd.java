package com.server.pojo.url.daysSr;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestGcsrAdd implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "工程收入")
	private List<CbhsDaysGclSr> srs= new ArrayList<>();;

	public List<CbhsDaysGclSr> getSrs() {
    	return this.srs;
	}
	public void setSrs(List<CbhsDaysGclSr> srs) {
    this.srs =srs;
	}


}