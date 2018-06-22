package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestRegAdmin implements Serializable{
private static final long serialVersionUID = 10000000L;

private String  account;// 账号(蹇呭～)
private String  password;// 密码(蹇呭～)
private String  name;// 名称
private String  phoneNumber;// 手机号码
private  boolean sex;// 性别
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


}