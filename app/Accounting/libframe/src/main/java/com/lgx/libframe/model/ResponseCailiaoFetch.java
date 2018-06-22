package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseCailiaoFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsCailiao> result;;// 材料集合
private long total;// 总数
public List<CbhsCailiao>  getResult(){
    return this.result;
}
public void setResult(List<CbhsCailiao> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}