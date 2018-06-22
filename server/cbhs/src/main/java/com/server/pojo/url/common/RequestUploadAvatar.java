package com.server.pojo.url.common;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestUploadAvatar implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "上传的资源ID")
	private Integer avatarOid= 0;

	public Integer getAvatarOid() { 

    	return this.avatarOid;

	}

	public void setAvatarOid(Integer avatarOid) {
 
        this.avatarOid = avatarOid;

	}


}