package com.server.handler;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.server.pojo.bean.CbhsSettleUp;
import com.server.pojo.bean.CbhsSettleUp;
import com.server.pojo.bean.CbhsSettleUp;
import com.server.pojo.bean.CbhsSettleUp;
import com.server.pojo.url.cw.RequestSettlementUpDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.cw.RequestSettlementUpFetch;
import com.server.pojo.url.cw.ResponseSettlementUpFetch;
import com.server.pojo.url.cw.RequestSettlementDownAdd;
import com.server.pojo.bean.CbhsSettleDown;
import com.server.pojo.bean.CbhsSettleDown;
import com.server.pojo.bean.CbhsSettleDown;
import com.server.pojo.url.cw.RequestSettlementDownDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.cw.RequestSettlementDownFetch;
import com.server.pojo.url.cw.ResponseSettlementDownFetch;
import com.server.pojo.bean.CbhsReim;
import com.server.pojo.bean.CbhsReim;
import com.server.pojo.bean.CbhsReim;
import com.server.pojo.bean.CbhsReim;
import com.server.pojo.url.cw.RequestReimDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.cw.RequestReimFetch;
import com.server.pojo.url.cw.ResponseReimFetch;
import com.server.pojo.url.cw.RequestReimShe;
import com.alibaba.fastjson.JSONObject;

public interface CwApisService {

	public CbhsSettleUp settlementUpAdd(CbhsSettleUp request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsSettleUp settlementUpUpdate(CbhsSettleUp request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject settlementUpDel(RequestSettlementUpDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseSettlementUpFetch settlementUpFetch(RequestSettlementUpFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsSettleDown settlementDownAdd(RequestSettlementDownAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsSettleDown settlementDownUpdate(CbhsSettleDown request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject settlementDownDel(RequestSettlementDownDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseSettlementDownFetch settlementDownFetch(RequestSettlementDownFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsReim reimAdd(CbhsReim request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsReim reimUpdate(CbhsReim request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject reimDel(RequestReimDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseReimFetch reimFetch(RequestReimFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject reimShe(RequestReimShe request, HttpServletRequest httpServletRequest) throws Exception;

}
