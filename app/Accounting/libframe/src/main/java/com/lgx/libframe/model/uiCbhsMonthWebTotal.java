package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class uiCbhsMonthWebTotal implements Serializable{
private static final long serialVersionUID = 100000001L;

private String  monthStr;// 月份
private int deptOid;// 部门ID
private String  deptName;// 部门名称
private double jjcbTotal;// 间接成本汇总
private double fbgcTotal;// 分包成本汇总
private double fbcailiaoCbTotal;// 分包材料汇总
private double fbljxmTotal;// 分包临建项目汇总
private double zycailiaoCbTotal;// 自营材料汇总
private double zylxygTotal;// 自营零星工程汇总
private double zyjxcbTotal;// 自营机械成本
private double qtfy;// 其他费用
private double glfy;// 管理费用
private double deptYsTotal;// 部门月预算总金额
public String  getMonthStr(){ 

    return this.monthStr;

}

public void setMonthStr(String monthStr){
 
        this.monthStr=monthStr;

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

public double  getJjcbTotal(){ 

    return this.jjcbTotal;

}

public void setJjcbTotal(double jjcbTotal){
 
        this.jjcbTotal=jjcbTotal;

}

public double  getFbgcTotal(){ 

    return this.fbgcTotal;

}

public void setFbgcTotal(double fbgcTotal){
 
        this.fbgcTotal=fbgcTotal;

}

public double  getFbcailiaoCbTotal(){ 

    return this.fbcailiaoCbTotal;

}

public void setFbcailiaoCbTotal(double fbcailiaoCbTotal){
 
        this.fbcailiaoCbTotal=fbcailiaoCbTotal;

}

public double  getFbljxmTotal(){ 

    return this.fbljxmTotal;

}

public void setFbljxmTotal(double fbljxmTotal){
 
        this.fbljxmTotal=fbljxmTotal;

}

public double  getZycailiaoCbTotal(){ 

    return this.zycailiaoCbTotal;

}

public void setZycailiaoCbTotal(double zycailiaoCbTotal){
 
        this.zycailiaoCbTotal=zycailiaoCbTotal;

}

public double  getZylxygTotal(){ 

    return this.zylxygTotal;

}

public void setZylxygTotal(double zylxygTotal){
 
        this.zylxygTotal=zylxygTotal;

}

public double  getZyjxcbTotal(){ 

    return this.zyjxcbTotal;

}

public void setZyjxcbTotal(double zyjxcbTotal){
 
        this.zyjxcbTotal=zyjxcbTotal;

}

public double  getQtfy(){ 

    return this.qtfy;

}

public void setQtfy(double qtfy){
 
        this.qtfy=qtfy;

}

public double  getGlfy(){ 

    return this.glfy;

}

public void setGlfy(double glfy){
 
        this.glfy=glfy;

}

public double  getDeptYsTotal(){ 

    return this.deptYsTotal;

}

public void setDeptYsTotal(double deptYsTotal){
 
        this.deptYsTotal=deptYsTotal;

}


}