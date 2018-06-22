package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class uiDeptGrandTotalTj implements Serializable{
private static final long serialVersionUID = 1000000007L;

private double cbTotal;// 总支出
private int deptOid;// 部门ID
private String  deptName;// 部门名称
private long personCount;// 人数
public double  getCbTotal(){ 

    return this.cbTotal;

}

public void setCbTotal(double cbTotal){
 
        this.cbTotal=cbTotal;

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

public long  getPersonCount(){ 

    return this.personCount;

}

public void setPersonCount(long personCount){
 
        this.personCount=personCount;

}


}