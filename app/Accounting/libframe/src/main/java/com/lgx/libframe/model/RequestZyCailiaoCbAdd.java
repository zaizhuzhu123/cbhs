package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestZyCailiaoCbAdd implements Serializable{
private static final long serialVersionUID = 10000000L;

private List<CbhsDaysZyCailiaoCb> yss;;// 自营材料成本集合 可批量添加
private int submitType;// 提交方式(0默认提交 1审核提交)
public List<CbhsDaysZyCailiaoCb>  getYss(){
    return this.yss;
}
public void setYss(List<CbhsDaysZyCailiaoCb> yss){
    this.yss=yss;
}

public int  getSubmitType(){ 

    return this.submitType;

}

public void setSubmitType(int submitType){
 
        this.submitType=submitType;

}


}