package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseZytjFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsZytj> result;;// 资源统计集合
private long total;// 总条数
public List<CbhsZytj>  getResult(){
    return this.result;
}
public void setResult(List<CbhsZytj> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}