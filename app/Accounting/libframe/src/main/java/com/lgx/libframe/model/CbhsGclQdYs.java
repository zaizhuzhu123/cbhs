package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsGclQdYs implements Serializable{
private static final long serialVersionUID = 70000000L;

private int oid;// 全局工程量清单主键ID(创建不填|修改必填)
private int projectOid;// 必填|所属工程项目ID CbhsProject
private  boolean isGlobal;// 全局预算项目
private int deptOid;// 必填|部门编号
private String  deptName;// 必填|部门名称
private String  month;// 必填|月份
private int fbcompanyOid;// 必填|分包公司编号 分包公司项目
private String  nodeId;// 必填|项目编号
private String  name;// 必填|项目名称
private String  unit;// 选填|单位
private double count;// 选填|合同工程量
private double unitPrice;// 选填|单价
private double totaPrice;// 选填|总金额
private String  pNodeId;// 选填|父节点编号
private int opUserOid;// 操作人ID
private String  opUserName;// 操作人姓名
private String  opTimeStr;// 操作时间
private long opTime;// 操作时间
private double completeCount;// 累计完成工程量
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

public boolean  getIsGlobal(){ 

    return this.isGlobal;

}

public void setIsGlobal(boolean isGlobal){
 
        this.isGlobal=isGlobal;

}

public int  getDeptOid(){ 

    return this.deptOid;

}

public void setDeptOid(int deptOid){
 
        this.deptOid=deptOid;

}

public String  getDeptName(){ 

    return this.deptName;

}

public void setDeptName(String deptName){
 
        this.deptName=deptName;

}

public String  getMonth(){ 

    return this.month;

}

public void setMonth(String month){
 
        this.month=month;

}

public int  getFbcompanyOid(){ 

    return this.fbcompanyOid;

}

public void setFbcompanyOid(int fbcompanyOid){
 
        this.fbcompanyOid=fbcompanyOid;

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

public double  getCount(){ 

    return this.count;

}

public void setCount(double count){
 
        this.count=count;

}

public double  getUnitPrice(){ 

    return this.unitPrice;

}

public void setUnitPrice(double unitPrice){
 
        this.unitPrice=unitPrice;

}

public double  getTotaPrice(){ 

    return this.totaPrice;

}

public void setTotaPrice(double totaPrice){
 
        this.totaPrice=totaPrice;

}

public String  getPNodeId(){ 

    return this.pNodeId;

}

public void setPNodeId(String pNodeId){
 
        this.pNodeId=pNodeId;

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

public double  getCompleteCount(){ 

    return this.completeCount;

}

public void setCompleteCount(double completeCount){
 
        this.completeCount=completeCount;

}


}