package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestFbGclTjCbFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 主键
private int deptOid;// 部门ID
private int fbGclYsOid;// 工程量ID
private int projectOid;// 工程项目ID
private long daysStart;// 开始日期
private long daysEnd;// 结束日期
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始ID
private int type;// 类型(1:大项|2:有单价的项)
private int shStatus;// 审核状态 0所有 1 审核通过的
private int htID;// 合同ID
private String  htName;// 合同名称
private int fbCompanyOid;// 分包商ID
private String  fbCompanyName;// 分包商名称
private String  fbGclYsName;// 分包工程名称
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

public int  getFbGclYsOid(){ 

    return this.fbGclYsOid;

}

public void setFbGclYsOid(int fbGclYsOid){
 
        this.fbGclYsOid=fbGclYsOid;

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

public int  getType(){ 

    return this.type;

}

public void setType(int type){
 
        this.type=type;

}

public int  getShStatus(){ 

    return this.shStatus;

}

public void setShStatus(int shStatus){
 
        this.shStatus=shStatus;

}

public int  getHtID(){ 

    return this.htID;

}

public void setHtID(int htID){
 
        this.htID=htID;

}

public String  getHtName(){ 

    return this.htName;

}

public void setHtName(String htName){
 
        this.htName=htName;

}

public int  getFbCompanyOid(){ 

    return this.fbCompanyOid;

}

public void setFbCompanyOid(int fbCompanyOid){
 
        this.fbCompanyOid=fbCompanyOid;

}

public String  getFbCompanyName(){ 

    return this.fbCompanyName;

}

public void setFbCompanyName(String fbCompanyName){
 
        this.fbCompanyName=fbCompanyName;

}

public String  getFbGclYsName(){ 

    return this.fbGclYsName;

}

public void setFbGclYsName(String fbGclYsName){
 
        this.fbGclYsName=fbGclYsName;

}


}