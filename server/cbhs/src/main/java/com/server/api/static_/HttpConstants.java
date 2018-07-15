package com.server.api.static_;
import java.util.HashMap;
public class HttpConstants {

	public static HashMap<String,SimpleWebCommandOperationInfo> webCommands = new HashMap<String,SimpleWebCommandOperationInfo>();
	private static HashMap<Integer,SimpleWebCommandOperationInfo> codeOpMap = new HashMap<Integer,SimpleWebCommandOperationInfo>();

    public static Integer BASE_projectAdd=20101;

    public static Integer BASE_projectUpdate=20102;

    public static Integer BASE_projectFetch=20103;

    public static Integer BASE_cailiaoAdd=20201;

    public static Integer BASE_cailiaoUpdate=20202;

    public static Integer BASE_cailiaoDel=20203;

    public static Integer BASE_cailiaoFetch=20204;

    public static Integer BASE_cailiaoImport=20205;

    public static Integer BASE_cailiaoKemuAdd=20301;

    public static Integer BASE_cailiaoKemuUpdate=20302;

    public static Integer BASE_cailiaoKemuDel=20303;

    public static Integer BASE_cailiaoKemuFetch=20304;

    public static Integer BASE_fbCompanyAdd=20401;

    public static Integer BASE_fbCompanyUpdate=20402;

    public static Integer BASE_fbCompanyDel=20403;

    public static Integer BASE_fbCompanyFetch=20404;

    public static Integer BASE_machineryTypeAdd=20501;

    public static Integer BASE_machineryTypeUpdate=20502;

    public static Integer BASE_machineryTypeDel=20503;

    public static Integer BASE_machineryTypeFetch=20504;

    public static Integer BASE_machineryAdd=20601;

    public static Integer BASE_machineryUpdate=20602;

    public static Integer BASE_machineryDel=20603;

    public static Integer BASE_machineryFetch=20604;

    public static Integer BASE_cbhsGlfyRuleAdd=20801;

    public static Integer BASE_cbhsGlfyRuleUpdate=20802;

    public static Integer BASE_cbhsGlfyRuleFetch=20803;

    public static Integer BASE_gzAdd=20901;

    public static Integer BASE_gzUpdate=20902;

    public static Integer BASE_gzDel=20903;

    public static Integer BASE_gzFetch=20904;

    public static Integer BASE_htAdd=21001;

    public static Integer BASE_htUpdate=21002;

    public static Integer BASE_htDel=21003;

    public static Integer BASE_htFetch=21004;

    public static Integer BASE_contactsAdd=21101;

    public static Integer BASE_contactsUpdate=21102;

    public static Integer BASE_contactsDel=21103;

    public static Integer BASE_contactsFetch=21104;

    public static Integer BASE_contactsImport=21105;

    public static Integer CBSHE_examinerRuleAdd=70501;

    public static Integer CBSHE_examinerRuleUpdate=70502;

    public static Integer CBSHE_examinerRuleDel=70503;

    public static Integer CBSHE_examinerRuleFetch=70504;

    public static Integer CBSHE_examCb=70601;

    public static Integer CBSHE_examTaskFetch=70701;

    public static Integer CBSHE_examTaskStepFetch=70702;

    public static Integer CBSHE_examMyCreateTaskFetch=70703;

    public static Integer CBSHE_cancelExam=70704;

    public static Integer CLHX_zyGclFetch=90101;

    public static Integer CLHX_zyClhxFetch=90102;

    public static Integer CLHX_fbGclFetch=90103;

    public static Integer CLHX_fbClhxFetch=90104;

    public static Integer COMMON_login=10101;

    public static Integer COMMON_exit=10102;

    public static Integer COMMON_regAdmin=10103;

    public static Integer COMMON_regUser=10104;

    public static Integer COMMON_getUser=10105;

    public static Integer COMMON_modifyPwd=10106;

    public static Integer COMMON_updateUser=10107;

    public static Integer COMMON_uploadAvatar=10108;

    public static Integer COMMON_delUser=10109;

    public static Integer COMMON_roleAdd=10201;

    public static Integer COMMON_roleUpdate=10202;

    public static Integer COMMON_roleDel=10203;

    public static Integer COMMON_roleFetch=10204;

    public static Integer COMMON_deptAdd=10301;

    public static Integer COMMON_deptUpdate=10302;

    public static Integer COMMON_deptDel=10303;

    public static Integer COMMON_deptFetch=10304;

    public static Integer COMMON_jPushRegID=10401;

    public static Integer COMMON_versionAdd=10501;

    public static Integer COMMON_versionFetch=10502;

    public static Integer COMMON_versionUpdate=10503;

    public static Integer CW_settlementUpAdd=110101;

    public static Integer CW_settlementUpUpdate=110102;

    public static Integer CW_settlementUpDel=110103;

    public static Integer CW_settlementUpFetch=110104;

    public static Integer CW_settlementDownAdd=110201;

    public static Integer CW_settlementDownUpdate=110202;

    public static Integer CW_settlementDownDel=110203;

    public static Integer CW_settlementDownFetch=110204;

    public static Integer CW_reimAdd=110301;

    public static Integer CW_reimUpdate=110302;

    public static Integer CW_reimDel=110303;

    public static Integer CW_reimFetch=110304;

    public static Integer CW_reimShe=110305;

    public static Integer DAYSCB_jjcbFetch=50101;

    public static Integer DAYSCB_jjcbUpdate=50102;

    public static Integer DAYSCB_jjcbDel=50103;

    public static Integer DAYSCB_jjcbAdd=50104;

    public static Integer DAYSCB_glfyFetch=50201;

    public static Integer DAYSCB_glfyUpdate=50202;

    public static Integer DAYSCB_glfyDel=50203;

    public static Integer DAYSCB_glfyAdd=50204;

    public static Integer DAYSCB_todayFetch=50205;

    public static Integer DAYSCB_zyLxygCbFetch=50401;

    public static Integer DAYSCB_zyLxygCbUpdate=50402;

    public static Integer DAYSCB_zyLxygCbDel=50403;

    public static Integer DAYSCB_zyLxygCbAdd=50404;

    public static Integer DAYSCB_zyJxCbFetch=50501;

    public static Integer DAYSCB_zyJxCbUpdate=50502;

    public static Integer DAYSCB_zyJxCbDel=50503;

    public static Integer DAYSCB_zyJxCbAdd=50504;

    public static Integer DAYSCB_zyQtCbFetch=50601;

    public static Integer DAYSCB_zyQtCbUpdate=50602;

    public static Integer DAYSCB_zyQtCbDel=50603;

    public static Integer DAYSCB_zyQtCbAdd=50604;

    public static Integer DAYSCB_zyCailiaoCbFetch=50701;

    public static Integer DAYSCB_zyCailiaoCbUpdate=50702;

    public static Integer DAYSCB_zyCailiaoCbDel=50703;

    public static Integer DAYSCB_zyCailiaoCbAdd=50704;

    public static Integer DAYSCB_fbGclTjCbFetch=50801;

    public static Integer DAYSCB_fbGclTjCbUpdate=50802;

    public static Integer DAYSCB_fbGclTjCbDel=50803;

    public static Integer DAYSCB_fbGclTjCbAdd=50804;

    public static Integer DAYSCB_fbLjxmCbFetch=50901;

    public static Integer DAYSCB_fbLjxmCbUpdate=50902;

    public static Integer DAYSCB_fbLjxmCbDel=50903;

    public static Integer DAYSCB_fbLjxmCbAddCount=50904;

    public static Integer DAYSCB_fbLjxmCbAddJg=50905;

    public static Integer DAYSCB_fbLjxmCbUpdateJg=50906;

    public static Integer DAYSCB_fbJgUpdate=51001;

    public static Integer DAYSCB_fbJgAdd=51002;

    public static Integer DAYSSR_gcsrFetch=60101;

    public static Integer DAYSSR_gcsrUpdate=60102;

    public static Integer DAYSSR_gcsrDel=60103;

    public static Integer DAYSSR_gcsrAdd=60104;

    public static Integer DAYSSR_newsrFetch=60201;

    public static Integer DAYSSR_newsrUpdate=60202;

    public static Integer DAYSSR_newsrDel=60203;

    public static Integer DAYSSR_newsrAddCount=60204;

    public static Integer DAYSSR_newsrAddPrice=60205;

    public static Integer GLOBALYS_globalGclYsFetch=30101;

    public static Integer GLOBALYS_globalGclYsUpdate=30102;

    public static Integer GLOBALYS_globalGclYsDel=30103;

    public static Integer GLOBALYS_globalGclYsImport=30104;

    public static Integer GLOBALYS_globalGclYsAdd=30105;

    public static Integer GLOBALYS_globalRcjzhlYsFetch=30201;

    public static Integer GLOBALYS_globalRcjzhlYsUpdate=30202;

    public static Integer GLOBALYS_globalRcjzhlYsDel=30203;

    public static Integer GLOBALYS_globalRcjzhlYsImport=30204;

    public static Integer GLOBALYS_globalRcjzhlYsAdd=30205;

    public static Integer GLOBALYS_globalFyzYsFetch=30301;

    public static Integer GLOBALYS_globalFyzYsUpdate=30302;

    public static Integer GLOBALYS_globalFyzYsDel=30303;

    public static Integer GLOBALYS_globalFyzYsImport=30304;

    public static Integer GLOBALYS_globalFyzYsAdd=30305;

    public static Integer MONTHMBYS_jjcbYsFetch=40101;

    public static Integer MONTHMBYS_jjcbYsUpdate=40102;

    public static Integer MONTHMBYS_jjcbYsDel=40103;

    public static Integer MONTHMBYS_jjcbYsAdd=40104;

    public static Integer MONTHMBYS_glfyYsFetch=40201;

    public static Integer MONTHMBYS_glfyYsUpdate=40202;

    public static Integer MONTHMBYS_glfyYsDel=40203;

    public static Integer MONTHMBYS_glfyYsAdd=40204;

    public static Integer MONTHMBYS_zyCailiaoCbYsFetch=40301;

    public static Integer MONTHMBYS_zyCailiaoCbYsUpdate=40302;

    public static Integer MONTHMBYS_zyCailiaoCbYsDel=40303;

    public static Integer MONTHMBYS_zyCailiaoCbYsAdd=40304;

    public static Integer MONTHMBYS_zyCailiaoCbYsCailiaoFetch=40305;

    public static Integer MONTHMBYS_zyLxygCbYsFetch=40401;

    public static Integer MONTHMBYS_zyLxygCbYsUpdate=40402;

    public static Integer MONTHMBYS_zyLxygCbYsDel=40403;

    public static Integer MONTHMBYS_zyLxygCbYsAdd=40404;

    public static Integer MONTHMBYS_zyJxCbYsFetch=40501;

    public static Integer MONTHMBYS_zyJxCbYsUpdate=40502;

    public static Integer MONTHMBYS_zyJxCbYsDel=40503;

    public static Integer MONTHMBYS_zyJxCbYsAdd=40504;

    public static Integer MONTHMBYS_zyQtfyYsFetch=40601;

    public static Integer MONTHMBYS_zyQtfyYsUpdate=40602;

    public static Integer MONTHMBYS_zyQtfyYsDel=40603;

    public static Integer MONTHMBYS_zyQtfyYsAdd=40604;

    public static Integer MONTHMBYS_fbLjxmCbYsFetch=40701;

    public static Integer MONTHMBYS_fbLjxmCbYsUpdate=40702;

    public static Integer MONTHMBYS_fbLjxmCbYsDel=40703;

    public static Integer MONTHMBYS_fbLjxmCbYsAdd=40704;

    public static Integer MONTHMBYS_fbGcCbYsFetch=40801;

    public static Integer MONTHMBYS_fbGcCbYsUpdate=40802;

    public static Integer MONTHMBYS_fbGcCbYsDel=40803;

    public static Integer MONTHMBYS_fbGcCbYsAdd=40804;

    public static Integer MONTHMBYS_fbGcGlobalXmFetch=40805;

    public static Integer MONTHMBYS_fbGcFbCompanyFetch=40806;

    public static Integer MONTHMBYS_fbCailiaoCbYsFetch=40901;

    public static Integer MONTHMBYS_fbCailiaoCbYsUpdate=40902;

    public static Integer MONTHMBYS_fbCailiaoCbYsDel=40903;

    public static Integer MONTHMBYS_fbCailiaoCbYsAdd=40904;

    public static Integer MONTHMBYS_fbCailiaoCbYsCailiaoFetch=40905;

    public static Integer MONTHMBYS_mbYsFetch=41001;

    public static Integer MONTHMBYS_mbYsTotalFetch=41002;

    public static Integer TJBB_cbsrbb=100101;

    public static Integer TJBB_zybb=100102;

    public static Integer TJBB_daysDetails=100103;

    public static Integer TJBB_grandTotal=100104;

    public static Integer TJBB_abnormalFetch=100105;

    public static Integer TJBB_zybbAbnormalFetch=100106;

    public static Integer TJBB_cbAnalyze=100107;

    public static Integer TJBB_fbCompanyTj=100108;

    public static Integer ZYTJ_zytjFetch=80101;

    public static Integer ZYTJ_zytjUpdate=80102;

    public static Integer ZYTJ_zytjDel=80103;

    public static Integer ZYTJ_zytjAdd=80104;

    public static Integer ZYTJ_zdgxhsFetch=80201;

    public static Integer ZYTJ_zdgxhsUpdate=80202;

    public static Integer ZYTJ_zdgxhsDel=80203;

    public static Integer ZYTJ_zdgxhsAdd=80204;

	public static SimpleWebCommandOperationInfo getOperation(String url){
		return webCommands.get(url);
	}

	public static SimpleWebCommandOperationInfo getOperation(int cmd){
		return codeOpMap.get(cmd);
	}

