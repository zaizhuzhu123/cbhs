package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestHtFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 合同ID
private String  name;// 工种名称
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始编号
private  boolean status;// 工种状态
private int fbCompanyId;// 分包商ID
private String  fbCompanyName;// 分包商名称
private String  htId;// 合同编号
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

public boolean  getStatus(){ 

    return this.status;

}

public void setStatus(boolean status){
 
        this.status=status;

}

public int  getFbCompanyId(){ 

    return this.fbCompanyId;

}

public void setFbCompanyId(int fbCompanyId){
 
        this.fbCompanyId=fbCompanyId;

}

public String  getFbCompanyName(){ 

    return this.fbCompanyName;

}

public void setFbCompanyName(String fbCompanyName){
 
        this.fbCompanyName=fbCompanyName;

}

public String  getHtId(){ 

    return this.htId;

}

public void setHtId(String htId){
 
        this.htId=htId;

}


}