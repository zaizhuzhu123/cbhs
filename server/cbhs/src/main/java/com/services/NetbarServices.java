package com.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://services.com")
// 命名空间,一般是接口的包名倒序
public interface NetbarServices {
	@WebMethod
	String sayHello(@WebParam(name = "userName") String name);
}