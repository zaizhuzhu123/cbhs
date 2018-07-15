package com.server.handler;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.server.pojo.url.tjbb.RequestCbsrbb;
import com.server.pojo.url.tjbb.ResponseCbsrbb;
import com.server.pojo.url.tjbb.RequestZybb;
import com.server.pojo.url.tjbb.ResponseZybb;
import com.server.pojo.url.tjbb.RequestDaysDetails;
import com.server.pojo.bean.uiDaysCbDetailTj;
import com.server.pojo.url.tjbb.RequestGrandTotal;
import com.server.pojo.bean.uiGrandTotalTj;
import com.server.pojo.url.tjbb.RequestAbnormalFetch;
import com.server.pojo.bean.uiAbnormal;
import com.server.pojo.url.tjbb.RequestZybbAbnormalFetch;
import com.server.pojo.bean.uiAbnormal;
import com.server.pojo.url.tjbb.RequestCbAnalyze;
import com.server.pojo.bean.uiCbAnalyze;
import com.server.pojo.url.tjbb.RequestFbCompanyTj;
import com.server.pojo.url.tjbb.ResponseFbCompanyTj;

public interface TjbbApisService {

	public ResponseCbsrbb cbsrbb(RequestCbsrbb request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseZybb zybb(RequestZybb request, HttpServletRequest httpServletRequest) throws Exception;

	public uiDaysCbDetailTj daysDetails(RequestDaysDetails request, HttpServletRequest httpServletRequest) throws Exception;

	public uiGrandTotalTj grandTotal(RequestGrandTotal request, HttpServletRequest httpServletRequest) throws Exception;

	public uiAbnormal abnormalFetch(RequestAbnormalFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public uiAbnormal zybbAbnormalFetch(RequestZybbAbnormalFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public uiCbAnalyze cbAnalyze(RequestCbAnalyze request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseFbCompanyTj fbCompanyTj(RequestFbCompanyTj request, HttpServletRequest httpServletRequest) throws Exception;

}
