package com.server.apis;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.server.handler.ResourceService;
import com.server.pojo.bean.CbhsResource;

@Api(tags = { "静态资源管理" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
public class ResourceApis {
	@Autowired
	private ResourceService resourceService;

	@RequestMapping(value = "/resource/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", value = "鉴权信息", required = true, dataType = "String", paramType = "header"), })
	@ApiOperation(value = "文件上传", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsResource resourceUpload(@RequestParam(name = "file", required = true) MultipartFile request, HttpServletRequest httpServletRequest) throws Exception {
		return resourceService.resourceUpload(request, httpServletRequest);
	}

	@RequestMapping(value = "/resource/down", method = RequestMethod.GET)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "下载")
	@ApiResponse(code = 200, message = "文件")
	public void resourceUpload(Integer resouceOid, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {
		resourceService.down(resouceOid, httpServletRequest, response);
	}
	
	@RequestMapping(value = "/resource/errorLogupload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "错误日志上传", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public JSONObject errorLogupload(@RequestParam(name = "file", required = true) MultipartFile request, HttpServletRequest httpServletRequest) throws Exception {
		return resourceService.errorLogupload(request, httpServletRequest);
	}
}
