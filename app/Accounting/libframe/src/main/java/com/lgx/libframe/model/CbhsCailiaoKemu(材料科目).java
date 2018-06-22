package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsCailiaoKemu(材料科目) implements Serializable{
private static final long serialVersionUID = 10000004L;

private int oid;// 材料科目主键ID(创建不填|修改必填)
private String  name;// 必填|材料科目名称
private  boolean status;// 删除标识 true正常状态，未删除 false 已被删除
private  boolean isRy;// 必填|是否属于燃油类别
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

public boolean  getStatus(){ 

    return this.status;

}

public void setStatus(boolean status){
 
        this.status=status;

}

public boolean  getIsRy(){ 

    return this.isRy;

}

public void setIsRy(boolean isRy){
 
        this.isRy=isRy;

}


}