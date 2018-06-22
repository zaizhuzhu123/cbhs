package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseMachineryFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsMachinery> result;;// 机械设备集合
private long total;// 总数
public List<CbhsMachinery>  getResult(){
    return this.result;
}
public void setResult(List<CbhsMachinery> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}