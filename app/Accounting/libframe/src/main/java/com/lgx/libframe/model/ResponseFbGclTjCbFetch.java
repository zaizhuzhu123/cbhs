package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseFbGclTjCbFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsDaysFbGclTj> result;;// 分包工程量集合
private long total;// 总条数
private  CbhsDaysFbGclTj  hj;// 合计
public List<CbhsDaysFbGclTj>  getResult(){
    return this.result;
}
public void setResult(List<CbhsDaysFbGclTj> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsDaysFbGclTj  getHj(){ 

    return this.hj;

}

public void setHj(CbhsDaysFbGclTj hj){
 
        this.hj=hj;

}


}