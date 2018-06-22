package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseZyCailiaoCbAdd implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<CbhsDaysZyCailiaoCb> yss;;// 自营材料成本集合
public List<CbhsDaysZyCailiaoCb>  getYss(){
    return this.yss;
}
public void setYss(List<CbhsDaysZyCailiaoCb> yss){
    this.yss=yss;
}


}