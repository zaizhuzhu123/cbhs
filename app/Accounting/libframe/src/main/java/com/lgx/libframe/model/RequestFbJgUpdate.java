package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestFbJgUpdate implements Serializable{
private static final long serialVersionUID = 10000000L;

private int fbGclOid;// 
private double fbPrice;// 
private double fbUnitPrice;// 
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


}