package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestGlobalGclYsFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 主键
private String  nodeId;// 编号
private String  name;// 名称
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始编号
private int projectOid;// 工程项目ID
private int type;// 类型(1:无单价的项|2:有单价的项|3大项)
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public String  getNodeId(){ 

    return this.nodeId;

}

public void setNodeId(String nodeId){
 
        this.nodeId=nodeId;

}

public String  getName(){ 

    return this.name;

}

public void setName(String name){
 
        this.name=name;

}

public int  getPageNum(){ 

    return this.pageNum;

}

public void setPageNum(int pageNum){
 
        this.pageNum=pageNum;

}

public int  getPageSize(){ 

    return this.pageSize;

}

public void setPageSize(int pageSize){
 
        this.pageSize=pageSize;

}

public int  getStartOid(){ 

    return this.startOid;

}

public void setStartOid(int startOid){
 
        this.startOid=startOid;

}

public int  getProjectOid(){ 

    return this.projectOid;

}

public void setProjectOid(int projectOid){
 
        this.projectOid=projectOid;

}

public int  getType(){ 

    return this.type;

}

public void setType(int type){
 
        this.type=type;

}


}