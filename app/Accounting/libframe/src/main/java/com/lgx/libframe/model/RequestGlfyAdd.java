package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestGlfyAdd implements Serializable{
private static final long serialVersionUID = 10000000L;

private  CbhsDaysGlfyYs  cb;// 管理经费
private int submitType;// 提交方式(0默认提交 1审核提交)
public CbhsDaysGlfyYs  getCb(){ 

    return this.cb;

}

public void setCb(CbhsDaysGlfyYs cb){
 
        this.cb=cb;

}

public int  getSubmitType(){ 

    return this.submitType;

}

public void setSubmitType(int submitType){
 
        this.submitType=submitType;

}


}