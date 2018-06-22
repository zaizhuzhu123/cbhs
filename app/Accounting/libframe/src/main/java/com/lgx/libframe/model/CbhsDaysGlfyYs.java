package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsDaysGlfyYs implements Serializable{
private static final long serialVersionUID = 50000001L;

private int oid;// 主键（管理费用）(创建不填|修改必填)
private int projectOid;// 必填|所属工程项目ID CbhsProject
private int deptOid;// 必填|部门编号
private String  deptName;// 必填|部门名称
private String  monthStr;// 必填|月份 yyyy-MM 便于展示
private long monthTimeStamp;// 必填|月份 时间戳 用于后期数据统计
private String  dateStr;// 日期 yyyy-MM-dd 便于展示
private long dateTimeStamp;// 日期 每天00:00:00的时间戳 用于后期数据统计
private double total;// 必填|合计
private double p_sjgs;// 必填|上缴公司
private double p_ztbfy;// 必填|招投标费用
private double p_sjzjjf;// 必填|上缴职教经费、工会经费、三类人员费用
private double p_kdqqysds;// 必填|跨地区企业所得税
private double p_yhsjqtsj;// 必填|印花税及其他税金
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

public double  getTotal(){ 

    return this.total;

}

public void setTotal(double total){
 
        this.total=total;

}

public double  getP_sjgs(){ 

    return this.p_sjgs;

}

public void setP_sjgs(double p_sjgs){
 
        this.p_sjgs=p_sjgs;

}

public double  getP_ztbfy(){ 

    return this.p_ztbfy;

}

public void setP_ztbfy(double p_ztbfy){
 
        this.p_ztbfy=p_ztbfy;

}

public double  getP_sjzjjf(){ 

    return this.p_sjzjjf;

}

public void setP_sjzjjf(double p_sjzjjf){
 
        this.p_sjzjjf=p_sjzjjf;

}

public double  getP_kdqqysds(){ 

    return this.p_kdqqysds;

}

public void setP_kdqqysds(double p_kdqqysds){
 
        this.p_kdqqysds=p_kdqqysds;

}

public double  getP_yhsjqtsj(){ 

    return this.p_yhsjqtsj;

}

public void setP_yhsjqtsj(double p_yhsjqtsj){
 
        this.p_yhsjqtsj=p_yhsjqtsj;

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