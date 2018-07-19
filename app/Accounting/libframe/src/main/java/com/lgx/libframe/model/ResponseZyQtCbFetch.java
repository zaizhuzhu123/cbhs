package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseZyQtCbFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsDaysZyQtCb> result;;// 
private long total;// 
private  CbhsDaysZyQtCb  hj;// 
public List<CbhsDaysZyQtCb>  getResult(){
    return this.result;
}
public void setResult(List<CbhsDaysZyQtCb> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsDaysZyQtCb  getHj(){ 

    return this.hj;

}

public void setHj(CbhsDaysZyQtCb hj){
 
        this.hj=hj;

}


}