      static{ 
    SimpleWebCommandOperationInfo urlInfo0= new SimpleWebCommandOperationInfo();
    urlInfo0.setMsgCode(20101);
    urlInfo0.setUrl("/cbhs/base/projectAdd");
    urlInfo0.setOpCode("0");
    urlInfo0.setWorkClass("");
    urlInfo0.setMsgReaquest("com.server.pojo.bean.CbhsProject");
    urlInfo0.setReaquestDepict("工程项目");
    urlInfo0.setMsgResponse("com.server.pojo.bean.CbhsProject");
    urlInfo0.setResponseDepict("工程项目");
    urlInfo0.setTransation(true);
    urlInfo0.setRestClass("projectAdd");
    webCommands.put(urlInfo0.getUrl(),urlInfo0);
    codeOpMap.put(urlInfo0.getMsgCode(),urlInfo0);

    SimpleWebCommandOperationInfo urlInfo1= new SimpleWebCommandOperationInfo();
    urlInfo1.setMsgCode(20102);
    urlInfo1.setUrl("/cbhs/base/projectUpdate");
    urlInfo1.setOpCode("0");
    urlInfo1.setWorkClass("");
    urlInfo1.setMsgReaquest("com.server.pojo.bean.CbhsProject");
    urlInfo1.setReaquestDepict("工程项目");
    urlInfo1.setMsgResponse("com.server.pojo.bean.CbhsProject");
    urlInfo1.setResponseDepict("工程项目");
    urlInfo1.setTransation(true);
    urlInfo1.setRestClass("projectUpdate");
    webCommands.put(urlInfo1.getUrl(),urlInfo1);
    codeOpMap.put(urlInfo1.getMsgCode(),urlInfo1);

    SimpleWebCommandOperationInfo urlInfo2= new SimpleWebCommandOperationInfo();
    urlInfo2.setMsgCode(20103);
    urlInfo2.setUrl("/cbhs/base/projectFetch");
    urlInfo2.setOpCode("0");
    urlInfo2.setWorkClass("");
    urlInfo2.setMsgReaquest("com.server.pojo.url.base.RequestProjectFetch");
    urlInfo2.setReaquestDepict("工程项目ID,工程项目名称,页码,数量,开始编号,工程项目删除状态,工程项目启动状态");
    urlInfo2.setMsgResponse("com.server.pojo.url.base.ResponseProjectFetch");
    urlInfo2.setResponseDepict("工程项目集合,总数");
    urlInfo2.setTransation(true);
    urlInfo2.setRestClass("projectFetch");
    webCommands.put(urlInfo2.getUrl(),urlInfo2);
    codeOpMap.put(urlInfo2.getMsgCode(),urlInfo2);

    SimpleWebCommandOperationInfo urlInfo3= new SimpleWebCommandOperationInfo();
    urlInfo3.setMsgCode(20201);
    urlInfo3.setUrl("/cbhs/base/cailiaoAdd");
    urlInfo3.setOpCode("0");
    urlInfo3.setWorkClass("");
    urlInfo3.setMsgReaquest("com.server.pojo.bean.CbhsCailiao");
    urlInfo3.setReaquestDepict("材料");
    urlInfo3.setMsgResponse("com.server.pojo.bean.CbhsCailiao");
    urlInfo3.setResponseDepict("材料");
    urlInfo3.setTransation(true);
    urlInfo3.setRestClass("cailiaoAdd");
    webCommands.put(urlInfo3.getUrl(),urlInfo3);
    codeOpMap.put(urlInfo3.getMsgCode(),urlInfo3);

    SimpleWebCommandOperationInfo urlInfo4= new SimpleWebCommandOperationInfo();
    urlInfo4.setMsgCode(20202);
    urlInfo4.setUrl("/cbhs/base/cailiaoUpdate");
    urlInfo4.setOpCode("0");
    urlInfo4.setWorkClass("");
    urlInfo4.setMsgReaquest("com.server.pojo.bean.CbhsCailiao");
    urlInfo4.setReaquestDepict("材料");
    urlInfo4.setMsgResponse("com.server.pojo.bean.CbhsCailiao");
    urlInfo4.setResponseDepict("材料");
    urlInfo4.setTransation(true);
    urlInfo4.setRestClass("cailiaoUpdate");
    webCommands.put(urlInfo4.getUrl(),urlInfo4);
    codeOpMap.put(urlInfo4.getMsgCode(),urlInfo4);

    SimpleWebCommandOperationInfo urlInfo5= new SimpleWebCommandOperationInfo();
    urlInfo5.setMsgCode(20203);
    urlInfo5.setUrl("/cbhs/base/cailiaoDel");
    urlInfo5.setOpCode("0");
    urlInfo5.setWorkClass("");
    urlInfo5.setMsgReaquest("com.server.pojo.url.base.RequestCailiaoDel");
    urlInfo5.setReaquestDepict("材料ID集合");
    urlInfo5.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo5.setResponseDepict("标识");
    urlInfo5.setTransation(false);
    urlInfo5.setRestClass("cailiaoDel");
    webCommands.put(urlInfo5.getUrl(),urlInfo5);
    codeOpMap.put(urlInfo5.getMsgCode(),urlInfo5);

    SimpleWebCommandOperationInfo urlInfo6= new SimpleWebCommandOperationInfo();
    urlInfo6.setMsgCode(20204);
    urlInfo6.setUrl("/cbhs/base/cailiaoFetch");
    urlInfo6.setOpCode("0");
    urlInfo6.setWorkClass("");
    urlInfo6.setMsgReaquest("com.server.pojo.url.base.RequestCailiaoFetch");
    urlInfo6.setReaquestDepict("材料ID,材料科目,规格,材料名称,页码,数量,开始编号,材料状态,是否是燃油 1是 2不是");
    urlInfo6.setMsgResponse("com.server.pojo.url.base.ResponseCailiaoFetch");
    urlInfo6.setResponseDepict("材料集合,总数");
    urlInfo6.setTransation(true);
    urlInfo6.setRestClass("cailiaoFetch");
    webCommands.put(urlInfo6.getUrl(),urlInfo6);
    codeOpMap.put(urlInfo6.getMsgCode(),urlInfo6);

    SimpleWebCommandOperationInfo urlInfo7= new SimpleWebCommandOperationInfo();
    urlInfo7.setMsgCode(20205);
    urlInfo7.setUrl("/cbhs/base/cailiaoImport");
    urlInfo7.setOpCode("0");
    urlInfo7.setWorkClass("");
    urlInfo7.setMsgReaquest("com.server.pojo.bean.MultipartFile");
    urlInfo7.setReaquestDepict("材料Excel");
    urlInfo7.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo7.setResponseDepict("标识");
    urlInfo7.setTransation(true);
    urlInfo7.setRestClass("cailiaoImport");
    webCommands.put(urlInfo7.getUrl(),urlInfo7);
    codeOpMap.put(urlInfo7.getMsgCode(),urlInfo7);

    SimpleWebCommandOperationInfo urlInfo8= new SimpleWebCommandOperationInfo();
    urlInfo8.setMsgCode(20301);
    urlInfo8.setUrl("/cbhs/base/cailiaoKemuAdd");
    urlInfo8.setOpCode("0");
    urlInfo8.setWorkClass("");
    urlInfo8.setMsgReaquest("com.server.pojo.bean.CbhsCailiaoKemu");
    urlInfo8.setReaquestDepict("材料科目");
    urlInfo8.setMsgResponse("com.server.pojo.bean.CbhsCailiaoKemu");
    urlInfo8.setResponseDepict("材料科目");
    urlInfo8.setTransation(true);
    urlInfo8.setRestClass("cailiaoKemuAdd");
    webCommands.put(urlInfo8.getUrl(),urlInfo8);
    codeOpMap.put(urlInfo8.getMsgCode(),urlInfo8);

    SimpleWebCommandOperationInfo urlInfo9= new SimpleWebCommandOperationInfo();
    urlInfo9.setMsgCode(20302);
    urlInfo9.setUrl("/cbhs/base/cailiaoKemuUpdate");
    urlInfo9.setOpCode("0");
    urlInfo9.setWorkClass("");
    urlInfo9.setMsgReaquest("com.server.pojo.bean.CbhsCailiaoKemu");
    urlInfo9.setReaquestDepict("材料科目");
    urlInfo9.setMsgResponse("com.server.pojo.bean.CbhsCailiaoKemu");
    urlInfo9.setResponseDepict("材料科目");
    urlInfo9.setTransation(true);
    urlInfo9.setRestClass("cailiaoKemuUpdate");
    webCommands.put(urlInfo9.getUrl(),urlInfo9);
    codeOpMap.put(urlInfo9.getMsgCode(),urlInfo9);

    SimpleWebCommandOperationInfo urlInfo10= new SimpleWebCommandOperationInfo();
    urlInfo10.setMsgCode(20303);
    urlInfo10.setUrl("/cbhs/base/cailiaoKemuDel");
    urlInfo10.setOpCode("0");
    urlInfo10.setWorkClass("");
    urlInfo10.setMsgReaquest("com.server.pojo.url.base.RequestCailiaoKemuDel");
    urlInfo10.setReaquestDepict("材料科目ID集合");
    urlInfo10.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo10.setResponseDepict("标识");
    urlInfo10.setTransation(false);
    urlInfo10.setRestClass("cailiaoKemuDel");
    webCommands.put(urlInfo10.getUrl(),urlInfo10);
    codeOpMap.put(urlInfo10.getMsgCode(),urlInfo10);

    SimpleWebCommandOperationInfo urlInfo11= new SimpleWebCommandOperationInfo();
    urlInfo11.setMsgCode(20304);
    urlInfo11.setUrl("/cbhs/base/cailiaoKemuFetch");
    urlInfo11.setOpCode("0");
    urlInfo11.setWorkClass("");
    urlInfo11.setMsgReaquest("com.server.pojo.url.base.RequestCailiaoKemuFetch");
    urlInfo11.setReaquestDepict("材料科目ID,材料科目名称,页码,数量,开始编号,材料科目状态");
    urlInfo11.setMsgResponse("com.server.pojo.url.base.ResponseCailiaoKemuFetch");
    urlInfo11.setResponseDepict("材料科目集合,总数");
    urlInfo11.setTransation(true);
    urlInfo11.setRestClass("cailiaoKemuFetch");
    webCommands.put(urlInfo11.getUrl(),urlInfo11);
    codeOpMap.put(urlInfo11.getMsgCode(),urlInfo11);

    SimpleWebCommandOperationInfo urlInfo12= new SimpleWebCommandOperationInfo();
    urlInfo12.setMsgCode(20401);
    urlInfo12.setUrl("/cbhs/base/fbCompanyAdd");
    urlInfo12.setOpCode("0");
    urlInfo12.setWorkClass("");
    urlInfo12.setMsgReaquest("com.server.pojo.bean.CbhsFbCompany");
    urlInfo12.setReaquestDepict("分包公司");
    urlInfo12.setMsgResponse("com.server.pojo.bean.CbhsFbCompany");
    urlInfo12.setResponseDepict("分包公司");
    urlInfo12.setTransation(true);
    urlInfo12.setRestClass("fbCompanyAdd");
    webCommands.put(urlInfo12.getUrl(),urlInfo12);
    codeOpMap.put(urlInfo12.getMsgCode(),urlInfo12);

    SimpleWebCommandOperationInfo urlInfo13= new SimpleWebCommandOperationInfo();
    urlInfo13.setMsgCode(20402);
    urlInfo13.setUrl("/cbhs/base/fbCompanyUpdate");
    urlInfo13.setOpCode("0");
    urlInfo13.setWorkClass("");
    urlInfo13.setMsgReaquest("com.server.pojo.bean.CbhsFbCompany");
    urlInfo13.setReaquestDepict("分包公司");
    urlInfo13.setMsgResponse("com.server.pojo.bean.CbhsFbCompany");
    urlInfo13.setResponseDepict("分包公司");
    urlInfo13.setTransation(true);
    urlInfo13.setRestClass("fbCompanyUpdate");
    webCommands.put(urlInfo13.getUrl(),urlInfo13);
    codeOpMap.put(urlInfo13.getMsgCode(),urlInfo13);

    SimpleWebCommandOperationInfo urlInfo14= new SimpleWebCommandOperationInfo();
    urlInfo14.setMsgCode(20403);
    urlInfo14.setUrl("/cbhs/base/fbCompanyDel");
    urlInfo14.setOpCode("0");
    urlInfo14.setWorkClass("");
    urlInfo14.setMsgReaquest("com.server.pojo.url.base.RequestFbCompanyDel");
    urlInfo14.setReaquestDepict("分包公司ID集合");
    urlInfo14.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo14.setResponseDepict("标识");
    urlInfo14.setTransation(false);
    urlInfo14.setRestClass("fbCompanyDel");
    webCommands.put(urlInfo14.getUrl(),urlInfo14);
    codeOpMap.put(urlInfo14.getMsgCode(),urlInfo14);

    SimpleWebCommandOperationInfo urlInfo15= new SimpleWebCommandOperationInfo();
    urlInfo15.setMsgCode(20404);
    urlInfo15.setUrl("/cbhs/base/fbCompanyFetch");
    urlInfo15.setOpCode("0");
    urlInfo15.setWorkClass("");
    urlInfo15.setMsgReaquest("com.server.pojo.url.base.RequestFbCompanyFetch");
    urlInfo15.setReaquestDepict("分包公司ID,分包公司名称,页码,数量,开始编号,分包公司状态");
    urlInfo15.setMsgResponse("com.server.pojo.url.base.ResponseFbCompanyFetch");
    urlInfo15.setResponseDepict("分包公司集合,总数");
    urlInfo15.setTransation(true);
    urlInfo15.setRestClass("fbCompanyFetch");
    webCommands.put(urlInfo15.getUrl(),urlInfo15);
    codeOpMap.put(urlInfo15.getMsgCode(),urlInfo15);

    SimpleWebCommandOperationInfo urlInfo16= new SimpleWebCommandOperationInfo();
    urlInfo16.setMsgCode(20501);
    urlInfo16.setUrl("/cbhs/base/machineryTypeAdd");
    urlInfo16.setOpCode("0");
    urlInfo16.setWorkClass("");
    urlInfo16.setMsgReaquest("com.server.pojo.bean.CbhsMachineryType");
    urlInfo16.setReaquestDepict("机械设备种类");
    urlInfo16.setMsgResponse("com.server.pojo.bean.CbhsMachineryType");
    urlInfo16.setResponseDepict("机械设备种类");
    urlInfo16.setTransation(true);
    urlInfo16.setRestClass("machineryTypeAdd");
    webCommands.put(urlInfo16.getUrl(),urlInfo16);
    codeOpMap.put(urlInfo16.getMsgCode(),urlInfo16);

    SimpleWebCommandOperationInfo urlInfo17= new SimpleWebCommandOperationInfo();
    urlInfo17.setMsgCode(20502);
    urlInfo17.setUrl("/cbhs/base/machineryTypeUpdate");
    urlInfo17.setOpCode("0");
    urlInfo17.setWorkClass("");
    urlInfo17.setMsgReaquest("com.server.pojo.bean.CbhsMachineryType");
    urlInfo17.setReaquestDepict("机械设备种类");
    urlInfo17.setMsgResponse("com.server.pojo.bean.CbhsMachineryType");
    urlInfo17.setResponseDepict("机械设备种类");
    urlInfo17.setTransation(true);
    urlInfo17.setRestClass("machineryTypeUpdate");
    webCommands.put(urlInfo17.getUrl(),urlInfo17);
    codeOpMap.put(urlInfo17.getMsgCode(),urlInfo17);

    SimpleWebCommandOperationInfo urlInfo18= new SimpleWebCommandOperationInfo();
    urlInfo18.setMsgCode(20503);
    urlInfo18.setUrl("/cbhs/base/machineryTypeDel");
    urlInfo18.setOpCode("0");
    urlInfo18.setWorkClass("");
    urlInfo18.setMsgReaquest("com.server.pojo.url.base.RequestMachineryTypeDel");
    urlInfo18.setReaquestDepict("机械设备种类ID集合");
    urlInfo18.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo18.setResponseDepict("标识");
    urlInfo18.setTransation(false);
    urlInfo18.setRestClass("machineryTypeDel");
    webCommands.put(urlInfo18.getUrl(),urlInfo18);
    codeOpMap.put(urlInfo18.getMsgCode(),urlInfo18);

    SimpleWebCommandOperationInfo urlInfo19= new SimpleWebCommandOperationInfo();
    urlInfo19.setMsgCode(20504);
    urlInfo19.setUrl("/cbhs/base/machineryTypeFetch");
    urlInfo19.setOpCode("0");
    urlInfo19.setWorkClass("");
    urlInfo19.setMsgReaquest("com.server.pojo.url.base.RequestMachineryTypeFetch");
    urlInfo19.setReaquestDepict("机械设备种类ID,机械设备种类名称,页码,数量,开始编号,分包公司状态");
    urlInfo19.setMsgResponse("com.server.pojo.url.base.ResponseMachineryTypeFetch");
    urlInfo19.setResponseDepict("机械设备种类集合,总数");
    urlInfo19.setTransation(true);
    urlInfo19.setRestClass("machineryTypeFetch");
    webCommands.put(urlInfo19.getUrl(),urlInfo19);
    codeOpMap.put(urlInfo19.getMsgCode(),urlInfo19);

    SimpleWebCommandOperationInfo urlInfo20= new SimpleWebCommandOperationInfo();
    urlInfo20.setMsgCode(20601);
    urlInfo20.setUrl("/cbhs/base/machineryAdd");
    urlInfo20.setOpCode("0");
    urlInfo20.setWorkClass("");
    urlInfo20.setMsgReaquest("com.server.pojo.bean.CbhsMachinery");
    urlInfo20.setReaquestDepict("机械设备");
    urlInfo20.setMsgResponse("com.server.pojo.bean.CbhsMachinery");
    urlInfo20.setResponseDepict("机械设备");
    urlInfo20.setTransation(true);
    urlInfo20.setRestClass("machineryAdd");
    webCommands.put(urlInfo20.getUrl(),urlInfo20);
    codeOpMap.put(urlInfo20.getMsgCode(),urlInfo20);

    SimpleWebCommandOperationInfo urlInfo21= new SimpleWebCommandOperationInfo();
    urlInfo21.setMsgCode(20602);
    urlInfo21.setUrl("/cbhs/base/machineryUpdate");
    urlInfo21.setOpCode("0");
    urlInfo21.setWorkClass("");
    urlInfo21.setMsgReaquest("com.server.pojo.bean.CbhsMachinery");
    urlInfo21.setReaquestDepict("机械设备");
    urlInfo21.setMsgResponse("com.server.pojo.bean.CbhsMachinery");
    urlInfo21.setResponseDepict("机械设备");
    urlInfo21.setTransation(true);
    urlInfo21.setRestClass("machineryUpdate");
    webCommands.put(urlInfo21.getUrl(),urlInfo21);
    codeOpMap.put(urlInfo21.getMsgCode(),urlInfo21);

    SimpleWebCommandOperationInfo urlInfo22= new SimpleWebCommandOperationInfo();
    urlInfo22.setMsgCode(20603);
    urlInfo22.setUrl("/cbhs/base/machineryDel");
    urlInfo22.setOpCode("0");
    urlInfo22.setWorkClass("");
    urlInfo22.setMsgReaquest("com.server.pojo.url.base.RequestMachineryDel");
    urlInfo22.setReaquestDepict("机械设备ID集合");
    urlInfo22.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo22.setResponseDepict("标识");
    urlInfo22.setTransation(false);
    urlInfo22.setRestClass("machineryDel");
    webCommands.put(urlInfo22.getUrl(),urlInfo22);
    codeOpMap.put(urlInfo22.getMsgCode(),urlInfo22);

    SimpleWebCommandOperationInfo urlInfo23= new SimpleWebCommandOperationInfo();
    urlInfo23.setMsgCode(20604);
    urlInfo23.setUrl("/cbhs/base/machineryFetch");
    urlInfo23.setOpCode("0");
    urlInfo23.setWorkClass("");
    urlInfo23.setMsgReaquest("com.server.pojo.url.base.RequestMachineryFetch");
    urlInfo23.setReaquestDepict("机械设备ID,设备种类ID,机械设备名称,页码,数量,开始编号,机械设备状态,是否使用中 1使用 2未使用");
    urlInfo23.setMsgResponse("com.server.pojo.url.base.ResponseMachineryFetch");
    urlInfo23.setResponseDepict("机械设备集合,总数");
    urlInfo23.setTransation(true);
    urlInfo23.setRestClass("machineryFetch");
    webCommands.put(urlInfo23.getUrl(),urlInfo23);
    codeOpMap.put(urlInfo23.getMsgCode(),urlInfo23);

    SimpleWebCommandOperationInfo urlInfo24= new SimpleWebCommandOperationInfo();
    urlInfo24.setMsgCode(20801);
    urlInfo24.setUrl("/cbhs/base/cbhsGlfyRuleAdd");
    urlInfo24.setOpCode("0");
    urlInfo24.setWorkClass("");
    urlInfo24.setMsgReaquest("com.server.pojo.bean.CbhsGlfyRule");
    urlInfo24.setReaquestDepict("管理费用上缴公式");
    urlInfo24.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo24.setResponseDepict("标识");
    urlInfo24.setTransation(true);
    urlInfo24.setRestClass("cbhsGlfyRuleAdd");
    webCommands.put(urlInfo24.getUrl(),urlInfo24);
    codeOpMap.put(urlInfo24.getMsgCode(),urlInfo24);

    SimpleWebCommandOperationInfo urlInfo25= new SimpleWebCommandOperationInfo();
    urlInfo25.setMsgCode(20802);
    urlInfo25.setUrl("/cbhs/base/cbhsGlfyRuleUpdate");
    urlInfo25.setOpCode("0");
    urlInfo25.setWorkClass("");
    urlInfo25.setMsgReaquest("com.server.pojo.bean.CbhsGlfyRule");
    urlInfo25.setReaquestDepict("管理费用上缴公式");
    urlInfo25.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo25.setResponseDepict("标识");
    urlInfo25.setTransation(true);
    urlInfo25.setRestClass("cbhsGlfyRuleUpdate");
    webCommands.put(urlInfo25.getUrl(),urlInfo25);
    codeOpMap.put(urlInfo25.getMsgCode(),urlInfo25);

    SimpleWebCommandOperationInfo urlInfo26= new SimpleWebCommandOperationInfo();
    urlInfo26.setMsgCode(20803);
    urlInfo26.setUrl("/cbhs/base/cbhsGlfyRuleFetch");
    urlInfo26.setOpCode("0");
    urlInfo26.setWorkClass("");
    urlInfo26.setMsgReaquest("com.server.pojo.url.base.RequestCbhsGlfyRuleFetch");
    urlInfo26.setReaquestDepict("工程项目ID");
    urlInfo26.setMsgResponse("com.server.pojo.bean.CbhsGlfyRule");
    urlInfo26.setResponseDepict("管理费用上缴公式");
    urlInfo26.setTransation(true);
    urlInfo26.setRestClass("cbhsGlfyRuleFetch");
    webCommands.put(urlInfo26.getUrl(),urlInfo26);
    codeOpMap.put(urlInfo26.getMsgCode(),urlInfo26);

    SimpleWebCommandOperationInfo urlInfo27= new SimpleWebCommandOperationInfo();
    urlInfo27.setMsgCode(20901);
    urlInfo27.setUrl("/cbhs/base/gzAdd");
    urlInfo27.setOpCode("0");
    urlInfo27.setWorkClass("");
    urlInfo27.setMsgReaquest("com.server.pojo.bean.CbhsGz");
    urlInfo27.setReaquestDepict("工种");
    urlInfo27.setMsgResponse("com.server.pojo.bean.CbhsGz");
    urlInfo27.setResponseDepict("工种");
    urlInfo27.setTransation(true);
    urlInfo27.setRestClass("gzAdd");
    webCommands.put(urlInfo27.getUrl(),urlInfo27);
    codeOpMap.put(urlInfo27.getMsgCode(),urlInfo27);

    SimpleWebCommandOperationInfo urlInfo28= new SimpleWebCommandOperationInfo();
    urlInfo28.setMsgCode(20902);
    urlInfo28.setUrl("/cbhs/base/gzUpdate");
    urlInfo28.setOpCode("0");
    urlInfo28.setWorkClass("");
    urlInfo28.setMsgReaquest("com.server.pojo.bean.CbhsGz");
    urlInfo28.setReaquestDepict("工种");
    urlInfo28.setMsgResponse("com.server.pojo.bean.CbhsGz");
    urlInfo28.setResponseDepict("工种");
    urlInfo28.setTransation(true);
    urlInfo28.setRestClass("gzUpdate");
    webCommands.put(urlInfo28.getUrl(),urlInfo28);
    codeOpMap.put(urlInfo28.getMsgCode(),urlInfo28);

    SimpleWebCommandOperationInfo urlInfo29= new SimpleWebCommandOperationInfo();
    urlInfo29.setMsgCode(20903);
    urlInfo29.setUrl("/cbhs/base/gzDel");
    urlInfo29.setOpCode("0");
    urlInfo29.setWorkClass("");
    urlInfo29.setMsgReaquest("com.server.pojo.url.base.RequestGzDel");
    urlInfo29.setReaquestDepict("工种ID集合");
    urlInfo29.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo29.setResponseDepict("标识");
    urlInfo29.setTransation(false);
    urlInfo29.setRestClass("gzDel");
    webCommands.put(urlInfo29.getUrl(),urlInfo29);
    codeOpMap.put(urlInfo29.getMsgCode(),urlInfo29);

    SimpleWebCommandOperationInfo urlInfo30= new SimpleWebCommandOperationInfo();
    urlInfo30.setMsgCode(20904);
    urlInfo30.setUrl("/cbhs/base/gzFetch");
    urlInfo30.setOpCode("0");
    urlInfo30.setWorkClass("");
    urlInfo30.setMsgReaquest("com.server.pojo.url.base.RequestGzFetch");
    urlInfo30.setReaquestDepict("工种ID,工种名称,页码,数量,开始编号,工种状态");
    urlInfo30.setMsgResponse("com.server.pojo.url.base.ResponseGzFetch");
    urlInfo30.setResponseDepict("工种集合,总数");
    urlInfo30.setTransation(true);
    urlInfo30.setRestClass("gzFetch");
    webCommands.put(urlInfo30.getUrl(),urlInfo30);
    codeOpMap.put(urlInfo30.getMsgCode(),urlInfo30);

    SimpleWebCommandOperationInfo urlInfo31= new SimpleWebCommandOperationInfo();
    urlInfo31.setMsgCode(21001);
    urlInfo31.setUrl("/cbhs/base/htAdd");
    urlInfo31.setOpCode("0");
    urlInfo31.setWorkClass("");
    urlInfo31.setMsgReaquest("com.server.pojo.bean.CbhsHt");
    urlInfo31.setReaquestDepict("合同");
    urlInfo31.setMsgResponse("com.server.pojo.bean.CbhsHt");
    urlInfo31.setResponseDepict("合同");
    urlInfo31.setTransation(true);
    urlInfo31.setRestClass("htAdd");
    webCommands.put(urlInfo31.getUrl(),urlInfo31);
    codeOpMap.put(urlInfo31.getMsgCode(),urlInfo31);

    SimpleWebCommandOperationInfo urlInfo32= new SimpleWebCommandOperationInfo();
    urlInfo32.setMsgCode(21002);
    urlInfo32.setUrl("/cbhs/base/htUpdate");
    urlInfo32.setOpCode("0");
    urlInfo32.setWorkClass("");
    urlInfo32.setMsgReaquest("com.server.pojo.bean.CbhsHt");
    urlInfo32.setReaquestDepict("合同");
    urlInfo32.setMsgResponse("com.server.pojo.bean.CbhsHt");
    urlInfo32.setResponseDepict("合同");
    urlInfo32.setTransation(true);
    urlInfo32.setRestClass("htUpdate");
    webCommands.put(urlInfo32.getUrl(),urlInfo32);
    codeOpMap.put(urlInfo32.getMsgCode(),urlInfo32);

    SimpleWebCommandOperationInfo urlInfo33= new SimpleWebCommandOperationInfo();
    urlInfo33.setMsgCode(21003);
    urlInfo33.setUrl("/cbhs/base/htDel");
    urlInfo33.setOpCode("0");
    urlInfo33.setWorkClass("");
    urlInfo33.setMsgReaquest("com.server.pojo.url.base.RequestHtDel");
    urlInfo33.setReaquestDepict("合同ID集合");
    urlInfo33.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo33.setResponseDepict("标识");
    urlInfo33.setTransation(false);
    urlInfo33.setRestClass("htDel");
    webCommands.put(urlInfo33.getUrl(),urlInfo33);
    codeOpMap.put(urlInfo33.getMsgCode(),urlInfo33);

    SimpleWebCommandOperationInfo urlInfo34= new SimpleWebCommandOperationInfo();
    urlInfo34.setMsgCode(21004);
    urlInfo34.setUrl("/cbhs/base/htFetch");
    urlInfo34.setOpCode("0");
    urlInfo34.setWorkClass("");
    urlInfo34.setMsgReaquest("com.server.pojo.url.base.RequestHtFetch");
    urlInfo34.setReaquestDepict("合同ID,工种名称,页码,数量,开始编号,工种状态,分包商ID,分包商名称,合同编号");
    urlInfo34.setMsgResponse("com.server.pojo.url.base.ResponseHtFetch");
    urlInfo34.setResponseDepict("合同集合,总数");
    urlInfo34.setTransation(true);
    urlInfo34.setRestClass("htFetch");
    webCommands.put(urlInfo34.getUrl(),urlInfo34);
    codeOpMap.put(urlInfo34.getMsgCode(),urlInfo34);

    SimpleWebCommandOperationInfo urlInfo35= new SimpleWebCommandOperationInfo();
    urlInfo35.setMsgCode(21101);
    urlInfo35.setUrl("/cbhs/base/contactsAdd");
    urlInfo35.setOpCode("0");
    urlInfo35.setWorkClass("");
    urlInfo35.setMsgReaquest("com.server.pojo.bean.CbhsContacts");
    urlInfo35.setReaquestDepict("联系人");
    urlInfo35.setMsgResponse("com.server.pojo.bean.CbhsContacts");
    urlInfo35.setResponseDepict("联系人");
    urlInfo35.setTransation(true);
    urlInfo35.setRestClass("contactsAdd");
    webCommands.put(urlInfo35.getUrl(),urlInfo35);
    codeOpMap.put(urlInfo35.getMsgCode(),urlInfo35);

    SimpleWebCommandOperationInfo urlInfo36= new SimpleWebCommandOperationInfo();
    urlInfo36.setMsgCode(21102);
    urlInfo36.setUrl("/cbhs/base/contactsUpdate");
    urlInfo36.setOpCode("0");
    urlInfo36.setWorkClass("");
    urlInfo36.setMsgReaquest("com.server.pojo.bean.CbhsContacts");
    urlInfo36.setReaquestDepict("联系人");
    urlInfo36.setMsgResponse("com.server.pojo.bean.CbhsContacts");
    urlInfo36.setResponseDepict("联系人");
    urlInfo36.setTransation(true);
    urlInfo36.setRestClass("contactsUpdate");
    webCommands.put(urlInfo36.getUrl(),urlInfo36);
    codeOpMap.put(urlInfo36.getMsgCode(),urlInfo36);

    SimpleWebCommandOperationInfo urlInfo37= new SimpleWebCommandOperationInfo();
    urlInfo37.setMsgCode(21103);
    urlInfo37.setUrl("/cbhs/base/contactsDel");
    urlInfo37.setOpCode("0");
    urlInfo37.setWorkClass("");
    urlInfo37.setMsgReaquest("com.server.pojo.url.base.RequestContactsDel");
    urlInfo37.setReaquestDepict("联系人ID集合");
    urlInfo37.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo37.setResponseDepict("标识");
    urlInfo37.setTransation(false);
    urlInfo37.setRestClass("contactsDel");
    webCommands.put(urlInfo37.getUrl(),urlInfo37);
    codeOpMap.put(urlInfo37.getMsgCode(),urlInfo37);

    SimpleWebCommandOperationInfo urlInfo38= new SimpleWebCommandOperationInfo();
    urlInfo38.setMsgCode(21104);
    urlInfo38.setUrl("/cbhs/base/contactsFetch");
    urlInfo38.setOpCode("0");
    urlInfo38.setWorkClass("");
    urlInfo38.setMsgReaquest("com.server.pojo.url.base.RequestContactsFetch");
    urlInfo38.setReaquestDepict("联系人ID,姓名(模糊查询),电话(模糊查询),职位(模糊查询),页码,数量,开始ID");
    urlInfo38.setMsgResponse("com.server.pojo.url.base.ResponseContactsFetch");
    urlInfo38.setResponseDepict("联系人集合,总数");
    urlInfo38.setTransation(true);
    urlInfo38.setRestClass("contactsFetch");
    webCommands.put(urlInfo38.getUrl(),urlInfo38);
    codeOpMap.put(urlInfo38.getMsgCode(),urlInfo38);

    SimpleWebCommandOperationInfo urlInfo39= new SimpleWebCommandOperationInfo();
    urlInfo39.setMsgCode(21105);
    urlInfo39.setUrl("/cbhs/base/contactsImport");
    urlInfo39.setOpCode("0");
    urlInfo39.setWorkClass("");
    urlInfo39.setMsgReaquest("com.server.pojo.bean.MultipartFile");
    urlInfo39.setReaquestDepict("联系人Excel");
    urlInfo39.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo39.setResponseDepict("标识");
    urlInfo39.setTransation(true);
    urlInfo39.setRestClass("contactsImport");
    webCommands.put(urlInfo39.getUrl(),urlInfo39);
    codeOpMap.put(urlInfo39.getMsgCode(),urlInfo39);

    SimpleWebCommandOperationInfo urlInfo40= new SimpleWebCommandOperationInfo();
    urlInfo40.setMsgCode(70501);
    urlInfo40.setUrl("/cbhs/cbshe/examinerRuleAdd");
    urlInfo40.setOpCode("0");
    urlInfo40.setWorkClass("");
    urlInfo40.setMsgReaquest("com.server.pojo.bean.CbhsCbExaminerRule");
    urlInfo40.setReaquestDepict("部门");
    urlInfo40.setMsgResponse("com.server.pojo.bean.CbhsCbExaminerRule");
    urlInfo40.setResponseDepict("审核规则信息");
    urlInfo40.setTransation(true);
    urlInfo40.setRestClass("examinerRuleAdd");
    webCommands.put(urlInfo40.getUrl(),urlInfo40);
    codeOpMap.put(urlInfo40.getMsgCode(),urlInfo40);

    SimpleWebCommandOperationInfo urlInfo41= new SimpleWebCommandOperationInfo();
    urlInfo41.setMsgCode(70502);
    urlInfo41.setUrl("/cbhs/cbshe/examinerRuleUpdate");
    urlInfo41.setOpCode("0");
    urlInfo41.setWorkClass("");
    urlInfo41.setMsgReaquest("com.server.pojo.bean.CbhsCbExaminerRule");
    urlInfo41.setReaquestDepict("部门");
    urlInfo41.setMsgResponse("com.server.pojo.bean.CbhsCbExaminerRule");
    urlInfo41.setResponseDepict("审核规则信息");
    urlInfo41.setTransation(true);
    urlInfo41.setRestClass("examinerRuleUpdate");
    webCommands.put(urlInfo41.getUrl(),urlInfo41);
    codeOpMap.put(urlInfo41.getMsgCode(),urlInfo41);

    SimpleWebCommandOperationInfo urlInfo42= new SimpleWebCommandOperationInfo();
    urlInfo42.setMsgCode(70503);
    urlInfo42.setUrl("/cbhs/cbshe/examinerRuleDel");
    urlInfo42.setOpCode("0");
    urlInfo42.setWorkClass("");
    urlInfo42.setMsgReaquest("com.server.pojo.url.cbshe.RequestExaminerRuleDel");
    urlInfo42.setReaquestDepict("部门ID集合");
    urlInfo42.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo42.setResponseDepict("响应状态码");
    urlInfo42.setTransation(false);
    urlInfo42.setRestClass("examinerRuleDel");
    webCommands.put(urlInfo42.getUrl(),urlInfo42);
    codeOpMap.put(urlInfo42.getMsgCode(),urlInfo42);

    SimpleWebCommandOperationInfo urlInfo43= new SimpleWebCommandOperationInfo();
    urlInfo43.setMsgCode(70504);
    urlInfo43.setUrl("/cbhs/cbshe/examinerRuleFetch");
    urlInfo43.setOpCode("0");
    urlInfo43.setWorkClass("");
    urlInfo43.setMsgReaquest("com.server.pojo.url.cbshe.RequestExaminerRuleFetch");
    urlInfo43.setReaquestDepict("规则ID,部门ID,工程项目ID,人员ID,页码,数量,开始ID,审核方式");
    urlInfo43.setMsgResponse("com.server.pojo.url.cbshe.ResponseExaminerRuleFetch");
    urlInfo43.setResponseDepict("审核规则集合,总条数");
    urlInfo43.setTransation(true);
    urlInfo43.setRestClass("examinerRuleFetch");
    webCommands.put(urlInfo43.getUrl(),urlInfo43);
    codeOpMap.put(urlInfo43.getMsgCode(),urlInfo43);

    SimpleWebCommandOperationInfo urlInfo44= new SimpleWebCommandOperationInfo();
    urlInfo44.setMsgCode(70601);
    urlInfo44.setUrl("/cbhs/cbshe/examCb");
    urlInfo44.setOpCode("0");
    urlInfo44.setWorkClass("");
    urlInfo44.setMsgReaquest("com.server.pojo.url.cbshe.RequestExamCb");
    urlInfo44.setReaquestDepict("审核任务ID,审核通过(1批准 2拒绝),备注说明");
    urlInfo44.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo44.setResponseDepict("响应状态码");
    urlInfo44.setTransation(true);
    urlInfo44.setRestClass("examCb");
    webCommands.put(urlInfo44.getUrl(),urlInfo44);
    codeOpMap.put(urlInfo44.getMsgCode(),urlInfo44);

    SimpleWebCommandOperationInfo urlInfo45= new SimpleWebCommandOperationInfo();
    urlInfo45.setMsgCode(70701);
    urlInfo45.setUrl("/cbhs/cbshe/examTaskFetch");
    urlInfo45.setOpCode("0");
    urlInfo45.setWorkClass("");
    urlInfo45.setMsgReaquest("com.server.pojo.url.cbshe.RequestExamTaskFetch");
    urlInfo45.setReaquestDepict("审核任务ID,工程项目ID,页码,数量,开始ID,类型( 0 用户参与的审核  1 轮到用户自己审核的 2 审核完成的)");
    urlInfo45.setMsgResponse("com.server.pojo.url.cbshe.ResponseExamTaskFetch");
    urlInfo45.setResponseDepict("审核任务集合,总条数");
    urlInfo45.setTransation(true);
    urlInfo45.setRestClass("examTaskFetch");
    webCommands.put(urlInfo45.getUrl(),urlInfo45);
    codeOpMap.put(urlInfo45.getMsgCode(),urlInfo45);

    SimpleWebCommandOperationInfo urlInfo46= new SimpleWebCommandOperationInfo();
    urlInfo46.setMsgCode(70702);
    urlInfo46.setUrl("/cbhs/cbshe/examTaskStepFetch");
    urlInfo46.setOpCode("0");
    urlInfo46.setWorkClass("");
    urlInfo46.setMsgReaquest("com.server.pojo.url.cbshe.RequestExamTaskStepFetch");
    urlInfo46.setReaquestDepict("审核任务ID,页码,数量,开始ID");
    urlInfo46.setMsgResponse("com.server.pojo.url.cbshe.ResponseExamTaskStepFetch");
    urlInfo46.setResponseDepict("审核任务步骤,总条数");
    urlInfo46.setTransation(true);
    urlInfo46.setRestClass("examTaskStepFetch");
    webCommands.put(urlInfo46.getUrl(),urlInfo46);
    codeOpMap.put(urlInfo46.getMsgCode(),urlInfo46);

    SimpleWebCommandOperationInfo urlInfo47= new SimpleWebCommandOperationInfo();
    urlInfo47.setMsgCode(70703);
    urlInfo47.setUrl("/cbhs/cbshe/examMyCreateTaskFetch");
    urlInfo47.setOpCode("0");
    urlInfo47.setWorkClass("");
    urlInfo47.setMsgReaquest("com.server.pojo.url.cbshe.RequestExamMyCreateTaskFetch");
    urlInfo47.setReaquestDepict("工程项目ID,页码,数量,开始ID");
    urlInfo47.setMsgResponse("com.server.pojo.url.cbshe.ResponseExamMyCreateTaskFetch");
    urlInfo47.setResponseDepict("审核任务集合,总条数");
    urlInfo47.setTransation(true);
    urlInfo47.setRestClass("examMyCreateTaskFetch");
    webCommands.put(urlInfo47.getUrl(),urlInfo47);
    codeOpMap.put(urlInfo47.getMsgCode(),urlInfo47);

    SimpleWebCommandOperationInfo urlInfo48= new SimpleWebCommandOperationInfo();
    urlInfo48.setMsgCode(70704);
    urlInfo48.setUrl("/cbhs/cbshe/cancelExam");
    urlInfo48.setOpCode("0");
    urlInfo48.setWorkClass("");
    urlInfo48.setMsgReaquest("com.server.pojo.url.cbshe.RequestCancelExam");
    urlInfo48.setReaquestDepict("审核任务ID");
    urlInfo48.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo48.setResponseDepict("响应状态码");
    urlInfo48.setTransation(true);
    urlInfo48.setRestClass("cancelExam");
    webCommands.put(urlInfo48.getUrl(),urlInfo48);
    codeOpMap.put(urlInfo48.getMsgCode(),urlInfo48);

    SimpleWebCommandOperationInfo urlInfo49= new SimpleWebCommandOperationInfo();
    urlInfo49.setMsgCode(90101);
    urlInfo49.setUrl("/cbhs/clhx/zyGclFetch");
    urlInfo49.setOpCode("0");
    urlInfo49.setWorkClass("");
    urlInfo49.setMsgReaquest("com.server.pojo.url.clhx.RequestZyGclFetch");
    urlInfo49.setReaquestDepict("工程项目ID,部门ID,月份,页码,数量,开始ID");
    urlInfo49.setMsgResponse("com.server.pojo.url.clhx.ResponseZyGclFetch");
    urlInfo49.setResponseDepict("工程项清单集合,总条数");
    urlInfo49.setTransation(true);
    urlInfo49.setRestClass("zyGclFetch");
    webCommands.put(urlInfo49.getUrl(),urlInfo49);
    codeOpMap.put(urlInfo49.getMsgCode(),urlInfo49);

    SimpleWebCommandOperationInfo urlInfo50= new SimpleWebCommandOperationInfo();
    urlInfo50.setMsgCode(90102);
    urlInfo50.setUrl("/cbhs/clhx/zyClhxFetch");
    urlInfo50.setOpCode("0");
    urlInfo50.setWorkClass("");
    urlInfo50.setMsgReaquest("com.server.pojo.url.clhx.RequestZyClhxFetch");
    urlInfo50.setReaquestDepict("工程项目ID,部门ID,月份,工程量清单ID,页码,数量,开始ID");
    urlInfo50.setMsgResponse("com.server.pojo.url.clhx.ResponseZyClhxFetch");
    urlInfo50.setResponseDepict("材料核销集合,总条数");
    urlInfo50.setTransation(true);
    urlInfo50.setRestClass("zyClhxFetch");
    webCommands.put(urlInfo50.getUrl(),urlInfo50);
    codeOpMap.put(urlInfo50.getMsgCode(),urlInfo50);

    SimpleWebCommandOperationInfo urlInfo51= new SimpleWebCommandOperationInfo();
    urlInfo51.setMsgCode(90103);
    urlInfo51.setUrl("/cbhs/clhx/fbGclFetch");
    urlInfo51.setOpCode("0");
    urlInfo51.setWorkClass("");
    urlInfo51.setMsgReaquest("com.server.pojo.url.clhx.RequestFbGclFetch");
    urlInfo51.setReaquestDepict("工程项目ID,部门ID,月份,页码,数量,开始ID");
    urlInfo51.setMsgResponse("com.server.pojo.url.clhx.ResponseFbGclFetch");
    urlInfo51.setResponseDepict("工程项清单集合,总条数");
    urlInfo51.setTransation(true);
    urlInfo51.setRestClass("fbGclFetch");
    webCommands.put(urlInfo51.getUrl(),urlInfo51);
    codeOpMap.put(urlInfo51.getMsgCode(),urlInfo51);

    SimpleWebCommandOperationInfo urlInfo52= new SimpleWebCommandOperationInfo();
    urlInfo52.setMsgCode(90104);
    urlInfo52.setUrl("/cbhs/clhx/fbClhxFetch");
    urlInfo52.setOpCode("0");
    urlInfo52.setWorkClass("");
    urlInfo52.setMsgReaquest("com.server.pojo.url.clhx.RequestFbClhxFetch");
    urlInfo52.setReaquestDepict("工程项目ID,部门ID,月份,分包工程清单ID,页码,数量,开始ID");
    urlInfo52.setMsgResponse("com.server.pojo.url.clhx.ResponseFbClhxFetch");
    urlInfo52.setResponseDepict("材料核销集合,总条数");
    urlInfo52.setTransation(true);
    urlInfo52.setRestClass("fbClhxFetch");
    webCommands.put(urlInfo52.getUrl(),urlInfo52);
    codeOpMap.put(urlInfo52.getMsgCode(),urlInfo52);

    SimpleWebCommandOperationInfo urlInfo53= new SimpleWebCommandOperationInfo();
    urlInfo53.setMsgCode(10101);
    urlInfo53.setUrl("/cbhs/common/login");
    urlInfo53.setOpCode("-1");
    urlInfo53.setWorkClass("");
    urlInfo53.setMsgReaquest("com.server.pojo.url.common.RequestLogin");
    urlInfo53.setReaquestDepict("账号,密码,登录方式(pwd 密码登录|phone 手机号码登录),登录平台(app|web 默认为app)");
    urlInfo53.setMsgResponse("com.server.pojo.url.common.ResponseLogin");
    urlInfo53.setResponseDepict("账号主键,token,用户信息,可操作的菜单,可操作的部门,最新版本信息");
    urlInfo53.setTransation(false);
    urlInfo53.setRestClass("login");
    webCommands.put(urlInfo53.getUrl(),urlInfo53);
    codeOpMap.put(urlInfo53.getMsgCode(),urlInfo53);

    SimpleWebCommandOperationInfo urlInfo54= new SimpleWebCommandOperationInfo();
    urlInfo54.setMsgCode(10102);
    urlInfo54.setUrl("/cbhs/common/exit");
    urlInfo54.setOpCode("-1");
    urlInfo54.setWorkClass("");
    urlInfo54.setMsgReaquest("com.server.pojo.url.common.RequestExit");
    urlInfo54.setReaquestDepict("账号标识,token,登录平台(app|web 默认为app)");
    urlInfo54.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo54.setResponseDepict("响应状态码");
    urlInfo54.setTransation(false);
    urlInfo54.setRestClass("exit");
    webCommands.put(urlInfo54.getUrl(),urlInfo54);
    codeOpMap.put(urlInfo54.getMsgCode(),urlInfo54);

    SimpleWebCommandOperationInfo urlInfo55= new SimpleWebCommandOperationInfo();
    urlInfo55.setMsgCode(10103);
    urlInfo55.setUrl("/cbhs/common/regAdmin");
    urlInfo55.setOpCode("-1");
    urlInfo55.setWorkClass("");
    urlInfo55.setMsgReaquest("com.server.pojo.url.common.RequestRegAdmin");
    urlInfo55.setReaquestDepict("账号,密码,名称,手机号码,性别");
    urlInfo55.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo55.setResponseDepict("响应状态码");
    urlInfo55.setTransation(false);
    urlInfo55.setRestClass("regAdmin");
    webCommands.put(urlInfo55.getUrl(),urlInfo55);
    codeOpMap.put(urlInfo55.getMsgCode(),urlInfo55);

    SimpleWebCommandOperationInfo urlInfo56= new SimpleWebCommandOperationInfo();
    urlInfo56.setMsgCode(10104);
    urlInfo56.setUrl("/cbhs/common/regUser");
    urlInfo56.setOpCode("0");
    urlInfo56.setWorkClass("");
    urlInfo56.setMsgReaquest("com.server.pojo.url.common.RequestRegUser");
    urlInfo56.setReaquestDepict("账号,密码,名称,手机号码,性别,自定义菜单,角色,角色名称,部门,部门名称,是否可操作所有部门");
    urlInfo56.setMsgResponse("com.server.pojo.bean.CbhsUser");
    urlInfo56.setResponseDepict("用户信息");
    urlInfo56.setTransation(false);
    urlInfo56.setRestClass("regUser");
    webCommands.put(urlInfo56.getUrl(),urlInfo56);
    codeOpMap.put(urlInfo56.getMsgCode(),urlInfo56);

    SimpleWebCommandOperationInfo urlInfo57= new SimpleWebCommandOperationInfo();
    urlInfo57.setMsgCode(10105);
    urlInfo57.setUrl("/cbhs/common/getUser");
    urlInfo57.setOpCode("0");
    urlInfo57.setWorkClass("");
    urlInfo57.setMsgReaquest("com.server.pojo.url.common.RequestGetUser");
    urlInfo57.setReaquestDepict("账号,名称,部门ID,角色ID,页码,数量,开始ID,状态");
    urlInfo57.setMsgResponse("com.server.pojo.url.common.ResponseGetUser");
    urlInfo57.setResponseDepict("用户信息集合,总条数");
    urlInfo57.setTransation(true);
    urlInfo57.setRestClass("getUser");
    webCommands.put(urlInfo57.getUrl(),urlInfo57);
    codeOpMap.put(urlInfo57.getMsgCode(),urlInfo57);

    SimpleWebCommandOperationInfo urlInfo58= new SimpleWebCommandOperationInfo();
    urlInfo58.setMsgCode(10106);
    urlInfo58.setUrl("/cbhs/common/modifyPwd");
    urlInfo58.setOpCode("0");
    urlInfo58.setWorkClass("");
    urlInfo58.setMsgReaquest("com.server.pojo.url.common.RequestModifyPwd");
    urlInfo58.setReaquestDepict("账号标识,旧密码,新密码");
    urlInfo58.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo58.setResponseDepict("响应状态码");
    urlInfo58.setTransation(false);
    urlInfo58.setRestClass("modifyPwd");
    webCommands.put(urlInfo58.getUrl(),urlInfo58);
    codeOpMap.put(urlInfo58.getMsgCode(),urlInfo58);

    SimpleWebCommandOperationInfo urlInfo59= new SimpleWebCommandOperationInfo();
    urlInfo59.setMsgCode(10107);
    urlInfo59.setUrl("/cbhs/common/updateUser");
    urlInfo59.setOpCode("0");
    urlInfo59.setWorkClass("");
    urlInfo59.setMsgReaquest("com.server.pojo.bean.CbhsUser");
    urlInfo59.setReaquestDepict("用户信息");
    urlInfo59.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo59.setResponseDepict("响应状态码");
    urlInfo59.setTransation(true);
    urlInfo59.setRestClass("updateUser");
    webCommands.put(urlInfo59.getUrl(),urlInfo59);
    codeOpMap.put(urlInfo59.getMsgCode(),urlInfo59);

    SimpleWebCommandOperationInfo urlInfo60= new SimpleWebCommandOperationInfo();
    urlInfo60.setMsgCode(10108);
    urlInfo60.setUrl("/cbhs/common/uploadAvatar");
    urlInfo60.setOpCode("0");
    urlInfo60.setWorkClass("");
    urlInfo60.setMsgReaquest("com.server.pojo.url.common.RequestUploadAvatar");
    urlInfo60.setReaquestDepict("上传的资源ID");
    urlInfo60.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo60.setResponseDepict("响应状态码");
    urlInfo60.setTransation(true);
    urlInfo60.setRestClass("uploadAvatar");
    webCommands.put(urlInfo60.getUrl(),urlInfo60);
    codeOpMap.put(urlInfo60.getMsgCode(),urlInfo60);

    SimpleWebCommandOperationInfo urlInfo61= new SimpleWebCommandOperationInfo();
    urlInfo61.setMsgCode(10109);
    urlInfo61.setUrl("/cbhs/common/delUser");
    urlInfo61.setOpCode("0");
    urlInfo61.setWorkClass("");
    urlInfo61.setMsgReaquest("com.server.pojo.url.common.RequestDelUser");
    urlInfo61.setReaquestDepict("用户ID集合");
    urlInfo61.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo61.setResponseDepict("响应状态码");
    urlInfo61.setTransation(true);
    urlInfo61.setRestClass("delUser");
    webCommands.put(urlInfo61.getUrl(),urlInfo61);
    codeOpMap.put(urlInfo61.getMsgCode(),urlInfo61);

    SimpleWebCommandOperationInfo urlInfo62= new SimpleWebCommandOperationInfo();
    urlInfo62.setMsgCode(10201);
    urlInfo62.setUrl("/cbhs/common/roleAdd");
    urlInfo62.setOpCode("0");
    urlInfo62.setWorkClass("");
    urlInfo62.setMsgReaquest("com.server.pojo.bean.CbhsRole");
    urlInfo62.setReaquestDepict("角色");
    urlInfo62.setMsgResponse("com.server.pojo.bean.CbhsRole");
    urlInfo62.setResponseDepict("角色信息");
    urlInfo62.setTransation(true);
    urlInfo62.setRestClass("roleAdd");
    webCommands.put(urlInfo62.getUrl(),urlInfo62);
    codeOpMap.put(urlInfo62.getMsgCode(),urlInfo62);

    SimpleWebCommandOperationInfo urlInfo63= new SimpleWebCommandOperationInfo();
    urlInfo63.setMsgCode(10202);
    urlInfo63.setUrl("/cbhs/common/roleUpdate");
    urlInfo63.setOpCode("0");
    urlInfo63.setWorkClass("");
    urlInfo63.setMsgReaquest("com.server.pojo.bean.CbhsRole");
    urlInfo63.setReaquestDepict("角色");
    urlInfo63.setMsgResponse("com.server.pojo.bean.CbhsRole");
    urlInfo63.setResponseDepict("角色信息");
    urlInfo63.setTransation(true);
    urlInfo63.setRestClass("roleUpdate");
    webCommands.put(urlInfo63.getUrl(),urlInfo63);
    codeOpMap.put(urlInfo63.getMsgCode(),urlInfo63);

    SimpleWebCommandOperationInfo urlInfo64= new SimpleWebCommandOperationInfo();
    urlInfo64.setMsgCode(10203);
    urlInfo64.setUrl("/cbhs/common/roleDel");
    urlInfo64.setOpCode("0");
    urlInfo64.setWorkClass("");
    urlInfo64.setMsgReaquest("com.server.pojo.url.common.RequestRoleDel");
    urlInfo64.setReaquestDepict("角色ID集合");
    urlInfo64.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo64.setResponseDepict("响应状态码");
    urlInfo64.setTransation(false);
    urlInfo64.setRestClass("roleDel");
    webCommands.put(urlInfo64.getUrl(),urlInfo64);
    codeOpMap.put(urlInfo64.getMsgCode(),urlInfo64);

    SimpleWebCommandOperationInfo urlInfo65= new SimpleWebCommandOperationInfo();
    urlInfo65.setMsgCode(10204);
    urlInfo65.setUrl("/cbhs/common/roleFetch");
    urlInfo65.setOpCode("0");
    urlInfo65.setWorkClass("");
    urlInfo65.setMsgReaquest("com.server.pojo.url.common.RequestRoleFetch");
    urlInfo65.setReaquestDepict("角色ID,角色名称(模糊查询),页码,数量,开始ID,角色状态");
    urlInfo65.setMsgResponse("com.server.pojo.url.common.ResponseRoleFetch");
    urlInfo65.setResponseDepict("角色信息集合,总条数");
    urlInfo65.setTransation(true);
    urlInfo65.setRestClass("roleFetch");
    webCommands.put(urlInfo65.getUrl(),urlInfo65);
    codeOpMap.put(urlInfo65.getMsgCode(),urlInfo65);

    SimpleWebCommandOperationInfo urlInfo66= new SimpleWebCommandOperationInfo();
    urlInfo66.setMsgCode(10301);
    urlInfo66.setUrl("/cbhs/common/deptAdd");
    urlInfo66.setOpCode("0");
    urlInfo66.setWorkClass("");
    urlInfo66.setMsgReaquest("com.server.pojo.bean.CbhsDept");
    urlInfo66.setReaquestDepict("部门");
    urlInfo66.setMsgResponse("com.server.pojo.bean.CbhsDept");
    urlInfo66.setResponseDepict("部门信息");
    urlInfo66.setTransation(true);
    urlInfo66.setRestClass("deptAdd");
    webCommands.put(urlInfo66.getUrl(),urlInfo66);
    codeOpMap.put(urlInfo66.getMsgCode(),urlInfo66);

    SimpleWebCommandOperationInfo urlInfo67= new SimpleWebCommandOperationInfo();
    urlInfo67.setMsgCode(10302);
    urlInfo67.setUrl("/cbhs/common/deptUpdate");
    urlInfo67.setOpCode("0");
    urlInfo67.setWorkClass("");
    urlInfo67.setMsgReaquest("com.server.pojo.bean.CbhsDept");
    urlInfo67.setReaquestDepict("部门");
    urlInfo67.setMsgResponse("com.server.pojo.bean.CbhsDept");
    urlInfo67.setResponseDepict("部门信息");
    urlInfo67.setTransation(true);
    urlInfo67.setRestClass("deptUpdate");
    webCommands.put(urlInfo67.getUrl(),urlInfo67);
    codeOpMap.put(urlInfo67.getMsgCode(),urlInfo67);

    SimpleWebCommandOperationInfo urlInfo68= new SimpleWebCommandOperationInfo();
    urlInfo68.setMsgCode(10303);
    urlInfo68.setUrl("/cbhs/common/deptDel");
    urlInfo68.setOpCode("0");
    urlInfo68.setWorkClass("");
    urlInfo68.setMsgReaquest("com.server.pojo.url.common.RequestDeptDel");
    urlInfo68.setReaquestDepict("部门ID集合");
    urlInfo68.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo68.setResponseDepict("响应状态码");
    urlInfo68.setTransation(false);
    urlInfo68.setRestClass("deptDel");
    webCommands.put(urlInfo68.getUrl(),urlInfo68);
    codeOpMap.put(urlInfo68.getMsgCode(),urlInfo68);

    SimpleWebCommandOperationInfo urlInfo69= new SimpleWebCommandOperationInfo();
    urlInfo69.setMsgCode(10304);
    urlInfo69.setUrl("/cbhs/common/deptFetch");
    urlInfo69.setOpCode("0");
    urlInfo69.setWorkClass("");
    urlInfo69.setMsgReaquest("com.server.pojo.url.common.RequestDeptFetch");
    urlInfo69.setReaquestDepict("部门ID,部门名称,页码,数量,开始ID,部门状态");
    urlInfo69.setMsgResponse("com.server.pojo.url.common.ResponseDeptFetch");
    urlInfo69.setResponseDepict("部门信息集合,总条数");
    urlInfo69.setTransation(true);
    urlInfo69.setRestClass("deptFetch");
    webCommands.put(urlInfo69.getUrl(),urlInfo69);
    codeOpMap.put(urlInfo69.getMsgCode(),urlInfo69);

    SimpleWebCommandOperationInfo urlInfo70= new SimpleWebCommandOperationInfo();
    urlInfo70.setMsgCode(10401);
    urlInfo70.setUrl("/cbhs/common/jPushRegID");
    urlInfo70.setOpCode("0");
    urlInfo70.setWorkClass("");
    urlInfo70.setMsgReaquest("com.server.pojo.url.common.RequestJPushRegID");
    urlInfo70.setReaquestDepict("极光生成的设备ID");
    urlInfo70.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo70.setResponseDepict("响应状态码");
    urlInfo70.setTransation(true);
    urlInfo70.setRestClass("jPushRegID");
    webCommands.put(urlInfo70.getUrl(),urlInfo70);
    codeOpMap.put(urlInfo70.getMsgCode(),urlInfo70);

    SimpleWebCommandOperationInfo urlInfo71= new SimpleWebCommandOperationInfo();
    urlInfo71.setMsgCode(10501);
    urlInfo71.setUrl("/cbhs/common/versionAdd");
    urlInfo71.setOpCode("0");
    urlInfo71.setWorkClass("");
    urlInfo71.setMsgReaquest("com.server.pojo.bean.CbhsVersion");
    urlInfo71.setReaquestDepict("版本对象");
    urlInfo71.setMsgResponse("com.server.pojo.bean.CbhsVersion");
    urlInfo71.setResponseDepict("版本信息");
    urlInfo71.setTransation(true);
    urlInfo71.setRestClass("versionAdd");
    webCommands.put(urlInfo71.getUrl(),urlInfo71);
    codeOpMap.put(urlInfo71.getMsgCode(),urlInfo71);

    SimpleWebCommandOperationInfo urlInfo72= new SimpleWebCommandOperationInfo();
    urlInfo72.setMsgCode(10502);
    urlInfo72.setUrl("/cbhs/common/versionFetch");
    urlInfo72.setOpCode("0");
    urlInfo72.setWorkClass("");
    urlInfo72.setMsgReaquest("com.server.pojo.url.common.RequestVersionFetch");
    urlInfo72.setReaquestDepict("页码,数量,开始ID");
    urlInfo72.setMsgResponse("com.server.pojo.url.common.ResponseVersionFetch");
    urlInfo72.setResponseDepict("版本信息集合,总条数");
    urlInfo72.setTransation(true);
    urlInfo72.setRestClass("versionFetch");
    webCommands.put(urlInfo72.getUrl(),urlInfo72);
    codeOpMap.put(urlInfo72.getMsgCode(),urlInfo72);

    SimpleWebCommandOperationInfo urlInfo73= new SimpleWebCommandOperationInfo();
    urlInfo73.setMsgCode(10503);
    urlInfo73.setUrl("/cbhs/common/versionUpdate");
    urlInfo73.setOpCode("0");
    urlInfo73.setWorkClass("");
    urlInfo73.setMsgReaquest("com.server.pojo.bean.CbhsVersion");
    urlInfo73.setReaquestDepict("版本对象");
    urlInfo73.setMsgResponse("com.server.pojo.bean.CbhsVersion");
    urlInfo73.setResponseDepict("版本信息");
    urlInfo73.setTransation(true);
    urlInfo73.setRestClass("versionUpdate");
    webCommands.put(urlInfo73.getUrl(),urlInfo73);
    codeOpMap.put(urlInfo73.getMsgCode(),urlInfo73);

    SimpleWebCommandOperationInfo urlInfo74= new SimpleWebCommandOperationInfo();
    urlInfo74.setMsgCode(110101);
    urlInfo74.setUrl("/cbhs/cw/settlementUpAdd");
    urlInfo74.setOpCode("0");
    urlInfo74.setWorkClass("");
    urlInfo74.setMsgReaquest("com.server.pojo.bean.CbhsSettleUp");
    urlInfo74.setReaquestDepict("对上结算");
    urlInfo74.setMsgResponse("com.server.pojo.bean.CbhsSettleUp");
    urlInfo74.setResponseDepict("对上结算");
    urlInfo74.setTransation(true);
    urlInfo74.setRestClass("settlementUpAdd");
    webCommands.put(urlInfo74.getUrl(),urlInfo74);
    codeOpMap.put(urlInfo74.getMsgCode(),urlInfo74);

    SimpleWebCommandOperationInfo urlInfo75= new SimpleWebCommandOperationInfo();
    urlInfo75.setMsgCode(110102);
    urlInfo75.setUrl("/cbhs/cw/settlementUpUpdate");
    urlInfo75.setOpCode("0");
    urlInfo75.setWorkClass("");
    urlInfo75.setMsgReaquest("com.server.pojo.bean.CbhsSettleUp");
    urlInfo75.setReaquestDepict("对上结算");
    urlInfo75.setMsgResponse("com.server.pojo.bean.CbhsSettleUp");
    urlInfo75.setResponseDepict("对上结算");
    urlInfo75.setTransation(true);
    urlInfo75.setRestClass("settlementUpUpdate");
    webCommands.put(urlInfo75.getUrl(),urlInfo75);
    codeOpMap.put(urlInfo75.getMsgCode(),urlInfo75);

    SimpleWebCommandOperationInfo urlInfo76= new SimpleWebCommandOperationInfo();
    urlInfo76.setMsgCode(110103);
    urlInfo76.setUrl("/cbhs/cw/settlementUpDel");
    urlInfo76.setOpCode("0");
    urlInfo76.setWorkClass("");
    urlInfo76.setMsgReaquest("com.server.pojo.url.cw.RequestSettlementUpDel");
    urlInfo76.setReaquestDepict("对上结算ID集合");
    urlInfo76.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo76.setResponseDepict("标识");
    urlInfo76.setTransation(false);
    urlInfo76.setRestClass("settlementUpDel");
    webCommands.put(urlInfo76.getUrl(),urlInfo76);
    codeOpMap.put(urlInfo76.getMsgCode(),urlInfo76);

    SimpleWebCommandOperationInfo urlInfo77= new SimpleWebCommandOperationInfo();
    urlInfo77.setMsgCode(110104);
    urlInfo77.setUrl("/cbhs/cw/settlementUpFetch");
    urlInfo77.setOpCode("0");
    urlInfo77.setWorkClass("");
    urlInfo77.setMsgReaquest("com.server.pojo.url.cw.RequestSettlementUpFetch");
    urlInfo77.setReaquestDepict("对上结算ID,工程项目ID,总工程量清单ID,页码,数量,开始编号");
    urlInfo77.setMsgResponse("com.server.pojo.url.cw.ResponseSettlementUpFetch");
    urlInfo77.setResponseDepict("对上结算集合,总数");
    urlInfo77.setTransation(true);
    urlInfo77.setRestClass("settlementUpFetch");
    webCommands.put(urlInfo77.getUrl(),urlInfo77);
    codeOpMap.put(urlInfo77.getMsgCode(),urlInfo77);

    SimpleWebCommandOperationInfo urlInfo78= new SimpleWebCommandOperationInfo();
    urlInfo78.setMsgCode(110201);
    urlInfo78.setUrl("/cbhs/cw/settlementDownAdd");
    urlInfo78.setOpCode("0");
    urlInfo78.setWorkClass("");
    urlInfo78.setMsgReaquest("com.server.pojo.url.cw.RequestSettlementDownAdd");
    urlInfo78.setReaquestDepict("对下结算");
    urlInfo78.setMsgResponse("com.server.pojo.bean.CbhsSettleDown");
    urlInfo78.setResponseDepict("对下结算");
    urlInfo78.setTransation(true);
    urlInfo78.setRestClass("settlementDownAdd");
    webCommands.put(urlInfo78.getUrl(),urlInfo78);
    codeOpMap.put(urlInfo78.getMsgCode(),urlInfo78);

    SimpleWebCommandOperationInfo urlInfo79= new SimpleWebCommandOperationInfo();
    urlInfo79.setMsgCode(110202);
    urlInfo79.setUrl("/cbhs/cw/settlementDownUpdate");
    urlInfo79.setOpCode("0");
    urlInfo79.setWorkClass("");
    urlInfo79.setMsgReaquest("com.server.pojo.bean.CbhsSettleDown");
    urlInfo79.setReaquestDepict("对下结算");
    urlInfo79.setMsgResponse("com.server.pojo.bean.CbhsSettleDown");
    urlInfo79.setResponseDepict("对下结算");
    urlInfo79.setTransation(true);
    urlInfo79.setRestClass("settlementDownUpdate");
    webCommands.put(urlInfo79.getUrl(),urlInfo79);
    codeOpMap.put(urlInfo79.getMsgCode(),urlInfo79);

    SimpleWebCommandOperationInfo urlInfo80= new SimpleWebCommandOperationInfo();
    urlInfo80.setMsgCode(110203);
    urlInfo80.setUrl("/cbhs/cw/settlementDownDel");
    urlInfo80.setOpCode("0");
    urlInfo80.setWorkClass("");
    urlInfo80.setMsgReaquest("com.server.pojo.url.cw.RequestSettlementDownDel");
    urlInfo80.setReaquestDepict("对下结算ID集合");
    urlInfo80.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo80.setResponseDepict("标识");
    urlInfo80.setTransation(false);
    urlInfo80.setRestClass("settlementDownDel");
    webCommands.put(urlInfo80.getUrl(),urlInfo80);
    codeOpMap.put(urlInfo80.getMsgCode(),urlInfo80);

    SimpleWebCommandOperationInfo urlInfo81= new SimpleWebCommandOperationInfo();
    urlInfo81.setMsgCode(110204);
    urlInfo81.setUrl("/cbhs/cw/settlementDownFetch");
    urlInfo81.setOpCode("0");
    urlInfo81.setWorkClass("");
    urlInfo81.setMsgReaquest("com.server.pojo.url.cw.RequestSettlementDownFetch");
    urlInfo81.setReaquestDepict("对下结算ID,工程项目ID,总工程量清单ID,对上结算ID,页码,数量,开始编号");
    urlInfo81.setMsgResponse("com.server.pojo.url.cw.ResponseSettlementDownFetch");
    urlInfo81.setResponseDepict("对下结算集合,总数");
    urlInfo81.setTransation(true);
    urlInfo81.setRestClass("settlementDownFetch");
    webCommands.put(urlInfo81.getUrl(),urlInfo81);
    codeOpMap.put(urlInfo81.getMsgCode(),urlInfo81);

    SimpleWebCommandOperationInfo urlInfo82= new SimpleWebCommandOperationInfo();
    urlInfo82.setMsgCode(110301);
    urlInfo82.setUrl("/cbhs/cw/reimAdd");
    urlInfo82.setOpCode("0");
    urlInfo82.setWorkClass("");
    urlInfo82.setMsgReaquest("com.server.pojo.bean.CbhsReim");
    urlInfo82.setReaquestDepict("财务报销");
    urlInfo82.setMsgResponse("com.server.pojo.bean.CbhsReim");
    urlInfo82.setResponseDepict("财务报销");
    urlInfo82.setTransation(true);
    urlInfo82.setRestClass("reimAdd");
    webCommands.put(urlInfo82.getUrl(),urlInfo82);
    codeOpMap.put(urlInfo82.getMsgCode(),urlInfo82);

    SimpleWebCommandOperationInfo urlInfo83= new SimpleWebCommandOperationInfo();
    urlInfo83.setMsgCode(110302);
    urlInfo83.setUrl("/cbhs/cw/reimUpdate");
    urlInfo83.setOpCode("0");
    urlInfo83.setWorkClass("");
    urlInfo83.setMsgReaquest("com.server.pojo.bean.CbhsReim");
    urlInfo83.setReaquestDepict("财务报销");
    urlInfo83.setMsgResponse("com.server.pojo.bean.CbhsReim");
    urlInfo83.setResponseDepict("财务报销");
    urlInfo83.setTransation(true);
    urlInfo83.setRestClass("reimUpdate");
    webCommands.put(urlInfo83.getUrl(),urlInfo83);
    codeOpMap.put(urlInfo83.getMsgCode(),urlInfo83);

    SimpleWebCommandOperationInfo urlInfo84= new SimpleWebCommandOperationInfo();
    urlInfo84.setMsgCode(110303);
    urlInfo84.setUrl("/cbhs/cw/reimDel");
    urlInfo84.setOpCode("0");
    urlInfo84.setWorkClass("");
    urlInfo84.setMsgReaquest("com.server.pojo.url.cw.RequestReimDel");
    urlInfo84.setReaquestDepict("财务报销ID集合");
    urlInfo84.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo84.setResponseDepict("标识");
    urlInfo84.setTransation(false);
    urlInfo84.setRestClass("reimDel");
    webCommands.put(urlInfo84.getUrl(),urlInfo84);
    codeOpMap.put(urlInfo84.getMsgCode(),urlInfo84);

    SimpleWebCommandOperationInfo urlInfo85= new SimpleWebCommandOperationInfo();
    urlInfo85.setMsgCode(110304);
    urlInfo85.setUrl("/cbhs/cw/reimFetch");
    urlInfo85.setOpCode("0");
    urlInfo85.setWorkClass("");
    urlInfo85.setMsgReaquest("com.server.pojo.url.cw.RequestReimFetch");
    urlInfo85.setReaquestDepict("财务报销ID,工程项目ID,部门ID,页码,数量,开始编号,审核状态(0所有 1审核中 2审核通过),当前步骤");
    urlInfo85.setMsgResponse("com.server.pojo.url.cw.ResponseReimFetch");
    urlInfo85.setResponseDepict("财务报销集合,总数");
    urlInfo85.setTransation(true);
    urlInfo85.setRestClass("reimFetch");
    webCommands.put(urlInfo85.getUrl(),urlInfo85);
    codeOpMap.put(urlInfo85.getMsgCode(),urlInfo85);

    SimpleWebCommandOperationInfo urlInfo86= new SimpleWebCommandOperationInfo();
    urlInfo86.setMsgCode(110305);
    urlInfo86.setUrl("/cbhs/cw/reimShe");
    urlInfo86.setOpCode("0");
    urlInfo86.setWorkClass("");
    urlInfo86.setMsgReaquest("com.server.pojo.url.cw.RequestReimShe");
    urlInfo86.setReaquestDepict("财务报销ID,批准金额,审核通过(1批准 2拒绝)");
    urlInfo86.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo86.setResponseDepict("标识");
    urlInfo86.setTransation(true);
    urlInfo86.setRestClass("reimShe");
    webCommands.put(urlInfo86.getUrl(),urlInfo86);
    codeOpMap.put(urlInfo86.getMsgCode(),urlInfo86);

    SimpleWebCommandOperationInfo urlInfo87= new SimpleWebCommandOperationInfo();
    urlInfo87.setMsgCode(50101);
    urlInfo87.setUrl("/cbhs/daysCb/jjcbFetch");
    urlInfo87.setOpCode("0");
    urlInfo87.setWorkClass("");
    urlInfo87.setMsgReaquest("com.server.pojo.url.daysCb.RequestJjcbFetch");
    urlInfo87.setReaquestDepict("主键,部门ID,工程项目ID,开始日期,结束日期,页码,数量,开始ID");
    urlInfo87.setMsgResponse("com.server.pojo.url.daysCb.ResponseJjcbFetch");
    urlInfo87.setResponseDepict("间接成本预算集合,总条数,合计对象");
    urlInfo87.setTransation(true);
    urlInfo87.setRestClass("jjcbFetch");
    webCommands.put(urlInfo87.getUrl(),urlInfo87);
    codeOpMap.put(urlInfo87.getMsgCode(),urlInfo87);

    SimpleWebCommandOperationInfo urlInfo88= new SimpleWebCommandOperationInfo();
    urlInfo88.setMsgCode(50102);
    urlInfo88.setUrl("/cbhs/daysCb/jjcbUpdate");
    urlInfo88.setOpCode("0");
    urlInfo88.setWorkClass("");
    urlInfo88.setMsgReaquest("com.server.pojo.bean.CbhsDaysJjcb");
    urlInfo88.setReaquestDepict("间接成本");
    urlInfo88.setMsgResponse("com.server.pojo.bean.CbhsDaysJjcb");
    urlInfo88.setResponseDepict("间接成本");
    urlInfo88.setTransation(true);
    urlInfo88.setRestClass("jjcbUpdate");
    webCommands.put(urlInfo88.getUrl(),urlInfo88);
    codeOpMap.put(urlInfo88.getMsgCode(),urlInfo88);

    SimpleWebCommandOperationInfo urlInfo89= new SimpleWebCommandOperationInfo();
    urlInfo89.setMsgCode(50103);
    urlInfo89.setUrl("/cbhs/daysCb/jjcbDel");
    urlInfo89.setOpCode("0");
    urlInfo89.setWorkClass("");
    urlInfo89.setMsgReaquest("com.server.pojo.url.daysCb.RequestJjcbDel");
    urlInfo89.setReaquestDepict("间接成本主键集合");
    urlInfo89.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo89.setResponseDepict("响应状态码");
    urlInfo89.setTransation(false);
    urlInfo89.setRestClass("jjcbDel");
    webCommands.put(urlInfo89.getUrl(),urlInfo89);
    codeOpMap.put(urlInfo89.getMsgCode(),urlInfo89);

    SimpleWebCommandOperationInfo urlInfo90= new SimpleWebCommandOperationInfo();
    urlInfo90.setMsgCode(50104);
    urlInfo90.setUrl("/cbhs/daysCb/jjcbAdd");
    urlInfo90.setOpCode("0");
    urlInfo90.setWorkClass("");
    urlInfo90.setMsgReaquest("com.server.pojo.url.daysCb.RequestJjcbAdd");
    urlInfo90.setReaquestDepict("间接成本,提交方式(0默认提交 1审核提交)");
    urlInfo90.setMsgResponse("com.server.pojo.bean.CbhsDaysJjcb");
    urlInfo90.setResponseDepict("间接成本");
    urlInfo90.setTransation(true);
    urlInfo90.setRestClass("jjcbAdd");
    webCommands.put(urlInfo90.getUrl(),urlInfo90);
    codeOpMap.put(urlInfo90.getMsgCode(),urlInfo90);

    SimpleWebCommandOperationInfo urlInfo91= new SimpleWebCommandOperationInfo();
    urlInfo91.setMsgCode(50201);
    urlInfo91.setUrl("/cbhs/daysCb/glfyFetch");
    urlInfo91.setOpCode("0");
    urlInfo91.setWorkClass("");
    urlInfo91.setMsgReaquest("com.server.pojo.url.daysCb.RequestGlfyFetch");
    urlInfo91.setReaquestDepict("主键,部门ID,工程项目ID,开始日期,结束日期,页码,数量,开始ID");
    urlInfo91.setMsgResponse("com.server.pojo.url.daysCb.ResponseGlfyFetch");
    urlInfo91.setResponseDepict("管理费用集合,总条数");
    urlInfo91.setTransation(true);
    urlInfo91.setRestClass("glfyFetch");
    webCommands.put(urlInfo91.getUrl(),urlInfo91);
    codeOpMap.put(urlInfo91.getMsgCode(),urlInfo91);

    SimpleWebCommandOperationInfo urlInfo92= new SimpleWebCommandOperationInfo();
    urlInfo92.setMsgCode(50202);
    urlInfo92.setUrl("/cbhs/daysCb/glfyUpdate");
    urlInfo92.setOpCode("0");
    urlInfo92.setWorkClass("");
    urlInfo92.setMsgReaquest("com.server.pojo.bean.CbhsDaysGlfyYs");
    urlInfo92.setReaquestDepict("管理经费");
    urlInfo92.setMsgResponse("com.server.pojo.bean.CbhsDaysGlfyYs");
    urlInfo92.setResponseDepict("管理费用");
    urlInfo92.setTransation(true);
    urlInfo92.setRestClass("glfyUpdate");
    webCommands.put(urlInfo92.getUrl(),urlInfo92);
    codeOpMap.put(urlInfo92.getMsgCode(),urlInfo92);

    SimpleWebCommandOperationInfo urlInfo93= new SimpleWebCommandOperationInfo();
    urlInfo93.setMsgCode(50203);
    urlInfo93.setUrl("/cbhs/daysCb/glfyDel");
    urlInfo93.setOpCode("0");
    urlInfo93.setWorkClass("");
    urlInfo93.setMsgReaquest("com.server.pojo.url.daysCb.RequestGlfyDel");
    urlInfo93.setReaquestDepict("管理经费主键集合");
    urlInfo93.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo93.setResponseDepict("响应状态码");
    urlInfo93.setTransation(false);
    urlInfo93.setRestClass("glfyDel");
    webCommands.put(urlInfo93.getUrl(),urlInfo93);
    codeOpMap.put(urlInfo93.getMsgCode(),urlInfo93);

    SimpleWebCommandOperationInfo urlInfo94= new SimpleWebCommandOperationInfo();
    urlInfo94.setMsgCode(50204);
    urlInfo94.setUrl("/cbhs/daysCb/glfyAdd");
    urlInfo94.setOpCode("0");
    urlInfo94.setWorkClass("");
    urlInfo94.setMsgReaquest("com.server.pojo.url.daysCb.RequestGlfyAdd");
    urlInfo94.setReaquestDepict("管理经费,提交方式(0默认提交 1审核提交)");
    urlInfo94.setMsgResponse("com.server.pojo.bean.CbhsDaysGlfyYs");
    urlInfo94.setResponseDepict("管理费用");
    urlInfo94.setTransation(true);
    urlInfo94.setRestClass("glfyAdd");
    webCommands.put(urlInfo94.getUrl(),urlInfo94);
    codeOpMap.put(urlInfo94.getMsgCode(),urlInfo94);

    SimpleWebCommandOperationInfo urlInfo95= new SimpleWebCommandOperationInfo();
    urlInfo95.setMsgCode(50205);
    urlInfo95.setUrl("/cbhs/daysCb/todayFetch");
    urlInfo95.setOpCode("0");
    urlInfo95.setWorkClass("");
    urlInfo95.setMsgReaquest("com.server.pojo.url.daysCb.RequestTodayFetch");
    urlInfo95.setReaquestDepict("工程项目ID,日期");
    urlInfo95.setMsgResponse("com.server.pojo.bean.CbhsDaysGlfyYs");
    urlInfo95.setResponseDepict("管理费用");
    urlInfo95.setTransation(true);
    urlInfo95.setRestClass("todayFetch");
    webCommands.put(urlInfo95.getUrl(),urlInfo95);
    codeOpMap.put(urlInfo95.getMsgCode(),urlInfo95);

    SimpleWebCommandOperationInfo urlInfo96= new SimpleWebCommandOperationInfo();
    urlInfo96.setMsgCode(50401);
    urlInfo96.setUrl("/cbhs/daysCb/zyLxygCbFetch");
    urlInfo96.setOpCode("0");
    urlInfo96.setWorkClass("");
    urlInfo96.setMsgReaquest("com.server.pojo.url.daysCb.RequestZyLxygCbFetch");
    urlInfo96.setReaquestDepict("主键,部门ID,工程项目ID,开始日期,结束日期,页码,数量,开始ID");
    urlInfo96.setMsgResponse("com.server.pojo.url.daysCb.ResponseZyLxygCbFetch");
    urlInfo96.setResponseDepict("自营零星用工成本集合,总条数");
    urlInfo96.setTransation(true);
    urlInfo96.setRestClass("zyLxygCbFetch");
    webCommands.put(urlInfo96.getUrl(),urlInfo96);
    codeOpMap.put(urlInfo96.getMsgCode(),urlInfo96);

    SimpleWebCommandOperationInfo urlInfo97= new SimpleWebCommandOperationInfo();
    urlInfo97.setMsgCode(50402);
    urlInfo97.setUrl("/cbhs/daysCb/zyLxygCbUpdate");
    urlInfo97.setOpCode("0");
    urlInfo97.setWorkClass("");
    urlInfo97.setMsgReaquest("com.server.pojo.bean.CbhsDaysZyLxygCb");
    urlInfo97.setReaquestDepict("自营零星用工");
    urlInfo97.setMsgResponse("com.server.pojo.bean.CbhsDaysZyLxygCb");
    urlInfo97.setResponseDepict("自营零星用工成本");
    urlInfo97.setTransation(true);
    urlInfo97.setRestClass("zyLxygCbUpdate");
    webCommands.put(urlInfo97.getUrl(),urlInfo97);
    codeOpMap.put(urlInfo97.getMsgCode(),urlInfo97);

    SimpleWebCommandOperationInfo urlInfo98= new SimpleWebCommandOperationInfo();
    urlInfo98.setMsgCode(50403);
    urlInfo98.setUrl("/cbhs/daysCb/zyLxygCbDel");
    urlInfo98.setOpCode("0");
    urlInfo98.setWorkClass("");
    urlInfo98.setMsgReaquest("com.server.pojo.url.daysCb.RequestZyLxygCbDel");
    urlInfo98.setReaquestDepict("自营零星用工主键集合");
    urlInfo98.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo98.setResponseDepict("响应状态码");
    urlInfo98.setTransation(false);
    urlInfo98.setRestClass("zyLxygCbDel");
    webCommands.put(urlInfo98.getUrl(),urlInfo98);
    codeOpMap.put(urlInfo98.getMsgCode(),urlInfo98);

    SimpleWebCommandOperationInfo urlInfo99= new SimpleWebCommandOperationInfo();
    urlInfo99.setMsgCode(50404);
    urlInfo99.setUrl("/cbhs/daysCb/zyLxygCbAdd");
    urlInfo99.setOpCode("0");
    urlInfo99.setWorkClass("");
    urlInfo99.setMsgReaquest("com.server.pojo.url.daysCb.RequestZyLxygCbAdd");
    urlInfo99.setReaquestDepict("自营零星用工,提交方式(0默认提交 1审核提交)");
    urlInfo99.setMsgResponse("com.server.pojo.bean.CbhsDaysZyLxygCb");
    urlInfo99.setResponseDepict("自营零星用工成本集合");
    urlInfo99.setTransation(true);
    urlInfo99.setRestClass("zyLxygCbAdd");
    webCommands.put(urlInfo99.getUrl(),urlInfo99);
    codeOpMap.put(urlInfo99.getMsgCode(),urlInfo99);

    SimpleWebCommandOperationInfo urlInfo100= new SimpleWebCommandOperationInfo();
    urlInfo100.setMsgCode(50501);
    urlInfo100.setUrl("/cbhs/daysCb/zyJxCbFetch");
    urlInfo100.setOpCode("0");
    urlInfo100.setWorkClass("");
    urlInfo100.setMsgReaquest("com.server.pojo.url.daysCb.RequestZyJxCbFetch");
    urlInfo100.setReaquestDepict("主键,部门ID,工程项目ID,开始日期,结束日期,页码,数量,开始ID,机械设备ID,全局工程量ID");
    urlInfo100.setMsgResponse("com.server.pojo.url.daysCb.ResponseZyJxCbFetch");
    urlInfo100.setResponseDepict("自营机械成本集合,总条数");
    urlInfo100.setTransation(true);
    urlInfo100.setRestClass("zyJxCbFetch");
    webCommands.put(urlInfo100.getUrl(),urlInfo100);
    codeOpMap.put(urlInfo100.getMsgCode(),urlInfo100);

    SimpleWebCommandOperationInfo urlInfo101= new SimpleWebCommandOperationInfo();
    urlInfo101.setMsgCode(50502);
    urlInfo101.setUrl("/cbhs/daysCb/zyJxCbUpdate");
    urlInfo101.setOpCode("0");
    urlInfo101.setWorkClass("");
    urlInfo101.setMsgReaquest("com.server.pojo.bean.CbhsDaysZyJxCb");
    urlInfo101.setReaquestDepict("自营机械成本");
    urlInfo101.setMsgResponse("com.server.pojo.bean.CbhsDaysZyJxCb");
    urlInfo101.setResponseDepict("自营机械成本成本");
    urlInfo101.setTransation(true);
    urlInfo101.setRestClass("zyJxCbUpdate");
    webCommands.put(urlInfo101.getUrl(),urlInfo101);
    codeOpMap.put(urlInfo101.getMsgCode(),urlInfo101);

    SimpleWebCommandOperationInfo urlInfo102= new SimpleWebCommandOperationInfo();
    urlInfo102.setMsgCode(50503);
    urlInfo102.setUrl("/cbhs/daysCb/zyJxCbDel");
    urlInfo102.setOpCode("0");
    urlInfo102.setWorkClass("");
    urlInfo102.setMsgReaquest("com.server.pojo.url.daysCb.RequestZyJxCbDel");
    urlInfo102.setReaquestDepict("自营机械成本主键集合");
    urlInfo102.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo102.setResponseDepict("响应状态码");
    urlInfo102.setTransation(false);
    urlInfo102.setRestClass("zyJxCbDel");
    webCommands.put(urlInfo102.getUrl(),urlInfo102);
    codeOpMap.put(urlInfo102.getMsgCode(),urlInfo102);

    SimpleWebCommandOperationInfo urlInfo103= new SimpleWebCommandOperationInfo();
    urlInfo103.setMsgCode(50504);
    urlInfo103.setUrl("/cbhs/daysCb/zyJxCbAdd");
    urlInfo103.setOpCode("0");
    urlInfo103.setWorkClass("");
    urlInfo103.setMsgReaquest("com.server.pojo.url.daysCb.RequestZyJxCbAdd");
    urlInfo103.setReaquestDepict("自营机械成本,提交方式(0默认提交 1审核提交)");
    urlInfo103.setMsgResponse("com.server.pojo.bean.CbhsDaysZyJxCb");
    urlInfo103.setResponseDepict("自营机械成本集合");
    urlInfo103.setTransation(true);
    urlInfo103.setRestClass("zyJxCbAdd");
    webCommands.put(urlInfo103.getUrl(),urlInfo103);
    codeOpMap.put(urlInfo103.getMsgCode(),urlInfo103);

    SimpleWebCommandOperationInfo urlInfo104= new SimpleWebCommandOperationInfo();
    urlInfo104.setMsgCode(50601);
    urlInfo104.setUrl("/cbhs/daysCb/zyQtCbFetch");
    urlInfo104.setOpCode("0");
    urlInfo104.setWorkClass("");
    urlInfo104.setMsgReaquest("com.server.pojo.url.daysCb.RequestZyQtCbFetch");
    urlInfo104.setReaquestDepict("主键,部门ID,工程项目ID,开始日期,结束日期,页码,数量,开始ID");
    urlInfo104.setMsgResponse("com.server.pojo.url.daysCb.ResponseZyQtCbFetch");
    urlInfo104.setResponseDepict("自营其他成本集合,总条数");
    urlInfo104.setTransation(true);
    urlInfo104.setRestClass("zyQtCbFetch");
    webCommands.put(urlInfo104.getUrl(),urlInfo104);
    codeOpMap.put(urlInfo104.getMsgCode(),urlInfo104);

    SimpleWebCommandOperationInfo urlInfo105= new SimpleWebCommandOperationInfo();
    urlInfo105.setMsgCode(50602);
    urlInfo105.setUrl("/cbhs/daysCb/zyQtCbUpdate");
    urlInfo105.setOpCode("0");
    urlInfo105.setWorkClass("");
    urlInfo105.setMsgReaquest("com.server.pojo.bean.CbhsDaysZyQtCb");
    urlInfo105.setReaquestDepict("自营机械成本");
    urlInfo105.setMsgResponse("com.server.pojo.bean.CbhsDaysZyQtCb");
    urlInfo105.setResponseDepict("自营其他成本成本");
    urlInfo105.setTransation(true);
    urlInfo105.setRestClass("zyQtCbUpdate");
    webCommands.put(urlInfo105.getUrl(),urlInfo105);
    codeOpMap.put(urlInfo105.getMsgCode(),urlInfo105);

    SimpleWebCommandOperationInfo urlInfo106= new SimpleWebCommandOperationInfo();
    urlInfo106.setMsgCode(50603);
    urlInfo106.setUrl("/cbhs/daysCb/zyQtCbDel");
    urlInfo106.setOpCode("0");
    urlInfo106.setWorkClass("");
    urlInfo106.setMsgReaquest("com.server.pojo.url.daysCb.RequestZyQtCbDel");
    urlInfo106.setReaquestDepict("自营机械成本主键集合");
    urlInfo106.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo106.setResponseDepict("响应状态码");
    urlInfo106.setTransation(false);
    urlInfo106.setRestClass("zyQtCbDel");
    webCommands.put(urlInfo106.getUrl(),urlInfo106);
    codeOpMap.put(urlInfo106.getMsgCode(),urlInfo106);

    SimpleWebCommandOperationInfo urlInfo107= new SimpleWebCommandOperationInfo();
    urlInfo107.setMsgCode(50604);
    urlInfo107.setUrl("/cbhs/daysCb/zyQtCbAdd");
    urlInfo107.setOpCode("0");
    urlInfo107.setWorkClass("");
    urlInfo107.setMsgReaquest("com.server.pojo.url.daysCb.RequestZyQtCbAdd");
    urlInfo107.setReaquestDepict("自营机械成本,提交方式(0默认提交 1审核提交)");
    urlInfo107.setMsgResponse("com.server.pojo.bean.CbhsDaysZyQtCb");
    urlInfo107.setResponseDepict("自营其他成本");
    urlInfo107.setTransation(true);
    urlInfo107.setRestClass("zyQtCbAdd");
    webCommands.put(urlInfo107.getUrl(),urlInfo107);
    codeOpMap.put(urlInfo107.getMsgCode(),urlInfo107);

    SimpleWebCommandOperationInfo urlInfo108= new SimpleWebCommandOperationInfo();
    urlInfo108.setMsgCode(50701);
    urlInfo108.setUrl("/cbhs/daysCb/zyCailiaoCbFetch");
    urlInfo108.setOpCode("0");
    urlInfo108.setWorkClass("");
    urlInfo108.setMsgReaquest("com.server.pojo.url.daysCb.RequestZyCailiaoCbFetch");
    urlInfo108.setReaquestDepict("主键,部门ID,工程量ID,工程项目ID,开始日期,结束日期,页码,数量,开始ID");
    urlInfo108.setMsgResponse("com.server.pojo.url.daysCb.ResponseZyCailiaoCbFetch");
    urlInfo108.setResponseDepict("自营材料成本集合,总条数");
    urlInfo108.setTransation(true);
    urlInfo108.setRestClass("zyCailiaoCbFetch");
    webCommands.put(urlInfo108.getUrl(),urlInfo108);
    codeOpMap.put(urlInfo108.getMsgCode(),urlInfo108);

    SimpleWebCommandOperationInfo urlInfo109= new SimpleWebCommandOperationInfo();
    urlInfo109.setMsgCode(50702);
    urlInfo109.setUrl("/cbhs/daysCb/zyCailiaoCbUpdate");
    urlInfo109.setOpCode("0");
    urlInfo109.setWorkClass("");
    urlInfo109.setMsgReaquest("com.server.pojo.bean.CbhsDaysZyCailiaoCb");
    urlInfo109.setReaquestDepict("自营材料成本");
    urlInfo109.setMsgResponse("com.server.pojo.bean.CbhsDaysZyCailiaoCb");
    urlInfo109.setResponseDepict("自营材料成本");
    urlInfo109.setTransation(true);
    urlInfo109.setRestClass("zyCailiaoCbUpdate");
    webCommands.put(urlInfo109.getUrl(),urlInfo109);
    codeOpMap.put(urlInfo109.getMsgCode(),urlInfo109);

    SimpleWebCommandOperationInfo urlInfo110= new SimpleWebCommandOperationInfo();
    urlInfo110.setMsgCode(50703);
    urlInfo110.setUrl("/cbhs/daysCb/zyCailiaoCbDel");
    urlInfo110.setOpCode("0");
    urlInfo110.setWorkClass("");
    urlInfo110.setMsgReaquest("com.server.pojo.url.daysCb.RequestZyCailiaoCbDel");
    urlInfo110.setReaquestDepict("自营材料成本主键集合");
    urlInfo110.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo110.setResponseDepict("响应状态码");
    urlInfo110.setTransation(false);
    urlInfo110.setRestClass("zyCailiaoCbDel");
    webCommands.put(urlInfo110.getUrl(),urlInfo110);
    codeOpMap.put(urlInfo110.getMsgCode(),urlInfo110);

    SimpleWebCommandOperationInfo urlInfo111= new SimpleWebCommandOperationInfo();
    urlInfo111.setMsgCode(50704);
    urlInfo111.setUrl("/cbhs/daysCb/zyCailiaoCbAdd");
    urlInfo111.setOpCode("0");
    urlInfo111.setWorkClass("");
    urlInfo111.setMsgReaquest("com.server.pojo.url.daysCb.RequestZyCailiaoCbAdd");
    urlInfo111.setReaquestDepict("自营材料成本集合 可批量添加,提交方式(0默认提交 1审核提交)");
    urlInfo111.setMsgResponse("com.server.pojo.url.daysCb.ResponseZyCailiaoCbAdd");
    urlInfo111.setResponseDepict("自营材料成本集合");
    urlInfo111.setTransation(true);
    urlInfo111.setRestClass("zyCailiaoCbAdd");
    webCommands.put(urlInfo111.getUrl(),urlInfo111);
    codeOpMap.put(urlInfo111.getMsgCode(),urlInfo111);

    SimpleWebCommandOperationInfo urlInfo112= new SimpleWebCommandOperationInfo();
    urlInfo112.setMsgCode(50801);
    urlInfo112.setUrl("/cbhs/daysCb/fbGclTjCbFetch");
    urlInfo112.setOpCode("0");
    urlInfo112.setWorkClass("");
    urlInfo112.setMsgReaquest("com.server.pojo.url.daysCb.RequestFbGclTjCbFetch");
    urlInfo112.setReaquestDepict("主键,部门ID,工程量ID,工程项目ID,开始日期,结束日期,页码,数量,开始ID,类型(1:大项|2:有单价的项),审核状态 0所有 1 审核通过的,合同ID,合同名称,分包商ID,分包商名称,分包工程名称");
    urlInfo112.setMsgResponse("com.server.pojo.url.daysCb.ResponseFbGclTjCbFetch");
    urlInfo112.setResponseDepict("分包工程量集合,总条数");
    urlInfo112.setTransation(true);
    urlInfo112.setRestClass("fbGclTjCbFetch");
    webCommands.put(urlInfo112.getUrl(),urlInfo112);
    codeOpMap.put(urlInfo112.getMsgCode(),urlInfo112);

    SimpleWebCommandOperationInfo urlInfo113= new SimpleWebCommandOperationInfo();
    urlInfo113.setMsgCode(50802);
    urlInfo113.setUrl("/cbhs/daysCb/fbGclTjCbUpdate");
    urlInfo113.setOpCode("0");
    urlInfo113.setWorkClass("");
    urlInfo113.setMsgReaquest("com.server.pojo.bean.CbhsDaysFbGclTj");
    urlInfo113.setReaquestDepict("分包工程");
    urlInfo113.setMsgResponse("com.server.pojo.bean.CbhsDaysFbGclTj");
    urlInfo113.setResponseDepict("分包工程量集合,总条数");
    urlInfo113.setTransation(true);
    urlInfo113.setRestClass("fbGclTjCbUpdate");
    webCommands.put(urlInfo113.getUrl(),urlInfo113);
    codeOpMap.put(urlInfo113.getMsgCode(),urlInfo113);

    SimpleWebCommandOperationInfo urlInfo114= new SimpleWebCommandOperationInfo();
    urlInfo114.setMsgCode(50803);
    urlInfo114.setUrl("/cbhs/daysCb/fbGclTjCbDel");
    urlInfo114.setOpCode("0");
    urlInfo114.setWorkClass("");
    urlInfo114.setMsgReaquest("com.server.pojo.url.daysCb.RequestFbGclTjCbDel");
    urlInfo114.setReaquestDepict("分包工程主键集合");
    urlInfo114.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo114.setResponseDepict("响应状态码");
    urlInfo114.setTransation(false);
    urlInfo114.setRestClass("fbGclTjCbDel");
    webCommands.put(urlInfo114.getUrl(),urlInfo114);
    codeOpMap.put(urlInfo114.getMsgCode(),urlInfo114);

    SimpleWebCommandOperationInfo urlInfo115= new SimpleWebCommandOperationInfo();
    urlInfo115.setMsgCode(50804);
    urlInfo115.setUrl("/cbhs/daysCb/fbGclTjCbAdd");
    urlInfo115.setOpCode("0");
    urlInfo115.setWorkClass("");
    urlInfo115.setMsgReaquest("com.server.pojo.url.daysCb.RequestFbGclTjCbAdd");
    urlInfo115.setReaquestDepict("分包工程,提交方式(0默认提交 1审核提交)");
    urlInfo115.setMsgResponse("com.server.pojo.bean.CbhsDaysFbGclTj");
    urlInfo115.setResponseDepict("分包工程量集合,总条数");
    urlInfo115.setTransation(true);
    urlInfo115.setRestClass("fbGclTjCbAdd");
    webCommands.put(urlInfo115.getUrl(),urlInfo115);
    codeOpMap.put(urlInfo115.getMsgCode(),urlInfo115);

    SimpleWebCommandOperationInfo urlInfo116= new SimpleWebCommandOperationInfo();
    urlInfo116.setMsgCode(50901);
    urlInfo116.setUrl("/cbhs/daysCb/fbLjxmCbFetch");
    urlInfo116.setOpCode("0");
    urlInfo116.setWorkClass("");
    urlInfo116.setMsgReaquest("com.server.pojo.url.daysCb.RequestFbLjxmCbFetch");
    urlInfo116.setReaquestDepict("主键,部门ID,工程项目ID,月份时间戳,页码,数量,开始ID");
    urlInfo116.setMsgResponse("com.server.pojo.url.daysCb.ResponseFbLjxmCbFetch");
    urlInfo116.setResponseDepict("分包临建项目集合,总条数");
    urlInfo116.setTransation(true);
    urlInfo116.setRestClass("fbLjxmCbFetch");
    webCommands.put(urlInfo116.getUrl(),urlInfo116);
    codeOpMap.put(urlInfo116.getMsgCode(),urlInfo116);

    SimpleWebCommandOperationInfo urlInfo117= new SimpleWebCommandOperationInfo();
    urlInfo117.setMsgCode(50902);
    urlInfo117.setUrl("/cbhs/daysCb/fbLjxmCbUpdate");
    urlInfo117.setOpCode("0");
    urlInfo117.setWorkClass("");
    urlInfo117.setMsgReaquest("com.server.pojo.bean.CbhsDaysFbLjxmCb");
    urlInfo117.setReaquestDepict("分包临建项目");
    urlInfo117.setMsgResponse("com.server.pojo.bean.CbhsDaysFbLjxmCb");
    urlInfo117.setResponseDepict("分包临建项目");
    urlInfo117.setTransation(true);
    urlInfo117.setRestClass("fbLjxmCbUpdate");
    webCommands.put(urlInfo117.getUrl(),urlInfo117);
    codeOpMap.put(urlInfo117.getMsgCode(),urlInfo117);

    SimpleWebCommandOperationInfo urlInfo118= new SimpleWebCommandOperationInfo();
    urlInfo118.setMsgCode(50903);
    urlInfo118.setUrl("/cbhs/daysCb/fbLjxmCbDel");
    urlInfo118.setOpCode("0");
    urlInfo118.setWorkClass("");
    urlInfo118.setMsgReaquest("com.server.pojo.url.daysCb.RequestFbLjxmCbDel");
    urlInfo118.setReaquestDepict("分包临建项目主键集合");
    urlInfo118.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo118.setResponseDepict("响应状态码");
    urlInfo118.setTransation(false);
    urlInfo118.setRestClass("fbLjxmCbDel");
    webCommands.put(urlInfo118.getUrl(),urlInfo118);
    codeOpMap.put(urlInfo118.getMsgCode(),urlInfo118);

    SimpleWebCommandOperationInfo urlInfo119= new SimpleWebCommandOperationInfo();
    urlInfo119.setMsgCode(50904);
    urlInfo119.setUrl("/cbhs/daysCb/fbLjxmCbAddCount");
    urlInfo119.setOpCode("0");
    urlInfo119.setWorkClass("");
    urlInfo119.setMsgReaquest("com.server.pojo.url.daysCb.RequestFbLjxmCbAddCount");
    urlInfo119.setReaquestDepict("分包临建项目,提交方式(0默认提交 1审核提交)");
    urlInfo119.setMsgResponse("com.server.pojo.bean.CbhsDaysFbLjxmCb");
    urlInfo119.setResponseDepict("分包临建项目");
    urlInfo119.setTransation(true);
    urlInfo119.setRestClass("fbLjxmCbAddCount");
    webCommands.put(urlInfo119.getUrl(),urlInfo119);
    codeOpMap.put(urlInfo119.getMsgCode(),urlInfo119);

    SimpleWebCommandOperationInfo urlInfo120= new SimpleWebCommandOperationInfo();
    urlInfo120.setMsgCode(50905);
    urlInfo120.setUrl("/cbhs/daysCb/fbLjxmCbAddJg");
    urlInfo120.setOpCode("0");
    urlInfo120.setWorkClass("");
    urlInfo120.setMsgReaquest("com.server.pojo.url.daysCb.RequestFbLjxmCbAddJg");
    urlInfo120.setReaquestDepict("数量统计ID,总金额,单价,提交方式(0默认提交 1审核提交)");
    urlInfo120.setMsgResponse("com.server.pojo.bean.CbhsDaysFbLjxmCb");
    urlInfo120.setResponseDepict("分包临建项目");
    urlInfo120.setTransation(true);
    urlInfo120.setRestClass("fbLjxmCbAddJg");
    webCommands.put(urlInfo120.getUrl(),urlInfo120);
    codeOpMap.put(urlInfo120.getMsgCode(),urlInfo120);

    SimpleWebCommandOperationInfo urlInfo121= new SimpleWebCommandOperationInfo();
    urlInfo121.setMsgCode(50906);
    urlInfo121.setUrl("/cbhs/daysCb/fbLjxmCbUpdateJg");
    urlInfo121.setOpCode("0");
    urlInfo121.setWorkClass("");
    urlInfo121.setMsgReaquest("com.server.pojo.url.daysCb.RequestFbLjxmCbUpdateJg");
    urlInfo121.setReaquestDepict("数量统计ID,总金额,单价");
    urlInfo121.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo121.setResponseDepict("分包临建项目");
    urlInfo121.setTransation(true);
    urlInfo121.setRestClass("fbLjxmCbUpdateJg");
    webCommands.put(urlInfo121.getUrl(),urlInfo121);
    codeOpMap.put(urlInfo121.getMsgCode(),urlInfo121);

    SimpleWebCommandOperationInfo urlInfo122= new SimpleWebCommandOperationInfo();
    urlInfo122.setMsgCode(51001);
    urlInfo122.setUrl("/cbhs/daysCb/fbJgUpdate");
    urlInfo122.setOpCode("0");
    urlInfo122.setWorkClass("");
    urlInfo122.setMsgReaquest("com.server.pojo.url.daysCb.RequestFbJgUpdate");
    urlInfo122.setReaquestDepict("分包工程ID,分包价格");
    urlInfo122.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo122.setResponseDepict("响应状态码");
    urlInfo122.setTransation(true);
    urlInfo122.setRestClass("fbJgUpdate");
    webCommands.put(urlInfo122.getUrl(),urlInfo122);
    codeOpMap.put(urlInfo122.getMsgCode(),urlInfo122);

    SimpleWebCommandOperationInfo urlInfo123= new SimpleWebCommandOperationInfo();
    urlInfo123.setMsgCode(51002);
    urlInfo123.setUrl("/cbhs/daysCb/fbJgAdd");
    urlInfo123.setOpCode("0");
    urlInfo123.setWorkClass("");
    urlInfo123.setMsgReaquest("com.server.pojo.url.daysCb.RequestFbJgAdd");
    urlInfo123.setReaquestDepict("分包工程ID,分包总金额,分包单价,提交方式(0默认提交 1审核提交)");
    urlInfo123.setMsgResponse("com.server.pojo.bean.CbhsDaysFbGclTj");
    urlInfo123.setResponseDepict("响应状态码");
    urlInfo123.setTransation(true);
    urlInfo123.setRestClass("fbJgAdd");
    webCommands.put(urlInfo123.getUrl(),urlInfo123);
    codeOpMap.put(urlInfo123.getMsgCode(),urlInfo123);

    SimpleWebCommandOperationInfo urlInfo124= new SimpleWebCommandOperationInfo();
    urlInfo124.setMsgCode(60101);
    urlInfo124.setUrl("/cbhs/daysSr/gcsrFetch");
    urlInfo124.setOpCode("0");
    urlInfo124.setWorkClass("");
    urlInfo124.setMsgReaquest("com.server.pojo.url.daysSr.RequestGcsrFetch");
    urlInfo124.setReaquestDepict("主键,部门ID,工程项目ID,工程量ID,开始日期,结束日期,页码,数量,开始ID");
    urlInfo124.setMsgResponse("com.server.pojo.url.daysSr.ResponseGcsrFetch");
    urlInfo124.setResponseDepict("工程收入集合,总条数");
    urlInfo124.setTransation(true);
    urlInfo124.setRestClass("gcsrFetch");
    webCommands.put(urlInfo124.getUrl(),urlInfo124);
    codeOpMap.put(urlInfo124.getMsgCode(),urlInfo124);

    SimpleWebCommandOperationInfo urlInfo125= new SimpleWebCommandOperationInfo();
    urlInfo125.setMsgCode(60102);
    urlInfo125.setUrl("/cbhs/daysSr/gcsrUpdate");
    urlInfo125.setOpCode("0");
    urlInfo125.setWorkClass("");
    urlInfo125.setMsgReaquest("com.server.pojo.bean.CbhsDaysGclSr");
    urlInfo125.setReaquestDepict("工程收入");
    urlInfo125.setMsgResponse("com.server.pojo.bean.CbhsDaysGclSr");
    urlInfo125.setResponseDepict("工程收入");
    urlInfo125.setTransation(true);
    urlInfo125.setRestClass("gcsrUpdate");
    webCommands.put(urlInfo125.getUrl(),urlInfo125);
    codeOpMap.put(urlInfo125.getMsgCode(),urlInfo125);

    SimpleWebCommandOperationInfo urlInfo126= new SimpleWebCommandOperationInfo();
    urlInfo126.setMsgCode(60103);
    urlInfo126.setUrl("/cbhs/daysSr/gcsrDel");
    urlInfo126.setOpCode("0");
    urlInfo126.setWorkClass("");
    urlInfo126.setMsgReaquest("com.server.pojo.url.daysSr.RequestGcsrDel");
    urlInfo126.setReaquestDepict("工程收入主键集合");
    urlInfo126.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo126.setResponseDepict("响应状态码");
    urlInfo126.setTransation(false);
    urlInfo126.setRestClass("gcsrDel");
    webCommands.put(urlInfo126.getUrl(),urlInfo126);
    codeOpMap.put(urlInfo126.getMsgCode(),urlInfo126);

    SimpleWebCommandOperationInfo urlInfo127= new SimpleWebCommandOperationInfo();
    urlInfo127.setMsgCode(60104);
    urlInfo127.setUrl("/cbhs/daysSr/gcsrAdd");
    urlInfo127.setOpCode("0");
    urlInfo127.setWorkClass("");
    urlInfo127.setMsgReaquest("com.server.pojo.url.daysSr.RequestGcsrAdd");
    urlInfo127.setReaquestDepict("工程收入");
    urlInfo127.setMsgResponse("com.server.pojo.url.daysSr.ResponseGcsrAdd");
    urlInfo127.setResponseDepict("工程收入");
    urlInfo127.setTransation(true);
    urlInfo127.setRestClass("gcsrAdd");
    webCommands.put(urlInfo127.getUrl(),urlInfo127);
    codeOpMap.put(urlInfo127.getMsgCode(),urlInfo127);

    SimpleWebCommandOperationInfo urlInfo128= new SimpleWebCommandOperationInfo();
    urlInfo128.setMsgCode(60201);
    urlInfo128.setUrl("/cbhs/daysSr/newsrFetch");
    urlInfo128.setOpCode("0");
    urlInfo128.setWorkClass("");
    urlInfo128.setMsgReaquest("com.server.pojo.url.daysSr.RequestNewsrFetch");
    urlInfo128.setReaquestDepict("主键,部门ID,工程项目ID,开始日期,结束日期,页码,数量,开始ID");
    urlInfo128.setMsgResponse("com.server.pojo.url.daysSr.ResponseNewsrFetch");
    urlInfo128.setResponseDepict("新增收入集合,总条数");
    urlInfo128.setTransation(true);
    urlInfo128.setRestClass("newsrFetch");
    webCommands.put(urlInfo128.getUrl(),urlInfo128);
    codeOpMap.put(urlInfo128.getMsgCode(),urlInfo128);

    SimpleWebCommandOperationInfo urlInfo129= new SimpleWebCommandOperationInfo();
    urlInfo129.setMsgCode(60202);
    urlInfo129.setUrl("/cbhs/daysSr/newsrUpdate");
    urlInfo129.setOpCode("0");
    urlInfo129.setWorkClass("");
    urlInfo129.setMsgReaquest("com.server.pojo.bean.CbhsDaysQtSr");
    urlInfo129.setReaquestDepict("新增收入");
    urlInfo129.setMsgResponse("com.server.pojo.bean.CbhsDaysQtSr");
    urlInfo129.setResponseDepict("新增收入");
    urlInfo129.setTransation(true);
    urlInfo129.setRestClass("newsrUpdate");
    webCommands.put(urlInfo129.getUrl(),urlInfo129);
    codeOpMap.put(urlInfo129.getMsgCode(),urlInfo129);

    SimpleWebCommandOperationInfo urlInfo130= new SimpleWebCommandOperationInfo();
    urlInfo130.setMsgCode(60203);
    urlInfo130.setUrl("/cbhs/daysSr/newsrDel");
    urlInfo130.setOpCode("0");
    urlInfo130.setWorkClass("");
    urlInfo130.setMsgReaquest("com.server.pojo.url.daysSr.RequestNewsrDel");
    urlInfo130.setReaquestDepict("新增收入主键集合");
    urlInfo130.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo130.setResponseDepict("响应状态码");
    urlInfo130.setTransation(false);
    urlInfo130.setRestClass("newsrDel");
    webCommands.put(urlInfo130.getUrl(),urlInfo130);
    codeOpMap.put(urlInfo130.getMsgCode(),urlInfo130);

    SimpleWebCommandOperationInfo urlInfo131= new SimpleWebCommandOperationInfo();
    urlInfo131.setMsgCode(60204);
    urlInfo131.setUrl("/cbhs/daysSr/newsrAddCount");
    urlInfo131.setOpCode("0");
    urlInfo131.setWorkClass("");
    urlInfo131.setMsgReaquest("com.server.pojo.bean.CbhsDaysQtSr");
    urlInfo131.setReaquestDepict("新增收入");
    urlInfo131.setMsgResponse("com.server.pojo.bean.CbhsDaysQtSr");
    urlInfo131.setResponseDepict("新增收入");
    urlInfo131.setTransation(true);
    urlInfo131.setRestClass("newsrAddCount");
    webCommands.put(urlInfo131.getUrl(),urlInfo131);
    codeOpMap.put(urlInfo131.getMsgCode(),urlInfo131);

    SimpleWebCommandOperationInfo urlInfo132= new SimpleWebCommandOperationInfo();
    urlInfo132.setMsgCode(60205);
    urlInfo132.setUrl("/cbhs/daysSr/newsrAddPrice");
    urlInfo132.setOpCode("0");
    urlInfo132.setWorkClass("");
    urlInfo132.setMsgReaquest("com.server.pojo.url.daysSr.RequestNewsrAddPrice");
    urlInfo132.setReaquestDepict("数量收入ID,总金额,单价");
    urlInfo132.setMsgResponse("com.server.pojo.bean.CbhsDaysQtSr");
    urlInfo132.setResponseDepict("新增收入");
    urlInfo132.setTransation(true);
    urlInfo132.setRestClass("newsrAddPrice");
    webCommands.put(urlInfo132.getUrl(),urlInfo132);
    codeOpMap.put(urlInfo132.getMsgCode(),urlInfo132);

    SimpleWebCommandOperationInfo urlInfo133= new SimpleWebCommandOperationInfo();
    urlInfo133.setMsgCode(30101);
    urlInfo133.setUrl("/cbhs/globalYs/globalGclYsFetch");
    urlInfo133.setOpCode("0");
    urlInfo133.setWorkClass("");
    urlInfo133.setMsgReaquest("com.server.pojo.url.globalYs.RequestGlobalGclYsFetch");
    urlInfo133.setReaquestDepict("主键,编号,名称,页码,数量,开始编号,工程项目ID,类型(1:无单价的项|2:有单价的项|3大项)");
    urlInfo133.setMsgResponse("com.server.pojo.url.globalYs.ResponseGlobalGclYsFetch");
    urlInfo133.setResponseDepict("工程量集合,总条数,总费用");
    urlInfo133.setTransation(true);
    urlInfo133.setRestClass("globalGclYsFetch");
    webCommands.put(urlInfo133.getUrl(),urlInfo133);
    codeOpMap.put(urlInfo133.getMsgCode(),urlInfo133);

    SimpleWebCommandOperationInfo urlInfo134= new SimpleWebCommandOperationInfo();
    urlInfo134.setMsgCode(30102);
    urlInfo134.setUrl("/cbhs/globalYs/globalGclYsUpdate");
    urlInfo134.setOpCode("0");
    urlInfo134.setWorkClass("");
    urlInfo134.setMsgReaquest("com.server.pojo.bean.CbhsGclQdYs");
    urlInfo134.setReaquestDepict("工程量");
    urlInfo134.setMsgResponse("com.server.pojo.bean.CbhsGclQdYs");
    urlInfo134.setResponseDepict("工程量");
    urlInfo134.setTransation(true);
    urlInfo134.setRestClass("globalGclYsUpdate");
    webCommands.put(urlInfo134.getUrl(),urlInfo134);
    codeOpMap.put(urlInfo134.getMsgCode(),urlInfo134);

    SimpleWebCommandOperationInfo urlInfo135= new SimpleWebCommandOperationInfo();
    urlInfo135.setMsgCode(30103);
    urlInfo135.setUrl("/cbhs/globalYs/globalGclYsDel");
    urlInfo135.setOpCode("0");
    urlInfo135.setWorkClass("");
    urlInfo135.setMsgReaquest("com.server.pojo.url.globalYs.RequestGlobalGclYsDel");
    urlInfo135.setReaquestDepict("工程量主键集合");
    urlInfo135.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo135.setResponseDepict("标识");
    urlInfo135.setTransation(false);
    urlInfo135.setRestClass("globalGclYsDel");
    webCommands.put(urlInfo135.getUrl(),urlInfo135);
    codeOpMap.put(urlInfo135.getMsgCode(),urlInfo135);

    SimpleWebCommandOperationInfo urlInfo136= new SimpleWebCommandOperationInfo();
    urlInfo136.setMsgCode(30104);
    urlInfo136.setUrl("/cbhs/globalYs/globalGclYsImport");
    urlInfo136.setOpCode("0");
    urlInfo136.setWorkClass("");
    urlInfo136.setMsgReaquest("com.server.pojo.bean.MultipartFile");
    urlInfo136.setReaquestDepict("上传的文件,所属的项目ID");
    urlInfo136.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo136.setResponseDepict("标识");
    urlInfo136.setTransation(true);
    urlInfo136.setRestClass("globalGclYsImport");
    webCommands.put(urlInfo136.getUrl(),urlInfo136);
    codeOpMap.put(urlInfo136.getMsgCode(),urlInfo136);

    SimpleWebCommandOperationInfo urlInfo137= new SimpleWebCommandOperationInfo();
    urlInfo137.setMsgCode(30105);
    urlInfo137.setUrl("/cbhs/globalYs/globalGclYsAdd");
    urlInfo137.setOpCode("0");
    urlInfo137.setWorkClass("");
    urlInfo137.setMsgReaquest("com.server.pojo.bean.CbhsGclQdYs");
    urlInfo137.setReaquestDepict("工程量");
    urlInfo137.setMsgResponse("com.server.pojo.bean.CbhsGclQdYs");
    urlInfo137.setResponseDepict("工程量");
    urlInfo137.setTransation(true);
    urlInfo137.setRestClass("globalGclYsAdd");
    webCommands.put(urlInfo137.getUrl(),urlInfo137);
    codeOpMap.put(urlInfo137.getMsgCode(),urlInfo137);

    SimpleWebCommandOperationInfo urlInfo138= new SimpleWebCommandOperationInfo();
    urlInfo138.setMsgCode(30201);
    urlInfo138.setUrl("/cbhs/globalYs/globalRcjzhlYsFetch");
    urlInfo138.setOpCode("0");
    urlInfo138.setWorkClass("");
    urlInfo138.setMsgReaquest("com.server.pojo.url.globalYs.RequestGlobalRcjzhlYsFetch");
    urlInfo138.setReaquestDepict("ID,编号,名称,页码,数量,开始编号,工程项目ID");
    urlInfo138.setMsgResponse("com.server.pojo.url.globalYs.ResponseGlobalRcjzhlYsFetch");
    urlInfo138.setResponseDepict("总耗量预算集合,总条数,总费用");
    urlInfo138.setTransation(true);
    urlInfo138.setRestClass("globalRcjzhlYsFetch");
    webCommands.put(urlInfo138.getUrl(),urlInfo138);
    codeOpMap.put(urlInfo138.getMsgCode(),urlInfo138);

    SimpleWebCommandOperationInfo urlInfo139= new SimpleWebCommandOperationInfo();
    urlInfo139.setMsgCode(30202);
    urlInfo139.setUrl("/cbhs/globalYs/globalRcjzhlYsUpdate");
    urlInfo139.setOpCode("0");
    urlInfo139.setWorkClass("");
    urlInfo139.setMsgReaquest("com.server.pojo.bean.CbhsGlobalRcjzhlYs");
    urlInfo139.setReaquestDepict("总耗量预算");
    urlInfo139.setMsgResponse("com.server.pojo.bean.CbhsGlobalRcjzhlYs");
    urlInfo139.setResponseDepict("总耗量预算");
    urlInfo139.setTransation(true);
    urlInfo139.setRestClass("globalRcjzhlYsUpdate");
    webCommands.put(urlInfo139.getUrl(),urlInfo139);
    codeOpMap.put(urlInfo139.getMsgCode(),urlInfo139);

    SimpleWebCommandOperationInfo urlInfo140= new SimpleWebCommandOperationInfo();
    urlInfo140.setMsgCode(30203);
    urlInfo140.setUrl("/cbhs/globalYs/globalRcjzhlYsDel");
    urlInfo140.setOpCode("0");
    urlInfo140.setWorkClass("");
    urlInfo140.setMsgReaquest("com.server.pojo.url.globalYs.RequestGlobalRcjzhlYsDel");
    urlInfo140.setReaquestDepict("总耗量预算主键集合");
    urlInfo140.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo140.setResponseDepict("响应状态码");
    urlInfo140.setTransation(false);
    urlInfo140.setRestClass("globalRcjzhlYsDel");
    webCommands.put(urlInfo140.getUrl(),urlInfo140);
    codeOpMap.put(urlInfo140.getMsgCode(),urlInfo140);

    SimpleWebCommandOperationInfo urlInfo141= new SimpleWebCommandOperationInfo();
    urlInfo141.setMsgCode(30204);
    urlInfo141.setUrl("/cbhs/globalYs/globalRcjzhlYsImport");
    urlInfo141.setOpCode("0");
    urlInfo141.setWorkClass("");
    urlInfo141.setMsgReaquest("com.server.pojo.bean.MultipartFile");
    urlInfo141.setReaquestDepict("上传的文件");
    urlInfo141.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo141.setResponseDepict("响应状态码");
    urlInfo141.setTransation(true);
    urlInfo141.setRestClass("globalRcjzhlYsImport");
    webCommands.put(urlInfo141.getUrl(),urlInfo141);
    codeOpMap.put(urlInfo141.getMsgCode(),urlInfo141);

    SimpleWebCommandOperationInfo urlInfo142= new SimpleWebCommandOperationInfo();
    urlInfo142.setMsgCode(30205);
    urlInfo142.setUrl("/cbhs/globalYs/globalRcjzhlYsAdd");
    urlInfo142.setOpCode("0");
    urlInfo142.setWorkClass("");
    urlInfo142.setMsgReaquest("com.server.pojo.bean.CbhsGlobalRcjzhlYs");
    urlInfo142.setReaquestDepict("总耗量预算");
    urlInfo142.setMsgResponse("com.server.pojo.bean.CbhsGlobalRcjzhlYs");
    urlInfo142.setResponseDepict("总耗量预算");
    urlInfo142.setTransation(true);
    urlInfo142.setRestClass("globalRcjzhlYsAdd");
    webCommands.put(urlInfo142.getUrl(),urlInfo142);
    codeOpMap.put(urlInfo142.getMsgCode(),urlInfo142);

    SimpleWebCommandOperationInfo urlInfo143= new SimpleWebCommandOperationInfo();
    urlInfo143.setMsgCode(30301);
    urlInfo143.setUrl("/cbhs/globalYs/globalFyzYsFetch");
    urlInfo143.setOpCode("0");
    urlInfo143.setWorkClass("");
    urlInfo143.setMsgReaquest("com.server.pojo.url.globalYs.RequestGlobalFyzYsFetch");
    urlInfo143.setReaquestDepict("ID,编号,名称,页码,数量,开始编号,工程项目ID");
    urlInfo143.setMsgResponse("com.server.pojo.url.globalYs.ResponseGlobalFyzYsFetch");
    urlInfo143.setResponseDepict("费用总预算集合,总条数,总费用");
    urlInfo143.setTransation(true);
    urlInfo143.setRestClass("globalFyzYsFetch");
    webCommands.put(urlInfo143.getUrl(),urlInfo143);
    codeOpMap.put(urlInfo143.getMsgCode(),urlInfo143);

    SimpleWebCommandOperationInfo urlInfo144= new SimpleWebCommandOperationInfo();
    urlInfo144.setMsgCode(30302);
    urlInfo144.setUrl("/cbhs/globalYs/globalFyzYsUpdate");
    urlInfo144.setOpCode("0");
    urlInfo144.setWorkClass("");
    urlInfo144.setMsgReaquest("com.server.pojo.bean.CbhsGlobalFyzYs");
    urlInfo144.setReaquestDepict("费用总预算");
    urlInfo144.setMsgResponse("com.server.pojo.bean.CbhsGlobalFyzYs");
    urlInfo144.setResponseDepict("费用总预算");
    urlInfo144.setTransation(true);
    urlInfo144.setRestClass("globalFyzYsUpdate");
    webCommands.put(urlInfo144.getUrl(),urlInfo144);
    codeOpMap.put(urlInfo144.getMsgCode(),urlInfo144);

    SimpleWebCommandOperationInfo urlInfo145= new SimpleWebCommandOperationInfo();
    urlInfo145.setMsgCode(30303);
    urlInfo145.setUrl("/cbhs/globalYs/globalFyzYsDel");
    urlInfo145.setOpCode("0");
    urlInfo145.setWorkClass("");
    urlInfo145.setMsgReaquest("com.server.pojo.url.globalYs.RequestGlobalFyzYsDel");
    urlInfo145.setReaquestDepict("费用总预算主键集合");
    urlInfo145.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo145.setResponseDepict("响应状态码");
    urlInfo145.setTransation(false);
    urlInfo145.setRestClass("globalFyzYsDel");
    webCommands.put(urlInfo145.getUrl(),urlInfo145);
    codeOpMap.put(urlInfo145.getMsgCode(),urlInfo145);

    SimpleWebCommandOperationInfo urlInfo146= new SimpleWebCommandOperationInfo();
    urlInfo146.setMsgCode(30304);
    urlInfo146.setUrl("/cbhs/globalYs/globalFyzYsImport");
    urlInfo146.setOpCode("0");
    urlInfo146.setWorkClass("");
    urlInfo146.setMsgReaquest("com.server.pojo.bean.MultipartFile");
    urlInfo146.setReaquestDepict("上传的文件");
    urlInfo146.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo146.setResponseDepict("响应状态码");
    urlInfo146.setTransation(true);
    urlInfo146.setRestClass("globalFyzYsImport");
    webCommands.put(urlInfo146.getUrl(),urlInfo146);
    codeOpMap.put(urlInfo146.getMsgCode(),urlInfo146);

    SimpleWebCommandOperationInfo urlInfo147= new SimpleWebCommandOperationInfo();
    urlInfo147.setMsgCode(30305);
    urlInfo147.setUrl("/cbhs/globalYs/globalFyzYsAdd");
    urlInfo147.setOpCode("0");
    urlInfo147.setWorkClass("");
    urlInfo147.setMsgReaquest("com.server.pojo.bean.CbhsGlobalFyzYs");
    urlInfo147.setReaquestDepict("费用总预算");
    urlInfo147.setMsgResponse("com.server.pojo.bean.CbhsGlobalFyzYs");
    urlInfo147.setResponseDepict("费用总预算");
    urlInfo147.setTransation(true);
    urlInfo147.setRestClass("globalFyzYsAdd");
    webCommands.put(urlInfo147.getUrl(),urlInfo147);
    codeOpMap.put(urlInfo147.getMsgCode(),urlInfo147);

    SimpleWebCommandOperationInfo urlInfo148= new SimpleWebCommandOperationInfo();
    urlInfo148.setMsgCode(40101);
    urlInfo148.setUrl("/cbhs/monthMbYs/jjcbYsFetch");
    urlInfo148.setOpCode("0");
    urlInfo148.setWorkClass("");
    urlInfo148.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestJjcbYsFetch");
    urlInfo148.setReaquestDepict("主键,部门ID,工程项目ID,月份时间戳,页码,数量,开始ID");
    urlInfo148.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseJjcbYsFetch");
    urlInfo148.setResponseDepict("间接成本预算集合,总条数,合计对象");
    urlInfo148.setTransation(true);
    urlInfo148.setRestClass("jjcbYsFetch");
    webCommands.put(urlInfo148.getUrl(),urlInfo148);
    codeOpMap.put(urlInfo148.getMsgCode(),urlInfo148);

    SimpleWebCommandOperationInfo urlInfo149= new SimpleWebCommandOperationInfo();
    urlInfo149.setMsgCode(40102);
    urlInfo149.setUrl("/cbhs/monthMbYs/jjcbYsUpdate");
    urlInfo149.setOpCode("0");
    urlInfo149.setWorkClass("");
    urlInfo149.setMsgReaquest("com.server.pojo.bean.CbhsMonthJjcbYs");
    urlInfo149.setReaquestDepict("间接成本");
    urlInfo149.setMsgResponse("com.server.pojo.bean.CbhsMonthJjcbYs");
    urlInfo149.setResponseDepict("间接成本预算");
    urlInfo149.setTransation(true);
    urlInfo149.setRestClass("jjcbYsUpdate");
    webCommands.put(urlInfo149.getUrl(),urlInfo149);
    codeOpMap.put(urlInfo149.getMsgCode(),urlInfo149);

    SimpleWebCommandOperationInfo urlInfo150= new SimpleWebCommandOperationInfo();
    urlInfo150.setMsgCode(40103);
    urlInfo150.setUrl("/cbhs/monthMbYs/jjcbYsDel");
    urlInfo150.setOpCode("0");
    urlInfo150.setWorkClass("");
    urlInfo150.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestJjcbYsDel");
    urlInfo150.setReaquestDepict("间接成本主键集合");
    urlInfo150.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo150.setResponseDepict("响应状态码");
    urlInfo150.setTransation(false);
    urlInfo150.setRestClass("jjcbYsDel");
    webCommands.put(urlInfo150.getUrl(),urlInfo150);
    codeOpMap.put(urlInfo150.getMsgCode(),urlInfo150);

    SimpleWebCommandOperationInfo urlInfo151= new SimpleWebCommandOperationInfo();
    urlInfo151.setMsgCode(40104);
    urlInfo151.setUrl("/cbhs/monthMbYs/jjcbYsAdd");
    urlInfo151.setOpCode("0");
    urlInfo151.setWorkClass("");
    urlInfo151.setMsgReaquest("com.server.pojo.bean.CbhsMonthJjcbYs");
    urlInfo151.setReaquestDepict("间接成本");
    urlInfo151.setMsgResponse("com.server.pojo.bean.CbhsMonthJjcbYs");
    urlInfo151.setResponseDepict("间接成本预算");
    urlInfo151.setTransation(true);
    urlInfo151.setRestClass("jjcbYsAdd");
    webCommands.put(urlInfo151.getUrl(),urlInfo151);
    codeOpMap.put(urlInfo151.getMsgCode(),urlInfo151);

    SimpleWebCommandOperationInfo urlInfo152= new SimpleWebCommandOperationInfo();
    urlInfo152.setMsgCode(40201);
    urlInfo152.setUrl("/cbhs/monthMbYs/glfyYsFetch");
    urlInfo152.setOpCode("0");
    urlInfo152.setWorkClass("");
    urlInfo152.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestGlfyYsFetch");
    urlInfo152.setReaquestDepict("主键,部门ID,工程项目ID,月份时间戳,页码,数量,开始ID");
    urlInfo152.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseGlfyYsFetch");
    urlInfo152.setResponseDepict("管理费用集合,总条数");
    urlInfo152.setTransation(true);
    urlInfo152.setRestClass("glfyYsFetch");
    webCommands.put(urlInfo152.getUrl(),urlInfo152);
    codeOpMap.put(urlInfo152.getMsgCode(),urlInfo152);

    SimpleWebCommandOperationInfo urlInfo153= new SimpleWebCommandOperationInfo();
    urlInfo153.setMsgCode(40202);
    urlInfo153.setUrl("/cbhs/monthMbYs/glfyYsUpdate");
    urlInfo153.setOpCode("0");
    urlInfo153.setWorkClass("");
    urlInfo153.setMsgReaquest("com.server.pojo.bean.CbhsMonthGlfyYs");
    urlInfo153.setReaquestDepict("管理经费");
    urlInfo153.setMsgResponse("com.server.pojo.bean.CbhsMonthGlfyYs");
    urlInfo153.setResponseDepict("管理费用");
    urlInfo153.setTransation(true);
    urlInfo153.setRestClass("glfyYsUpdate");
    webCommands.put(urlInfo153.getUrl(),urlInfo153);
    codeOpMap.put(urlInfo153.getMsgCode(),urlInfo153);

    SimpleWebCommandOperationInfo urlInfo154= new SimpleWebCommandOperationInfo();
    urlInfo154.setMsgCode(40203);
    urlInfo154.setUrl("/cbhs/monthMbYs/glfyYsDel");
    urlInfo154.setOpCode("0");
    urlInfo154.setWorkClass("");
    urlInfo154.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestGlfyYsDel");
    urlInfo154.setReaquestDepict("管理经费主键集合");
    urlInfo154.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo154.setResponseDepict("响应状态码");
    urlInfo154.setTransation(false);
    urlInfo154.setRestClass("glfyYsDel");
    webCommands.put(urlInfo154.getUrl(),urlInfo154);
    codeOpMap.put(urlInfo154.getMsgCode(),urlInfo154);

    SimpleWebCommandOperationInfo urlInfo155= new SimpleWebCommandOperationInfo();
    urlInfo155.setMsgCode(40204);
    urlInfo155.setUrl("/cbhs/monthMbYs/glfyYsAdd");
    urlInfo155.setOpCode("0");
    urlInfo155.setWorkClass("");
    urlInfo155.setMsgReaquest("com.server.pojo.bean.CbhsMonthGlfyYs");
    urlInfo155.setReaquestDepict("管理经费");
    urlInfo155.setMsgResponse("com.server.pojo.bean.CbhsMonthGlfyYs");
    urlInfo155.setResponseDepict("管理费用");
    urlInfo155.setTransation(true);
    urlInfo155.setRestClass("glfyYsAdd");
    webCommands.put(urlInfo155.getUrl(),urlInfo155);
    codeOpMap.put(urlInfo155.getMsgCode(),urlInfo155);

    SimpleWebCommandOperationInfo urlInfo156= new SimpleWebCommandOperationInfo();
    urlInfo156.setMsgCode(40301);
    urlInfo156.setUrl("/cbhs/monthMbYs/zyCailiaoCbYsFetch");
    urlInfo156.setOpCode("0");
    urlInfo156.setWorkClass("");
    urlInfo156.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsFetch");
    urlInfo156.setReaquestDepict("主键,部门ID,工程量ID,工程项目ID,月份时间戳,页码,数量,开始ID");
    urlInfo156.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseZyCailiaoCbYsFetch");
    urlInfo156.setResponseDepict("自营材料成本集合,总条数");
    urlInfo156.setTransation(true);
    urlInfo156.setRestClass("zyCailiaoCbYsFetch");
    webCommands.put(urlInfo156.getUrl(),urlInfo156);
    codeOpMap.put(urlInfo156.getMsgCode(),urlInfo156);

    SimpleWebCommandOperationInfo urlInfo157= new SimpleWebCommandOperationInfo();
    urlInfo157.setMsgCode(40302);
    urlInfo157.setUrl("/cbhs/monthMbYs/zyCailiaoCbYsUpdate");
    urlInfo157.setOpCode("0");
    urlInfo157.setWorkClass("");
    urlInfo157.setMsgReaquest("com.server.pojo.bean.CbhsMonthZyCailiaoCbYs");
    urlInfo157.setReaquestDepict("自营材料成本");
    urlInfo157.setMsgResponse("com.server.pojo.bean.CbhsMonthZyCailiaoCbYs");
    urlInfo157.setResponseDepict("自营材料成本");
    urlInfo157.setTransation(true);
    urlInfo157.setRestClass("zyCailiaoCbYsUpdate");
    webCommands.put(urlInfo157.getUrl(),urlInfo157);
    codeOpMap.put(urlInfo157.getMsgCode(),urlInfo157);

    SimpleWebCommandOperationInfo urlInfo158= new SimpleWebCommandOperationInfo();
    urlInfo158.setMsgCode(40303);
    urlInfo158.setUrl("/cbhs/monthMbYs/zyCailiaoCbYsDel");
    urlInfo158.setOpCode("0");
    urlInfo158.setWorkClass("");
    urlInfo158.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsDel");
    urlInfo158.setReaquestDepict("自营材料成本主键集合");
    urlInfo158.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo158.setResponseDepict("响应状态码");
    urlInfo158.setTransation(false);
    urlInfo158.setRestClass("zyCailiaoCbYsDel");
    webCommands.put(urlInfo158.getUrl(),urlInfo158);
    codeOpMap.put(urlInfo158.getMsgCode(),urlInfo158);

    SimpleWebCommandOperationInfo urlInfo159= new SimpleWebCommandOperationInfo();
    urlInfo159.setMsgCode(40304);
    urlInfo159.setUrl("/cbhs/monthMbYs/zyCailiaoCbYsAdd");
    urlInfo159.setOpCode("0");
    urlInfo159.setWorkClass("");
    urlInfo159.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsAdd");
    urlInfo159.setReaquestDepict("自营材料成本集合 可批量添加");
    urlInfo159.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseZyCailiaoCbYsAdd");
    urlInfo159.setResponseDepict("自营材料成本集合");
    urlInfo159.setTransation(true);
    urlInfo159.setRestClass("zyCailiaoCbYsAdd");
    webCommands.put(urlInfo159.getUrl(),urlInfo159);
    codeOpMap.put(urlInfo159.getMsgCode(),urlInfo159);

    SimpleWebCommandOperationInfo urlInfo160= new SimpleWebCommandOperationInfo();
    urlInfo160.setMsgCode(40305);
    urlInfo160.setUrl("/cbhs/monthMbYs/zyCailiaoCbYsCailiaoFetch");
    urlInfo160.setOpCode("0");
    urlInfo160.setWorkClass("");
    urlInfo160.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsCailiaoFetch");
    urlInfo160.setReaquestDepict("部门ID,工程量ID,工程项目ID,月份时间戳,页码,数量,开始ID,是否是燃油 1是 2不是");
    urlInfo160.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseZyCailiaoCbYsCailiaoFetch");
    urlInfo160.setResponseDepict("材料集合,总条数");
    urlInfo160.setTransation(true);
    urlInfo160.setRestClass("zyCailiaoCbYsCailiaoFetch");
    webCommands.put(urlInfo160.getUrl(),urlInfo160);
    codeOpMap.put(urlInfo160.getMsgCode(),urlInfo160);

    SimpleWebCommandOperationInfo urlInfo161= new SimpleWebCommandOperationInfo();
    urlInfo161.setMsgCode(40401);
    urlInfo161.setUrl("/cbhs/monthMbYs/zyLxygCbYsFetch");
    urlInfo161.setOpCode("0");
    urlInfo161.setWorkClass("");
    urlInfo161.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestZyLxygCbYsFetch");
    urlInfo161.setReaquestDepict("主键,部门ID,工程项目ID,月份时间戳,页码,数量,开始ID");
    urlInfo161.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseZyLxygCbYsFetch");
    urlInfo161.setResponseDepict("自营零星用工成本集合,总条数");
    urlInfo161.setTransation(true);
    urlInfo161.setRestClass("zyLxygCbYsFetch");
    webCommands.put(urlInfo161.getUrl(),urlInfo161);
    codeOpMap.put(urlInfo161.getMsgCode(),urlInfo161);

    SimpleWebCommandOperationInfo urlInfo162= new SimpleWebCommandOperationInfo();
    urlInfo162.setMsgCode(40402);
    urlInfo162.setUrl("/cbhs/monthMbYs/zyLxygCbYsUpdate");
    urlInfo162.setOpCode("0");
    urlInfo162.setWorkClass("");
    urlInfo162.setMsgReaquest("com.server.pojo.bean.CbhsMonthZyLxygCbYs");
    urlInfo162.setReaquestDepict("自营零星用工");
    urlInfo162.setMsgResponse("com.server.pojo.bean.CbhsMonthZyLxygCbYs");
    urlInfo162.setResponseDepict("自营零星用工成本");
    urlInfo162.setTransation(true);
    urlInfo162.setRestClass("zyLxygCbYsUpdate");
    webCommands.put(urlInfo162.getUrl(),urlInfo162);
    codeOpMap.put(urlInfo162.getMsgCode(),urlInfo162);

    SimpleWebCommandOperationInfo urlInfo163= new SimpleWebCommandOperationInfo();
    urlInfo163.setMsgCode(40403);
    urlInfo163.setUrl("/cbhs/monthMbYs/zyLxygCbYsDel");
    urlInfo163.setOpCode("0");
    urlInfo163.setWorkClass("");
    urlInfo163.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestZyLxygCbYsDel");
    urlInfo163.setReaquestDepict("自营零星用工主键集合");
    urlInfo163.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo163.setResponseDepict("响应状态码");
    urlInfo163.setTransation(false);
    urlInfo163.setRestClass("zyLxygCbYsDel");
    webCommands.put(urlInfo163.getUrl(),urlInfo163);
    codeOpMap.put(urlInfo163.getMsgCode(),urlInfo163);

    SimpleWebCommandOperationInfo urlInfo164= new SimpleWebCommandOperationInfo();
    urlInfo164.setMsgCode(40404);
    urlInfo164.setUrl("/cbhs/monthMbYs/zyLxygCbYsAdd");
    urlInfo164.setOpCode("0");
    urlInfo164.setWorkClass("");
    urlInfo164.setMsgReaquest("com.server.pojo.bean.CbhsMonthZyLxygCbYs");
    urlInfo164.setReaquestDepict("自营零星用工");
    urlInfo164.setMsgResponse("com.server.pojo.bean.CbhsMonthZyLxygCbYs");
    urlInfo164.setResponseDepict("自营零星用工成本集合");
    urlInfo164.setTransation(true);
    urlInfo164.setRestClass("zyLxygCbYsAdd");
    webCommands.put(urlInfo164.getUrl(),urlInfo164);
    codeOpMap.put(urlInfo164.getMsgCode(),urlInfo164);

    SimpleWebCommandOperationInfo urlInfo165= new SimpleWebCommandOperationInfo();
    urlInfo165.setMsgCode(40501);
    urlInfo165.setUrl("/cbhs/monthMbYs/zyJxCbYsFetch");
    urlInfo165.setOpCode("0");
    urlInfo165.setWorkClass("");
    urlInfo165.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestZyJxCbYsFetch");
    urlInfo165.setReaquestDepict("主键,部门ID,工程项目ID,月份时间戳,页码,数量,开始ID");
    urlInfo165.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseZyJxCbYsFetch");
    urlInfo165.setResponseDepict("自营机械成本集合,总条数");
    urlInfo165.setTransation(true);
    urlInfo165.setRestClass("zyJxCbYsFetch");
    webCommands.put(urlInfo165.getUrl(),urlInfo165);
    codeOpMap.put(urlInfo165.getMsgCode(),urlInfo165);

    SimpleWebCommandOperationInfo urlInfo166= new SimpleWebCommandOperationInfo();
    urlInfo166.setMsgCode(40502);
    urlInfo166.setUrl("/cbhs/monthMbYs/zyJxCbYsUpdate");
    urlInfo166.setOpCode("0");
    urlInfo166.setWorkClass("");
    urlInfo166.setMsgReaquest("com.server.pojo.bean.CbhsMonthZyJxCbYs");
    urlInfo166.setReaquestDepict("自营机械成本");
    urlInfo166.setMsgResponse("com.server.pojo.bean.CbhsMonthZyJxCbYs");
    urlInfo166.setResponseDepict("自营机械成本成本");
    urlInfo166.setTransation(true);
    urlInfo166.setRestClass("zyJxCbYsUpdate");
    webCommands.put(urlInfo166.getUrl(),urlInfo166);
    codeOpMap.put(urlInfo166.getMsgCode(),urlInfo166);

    SimpleWebCommandOperationInfo urlInfo167= new SimpleWebCommandOperationInfo();
    urlInfo167.setMsgCode(40503);
    urlInfo167.setUrl("/cbhs/monthMbYs/zyJxCbYsDel");
    urlInfo167.setOpCode("0");
    urlInfo167.setWorkClass("");
    urlInfo167.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestZyJxCbYsDel");
    urlInfo167.setReaquestDepict("自营机械成本主键集合");
    urlInfo167.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo167.setResponseDepict("响应状态码");
    urlInfo167.setTransation(false);
    urlInfo167.setRestClass("zyJxCbYsDel");
    webCommands.put(urlInfo167.getUrl(),urlInfo167);
    codeOpMap.put(urlInfo167.getMsgCode(),urlInfo167);

    SimpleWebCommandOperationInfo urlInfo168= new SimpleWebCommandOperationInfo();
    urlInfo168.setMsgCode(40504);
    urlInfo168.setUrl("/cbhs/monthMbYs/zyJxCbYsAdd");
    urlInfo168.setOpCode("0");
    urlInfo168.setWorkClass("");
    urlInfo168.setMsgReaquest("com.server.pojo.bean.CbhsMonthZyJxCbYs");
    urlInfo168.setReaquestDepict("自营机械成本");
    urlInfo168.setMsgResponse("com.server.pojo.bean.CbhsMonthZyJxCbYs");
    urlInfo168.setResponseDepict("自营机械成本集合");
    urlInfo168.setTransation(true);
    urlInfo168.setRestClass("zyJxCbYsAdd");
    webCommands.put(urlInfo168.getUrl(),urlInfo168);
    codeOpMap.put(urlInfo168.getMsgCode(),urlInfo168);

    SimpleWebCommandOperationInfo urlInfo169= new SimpleWebCommandOperationInfo();
    urlInfo169.setMsgCode(40601);
    urlInfo169.setUrl("/cbhs/monthMbYs/zyQtfyYsFetch");
    urlInfo169.setOpCode("0");
    urlInfo169.setWorkClass("");
    urlInfo169.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestZyQtfyYsFetch");
    urlInfo169.setReaquestDepict("主键,部门ID,工程项目ID,月份时间戳,页码,数量,开始ID");
    urlInfo169.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseZyQtfyYsFetch");
    urlInfo169.setResponseDepict("自营其他费用集合,总条数");
    urlInfo169.setTransation(true);
    urlInfo169.setRestClass("zyQtfyYsFetch");
    webCommands.put(urlInfo169.getUrl(),urlInfo169);
    codeOpMap.put(urlInfo169.getMsgCode(),urlInfo169);

    SimpleWebCommandOperationInfo urlInfo170= new SimpleWebCommandOperationInfo();
    urlInfo170.setMsgCode(40602);
    urlInfo170.setUrl("/cbhs/monthMbYs/zyQtfyYsUpdate");
    urlInfo170.setOpCode("0");
    urlInfo170.setWorkClass("");
    urlInfo170.setMsgReaquest("com.server.pojo.bean.CbhsMonthZyQtfyYs");
    urlInfo170.setReaquestDepict("自营其他费用");
    urlInfo170.setMsgResponse("com.server.pojo.bean.CbhsMonthZyQtfyYs");
    urlInfo170.setResponseDepict("自营其他费用成本");
    urlInfo170.setTransation(true);
    urlInfo170.setRestClass("zyQtfyYsUpdate");
    webCommands.put(urlInfo170.getUrl(),urlInfo170);
    codeOpMap.put(urlInfo170.getMsgCode(),urlInfo170);

    SimpleWebCommandOperationInfo urlInfo171= new SimpleWebCommandOperationInfo();
    urlInfo171.setMsgCode(40603);
    urlInfo171.setUrl("/cbhs/monthMbYs/zyQtfyYsDel");
    urlInfo171.setOpCode("0");
    urlInfo171.setWorkClass("");
    urlInfo171.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestZyQtfyYsDel");
    urlInfo171.setReaquestDepict("自营其他费用主键集合");
    urlInfo171.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo171.setResponseDepict("响应状态码");
    urlInfo171.setTransation(false);
    urlInfo171.setRestClass("zyQtfyYsDel");
    webCommands.put(urlInfo171.getUrl(),urlInfo171);
    codeOpMap.put(urlInfo171.getMsgCode(),urlInfo171);

    SimpleWebCommandOperationInfo urlInfo172= new SimpleWebCommandOperationInfo();
    urlInfo172.setMsgCode(40604);
    urlInfo172.setUrl("/cbhs/monthMbYs/zyQtfyYsAdd");
    urlInfo172.setOpCode("0");
    urlInfo172.setWorkClass("");
    urlInfo172.setMsgReaquest("com.server.pojo.bean.CbhsMonthZyQtfyYs");
    urlInfo172.setReaquestDepict("自营其他费用");
    urlInfo172.setMsgResponse("com.server.pojo.bean.CbhsMonthZyQtfyYs");
    urlInfo172.setResponseDepict("自营其他费用集合");
    urlInfo172.setTransation(true);
    urlInfo172.setRestClass("zyQtfyYsAdd");
    webCommands.put(urlInfo172.getUrl(),urlInfo172);
    codeOpMap.put(urlInfo172.getMsgCode(),urlInfo172);

    SimpleWebCommandOperationInfo urlInfo173= new SimpleWebCommandOperationInfo();
    urlInfo173.setMsgCode(40701);
    urlInfo173.setUrl("/cbhs/monthMbYs/fbLjxmCbYsFetch");
    urlInfo173.setOpCode("0");
    urlInfo173.setWorkClass("");
    urlInfo173.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestFbLjxmCbYsFetch");
    urlInfo173.setReaquestDepict("主键,部门ID,工程项目ID,月份时间戳,页码,数量,开始ID");
    urlInfo173.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseFbLjxmCbYsFetch");
    urlInfo173.setResponseDepict("分包临建项目集合,总条数");
    urlInfo173.setTransation(true);
    urlInfo173.setRestClass("fbLjxmCbYsFetch");
    webCommands.put(urlInfo173.getUrl(),urlInfo173);
    codeOpMap.put(urlInfo173.getMsgCode(),urlInfo173);

    SimpleWebCommandOperationInfo urlInfo174= new SimpleWebCommandOperationInfo();
    urlInfo174.setMsgCode(40702);
    urlInfo174.setUrl("/cbhs/monthMbYs/fbLjxmCbYsUpdate");
    urlInfo174.setOpCode("0");
    urlInfo174.setWorkClass("");
    urlInfo174.setMsgReaquest("com.server.pojo.bean.CbhsMonthFbLjxmCbYs");
    urlInfo174.setReaquestDepict("分包临建项目");
    urlInfo174.setMsgResponse("com.server.pojo.bean.CbhsMonthFbLjxmCbYs");
    urlInfo174.setResponseDepict("分包临建项目");
    urlInfo174.setTransation(true);
    urlInfo174.setRestClass("fbLjxmCbYsUpdate");
    webCommands.put(urlInfo174.getUrl(),urlInfo174);
    codeOpMap.put(urlInfo174.getMsgCode(),urlInfo174);

    SimpleWebCommandOperationInfo urlInfo175= new SimpleWebCommandOperationInfo();
    urlInfo175.setMsgCode(40703);
    urlInfo175.setUrl("/cbhs/monthMbYs/fbLjxmCbYsDel");
    urlInfo175.setOpCode("0");
    urlInfo175.setWorkClass("");
    urlInfo175.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestFbLjxmCbYsDel");
    urlInfo175.setReaquestDepict("分包临建项目主键集合");
    urlInfo175.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo175.setResponseDepict("响应状态码");
    urlInfo175.setTransation(false);
    urlInfo175.setRestClass("fbLjxmCbYsDel");
    webCommands.put(urlInfo175.getUrl(),urlInfo175);
    codeOpMap.put(urlInfo175.getMsgCode(),urlInfo175);

    SimpleWebCommandOperationInfo urlInfo176= new SimpleWebCommandOperationInfo();
    urlInfo176.setMsgCode(40704);
    urlInfo176.setUrl("/cbhs/monthMbYs/fbLjxmCbYsAdd");
    urlInfo176.setOpCode("0");
    urlInfo176.setWorkClass("");
    urlInfo176.setMsgReaquest("com.server.pojo.bean.CbhsMonthFbLjxmCbYs");
    urlInfo176.setReaquestDepict("分包临建项目");
    urlInfo176.setMsgResponse("com.server.pojo.bean.CbhsMonthFbLjxmCbYs");
    urlInfo176.setResponseDepict("分包临建项目");
    urlInfo176.setTransation(true);
    urlInfo176.setRestClass("fbLjxmCbYsAdd");
    webCommands.put(urlInfo176.getUrl(),urlInfo176);
    codeOpMap.put(urlInfo176.getMsgCode(),urlInfo176);

    SimpleWebCommandOperationInfo urlInfo177= new SimpleWebCommandOperationInfo();
    urlInfo177.setMsgCode(40801);
    urlInfo177.setUrl("/cbhs/monthMbYs/fbGcCbYsFetch");
    urlInfo177.setOpCode("0");
    urlInfo177.setWorkClass("");
    urlInfo177.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestFbGcCbYsFetch");
    urlInfo177.setReaquestDepict("主键,部门ID,工程量ID,工程项目ID,月份时间戳,页码,数量,开始ID,类型(1:大项|2:有单价的项),分包商ID,合同ID");
    urlInfo177.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseFbGcCbYsFetch");
    urlInfo177.setResponseDepict("分包工程集合,总条数,总费用");
    urlInfo177.setTransation(true);
    urlInfo177.setRestClass("fbGcCbYsFetch");
    webCommands.put(urlInfo177.getUrl(),urlInfo177);
    codeOpMap.put(urlInfo177.getMsgCode(),urlInfo177);

    SimpleWebCommandOperationInfo urlInfo178= new SimpleWebCommandOperationInfo();
    urlInfo178.setMsgCode(40802);
    urlInfo178.setUrl("/cbhs/monthMbYs/fbGcCbYsUpdate");
    urlInfo178.setOpCode("0");
    urlInfo178.setWorkClass("");
    urlInfo178.setMsgReaquest("com.server.pojo.bean.CbhsMonthFbGcCbYs");
    urlInfo178.setReaquestDepict("分包工程");
    urlInfo178.setMsgResponse("com.server.pojo.bean.CbhsMonthFbGcCbYs");
    urlInfo178.setResponseDepict("分包工程");
    urlInfo178.setTransation(true);
    urlInfo178.setRestClass("fbGcCbYsUpdate");
    webCommands.put(urlInfo178.getUrl(),urlInfo178);
    codeOpMap.put(urlInfo178.getMsgCode(),urlInfo178);

    SimpleWebCommandOperationInfo urlInfo179= new SimpleWebCommandOperationInfo();
    urlInfo179.setMsgCode(40803);
    urlInfo179.setUrl("/cbhs/monthMbYs/fbGcCbYsDel");
    urlInfo179.setOpCode("0");
    urlInfo179.setWorkClass("");
    urlInfo179.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestFbGcCbYsDel");
    urlInfo179.setReaquestDepict("分包工程主键集合");
    urlInfo179.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo179.setResponseDepict("响应状态码");
    urlInfo179.setTransation(false);
    urlInfo179.setRestClass("fbGcCbYsDel");
    webCommands.put(urlInfo179.getUrl(),urlInfo179);
    codeOpMap.put(urlInfo179.getMsgCode(),urlInfo179);

    SimpleWebCommandOperationInfo urlInfo180= new SimpleWebCommandOperationInfo();
    urlInfo180.setMsgCode(40804);
    urlInfo180.setUrl("/cbhs/monthMbYs/fbGcCbYsAdd");
    urlInfo180.setOpCode("0");
    urlInfo180.setWorkClass("");
    urlInfo180.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestFbGcCbYsAdd");
    urlInfo180.setReaquestDepict("分包工程");
    urlInfo180.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseFbGcCbYsAdd");
    urlInfo180.setResponseDepict("分包工程");
    urlInfo180.setTransation(true);
    urlInfo180.setRestClass("fbGcCbYsAdd");
    webCommands.put(urlInfo180.getUrl(),urlInfo180);
    codeOpMap.put(urlInfo180.getMsgCode(),urlInfo180);

    SimpleWebCommandOperationInfo urlInfo181= new SimpleWebCommandOperationInfo();
    urlInfo181.setMsgCode(40805);
    urlInfo181.setUrl("/cbhs/monthMbYs/fbGcGlobalXmFetch");
    urlInfo181.setOpCode("0");
    urlInfo181.setWorkClass("");
    urlInfo181.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestFbGcGlobalXmFetch");
    urlInfo181.setReaquestDepict("工程项目ID,部门ID,月份时间戳,页码,数量,开始ID");
    urlInfo181.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseFbGcGlobalXmFetch");
    urlInfo181.setResponseDepict("分包工程大项集合,总条数");
    urlInfo181.setTransation(true);
    urlInfo181.setRestClass("fbGcGlobalXmFetch");
    webCommands.put(urlInfo181.getUrl(),urlInfo181);
    codeOpMap.put(urlInfo181.getMsgCode(),urlInfo181);

    SimpleWebCommandOperationInfo urlInfo182= new SimpleWebCommandOperationInfo();
    urlInfo182.setMsgCode(40806);
    urlInfo182.setUrl("/cbhs/monthMbYs/fbGcFbCompanyFetch");
    urlInfo182.setOpCode("0");
    urlInfo182.setWorkClass("");
    urlInfo182.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestFbGcFbCompanyFetch");
    urlInfo182.setReaquestDepict("工程项目ID,部门ID,月份时间戳,页码,数量,开始ID");
    urlInfo182.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseFbGcFbCompanyFetch");
    urlInfo182.setResponseDepict("分包工程大项集合,总条数");
    urlInfo182.setTransation(true);
    urlInfo182.setRestClass("fbGcFbCompanyFetch");
    webCommands.put(urlInfo182.getUrl(),urlInfo182);
    codeOpMap.put(urlInfo182.getMsgCode(),urlInfo182);

    SimpleWebCommandOperationInfo urlInfo183= new SimpleWebCommandOperationInfo();
    urlInfo183.setMsgCode(40901);
    urlInfo183.setUrl("/cbhs/monthMbYs/fbCailiaoCbYsFetch");
    urlInfo183.setOpCode("0");
    urlInfo183.setWorkClass("");
    urlInfo183.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsFetch");
    urlInfo183.setReaquestDepict("主键,部门ID,分包工程量ID,工程项目ID,月份时间戳,页码,数量,开始ID,分包商ID");
    urlInfo183.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseFbCailiaoCbYsFetch");
    urlInfo183.setResponseDepict("分包材料成本集合,总条数");
    urlInfo183.setTransation(true);
    urlInfo183.setRestClass("fbCailiaoCbYsFetch");
    webCommands.put(urlInfo183.getUrl(),urlInfo183);
    codeOpMap.put(urlInfo183.getMsgCode(),urlInfo183);

    SimpleWebCommandOperationInfo urlInfo184= new SimpleWebCommandOperationInfo();
    urlInfo184.setMsgCode(40902);
    urlInfo184.setUrl("/cbhs/monthMbYs/fbCailiaoCbYsUpdate");
    urlInfo184.setOpCode("0");
    urlInfo184.setWorkClass("");
    urlInfo184.setMsgReaquest("com.server.pojo.bean.CbhsMonthFbCailiaoCbYs");
    urlInfo184.setReaquestDepict("分包材料成本");
    urlInfo184.setMsgResponse("com.server.pojo.bean.CbhsMonthFbCailiaoCbYs");
    urlInfo184.setResponseDepict("分包材料成本");
    urlInfo184.setTransation(true);
    urlInfo184.setRestClass("fbCailiaoCbYsUpdate");
    webCommands.put(urlInfo184.getUrl(),urlInfo184);
    codeOpMap.put(urlInfo184.getMsgCode(),urlInfo184);

    SimpleWebCommandOperationInfo urlInfo185= new SimpleWebCommandOperationInfo();
    urlInfo185.setMsgCode(40903);
    urlInfo185.setUrl("/cbhs/monthMbYs/fbCailiaoCbYsDel");
    urlInfo185.setOpCode("0");
    urlInfo185.setWorkClass("");
    urlInfo185.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsDel");
    urlInfo185.setReaquestDepict("分包材料成本主键集合");
    urlInfo185.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo185.setResponseDepict("响应状态码");
    urlInfo185.setTransation(false);
    urlInfo185.setRestClass("fbCailiaoCbYsDel");
    webCommands.put(urlInfo185.getUrl(),urlInfo185);
    codeOpMap.put(urlInfo185.getMsgCode(),urlInfo185);

    SimpleWebCommandOperationInfo urlInfo186= new SimpleWebCommandOperationInfo();
    urlInfo186.setMsgCode(40904);
    urlInfo186.setUrl("/cbhs/monthMbYs/fbCailiaoCbYsAdd");
    urlInfo186.setOpCode("0");
    urlInfo186.setWorkClass("");
    urlInfo186.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsAdd");
    urlInfo186.setReaquestDepict("分包材料成本");
    urlInfo186.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseFbCailiaoCbYsAdd");
    urlInfo186.setResponseDepict("分包材料成本");
    urlInfo186.setTransation(true);
    urlInfo186.setRestClass("fbCailiaoCbYsAdd");
    webCommands.put(urlInfo186.getUrl(),urlInfo186);
    codeOpMap.put(urlInfo186.getMsgCode(),urlInfo186);

    SimpleWebCommandOperationInfo urlInfo187= new SimpleWebCommandOperationInfo();
    urlInfo187.setMsgCode(40905);
    urlInfo187.setUrl("/cbhs/monthMbYs/fbCailiaoCbYsCailiaoFetch");
    urlInfo187.setOpCode("0");
    urlInfo187.setWorkClass("");
    urlInfo187.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsCailiaoFetch");
    urlInfo187.setReaquestDepict("主键,部门ID,分包工程量ID,工程项目ID,月份时间戳,页码,数量,开始ID,是否是燃油 1是 2不是");
    urlInfo187.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseFbCailiaoCbYsCailiaoFetch");
    urlInfo187.setResponseDepict("分包材料成本");
    urlInfo187.setTransation(true);
    urlInfo187.setRestClass("fbCailiaoCbYsCailiaoFetch");
    webCommands.put(urlInfo187.getUrl(),urlInfo187);
    codeOpMap.put(urlInfo187.getMsgCode(),urlInfo187);

    SimpleWebCommandOperationInfo urlInfo188= new SimpleWebCommandOperationInfo();
    urlInfo188.setMsgCode(41001);
    urlInfo188.setUrl("/cbhs/monthMbYs/mbYsFetch");
    urlInfo188.setOpCode("0");
    urlInfo188.setWorkClass("");
    urlInfo188.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestMbYsFetch");
    urlInfo188.setReaquestDepict("工程项目ID,部门编号 0为所有部门汇总,月份");
    urlInfo188.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseMbYsFetch");
    urlInfo188.setResponseDepict("间接成本总量,管理费用总量,直接成本总量");
    urlInfo188.setTransation(true);
    urlInfo188.setRestClass("mbYsFetch");
    webCommands.put(urlInfo188.getUrl(),urlInfo188);
    codeOpMap.put(urlInfo188.getMsgCode(),urlInfo188);

    SimpleWebCommandOperationInfo urlInfo189= new SimpleWebCommandOperationInfo();
    urlInfo189.setMsgCode(41002);
    urlInfo189.setUrl("/cbhs/monthMbYs/mbYsTotalFetch");
    urlInfo189.setOpCode("0");
    urlInfo189.setWorkClass("");
    urlInfo189.setMsgReaquest("com.server.pojo.url.monthMbYs.RequestMbYsTotalFetch");
    urlInfo189.setReaquestDepict("工程项目ID,部门编号 0为所有部门汇总,月份");
    urlInfo189.setMsgResponse("com.server.pojo.url.monthMbYs.ResponseMbYsTotalFetch");
    urlInfo189.setResponseDepict("结果,总条数,月份所有部门总预算");
    urlInfo189.setTransation(true);
    urlInfo189.setRestClass("mbYsTotalFetch");
    webCommands.put(urlInfo189.getUrl(),urlInfo189);
    codeOpMap.put(urlInfo189.getMsgCode(),urlInfo189);

    SimpleWebCommandOperationInfo urlInfo190= new SimpleWebCommandOperationInfo();
    urlInfo190.setMsgCode(100101);
    urlInfo190.setUrl("/cbhs/tjbb/cbsrbb");
    urlInfo190.setOpCode("0");
    urlInfo190.setWorkClass("");
    urlInfo190.setMsgReaquest("com.server.pojo.url.tjbb.RequestCbsrbb");
    urlInfo190.setReaquestDepict("工程项目ID,开始日期,结束日期");
    urlInfo190.setMsgResponse("com.server.pojo.url.tjbb.ResponseCbsrbb");
    urlInfo190.setResponseDepict("成本集合,收入集合");
    urlInfo190.setTransation(true);
    urlInfo190.setRestClass("cbsrbb");
    webCommands.put(urlInfo190.getUrl(),urlInfo190);
    codeOpMap.put(urlInfo190.getMsgCode(),urlInfo190);

    SimpleWebCommandOperationInfo urlInfo191= new SimpleWebCommandOperationInfo();
    urlInfo191.setMsgCode(100102);
    urlInfo191.setUrl("/cbhs/tjbb/zybb");
    urlInfo191.setOpCode("0");
    urlInfo191.setWorkClass("");
    urlInfo191.setMsgReaquest("com.server.pojo.url.tjbb.RequestZybb");
    urlInfo191.setReaquestDepict("工程项目ID,分包商ID,开始日期,结束日期");
    urlInfo191.setMsgResponse("com.server.pojo.url.tjbb.ResponseZybb");
    urlInfo191.setResponseDepict("成本集合,收入集合");
    urlInfo191.setTransation(true);
    urlInfo191.setRestClass("zybb");
    webCommands.put(urlInfo191.getUrl(),urlInfo191);
    codeOpMap.put(urlInfo191.getMsgCode(),urlInfo191);

    SimpleWebCommandOperationInfo urlInfo192= new SimpleWebCommandOperationInfo();
    urlInfo192.setMsgCode(100103);
    urlInfo192.setUrl("/cbhs/tjbb/daysDetails");
    urlInfo192.setOpCode("0");
    urlInfo192.setWorkClass("");
    urlInfo192.setMsgReaquest("com.server.pojo.url.tjbb.RequestDaysDetails");
    urlInfo192.setReaquestDepict("部门ID,工程项目ID,日期时间戳");
    urlInfo192.setMsgResponse("com.server.pojo.bean.uiDaysCbDetailTj");
    urlInfo192.setResponseDepict("每日数据详情");
    urlInfo192.setTransation(true);
    urlInfo192.setRestClass("daysDetails");
    webCommands.put(urlInfo192.getUrl(),urlInfo192);
    codeOpMap.put(urlInfo192.getMsgCode(),urlInfo192);

    SimpleWebCommandOperationInfo urlInfo193= new SimpleWebCommandOperationInfo();
    urlInfo193.setMsgCode(100104);
    urlInfo193.setUrl("/cbhs/tjbb/grandTotal");
    urlInfo193.setOpCode("0");
    urlInfo193.setWorkClass("");
    urlInfo193.setMsgReaquest("com.server.pojo.url.tjbb.RequestGrandTotal");
    urlInfo193.setReaquestDepict("工程项目ID,开始时间,结束时间");
    urlInfo193.setMsgResponse("com.server.pojo.bean.uiGrandTotalTj");
    urlInfo193.setResponseDepict("累计数据详情");
    urlInfo193.setTransation(true);
    urlInfo193.setRestClass("grandTotal");
    webCommands.put(urlInfo193.getUrl(),urlInfo193);
    codeOpMap.put(urlInfo193.getMsgCode(),urlInfo193);

    SimpleWebCommandOperationInfo urlInfo194= new SimpleWebCommandOperationInfo();
    urlInfo194.setMsgCode(100105);
    urlInfo194.setUrl("/cbhs/tjbb/abnormalFetch");
    urlInfo194.setOpCode("0");
    urlInfo194.setWorkClass("");
    urlInfo194.setMsgReaquest("com.server.pojo.url.tjbb.RequestAbnormalFetch");
    urlInfo194.setReaquestDepict("工程项目ID");
    urlInfo194.setMsgResponse("com.server.pojo.bean.uiAbnormal");
    urlInfo194.setResponseDepict("收支异常信息");
    urlInfo194.setTransation(true);
    urlInfo194.setRestClass("abnormalFetch");
    webCommands.put(urlInfo194.getUrl(),urlInfo194);
    codeOpMap.put(urlInfo194.getMsgCode(),urlInfo194);

    SimpleWebCommandOperationInfo urlInfo195= new SimpleWebCommandOperationInfo();
    urlInfo195.setMsgCode(100106);
    urlInfo195.setUrl("/cbhs/tjbb/zybbAbnormalFetch");
    urlInfo195.setOpCode("0");
    urlInfo195.setWorkClass("");
    urlInfo195.setMsgReaquest("com.server.pojo.url.tjbb.RequestZybbAbnormalFetch");
    urlInfo195.setReaquestDepict("工程项目ID,分包商ID");
    urlInfo195.setMsgResponse("com.server.pojo.bean.uiAbnormal");
    urlInfo195.setResponseDepict("收支异常信息");
    urlInfo195.setTransation(true);
    urlInfo195.setRestClass("zybbAbnormalFetch");
    webCommands.put(urlInfo195.getUrl(),urlInfo195);
    codeOpMap.put(urlInfo195.getMsgCode(),urlInfo195);

    SimpleWebCommandOperationInfo urlInfo196= new SimpleWebCommandOperationInfo();
    urlInfo196.setMsgCode(100107);
    urlInfo196.setUrl("/cbhs/tjbb/cbAnalyze");
    urlInfo196.setOpCode("0");
    urlInfo196.setWorkClass("");
    urlInfo196.setMsgReaquest("com.server.pojo.url.tjbb.RequestCbAnalyze");
    urlInfo196.setReaquestDepict("工程项目ID,开始月份,结束月份");
    urlInfo196.setMsgResponse("com.server.pojo.bean.uiCbAnalyze");
    urlInfo196.setResponseDepict("成本分析");
    urlInfo196.setTransation(true);
    urlInfo196.setRestClass("cbAnalyze");
    webCommands.put(urlInfo196.getUrl(),urlInfo196);
    codeOpMap.put(urlInfo196.getMsgCode(),urlInfo196);

    SimpleWebCommandOperationInfo urlInfo197= new SimpleWebCommandOperationInfo();
    urlInfo197.setMsgCode(100108);
    urlInfo197.setUrl("/cbhs/tjbb/fbCompanyTj");
    urlInfo197.setOpCode("0");
    urlInfo197.setWorkClass("");
    urlInfo197.setMsgReaquest("com.server.pojo.url.tjbb.RequestFbCompanyTj");
    urlInfo197.setReaquestDepict("工程项目ID,开始日期,结束日期,分包商ID,分包工程ID,页码,数量,开始编号");
    urlInfo197.setMsgResponse("com.server.pojo.url.tjbb.ResponseFbCompanyTj");
    urlInfo197.setResponseDepict("分包商统计");
    urlInfo197.setTransation(true);
    urlInfo197.setRestClass("fbCompanyTj");
    webCommands.put(urlInfo197.getUrl(),urlInfo197);
    codeOpMap.put(urlInfo197.getMsgCode(),urlInfo197);

    SimpleWebCommandOperationInfo urlInfo198= new SimpleWebCommandOperationInfo();
    urlInfo198.setMsgCode(80101);
    urlInfo198.setUrl("/cbhs/zytj/zytjFetch");
    urlInfo198.setOpCode("0");
    urlInfo198.setWorkClass("");
    urlInfo198.setMsgReaquest("com.server.pojo.url.zytj.RequestZytjFetch");
    urlInfo198.setReaquestDepict("主键,部门ID,工程项目ID,总工程量ID,分包公司ID,开始日期,结束日期,页码,数量,开始ID");
    urlInfo198.setMsgResponse("com.server.pojo.url.zytj.ResponseZytjFetch");
    urlInfo198.setResponseDepict("资源统计集合,总条数");
    urlInfo198.setTransation(true);
    urlInfo198.setRestClass("zytjFetch");
    webCommands.put(urlInfo198.getUrl(),urlInfo198);
    codeOpMap.put(urlInfo198.getMsgCode(),urlInfo198);

    SimpleWebCommandOperationInfo urlInfo199= new SimpleWebCommandOperationInfo();
    urlInfo199.setMsgCode(80102);
    urlInfo199.setUrl("/cbhs/zytj/zytjUpdate");
    urlInfo199.setOpCode("0");
    urlInfo199.setWorkClass("");
    urlInfo199.setMsgReaquest("com.server.pojo.bean.CbhsZytj");
    urlInfo199.setReaquestDepict("资源统计");
    urlInfo199.setMsgResponse("com.server.pojo.bean.CbhsZytj");
    urlInfo199.setResponseDepict("资源统计");
    urlInfo199.setTransation(true);
    urlInfo199.setRestClass("zytjUpdate");
    webCommands.put(urlInfo199.getUrl(),urlInfo199);
    codeOpMap.put(urlInfo199.getMsgCode(),urlInfo199);

    SimpleWebCommandOperationInfo urlInfo200= new SimpleWebCommandOperationInfo();
    urlInfo200.setMsgCode(80103);
    urlInfo200.setUrl("/cbhs/zytj/zytjDel");
    urlInfo200.setOpCode("0");
    urlInfo200.setWorkClass("");
    urlInfo200.setMsgReaquest("com.server.pojo.url.zytj.RequestZytjDel");
    urlInfo200.setReaquestDepict("资源统计主键集合");
    urlInfo200.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo200.setResponseDepict("响应状态码");
    urlInfo200.setTransation(false);
    urlInfo200.setRestClass("zytjDel");
    webCommands.put(urlInfo200.getUrl(),urlInfo200);
    codeOpMap.put(urlInfo200.getMsgCode(),urlInfo200);

    SimpleWebCommandOperationInfo urlInfo201= new SimpleWebCommandOperationInfo();
    urlInfo201.setMsgCode(80104);
    urlInfo201.setUrl("/cbhs/zytj/zytjAdd");
    urlInfo201.setOpCode("0");
    urlInfo201.setWorkClass("");
    urlInfo201.setMsgReaquest("com.server.pojo.url.zytj.RequestZytjAdd");
    urlInfo201.setReaquestDepict("资源统计,提交方式(0默认提交 1审核提交)");
    urlInfo201.setMsgResponse("com.server.pojo.bean.CbhsZytj");
    urlInfo201.setResponseDepict("资源统计");
    urlInfo201.setTransation(true);
    urlInfo201.setRestClass("zytjAdd");
    webCommands.put(urlInfo201.getUrl(),urlInfo201);
    codeOpMap.put(urlInfo201.getMsgCode(),urlInfo201);

    SimpleWebCommandOperationInfo urlInfo202= new SimpleWebCommandOperationInfo();
    urlInfo202.setMsgCode(80201);
    urlInfo202.setUrl("/cbhs/zytj/zdgxhsFetch");
    urlInfo202.setOpCode("0");
    urlInfo202.setWorkClass("");
    urlInfo202.setMsgReaquest("com.server.pojo.url.zytj.RequestZdgxhsFetch");
    urlInfo202.setReaquestDepict("主键,部门ID,工程项目ID,分包工程量ID,分包公司ID,开始日期,结束日期,页码,数量,开始ID");
    urlInfo202.setMsgResponse("com.server.pojo.url.zytj.ResponseZdgxhsFetch");
    urlInfo202.setResponseDepict("重点工序核算集合,总条数");
    urlInfo202.setTransation(true);
    urlInfo202.setRestClass("zdgxhsFetch");
    webCommands.put(urlInfo202.getUrl(),urlInfo202);
    codeOpMap.put(urlInfo202.getMsgCode(),urlInfo202);

    SimpleWebCommandOperationInfo urlInfo203= new SimpleWebCommandOperationInfo();
    urlInfo203.setMsgCode(80202);
    urlInfo203.setUrl("/cbhs/zytj/zdgxhsUpdate");
    urlInfo203.setOpCode("0");
    urlInfo203.setWorkClass("");
    urlInfo203.setMsgReaquest("com.server.pojo.bean.CbhsZdgxhs");
    urlInfo203.setReaquestDepict("重点工序核算");
    urlInfo203.setMsgResponse("com.server.pojo.bean.CbhsZdgxhs");
    urlInfo203.setResponseDepict("重点工序核算");
    urlInfo203.setTransation(true);
    urlInfo203.setRestClass("zdgxhsUpdate");
    webCommands.put(urlInfo203.getUrl(),urlInfo203);
    codeOpMap.put(urlInfo203.getMsgCode(),urlInfo203);

    SimpleWebCommandOperationInfo urlInfo204= new SimpleWebCommandOperationInfo();
    urlInfo204.setMsgCode(80203);
    urlInfo204.setUrl("/cbhs/zytj/zdgxhsDel");
    urlInfo204.setOpCode("0");
    urlInfo204.setWorkClass("");
    urlInfo204.setMsgReaquest("com.server.pojo.url.zytj.RequestZdgxhsDel");
    urlInfo204.setReaquestDepict("重点工序核算主键集合");
    urlInfo204.setMsgResponse("com.alibaba.fastjson.JSONObject");
    urlInfo204.setResponseDepict("响应状态码");
    urlInfo204.setTransation(false);
    urlInfo204.setRestClass("zdgxhsDel");
    webCommands.put(urlInfo204.getUrl(),urlInfo204);
    codeOpMap.put(urlInfo204.getMsgCode(),urlInfo204);

    SimpleWebCommandOperationInfo urlInfo205= new SimpleWebCommandOperationInfo();
    urlInfo205.setMsgCode(80204);
    urlInfo205.setUrl("/cbhs/zytj/zdgxhsAdd");
    urlInfo205.setOpCode("0");
    urlInfo205.setWorkClass("");
    urlInfo205.setMsgReaquest("com.server.pojo.bean.CbhsZdgxhs");
    urlInfo205.setReaquestDepict("重点工序核算");
    urlInfo205.setMsgResponse("com.server.pojo.bean.CbhsZdgxhs");
    urlInfo205.setResponseDepict("重点工序核算");
    urlInfo205.setTransation(true);
    urlInfo205.setRestClass("zdgxhsAdd");
    webCommands.put(urlInfo205.getUrl(),urlInfo205);
    codeOpMap.put(urlInfo205.getMsgCode(),urlInfo205);

   }
}