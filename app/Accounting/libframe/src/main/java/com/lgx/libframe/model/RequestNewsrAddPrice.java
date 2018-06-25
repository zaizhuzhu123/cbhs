package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestNewsrAddPrice implements Serializable{
private static final long serialVersionUID = 10000000L;

private int cbhsDaysQtSrOid;// 数量收入ID
private double price;// 总金额
private double unitPrice;// 单价
public int  getCbhsDaysQtSrOid(){ 

    return this.cbhsDaysQtSrOid;

}

public void setCbhsDaysQtSrOid(int cbhsDaysQtSrOid){
 
        this.cbhsDaysQtSrOid=cbhsDaysQtSrOid;

}

public double  getPrice(){ 

    return this.price;

}

public void setPrice(double price){
 
        this.price=price;

}

public double  getUnitPrice(){ 

    return this.unitPrice;

}

public void setUnitPrice(double unitPrice){
 
        this.unitPrice=unitPrice;

}


}