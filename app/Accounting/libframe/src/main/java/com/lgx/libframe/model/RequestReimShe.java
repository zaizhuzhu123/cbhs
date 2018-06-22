package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestReimShe implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 财务报销ID
private double cwTotal;// 批准金额
private int shStatus;// 审核通过(1批准 2拒绝)
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public double  getCwTotal(){ 

    return this.cwTotal;

}

public void setCwTotal(double cwTotal){
 
        this.cwTotal=cwTotal;

}

public int  getShStatus(){ 

    return this.shStatus;

}

public void setShStatus(int shStatus){
 
        this.shStatus=shStatus;

}


}