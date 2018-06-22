package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseMachineryTypeFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsMachineryType> result;;// 机械设备种类集合
private long total;// 总数
public List<CbhsMachineryType>  getResult(){
    return this.result;
}
public void setResult(List<CbhsMachineryType> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}