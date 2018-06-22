package com.server.pojo.url.common;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestJPushRegID implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "极光生成的设备ID")
	private String registrationID= "";

	public String getRegistrationID() { 

    	return this.registrationID;

	}

	public void setRegistrationID(String registrationID) {
 
        this.registrationID = registrationID;

	}


}