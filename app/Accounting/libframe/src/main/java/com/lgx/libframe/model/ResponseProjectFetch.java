package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseProjectFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsProject> result;;// 工程项目集合
private long total;// 总数
public List<CbhsProject>  getResult(){
    return this.result;
}
public void setResult(List<CbhsProject> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}