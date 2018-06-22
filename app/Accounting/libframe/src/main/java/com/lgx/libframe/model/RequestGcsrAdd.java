package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestGcsrAdd implements Serializable{
private static final long serialVersionUID = 10000000L;

private List<CbhsDaysGclSr> srs;;// 工程收入
public List<CbhsDaysGclSr>  getSrs(){
    return this.srs;
}
public void setSrs(List<CbhsDaysGclSr> srs){
    this.srs=srs;
}


}