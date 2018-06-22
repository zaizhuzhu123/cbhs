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
import com.server.handler.DaysCbApisService;
import com.server.pojo.url.daysCb.RequestJjcbFetch;
import com.server.pojo.url.daysCb.ResponseJjcbFetch;
import com.server.pojo.bean.CbhsDaysJjcb;
import com.server.pojo.url.daysCb.RequestJjcbDel;
import com.server.pojo.url.daysCb.RequestJjcbAdd;
import com.server.pojo.url.daysCb.RequestGlfyFetch;
import com.server.pojo.url.daysCb.ResponseGlfyFetch;
import com.server.pojo.bean.CbhsDaysGlfyYs;
import com.server.pojo.url.daysCb.RequestGlfyDel;
import com.server.pojo.url.daysCb.RequestGlfyAdd;
import com.server.pojo.url.daysCb.RequestTodayFetch;
import com.server.pojo.url.daysCb.RequestZyLxygCbFetch;
import com.server.pojo.url.daysCb.ResponseZyLxygCbFetch;
import com.server.pojo.bean.CbhsDaysZyLxygCb;
import com.server.pojo.url.daysCb.RequestZyLxygCbDel;
import com.server.pojo.url.daysCb.RequestZyLxygCbAdd;
import com.server.pojo.url.daysCb.RequestZyJxCbFetch;
import com.server.pojo.url.daysCb.ResponseZyJxCbFetch;
import com.server.pojo.bean.CbhsDaysZyJxCb;
import com.server.pojo.url.daysCb.RequestZyJxCbDel;
import com.server.pojo.url.daysCb.RequestZyJxCbAdd;
import com.server.pojo.url.daysCb.RequestZyQtCbFetch;
import com.server.pojo.url.daysCb.ResponseZyQtCbFetch;
import com.server.pojo.bean.CbhsDaysZyQtCb;
import com.server.pojo.url.daysCb.RequestZyQtCbDel;
import com.server.pojo.url.daysCb.RequestZyQtCbAdd;
import com.server.pojo.url.daysCb.RequestZyCailiaoCbFetch;
import com.server.pojo.url.daysCb.ResponseZyCailiaoCbFetch;
import com.server.pojo.bean.CbhsDaysZyCailiaoCb;
import com.server.pojo.url.daysCb.RequestZyCailiaoCbDel;
import com.server.pojo.url.daysCb.RequestZyCailiaoCbAdd;
import com.server.pojo.url.daysCb.ResponseZyCailiaoCbAdd;
import com.server.pojo.url.daysCb.RequestFbGclTjCbFetch;
import com.server.pojo.url.daysCb.ResponseFbGclTjCbFetch;
import com.server.pojo.bean.CbhsDaysFbGclTj;
import com.server.pojo.url.daysCb.RequestFbGclTjCbDel;
import com.server.pojo.url.daysCb.RequestFbGclTjCbAdd;
import com.server.pojo.url.daysCb.RequestFbLjxmCbFetch;
import com.server.pojo.url.daysCb.ResponseFbLjxmCbFetch;
import com.server.pojo.bean.CbhsDaysFbLjxmCb;
import com.server.pojo.url.daysCb.RequestFbLjxmCbDel;
import com.server.pojo.url.daysCb.RequestFbLjxmCbAdd;
import com.server.pojo.url.daysCb.RequestFbJgUpdate;
import com.server.pojo.url.daysCb.RequestFbJgAdd;

