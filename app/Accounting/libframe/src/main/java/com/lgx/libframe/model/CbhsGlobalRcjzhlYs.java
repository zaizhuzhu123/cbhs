package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsGlobalRcjzhlYs implements Serializable{
private static final long serialVersionUID = 10000003L;

private int oid;// 全局人材机预算主键ID(创建不填|修改必填)
private int projectOid;// 必填|所属工程项目ID CbhsProject
private String  nodeId;// 必填|项目编号
private String  name;// 必填|项目名称
private String  count;// 必填|工程量
private String  unit;// 必填|单位
private double tong;// 必填|砼含量
private double totaPrice;// 必填|总金额
private double r_zc;// 必填|主材价格
private double r_rg;// 必填|人工价格
private double r_jx;// 必填|机械价格
private double r_qt;// 必填|其他价格
private double r_unitHj;// 必填|单价合计
private double c_cy;// 必填|柴油耗量
private double c_zy;// 必填|炸药耗量
private double c_fdlg;// 必填|非电雷管
private double c_tpzs;// 必填|铜片止水
private double c_gksn;// 必填|高抗水泥
private double c_sn;// 必填|水泥
private double c_fmh;// 必填|粉煤灰
private double c_sha;// 必填|砂
private double c_shi;// 必填|石
private double c_shui;// 必填|水
private double c_wjj;// 必填|外加剂
private double c_nq;// 必填|沥青
private double c_gj;// 必填|钢筋
private double rg_count;// 必填|人工工时数量
private double j_yyldz;// 必填|液压履带钻
private double j_zxqc;// 必填|自卸汽车
private double j_wjjyy;// 必填|挖掘机 液压
private int opUserOid;// 操作人ID
private String  opUserName;// 操作人姓名
private String  opTimeStr;// 操作时间
private long opTime;// 操作时间
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public int  getProjectOid(){ 

    return this.projectOid;

}

public void setProjectOid(int projectOid){
 
        this.projectOid=projectOid;

}

public String  getNodeId(){ 

    return this.nodeId;

}

public void setNodeId(String nodeId){
 
        this.nodeId=nodeId;

}

public String  getName(){ 

    return this.name;

}

public void setName(String name){
 
        this.name=name;

}

public String  getCount(){ 

    return this.count;

}

public void setCount(String count){
 
        this.count=count;

}

public String  getUnit(){ 

    return this.unit;

}

public void setUnit(String unit){
 
        this.unit=unit;

}

public double  getTong(){ 

    return this.tong;

}

public void setTong(double tong){
 
        this.tong=tong;

}

public double  getTotaPrice(){ 

    return this.totaPrice;

}

public void setTotaPrice(double totaPrice){
 
        this.totaPrice=totaPrice;

}

public double  getR_zc(){ 

    return this.r_zc;

}

public void setR_zc(double r_zc){
 
        this.r_zc=r_zc;

}

public double  getR_rg(){ 

    return this.r_rg;

}

public void setR_rg(double r_rg){
 
        this.r_rg=r_rg;

}

public double  getR_jx(){ 

    return this.r_jx;

}

public void setR_jx(double r_jx){
 
        this.r_jx=r_jx;

}

public double  getR_qt(){ 

    return this.r_qt;

}

public void setR_qt(double r_qt){
 
        this.r_qt=r_qt;

}

public double  getR_unitHj(){ 

    return this.r_unitHj;

}

public void setR_unitHj(double r_unitHj){
 
        this.r_unitHj=r_unitHj;

}

public double  getC_cy(){ 

    return this.c_cy;

}

public void setC_cy(double c_cy){
 
        this.c_cy=c_cy;

}

public double  getC_zy(){ 

    return this.c_zy;

}

public void setC_zy(double c_zy){
 
        this.c_zy=c_zy;

}

public double  getC_fdlg(){ 

    return this.c_fdlg;

}

public void setC_fdlg(double c_fdlg){
 
        this.c_fdlg=c_fdlg;

}

public double  getC_tpzs(){ 

    return this.c_tpzs;

}

public void setC_tpzs(double c_tpzs){
 
        this.c_tpzs=c_tpzs;

}

public double  getC_gksn(){ 

    return this.c_gksn;

}

public void setC_gksn(double c_gksn){
 
        this.c_gksn=c_gksn;

}

public double  getC_sn(){ 

    return this.c_sn;

}

public void setC_sn(double c_sn){
 
        this.c_sn=c_sn;

}

public double  getC_fmh(){ 

    return this.c_fmh;

}

public void setC_fmh(double c_fmh){
 
        this.c_fmh=c_fmh;

}

public double  getC_sha(){ 

    return this.c_sha;

}

public void setC_sha(double c_sha){
 
        this.c_sha=c_sha;

}

public double  getC_shi(){ 

    return this.c_shi;

}

public void setC_shi(double c_shi){
 
        this.c_shi=c_shi;

}

public double  getC_shui(){ 

    return this.c_shui;

}

public void setC_shui(double c_shui){
 
        this.c_shui=c_shui;

}

public double  getC_wjj(){ 

    return this.c_wjj;

}

public void setC_wjj(double c_wjj){
 
        this.c_wjj=c_wjj;

}

public double  getC_nq(){ 

    return this.c_nq;

}

public void setC_nq(double c_nq){
 
        this.c_nq=c_nq;

}

public double  getC_gj(){ 

    return this.c_gj;

}

public void setC_gj(double c_gj){
 
        this.c_gj=c_gj;

}

public double  getRg_count(){ 

    return this.rg_count;

}

public void setRg_count(double rg_count){
 
        this.rg_count=rg_count;

}

public double  getJ_yyldz(){ 

    return this.j_yyldz;

}

public void setJ_yyldz(double j_yyldz){
 
        this.j_yyldz=j_yyldz;

}

public double  getJ_zxqc(){ 

    return this.j_zxqc;

}

public void setJ_zxqc(double j_zxqc){
 
        this.j_zxqc=j_zxqc;

}

public double  getJ_wjjyy(){ 

    return this.j_wjjyy;

}

public void setJ_wjjyy(double j_wjjyy){
 
        this.j_wjjyy=j_wjjyy;

}

public int  getOpUserOid(){ 

    return this.opUserOid;

}

public void setOpUserOid(int opUserOid){
 
        this.opUserOid=opUserOid;

}

public String  getOpUserName(){ 

    return this.opUserName;

}

public void setOpUserName(String opUserName){
 
        this.opUserName=opUserName;

}

public String  getOpTimeStr(){ 

    return this.opTimeStr;

}

public void setOpTimeStr(String opTimeStr){
 
        this.opTimeStr=opTimeStr;

}

public long  getOpTime(){ 

    return this.opTime;

}

public void setOpTime(long opTime){
 
        this.opTime=opTime;

}


}