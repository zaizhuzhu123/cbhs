package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseGcsrFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsDaysGclSr> result;;// 工程收入集合
private long total;// 总条数
public List<CbhsDaysGclSr>  getResult(){
    return this.result;
}
public void setResult(List<CbhsDaysGclSr> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}