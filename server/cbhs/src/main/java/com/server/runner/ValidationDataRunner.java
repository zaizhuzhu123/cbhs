package com.server.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 驱动完毕后进行环境检测
 * @author hanlai
 *
 */
@Component
@Order(value=Integer.MAX_VALUE)
public class ValidationDataRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
	}

}
