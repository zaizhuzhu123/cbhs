package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestCancelExam implements Serializable{
private static final long serialVersionUID = 10000000L;

private int examOid;// 审核任务ID
public int  getExamOid(){ 

    return this.examOid;

}

public void setExamOid(int examOid){
 
        this.examOid=examOid;

}


}