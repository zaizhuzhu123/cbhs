package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestZyQtCbFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 主键
private int deptOid;// 部门ID
private int projectOid;// 工程项目ID
private long daysStart;// 开始日期
private long daysEnd;// 结束日期
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始ID
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