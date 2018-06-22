package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsDaysZyCailiaoCb(每日自营材料成本) implements Serializable{
private static final long serialVersionUID = 30000002L;

private int oid;// 主键（材料成本）(创建不填|修改必填)
private int projectOid;// 必填|所属工程项目ID CbhsProject
private int globalGclYsOid;// 必填|对应的总工程量ID 大项
private String  globalGclYsName;// 必填|对应的总工程量 名称
private int deptOid;// 必填|部门编号
private String  deptName;// 必填|部门名称
private String  monthStr;// 必填|月份 yyyy-MM 便于展示
private long monthTimeStamp;// 必填|月份 时间戳 用于后期数据统计
private String  dateStr;// 日期 yyyy-MM-dd 便于展示
private long dateTimeStamp;// 日期 每天00:00:00的时间戳 用于后期数据统计
private int cailiaoKemuOid;// 必填|对应的材料科目ID
private String  cailiaoKemuName;// 必填|对应的材料科目名称
private String  cailiaoName;// 必填|对应的材料名称
private int cailiaoOid;// 必填|对应的材料ID
private String  style;// 必填|对应的材料规格
private String  unit;// 必填|对应的材料单位
private double count;// 必填|对应的材料数量
private double unitPrice;// 必填|对应的材料单价
private double total;// 必填|总金额
private int opUserOid;// 操作人ID
private String  opUserName;// 操作人姓名
private String  opTimeStr;// 操作时间
private long opTime;// 操作时间
private int shStatus;// 审核状态 0 可用 1 审核中 2 审核不通过
private String  shId;// 审核标识 表示这是一个需要审核的操作 同一个操作由多条记录组成 通过这个表示审核的是一个操作
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

public String  getDateStr(){ 

    return this.dateStr;

}

public void setDateStr(String dateStr){
 
        this.dateStr=dateStr;

}

public long  getDateTimeStamp(){ 

    return this.dateTimeStamp;

}

public void setDateTimeStamp(long dateTimeStamp){
 
        this.dateTimeStamp=dateTimeStamp;

}

public int  getCailiaoKemuOid(){ 

    return this.cailiaoKemuOid;

}

public void setCailiaoKemuOid(int cailiaoKemuOid){
 
        this.cailiaoKemuOid=cailiaoKemuOid;

}

public String  getCailiaoKemuName(){ 

    return this.cailiaoKemuName;

}

public void setCailiaoKemuName(String cailiaoKemuName){
 
        this.cailiaoKemuName=cailiaoKemuName;

}

public String  getCailiaoName(){ 

    return this.cailiaoName;

}

public void setCailiaoName(String cailiaoName){
 
        this.cailiaoName=cailiaoName;

}

public int  getCailiaoOid(){ 

    return this.cailiaoOid;

}

public void setCailiaoOid(int cailiaoOid){
 
        this.cailiaoOid=cailiaoOid;

}

public String  getStyle(){ 

    return this.style;

}

public void setStyle(String style){
 
        this.style=style;

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

public double  getTotal(){ 

    return this.total;

}

public void setTotal(double total){
 
        this.total=total;

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

public int  getShStatus(){ 

    return this.shStatus;

}

public void setShStatus(int shStatus){
 
        this.shStatus=shStatus;

}

public String  getShId(){ 

    return this.shId;

}

public void setShId(String shId){
 
        this.shId=shId;

}


}