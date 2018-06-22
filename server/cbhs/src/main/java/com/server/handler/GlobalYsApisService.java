package com.server.handler;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.server.pojo.url.globalYs.RequestGlobalGclYsFetch;
import com.server.pojo.url.globalYs.ResponseGlobalGclYsFetch;
import com.server.pojo.bean.CbhsGclQdYs;
import com.server.pojo.bean.CbhsGclQdYs;
import com.server.pojo.url.globalYs.RequestGlobalGclYsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsGclQdYs;
import com.server.pojo.bean.CbhsGclQdYs;
import com.server.pojo.url.globalYs.RequestGlobalRcjzhlYsFetch;
import com.server.pojo.url.globalYs.ResponseGlobalRcjzhlYsFetch;
import com.server.pojo.bean.CbhsGlobalRcjzhlYs;
import com.server.pojo.bean.CbhsGlobalRcjzhlYs;
import com.server.pojo.url.globalYs.RequestGlobalRcjzhlYsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsGlobalRcjzhlYs;
import com.server.pojo.bean.CbhsGlobalRcjzhlYs;
import com.server.pojo.url.globalYs.RequestGlobalFyzYsFetch;
import com.server.pojo.url.globalYs.ResponseGlobalFyzYsFetch;
import com.server.pojo.bean.CbhsGlobalFyzYs;
import com.server.pojo.bean.CbhsGlobalFyzYs;
import com.server.pojo.url.globalYs.RequestGlobalFyzYsDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.bean.CbhsGlobalFyzYs;
import com.server.pojo.bean.CbhsGlobalFyzYs;

public interface GlobalYsApisService {

	public ResponseGlobalGclYsFetch globalGclYsFetch(RequestGlobalGclYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsGclQdYs globalGclYsUpdate(CbhsGclQdYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject globalGclYsDel(RequestGlobalGclYsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject globalGclYsImport(MultipartFile request,Integer projectOid, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsGclQdYs globalGclYsAdd(CbhsGclQdYs request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseGlobalRcjzhlYsFetch globalRcjzhlYsFetch(RequestGlobalRcjzhlYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsGlobalRcjzhlYs globalRcjzhlYsUpdate(CbhsGlobalRcjzhlYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject globalRcjzhlYsDel(RequestGlobalRcjzhlYsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject globalRcjzhlYsImport(MultipartFile request,Integer projectOid, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsGlobalRcjzhlYs globalRcjzhlYsAdd(CbhsGlobalRcjzhlYs request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseGlobalFyzYsFetch globalFyzYsFetch(RequestGlobalFyzYsFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsGlobalFyzYs globalFyzYsUpdate(CbhsGlobalFyzYs request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject globalFyzYsDel(RequestGlobalFyzYsDel request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject globalFyzYsImport(MultipartFile request,Integer projectOid, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsGlobalFyzYs globalFyzYsAdd(CbhsGlobalFyzYs request, HttpServletRequest httpServletRequest) throws Exception;

}
