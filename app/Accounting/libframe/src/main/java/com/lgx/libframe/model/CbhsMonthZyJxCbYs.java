package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsMonthZyJxCbYs implements Serializable{
private static final long serialVersionUID = 50000004L;

private int oid;// 主键（机械成本）(创建不填|修改必填)
private int projectOid;// 必填|所属工程项目ID CbhsProject
private int deptOid;// 必填|部门编号
private String  deptName;// 必填|部门名称
private String  monthStr;// 必填|月份 yyyy-MM 便于展示
private long monthTimeStamp;// 必填|月份 时间戳 用于后期数据统计
private double p_zjf;// 必填|折旧费
private double p_zpf;// 必填|租赁费
private double p_clysf;// 必填|车辆运输费
private double p_jxdxf;// 必填|机械大修费
private double total;// 必填|总金额
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


}