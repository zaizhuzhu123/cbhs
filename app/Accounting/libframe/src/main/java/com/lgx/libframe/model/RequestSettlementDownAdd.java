package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestSettlementDownAdd implements Serializable{
private static final long serialVersionUID = 10000000L;

private  CbhsSettleDown  settle;// 
private int submitType;// 
public CbhsSettleDown  getSettle(){ 

    return this.settle;

}

public void setSettle(CbhsSettleDown settle){
 
        this.settle=settle;

}

public int  getSubmitType(){ 

    return this.submitType;

}

public void setSubmitType(int submitType){
 
        this.submitType=submitType;

}


}