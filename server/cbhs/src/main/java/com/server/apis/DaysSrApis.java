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
import com.server.handler.DaysSrApisService;
import com.server.pojo.url.daysSr.RequestGcsrFetch;
import com.server.pojo.url.daysSr.ResponseGcsrFetch;
import com.server.pojo.bean.CbhsDaysGclSr;
import com.server.pojo.url.daysSr.RequestGcsrDel;
import com.server.pojo.url.daysSr.RequestGcsrAdd;
import com.server.pojo.url.daysSr.ResponseGcsrAdd;
import com.server.pojo.url.daysSr.RequestNewsrFetch;
import com.server.pojo.url.daysSr.ResponseNewsrFetch;
import com.server.pojo.bean.CbhsDaysQtSr;
import com.server.pojo.url.daysSr.RequestNewsrDel;
import com.server.pojo.url.daysSr.RequestNewsrAddPrice;

@Api(tags = { "收入统计接口" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class DaysSrApis {
	@Autowired
	private DaysSrApisService daysSrApisService;


	@RequestMapping(value = "/daysSr/gcsrFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "工程收入-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseGcsrFetch gcsrFetch(@Validated @RequestBody RequestGcsrFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return daysSrApisService.gcsrFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysSr/gcsrUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "工程收入-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysGclSr gcsrUpdate(@Validated @RequestBody CbhsDaysGclSr request, HttpServletRequest httpServletRequest) throws Exception{
		return daysSrApisService.gcsrUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysSr/gcsrDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "工程收入-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject gcsrDel(@Validated @RequestBody RequestGcsrDel request, HttpServletRequest httpServletRequest) throws Exception{
		return daysSrApisService.gcsrDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysSr/gcsrAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "工程收入-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseGcsrAdd gcsrAdd(@Validated @RequestBody RequestGcsrAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return daysSrApisService.gcsrAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysSr/newsrFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "新增收入-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseNewsrFetch newsrFetch(@Validated @RequestBody RequestNewsrFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return daysSrApisService.newsrFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysSr/newsrUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "新增收入-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysQtSr newsrUpdate(@Validated @RequestBody CbhsDaysQtSr request, HttpServletRequest httpServletRequest) throws Exception{
		return daysSrApisService.newsrUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysSr/newsrDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "新增收入-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject newsrDel(@Validated @RequestBody RequestNewsrDel request, HttpServletRequest httpServletRequest) throws Exception{
		return daysSrApisService.newsrDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysSr/newsrAddCount", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "新增收入-新增数量", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysQtSr newsrAddCount(@Validated @RequestBody CbhsDaysQtSr request, HttpServletRequest httpServletRequest) throws Exception{
		return daysSrApisService.newsrAddCount(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysSr/newsrAddPrice", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "新增收入-新增价格", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysQtSr newsrAddPrice(@Validated @RequestBody RequestNewsrAddPrice request, HttpServletRequest httpServletRequest) throws Exception{
		return daysSrApisService.newsrAddPrice(request, httpServletRequest);
	}


}
