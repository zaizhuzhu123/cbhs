package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsZdgxhs implements Serializable{
private static final long serialVersionUID = 10000000004L;

private int oid;// 主键(重点工序核算)(创建不填|修改必填)
private int projectOid;// 必填|所属工程项目ID CbhsProject
private int globalGclYsOid;// 必填|对应的分包工程量ID 大项
private String  globaGclYsName;// 必填|对应的分包工程量大项 名称
private int fbGclYsOid;// 必填|对应的分包工程量ID 小项
private String  fbGclYsName;// 必填|对应的分包工程量 名称
private int fbcompanyOid;// 必填|分包公司编号 分包公司项目
private String  fbcompanyName;// 必填|分包公司名称
private int deptOid;// 必填|部门编号
private String  deptName;// 必填|部门名称
private double total;// 必填|总金额
private int opUserOid;// 操作人ID
private String  opUserName;// 操作人姓名
private String  opTimeStr;// 操作时间
private long opTime;// 操作时间
private  ArrayList<CbhsZdgxhsGZ>  gzs;// 必填|工种集合
private double gzTotal;// 必填|工种总金额
private  ArrayList<CbhsZdgxhsZC>  zcs;// 必填|主材集合
private double zcTotal;// 必填|主材总金额
private  ArrayList<CbhsZdgxhsFC>  fcs;// 必填|辅材集合
private double fcTotal;// 必填|辅材总金额
private  ArrayList<CbhsZdgxhsMachine>  machinerys;// 机械设备
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

public String  getGlobaGclYsName(){ 

    return this.globaGclYsName;

}

public void setGlobaGclYsName(String globaGclYsName){
 
        this.globaGclYsName=globaGclYsName;

}

public int  getFbGclYsOid(){ 

    return this.fbGclYsOid;

}

public void setFbGclYsOid(int fbGclYsOid){
 
        this.fbGclYsOid=fbGclYsOid;

}

public String  getFbGclYsName(){ 

    return this.fbGclYsName;

}

public void setFbGclYsName(String fbGclYsName){
 
        this.fbGclYsName=fbGclYsName;

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

public ArrayList<CbhsZdgxhsGZ>  getGzs(){ 

    return this.gzs;

}

public void setGzs(ArrayList<CbhsZdgxhsGZ> gzs){
 
        this.gzs=gzs;

}

public double  getGzTotal(){ 

    return this.gzTotal;

}

public void setGzTotal(double gzTotal){
 
        this.gzTotal=gzTotal;

}

public ArrayList<CbhsZdgxhsZC>  getZcs(){ 

    return this.zcs;

}

public void setZcs(ArrayList<CbhsZdgxhsZC> zcs){
 
        this.zcs=zcs;

}

public double  getZcTotal(){ 

    return this.zcTotal;

}

public void setZcTotal(double zcTotal){
 
        this.zcTotal=zcTotal;

}

public ArrayList<CbhsZdgxhsFC>  getFcs(){ 

    return this.fcs;

}

public void setFcs(ArrayList<CbhsZdgxhsFC> fcs){
 
        this.fcs=fcs;

}

public double  getFcTotal(){ 

    return this.fcTotal;

}

public void setFcTotal(double fcTotal){
 
        this.fcTotal=fcTotal;

}

public ArrayList<CbhsZdgxhsMachine>  getMachinerys(){ 

    return this.machinerys;

}

public void setMachinerys(ArrayList<CbhsZdgxhsMachine> machinerys){
 
        this.machinerys=machinerys;

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