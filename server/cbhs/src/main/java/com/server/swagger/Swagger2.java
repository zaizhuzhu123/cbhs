package com.server.swagger;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.fasterxml.classmate.TypeResolver;
import com.server.view.BadRequestView;
import com.server.view.InternalErrorView;
import com.server.view.UnAuthorized;
import com.server.view.UnsupportContentType;
import com.server.view.UnsupportMethmod;

/**
 * Swagger配置文件
 * 
 * @author hanlai
 *
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
	@Autowired
	private TypeResolver typeResolver;

	@Bean
	public Docket createRestApi() {
		List<ResponseMessage> responseMessages = new ArrayList<>();
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.server.apis")).paths(PathSelectors.any()).build().useDefaultResponseMessages(false).additionalModels(typeResolver.resolve(BadRequestView.class), typeResolver.resolve(InternalErrorView.class), typeResolver.resolve(UnsupportMethmod.class), typeResolver.resolve(UnAuthorized.class), typeResolver.resolve(UnsupportContentType.class)).globalResponseMessage(RequestMethod.POST, responseMessages);
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfoBuilder().title("Restful API 列表调试工具").version("1.0").build();
		return apiInfo;
	}
}
