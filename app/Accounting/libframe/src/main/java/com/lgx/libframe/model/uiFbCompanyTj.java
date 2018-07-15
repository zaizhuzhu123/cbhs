package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class uiFbCompanyTj implements Serializable{
private static final long serialVersionUID = 10000000012L;

private int oid;// 主键(重点工序核算)(创建不填|修改必填)
private String  dateStr;// 日期 yyyy-MM-dd 便于展示
private  long  dateTimeStamp;// 日期 每天00:00:00的时间戳 用于后期数据统计
private int fbcompanyOid;// 分包公司编号 分包公司项目
private String  fbcompanyName;// 分包公司名称
private int globalGclYsOid;// 对应的分包工程量ID 大项
private String  globaGclYsName;// 对应的分包工程量大项 名称
private int fbGclYsOid;// 对应的分包工程量ID 小项
private String  fbGclYsName;// 对应的分包工程量 名称
private double gzTotal;// 人力费用
private double zcTotal;// 主材费用
private double fcTotal;// 辅材费用
private double machinerTotal;// 机械费用
private double machinerRyTotal;// 机械燃油
private double total;// 合计
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

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

public double  getGzTotal(){ 

    return this.gzTotal;

}

public void setGzTotal(double gzTotal){
 
        this.gzTotal=gzTotal;

}

public double  getZcTotal(){ 

    return this.zcTotal;

}

public void setZcTotal(double zcTotal){
 
        this.zcTotal=zcTotal;

}

public double  getFcTotal(){ 

    return this.fcTotal;

}

public void setFcTotal(double fcTotal){
 
        this.fcTotal=fcTotal;

}

public double  getMachinerTotal(){ 

    return this.machinerTotal;

}

public void setMachinerTotal(double machinerTotal){
 
        this.machinerTotal=machinerTotal;

}

public double  getMachinerRyTotal(){ 

    return this.machinerRyTotal;

}

public void setMachinerRyTotal(double machinerRyTotal){
 
        this.machinerRyTotal=machinerRyTotal;

}

public double  getTotal(){ 

    return this.total;

}

public void setTotal(double total){
 
        this.total=total;

}


}