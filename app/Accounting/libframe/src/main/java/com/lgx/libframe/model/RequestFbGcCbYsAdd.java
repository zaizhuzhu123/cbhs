package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestFbGcCbYsAdd implements Serializable{
private static final long serialVersionUID = 10000000L;

private List<CbhsMonthFbGcCbYs> yss;;// 分包工程
public List<CbhsMonthFbGcCbYs>  getYss(){
    return this.yss;
}
public void setYss(List<CbhsMonthFbGcCbYs> yss){
    this.yss=yss;
}


}