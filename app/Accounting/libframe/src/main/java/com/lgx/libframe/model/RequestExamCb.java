package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestExamCb implements Serializable{
private static final long serialVersionUID = 10000000L;

private int examOid;// 审核任务ID
private int shStatus;// 审核通过(1批准 2拒绝)
private String  remark;// 备注说明
public int  getExamOid(){ 

    return this.examOid;

}

public void setExamOid(int examOid){
 
        this.examOid=examOid;

}

public int  getShStatus(){ 

    return this.shStatus;

}

public void setShStatus(int shStatus){
 
        this.shStatus=shStatus;

}

public String  getRemark(){ 

    return this.remark;

}

public void setRemark(String remark){
 
        this.remark=remark;

}


}