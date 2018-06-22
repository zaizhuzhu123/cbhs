package com.server.pojo.bean;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import io.swagger.annotations.ApiModelProperty;
import com.server.pojo.bean.*;
import javax.persistence.*;
import java.math.BigDecimal;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;
import com.alibaba.fastjson.annotation.JSONField;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.DynamicInsert;
import io.swagger.annotations.ApiModelProperty;

@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "CbhsGlobalRcjzhlYs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CbhsGlobalRcjzhlYs implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(value = "全局人材机预算主键ID(创建不填|修改必填)",required=false)
	private Integer oid= 0;// 全局人材机预算主键ID(创建不填|修改必填)
	@Column(name = "projectOid", nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "必填|所属工程项目ID CbhsProject",required=false)
	private Integer projectOid= 0;// 必填|所属工程项目ID CbhsProject
	@Column(name = "nodeId", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|项目编号",required=false)
	private String nodeId= "";// 必填|项目编号
	@Column(name = "name", length = 100, nullable = true, unique = false,columnDefinition="varchar(100) default ''")
	@ApiModelProperty(value = "必填|项目名称",required=false)
	private String name= "";// 必填|项目名称
	@Column(name = "count", length = 255, nullable = true, unique = false,columnDefinition="varchar(255) default ''")
	@ApiModelProperty(value = "必填|工程量",required=false)
	private String count= "";// 必填|工程量
	@Column(name = "unit", length = 50, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "必填|单位",required=false)
	private String unit= "";// 必填|单位
	@Column(name = "tong",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|砼含量",required=false)
	private BigDecimal tong= new BigDecimal(0);// 必填|砼含量
	@Column(name = "totaPrice",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|总金额",required=false)
	private BigDecimal totaPrice= new BigDecimal(0);// 必填|总金额
	@Column(name = "r_zc",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|主材价格",required=false)
	private BigDecimal r_zc= new BigDecimal(0);// 必填|主材价格
	@Column(name = "r_rg",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|人工价格",required=false)
	private BigDecimal r_rg= new BigDecimal(0);// 必填|人工价格
	@Column(name = "r_jx",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|机械价格",required=false)
	private BigDecimal r_jx= new BigDecimal(0);// 必填|机械价格
	@Column(name = "r_qt",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|其他价格",required=false)
	private BigDecimal r_qt= new BigDecimal(0);// 必填|其他价格
	@Column(name = "r_unitHj",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|单价合计",required=false)
	private BigDecimal r_unitHj= new BigDecimal(0);// 必填|单价合计
	@Column(name = "c_cy",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|柴油耗量",required=false)
	private BigDecimal c_cy= new BigDecimal(0);// 必填|柴油耗量
	@Column(name = "c_zy",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|炸药耗量",required=false)
	private BigDecimal c_zy= new BigDecimal(0);// 必填|炸药耗量
	@Column(name = "c_fdlg",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|非电雷管",required=false)
	private BigDecimal c_fdlg= new BigDecimal(0);// 必填|非电雷管
	@Column(name = "c_tpzs",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|铜片止水",required=false)
	private BigDecimal c_tpzs= new BigDecimal(0);// 必填|铜片止水
	@Column(name = "c_gksn",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|高抗水泥",required=false)
	private BigDecimal c_gksn= new BigDecimal(0);// 必填|高抗水泥
	@Column(name = "c_sn",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|水泥",required=false)
	private BigDecimal c_sn= new BigDecimal(0);// 必填|水泥
	@Column(name = "c_fmh",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|粉煤灰",required=false)
	private BigDecimal c_fmh= new BigDecimal(0);// 必填|粉煤灰
	@Column(name = "c_sha",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|砂",required=false)
	private BigDecimal c_sha= new BigDecimal(0);// 必填|砂
	@Column(name = "c_shi",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|石",required=false)
	private BigDecimal c_shi= new BigDecimal(0);// 必填|石
	@Column(name = "c_shui",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|水",required=false)
	private BigDecimal c_shui= new BigDecimal(0);// 必填|水
	@Column(name = "c_wjj",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|外加剂",required=false)
	private BigDecimal c_wjj= new BigDecimal(0);// 必填|外加剂
	@Column(name = "c_nq",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|沥青",required=false)
	private BigDecimal c_nq= new BigDecimal(0);// 必填|沥青
	@Column(name = "c_gj",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|钢筋",required=false)
	private BigDecimal c_gj= new BigDecimal(0);// 必填|钢筋
	@Column(name = "rg_count",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|人工工时数量",required=false)
	private BigDecimal rg_count= new BigDecimal(0);// 必填|人工工时数量
	@Column(name = "j_yyldz",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|液压履带钻",required=false)
	private BigDecimal j_yyldz= new BigDecimal(0);// 必填|液压履带钻
	@Column(name = "j_zxqc",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|自卸汽车",required=false)
	private BigDecimal j_zxqc= new BigDecimal(0);// 必填|自卸汽车
	@Column(name = "j_wjjyy",precision = 19, scale = 4, columnDefinition="decimal(19,4) default 0", nullable = true, unique = false)
	@ApiModelProperty(value = "必填|挖掘机 液压",required=false)
	private BigDecimal j_wjjyy= new BigDecimal(0);// 必填|挖掘机 液压
	@Column(name = "opUserOid",updatable = false, nullable = true, unique = false,columnDefinition="Integer default 0")
	@ApiModelProperty(value = "操作人ID",hidden=true,required=false)
	private Integer opUserOid= 0;// 操作人ID
	@Column(name = "opUserName", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "操作人姓名",hidden=true,required=false)
	private String opUserName= "";// 操作人姓名
	@Column(name = "opTimeStr", length = 50,updatable = false, nullable = true, unique = false,columnDefinition="varchar(50) default ''")
	@ApiModelProperty(value = "操作时间",hidden=true,required=false)
	private String opTimeStr= "";// 操作时间
	@Column(name = "opTime",updatable = false, nullable = true, unique = false,columnDefinition="bigint default 0")
	@ApiModelProperty(value = "操作时间",hidden=true,required=false)
	private Long opTime= 0L;// 操作时间

	public Integer getOid() { 

    	return this.oid;

	}

	public void setOid(Integer oid) {
 
        this.oid = oid;

	}

	public Integer getProjectOid() { 

    	return this.projectOid;

	}

	public void setProjectOid(Integer projectOid) {
 
        this.projectOid = projectOid;

	}

	public String getNodeId() { 

    	return this.nodeId;

	}

	public void setNodeId(String nodeId) {
 
        this.nodeId = nodeId;

	}

	public String getName() { 

    	return this.name;

	}

	public void setName(String name) {
 
        this.name = name;

	}

	public String getCount() { 

    	return this.count;

	}

	public void setCount(String count) {
 
        this.count = count;

	}

	public String getUnit() { 

    	return this.unit;

	}

	public void setUnit(String unit) {
 
        this.unit = unit;

	}

	public BigDecimal getTong() { 

    	return this.tong;

	}

	public void setTong(BigDecimal tong) {
 
        this.tong = tong;

	}

	public BigDecimal getTotaPrice() { 

    	return this.totaPrice;

	}

	public void setTotaPrice(BigDecimal totaPrice) {
 
        this.totaPrice = totaPrice;

	}

	public BigDecimal getR_zc() { 

    	return this.r_zc;

	}

	public void setR_zc(BigDecimal r_zc) {
 
        this.r_zc = r_zc;

	}

	public BigDecimal getR_rg() { 

    	return this.r_rg;

	}

	public void setR_rg(BigDecimal r_rg) {
 
        this.r_rg = r_rg;

	}

	public BigDecimal getR_jx() { 

    	return this.r_jx;

	}

	public void setR_jx(BigDecimal r_jx) {
 
        this.r_jx = r_jx;

	}

	public BigDecimal getR_qt() { 

    	return this.r_qt;

	}

	public void setR_qt(BigDecimal r_qt) {
 
        this.r_qt = r_qt;

	}

	public BigDecimal getR_unitHj() { 

    	return this.r_unitHj;

	}

	public void setR_unitHj(BigDecimal r_unitHj) {
 
        this.r_unitHj = r_unitHj;

	}

	public BigDecimal getC_cy() { 

    	return this.c_cy;

	}

	public void setC_cy(BigDecimal c_cy) {
 
        this.c_cy = c_cy;

	}

	public BigDecimal getC_zy() { 

    	return this.c_zy;

	}

	public void setC_zy(BigDecimal c_zy) {
 
        this.c_zy = c_zy;

	}

	public BigDecimal getC_fdlg() { 

    	return this.c_fdlg;

	}

	public void setC_fdlg(BigDecimal c_fdlg) {
 
        this.c_fdlg = c_fdlg;

	}

	public BigDecimal getC_tpzs() { 

    	return this.c_tpzs;

	}

	public void setC_tpzs(BigDecimal c_tpzs) {
 
        this.c_tpzs = c_tpzs;

	}

	public BigDecimal getC_gksn() { 

    	return this.c_gksn;

	}

	public void setC_gksn(BigDecimal c_gksn) {
 
        this.c_gksn = c_gksn;

	}

	public BigDecimal getC_sn() { 

    	return this.c_sn;

	}

	public void setC_sn(BigDecimal c_sn) {
 
        this.c_sn = c_sn;

	}

	public BigDecimal getC_fmh() { 

    	return this.c_fmh;

	}

	public void setC_fmh(BigDecimal c_fmh) {
 
        this.c_fmh = c_fmh;

	}

	public BigDecimal getC_sha() { 

    	return this.c_sha;

	}

	public void setC_sha(BigDecimal c_sha) {
 
        this.c_sha = c_sha;

	}

	public BigDecimal getC_shi() { 

    	return this.c_shi;

	}

	public void setC_shi(BigDecimal c_shi) {
 
        this.c_shi = c_shi;

	}

	public BigDecimal getC_shui() { 

    	return this.c_shui;

	}

	public void setC_shui(BigDecimal c_shui) {
 
        this.c_shui = c_shui;

	}

	public BigDecimal getC_wjj() { 

    	return this.c_wjj;

	}

	public void setC_wjj(BigDecimal c_wjj) {
 
        this.c_wjj = c_wjj;

	}

	public BigDecimal getC_nq() { 

    	return this.c_nq;

	}

	public void setC_nq(BigDecimal c_nq) {
 
        this.c_nq = c_nq;

	}

	public BigDecimal getC_gj() { 

    	return this.c_gj;

	}

	public void setC_gj(BigDecimal c_gj) {
 
        this.c_gj = c_gj;

	}

	public BigDecimal getRg_count() { 

    	return this.rg_count;

	}

	public void setRg_count(BigDecimal rg_count) {
 
        this.rg_count = rg_count;

	}

	public BigDecimal getJ_yyldz() { 

    	return this.j_yyldz;

	}

	public void setJ_yyldz(BigDecimal j_yyldz) {
 
        this.j_yyldz = j_yyldz;

	}

	public BigDecimal getJ_zxqc() { 

    	return this.j_zxqc;

	}

	public void setJ_zxqc(BigDecimal j_zxqc) {
 
        this.j_zxqc = j_zxqc;

	}

	public BigDecimal getJ_wjjyy() { 

    	return this.j_wjjyy;

	}

	public void setJ_wjjyy(BigDecimal j_wjjyy) {
 
        this.j_wjjyy = j_wjjyy;

	}

	public Integer getOpUserOid() { 

    	return this.opUserOid;

	}

	public void setOpUserOid(Integer opUserOid) {
 
        this.opUserOid = opUserOid;

	}

	public String getOpUserName() { 

    	return this.opUserName;

	}

	public void setOpUserName(String opUserName) {
 
        this.opUserName = opUserName;

	}

	public String getOpTimeStr() { 

    	return this.opTimeStr;

	}

	public void setOpTimeStr(String opTimeStr) {
 
        this.opTimeStr = opTimeStr;

	}

	public Long getOpTime() { 

    	return this.opTime;

	}

	public void setOpTime(Long opTime) {
 
        this.opTime = opTime;

	}


}