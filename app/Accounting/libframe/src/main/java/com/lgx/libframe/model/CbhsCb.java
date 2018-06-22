package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsCb implements Serializable{
private static final long serialVersionUID = 100000011L;

private int oid;// 总成本主键ID
private int projectOid;// 所属工程项目ID CbhsProject
private int deptOid;// 部门编号
private String  deptName;// 部门名称
private int type;// 1间接成本 2管理费用 3零星用工 4机械成本 5自营其他费用 6自营材料成本 7分包临建项目 8分包工程量 9资源统计 10分包价格
private int cbOid;// 对应的成本ID
private double total;// 金额
private String  dateStr;// 日期 yyyy-MM-dd 便于展示
private String  monthStr;// 月份
private long dateTimeStamp;// 日期 每天00:00:00的时间戳 用于后期数据统计
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

public int  getType(){ 

    return this.type;

}

public void setType(int type){
 
        this.type=type;

}

public int  getCbOid(){ 

    return this.cbOid;

}

public void setCbOid(int cbOid){
 
        this.cbOid=cbOid;

}

public double  getTotal(){ 

    return this.total;

}

public void setTotal(double total){
 
        this.total=total;

}

public String  getDateStr(){ 

    return this.dateStr;

}

public void setDateStr(String dateStr){
 
        this.dateStr=dateStr;

}

public String  getMonthStr(){ 

    return this.monthStr;

}

public void setMonthStr(String monthStr){
 
        this.monthStr=monthStr;

}

public long  getDateTimeStamp(){ 

    return this.dateTimeStamp;

}

public void setDateTimeStamp(long dateTimeStamp){
 
        this.dateTimeStamp=dateTimeStamp;

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