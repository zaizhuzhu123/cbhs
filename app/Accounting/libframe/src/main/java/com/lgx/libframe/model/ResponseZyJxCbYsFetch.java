package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseZyJxCbYsFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsMonthZyJxCbYs> result;;// 自营机械成本集合
private long total;// 总条数
private  CbhsMonthZyJxCbYs  hj;// 合计
public List<CbhsMonthZyJxCbYs>  getResult(){
    return this.result;
}
public void setResult(List<CbhsMonthZyJxCbYs> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsMonthZyJxCbYs  getHj(){ 

    return this.hj;

}

public void setHj(CbhsMonthZyJxCbYs hj){
 
        this.hj=hj;

}


}