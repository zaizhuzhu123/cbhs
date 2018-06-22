package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestMbYsTotalFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int projectOid;// 工程项目ID
private int deptOid;// 部门编号 0为所有部门汇总
private long month;// 月份
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

public long  getMonth(){ 

    return this.month;

}

public void setMonth(long month){
 
        this.month=month;

}


}