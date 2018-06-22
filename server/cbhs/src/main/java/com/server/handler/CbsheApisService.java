package com.server.handler;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;
import com.server.pojo.bean.CbhsCbExaminerRule;
import com.server.pojo.bean.CbhsCbExaminerRule;
import com.server.pojo.bean.CbhsCbExaminerRule;
import com.server.pojo.bean.CbhsCbExaminerRule;
import com.server.pojo.url.cbshe.RequestExaminerRuleDel;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.cbshe.RequestExaminerRuleFetch;
import com.server.pojo.url.cbshe.ResponseExaminerRuleFetch;
import com.server.pojo.url.cbshe.RequestExamCb;
import com.alibaba.fastjson.JSONObject;
import com.server.pojo.url.cbshe.RequestExamTaskFetch;
import com.server.pojo.url.cbshe.ResponseExamTaskFetch;
import com.server.pojo.url.cbshe.RequestExamTaskStepFetch;
import com.server.pojo.url.cbshe.ResponseExamTaskStepFetch;
import com.server.pojo.url.cbshe.RequestExamMyCreateTaskFetch;
import com.server.pojo.url.cbshe.ResponseExamMyCreateTaskFetch;
import com.server.pojo.url.cbshe.RequestCancelExam;
import com.alibaba.fastjson.JSONObject;

public interface CbsheApisService {

	public CbhsCbExaminerRule examinerRuleAdd(CbhsCbExaminerRule request, HttpServletRequest httpServletRequest) throws Exception;

	public CbhsCbExaminerRule examinerRuleUpdate(CbhsCbExaminerRule request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject examinerRuleDel(RequestExaminerRuleDel request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseExaminerRuleFetch examinerRuleFetch(RequestExaminerRuleFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject examCb(RequestExamCb request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseExamTaskFetch examTaskFetch(RequestExamTaskFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseExamTaskStepFetch examTaskStepFetch(RequestExamTaskStepFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public ResponseExamMyCreateTaskFetch examMyCreateTaskFetch(RequestExamMyCreateTaskFetch request, HttpServletRequest httpServletRequest) throws Exception;

	public JSONObject cancelExam(RequestCancelExam request, HttpServletRequest httpServletRequest) throws Exception;

}
