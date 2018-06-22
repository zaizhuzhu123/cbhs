package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class uiExceedInfo implements Serializable{
private static final long serialVersionUID = 100000003L;

private String  name;// 超标项名称
private double value;// 超标值
private String  unit;// 单位
public String  getName(){ 

    return this.name;

}

public void setName(String name){
 
        this.name=name;

}

public double  getValue(){ 

    return this.value;

}

public void setValue(double value){
 
        this.value=value;

}

public String  getUnit(){ 

    return this.unit;

}

public void setUnit(String unit){
 
        this.unit=unit;

}


}