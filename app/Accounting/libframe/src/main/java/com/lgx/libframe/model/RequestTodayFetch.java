package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestTodayFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int projectOid;// 工程项目ID
private long daysStamp;// 日期
public int  getProjectOid(){ 

    return this.projectOid;

}

public void setProjectOid(int projectOid){
 
        this.projectOid=projectOid;

}

public long  getDaysStamp(){ 

    return this.daysStamp;

}

public void setDaysStamp(long daysStamp){
 
        this.daysStamp=daysStamp;

}


}