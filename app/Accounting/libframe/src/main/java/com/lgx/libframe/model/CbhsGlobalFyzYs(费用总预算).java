package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsGlobalFyzYs(费用总预算) implements Serializable{
private static final long serialVersionUID = 70000002L;

private int oid;// 全局费用总预算主键ID(创建不填|修改必填)
private int projectOid;// 必填|所属工程项目ID
private String  nodeId;// 必填|项目编号
private String  name;// 必填|项目名称
private double totaPrice;// 必填|总金额（万元）
private String  remark;// 选填|备注
private int opUserOid;// 操作人ID
private String  opUserName;// 操作人姓名
private String  opTimeStr;// 操作时间
private long opTime;// 操作时间
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public int  getProjectOid(){ 

    return this.projectOid;

}

public void setProjectOid(int projectOid){
 
        this.projectOid=projectOid;

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

public double  getTotaPrice(){ 

    return this.totaPrice;

}

public void setTotaPrice(double totaPrice){
 
        this.totaPrice=totaPrice;

}

public String  getRemark(){ 

    return this.remark;

}

public void setRemark(String remark){
 
        this.remark=remark;

}

public int  getOpUserOid(){ 

    return this.opUserOid;

}

public void setOpUserOid(int opUserOid){
 
        this.opUserOid=opUserOid;

}

public String  getOpUserName(){ 

    return this.opUserName;

}

public void setOpUserName(String opUserName){
 
        this.opUserName=opUserName;

}

public String  getOpTimeStr(){ 

    return this.opTimeStr;

}

public void setOpTimeStr(String opTimeStr){
 
        this.opTimeStr=opTimeStr;

}

public long  getOpTime(){ 

    return this.opTime;

}

public void setOpTime(long opTime){
 
        this.opTime=opTime;

}


}