package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseZyQtfyYsFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsMonthZyQtfyYs> result;;// 自营其他费用集合
private long total;// 总条数
private  CbhsMonthZyQtfyYs  hj;// 合计
public List<CbhsMonthZyQtfyYs>  getResult(){
    return this.result;
}
public void setResult(List<CbhsMonthZyQtfyYs> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsMonthZyQtfyYs  getHj(){ 

    return this.hj;

}

public void setHj(CbhsMonthZyQtfyYs hj){
 
        this.hj=hj;

}


}