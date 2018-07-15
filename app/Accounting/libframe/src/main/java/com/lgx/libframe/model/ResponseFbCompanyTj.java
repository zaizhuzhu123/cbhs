package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseFbCompanyTj implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<uiFbCompanyTj> result;;// 
private long total;// 
private  uiFbCompanyTj  hj;// 
public List<uiFbCompanyTj>  getResult(){
    return this.result;
}
public void setResult(List<uiFbCompanyTj> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public uiFbCompanyTj  getHj(){ 

    return this.hj;

}

public void setHj(uiFbCompanyTj hj){
 
        this.hj=hj;

}


}