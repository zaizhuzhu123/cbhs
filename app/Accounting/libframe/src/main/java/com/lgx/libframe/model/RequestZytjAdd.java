package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestZytjAdd implements Serializable{
private static final long serialVersionUID = 10000000L;

private  CbhsZytj  cb;// 资源统计
private int submitType;// 提交方式(0默认提交 1审核提交)
public CbhsZytj  getCb(){ 

    return this.cb;

}

public void setCb(CbhsZytj cb){
 
        this.cb=cb;

}

public int  getSubmitType(){ 

    return this.submitType;

}

public void setSubmitType(int submitType){
 
        this.submitType=submitType;

}


}