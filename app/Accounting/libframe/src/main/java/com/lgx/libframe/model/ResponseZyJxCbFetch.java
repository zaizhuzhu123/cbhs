package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseZyJxCbFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsDaysZyJxCb> result;;// 
private long total;// 
private  CbhsDaysZyJxCb  hj;// 
public List<CbhsDaysZyJxCb>  getResult(){
    return this.result;
}
public void setResult(List<CbhsDaysZyJxCb> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsDaysZyJxCb  getHj(){ 

    return this.hj;

}

public void setHj(CbhsDaysZyJxCb hj){
 
        this.hj=hj;

}


}