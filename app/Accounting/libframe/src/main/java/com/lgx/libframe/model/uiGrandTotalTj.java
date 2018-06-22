package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class uiGrandTotalTj implements Serializable{
private static final long serialVersionUID = 1000000006L;

private double cbTotal;// 总支出
private double srTotal;// 总收入
private double ykTotal;// 总盈亏
private  ArrayList<uiDeptGrandTotalTj>  deptGrandTotals;// 部门明细
public double  getCbTotal(){ 

    return this.cbTotal;

}

public void setCbTotal(double cbTotal){
 
        this.cbTotal=cbTotal;

}

public double  getSrTotal(){ 

    return this.srTotal;

}

public void setSrTotal(double srTotal){
 
        this.srTotal=srTotal;

}

public double  getYkTotal(){ 

    return this.ykTotal;

}

public void setYkTotal(double ykTotal){
 
        this.ykTotal=ykTotal;

}

public ArrayList<uiDeptGrandTotalTj>  getDeptGrandTotals(){ 

    return this.deptGrandTotals;

}

public void setDeptGrandTotals(ArrayList<uiDeptGrandTotalTj> deptGrandTotals){
 
        this.deptGrandTotals=deptGrandTotals;

}


}