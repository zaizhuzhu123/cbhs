package com.server.runner;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.services.NetbarServices;

import javax.xml.ws.Endpoint;

@Configuration
public class CxfConfig {
	@Autowired
	private Bus bus;
	@Autowired
	private NetbarServices netbarServices;

	@Bean
	// ----------http://127.0.0.1:8080/services/NetbarServices?wsdl
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, netbarServices);
		endpoint.publish("/NetbarServices");// 接口发布在 /NetbarServices 目录下
		return endpoint;
	}
}