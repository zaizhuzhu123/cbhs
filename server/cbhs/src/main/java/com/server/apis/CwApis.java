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
import com.server.handler.CwApisService;
import com.server.pojo.bean.CbhsSettleUp;
import com.server.pojo.url.cw.RequestSettlementUpDel;
import com.server.pojo.url.cw.RequestSettlementUpFetch;
import com.server.pojo.url.cw.ResponseSettlementUpFetch;
import com.server.pojo.url.cw.RequestSettlementDownAdd;
import com.server.pojo.bean.CbhsSettleDown;
import com.server.pojo.url.cw.RequestSettlementDownDel;
import com.server.pojo.url.cw.RequestSettlementDownFetch;
import com.server.pojo.url.cw.ResponseSettlementDownFetch;
import com.server.pojo.bean.CbhsReim;
import com.server.pojo.url.cw.RequestReimDel;
import com.server.pojo.url.cw.RequestReimFetch;
import com.server.pojo.url.cw.ResponseReimFetch;
import com.server.pojo.url.cw.RequestReimShe;

@Api(tags = { "财务接口" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class CwApis {
	@Autowired
	private CwApisService cwApisService;


	@RequestMapping(value = "/cw/settlementUpAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "对上结算-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsSettleUp settlementUpAdd(@Validated @RequestBody CbhsSettleUp request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.settlementUpAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/cw/settlementUpUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "对上结算-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsSettleUp settlementUpUpdate(@Validated @RequestBody CbhsSettleUp request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.settlementUpUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/cw/settlementUpDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "对上结算-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject settlementUpDel(@Validated @RequestBody RequestSettlementUpDel request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.settlementUpDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/cw/settlementUpFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "对上结算-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseSettlementUpFetch settlementUpFetch(@Validated @RequestBody RequestSettlementUpFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.settlementUpFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/cw/settlementDownAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "对下结算-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsSettleDown settlementDownAdd(@Validated @RequestBody RequestSettlementDownAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.settlementDownAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/cw/settlementDownUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "对下结算-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsSettleDown settlementDownUpdate(@Validated @RequestBody CbhsSettleDown request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.settlementDownUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/cw/settlementDownDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "对下结算-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject settlementDownDel(@Validated @RequestBody RequestSettlementDownDel request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.settlementDownDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/cw/settlementDownFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "对下结算-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseSettlementDownFetch settlementDownFetch(@Validated @RequestBody RequestSettlementDownFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.settlementDownFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/cw/reimAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "财务报销-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsReim reimAdd(@Validated @RequestBody CbhsReim request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.reimAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/cw/reimUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "财务报销-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsReim reimUpdate(@Validated @RequestBody CbhsReim request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.reimUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/cw/reimDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "财务报销-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject reimDel(@Validated @RequestBody RequestReimDel request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.reimDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/cw/reimFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "财务报销-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseReimFetch reimFetch(@Validated @RequestBody RequestReimFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.reimFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/cw/reimShe", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "财务报销-审批", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject reimShe(@Validated @RequestBody RequestReimShe request, HttpServletRequest httpServletRequest) throws Exception{
		return cwApisService.reimShe(request, httpServletRequest);
	}


}
