package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestFbLjxmCbFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 
private int deptOid;// 
private int projectOid;// 
private long daysStart;// 
private long daysEnd;// 
private int pageNum;// 
private int pageSize;// 
private int startOid;// 
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

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

public long  getDaysStart(){ 

    return this.daysStart;

}

public void setDaysStart(long daysStart){
 
        this.daysStart=daysStart;

}

public long  getDaysEnd(){ 

    return this.daysEnd;

}

public void setDaysEnd(long daysEnd){
 
        this.daysEnd=daysEnd;

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

public int  getStartOid(){ 

    return this.startOid;

}

public void setStartOid(int startOid){
 
        this.startOid=startOid;

}


}