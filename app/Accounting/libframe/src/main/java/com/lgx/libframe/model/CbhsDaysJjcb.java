package com.lgx.libframe.model;
import java.util.List;
import java.util.ArrayList;

import java.io.Serializable;
import com.lgx.libframe.*;
public class CbhsDaysJjcb implements Serializable{
private static final long serialVersionUID = 30000000L;

private int oid;// 主键（间接成本）(创建不填|修改必填)
private int projectOid;// 必填|所属工程项目ID CbhsProject
private int deptOid;// 必填|部门编号
private String  deptName;// 必填|部门名称
private String  monthStr;// 必填|月份 yyyy-MM 便于展示
private long monthTimeStamp;// 必填|月份 时间戳 用于后期数据统计
private String  dateStr;// 日期 yyyy-MM-dd 便于展示
private long dateTimeStamp;// 日期 每天00:00:00的时间戳 用于后期数据统计
private double total;// 必填|合计
private double glry_gz;// 必填|管理人员-工资
private double glry_zjjf;// 必填|管理人员-职教经费
private double glry_ghjf;// 必填|管理人员-工会经费
private double glry_dwbx;// 必填|管理人员-单位保险
private double glry_qt;// 必填|管理人员-其他
private double glry_wp_gz;// 必填|管理人员-外聘-工资
private double glry_wp_zjjf;// 必填|管理人员-外聘-职教经费
private double glry_wp_ghjf;// 必填|管理人员-外聘-工会经费
private double glry_wp_qt;// 必填|管理人员-外聘-其他
private double scry_gz;// 必填|生产人员-工资
private double scry_zjjf;// 必填|生产人员-职教经费
private double scry_ghjf;// 必填|生产人员-工会经费
private double scry_dwbx;// 必填|生产人员-单位保险
private double scry_qt;// 必填|生产人员-其他
private double scry_wp_gz;// 必填|生产人员-外聘-工资
private double scry_wp_zjjf;// 必填|生产人员-外聘-职教经费
private double scry_wp_ghjf;// 必填|生产人员-外聘-工会经费
private double scry_wp_qt;// 必填|生产人员-外聘-其他
private double bg_bgyp;// 必填|办公-办公用品
private double bg_txf;// 必填|办公-通讯费
private double bg_dnhc;// 必填|办公-电脑耗材
private double bg_qt;// 必填|办公-其他
private double xlf_dxf;// 必填|修理费-大修费
private double xlf_ybxlf;// 必填|修理费-一般修理费
private double xlf_clf;// 必填|修理费-差旅费
private double xlf_cailiaofei;// 必填|修理费-材料费
private double xlf_flf;// 必填|修理费-福利费
private double xlf_ywjf;// 必填|修理费-业务经费
private double xlf_sdf;// 必填|修理费-水电费
private double xlf_scf;// 必填|修理费-审车费
private double xlf_kyjf;// 必填|修理费-科研经费
private double xlf_cljbxf;// 必填|修理费-车辆及保险费
private double xlf_qt;// 必填|修理费-其他
private double aqfy_ygsz;// 必填|安全费用-一岗双责
private double aqfy_ygsztc;// 必填|安全费用-一岗双责调差
private double aqfy_qt;// 必填|安全费用-其他
private int opUserOid;// 操作人ID
private String  opUserName;// 操作人姓名
private String  opTimeStr;// 操作时间
private long opTime;// 操作时间
private int shStatus;// 审核状态 0 可用 1 审核中 2 审核不通过
private String  shId;// 审核标识 表示这是一个需要审核的操作 同一个操作由多条记录组成 通过这个表示审核的是一个操作
public int  getOid(){ 

    return this.oid;

}

public void setOid(int oid){
 
        this.oid=oid;

}

public int  getProjectOid(){ 

    return this.projectOid;

}

public void setProjectOid(int projectOid){
 
        this.projectOid=projectOid;

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

public double  getTotal(){ 

    return this.total;

}

public void setTotal(double total){
 
        this.total=total;

}

public double  getGlry_gz(){ 

    return this.glry_gz;

}

public void setGlry_gz(double glry_gz){
 
        this.glry_gz=glry_gz;

}

public double  getGlry_zjjf(){ 

    return this.glry_zjjf;

}

public void setGlry_zjjf(double glry_zjjf){
 
        this.glry_zjjf=glry_zjjf;

}

public double  getGlry_ghjf(){ 

    return this.glry_ghjf;

}

public void setGlry_ghjf(double glry_ghjf){
 
        this.glry_ghjf=glry_ghjf;

}

public double  getGlry_dwbx(){ 

    return this.glry_dwbx;

}

public void setGlry_dwbx(double glry_dwbx){
 
        this.glry_dwbx=glry_dwbx;

}

public double  getGlry_qt(){ 

    return this.glry_qt;

}

public void setGlry_qt(double glry_qt){
 
        this.glry_qt=glry_qt;

}

public double  getGlry_wp_gz(){ 

    return this.glry_wp_gz;

}

public void setGlry_wp_gz(double glry_wp_gz){
 
        this.glry_wp_gz=glry_wp_gz;

}

public double  getGlry_wp_zjjf(){ 

    return this.glry_wp_zjjf;

}

public void setGlry_wp_zjjf(double glry_wp_zjjf){
 
        this.glry_wp_zjjf=glry_wp_zjjf;

}

public double  getGlry_wp_ghjf(){ 

    return this.glry_wp_ghjf;

}

public void setGlry_wp_ghjf(double glry_wp_ghjf){
 
        this.glry_wp_ghjf=glry_wp_ghjf;

}

public double  getGlry_wp_qt(){ 

    return this.glry_wp_qt;

}

public void setGlry_wp_qt(double glry_wp_qt){
 
        this.glry_wp_qt=glry_wp_qt;

}

public double  getScry_gz(){ 

    return this.scry_gz;

}

public void setScry_gz(double scry_gz){
 
        this.scry_gz=scry_gz;

}

public double  getScry_zjjf(){ 

    return this.scry_zjjf;

}

public void setScry_zjjf(double scry_zjjf){
 
        this.scry_zjjf=scry_zjjf;

}

public double  getScry_ghjf(){ 

    return this.scry_ghjf;

}

public void setScry_ghjf(double scry_ghjf){
 
        this.scry_ghjf=scry_ghjf;

}

public double  getScry_dwbx(){ 

    return this.scry_dwbx;

}

public void setScry_dwbx(double scry_dwbx){
 
        this.scry_dwbx=scry_dwbx;

}

public double  getScry_qt(){ 

    return this.scry_qt;

}

public void setScry_qt(double scry_qt){
 
        this.scry_qt=scry_qt;

}

public double  getScry_wp_gz(){ 

    return this.scry_wp_gz;

}

public void setScry_wp_gz(double scry_wp_gz){
 
        this.scry_wp_gz=scry_wp_gz;

}

public double  getScry_wp_zjjf(){ 

    return this.scry_wp_zjjf;

}

public void setScry_wp_zjjf(double scry_wp_zjjf){
 
        this.scry_wp_zjjf=scry_wp_zjjf;

}

public double  getScry_wp_ghjf(){ 

    return this.scry_wp_ghjf;

}

public void setScry_wp_ghjf(double scry_wp_ghjf){
 
        this.scry_wp_ghjf=scry_wp_ghjf;

}

public double  getScry_wp_qt(){ 

    return this.scry_wp_qt;

}

public void setScry_wp_qt(double scry_wp_qt){
 
        this.scry_wp_qt=scry_wp_qt;

}

public double  getBg_bgyp(){ 

    return this.bg_bgyp;

}

public void setBg_bgyp(double bg_bgyp){
 
        this.bg_bgyp=bg_bgyp;

}

public double  getBg_txf(){ 

    return this.bg_txf;

}

public void setBg_txf(double bg_txf){
 
        this.bg_txf=bg_txf;

}

public double  getBg_dnhc(){ 

    return this.bg_dnhc;

}

public void setBg_dnhc(double bg_dnhc){
 
        this.bg_dnhc=bg_dnhc;

}

public double  getBg_qt(){ 

    return this.bg_qt;

}

public void setBg_qt(double bg_qt){
 
        this.bg_qt=bg_qt;

}

public double  getXlf_dxf(){ 

    return this.xlf_dxf;

}

public void setXlf_dxf(double xlf_dxf){
 
        this.xlf_dxf=xlf_dxf;

}

public double  getXlf_ybxlf(){ 

    return this.xlf_ybxlf;

}

public void setXlf_ybxlf(double xlf_ybxlf){
 
        this.xlf_ybxlf=xlf_ybxlf;

}

public double  getXlf_clf(){ 

    return this.xlf_clf;

}

public void setXlf_clf(double xlf_clf){
 
        this.xlf_clf=xlf_clf;

}

public double  getXlf_cailiaofei(){ 

    return this.xlf_cailiaofei;

}

public void setXlf_cailiaofei(double xlf_cailiaofei){
 
        this.xlf_cailiaofei=xlf_cailiaofei;

}

public double  getXlf_flf(){ 

    return this.xlf_flf;

}

public void setXlf_flf(double xlf_flf){
 
        this.xlf_flf=xlf_flf;

}

public double  getXlf_ywjf(){ 

    return this.xlf_ywjf;

}

public void setXlf_ywjf(double xlf_ywjf){
 
        this.xlf_ywjf=xlf_ywjf;

}

public double  getXlf_sdf(){ 

    return this.xlf_sdf;

}

public void setXlf_sdf(double xlf_sdf){
 
        this.xlf_sdf=xlf_sdf;

}

public double  getXlf_scf(){ 

    return this.xlf_scf;

}

public void setXlf_scf(double xlf_scf){
 
        this.xlf_scf=xlf_scf;

}

public double  getXlf_kyjf(){ 

    return this.xlf_kyjf;

}

public void setXlf_kyjf(double xlf_kyjf){
 
        this.xlf_kyjf=xlf_kyjf;

}

public double  getXlf_cljbxf(){ 

    return this.xlf_cljbxf;

}

public void setXlf_cljbxf(double xlf_cljbxf){
 
        this.xlf_cljbxf=xlf_cljbxf;

}

public double  getXlf_qt(){ 

    return this.xlf_qt;

}

public void setXlf_qt(double xlf_qt){
 
        this.xlf_qt=xlf_qt;

}

public double  getAqfy_ygsz(){ 

    return this.aqfy_ygsz;

}

public void setAqfy_ygsz(double aqfy_ygsz){
 
        this.aqfy_ygsz=aqfy_ygsz;

}

public double  getAqfy_ygsztc(){ 

    return this.aqfy_ygsztc;

}

public void setAqfy_ygsztc(double aqfy_ygsztc){
 
        this.aqfy_ygsztc=aqfy_ygsztc;

}

public double  getAqfy_qt(){ 

    return this.aqfy_qt;

}

public void setAqfy_qt(double aqfy_qt){
 
        this.aqfy_qt=aqfy_qt;

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

public int  getShStatus(){ 

    return this.shStatus;

}

public void setShStatus(int shStatus){
 
        this.shStatus=shStatus;

}

public String  getShId(){ 

    return this.shId;

}

public void setShId(String shId){
 
        this.shId=shId;

}


}