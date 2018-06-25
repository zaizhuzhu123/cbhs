package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestFbLjxmCbAddCount implements Serializable{
private static final long serialVersionUID = 10000000L;

private  CbhsDaysFbLjxmCb  cb;// 分包临建项目
private int submitType;// 提交方式(0默认提交 1审核提交)
public CbhsDaysFbLjxmCb  getCb(){ 

    return this.cb;

}

public void setCb(CbhsDaysFbLjxmCb cb){
 
        this.cb=cb;

}

public int  getSubmitType(){ 

    return this.submitType;

}

public void setSubmitType(int submitType){
 
        this.submitType=submitType;

}


}