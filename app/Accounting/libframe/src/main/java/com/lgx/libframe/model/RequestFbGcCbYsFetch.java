package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestFbGcCbYsFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 
private int deptOid;// 
private int globalGclYsOid;// 
private int projectOid;// 
private long month;// 
private int pageNum;// 
private int pageSize;// 
private int startOid;// 
private int fbCompanyOid;// 
private int htOid;// 
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

public int  getGlobalGclYsOid(){ 

    return this.globalGclYsOid;

}

public void setGlobalGclYsOid(int globalGclYsOid){
 
        this.globalGclYsOid=globalGclYsOid;

}

public int  getProjectOid(){ 

    return this.projectOid;

}

public void setProjectOid(int projectOid){
 
        this.projectOid=projectOid;

}

public long  getMonth(){ 

    return this.month;

}

public void setMonth(long month){
 
        this.month=month;

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

public int  getFbCompanyOid(){ 

    return this.fbCompanyOid;

}

public void setFbCompanyOid(int fbCompanyOid){
 
        this.fbCompanyOid=fbCompanyOid;

}

public int  getHtOid(){ 

    return this.htOid;

}

public void setHtOid(int htOid){
 
        this.htOid=htOid;

}


}