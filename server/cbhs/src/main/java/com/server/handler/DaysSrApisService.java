package com.server.handler;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.server.pojo.url.daysSr.RequestGcsrFetch;
import com.server.pojo.url.daysSr.ResponseGcsrFetch;
import com.server.pojo.bean.CbhsDaysGclSr;
import com.server.pojo.bean.CbhsDaysGclSr;
import com.server.pojo.url.daysSr.RequestGcsrDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.daysSr.RequestGcsrAdd;
import com.server.pojo.url.daysSr.ResponseGcsrAdd;
import com.server.pojo.url.daysSr.RequestNewsrFetch;
import com.server.pojo.url.daysSr.ResponseNewsrFetch;
import com.server.pojo.bean.CbhsDaysQtSr;
import com.server.pojo.bean.CbhsDaysQtSr;
import com.server.pojo.url.daysSr.RequestNewsrDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsDaysQtSr;
import com.server.pojo.bean.CbhsDaysQtSr;
import com.server.pojo.url.daysSr.RequestNewsrAddPrice;
import com.server.pojo.bean.CbhsDaysQtSr;

public interface DaysSrApisService {

	public ResponseGcsrFetch gcsrFetch(RequestGcsrFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysGclSr gcsrUpdate(CbhsDaysGclSr request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject gcsrDel(RequestGcsrDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseGcsrAdd gcsrAdd(RequestGcsrAdd request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseNewsrFetch newsrFetch(RequestNewsrFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysQtSr newsrUpdate(CbhsDaysQtSr request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject newsrDel(RequestNewsrDel request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysQtSr newsrAddCount(CbhsDaysQtSr request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsDaysQtSr newsrAddPrice(RequestNewsrAddPrice request, HttpServletRequest httpServletRequest) throws Exception;

}
