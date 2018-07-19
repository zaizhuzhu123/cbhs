package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseGlfyYsFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsMonthGlfyYs> result;;// 管理费用集合
private long total;// 总条数
private  CbhsMonthGlfyYs  hj;// 合计
public List<CbhsMonthGlfyYs>  getResult(){
    return this.result;
}
public void setResult(List<CbhsMonthGlfyYs> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsMonthGlfyYs  getHj(){ 

    return this.hj;

}

public void setHj(CbhsMonthGlfyYs hj){
 
        this.hj=hj;

}


}