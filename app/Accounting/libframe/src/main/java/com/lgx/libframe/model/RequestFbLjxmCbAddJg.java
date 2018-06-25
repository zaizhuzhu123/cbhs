package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestFbLjxmCbAddJg implements Serializable{
private static final long serialVersionUID = 10000000L;

private int daysFbLjxmCbOid;// 数量统计ID
private double fbPrice;// 总金额
private double fbUnitPrice;// 单价
private int submitType;// 提交方式(0默认提交 1审核提交)
public int  getDaysFbLjxmCbOid(){ 

    return this.daysFbLjxmCbOid;

}

public void setDaysFbLjxmCbOid(int daysFbLjxmCbOid){
 
        this.daysFbLjxmCbOid=daysFbLjxmCbOid;

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