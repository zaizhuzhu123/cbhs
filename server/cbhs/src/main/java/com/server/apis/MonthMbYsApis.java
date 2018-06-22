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
import com.server.handler.MonthMbYsApisService;
import com.server.pojo.url.monthMbYs.RequestJjcbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseJjcbYsFetch;
import com.server.pojo.bean.CbhsMonthJjcbYs;
import com.server.pojo.url.monthMbYs.RequestJjcbYsDel;
import com.server.pojo.url.monthMbYs.RequestGlfyYsFetch;
import com.server.pojo.url.monthMbYs.ResponseGlfyYsFetch;
import com.server.pojo.bean.CbhsMonthGlfyYs;
import com.server.pojo.url.monthMbYs.RequestGlfyYsDel;
import com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseZyCailiaoCbYsFetch;
import com.server.pojo.bean.CbhsMonthZyCailiaoCbYs;
import com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsDel;
import com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsAdd;
import com.server.pojo.url.monthMbYs.ResponseZyCailiaoCbYsAdd;
import com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsCailiaoFetch;
import com.server.pojo.url.monthMbYs.ResponseZyCailiaoCbYsCailiaoFetch;
import com.server.pojo.url.monthMbYs.RequestZyLxygCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseZyLxygCbYsFetch;
import com.server.pojo.bean.CbhsMonthZyLxygCbYs;
import com.server.pojo.url.monthMbYs.RequestZyLxygCbYsDel;
import com.server.pojo.url.monthMbYs.RequestZyJxCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseZyJxCbYsFetch;
import com.server.pojo.bean.CbhsMonthZyJxCbYs;
import com.server.pojo.url.monthMbYs.RequestZyJxCbYsDel;
import com.server.pojo.url.monthMbYs.RequestZyQtfyYsFetch;
import com.server.pojo.url.monthMbYs.ResponseZyQtfyYsFetch;
import com.server.pojo.bean.CbhsMonthZyQtfyYs;
import com.server.pojo.url.monthMbYs.RequestZyQtfyYsDel;
import com.server.pojo.url.monthMbYs.RequestFbLjxmCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseFbLjxmCbYsFetch;
import com.server.pojo.bean.CbhsMonthFbLjxmCbYs;
import com.server.pojo.url.monthMbYs.RequestFbLjxmCbYsDel;
import com.server.pojo.url.monthMbYs.RequestFbGcCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseFbGcCbYsFetch;
import com.server.pojo.bean.CbhsMonthFbGcCbYs;
import com.server.pojo.url.monthMbYs.RequestFbGcCbYsDel;
import com.server.pojo.url.monthMbYs.RequestFbGcGlobalXmFetch;
import com.server.pojo.url.monthMbYs.ResponseFbGcGlobalXmFetch;
import com.server.pojo.url.monthMbYs.RequestFbGcFbCompanyFetch;
import com.server.pojo.url.monthMbYs.ResponseFbGcFbCompanyFetch;
import com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseFbCailiaoCbYsFetch;
import com.server.pojo.bean.CbhsMonthFbCailiaoCbYs;
import com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsDel;
import com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsAdd;
import com.server.pojo.url.monthMbYs.ResponseFbCailiaoCbYsAdd;
import com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsCailiaoFetch;
import com.server.pojo.url.monthMbYs.ResponseFbCailiaoCbYsCailiaoFetch;
import com.server.pojo.url.monthMbYs.RequestMbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseMbYsFetch;
import com.server.pojo.url.monthMbYs.RequestMbYsTotalFetch;
import com.server.pojo.url.monthMbYs.ResponseMbYsTotalFetch;

