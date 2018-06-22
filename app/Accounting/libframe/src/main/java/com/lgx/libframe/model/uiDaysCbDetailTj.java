package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class uiDaysCbDetailTj implements Serializable{
private static final long serialVersionUID = 100000005L;

private double jjcb;// 间接成本
private double zycailiaocb;// 自营材料成本
private double zyjxcb;// 自营机械成本
private double lxyg;// 零星用工
private double qtfy;// 其他费用
private double fbcb;// 分包成本费用
private double fbcailiaocb;// 分包材料成本
private double ljxm;// 临建项目
private double glfy;// 管理费用
private double cbTotal;// 总支出
private double srTotal;// 总收入
private double ykTotal;// 总盈亏
public double  getJjcb(){ 

    return this.jjcb;

}

public void setJjcb(double jjcb){
 
        this.jjcb=jjcb;

}

public double  getZycailiaocb(){ 

    return this.zycailiaocb;

}

public void setZycailiaocb(double zycailiaocb){
 
        this.zycailiaocb=zycailiaocb;

}

public double  getZyjxcb(){ 

    return this.zyjxcb;

}

public void setZyjxcb(double zyjxcb){
 
        this.zyjxcb=zyjxcb;

}

public double  getLxyg(){ 

    return this.lxyg;

}

public void setLxyg(double lxyg){
 
        this.lxyg=lxyg;

}

public double  getQtfy(){ 

    return this.qtfy;

}

public void setQtfy(double qtfy){
 
        this.qtfy=qtfy;

}

public double  getFbcb(){ 

    return this.fbcb;

}

public void setFbcb(double fbcb){
 
        this.fbcb=fbcb;

}

public double  getFbcailiaocb(){ 

    return this.fbcailiaocb;

}

public void setFbcailiaocb(double fbcailiaocb){
 
        this.fbcailiaocb=fbcailiaocb;

}

public double  getLjxm(){ 

    return this.ljxm;

}

public void setLjxm(double ljxm){
 
        this.ljxm=ljxm;

}

public double  getGlfy(){ 

    return this.glfy;

}

public void setGlfy(double glfy){
 
        this.glfy=glfy;

}

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


}