package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestLogin implements Serializable{
private static final long serialVersionUID = 10000000L;

private String  account;// 账号(蹇呭～)
private String  password;// 密码(蹇呭～)
private String  loginType;// 登录方式(pwd 密码登录|phone 手机号码登录)(蹇呭～)
private String  platform;// 登录平台(app|web 默认为app)
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

public String  getLoginType(){ 

    return this.loginType;

}

public void setLoginType(String loginType){
 
        this.loginType=loginType;

}

public String  getPlatform(){ 

    return this.platform;

}

public void setPlatform(String platform){
 
        this.platform=platform;

}


}