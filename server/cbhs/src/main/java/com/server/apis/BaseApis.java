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
import com.server.handler.BaseApisService;
import com.server.pojo.bean.CbhsProject;
import com.server.pojo.url.base.RequestProjectFetch;
import com.server.pojo.url.base.ResponseProjectFetch;
import com.server.pojo.bean.CbhsCailiao;
import com.server.pojo.url.base.RequestCailiaoDel;
import com.server.pojo.url.base.RequestCailiaoFetch;
import com.server.pojo.url.base.ResponseCailiaoFetch;
import com.server.pojo.bean.CbhsCailiaoKemu;
import com.server.pojo.url.base.RequestCailiaoKemuDel;
import com.server.pojo.url.base.RequestCailiaoKemuFetch;
import com.server.pojo.url.base.ResponseCailiaoKemuFetch;
import com.server.pojo.bean.CbhsFbCompany;
import com.server.pojo.url.base.RequestFbCompanyDel;
import com.server.pojo.url.base.RequestFbCompanyFetch;
import com.server.pojo.url.base.ResponseFbCompanyFetch;
import com.server.pojo.bean.CbhsMachineryType;
import com.server.pojo.url.base.RequestMachineryTypeDel;
import com.server.pojo.url.base.RequestMachineryTypeFetch;
import com.server.pojo.url.base.ResponseMachineryTypeFetch;
import com.server.pojo.bean.CbhsMachinery;
import com.server.pojo.url.base.RequestMachineryDel;
import com.server.pojo.url.base.RequestMachineryFetch;
import com.server.pojo.url.base.ResponseMachineryFetch;
import com.server.pojo.bean.CbhsGlfyRule;
import com.server.pojo.url.base.RequestCbhsGlfyRuleFetch;
import com.server.pojo.bean.CbhsGz;
import com.server.pojo.url.base.RequestGzDel;
import com.server.pojo.url.base.RequestGzFetch;
import com.server.pojo.url.base.ResponseGzFetch;
import com.server.pojo.bean.CbhsHt;
import com.server.pojo.url.base.RequestHtDel;
import com.server.pojo.url.base.RequestHtFetch;
import com.server.pojo.url.base.ResponseHtFetch;
import com.server.pojo.bean.CbhsContacts;
import com.server.pojo.url.base.RequestContactsDel;
import com.server.pojo.url.base.RequestContactsFetch;
import com.server.pojo.url.base.ResponseContactsFetch;

