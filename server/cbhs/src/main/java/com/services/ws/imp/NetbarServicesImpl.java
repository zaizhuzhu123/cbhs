package com.services.ws.imp;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.services.NetbarServices;

/**
 * 网吧web services 接口实现
 * 
 * @author xiaojf 2017/7/24 21:38
 */
@WebService(serviceName = "NetbarServices"// 服务名
, targetNamespace = "http://services.com"// 报名倒叙，并且和接口定义保持一致
, endpointInterface = "com.services.NetbarServices")
// 包名
@Component
public class NetbarServicesImpl implements NetbarServices {
	@Override
	public String sayHello(String name) {
		return "hello , " + name;
	}
}