package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsVersion implements Serializable{
private static final long serialVersionUID = 100000013L;

private int oid;// 主键ID
private String  opTimeStr;// 操作时间
private long opTime;// 操作时间
private int versionCode;// 版本号(例如1.0.0 就填100 这样 三位数)
private String  pushtitle;// 推送标题
private String  pushAlert;// 推送内容
private String  remark;// 更新详情
private int fileOid;// 资源Oid 调用上传接口后 返回的文件ID
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public String  getOpTimeStr(){ 

    return this.opTimeStr;

}

public void setOpTimeStr(String opTimeStr){
 
        this.opTimeStr=opTimeStr;

}

public long  getOpTime(){ 

    return this.opTime;

}

public void setOpTime(long opTime){
 
        this.opTime=opTime;

}

public int  getVersionCode(){ 

    return this.versionCode;

}

public void setVersionCode(int versionCode){
 
        this.versionCode=versionCode;

}

public String  getPushtitle(){ 

    return this.pushtitle;

}

public void setPushtitle(String pushtitle){
 
        this.pushtitle=pushtitle;

}

public String  getPushAlert(){ 

    return this.pushAlert;

}

public void setPushAlert(String pushAlert){
 
        this.pushAlert=pushAlert;

}

public String  getRemark(){ 

    return this.remark;

}

public void setRemark(String remark){
 
        this.remark=remark;

}

public int  getFileOid(){ 

    return this.fileOid;

}

public void setFileOid(int fileOid){
 
        this.fileOid=fileOid;

}


}