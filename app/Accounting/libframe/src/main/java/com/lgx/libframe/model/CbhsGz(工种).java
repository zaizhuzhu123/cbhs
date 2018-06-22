package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsGz(工种) implements Serializable{
private static final long serialVersionUID = 10000001L;

private int oid;// 工种主键ID(创建不填|修改必填)
private String  name;// 必填|工种名称
private String  content;// 选填|工种描述
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

public String  getContent(){ 

    return this.content;

}

public void setContent(String content){
 
        this.content=content;

}

public boolean  getStatus(){ 

    return this.status;

}

public void setStatus(boolean status){
 
        this.status=status;

}


}