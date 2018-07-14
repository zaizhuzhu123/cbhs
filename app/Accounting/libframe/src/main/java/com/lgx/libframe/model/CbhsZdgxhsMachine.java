package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsZdgxhsMachine implements Serializable{
private static final long serialVersionUID = 10000000006L;

private int oid;// 主键(重点工序核算)(创建不填|修改必填)
private int zytjOid;// (重点工序核算)
private int machineryOid;// 必填|设备ID
private String  machineryName;// 必填|设备名称
private double completeTotal;// 必填|完成方量
private  float  workTime;// 必填|工作时间
private double p_zjf;// 必填|折旧费
private double p_zpf;// 必填|租赁费
private double p_jxysf;// 必填|机械运输费
private double p_jxdxf;// 必填|机械大修费
private int ryID;// 必填|燃油ID
private String  ryKemuName;// 选填|燃油科目名称
private String  ryName;// 必填|燃油名称
private double ryUseCount;// 必填|燃油使用量 单位L
private String  ryStyle;// 选填|燃油规格
private String  ryUnit;// 必填|燃油单位
private double ryUnitPrice;// 必填|燃油单价
private double ryPrice;// 必填|燃油金额
private double p_total;// 必填|机械总价
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public int  getZytjOid(){ 

    return this.zytjOid;

}

public void setZytjOid(int zytjOid){
 
        this.zytjOid=zytjOid;

}

public int  getMachineryOid(){ 

    return this.machineryOid;

}

public void setMachineryOid(int machineryOid){
 
        this.machineryOid=machineryOid;

}

public String  getMachineryName(){ 

    return this.machineryName;

}

public void setMachineryName(String machineryName){
 
        this.machineryName=machineryName;

}

public double  getCompleteTotal(){ 

    return this.completeTotal;

}

public void setCompleteTotal(double completeTotal){
 
        this.completeTotal=completeTotal;

}

public float  getWorkTime(){ 

    return this.workTime;

}

public void setWorkTime(float workTime){
 
        this.workTime=workTime;

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

public double  getP_jxysf(){ 

    return this.p_jxysf;

}

public void setP_jxysf(double p_jxysf){
 
        this.p_jxysf=p_jxysf;

}

public double  getP_jxdxf(){ 

    return this.p_jxdxf;

}

public void setP_jxdxf(double p_jxdxf){
 
        this.p_jxdxf=p_jxdxf;

}

public int  getRyID(){ 

    return this.ryID;

}

public void setRyID(int ryID){
 
        this.ryID=ryID;

}

public String  getRyKemuName(){ 

    return this.ryKemuName;

}

public void setRyKemuName(String ryKemuName){
 
        this.ryKemuName=ryKemuName;

}

public String  getRyName(){ 

    return this.ryName;

}

public void setRyName(String ryName){
 
        this.ryName=ryName;

}

public double  getRyUseCount(){ 

    return this.ryUseCount;

}

public void setRyUseCount(double ryUseCount){
 
        this.ryUseCount=ryUseCount;

}

public String  getRyStyle(){ 

    return this.ryStyle;

}

public void setRyStyle(String ryStyle){
 
        this.ryStyle=ryStyle;

}

public String  getRyUnit(){ 

    return this.ryUnit;

}

public void setRyUnit(String ryUnit){
 
        this.ryUnit=ryUnit;

}

public double  getRyUnitPrice(){ 

    return this.ryUnitPrice;

}

public void setRyUnitPrice(double ryUnitPrice){
 
        this.ryUnitPrice=ryUnitPrice;

}

public double  getRyPrice(){ 

    return this.ryPrice;

}

public void setRyPrice(double ryPrice){
 
        this.ryPrice=ryPrice;

}

public double  getP_total(){ 

    return this.p_total;

}

public void setP_total(double p_total){
 
        this.p_total=p_total;

}


}