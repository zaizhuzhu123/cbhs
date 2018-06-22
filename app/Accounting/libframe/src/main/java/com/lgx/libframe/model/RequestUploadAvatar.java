package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestUploadAvatar implements Serializable{
private static final long serialVersionUID = 10000000L;

private int avatarOid;// 上传的资源ID
public int  getAvatarOid(){ 

    return this.avatarOid;

}

public void setAvatarOid(int avatarOid){
 
        this.avatarOid=avatarOid;

}


}