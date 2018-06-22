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
import com.server.handler.GlobalYsApisService;
import com.server.pojo.url.globalYs.RequestGlobalGclYsFetch;
import com.server.pojo.url.globalYs.ResponseGlobalGclYsFetch;
import com.server.pojo.bean.CbhsGclQdYs;
import com.server.pojo.url.globalYs.RequestGlobalGclYsDel;
import com.server.pojo.url.globalYs.RequestGlobalRcjzhlYsFetch;
import com.server.pojo.url.globalYs.ResponseGlobalRcjzhlYsFetch;
import com.server.pojo.bean.CbhsGlobalRcjzhlYs;
import com.server.pojo.url.globalYs.RequestGlobalRcjzhlYsDel;
import com.server.pojo.url.globalYs.RequestGlobalFyzYsFetch;
import com.server.pojo.url.globalYs.ResponseGlobalFyzYsFetch;
import com.server.pojo.bean.CbhsGlobalFyzYs;
import com.server.pojo.url.globalYs.RequestGlobalFyzYsDel;

@Api(tags = { "全局预算接口" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class GlobalYsApis {
	@Autowired
	private GlobalYsApisService globalYsApisService;


	@RequestMapping(value = "/globalYs/globalGclYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "全局工程量预算-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseGlobalGclYsFetch globalGclYsFetch(@Validated @RequestBody RequestGlobalGclYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalGclYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalGclYsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "全局工程量预算-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsGclQdYs globalGclYsUpdate(@Validated @RequestBody CbhsGclQdYs request, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalGclYsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalGclYsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "全局工程量预算-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject globalGclYsDel(@Validated @RequestBody RequestGlobalGclYsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalGclYsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalGclYsImport", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "全局工程量预算-导入", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject globalGclYsImport(@RequestParam(name = "file", required = true) MultipartFile request,Integer projectOid, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalGclYsImport(request,projectOid, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalGclYsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "全局工程量预算-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsGclQdYs globalGclYsAdd(@Validated @RequestBody CbhsGclQdYs request, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalGclYsAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalRcjzhlYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "人材机总耗量预算-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseGlobalRcjzhlYsFetch globalRcjzhlYsFetch(@Validated @RequestBody RequestGlobalRcjzhlYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalRcjzhlYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalRcjzhlYsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "人材机总耗量预算-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsGlobalRcjzhlYs globalRcjzhlYsUpdate(@Validated @RequestBody CbhsGlobalRcjzhlYs request, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalRcjzhlYsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalRcjzhlYsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "人材机总耗量预算-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject globalRcjzhlYsDel(@Validated @RequestBody RequestGlobalRcjzhlYsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalRcjzhlYsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalRcjzhlYsImport", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "人材机总耗量预算-导入", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject globalRcjzhlYsImport(@RequestParam(name = "file", required = true) MultipartFile request,Integer projectOid, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalRcjzhlYsImport(request,projectOid, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalRcjzhlYsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "人材机总耗量预算-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsGlobalRcjzhlYs globalRcjzhlYsAdd(@Validated @RequestBody CbhsGlobalRcjzhlYs request, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalRcjzhlYsAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalFyzYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "费用总预算-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseGlobalFyzYsFetch globalFyzYsFetch(@Validated @RequestBody RequestGlobalFyzYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalFyzYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalFyzYsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "费用总预算-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsGlobalFyzYs globalFyzYsUpdate(@Validated @RequestBody CbhsGlobalFyzYs request, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalFyzYsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalFyzYsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "费用总预算-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject globalFyzYsDel(@Validated @RequestBody RequestGlobalFyzYsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalFyzYsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalFyzYsImport", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "费用总预算-导入", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject globalFyzYsImport(@RequestParam(name = "file", required = true) MultipartFile request,Integer projectOid, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalFyzYsImport(request,projectOid, httpServletRequest);
	}


	@RequestMapping(value = "/globalYs/globalFyzYsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "费用总预算-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsGlobalFyzYs globalFyzYsAdd(@Validated @RequestBody CbhsGlobalFyzYs request, HttpServletRequest httpServletRequest) throws Exception{
		return globalYsApisService.globalFyzYsAdd(request, httpServletRequest);
	}


}
