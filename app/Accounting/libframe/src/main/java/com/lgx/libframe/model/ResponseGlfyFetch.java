package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseGlfyFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsDaysGlfyYs> result;;// 管理费用集合
private long total;// 总条数
private  CbhsDaysGlfyYs  hj;// 合计
public List<CbhsDaysGlfyYs>  getResult(){
    return this.result;
}
public void setResult(List<CbhsDaysGlfyYs> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsDaysGlfyYs  getHj(){ 

    return this.hj;

}

public void setHj(CbhsDaysGlfyYs hj){
 
        this.hj=hj;

}


}