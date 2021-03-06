package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsZdgxhsFC implements Serializable{
private static final long serialVersionUID = 10000000008L;

private int oid;// 主键
private int zytjOid;// (重点工序核算)
private int clOid;// 材料编号
private String  clName;// 材料名称
private double clUnitPrice;// 单价
private String  clUnit;// 单位
private String  clStyle;// 规格
private double clCount;// 材料数量
private double clTotalPrice;// 材料金额
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

public int  getClOid(){ 

    return this.clOid;

}

public void setClOid(int clOid){
 
        this.clOid=clOid;

}

public String  getClName(){ 

    return this.clName;

}

public void setClName(String clName){
 
        this.clName=clName;

}

public double  getClUnitPrice(){ 

    return this.clUnitPrice;

}

public void setClUnitPrice(double clUnitPrice){
 
        this.clUnitPrice=clUnitPrice;

}

public String  getClUnit(){ 

    return this.clUnit;

}

public void setClUnit(String clUnit){
 
        this.clUnit=clUnit;

}

public String  getClStyle(){ 

    return this.clStyle;

}

public void setClStyle(String clStyle){
 
        this.clStyle=clStyle;

}

public double  getClCount(){ 

    return this.clCount;

}

public void setClCount(double clCount){
 
        this.clCount=clCount;

}

public double  getClTotalPrice(){ 

    return this.clTotalPrice;

}

public void setClTotalPrice(double clTotalPrice){
 
        this.clTotalPrice=clTotalPrice;

}


}