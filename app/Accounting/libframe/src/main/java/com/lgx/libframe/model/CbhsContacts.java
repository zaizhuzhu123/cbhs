package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsContacts implements Serializable{
private static final long serialVersionUID = 100000012L;

private int oid;// 主键（临建项目）(创建不填|修改必填)
private String  name;// 必填|姓名
private String  phone;// 必填|电话
private String  post;// 职位
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

public String  getPhone(){ 

    return this.phone;

}

public void setPhone(String phone){
 
        this.phone=phone;

}

public String  getPost(){ 

    return this.post;

}

public void setPost(String post){
 
        this.post=post;

}


}