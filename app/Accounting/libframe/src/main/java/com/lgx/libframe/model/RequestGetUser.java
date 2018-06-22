package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestGetUser implements Serializable{
private static final long serialVersionUID = 10000000L;

private String  account;// 账号
private String  name;// 名称
private int deptOid;// 部门ID
private int roleOid;// 角色ID
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始ID
private  boolean status;// 状态
public String  getAccount(){ 

    return this.account;

}

public void setAccount(String account){
 
        this.account=account;

}

public String  getName(){ 

    return this.name;

}

public void setName(String name){
 
        this.name=name;

}

public int  getDeptOid(){ 

    return this.deptOid;

}

public void setDeptOid(int deptOid){
 
        this.deptOid=deptOid;

}

public int  getRoleOid(){ 

    return this.roleOid;

}

public void setRoleOid(int roleOid){
 
        this.roleOid=roleOid;

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

public boolean  getStatus(){ 

    return this.status;

}

public void setStatus(boolean status){
 
        this.status=status;

}


}