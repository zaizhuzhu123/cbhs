package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class uiClhxTj implements Serializable{
private static final long serialVersionUID = 1000000009L;

private String  gclName;// 工程量名称
private int gclOid;// 工程量id
private String  monthStr;// 月份
private String  cailiaoKemuName;// 材料科目名称
private int cailiaoOid;// 材料ID
private String  cailiaoName;// 材料名称
private String  style;// 材料规格
private String  unit;// 材料单位
private double ysCount;// 预算用量
private double cbCount;// 实际用量
public String  getGclName(){ 

    return this.gclName;

}

public void setGclName(String gclName){
 
        this.gclName=gclName;

}

public int  getGclOid(){ 

    return this.gclOid;

}

public void setGclOid(int gclOid){
 
        this.gclOid=gclOid;

}

public String  getMonthStr(){ 

    return this.monthStr;

}

public void setMonthStr(String monthStr){
 
        this.monthStr=monthStr;

}

public String  getCailiaoKemuName(){ 

    return this.cailiaoKemuName;

}

public void setCailiaoKemuName(String cailiaoKemuName){
 
        this.cailiaoKemuName=cailiaoKemuName;

}

public int  getCailiaoOid(){ 

    return this.cailiaoOid;

}

public void setCailiaoOid(int cailiaoOid){
 
        this.cailiaoOid=cailiaoOid;

}

public String  getCailiaoName(){ 

    return this.cailiaoName;

}

public void setCailiaoName(String cailiaoName){
 
        this.cailiaoName=cailiaoName;

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

public double  getYsCount(){ 

    return this.ysCount;

}

public void setYsCount(double ysCount){
 
        this.ysCount=ysCount;

}

public double  getCbCount(){ 

    return this.cbCount;

}

public void setCbCount(double cbCount){
 
        this.cbCount=cbCount;

}


}