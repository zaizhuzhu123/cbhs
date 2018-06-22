package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseHtFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsHt> result;;// 合同集合
private long total;// 总数
public List<CbhsHt>  getResult(){
    return this.result;
}
public void setResult(List<CbhsHt> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}