package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseGlobalRcjzhlYsFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsGlobalRcjzhlYs> result;;// 总耗量预算集合
private long total;// 总条数
private double priceTotal;// 总费用
public List<CbhsGlobalRcjzhlYs>  getResult(){
    return this.result;
}
public void setResult(List<CbhsGlobalRcjzhlYs> result){
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