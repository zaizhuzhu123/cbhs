package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestGcsrDel implements Serializable{
private static final long serialVersionUID = 10000000L;

private List<Integer> oids;;// 工程收入主键集合(蹇呭～)
public List<Integer>  getOids(){
    return this.oids;
}
public void setOids(List<Integer> oids){
    this.oids=oids;
}


}