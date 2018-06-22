package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsRole implements Serializable{
private static final long serialVersionUID = 30000003L;

private int oid;// 主键
private String  name;// 必填|角色名称
private String  content;// 选填|角色描述
private String  menuids;// 选填|可操作的菜单集合
private  boolean status;// 删除标识 true正常状态，未删除 false 已被删除
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

public String  getContent(){ 

    return this.content;

}

public void setContent(String content){
 
        this.content=content;

}

public String  getMenuids(){ 

    return this.menuids;

}

public void setMenuids(String menuids){
 
        this.menuids=menuids;

}

public boolean  getStatus(){ 

    return this.status;

}

public void setStatus(boolean status){
 
        this.status=status;

}


}