package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestFbCailiaoCbYsFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 主键
private int deptOid;// 部门ID
private int globalGclYsOid;// 分包工程量ID
private int projectOid;// 工程项目ID
private long month;// 月份时间戳
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始ID
private int fbCompanyOid;// 分包商ID
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


}