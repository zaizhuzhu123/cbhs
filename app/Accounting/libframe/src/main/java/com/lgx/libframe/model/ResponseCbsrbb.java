package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class ResponseCbsrbb implements Serializable{
private static final long serialVersionUID = 10000001L;

private List<uiCbSrTj> cbs;;// 成本集合
private List<uiCbSrTj> srs;;// 收入集合
public List<uiCbSrTj>  getCbs(){
    return this.cbs;
}
public void setCbs(List<uiCbSrTj> cbs){
    this.cbs=cbs;
}

public List<uiCbSrTj>  getSrs(){
    return this.srs;
}
public void setSrs(List<uiCbSrTj> srs){
    this.srs=srs;
}


}