package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class uiAbnormal implements Serializable{
private static final long serialVersionUID = 10000000010L;

private double srTotal;// 总收入
private double cbTotal;// 总支出
private  long  tjTime;// 统计时间
private  boolean abnormal;// 是否异常
public double  getSrTotal(){ 

    return this.srTotal;

}

public void setSrTotal(double srTotal){
 
        this.srTotal=srTotal;

}

public double  getCbTotal(){ 

    return this.cbTotal;

}

public void setCbTotal(double cbTotal){
 
        this.cbTotal=cbTotal;

}

public long  getTjTime(){ 

    return this.tjTime;

}

public void setTjTime(long tjTime){
 
        this.tjTime=tjTime;

}

public boolean  getAbnormal(){ 

    return this.abnormal;

}

public void setAbnormal(boolean abnormal){
 
        this.abnormal=abnormal;

}


}