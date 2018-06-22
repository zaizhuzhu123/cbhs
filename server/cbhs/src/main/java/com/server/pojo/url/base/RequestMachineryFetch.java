package com.server.pojo.url.base;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestMachineryFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "机械设备ID")
	private Integer oid= 0;
	@ApiModelProperty(value = "设备种类ID")
	private Integer typeOid= 0;
	@ApiModelProperty(value = "机械设备名称")
	private String name= "";
	@ApiModelProperty(value = "页码")
	private Integer pageNum= 0;
	@ApiModelProperty(value = "数量")
	private Integer pageSize= 0;
	@ApiModelProperty(value = "开始编号")
	private Integer startOid= 0;
	@ApiModelProperty(value = "机械设备状态")
	private Boolean status=true;
	@ApiModelProperty(value = "是否使用中 1使用 2未使用")
	private Integer used= 0;

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getTypeOid() { 

    	return this.typeOid;

	}

	public void setTypeOid(Integer typeOid) {
 
        this.typeOid = typeOid;

	}

	public String getName() { 

    	return this.name;

	}

	public void setName(String name) {
 
        this.name = name;

	}

	public Integer getPageNum() { 

    	return this.pageNum;

	}

	public void setPageNum(Integer pageNum) {
 
        this.pageNum = pageNum;

	}

	public Integer getPageSize() { 

    	return this.pageSize;

	}

	public void setPageSize(Integer pageSize) {
 
        this.pageSize = pageSize;

	}

	public Integer getStartOid() { 

    	return this.startOid;

	}

	public void setStartOid(Integer startOid) {
 
        this.startOid = startOid;

	}

	public Boolean getStatus() { 

    	return this.status;

	}

	public void setStatus(Boolean status) {
 
        this.status = status;

	}

	public Integer getUsed() { 

    	return this.used;

	}

	public void setUsed(Integer used) {
 
        this.used = used;

	}


}