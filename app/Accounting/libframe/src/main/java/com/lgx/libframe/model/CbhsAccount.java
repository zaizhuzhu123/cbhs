package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsAccount implements Serializable{
private static final long serialVersionUID = 30000000L;

private String  accountKey;// 帐号主键
private String  account;// 登录帐号
private String  password;// 密码
private String  ryToken;// 融云Token
private String  token;// app登录令牌
private  CbhsUser  user;// 用户
private String  webtoken;// web登录令牌
public String  getAccountKey(){ 

    return this.accountKey;

}

public void setAccountKey(String accountKey){
 
        this.accountKey=accountKey;

}

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

public String  getRyToken(){ 

    return this.ryToken;

}

public void setRyToken(String ryToken){
 
        this.ryToken=ryToken;

}

public String  getToken(){ 

    return this.token;

}

public void setToken(String token){
 
        this.token=token;

}

public CbhsUser  getUser(){ 

    return this.user;

}

public void setUser(CbhsUser user){
 
        this.user=user;

}

public String  getWebtoken(){ 

    return this.webtoken;

}

public void setWebtoken(String webtoken){
 
        this.webtoken=webtoken;

}


}