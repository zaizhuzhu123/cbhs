package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsResource(静态资源) implements Serializable{
private static final long serialVersionUID = 30000008L;

private int oid;// 主键(资源ID)
private String  filePath;// 文件路径
private String  url;// 访问路径
private String  oldFileName;// 上传的原文件名
private long fileSize;// 文件大小
private String  contentType;// contentType
private String  prefix;// 后缀名
private int opUserOid;// 操作人ID
private String  opUserName;// 操作人姓名
private String  opTimeStr;// 操作时间
private long opTime;// 操作时间
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public String  getFilePath(){ 

    return this.filePath;

}

public void setFilePath(String filePath){
 
        this.filePath=filePath;

}

public String  getUrl(){ 

    return this.url;

}

public void setUrl(String url){
 
        this.url=url;

}

public String  getOldFileName(){ 

    return this.oldFileName;

}

public void setOldFileName(String oldFileName){
 
        this.oldFileName=oldFileName;

}

public long  getFileSize(){ 

    return this.fileSize;

}

public void setFileSize(long fileSize){
 
        this.fileSize=fileSize;

}

public String  getContentType(){ 

    return this.contentType;

}

public void setContentType(String contentType){
 
        this.contentType=contentType;

}

public String  getPrefix(){ 

    return this.prefix;

}

public void setPrefix(String prefix){
 
        this.prefix=prefix;

}

public int  getOpUserOid(){ 

    return this.opUserOid;

}

public void setOpUserOid(int opUserOid){
 
        this.opUserOid=opUserOid;

}

public String  getOpUserName(){ 

    return this.opUserName;

}

public void setOpUserName(String opUserName){
 
        this.opUserName=opUserName;

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


}