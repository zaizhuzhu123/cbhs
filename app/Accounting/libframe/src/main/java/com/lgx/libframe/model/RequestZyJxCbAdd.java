package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestZyJxCbAdd implements Serializable{
private static final long serialVersionUID = 10000000L;

private  CbhsDaysZyJxCb  cb;// 自营机械成本
private int submitType;// 提交方式(0默认提交 1审核提交)
public CbhsDaysZyJxCb  getCb(){ 

    return this.cb;

}

public void setCb(CbhsDaysZyJxCb cb){
 
        this.cb=cb;

}

public int  getSubmitType(){ 

    return this.submitType;

}

public void setSubmitType(int submitType){
 
        this.submitType=submitType;

}


}