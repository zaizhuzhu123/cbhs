package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseZyGclFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsGclQdYs> result;;// 工程项清单集合
private long total;// 总条数
public List<CbhsGclQdYs>  getResult(){
    return this.result;
}
public void setResult(List<CbhsGclQdYs> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}


}