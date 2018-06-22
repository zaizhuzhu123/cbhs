package com.server.apis;

import com.server.pojo.url.*;
import javax.servlet.http.HttpServletRequest;
import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.server.handler.CbsheApisService;
import com.server.pojo.bean.CbhsCbExaminerRule;
import com.server.pojo.url.cbshe.RequestExaminerRuleDel;
import com.server.pojo.url.cbshe.RequestExaminerRuleFetch;
import com.server.pojo.url.cbshe.ResponseExaminerRuleFetch;
import com.server.pojo.url.cbshe.RequestExamCb;
import com.server.pojo.url.cbshe.RequestExamTaskFetch;
import com.server.pojo.url.cbshe.ResponseExamTaskFetch;
import com.server.pojo.url.cbshe.RequestExamTaskStepFetch;
import com.server.pojo.url.cbshe.ResponseExamTaskStepFetch;
import com.server.pojo.url.cbshe.RequestExamMyCreateTaskFetch;
import com.server.pojo.url.cbshe.ResponseExamMyCreateTaskFetch;
import com.server.pojo.url.cbshe.RequestCancelExam;

@Api(tags = { "成本审核接口" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class CbsheApis {
	@Autowired
	private CbsheApisService cbsheApisService;


	@RequestMapping(value = "/cbshe/examinerRuleAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "审核规则-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsCbExaminerRule examinerRuleAdd(@Validated @RequestBody CbhsCbExaminerRule request, HttpServletRequest httpServletRequest) throws Exception{
		return cbsheApisService.examinerRuleAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/cbshe/examinerRuleUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "审核规则-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsCbExaminerRule examinerRuleUpdate(@Validated @RequestBody CbhsCbExaminerRule request, HttpServletRequest httpServletRequest) throws Exception{
		return cbsheApisService.examinerRuleUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/cbshe/examinerRuleDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "审核规则-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject examinerRuleDel(@Validated @RequestBody RequestExaminerRuleDel request, HttpServletRequest httpServletRequest) throws Exception{
		return cbsheApisService.examinerRuleDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/cbshe/examinerRuleFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "审核规则-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseExaminerRuleFetch examinerRuleFetch(@Validated @RequestBody RequestExaminerRuleFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return cbsheApisService.examinerRuleFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/cbshe/examCb", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "审核任务-审核", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject examCb(@Validated @RequestBody RequestExamCb request, HttpServletRequest httpServletRequest) throws Exception{
		return cbsheApisService.examCb(request, httpServletRequest);
	}


	@RequestMapping(value = "/cbshe/examTaskFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "审核任务-查询（作为审核人）", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseExamTaskFetch examTaskFetch(@Validated @RequestBody RequestExamTaskFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return cbsheApisService.examTaskFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/cbshe/examTaskStepFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "审核任务-流程查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseExamTaskStepFetch examTaskStepFetch(@Validated @RequestBody RequestExamTaskStepFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return cbsheApisService.examTaskStepFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/cbshe/examMyCreateTaskFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "审核任务-我的审核请求", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseExamMyCreateTaskFetch examMyCreateTaskFetch(@Validated @RequestBody RequestExamMyCreateTaskFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return cbsheApisService.examMyCreateTaskFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/cbshe/cancelExam", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "审核任务-撤销审核", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject cancelExam(@Validated @RequestBody RequestCancelExam request, HttpServletRequest httpServletRequest) throws Exception{
		return cbsheApisService.cancelExam(request, httpServletRequest);
	}


}