@Api(tags = { "目标预算接口" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class MonthMbYsApis {
	@Autowired
	private MonthMbYsApisService monthMbYsApisService;


	@RequestMapping(value = "/monthMbYs/jjcbYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "间接成本预算-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseJjcbYsFetch jjcbYsFetch(@Validated @RequestBody RequestJjcbYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.jjcbYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/jjcbYsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "间接成本预算-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthJjcbYs jjcbYsUpdate(@Validated @RequestBody CbhsMonthJjcbYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.jjcbYsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/jjcbYsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "间接成本预算-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject jjcbYsDel(@Validated @RequestBody RequestJjcbYsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.jjcbYsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/jjcbYsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "间接成本预算-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthJjcbYs jjcbYsAdd(@Validated @RequestBody CbhsMonthJjcbYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.jjcbYsAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/glfyYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "管理费用预算-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseGlfyYsFetch glfyYsFetch(@Validated @RequestBody RequestGlfyYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.glfyYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/glfyYsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "管理费用预算-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthGlfyYs glfyYsUpdate(@Validated @RequestBody CbhsMonthGlfyYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.glfyYsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/glfyYsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "管理费用预算-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject glfyYsDel(@Validated @RequestBody RequestGlfyYsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.glfyYsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/glfyYsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "管理费用预算-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthGlfyYs glfyYsAdd(@Validated @RequestBody CbhsMonthGlfyYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.glfyYsAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyCailiaoCbYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营材料成本-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyCailiaoCbYsFetch zyCailiaoCbYsFetch(@Validated @RequestBody RequestZyCailiaoCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyCailiaoCbYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyCailiaoCbYsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营材料成本-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthZyCailiaoCbYs zyCailiaoCbYsUpdate(@Validated @RequestBody CbhsMonthZyCailiaoCbYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyCailiaoCbYsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyCailiaoCbYsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营材料成本-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject zyCailiaoCbYsDel(@Validated @RequestBody RequestZyCailiaoCbYsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyCailiaoCbYsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyCailiaoCbYsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营材料成本-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyCailiaoCbYsAdd zyCailiaoCbYsAdd(@Validated @RequestBody RequestZyCailiaoCbYsAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyCailiaoCbYsAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyCailiaoCbYsCailiaoFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营材料成本-材料查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyCailiaoCbYsCailiaoFetch zyCailiaoCbYsCailiaoFetch(@Validated @RequestBody RequestZyCailiaoCbYsCailiaoFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyCailiaoCbYsCailiaoFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyLxygCbYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营零星用工成本-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyLxygCbYsFetch zyLxygCbYsFetch(@Validated @RequestBody RequestZyLxygCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyLxygCbYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyLxygCbYsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营零星用工成本-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthZyLxygCbYs zyLxygCbYsUpdate(@Validated @RequestBody CbhsMonthZyLxygCbYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyLxygCbYsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyLxygCbYsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营零星用工成本-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject zyLxygCbYsDel(@Validated @RequestBody RequestZyLxygCbYsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyLxygCbYsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyLxygCbYsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营零星用工成本-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthZyLxygCbYs zyLxygCbYsAdd(@Validated @RequestBody CbhsMonthZyLxygCbYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyLxygCbYsAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyJxCbYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营机械成本-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyJxCbYsFetch zyJxCbYsFetch(@Validated @RequestBody RequestZyJxCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyJxCbYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyJxCbYsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营机械成本-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthZyJxCbYs zyJxCbYsUpdate(@Validated @RequestBody CbhsMonthZyJxCbYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyJxCbYsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyJxCbYsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营机械成本-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject zyJxCbYsDel(@Validated @RequestBody RequestZyJxCbYsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyJxCbYsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyJxCbYsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营机械成本-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthZyJxCbYs zyJxCbYsAdd(@Validated @RequestBody CbhsMonthZyJxCbYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyJxCbYsAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyQtfyYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营其他费用-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyQtfyYsFetch zyQtfyYsFetch(@Validated @RequestBody RequestZyQtfyYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyQtfyYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyQtfyYsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营其他费用-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthZyQtfyYs zyQtfyYsUpdate(@Validated @RequestBody CbhsMonthZyQtfyYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyQtfyYsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyQtfyYsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营其他费用-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject zyQtfyYsDel(@Validated @RequestBody RequestZyQtfyYsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyQtfyYsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/zyQtfyYsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营其他费用-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthZyQtfyYs zyQtfyYsAdd(@Validated @RequestBody CbhsMonthZyQtfyYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.zyQtfyYsAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbLjxmCbYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包临建项目-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseFbLjxmCbYsFetch fbLjxmCbYsFetch(@Validated @RequestBody RequestFbLjxmCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbLjxmCbYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbLjxmCbYsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包临建项目-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthFbLjxmCbYs fbLjxmCbYsUpdate(@Validated @RequestBody CbhsMonthFbLjxmCbYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbLjxmCbYsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbLjxmCbYsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包临建项目-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject fbLjxmCbYsDel(@Validated @RequestBody RequestFbLjxmCbYsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbLjxmCbYsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbLjxmCbYsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包临建项目-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthFbLjxmCbYs fbLjxmCbYsAdd(@Validated @RequestBody CbhsMonthFbLjxmCbYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbLjxmCbYsAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbGcCbYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包工程-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseFbGcCbYsFetch fbGcCbYsFetch(@Validated @RequestBody RequestFbGcCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbGcCbYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbGcCbYsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包工程-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthFbGcCbYs fbGcCbYsUpdate(@Validated @RequestBody CbhsMonthFbGcCbYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbGcCbYsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbGcCbYsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包工程-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject fbGcCbYsDel(@Validated @RequestBody RequestFbGcCbYsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbGcCbYsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbGcCbYsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包工程-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthFbGcCbYs fbGcCbYsAdd(@Validated @RequestBody CbhsMonthFbGcCbYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbGcCbYsAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbGcGlobalXmFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包工程大项-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseFbGcGlobalXmFetch fbGcGlobalXmFetch(@Validated @RequestBody RequestFbGcGlobalXmFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbGcGlobalXmFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbGcFbCompanyFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包工程分包队-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseFbGcFbCompanyFetch fbGcFbCompanyFetch(@Validated @RequestBody RequestFbGcFbCompanyFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbGcFbCompanyFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbCailiaoCbYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包材料成本-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseFbCailiaoCbYsFetch fbCailiaoCbYsFetch(@Validated @RequestBody RequestFbCailiaoCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbCailiaoCbYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbCailiaoCbYsUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包材料成本-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsMonthFbCailiaoCbYs fbCailiaoCbYsUpdate(@Validated @RequestBody CbhsMonthFbCailiaoCbYs request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbCailiaoCbYsUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbCailiaoCbYsDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包材料成本-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject fbCailiaoCbYsDel(@Validated @RequestBody RequestFbCailiaoCbYsDel request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbCailiaoCbYsDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbCailiaoCbYsAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包材料成本-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseFbCailiaoCbYsAdd fbCailiaoCbYsAdd(@Validated @RequestBody RequestFbCailiaoCbYsAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbCailiaoCbYsAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/fbCailiaoCbYsCailiaoFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包材料成本-材料查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseFbCailiaoCbYsCailiaoFetch fbCailiaoCbYsCailiaoFetch(@Validated @RequestBody RequestFbCailiaoCbYsCailiaoFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.fbCailiaoCbYsCailiaoFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/mbYsFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "目标预算统计(APP汇总)-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseMbYsFetch mbYsFetch(@Validated @RequestBody RequestMbYsFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.mbYsFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/monthMbYs/mbYsTotalFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "目标预算总量统计(WEB汇总)-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseMbYsTotalFetch mbYsTotalFetch(@Validated @RequestBody RequestMbYsTotalFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return monthMbYsApisService.mbYsTotalFetch(request, httpServletRequest);
	}


}
