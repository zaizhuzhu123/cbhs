package com.server.pojo.url.base;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestHtFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "合同ID")
	private Integer oid= 0;
	@ApiModelProperty(value = "工种名称")
	private String name= "";
	@ApiModelProperty(value = "页码")
	private Integer pageNum= 0;
	@ApiModelProperty(value = "数量")
	private Integer pageSize= 0;
	@ApiModelProperty(value = "开始编号")
	private Integer startOid= 0;
	@ApiModelProperty(value = "工种状态")
	private Boolean status=true;
	@ApiModelProperty(value = "分包商ID")
	private Integer fbCompanyId= 0;
	@ApiModelProperty(value = "分包商名称")
	private String fbCompanyName= "";
	@ApiModelProperty(value = "合同编号")
	private String htId= "";

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

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

	public Integer getFbCompanyId() { 

    	return this.fbCompanyId;

	}

	public void setFbCompanyId(Integer fbCompanyId) {
 
        this.fbCompanyId = fbCompanyId;

	}

	public String getFbCompanyName() { 

    	return this.fbCompanyName;

	}

	public void setFbCompanyName(String fbCompanyName) {
 
        this.fbCompanyName = fbCompanyName;

	}

	public String getHtId() { 

    	return this.htId;

	}

	public void setHtId(String htId) {
 
        this.htId = htId;

	}


}