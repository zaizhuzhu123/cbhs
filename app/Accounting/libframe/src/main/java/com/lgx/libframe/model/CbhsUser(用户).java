package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsUser(用户) implements Serializable{
private static final long serialVersionUID = 30000001L;

private int oid;// 主键
private String  name;// 名称
private String  phoneNumber;// 手机号码
private  boolean sex;// 性别 true 男 false 女
private String  menuids;// 可操作的菜单集合(直接对账号分配的菜单权限)
private String  roleids;// 拥有的角色
private String  roleNames;// 拥有的角色名称
private int deptOid;// 所属部门ID
private String  deptName;// 部门名称
private  boolean isAdmin;// 管理员账号 true 管理员 
private  boolean status;// 删除标识 true正常状态，未删除 false 已被删除
private int avatarOid;// 头像对应的资源ID
private String  avatar;// 头像URL
private  boolean isAllDept;// 是否可查看所有部门信息
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

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

public boolean  getIsAdmin(){ 

    return this.isAdmin;

}

public void setIsAdmin(boolean isAdmin){
 
        this.isAdmin=isAdmin;

}

public boolean  getStatus(){ 

    return this.status;

}

public void setStatus(boolean status){
 
        this.status=status;

}

public int  getAvatarOid(){ 

    return this.avatarOid;

}

public void setAvatarOid(int avatarOid){
 
        this.avatarOid=avatarOid;

}

public String  getAvatar(){ 

    return this.avatar;

}

public void setAvatar(String avatar){
 
        this.avatar=avatar;

}

public boolean  getIsAllDept(){ 

    return this.isAllDept;

}

public void setIsAllDept(boolean isAllDept){
 
        this.isAllDept=isAllDept;

}


}