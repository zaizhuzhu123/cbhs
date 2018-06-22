package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsTest1 implements Serializable{
private static final long serialVersionUID = 100000001L;

private int oid;// 主键
private String  test1name;// 名称
private long createTime;// 创建时间
private long updateTime;// 修改时间
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public String  getTest1name(){ 

    return this.test1name;

}

public void setTest1name(String test1name){
 
        this.test1name=test1name;

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


}