package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsDaysZyJxCb(机械费用每日成本) implements Serializable{
private static final long serialVersionUID = 50000004L;

private int oid;// 主键（机械成本）(创建不填|修改必填)
private int projectOid;// 必填|所属工程项目ID CbhsProject
private int globalGclYsOid;// 必填|对应的总工程量ID 大项
private String  globalGclYsName;// 必填|对应的总工程量 名称
private int machineryOid;// 必填|设备编号
private String  machineryName;// 必填|设备名称
private int deptOid;// 必填|部门编号
private String  deptName;// 必填|部门名称
private String  monthStr;// 必填|月份 yyyy-MM 便于展示
private long monthTimeStamp;// 必填|月份 时间戳 用于后期数据统计
private String  dateStr;// 日期 yyyy-MM-dd 便于展示
private long dateTimeStamp;// 日期 每天00:00:00的时间戳 用于后期数据统计
private double completeCount;// 必填|完成方量 单位 方
private double workTimer;// 必填|工作时长 单位 时
private int ryOid;// 选填|燃油ID 对应到材料表
private String  ryKemuName;// 选填|燃油科目名称
private String  ryName;// 选填|燃油名称
private String  ryStyle;// 选填|燃油规格
private String  ryUnit;// 选填|燃油单位
private double ryUnitPrice;// 必填|燃油单价
private double ryUseCount;// 选填|燃油使用量 单位L
private double ryPrice;// 选填|燃油金额
private double p_zjf;// 必填|折旧费
private double p_zpf;// 必填|租赁费
private double p_clysf;// 必填|车辆运输费
private double p_jxdxf;// 必填|机械大修费
private double total;// 必填|机械成本金额（不包含燃油）
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

public int  getMachineryOid(){ 

    return this.machineryOid;

}

public void setMachineryOid(int machineryOid){
 
        this.machineryOid=machineryOid;

}

public String  getMachineryName(){ 

    return this.machineryName;

}

public void setMachineryName(String machineryName){
 
        this.machineryName=machineryName;

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

public double  getCompleteCount(){ 

    return this.completeCount;

}

public void setCompleteCount(double completeCount){
 
        this.completeCount=completeCount;

}

public double  getWorkTimer(){ 

    return this.workTimer;

}

public void setWorkTimer(double workTimer){
 
        this.workTimer=workTimer;

}

public int  getRyOid(){ 

    return this.ryOid;

}

public void setRyOid(int ryOid){
 
        this.ryOid=ryOid;

}

public String  getRyKemuName(){ 

    return this.ryKemuName;

}

public void setRyKemuName(String ryKemuName){
 
        this.ryKemuName=ryKemuName;

}

public String  getRyName(){ 

    return this.ryName;

}

public void setRyName(String ryName){
 
        this.ryName=ryName;

}

public String  getRyStyle(){ 

    return this.ryStyle;

}

public void setRyStyle(String ryStyle){
 
        this.ryStyle=ryStyle;

}

public String  getRyUnit(){ 

    return this.ryUnit;

}

public void setRyUnit(String ryUnit){
 
        this.ryUnit=ryUnit;

}

public double  getRyUnitPrice(){ 

    return this.ryUnitPrice;

}

public void setRyUnitPrice(double ryUnitPrice){
 
        this.ryUnitPrice=ryUnitPrice;

}

public double  getRyUseCount(){ 

    return this.ryUseCount;

}

public void setRyUseCount(double ryUseCount){
 
        this.ryUseCount=ryUseCount;

}

public double  getRyPrice(){ 

    return this.ryPrice;

}

public void setRyPrice(double ryPrice){
 
        this.ryPrice=ryPrice;

}

public double  getP_zjf(){ 

    return this.p_zjf;

}

public void setP_zjf(double p_zjf){
 
        this.p_zjf=p_zjf;

}

public double  getP_zpf(){ 

    return this.p_zpf;

}

public void setP_zpf(double p_zpf){
 
        this.p_zpf=p_zpf;

}

public double  getP_clysf(){ 

    return this.p_clysf;

}

public void setP_clysf(double p_clysf){
 
        this.p_clysf=p_clysf;

}

public double  getP_jxdxf(){ 

    return this.p_jxdxf;

}

public void setP_jxdxf(double p_jxdxf){
 
        this.p_jxdxf=p_jxdxf;

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