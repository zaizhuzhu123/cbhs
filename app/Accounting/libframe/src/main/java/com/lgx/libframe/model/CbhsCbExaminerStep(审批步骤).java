package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsCbExaminerStep(审批步骤) implements Serializable{
private static final long serialVersionUID = 30000006L;

private int oid;// 主键（审核信息）
private int taskOid;// 审核任务ID
private int shorder;// 审核顺序
private int shPersonOid;// 审核人ID
private String  shPersonName;// 审核人名称
private String  remark;// 审核人批注
private int stepStatus;// 步骤状态 1、等待 2、待审核 3、审核通过 4、审核拒绝
private String  opTimeStr;// 操作时间
private long opTime;// 操作时间
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public int  getTaskOid(){ 

    return this.taskOid;

}

public void setTaskOid(int taskOid){
 
        this.taskOid=taskOid;

}

public int  getShorder(){ 

    return this.shorder;

}

public void setShorder(int shorder){
 
        this.shorder=shorder;

}

public int  getShPersonOid(){ 

    return this.shPersonOid;

}

public void setShPersonOid(int shPersonOid){
 
        this.shPersonOid=shPersonOid;

}

public String  getShPersonName(){ 

    return this.shPersonName;

}

public void setShPersonName(String shPersonName){
 
        this.shPersonName=shPersonName;

}

public String  getRemark(){ 

    return this.remark;

}

public void setRemark(String remark){
 
        this.remark=remark;

}

public int  getStepStatus(){ 

    return this.stepStatus;

}

public void setStepStatus(int stepStatus){
 
        this.stepStatus=stepStatus;

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