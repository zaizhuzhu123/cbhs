package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsFbCompany(分包公司) implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 分包公司主键ID(创建不填|修改必填)
private String  name;// 必填|分包公司名称
private int personCount;// 选填|人数
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

public int  getPersonCount(){ 

    return this.personCount;

}

public void setPersonCount(int personCount){
 
        this.personCount=personCount;

}

public boolean  getStatus(){ 

    return this.status;

}

public void setStatus(boolean status){
 
        this.status=status;

}


}