package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseSettlementDownFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsSettleDown> result;;// 对下结算集合
private long total;// 总数
public List<CbhsSettleDown>  getResult(){
    return this.result;
}
public void setResult(List<CbhsSettleDown> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}