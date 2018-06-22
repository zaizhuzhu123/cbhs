package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsTest implements Serializable{
private static final long serialVersionUID = 100000000L;

private int oid;// 主键
private String  name;// 名称
private long createTime;// 创建时间
private long updateTime;// 修改时间
private  CbhsTest1  test1;// test1
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

public long  getCreateTime(){ 

    return this.createTime;

}

public void setCreateTime(long createTime){
 
        this.createTime=createTime;

}

public long  getUpdateTime(){ 

    return this.updateTime;

}

public void setUpdateTime(long updateTime){
 
        this.updateTime=updateTime;

}

public CbhsTest1  getTest1(){ 

    return this.test1;

}

public void setTest1(CbhsTest1 test1){
 
        this.test1=test1;

}


}