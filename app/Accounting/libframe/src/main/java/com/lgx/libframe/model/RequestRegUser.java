package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestRegUser implements Serializable{
private static final long serialVersionUID = 10000000L;

private String  account;// 账号(蹇呭～)
private String  password;// 密码(蹇呭～)
private String  name;// 名称(蹇呭～)
private String  phoneNumber;// 手机号码
private  boolean sex;// 性别
private String  menuids;// 自定义菜单
private String  roleids;// 角色
private String  roleNames;// 角色名称
private int deptOid;// 部门
private String  deptName;// 部门名称
private  boolean isAllDept;// 是否可操作所有部门
public String  getAccount(){ 

    return this.account;

}

public void setAccount(String account){
 
        this.account=account;

}

public String  getPassword(){ 

    return this.password;

}

public void setPassword(String password){
 
        this.password=password;

}

public String  getName(){ 

    return this.name;

}

public void setName(String name){
 
        this.name=name;

}

public String  getPhoneNumber(){ 

    return this.phoneNumber;

}

public void setPhoneNumber(String phoneNumber){
 
        this.phoneNumber=phoneNumber;

}

public boolean  getSex(){ 

    return this.sex;

}

public void setSex(boolean sex){
 
        this.sex=sex;

}

public String  getMenuids(){ 

    return this.menuids;

}

public void setMenuids(String menuids){
 
        this.menuids=menuids;

}

public String  getRoleids(){ 

    return this.roleids;

}

public void setRoleids(String roleids){
 
        this.roleids=roleids;

}

public String  getRoleNames(){ 

    return this.roleNames;

}

public void setRoleNames(String roleNames){
 
        this.roleNames=roleNames;

}

public int  getDeptOid(){ 

    return this.deptOid;

}

public void setDeptOid(int deptOid){
 
        this.deptOid=deptOid;

}

public String  getDeptName(){ 

    return this.deptName;

}

public void setDeptName(String deptName){
 
        this.deptName=deptName;

}

public boolean  getIsAllDept(){ 

    return this.isAllDept;

}

public void setIsAllDept(boolean isAllDept){
 
        this.isAllDept=isAllDept;

}


}