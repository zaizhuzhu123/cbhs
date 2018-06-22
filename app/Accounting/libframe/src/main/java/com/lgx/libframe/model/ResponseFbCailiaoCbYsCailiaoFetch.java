package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseFbCailiaoCbYsCailiaoFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsCailiao> result;;// 
private long total;// 
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