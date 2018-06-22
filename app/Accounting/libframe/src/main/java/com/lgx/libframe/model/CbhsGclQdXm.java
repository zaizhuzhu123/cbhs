package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsGclQdXm implements Serializable{
private static final long serialVersionUID = 10000002L;

private int oid;// 主键
private String  nodeId;// 项目编号
private String  name;// 项目名称
private String  unit;// 单位
private String  pNodeId;// 父节点编号
private  boolean status;// 删除标识 true正常状态，未删除 false 已被删除
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

public String  getUnit(){ 

    return this.unit;

}

public void setUnit(String unit){
 
        this.unit=unit;

}

public String  getPNodeId(){ 

    return this.pNodeId;

}

public void setPNodeId(String pNodeId){
 
        this.pNodeId=pNodeId;

}

public boolean  getStatus(){ 

    return this.status;

}

public void setStatus(boolean status){
 
        this.status=status;

}


}