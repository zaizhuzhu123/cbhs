package com.server.jpa.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 基类JPA
 * 
 * @ClassName: BaseJPA
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 青明锋
 * @date 2017年12月21日 下午10:50:25
 * 
 * @param <T>
 */
@NoRepositoryBean
public interface BaseJPA<T> extends JpaSpecificationExecutor<T>, QueryDslPredicateExecutor<T> {
}