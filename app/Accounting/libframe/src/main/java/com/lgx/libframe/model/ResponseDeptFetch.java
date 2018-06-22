package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseDeptFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsDept> result;;// 部门信息集合
private long total;// 总条数
public List<CbhsDept>  getResult(){
    return this.result;
}
public void setResult(List<CbhsDept> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}