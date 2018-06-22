package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseFbCompanyFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsFbCompany> result;;// 分包公司集合
private long total;// 总数
public List<CbhsFbCompany>  getResult(){
    return this.result;
}
public void setResult(List<CbhsFbCompany> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}