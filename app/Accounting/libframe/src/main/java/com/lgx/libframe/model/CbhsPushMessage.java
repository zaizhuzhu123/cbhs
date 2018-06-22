package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsPushMessage implements Serializable{
private static final long serialVersionUID = 70000005L;

private int oid;// 主键
private  boolean state;// 推送状态 1 已推送 0未推送
private String  title;// 标题
private String  alert;// 内容
private String  message;// 内容
private String  timeStr;// 消息时间
private  long  time;// 消息时间
private String  pushedStr;// 推送时间
private  long  pushedTime;// 推送时间
private String  extStr;// 额外信息
private int personOid;// 用户ID
private int examinerOid;// 审核ID
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public boolean  getState(){ 

    return this.state;

}

public void setState(boolean state){
 
        this.state=state;

}

public String  getTitle(){ 

    return this.title;

}

public void setTitle(String title){
 
        this.title=title;

}

public String  getAlert(){ 

    return this.alert;

}

public void setAlert(String alert){
 
        this.alert=alert;

}

public String  getMessage(){ 

    return this.message;

}

public void setMessage(String message){
 
        this.message=message;

}

public String  getTimeStr(){ 

    return this.timeStr;

}

public void setTimeStr(String timeStr){
 
        this.timeStr=timeStr;

}

public long  getTime(){ 

    return this.time;

}

public void setTime(long time){
 
        this.time=time;

}

public String  getPushedStr(){ 

    return this.pushedStr;

}

public void setPushedStr(String pushedStr){
 
        this.pushedStr=pushedStr;

}

public long  getPushedTime(){ 

    return this.pushedTime;

}

public void setPushedTime(long pushedTime){
 
        this.pushedTime=pushedTime;

}

public String  getExtStr(){ 

    return this.extStr;

}

public void setExtStr(String extStr){
 
        this.extStr=extStr;

}

public int  getPersonOid(){ 

    return this.personOid;

}

public void setPersonOid(int personOid){
 
        this.personOid=personOid;

}

public int  getExaminerOid(){ 

    return this.examinerOid;

}

public void setExaminerOid(int examinerOid){
 
        this.examinerOid=examinerOid;

}


}