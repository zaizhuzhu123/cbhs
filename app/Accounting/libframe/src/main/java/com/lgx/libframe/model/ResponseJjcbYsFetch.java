package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseJjcbYsFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsMonthJjcbYs> result;;// 间接成本预算集合
private long total;// 总条数
private  CbhsMonthJjcbYs  jjcbTotal;// 合计对象
public List<CbhsMonthJjcbYs>  getResult(){
    return this.result;
}
public void setResult(List<CbhsMonthJjcbYs> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsMonthJjcbYs  getJjcbTotal(){ 

    return this.jjcbTotal;

}

public void setJjcbTotal(CbhsMonthJjcbYs jjcbTotal){
 
        this.jjcbTotal=jjcbTotal;

}


}