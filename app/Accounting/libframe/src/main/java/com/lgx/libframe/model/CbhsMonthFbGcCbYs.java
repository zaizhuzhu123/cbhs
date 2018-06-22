package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsMonthFbGcCbYs implements Serializable{
private static final long serialVersionUID = 80000006L;

private int oid;// 主键（分包工程）(创建不填|修改必填)
private int globalGclYsOid;// 必填|对应的总工程量ID 大项
private String  globalGclYsName;// 必填|对应的总工程量 名称
private int projectOid;// 必填|所属工程项目ID CbhsProject
private int deptOid;// 必填|部门编号
private String  deptName;// 必填|部门名称
private String  monthStr;// 必填|月份 yyyy-MM 便于展示
private long monthTimeStamp;// 必填|月份 时间戳 用于后期数据统计
private double total;// 必填|总金额
private int fbCompanyOid;// 必填|分包公司ID
private String  fbCompanyName;// 必填|分包公司名称
private int htOid;// 必填|合同ID(必须是该分包公司合同)
private String  htName;// 必填|合同名称
private String  name;// 必填|项目名称
private String  nodeId;// 必填|项目编号
private String  unit;// 必填|单位
private double unitPrice;// 必填|单价
private double count;// 必填|工程量
private String  pNodeId;// 必填|父节点编号
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

public int  getGlobalGclYsOid(){ 

    return this.globalGclYsOid;

}

public void setGlobalGclYsOid(int globalGclYsOid){
 
        this.globalGclYsOid=globalGclYsOid;

}

public String  getGlobalGclYsName(){ 

    return this.globalGclYsName;

}

public void setGlobalGclYsName(String globalGclYsName){
 
        this.globalGclYsName=globalGclYsName;

}

public int  getProjectOid(){ 

    return this.projectOid;

}

public void setProjectOid(int projectOid){
 
        this.projectOid=projectOid;

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

public String  getMonthStr(){ 

    return this.monthStr;

}

public void setMonthStr(String monthStr){
 
        this.monthStr=monthStr;

}

public long  getMonthTimeStamp(){ 

    return this.monthTimeStamp;

}

public void setMonthTimeStamp(long monthTimeStamp){
 
        this.monthTimeStamp=monthTimeStamp;

}

public double  getTotal(){ 

    return this.total;

}

public void setTotal(double total){
 
        this.total=total;

}

public int  getFbCompanyOid(){ 

    return this.fbCompanyOid;

}

public void setFbCompanyOid(int fbCompanyOid){
 
        this.fbCompanyOid=fbCompanyOid;

}

public String  getFbCompanyName(){ 

    return this.fbCompanyName;

}

public void setFbCompanyName(String fbCompanyName){
 
        this.fbCompanyName=fbCompanyName;

}

public int  getHtOid(){ 

    return this.htOid;

}

public void setHtOid(int htOid){
 
        this.htOid=htOid;

}

public String  getHtName(){ 

    return this.htName;

}

public void setHtName(String htName){
 
        this.htName=htName;

}

public String  getName(){ 

    return this.name;

}

public void setName(String name){
 
        this.name=name;

}

public String  getNodeId(){ 

    return this.nodeId;

}

public void setNodeId(String nodeId){
 
        this.nodeId=nodeId;

}

public String  getUnit(){ 

    return this.unit;

}

public void setUnit(String unit){
 
        this.unit=unit;

}

public double  getUnitPrice(){ 

    return this.unitPrice;

}

public void setUnitPrice(double unitPrice){
 
        this.unitPrice=unitPrice;

}

public double  getCount(){ 

    return this.count;

}

public void setCount(double count){
 
        this.count=count;

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


}