package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsCbExaminer implements Serializable{
private static final long serialVersionUID = 30000005L;

private int oid;// 主键（审核信息）
private int projectOid;// 所属工程项目ID CbhsProject
private int type;// 审核类型 1间接成本 2管理费用 3零星用工 4机械成本 5自营其他费用 6自营材料成本 7分包临建项目
private int cbOid;// 对应的成本ID
private int deptOid;// 部门ID
private String  deptName;// 部门名称
private String  extStr;// 额外信息
private int completeState;// 完成状态 1、审核中 2、审核通过 3、审核拒绝 4、撤销
private String  title;// 标题
private String  alert;// 内容
private int personOid;// 创建成本的人员Oid
private String  personName;// 创建人名称
private String  createTimeStr;// 创建时间
private long createTime;// 创建时间
private int shPersonOid;// 当前审核人ID
private int shorder;// 当前审核顺序
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

public int  getType(){ 

    return this.type;

}

public void setType(int type){
 
        this.type=type;

}

public int  getCbOid(){ 

    return this.cbOid;

}

public void setCbOid(int cbOid){
 
        this.cbOid=cbOid;

}

public int  getDeptOid(){ 

    return this.deptOid;

}

public void setDeptOid(int deptOid){
 
        this.deptOid=deptOid;

}

public String  getDeptName(){ 

    return this.deptName;

}

public void setDeptName(String deptName){
 
        this.deptName=deptName;

}

public String  getExtStr(){ 

    return this.extStr;

}

public void setExtStr(String extStr){
 
        this.extStr=extStr;

}

public int  getCompleteState(){ 

    return this.completeState;

}

public void setCompleteState(int completeState){
 
        this.completeState=completeState;

}

public String  getTitle(){ 

    return this.title;

}

public void setTitle(String title){
 
        this.title=title;

}

public String  getAlert(){ 

    return this.alert;

}

public void setAlert(String alert){
 
        this.alert=alert;

}

public int  getPersonOid(){ 

    return this.personOid;

}

public void setPersonOid(int personOid){
 
        this.personOid=personOid;

}

public String  getPersonName(){ 

    return this.personName;

}

public void setPersonName(String personName){
 
        this.personName=personName;

}

public String  getCreateTimeStr(){ 

    return this.createTimeStr;

}

public void setCreateTimeStr(String createTimeStr){
 
        this.createTimeStr=createTimeStr;

}

public long  getCreateTime(){ 

    return this.createTime;

}

public void setCreateTime(long createTime){
 
        this.createTime=createTime;

}

public int  getShPersonOid(){ 

    return this.shPersonOid;

}

public void setShPersonOid(int shPersonOid){
 
        this.shPersonOid=shPersonOid;

}

public int  getShorder(){ 

    return this.shorder;

}

public void setShorder(int shorder){
 
        this.shorder=shorder;

}


}