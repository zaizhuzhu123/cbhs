package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsZdgxhsGZ implements Serializable{
private static final long serialVersionUID = 1000000005L;

private int oid;// 主键
private int zytjOid;// (重点工序核算)
private int gzOid;// 工种编号
private int grCount;// 工人数量
private double gzprice;// 工资
private double gzhj;// 工资合计
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public int  getZytjOid(){ 

    return this.zytjOid;

}

public void setZytjOid(int zytjOid){
 
        this.zytjOid=zytjOid;

}

public int  getGzOid(){ 

    return this.gzOid;

}

public void setGzOid(int gzOid){
 
        this.gzOid=gzOid;

}

public int  getGrCount(){ 

    return this.grCount;

}

public void setGrCount(int grCount){
 
        this.grCount=grCount;

}

public double  getGzprice(){ 

    return this.gzprice;

}

public void setGzprice(double gzprice){
 
        this.gzprice=gzprice;

}

public double  getGzhj(){ 

    return this.gzhj;

}

public void setGzhj(double gzhj){
 
        this.gzhj=gzhj;

}


}