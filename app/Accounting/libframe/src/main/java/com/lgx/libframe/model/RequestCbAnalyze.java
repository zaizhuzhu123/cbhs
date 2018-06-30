package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestCbAnalyze implements Serializable{
private static final long serialVersionUID = 10000000L;

private int projectOid;// 工程项目ID
private long monthStart;// 开始月份
private long monthEnd;// 结束月份
public int  getProjectOid(){ 

    return this.projectOid;

}

public void setProjectOid(int projectOid){
 
        this.projectOid=projectOid;

}

public long  getMonthStart(){ 

    return this.monthStart;

}

public void setMonthStart(long monthStart){
 
        this.monthStart=monthStart;

}

public long  getMonthEnd(){ 

    return this.monthEnd;

}

public void setMonthEnd(long monthEnd){
 
        this.monthEnd=monthEnd;

}


}