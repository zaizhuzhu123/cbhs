package com.server.runner;

import javax.persistence.EntityManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.querydsl.jpa.HQLTemplates;
import com.server.jpa.MyQueryFactory;
import com.server.manager.CbSrManager;
import com.server.manager.ExaminerManager;
import com.server.manager.MyCacheManager;
import com.server.manager.PushManager;

/**
 * 程序入口
 * 
 * @author hanlai
 * 
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.server")
@ComponentScan(basePackages = "com.services")
@EntityScan(basePackages = "com.server.pojo")
@EnableJpaRepositories(basePackages = "com.server.jpa")
@EnableConfigurationProperties
@EnableScheduling
public class ServletInitializer extends SpringBootServletInitializer implements ApplicationListener<ContextRefreshedEvent> {

	/**
	 * War包入口
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(ServletInitializer.class);
	}

	@Bean
	public MyQueryFactory jpaQueryFactory(EntityManager entityManager) {
		return new MyQueryFactory(new HQLTemplates(), entityManager);
	}

	@Bean
	public ExaminerManager examinerManager() {
		return new ExaminerManager();
	}

	@Bean
	public PushManager pushManager() {
		return new PushManager();
	}

	@Bean
	public CbSrManager cbSrManager() {
		return new CbSrManager();
	}

	@Bean
	public MyCacheManager myCacheManager() {
		return new MyCacheManager();
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
	}

	/**
	 * 程序测试入口
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(ServletInitializer.class);
		springApplication.setAdditionalProfiles("test");
		springApplication.run(args);
	}
}
