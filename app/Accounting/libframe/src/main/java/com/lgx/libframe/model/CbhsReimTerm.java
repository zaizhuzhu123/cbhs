package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsReimTerm implements Serializable{
private static final long serialVersionUID = 40000003L;

private int oid;// 主键(报销ID)(创建不填|修改必填)
private int reimOid;// 报销单ID
private String  name;// 费用项目
private String  content;// 费用内容
private double price;// 费用金额
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public int  getReimOid(){ 

    return this.reimOid;

}

public void setReimOid(int reimOid){
 
        this.reimOid=reimOid;

}

public String  getName(){ 

    return this.name;

}

public void setName(String name){
 
        this.name=name;

}

public String  getContent(){ 

    return this.content;

}

public void setContent(String content){
 
        this.content=content;

}

public double  getPrice(){ 

    return this.price;

}

public void setPrice(double price){
 
        this.price=price;

}


}