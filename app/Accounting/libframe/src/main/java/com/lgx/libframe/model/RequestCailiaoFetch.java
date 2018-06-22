package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestCailiaoFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 材料ID
private int kemuOid;// 材料科目
private String  style;// 规格
private String  name;// 材料名称
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始编号
private  boolean status;// 材料状态
private int isRy;// 是否是燃油 1是 2不是
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public int  getKemuOid(){ 

    return this.kemuOid;

}

public void setKemuOid(int kemuOid){
 
        this.kemuOid=kemuOid;

}

public String  getStyle(){ 

    return this.style;

}

public void setStyle(String style){
 
        this.style=style;

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

public int  getIsRy(){ 

    return this.isRy;

}

public void setIsRy(int isRy){
 
        this.isRy=isRy;

}


}