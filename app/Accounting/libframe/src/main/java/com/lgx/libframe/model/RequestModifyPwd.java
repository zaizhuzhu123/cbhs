package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestModifyPwd implements Serializable{
private static final long serialVersionUID = 10000000L;

private String  accountKey;// 账号标识(蹇呭～)
private String  oldPwd;// 旧密码(蹇呭～)
private String  newPwd;// 新密码(蹇呭～)
public String  getAccountKey(){ 

    return this.accountKey;

}

public void setAccountKey(String accountKey){
 
        this.accountKey=accountKey;

}

public String  getOldPwd(){ 

    return this.oldPwd;

}

public void setOldPwd(String oldPwd){
 
        this.oldPwd=oldPwd;

}

public String  getNewPwd(){ 

    return this.newPwd;

}

public void setNewPwd(String newPwd){
 
        this.newPwd=newPwd;

}


}