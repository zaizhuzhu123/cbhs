package com.server.pojo.url.cbshe;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestCancelExam implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "审核任务ID")
	private Integer examOid= 0;

	public Integer getExamOid() { 

    	return this.examOid;

	}

	public void setExamOid(Integer examOid) {
 
        this.examOid = examOid;

	}


}