package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseFbCailiaoCbYsAdd implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsMonthFbCailiaoCbYs> yss;;// 分包材料成本
public List<CbhsMonthFbCailiaoCbYs>  getYss(){
    return this.yss;
}
public void setYss(List<CbhsMonthFbCailiaoCbYs> yss){
    this.yss=yss;
}


}