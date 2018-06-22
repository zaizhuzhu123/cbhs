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
import com.server.handler.ClhxApisService;
import com.server.pojo.url.clhx.RequestZyGclFetch;
import com.server.pojo.url.clhx.ResponseZyGclFetch;
import com.server.pojo.url.clhx.RequestZyClhxFetch;
import com.server.pojo.url.clhx.ResponseZyClhxFetch;
import com.server.pojo.url.clhx.RequestFbGclFetch;
import com.server.pojo.url.clhx.ResponseFbGclFetch;
import com.server.pojo.url.clhx.RequestFbClhxFetch;
import com.server.pojo.url.clhx.ResponseFbClhxFetch;

@Api(tags = { "材料核销接口" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class ClhxApis {
	@Autowired
	private ClhxApisService clhxApisService;


	@RequestMapping(value = "/clhx/zyGclFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营材料核销-工程项查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyGclFetch zyGclFetch(@Validated @RequestBody RequestZyGclFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return clhxApisService.zyGclFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/clhx/zyClhxFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营材料核销-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyClhxFetch zyClhxFetch(@Validated @RequestBody RequestZyClhxFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return clhxApisService.zyClhxFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/clhx/fbGclFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包材料核销-工程项查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseFbGclFetch fbGclFetch(@Validated @RequestBody RequestFbGclFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return clhxApisService.fbGclFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/clhx/fbClhxFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包材料核销-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseFbClhxFetch fbClhxFetch(@Validated @RequestBody RequestFbClhxFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return clhxApisService.fbClhxFetch(request, httpServletRequest);
	}


}
