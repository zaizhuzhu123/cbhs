package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseNewsrFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsDaysQtSr> result;;// 新增收入集合
private long total;// 总条数
private  CbhsDaysQtSr  hj;// 合计
public List<CbhsDaysQtSr>  getResult(){
    return this.result;
}
public void setResult(List<CbhsDaysQtSr> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsDaysQtSr  getHj(){ 

    return this.hj;

}

public void setHj(CbhsDaysQtSr hj){
 
        this.hj=hj;

}


}