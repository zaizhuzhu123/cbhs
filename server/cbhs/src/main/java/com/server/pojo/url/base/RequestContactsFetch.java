package com.server.pojo.url.base;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestContactsFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "联系人ID")
	private Integer oid= 0;
	@ApiModelProperty(value = "姓名(模糊查询)")
	private String name= "";
	@ApiModelProperty(value = "电话(模糊查询)")
	private String phone= "";
	@ApiModelProperty(value = "职位(模糊查询)")
	private String post= "";
	@ApiModelProperty(value = "页码")
	private Integer pageNum= 0;
	@ApiModelProperty(value = "数量")
	private Integer pageSize= 0;
	@ApiModelProperty(value = "开始ID")
	private Integer startOid= 0;

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

	public String getPhone() { 

    	return this.phone;

	}

	public void setPhone(String phone) {
 
        this.phone = phone;

	}

	public String getPost() { 

    	return this.post;

	}

	public void setPost(String post) {
 
        this.post = post;

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


}