package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class RequestJPushRegID implements Serializable{
private static final long serialVersionUID = 10000000L;

private String  registrationID;// 极光生成的设备ID
public String  getRegistrationID(){ 

    return this.registrationID;

}

public void setRegistrationID(String registrationID){
 
        this.registrationID=registrationID;

}


}