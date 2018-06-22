package com.server.pojo.url.base;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestCailiaoFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "材料ID")
	private Integer oid= 0;
	@ApiModelProperty(value = "材料科目")
	private Integer kemuOid= 0;
	@ApiModelProperty(value = "规格")
	private String style= "";
	@ApiModelProperty(value = "材料名称")
	private String name= "";
	@ApiModelProperty(value = "页码")
	private Integer pageNum= 0;
	@ApiModelProperty(value = "数量")
	private Integer pageSize= 0;
	@ApiModelProperty(value = "开始编号")
	private Integer startOid= 0;
	@ApiModelProperty(value = "材料状态")
	private Boolean status=true;
	@ApiModelProperty(value = "是否是燃油 1是 2不是")
	private Integer isRy= 0;

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getKemuOid() { 

    	return this.kemuOid;

	}

	public void setKemuOid(Integer kemuOid) {
 
        this.kemuOid = kemuOid;

	}

	public String getStyle() { 

    	return this.style;

	}

	public void setStyle(String style) {
 
        this.style = style;

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

	public Integer getIsRy() { 

    	return this.isRy;

	}

	public void setIsRy(Integer isRy) {
 
        this.isRy = isRy;

	}


}