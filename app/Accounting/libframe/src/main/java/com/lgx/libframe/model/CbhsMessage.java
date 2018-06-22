package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsMessage implements Serializable{
private static final long serialVersionUID = 70000006L;

private int oid;// 主键
private int personOid;// 用户ID
private int type;// 1 普通的文本消息 2 审核消息
private String  title;// 标题
private String  message;// 内容
private  boolean alreadyRead;// 已阅读
private String  timeStr;// 消息时间
private  long  time;// 消息时间
private int examinerOid;// 审核ID
private String  extStr;// 额外信息
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public int  getPersonOid(){ 

    return this.personOid;

}

public void setPersonOid(int personOid){
 
        this.personOid=personOid;

}

public int  getType(){ 

    return this.type;

}

public void setType(int type){
 
        this.type=type;

}

public String  getTitle(){ 

    return this.title;

}

public void setTitle(String title){
 
        this.title=title;

}

public String  getMessage(){ 

    return this.message;

}

public void setMessage(String message){
 
        this.message=message;

}

public boolean  getAlreadyRead(){ 

    return this.alreadyRead;

}

public void setAlreadyRead(boolean alreadyRead){
 
        this.alreadyRead=alreadyRead;

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

public int  getExaminerOid(){ 

    return this.examinerOid;

}

public void setExaminerOid(int examinerOid){
 
        this.examinerOid=examinerOid;

}

public String  getExtStr(){ 

    return this.extStr;

}

public void setExtStr(String extStr){
 
        this.extStr=extStr;

}


}