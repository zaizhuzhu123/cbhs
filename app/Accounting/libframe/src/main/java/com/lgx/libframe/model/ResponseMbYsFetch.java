package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseMbYsFetch implements Serializable{
private static final long serialVersionUID = 10000001L;

private  CbhsMonthJjcbYs  jjcbTotal;// 间接成本总量
private  CbhsMonthGlfyYs  glfyTotal;// 管理费用总量
private  uiCbhsMonthZjCbTotal  zjcbTotal;// 直接成本总量
public CbhsMonthJjcbYs  getJjcbTotal(){ 

    return this.jjcbTotal;

}

public void setJjcbTotal(CbhsMonthJjcbYs jjcbTotal){
 
        this.jjcbTotal=jjcbTotal;

}

public CbhsMonthGlfyYs  getGlfyTotal(){ 

    return this.glfyTotal;

}

public void setGlfyTotal(CbhsMonthGlfyYs glfyTotal){
 
        this.glfyTotal=glfyTotal;

}

public uiCbhsMonthZjCbTotal  getZjcbTotal(){ 

    return this.zjcbTotal;

}

public void setZjcbTotal(uiCbhsMonthZjCbTotal zjcbTotal){
 
        this.zjcbTotal=zjcbTotal;

}


}