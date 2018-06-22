package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseJjcbFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsDaysJjcb> result;;// 间接成本预算集合
private long total;// 总条数
public List<CbhsDaysJjcb>  getResult(){
    return this.result;
}
public void setResult(List<CbhsDaysJjcb> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}