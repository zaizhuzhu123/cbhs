package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsGlfyRule(管理费用上缴公式) implements Serializable{
private static final long serialVersionUID = 100000011L;

private int oid;// 主键（临建项目）(创建不填|修改必填)
private int projectOid;// 必填|所属工程项目ID CbhsProject
private double p_sjgs_rule;// 必填|上缴公司 
private double p_ztbfy_rule;// 必填|招投标费用 
private double p_kdqqysds_rule;// 必填|跨地区企业所得税 
private double p_yhsjqtsj_rule;// 必填|印花税及其他税金 
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

public double  getP_sjgs_rule(){ 

    return this.p_sjgs_rule;

}

public void setP_sjgs_rule(double p_sjgs_rule){
 
        this.p_sjgs_rule=p_sjgs_rule;

}

public double  getP_ztbfy_rule(){ 

    return this.p_ztbfy_rule;

}

public void setP_ztbfy_rule(double p_ztbfy_rule){
 
        this.p_ztbfy_rule=p_ztbfy_rule;

}

public double  getP_kdqqysds_rule(){ 

    return this.p_kdqqysds_rule;

}

public void setP_kdqqysds_rule(double p_kdqqysds_rule){
 
        this.p_kdqqysds_rule=p_kdqqysds_rule;

}

public double  getP_yhsjqtsj_rule(){ 

    return this.p_yhsjqtsj_rule;

}

public void setP_yhsjqtsj_rule(double p_yhsjqtsj_rule){
 
        this.p_yhsjqtsj_rule=p_yhsjqtsj_rule;

}


}