@Api(tags = { "每日成本接口" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class DaysCbApis {
	@Autowired
	private DaysCbApisService daysCbApisService;


	@RequestMapping(value = "/daysCb/jjcbFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "间接成本预算-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseJjcbFetch jjcbFetch(@Validated @RequestBody RequestJjcbFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.jjcbFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/jjcbUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "间接成本预算-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysJjcb jjcbUpdate(@Validated @RequestBody CbhsDaysJjcb request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.jjcbUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/jjcbDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "间接成本预算-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject jjcbDel(@Validated @RequestBody RequestJjcbDel request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.jjcbDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/jjcbAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "间接成本预算-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysJjcb jjcbAdd(@Validated @RequestBody RequestJjcbAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.jjcbAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/glfyFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "管理费用预算-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseGlfyFetch glfyFetch(@Validated @RequestBody RequestGlfyFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.glfyFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/glfyUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "管理费用预算-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysGlfyYs glfyUpdate(@Validated @RequestBody CbhsDaysGlfyYs request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.glfyUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/glfyDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "管理费用预算-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject glfyDel(@Validated @RequestBody RequestGlfyDel request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.glfyDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/glfyAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "管理费用预算-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysGlfyYs glfyAdd(@Validated @RequestBody RequestGlfyAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.glfyAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/todayFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "管理费用-今日应缴查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysGlfyYs todayFetch(@Validated @RequestBody RequestTodayFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.todayFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyLxygCbFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营零星用工成本-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyLxygCbFetch zyLxygCbFetch(@Validated @RequestBody RequestZyLxygCbFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyLxygCbFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyLxygCbUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营零星用工成本-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysZyLxygCb zyLxygCbUpdate(@Validated @RequestBody CbhsDaysZyLxygCb request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyLxygCbUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyLxygCbDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营零星用工成本-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject zyLxygCbDel(@Validated @RequestBody RequestZyLxygCbDel request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyLxygCbDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyLxygCbAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营零星用工成本-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysZyLxygCb zyLxygCbAdd(@Validated @RequestBody RequestZyLxygCbAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyLxygCbAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyJxCbFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营机械成本-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyJxCbFetch zyJxCbFetch(@Validated @RequestBody RequestZyJxCbFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyJxCbFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyJxCbUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营机械成本-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysZyJxCb zyJxCbUpdate(@Validated @RequestBody CbhsDaysZyJxCb request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyJxCbUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyJxCbDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营机械成本-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject zyJxCbDel(@Validated @RequestBody RequestZyJxCbDel request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyJxCbDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyJxCbAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营机械成本-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysZyJxCb zyJxCbAdd(@Validated @RequestBody RequestZyJxCbAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyJxCbAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyQtCbFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营其他成本-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyQtCbFetch zyQtCbFetch(@Validated @RequestBody RequestZyQtCbFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyQtCbFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyQtCbUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营其他成本-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysZyQtCb zyQtCbUpdate(@Validated @RequestBody CbhsDaysZyQtCb request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyQtCbUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyQtCbDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营其他成本-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject zyQtCbDel(@Validated @RequestBody RequestZyQtCbDel request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyQtCbDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyQtCbAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营其他成本-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysZyQtCb zyQtCbAdd(@Validated @RequestBody RequestZyQtCbAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyQtCbAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyCailiaoCbFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营材料成本-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyCailiaoCbFetch zyCailiaoCbFetch(@Validated @RequestBody RequestZyCailiaoCbFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyCailiaoCbFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyCailiaoCbUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营材料成本-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysZyCailiaoCb zyCailiaoCbUpdate(@Validated @RequestBody CbhsDaysZyCailiaoCb request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyCailiaoCbUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyCailiaoCbDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营材料成本-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject zyCailiaoCbDel(@Validated @RequestBody RequestZyCailiaoCbDel request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyCailiaoCbDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/zyCailiaoCbAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "自营材料成本-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseZyCailiaoCbAdd zyCailiaoCbAdd(@Validated @RequestBody RequestZyCailiaoCbAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.zyCailiaoCbAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/fbGclTjCbFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包工程量-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseFbGclTjCbFetch fbGclTjCbFetch(@Validated @RequestBody RequestFbGclTjCbFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.fbGclTjCbFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/fbGclTjCbUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包工程量-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysFbGclTj fbGclTjCbUpdate(@Validated @RequestBody CbhsDaysFbGclTj request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.fbGclTjCbUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/fbGclTjCbDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包工程量-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject fbGclTjCbDel(@Validated @RequestBody RequestFbGclTjCbDel request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.fbGclTjCbDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/fbGclTjCbAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包工程量-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysFbGclTj fbGclTjCbAdd(@Validated @RequestBody RequestFbGclTjCbAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.fbGclTjCbAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/fbLjxmCbFetch", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包临建项目-查询", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public ResponseFbLjxmCbFetch fbLjxmCbFetch(@Validated @RequestBody RequestFbLjxmCbFetch request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.fbLjxmCbFetch(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/fbLjxmCbUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包临建项目-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysFbLjxmCb fbLjxmCbUpdate(@Validated @RequestBody CbhsDaysFbLjxmCb request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.fbLjxmCbUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/fbLjxmCbDel", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包临建项目-删除", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject fbLjxmCbDel(@Validated @RequestBody RequestFbLjxmCbDel request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.fbLjxmCbDel(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/fbLjxmCbAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包临建项目-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsDaysFbLjxmCb fbLjxmCbAdd(@Validated @RequestBody RequestFbLjxmCbAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.fbLjxmCbAdd(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/fbJgUpdate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包价格-修改", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject fbJgUpdate(@Validated @RequestBody RequestFbJgUpdate request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.fbJgUpdate(request, httpServletRequest);
	}


	@RequestMapping(value = "/daysCb/fbJgAdd", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({
		@ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"),
	})
	@ApiOperation(value = "分包价格-新增", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject fbJgAdd(@Validated @RequestBody RequestFbJgAdd request, HttpServletRequest httpServletRequest) throws Exception{
		return daysCbApisService.fbJgAdd(request, httpServletRequest);
	}


}
