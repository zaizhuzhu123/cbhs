package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseZyLxygCbFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsDaysZyLxygCb> result;;// 自营零星用工成本集合
private long total;// 总条数
private  CbhsDaysZyLxygCb  hj;// 合计
public List<CbhsDaysZyLxygCb>  getResult(){
    return this.result;
}
public void setResult(List<CbhsDaysZyLxygCb> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsDaysZyLxygCb  getHj(){ 

    return this.hj;

}

public void setHj(CbhsDaysZyLxygCb hj){
 
        this.hj=hj;

}


}