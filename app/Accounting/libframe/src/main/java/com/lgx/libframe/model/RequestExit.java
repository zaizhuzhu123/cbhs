package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestExit implements Serializable{
private static final long serialVersionUID = 10000000L;

private String  accountKey;// 账号标识(蹇呭～)
private String  token;// token(蹇呭～)
private String  platform;// 登录平台(app|web 默认为app)
public String  getAccountKey(){ 

    return this.accountKey;

}

public void setAccountKey(String accountKey){
 
        this.accountKey=accountKey;

}

public String  getToken(){ 

    return this.token;

}

public void setToken(String token){
 
        this.token=token;

}

public String  getPlatform(){ 

    return this.platform;

}

public void setPlatform(String platform){
 
        this.platform=platform;

}


}