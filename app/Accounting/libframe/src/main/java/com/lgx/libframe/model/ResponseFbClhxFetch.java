package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseFbClhxFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<uiClhxTj> result;;// 材料核销集合
private long total;// 总条数
public List<uiClhxTj>  getResult(){
    return this.result;
}
public void setResult(List<uiClhxTj> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}