package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestCbsrbb implements Serializable{
private static final long serialVersionUID = 10000000L;

private int projectOid;// 工程项目ID
private long daysStart;// 开始日期
private long daysEnd;// 结束日期
public int  getProjectOid(){ 

    return this.projectOid;

}

public void setProjectOid(int projectOid){
 
        this.projectOid=projectOid;

}

public long  getDaysStart(){ 

    return this.daysStart;

}

public void setDaysStart(long daysStart){
 
        this.daysStart=daysStart;

}

public long  getDaysEnd(){ 

    return this.daysEnd;

}

public void setDaysEnd(long daysEnd){
 
        this.daysEnd=daysEnd;

}


}