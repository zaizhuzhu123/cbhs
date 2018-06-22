package com.lgx.libframe.model;

import java.util.*;import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsReim implements Serializable{
private static final long serialVersionUID = 40000002L;

private int oid;// 主键(报销ID)(创建不填|修改必填)
private String  orderOid;// 报销编号
private int projectOid;// 必填|所属工程项目ID CbhsProject
private String  dateStr;// 日期 yyyy-MM-dd 便于展示
private  long  dateTimeStamp;// 日期 每天00:00:00的时间戳 用于后期数据统计
private String  monthStr;// 必填|月份 yyyy-MM 便于展示
private long monthTimeStamp;// 必填|月份 时间戳 用于后期数据统计
private int opUserOid;// 操作人ID
private String  opUserName;// 操作人姓名
private String  opTimeStr;// 操作时间
private long opTime;// 操作时间
private int deptOid;// 必填|部门编号
private String  deptName;// 必填|部门名称
private int shStatus;// 审核状态 0 可用 1 审核中 2 审核不通过
private double total;// 合计金额
private int attachmentCount;// 附件张数
private String  cwPersonName;// 财务审核时服务端加入|财务审核人姓名
private double cwTotal;// 财务审核时服务端加入|财务同意报销金额
private int process;// 服务端用于流程步骤的状态 0 待部门领导审批 1待财务审批 2待项目经理审批 3結束 部门领导和项目经理为审核规则中配置的人 财务为财务部的员工
private int examOid;// 审批任务编号，用于部门经理和项目经理审批 调用接口时使用
private List<CbhsReimTerm> terms;;// 项目
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public String  getOrderOid(){ 

    return this.orderOid;

}

public void setOrderOid(String orderOid){
 
        this.orderOid=orderOid;

}

public int  getProjectOid(){ 

    return this.projectOid;

}

public void setProjectOid(int projectOid){
 
        this.projectOid=projectOid;

}

public String  getDateStr(){ 

    return this.dateStr;

}

public void setDateStr(String dateStr){
 
        this.dateStr=dateStr;

}

public long  getDateTimeStamp(){ 

    return this.dateTimeStamp;

}

public void setDateTimeStamp(long dateTimeStamp){
 
        this.dateTimeStamp=dateTimeStamp;

}

public String  getMonthStr(){ 

    return this.monthStr;

}

public void setMonthStr(String monthStr){
 
        this.monthStr=monthStr;

}

public long  getMonthTimeStamp(){ 

    return this.monthTimeStamp;

}

public void setMonthTimeStamp(long monthTimeStamp){
 
        this.monthTimeStamp=monthTimeStamp;

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

public int  getDeptOid(){ 

    return this.deptOid;

}

public void setDeptOid(int deptOid){
 
        this.deptOid=deptOid;

}

public String  getDeptName(){ 

    return this.deptName;

}

public void setDeptName(String deptName){
 
        this.deptName=deptName;

}

public int  getShStatus(){ 

    return this.shStatus;

}

public void setShStatus(int shStatus){
 
        this.shStatus=shStatus;

}

public double  getTotal(){ 

    return this.total;

}

public void setTotal(double total){
 
        this.total=total;

}

public int  getAttachmentCount(){ 

    return this.attachmentCount;

}

public void setAttachmentCount(int attachmentCount){
 
        this.attachmentCount=attachmentCount;

}

public String  getCwPersonName(){ 

    return this.cwPersonName;

}

public void setCwPersonName(String cwPersonName){
 
        this.cwPersonName=cwPersonName;

}

public double  getCwTotal(){ 

    return this.cwTotal;

}

public void setCwTotal(double cwTotal){
 
        this.cwTotal=cwTotal;

}

public int  getProcess(){ 

    return this.process;

}

public void setProcess(int process){
 
        this.process=process;

}

public int  getExamOid(){ 

    return this.examOid;

}

public void setExamOid(int examOid){
 
        this.examOid=examOid;

}

public List<CbhsReimTerm>  getTerms(){
    return this.terms;
}
public void setTerms(List<CbhsReimTerm> terms){
    this.terms=terms;
}


}