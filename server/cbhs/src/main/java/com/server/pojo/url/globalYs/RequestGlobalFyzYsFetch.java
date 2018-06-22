package com.server.pojo.url.globalYs;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import org.hibernate.validator.constraints.*;
public class RequestGlobalFyzYsFetch implements Serializable {
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "ID")
	private Integer oid= 0;
	@ApiModelProperty(value = "编号")
	private String nodeId= "";
	@ApiModelProperty(value = "名称")
	private String name= "";
	@ApiModelProperty(value = "页码")
	private Integer pageNum= 0;
	@ApiModelProperty(value = "数量")
	private Integer pageSize= 0;
	@ApiModelProperty(value = "开始编号")
	private Integer startOid= 0;
	@ApiModelProperty(value = "工程项目ID")
	private Integer projectOid= 0;

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public String getNodeId() { 

    	return this.nodeId;

	}

	public void setNodeId(String nodeId) {
 
        this.nodeId = nodeId;

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

	public Integer getProjectOid() { 

    	return this.projectOid;

	}

	public void setProjectOid(Integer projectOid) {
 
        this.projectOid = projectOid;

	}


}