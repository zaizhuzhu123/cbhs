package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestReimFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 财务报销ID
private int projectOid;// 工程项目ID
private int deptOid;// 部门ID
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始编号
private int shStatus;// 审核状态(0所有 1审核中 2审核通过)
private int process;// 当前步骤
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

public int  getShStatus(){ 

    return this.shStatus;

}

public void setShStatus(int shStatus){
 
        this.shStatus=shStatus;

}

public int  getProcess(){ 

    return this.process;

}

public void setProcess(int process){
 
        this.process=process;

}


}