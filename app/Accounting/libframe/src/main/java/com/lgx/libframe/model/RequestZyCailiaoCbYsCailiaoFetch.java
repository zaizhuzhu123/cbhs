package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestZyCailiaoCbYsCailiaoFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int deptOid;// 部门ID
private int globalGclYsOid;// 工程量ID
private int projectOid;// 工程项目ID
private long month;// 月份时间戳
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始ID
private int isRy;// 是否是燃油 1是 2不是
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

public int  getIsRy(){ 

    return this.isRy;

}

public void setIsRy(int isRy){
 
        this.isRy=isRy;

}


}