package com.server.apis;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsTest;
import com.server.pojo.bean.CbhsTest1;

@Api(tags = { "代码测试" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@RestController
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class TestApis {

	@Autowired
	private MyQueryFactory queryFactory;

	@RequestMapping(value = "/test/add", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "测试-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsTest add(String name, Integer test1_oid, HttpServletRequest httpServletRequest) throws Exception {
		CbhsTest rb = new CbhsTest();
		rb.setName(name);
		CbhsTest1 test1 = queryFactory.findOne(CbhsTest1.class, test1_oid);
		rb.setTest1(test1);
		rb = queryFactory.saveOrUpdate(rb);
		return rb;
	}

	@RequestMapping(value = "/test/update", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiOperation(value = "测试-创建", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiResponse(code = 200, message = "操作成功后返回的视图")
	@ResponseBody
	public CbhsTest update(@Validated @RequestBody CbhsTest request, HttpServletRequest httpServletRequest) throws Exception {
		return queryFactory.saveOrUpdate(request);
	}
}
