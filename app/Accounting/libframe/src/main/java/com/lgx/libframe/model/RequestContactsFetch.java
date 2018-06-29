package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestContactsFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 联系人ID
private String  name;// 姓名(模糊查询)
private String  phone;// 电话(模糊查询)
private String  post;// 职位(模糊查询)
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始ID
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

public int  getPageNum(){ 

    return this.pageNum;

}

public void setPageNum(int pageNum){
 
        this.pageNum=pageNum;

}

public int  getPageSize(){ 

    return this.pageSize;

}

public void setPageSize(int pageSize){
 
        this.pageSize=pageSize;

}

public int  getStartOid(){ 

    return this.startOid;

}

public void setStartOid(int startOid){
 
        this.startOid=startOid;

}


}