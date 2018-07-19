package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseZyCailiaoCbYsFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsMonthZyCailiaoCbYs> result;;// 自营材料成本集合
private long total;// 总条数
private  CbhsMonthZyCailiaoCbYs  hj;// 合计
public List<CbhsMonthZyCailiaoCbYs>  getResult(){
    return this.result;
}
public void setResult(List<CbhsMonthZyCailiaoCbYs> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsMonthZyCailiaoCbYs  getHj(){ 

    return this.hj;

}

public void setHj(CbhsMonthZyCailiaoCbYs hj){
 
        this.hj=hj;

}


}