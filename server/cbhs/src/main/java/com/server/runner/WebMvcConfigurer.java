package com.server.runner;

import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.server.interceptor.LogInterceptor;
import com.server.interceptor.PermissionsInterceptor;
import com.server.util.SimplePropertyFilter;

/**
 * mvc相关配置
 * 
 * @ClassName: WebMvcConfigurer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 青明锋
 * @date 2017年12月18日 下午9:08:35
 *
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// 将所有/static/** 访问都映射到classpath:/static/ 目录下
		registry.addResourceHandler("/resources/**").addResourceLocations("classpath:/resources/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**");
		registry.addInterceptor(new PermissionsInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}

	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializeFilters(new SimplePropertyFilter());
		fastJsonConfig.setSerializerFeatures(SerializerFeature.DisableCircularReferenceDetect, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.WriteNullListAsEmpty,
				SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullBooleanAsFalse);
		fastConverter.setFastJsonConfig(fastJsonConfig);
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}
}