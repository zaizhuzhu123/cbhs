package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestExamTaskStepFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int examOid;// 审核任务ID
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始ID
public int  getExamOid(){ 

    return this.examOid;

}

public void setExamOid(int examOid){
 
        this.examOid=examOid;

}

public int  getPageNum(){ 

    return this.pageNum;

}

public void setPageNum(int pageNum){
 
        this.pageNum=pageNum;

}

public int  getPageSize(){ 

    return this.pageSize;

}

public void setPageSize(int pageSize){
 
        this.pageSize=pageSize;

}

public int  getStartOid(){ 

    return this.startOid;

}

public void setStartOid(int startOid){
 
        this.startOid=startOid;

}


}