package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsHt implements Serializable{
private static final long serialVersionUID = 100000010L;

private int oid;// 主键ID
private String  htId;// 合同编号
private String  htName;// 合同名称
private int fbCompanyOid;// 分包商ID
private String  fbCompanyName;// 分包商名称
private  boolean status;// 删除标识 true正常状态，未删除 false 已被删除
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public String  getHtId(){ 

    return this.htId;

}

public void setHtId(String htId){
 
        this.htId=htId;

}

public String  getHtName(){ 

    return this.htName;

}

public void setHtName(String htName){
 
        this.htName=htName;

}

public int  getFbCompanyOid(){ 

    return this.fbCompanyOid;

}

public void setFbCompanyOid(int fbCompanyOid){
 
        this.fbCompanyOid=fbCompanyOid;

}

public String  getFbCompanyName(){ 

    return this.fbCompanyName;

}

public void setFbCompanyName(String fbCompanyName){
 
        this.fbCompanyName=fbCompanyName;

}

public boolean  getStatus(){ 

    return this.status;

}

public void setStatus(boolean status){
 
        this.status=status;

}


}