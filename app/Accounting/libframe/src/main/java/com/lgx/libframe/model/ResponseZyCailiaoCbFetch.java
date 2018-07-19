package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseZyCailiaoCbFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsDaysZyCailiaoCb> result;;// 自营材料成本集合
private long total;// 总条数
private  CbhsDaysZyCailiaoCb  hj;// 合计
public List<CbhsDaysZyCailiaoCb>  getResult(){
    return this.result;
}
public void setResult(List<CbhsDaysZyCailiaoCb> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsDaysZyCailiaoCb  getHj(){ 

    return this.hj;

}

public void setHj(CbhsDaysZyCailiaoCb hj){
 
        this.hj=hj;

}


}