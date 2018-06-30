package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class uiCbAnalyze implements Serializable{
private static final long serialVersionUID = 10000000011L;

private double cbTotal;// 总支出
private double srTotal;// 总收入
private double rlTotal;// 人力总支出
private double rlSpecific;// 人力占的比重
private double cailiaoTotal;// 材料总支出
private double cailiaoSpecific;// 材料占的比重
private double jxTotal;// 机械总支出
private double jxSpecific;// 机械占的比重
private double qttotal;// 其他直接成本总支出
private double qtSpecific;// 其他直接占的比重
private double fbgctotal;// 分包工程总支出
private double fbgcSpecific;// 分包工程占的比重
private double fbljxmtotal;// 分包临建项目总支出
private double fbljxmSpecific;// 分包临建项目占的比重
private double rygztotal;// 人员工资总支出
private double rygzSpecific;// 人员工资占的比重
private double clftotal;// 差旅费总支出
private double clfSpecific;// 差旅费占的比重
private double bgftotal;// 办公费总支出
private double bgfSpecific;// 办公费占的比重
private double ywjftotal;// 业务经费总支出
private double ywjfSpecific;// 业务经费占的比重
private double xlftotal;// 修理费总支出
private double xlfSpecific;// 修理费占的比重
private double qtfytotal;// 其他费用总支出
private double qtfySpecific;// 其他费用占的比重
private double qyjgfytotal;// 企业经管费用总支出
private double qyjgfySpecific;// 企业经管费用占的比重
private double sjtotal;// 税金总支出
private double sjSpecific;// 税金占的比重
private double fbstjtotal;// 分包商统计总支出
private double fbstjSpecific;// 分包商统计占的比重
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

public double  getRlTotal(){ 

    return this.rlTotal;

}

public void setRlTotal(double rlTotal){
 
        this.rlTotal=rlTotal;

}

public double  getRlSpecific(){ 

    return this.rlSpecific;

}

public void setRlSpecific(double rlSpecific){
 
        this.rlSpecific=rlSpecific;

}

public double  getCailiaoTotal(){ 

    return this.cailiaoTotal;

}

public void setCailiaoTotal(double cailiaoTotal){
 
        this.cailiaoTotal=cailiaoTotal;

}

public double  getCailiaoSpecific(){ 

    return this.cailiaoSpecific;

}

public void setCailiaoSpecific(double cailiaoSpecific){
 
        this.cailiaoSpecific=cailiaoSpecific;

}

public double  getJxTotal(){ 

    return this.jxTotal;

}

public void setJxTotal(double jxTotal){
 
        this.jxTotal=jxTotal;

}

public double  getJxSpecific(){ 

    return this.jxSpecific;

}

public void setJxSpecific(double jxSpecific){
 
        this.jxSpecific=jxSpecific;

}

public double  getQttotal(){ 

    return this.qttotal;

}

public void setQttotal(double qttotal){
 
        this.qttotal=qttotal;

}

public double  getQtSpecific(){ 

    return this.qtSpecific;

}

public void setQtSpecific(double qtSpecific){
 
        this.qtSpecific=qtSpecific;

}

public double  getFbgctotal(){ 

    return this.fbgctotal;

}

public void setFbgctotal(double fbgctotal){
 
        this.fbgctotal=fbgctotal;

}

public double  getFbgcSpecific(){ 

    return this.fbgcSpecific;

}

public void setFbgcSpecific(double fbgcSpecific){
 
        this.fbgcSpecific=fbgcSpecific;

}

public double  getFbljxmtotal(){ 

    return this.fbljxmtotal;

}

public void setFbljxmtotal(double fbljxmtotal){
 
        this.fbljxmtotal=fbljxmtotal;

}

public double  getFbljxmSpecific(){ 

    return this.fbljxmSpecific;

}

public void setFbljxmSpecific(double fbljxmSpecific){
 
        this.fbljxmSpecific=fbljxmSpecific;

}

public double  getRygztotal(){ 

    return this.rygztotal;

}

public void setRygztotal(double rygztotal){
 
        this.rygztotal=rygztotal;

}

public double  getRygzSpecific(){ 

    return this.rygzSpecific;

}

public void setRygzSpecific(double rygzSpecific){
 
        this.rygzSpecific=rygzSpecific;

}

public double  getClftotal(){ 

    return this.clftotal;

}

public void setClftotal(double clftotal){
 
        this.clftotal=clftotal;

}

public double  getClfSpecific(){ 

    return this.clfSpecific;

}

public void setClfSpecific(double clfSpecific){
 
        this.clfSpecific=clfSpecific;

}

public double  getBgftotal(){ 

    return this.bgftotal;

}

public void setBgftotal(double bgftotal){
 
        this.bgftotal=bgftotal;

}

public double  getBgfSpecific(){ 

    return this.bgfSpecific;

}

public void setBgfSpecific(double bgfSpecific){
 
        this.bgfSpecific=bgfSpecific;

}

public double  getYwjftotal(){ 

    return this.ywjftotal;

}

public void setYwjftotal(double ywjftotal){
 
        this.ywjftotal=ywjftotal;

}

public double  getYwjfSpecific(){ 

    return this.ywjfSpecific;

}

public void setYwjfSpecific(double ywjfSpecific){
 
        this.ywjfSpecific=ywjfSpecific;

}

public double  getXlftotal(){ 

    return this.xlftotal;

}

public void setXlftotal(double xlftotal){
 
        this.xlftotal=xlftotal;

}

public double  getXlfSpecific(){ 

    return this.xlfSpecific;

}

public void setXlfSpecific(double xlfSpecific){
 
        this.xlfSpecific=xlfSpecific;

}

public double  getQtfytotal(){ 

    return this.qtfytotal;

}

public void setQtfytotal(double qtfytotal){
 
        this.qtfytotal=qtfytotal;

}

public double  getQtfySpecific(){ 

    return this.qtfySpecific;

}

public void setQtfySpecific(double qtfySpecific){
 
        this.qtfySpecific=qtfySpecific;

}

public double  getQyjgfytotal(){ 

    return this.qyjgfytotal;

}

public void setQyjgfytotal(double qyjgfytotal){
 
        this.qyjgfytotal=qyjgfytotal;

}

public double  getQyjgfySpecific(){ 

    return this.qyjgfySpecific;

}

public void setQyjgfySpecific(double qyjgfySpecific){
 
        this.qyjgfySpecific=qyjgfySpecific;

}

public double  getSjtotal(){ 

    return this.sjtotal;

}

public void setSjtotal(double sjtotal){
 
        this.sjtotal=sjtotal;

}

public double  getSjSpecific(){ 

    return this.sjSpecific;

}

public void setSjSpecific(double sjSpecific){
 
        this.sjSpecific=sjSpecific;

}

public double  getFbstjtotal(){ 

    return this.fbstjtotal;

}

public void setFbstjtotal(double fbstjtotal){
 
        this.fbstjtotal=fbstjtotal;

}

public double  getFbstjSpecific(){ 

    return this.fbstjSpecific;

}

public void setFbstjSpecific(double fbstjSpecific){
 
        this.fbstjSpecific=fbstjSpecific;

}


}