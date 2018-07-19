package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseFbLjxmCbYsFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsMonthFbLjxmCbYs> result;;// 分包临建项目集合
private long total;// 总条数
private  CbhsMonthFbLjxmCbYs  hj;// 合计
public List<CbhsMonthFbLjxmCbYs>  getResult(){
    return this.result;
}
public void setResult(List<CbhsMonthFbLjxmCbYs> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public CbhsMonthFbLjxmCbYs  getHj(){ 

    return this.hj;

}

public void setHj(CbhsMonthFbLjxmCbYs hj){
 
        this.hj=hj;

}


}