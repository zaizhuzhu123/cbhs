package com.server.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.dsl.EntityPathBase;

public class LazyInitUtils {

	private static final String basisPaths[] = { "com.querydsl.core.types.dsl.NumberPath", "com.querydsl.core.types.dsl.StringPath" };

	public static Object clearProxyOne(Object obj) {
		SimplePropertyFilter filter = new SimplePropertyFilter();
		String json = JSON.toJSONString(obj, filter, SerializerFeature.DisableCircularReferenceDetect);
		obj = JSON.parseObject(json, obj.getClass());
		return obj;
	}

	public static <T> List<T> clearProxyList(List<T> list) {
		List<T> newList = new ArrayList<T>();
		if (list != null && list.size() > 0) {
			for (T obj : list) {
				T newObj = (T) clearProxyOne(obj);
				newList.add(newObj);
			}
		}
		return newList;
	}

	@SuppressWarnings("rawtypes")
	public static List<Expression> basisExpression(EntityPathBase entity) {
		List<Expression> expressionList = new ArrayList<>();
		Class c = entity.getClass();
		Field[] fields = c.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field f = fields[i];
			f.setAccessible(true); // 设置些属性是可以访问的
			if (isBasisExpression(f.getType())) {
				try {
					expressionList.add((Expression) f.get(entity));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return expressionList;

	}

	/**
	 * 返回基本数据类型的Expression 非关联对象 @Title: isBasisExpression @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param obj @param @return 设定文件 @return
	 * boolean 返回类型 @throws
	 */
	@SuppressWarnings("rawtypes")
	public static boolean isBasisExpression(Class obj) {
		for (String basisPath : basisPaths) {
			if (basisPath.equals(obj.getName())) {
				return true;
			}
		}
		return false;
	}

}