@Api(tags = { "基础信息接口" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class BaseApis {
	@Autowired
	private BaseApisService baseApisService;


	@RequestMapping(value = "/base/projectAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "工程项目-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsProject projectAdd(@Validated @RequestBody CbhsProject request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.projectAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/projectUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "工程项目-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsProject projectUpdate(@Validated @RequestBody CbhsProject request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.projectUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/projectFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "工程项目-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseProjectFetch projectFetch(@Validated @RequestBody RequestProjectFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.projectFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/cailiaoAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "材料-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsCailiao cailiaoAdd(@Validated @RequestBody CbhsCailiao request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.cailiaoAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/cailiaoUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "材料-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsCailiao cailiaoUpdate(@Validated @RequestBody CbhsCailiao request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.cailiaoUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/cailiaoDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "材料-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject cailiaoDel(@Validated @RequestBody RequestCailiaoDel request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.cailiaoDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/cailiaoFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "材料-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseCailiaoFetch cailiaoFetch(@Validated @RequestBody RequestCailiaoFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.cailiaoFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/cailiaoImport", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "材料-导入", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject cailiaoImport(@RequestParam(name = "file", required = true) MultipartFile request,Integer projectOid, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.cailiaoImport(request,projectOid, httpServletRequest);
	}


	@RequestMapping(value = "/base/cailiaoKemuAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "材料科目-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsCailiaoKemu cailiaoKemuAdd(@Validated @RequestBody CbhsCailiaoKemu request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.cailiaoKemuAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/cailiaoKemuUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "材料科目-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsCailiaoKemu cailiaoKemuUpdate(@Validated @RequestBody CbhsCailiaoKemu request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.cailiaoKemuUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/cailiaoKemuDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "材料科目-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject cailiaoKemuDel(@Validated @RequestBody RequestCailiaoKemuDel request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.cailiaoKemuDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/cailiaoKemuFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "材料科目-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseCailiaoKemuFetch cailiaoKemuFetch(@Validated @RequestBody RequestCailiaoKemuFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.cailiaoKemuFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/fbCompanyAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包公司-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsFbCompany fbCompanyAdd(@Validated @RequestBody CbhsFbCompany request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.fbCompanyAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/fbCompanyUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包公司-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsFbCompany fbCompanyUpdate(@Validated @RequestBody CbhsFbCompany request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.fbCompanyUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/fbCompanyDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包公司-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject fbCompanyDel(@Validated @RequestBody RequestFbCompanyDel request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.fbCompanyDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/fbCompanyFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包公司-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseFbCompanyFetch fbCompanyFetch(@Validated @RequestBody RequestFbCompanyFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.fbCompanyFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/machineryTypeAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "机械设备种类-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMachineryType machineryTypeAdd(@Validated @RequestBody CbhsMachineryType request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.machineryTypeAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/machineryTypeUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "机械设备种类-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMachineryType machineryTypeUpdate(@Validated @RequestBody CbhsMachineryType request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.machineryTypeUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/machineryTypeDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "机械设备种类-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject machineryTypeDel(@Validated @RequestBody RequestMachineryTypeDel request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.machineryTypeDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/machineryTypeFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "机械设备种类-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseMachineryTypeFetch machineryTypeFetch(@Validated @RequestBody RequestMachineryTypeFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.machineryTypeFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/machineryAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "机械设备-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMachinery machineryAdd(@Validated @RequestBody CbhsMachinery request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.machineryAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/machineryUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "机械设备-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMachinery machineryUpdate(@Validated @RequestBody CbhsMachinery request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.machineryUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/machineryDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "机械设备-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject machineryDel(@Validated @RequestBody RequestMachineryDel request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.machineryDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/machineryFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "机械设备-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseMachineryFetch machineryFetch(@Validated @RequestBody RequestMachineryFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.machineryFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/cbhsGlfyRuleAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "管理费用上缴公式-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject cbhsGlfyRuleAdd(@Validated @RequestBody CbhsGlfyRule request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.cbhsGlfyRuleAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/cbhsGlfyRuleUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "管理费用上缴公式-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject cbhsGlfyRuleUpdate(@Validated @RequestBody CbhsGlfyRule request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.cbhsGlfyRuleUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/cbhsGlfyRuleFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "管理费用上缴公式-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsGlfyRule cbhsGlfyRuleFetch(@Validated @RequestBody RequestCbhsGlfyRuleFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.cbhsGlfyRuleFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/gzAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "工种-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsGz gzAdd(@Validated @RequestBody CbhsGz request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.gzAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/gzUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "工种-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsGz gzUpdate(@Validated @RequestBody CbhsGz request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.gzUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/gzDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "工种-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject gzDel(@Validated @RequestBody RequestGzDel request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.gzDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/gzFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "工种-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseGzFetch gzFetch(@Validated @RequestBody RequestGzFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.gzFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/htAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "合同-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsHt htAdd(@Validated @RequestBody CbhsHt request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.htAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/htUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "合同-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsHt htUpdate(@Validated @RequestBody CbhsHt request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.htUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/htDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "合同-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject htDel(@Validated @RequestBody RequestHtDel request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.htDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/htFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "合同-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseHtFetch htFetch(@Validated @RequestBody RequestHtFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.htFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/contactsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "通讯录-创建联系人", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsContacts contactsAdd(@Validated @RequestBody CbhsContacts request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.contactsAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/contactsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "通讯录-修改联系人", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsContacts contactsUpdate(@Validated @RequestBody CbhsContacts request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.contactsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/contactsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "通讯录-删除联系人", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject contactsDel(@Validated @RequestBody RequestContactsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.contactsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/contactsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "通讯录-查询联系人", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseContactsFetch contactsFetch(@Validated @RequestBody RequestContactsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.contactsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/base/contactsImport", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "通讯录-导入联系人", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject contactsImport(@RequestParam(name = "file", required = true) MultipartFile request,Integer projectOid, HttpServletRequest httpServletRequest) throws Exception{
		return baseApisService.contactsImport(request,projectOid, httpServletRequest);
	}


}
