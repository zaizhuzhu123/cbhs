package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseRoleFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsRole> result;;// 角色信息集合
private long total;// 总条数
public List<CbhsRole>  getResult(){
    return this.result;
}
public void setResult(List<CbhsRole> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}