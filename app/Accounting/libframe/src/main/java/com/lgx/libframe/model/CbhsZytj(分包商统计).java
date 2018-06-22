package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsZytj(分包商统计) implements Serializable{
private static final long serialVersionUID = 10000000000L;

private int oid;// 主键(资源统计)(创建不填|修改必填)
private int projectOid;// 必填|所属工程项目ID CbhsProject
private int globalGclYsOid;// 必填|对应分包工程量ID 大项
private String  globalGclYsName;// 必填|对应分包工程量 名称
private int fbcompanyOid;// 必填|分包公司编号 分包公司项目
private String  fbcompanyName;// 必填|分包公司名称
private int deptOid;// 必填|部门编号
private String  deptName;// 必填|部门名称
private int jxCount;// 必填|机械数量
private double p_zjf;// 必填|折旧费
private double p_jxysf;// 必填|机械运输费
private double p_jxdxf;// 必填|机械大修费
private int ryID;// 必填|燃油ID
private String  ryKemuName;// 选填|燃油科目名称
private String  ryName;// 必填|燃油名称
private double ryUseCount;// 必填|燃油使用量 单位L
private String  ryStyle;// 选填|燃油规格
private String  ryUnit;// 必填|燃油单位
private double ryUnitPrice;// 必填|燃油单价
private double ryPrice;// 必填|燃油金额
private double total;// 必填|总金额
private int opUserOid;// 操作人ID
private String  opUserName;// 操作人姓名
private String  opTimeStr;// 操作时间
private long opTime;// 操作时间
private int shStatus;// 审核状态 0 可用 1 审核中 2 审核不通过
private  ArrayList<CbhsZytjGZ>  gzs;// 必填|工种集合
private double gzTotal;// 必填|工种总金额
private  ArrayList<CbhsZytjZC>  zcs;// 必填|主材集合
private double zcTotal;// 必填|主材总金额
private  ArrayList<CbhsZytjFC>  fcs;// 必填|辅材集合
private double fcTotal;// 必填|辅材总金额
private String  dateStr;// 日期 yyyy-MM-dd 便于展示
private  long  dateTimeStamp;// 日期 每天00:00:00的时间戳 用于后期数据统计
private String  monthStr;// 必填|月份 yyyy-MM 便于展示
private long monthTimeStamp;// 必填|月份 时间戳 用于后期数据统计
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

public int  getFbcompanyOid(){ 

    return this.fbcompanyOid;

}

public void setFbcompanyOid(int fbcompanyOid){
 
        this.fbcompanyOid=fbcompanyOid;

}

public String  getFbcompanyName(){ 

    return this.fbcompanyName;

}

public void setFbcompanyName(String fbcompanyName){
 
        this.fbcompanyName=fbcompanyName;

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

public int  getJxCount(){ 

    return this.jxCount;

}

public void setJxCount(int jxCount){
 
        this.jxCount=jxCount;

}

public double  getP_zjf(){ 

    return this.p_zjf;

}

public void setP_zjf(double p_zjf){
 
        this.p_zjf=p_zjf;

}

public double  getP_jxysf(){ 

    return this.p_jxysf;

}

public void setP_jxysf(double p_jxysf){
 
        this.p_jxysf=p_jxysf;

}

public double  getP_jxdxf(){ 

    return this.p_jxdxf;

}

public void setP_jxdxf(double p_jxdxf){
 
        this.p_jxdxf=p_jxdxf;

}

public int  getRyID(){ 

    return this.ryID;

}

public void setRyID(int ryID){
 
        this.ryID=ryID;

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

public double  getRyUseCount(){ 

    return this.ryUseCount;

}

public void setRyUseCount(double ryUseCount){
 
        this.ryUseCount=ryUseCount;

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

public double  getRyPrice(){ 

    return this.ryPrice;

}

public void setRyPrice(double ryPrice){
 
        this.ryPrice=ryPrice;

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

public ArrayList<CbhsZytjGZ>  getGzs(){ 

    return this.gzs;

}

public void setGzs(ArrayList<CbhsZytjGZ> gzs){
 
        this.gzs=gzs;

}

public double  getGzTotal(){ 

    return this.gzTotal;

}

public void setGzTotal(double gzTotal){
 
        this.gzTotal=gzTotal;

}

public ArrayList<CbhsZytjZC>  getZcs(){ 

    return this.zcs;

}

public void setZcs(ArrayList<CbhsZytjZC> zcs){
 
        this.zcs=zcs;

}

public double  getZcTotal(){ 

    return this.zcTotal;

}

public void setZcTotal(double zcTotal){
 
        this.zcTotal=zcTotal;

}

public ArrayList<CbhsZytjFC>  getFcs(){ 

    return this.fcs;

}

public void setFcs(ArrayList<CbhsZytjFC> fcs){
 
        this.fcs=fcs;

}

public double  getFcTotal(){ 

    return this.fcTotal;

}

public void setFcTotal(double fcTotal){
 
        this.fcTotal=fcTotal;

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


}