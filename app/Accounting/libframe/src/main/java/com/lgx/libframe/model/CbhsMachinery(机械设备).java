package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsMachinery(机械设备) implements Serializable{
private static final long serialVersionUID = 10000006L;

private int oid;// 机械设备主键ID(创建不填|修改必填)
private String  machineryTypeName;// 必填|种类名称
private int machineryTypeOid;// 必填|种类ID
private String  name;// 必填|机械设备名称
private  boolean status;// 删除标识 true正常状态，未删除 false 已被删除
private String  style;// 必填|设备规格型号
private int selfOrLease;// 必填|设备归属 1自有 2租赁
private double p_zjf;// 必填|折旧费
private double p_zpf;// 必填|租赁费
private int used;// 必填|使用状态 1使用中 2未使用
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public String  getMachineryTypeName(){ 

    return this.machineryTypeName;

}

public void setMachineryTypeName(String machineryTypeName){
 
        this.machineryTypeName=machineryTypeName;

}

public int  getMachineryTypeOid(){ 

    return this.machineryTypeOid;

}

public void setMachineryTypeOid(int machineryTypeOid){
 
        this.machineryTypeOid=machineryTypeOid;

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

public String  getStyle(){ 

    return this.style;

}

public void setStyle(String style){
 
        this.style=style;

}

public int  getSelfOrLease(){ 

    return this.selfOrLease;

}

public void setSelfOrLease(int selfOrLease){
 
        this.selfOrLease=selfOrLease;

}

public double  getP_zjf(){ 

    return this.p_zjf;

}

public void setP_zjf(double p_zjf){
 
        this.p_zjf=p_zjf;

}

public double  getP_zpf(){ 

    return this.p_zpf;

}

public void setP_zpf(double p_zpf){
 
        this.p_zpf=p_zpf;

}

public int  getUsed(){ 

    return this.used;

}

public void setUsed(int used){
 
        this.used=used;

}


}