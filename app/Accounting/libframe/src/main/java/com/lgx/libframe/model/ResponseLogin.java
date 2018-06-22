package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseLogin implements Serializable{
private static final long serialVersionUID = 10000001L;

private String  accountKey;// 账号主键
private String  tokenId;// token
private  CbhsUser  user;// 用户信息
private String  menuids;// 可操作的菜单
private List<CbhsDept> depts;;// 可操作的部门
private  CbhsVersion  lastVersion;// 最新版本信息
public String  getAccountKey(){ 

    return this.accountKey;

}

public void setAccountKey(String accountKey){
 
        this.accountKey=accountKey;

}

public String  getTokenId(){ 

    return this.tokenId;

}

public void setTokenId(String tokenId){
 
        this.tokenId=tokenId;

}

public CbhsUser  getUser(){ 

    return this.user;

}

public void setUser(CbhsUser user){
 
        this.user=user;

}

public String  getMenuids(){ 

    return this.menuids;

}

public void setMenuids(String menuids){
 
        this.menuids=menuids;

}

public List<CbhsDept>  getDepts(){
    return this.depts;
}
public void setDepts(List<CbhsDept> depts){
    this.depts=depts;
}

public CbhsVersion  getLastVersion(){ 

    return this.lastVersion;

}

public void setLastVersion(CbhsVersion lastVersion){
 
        this.lastVersion=lastVersion;

}


}