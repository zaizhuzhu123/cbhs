package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsProject implements Serializable{
private static final long serialVersionUID = 10000002L;

private int oid;// 工程项目主键ID(创建不填|修改必填)
private String  name;// 必填|项目名称
private long startUpDate;// 项目启动时间
private int state;// 项目状态 1进行中 2已结束
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

public long  getStartUpDate(){ 

    return this.startUpDate;

}

public void setStartUpDate(long startUpDate){
 
        this.startUpDate=startUpDate;

}

public int  getState(){ 

    return this.state;

}

public void setState(int state){
 
        this.state=state;

}

public boolean  getStatus(){ 

    return this.status;

}

public void setStatus(boolean status){
 
        this.status=status;

}


}