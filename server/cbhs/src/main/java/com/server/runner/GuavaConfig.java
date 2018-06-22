package com.server.runner;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;
import com.google.common.cache.CacheBuilder;

/**
 * guava缓存配置
 */
@Configuration
@EnableCaching
public class GuavaConfig {

	/**
	 * 配置全局缓存参数，600秒过期，最大个数1000
	 */
	@Bean
	public CacheManager cacheManager() {
		GuavaCacheManager cacheManager = new GuavaCacheManager();
		cacheManager.setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(600, TimeUnit.SECONDS).maximumSize(1000));
		return cacheManager;
	}

	/**
	 * 自定义缓存key的生成类实现
	 */
	@Bean(name = "myKeyGenerator")
	public KeyGenerator myKeyGenerator() {
		return new KeyGenerator() {
			@Override
			public Object generate(Object o, Method method, Object... params) {
				// 仅仅用于测试，实际不可能这么写
				return JSON.toJSONString(params[0]);
			}
		};
	}
}