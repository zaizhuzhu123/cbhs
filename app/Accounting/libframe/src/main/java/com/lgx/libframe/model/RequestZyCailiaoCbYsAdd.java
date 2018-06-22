package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestZyCailiaoCbYsAdd implements Serializable{
private static final long serialVersionUID = 10000000L;

private List<CbhsMonthZyCailiaoCbYs> yss;;// 自营材料成本集合 可批量添加
public List<CbhsMonthZyCailiaoCbYs>  getYss(){
    return this.yss;
}
public void setYss(List<CbhsMonthZyCailiaoCbYs> yss){
    this.yss=yss;
}


}