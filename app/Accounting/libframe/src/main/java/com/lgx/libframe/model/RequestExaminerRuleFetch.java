package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestExaminerRuleFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 规则ID
private int deptOid;// 部门ID
private int projectOid;// 工程项目ID
private int personOid;// 人员ID
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始ID
private int shType;// 审核方式
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

public int  getPersonOid(){ 

    return this.personOid;

}

public void setPersonOid(int personOid){
 
        this.personOid=personOid;

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

public int  getShType(){ 

    return this.shType;

}

public void setShType(int shType){
 
        this.shType=shType;

}


}