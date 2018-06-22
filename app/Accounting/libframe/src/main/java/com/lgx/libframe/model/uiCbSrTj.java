package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class uiCbSrTj implements Serializable{
private static final long serialVersionUID = 100000004L;

private String  dateStr;// 日期
private double total;// 值
public String  getDateStr(){ 

    return this.dateStr;

}

public void setDateStr(String dateStr){
 
        this.dateStr=dateStr;

}

public double  getTotal(){ 

    return this.total;

}

public void setTotal(double total){
 
        this.total=total;

}


}