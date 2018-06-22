package com.server.jpa;

import java.lang.reflect.Field;
import java.util.List;

import javax.annotation.Nullable;
import javax.inject.Provider;
import javax.persistence.EntityManager;
import javax.persistence.Id;
import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPQLTemplates;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.server.util.LazyInitUtils;

/**
 * 
 * @ClassName: MyJPAQuery
 * @Description: TODO(JPAQueryFactory再封装)
 * @author 青明锋
 * @date 2018年3月10日 下午11:53:58
 * 
 * @param <T>
 */
public class MyQueryFactory extends JPAQueryFactory {

	@Nullable
	private final JPQLTemplates templates;

	private final Provider<EntityManager> entityManager;

	@Autowired
	private DataSource dataSource;

	public MyQueryFactory(final EntityManager entityManager) {
		super(entityManager);
		this.entityManager = new Provider<EntityManager>() {
			@Override
			public EntityManager get() {
				return entityManager;
			}
		};
		this.templates = null;
	}

	public MyQueryFactory(JPQLTemplates templates, final EntityManager entityManager) {
		super(templates, entityManager);
		this.entityManager = new Provider<EntityManager>() {
			@Override
			public EntityManager get() {
				return entityManager;
			}
		};
		this.templates = templates;
	}

	public MyQueryFactory(Provider<EntityManager> entityManager) {
		super(entityManager);
		this.entityManager = entityManager;
		this.templates = null;
	}

	public MyQueryFactory(JPQLTemplates templates, Provider<EntityManager> entityManager) {
		super(templates, entityManager);
		this.entityManager = entityManager;
		this.templates = templates;
	}

	@SuppressWarnings("unchecked")
	public <T> T findOne(EntityPath<T> path, Predicate predicate) {
		T obj = this.selectFrom(path).where(predicate).fetchOne();
		return obj != null ? (T) LazyInitUtils.clearProxyOne(obj) : null;
	};

	public <T> T findOne(Class<T> entityClass, Object primaryKey) {
		return this.entityManager.get().find(entityClass, primaryKey);
	};

	/**
	 * 添加或更新 更新时是通过主键进行更新
	 * 
	 * @param entity
	 * @return
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings("unchecked")
	@Modifying
	public <T> T saveOrUpdate(T entity) {
		// 反射找到主键
		Object id = getPrimaryValue(entity);
		// 存在 更新 不存在 新建
		if (id != null && (!(id instanceof Integer) || (id instanceof Integer && (Integer) id > 0))) {
			try {
				addUpdateTime(entity);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			entity = this.entityManager.get().merge(entity);
			this.entityManager.get().flush();
		} else {
			// 新增 检查时间类型
			try {
				addCreateTime(entity);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.entityManager.get().persist(entity);
		}
		this.entityManager.get().flush();
		return (T) LazyInitUtils.clearProxyOne(entity);
	}

	@SuppressWarnings("rawtypes")
	public <T> void addCreateTime(T entity) throws IllegalArgumentException, IllegalAccessException {
		Class c = entity.getClass();
		Field[] fields = c.getDeclaredFields();
		long time = System.currentTimeMillis();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			if (f.getName().trim().equals("createTime")) {
				f.set(entity, time);
			}
			if (f.getName().trim().equals("createTimeStr")) {
				f.set(entity, new DateTime(time).toString("yyyy-MM-dd HH:mm:ss"));
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public <T> void addUpdateTime(T entity) throws IllegalArgumentException, IllegalAccessException {
		Class c = entity.getClass();
		Field[] fields = c.getDeclaredFields();
		long time = System.currentTimeMillis();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			if (f.getName().trim().equals("updateTime")) {
				f.set(entity, time);
			}
			if (f.getName().trim().equals("updateTimeStr")) {
				f.set(entity, new DateTime(time).toString("yyyy-MM-dd HH:mm:ss"));
			}
		}
	}

	public void batchRemove(Class entityClass, List<Integer> oids) {
		if (oids != null && oids.size() > 0) {
			EntityManager em = this.entityManager.get();
			for (Integer oid : oids) {
				Object obj = em.find(entityClass, oid);
				if (obj == null) {
					continue;
				}
				em.remove(obj);
			}
			em.flush();
		}
	}

	/**
	 * 添加或更新 更新时是通过主键进行更新
	 * 
	 * @param entity
	 * @return
	 */
	@Modifying
	public <T> void batchSaveOrUpdate(List<T> entitys) {
		if (entitys != null && entitys.size() > 0) {
			for (int i = 0; i < entitys.size(); i++) {
				T entity = entitys.get(i);
				// 反射找到主键
				Object id = getPrimaryValue(entity);
				// 存在 更新 不存在 新建
				if (id != null) {
					entity = this.entityManager.get().merge(entity);
				} else {
					this.entityManager.get().persist(entity);
				}
			}
			this.entityManager.get().flush();
			this.entityManager.get().clear();
		}
	}

	public <T> boolean exists(EntityPath<T> path, Predicate predicate) {
		return this.select(Expressions.TRUE).from(path).where(predicate).fetchOne() != null;
	}

	public <T> long delete(EntityPath<T> path, Predicate predicate) {
		return this.delete(path).where(predicate).execute();
	}

	public <T> long delete(T entity) {
		// this.entityManager.get().remove(entity);
		return 0;
	}

	/**
	 * 获取对象主键值
	 * 
	 * @param entity
	 * @return
	 */
	public <T> Object getPrimaryValue(T entity) {
		Object id = null;
		Field[] fields = entity.getClass().getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true);
			Id anno = fields[i].getAnnotation(Id.class);
			if (anno != null) {
				try {
					id = f.get(entity);
					return id;
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public <T> MyJPAQuery<T> selectFrom(EntityPath<T> from) {
		return (MyJPAQuery<T>) select(from).from(from);
	}

	@Override
	public MyJPAQuery<?> from(EntityPath<?> from) {
		return (MyJPAQuery<?>) query().from(from);
	}

	@Override
	public MyJPAQuery<?> from(EntityPath<?>... from) {
		return (MyJPAQuery<?>) query().from(from);
	}

	@Override
	public <T> MyJPAQuery<T> select(Expression<T> expr) {
		return (MyJPAQuery<T>) query().select(expr);
	}

	@Override
	public MyJPAQuery<Tuple> select(Expression<?>... exprs) {
		return (MyJPAQuery<Tuple>) query().select(exprs);
	}

	@Override
	public MyJPAQuery<?> query() {
		return new MyJPAQuery<Void>(entityManager.get(), templates);
	}

	public QueryRunner getSqlRunner() {
		return new QueryRunner(dataSource);
	}

}
