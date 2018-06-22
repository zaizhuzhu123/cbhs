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
import com.server.handler.ZytjApisService;
import com.server.pojo.url.zytj.RequestZytjFetch;
import com.server.pojo.url.zytj.ResponseZytjFetch;
import com.server.pojo.bean.CbhsZytj;
import com.server.pojo.url.zytj.RequestZytjDel;
import com.server.pojo.url.zytj.RequestZytjAdd;
import com.server.pojo.url.zytj.RequestZdgxhsFetch;
import com.server.pojo.url.zytj.ResponseZdgxhsFetch;
import com.server.pojo.bean.CbhsZdgxhs;
import com.server.pojo.url.zytj.RequestZdgxhsDel;

@Api(tags = { "资源统计接口" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class ZytjApis {
	@Autowired
	private ZytjApisService zytjApisService;


	@RequestMapping(value = "/zytj/zytjFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包商统计-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZytjFetch zytjFetch(@Validated @RequestBody RequestZytjFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return zytjApisService.zytjFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/zytj/zytjUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包商统计-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsZytj zytjUpdate(@Validated @RequestBody CbhsZytj request, HttpServletRequest httpServletRequest) throws Exception{
		return zytjApisService.zytjUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/zytj/zytjDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包商统计-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject zytjDel(@Validated @RequestBody RequestZytjDel request, HttpServletRequest httpServletRequest) throws Exception{
		return zytjApisService.zytjDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/zytj/zytjAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包商统计-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsZytj zytjAdd(@Validated @RequestBody RequestZytjAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return zytjApisService.zytjAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/zytj/zdgxhsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "重点工序核算-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZdgxhsFetch zdgxhsFetch(@Validated @RequestBody RequestZdgxhsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return zytjApisService.zdgxhsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/zytj/zdgxhsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "重点工序核算-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsZdgxhs zdgxhsUpdate(@Validated @RequestBody CbhsZdgxhs request, HttpServletRequest httpServletRequest) throws Exception{
		return zytjApisService.zdgxhsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/zytj/zdgxhsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "重点工序核算-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject zdgxhsDel(@Validated @RequestBody RequestZdgxhsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return zytjApisService.zdgxhsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/zytj/zdgxhsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "重点工序核算-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsZdgxhs zdgxhsAdd(@Validated @RequestBody CbhsZdgxhs request, HttpServletRequest httpServletRequest) throws Exception{
		return zytjApisService.zdgxhsAdd(request, httpServletRequest);
	}


}
