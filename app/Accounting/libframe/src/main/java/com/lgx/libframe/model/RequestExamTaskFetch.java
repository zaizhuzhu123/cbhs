package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestExamTaskFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int oid;// 审核任务ID
private int projectOid;// 工程项目ID
private int pageNum;// 页码
private int pageSize;// 数量
private int startOid;// 开始ID
private int type;// 类型( 0 用户参与的审核  1 轮到用户自己审核的 2 审核完成的)
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

public int  getType(){ 

    return this.type;

}

public void setType(int type){
 
        this.type=type;

}


}