package com.server.pojo.url.tjbb;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class ResponseCbsrbb implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "成本集合")
	private List<uiCbSrTj> cbs= new ArrayList<>();;
	@ApiModelProperty(value = "收入集合")
	private List<uiCbSrTj> srs= new ArrayList<>();;

	public List<uiCbSrTj> getCbs() {
    	return this.cbs;
	}
	public void setCbs(List<uiCbSrTj> cbs) {
    this.cbs =cbs;
	}

	public List<uiCbSrTj> getSrs() {
    	return this.srs;
	}
	public void setSrs(List<uiCbSrTj> srs) {
    this.srs =srs;
	}


}