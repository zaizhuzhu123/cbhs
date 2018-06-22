package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestDaysDetails implements Serializable{
private static final long serialVersionUID = 10000000L;

private int deptOid;// 部门ID
private int projectOid;// 工程项目ID
private long daysTimeStamp;// 日期时间戳
public int  getDeptOid(){ 

    return this.deptOid;

}

public void setDeptOid(int deptOid){
 
        this.deptOid=deptOid;

}

public int  getProjectOid(){ 

    return this.projectOid;

}

public void setProjectOid(int projectOid){
 
        this.projectOid=projectOid;

}

public long  getDaysTimeStamp(){ 

    return this.daysTimeStamp;

}

public void setDaysTimeStamp(long daysTimeStamp){
 
        this.daysTimeStamp=daysTimeStamp;

}


}