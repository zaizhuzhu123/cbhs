package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseFbGcGlobalXmFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<uiCbhsFbGcGlobalXm> result;;// 分包工程大项集合
private long total;// 总条数
public List<uiCbhsFbGcGlobalXm>  getResult(){
    return this.result;
}
public void setResult(List<uiCbhsFbGcGlobalXm> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}