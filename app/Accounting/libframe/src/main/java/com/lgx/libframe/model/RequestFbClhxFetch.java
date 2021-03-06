package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestFbClhxFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int projectOid;// 工程项目ID
private int deptOid;// 部门ID
private long monthStart;// 月份
private long monthEnd;// 分包工程清单ID
private int globalGclYsOid;// 页码
private int pageNum;// 数量
private int pageSize;// 开始ID
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

public long  getMonthStart(){ 

    return this.monthStart;

}

public void setMonthStart(long monthStart){
 
        this.monthStart=monthStart;

}

public long  getMonthEnd(){ 

    return this.monthEnd;

}

public void setMonthEnd(long monthEnd){
 
        this.monthEnd=monthEnd;

}

public int  getGlobalGclYsOid(){ 

    return this.globalGclYsOid;

}

public void setGlobalGclYsOid(int globalGclYsOid){
 
        this.globalGclYsOid=globalGclYsOid;

}

public int  getPageNum(){ 

    return this.pageNum;

}

public void setPageNum(int pageNum){
 
        this.pageNum=pageNum;

}

public int  getPageSize(){ 

    return this.pageSize;

}

public void setPageSize(int pageSize){
 
        this.pageSize=pageSize;

}


}