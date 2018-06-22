package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestCbhsGlfyRuleFetch implements Serializable{
private static final long serialVersionUID = 10000000L;

private int projectOid;// 工程项目ID
public int  getProjectOid(){ 

    return this.projectOid;

}

public void setProjectOid(int projectOid){
 
        this.projectOid=projectOid;

}


}