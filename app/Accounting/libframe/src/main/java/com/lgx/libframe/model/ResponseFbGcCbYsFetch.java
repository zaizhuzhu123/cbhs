package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseFbGcCbYsFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsMonthFbGcCbYs> result;;// 分包工程集合
private long total;// 总条数
private double priceTotal;// 总费用
public List<CbhsMonthFbGcCbYs>  getResult(){
    return this.result;
}
public void setResult(List<CbhsMonthFbGcCbYs> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public double  getPriceTotal(){ 

    return this.priceTotal;

}

public void setPriceTotal(double priceTotal){
 
        this.priceTotal=priceTotal;

}


}