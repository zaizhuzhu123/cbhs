package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsCbExaminerRule(审批规则) implements Serializable{
private static final long serialVersionUID = 30000007L;

private int oid;// 主键(成本审核规则)
private int projectOid;// 所属工程项目ID CbhsProject
private  int  deptOid;// 部门ID 数字
private String  deptNames;// 部门名称
private int personOid1;// 审核人1ID
private String  personName1;// 审核人1名称
private int personOid2;// 审核人2ID
private String  personName2;// 审核人2名称
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

public int  getDeptOid(){ 

    return this.deptOid;

}

public void setDeptOid(int deptOid){
 
        this.deptOid=deptOid;

}

public String  getDeptNames(){ 

    return this.deptNames;

}

public void setDeptNames(String deptNames){
 
        this.deptNames=deptNames;

}

public int  getPersonOid1(){ 

    return this.personOid1;

}

public void setPersonOid1(int personOid1){
 
        this.personOid1=personOid1;

}

public String  getPersonName1(){ 

    return this.personName1;

}

public void setPersonName1(String personName1){
 
        this.personName1=personName1;

}

public int  getPersonOid2(){ 

    return this.personOid2;

}

public void setPersonOid2(int personOid2){
 
        this.personOid2=personOid2;

}

public String  getPersonName2(){ 

    return this.personName2;

}

public void setPersonName2(String personName2){
 
        this.personName2=personName2;

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