package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsCailiao(材料) implements Serializable{
private static final long serialVersionUID = 10000003L;

private int oid;// 材料主键ID(创建不填|修改必填)
private int kemuOid;// 必填|所属科目
private String  kemuName;// 必填|科目名称
private String  name;// 必填|材料名称
private String  style;// 必填|规格
private String  unit;// 必填|单位
private double unitPrice;// 必填|单价
private  boolean status;// 删除标识 true正常状态，未删除 false 已被删除
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

public String  getKemuName(){ 

    return this.kemuName;

}

public void setKemuName(String kemuName){
 
        this.kemuName=kemuName;

}

public String  getName(){ 

    return this.name;

}

public void setName(String name){
 
        this.name=name;

}

public String  getStyle(){ 

    return this.style;

}

public void setStyle(String style){
 
        this.style=style;

}

public String  getUnit(){ 

    return this.unit;

}

public void setUnit(String unit){
 
        this.unit=unit;

}

public double  getUnitPrice(){ 

    return this.unitPrice;

}

public void setUnitPrice(double unitPrice){
 
        this.unitPrice=unitPrice;

}

public boolean  getStatus(){ 

    return this.status;

}

public void setStatus(boolean status){
 
        this.status=status;

}


}