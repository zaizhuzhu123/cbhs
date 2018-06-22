package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseMbYsTotalFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<uiCbhsMonthWebTotal> result;;// 结果
private long total;// 总条数
private double monthYsTotal;// 月份所有部门总预算
public List<uiCbhsMonthWebTotal>  getResult(){
    return this.result;
}
public void setResult(List<uiCbhsMonthWebTotal> result){
    this.result=result;
}

public long  getTotal(){ 

    return this.total;

}

public void setTotal(long total){
 
        this.total=total;

}

public double  getMonthYsTotal(){ 

    return this.monthYsTotal;

}

public void setMonthYsTotal(double monthYsTotal){
 
        this.monthYsTotal=monthYsTotal;

}


}