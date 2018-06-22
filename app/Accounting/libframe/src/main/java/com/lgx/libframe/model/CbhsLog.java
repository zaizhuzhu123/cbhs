package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsLog implements Serializable{
private static final long serialVersionUID = 70000004L;

private int oid;// 主键
private int userOid;// 用户ID
private String  ip;// IP
private String  url;// URL
private String  method;// 请求方式
private String  paramQuery;// query请求参数
private String  paramBody;// body请求参数
private String  time;// 请求发起时间
private  long  timeUse;// 请求耗时 单位ms
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public int  getUserOid(){ 

    return this.userOid;

}

public void setUserOid(int userOid){
 
        this.userOid=userOid;

}

public String  getIp(){ 

    return this.ip;

}

public void setIp(String ip){
 
        this.ip=ip;

}

public String  getUrl(){ 

    return this.url;

}

public void setUrl(String url){
 
        this.url=url;

}

public String  getMethod(){ 

    return this.method;

}

public void setMethod(String method){
 
        this.method=method;

}

public String  getParamQuery(){ 

    return this.paramQuery;

}

public void setParamQuery(String paramQuery){
 
        this.paramQuery=paramQuery;

}

public String  getParamBody(){ 

    return this.paramBody;

}

public void setParamBody(String paramBody){
 
        this.paramBody=paramBody;

}

public String  getTime(){ 

    return this.time;

}

public void setTime(String time){
 
        this.time=time;

}

public long  getTimeUse(){ 

    return this.timeUse;

}

public void setTimeUse(long timeUse){
 
        this.timeUse=timeUse;

}


}