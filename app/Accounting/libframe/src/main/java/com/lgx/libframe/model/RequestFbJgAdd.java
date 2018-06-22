package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestFbJgAdd implements Serializable{
private static final long serialVersionUID = 10000000L;

private int fbGclOid;// 分包工程ID
private double fbPrice;// 分包总金额
private double fbUnitPrice;// 分包单价
private int submitType;// 提交方式(0默认提交 1审核提交)
public int  getFbGclOid(){ 

    return this.fbGclOid;

}

public void setFbGclOid(int fbGclOid){
 
        this.fbGclOid=fbGclOid;

}

public double  getFbPrice(){ 

    return this.fbPrice;

}

public void setFbPrice(double fbPrice){
 
        this.fbPrice=fbPrice;

}

public double  getFbUnitPrice(){ 

    return this.fbUnitPrice;

}

public void setFbUnitPrice(double fbUnitPrice){
 
        this.fbUnitPrice=fbUnitPrice;

}

public int  getSubmitType(){ 

    return this.submitType;

}

public void setSubmitType(int submitType){
 
        this.submitType=submitType;

}


}