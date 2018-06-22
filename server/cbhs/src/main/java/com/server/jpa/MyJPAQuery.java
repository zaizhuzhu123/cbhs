package com.server.jpa;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.commons.lang3.StringUtils;

import com.querydsl.core.DefaultQueryMetadata;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAQueryMixin;
import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * 
 * @ClassName: MyJPAQuery
 * @Description: TODO(JPAQuery再封装)
 * @author 青明锋
 * @date 2018年3月10日 下午11:53:58
 * 
 * @param <T>
 */
public class MyJPAQuery<T> extends JPAQuery<T> {

	private static final long serialVersionUID = 1L;

	public MyJPAQuery(EntityManager em, JPQLTemplates templates) {
		super(em, templates, new DefaultQueryMetadata());
	}

	public JPAQuery<T> where(String str, Predicate o) {
		if (StringUtils.isNotBlank(str)) {
			return queryMixin.where(o);
		}
		return this;
	}

	public JPAQuery<T> where(Boolean flag, Predicate o) {
		if (flag != null) {
			return queryMixin.where(o);
		}
		return this;
	}

	public JPAQuery<T> where(Integer num, Predicate o) {
		if (num != null && num.intValue() > 0) {
			return queryMixin.where(o);
		}
		return this;
	}

	public JPAQuery<T> where(Long num, Predicate o) {
		if (num != null && num > 0) {
			return queryMixin.where(o);
		}
		return this;
	}

	public JPAQueryMixin<JPAQuery<T>> getQueryMixin() {
		return queryMixin;
	}

	public PagerResult fetchPager(Integer pageNum, Integer pageSize) {
		long total = this.fetchCount();
		int pageNum_ = pageNum == null || pageNum == 0 ? 1 : pageNum;
		int pageSize_ = pageSize == null || pageSize == 0 ? 9999999 : pageSize;
		List<T> result = this.offset((pageNum_ - 1) * pageSize_).limit(pageSize_).fetch();
		PagerResult pr = new PagerResult();
		pr.setTotal(total);
		pr.setResult(result);
		return pr;
	}

	public PagerResult fetchPagerGroupBy(Integer pageNum, Integer pageSize, Expression<?> e) {
		long total = this.groupBy(e).fetchCount();
		int pageNum_ = pageNum == null || pageNum == 0 ? 1 : pageNum;
		int pageSize_ = pageSize == null || pageSize == 0 ? 9999999 : pageSize;
		List<T> result = this.offset((pageNum_ - 1) * pageSize_).limit(pageSize_).groupBy(e).fetch();
		PagerResult pr = new PagerResult();
		pr.setTotal(total);
		pr.setResult(result);
		return pr;
	}

	public class PagerResult {
		private Long total;
		private List<T> result;

		public Long getTotal() {
			return total;
		}

		public void setTotal(Long total) {
			this.total = total;
		}

		public List<T> getResult() {
			return result;
		}

		public void setResult(List<T> result) {
			this.result = result;
		}

	}
}
