package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseFbLjxmCbFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsDaysFbLjxmCb> result;;// 分包临建项目集合
private long total;// 总条数
private  CbhsDaysFbLjxmCb  hj;// 合计
public List<CbhsDaysFbLjxmCb>  getResult(){
    return this.result;
}
public void setResult(List<CbhsDaysFbLjxmCb> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsDaysFbLjxmCb  getHj(){ 

    return this.hj;

}

public void setHj(CbhsDaysFbLjxmCb hj){
 
        this.hj=hj;

}


}