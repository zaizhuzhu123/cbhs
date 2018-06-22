package com.server.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;

public class MyCacheManager {

	// @Autowired
	// private CacheManager cacheManager;
	//
	// /**
	// * 获取缓存
	// *
	// * @param tableName
	// * @param key
	// * @return
	// */
	// public Object getCache(String tableName, String key) {
	// ValueWrapper vw = cacheManager.getCache(tableName).get(key);
	// if (vw != null) {
	// return vw.get();
	// }
	// return null;
	// }
	//
	// /**
	// * 加入缓存
	// *
	// * @param tableName
	// * @param key
	// * @param value
	// */
	// public void putCache(String tableName, String key, Object value) {
	// cacheManager.getCache(tableName).put(key, value);
	// }
	//
	// /**
	// * 清除缓存
	// *
	// * @param tableName
	// */
	// public void clearCache(String tableName) {
	// cacheManager.getCache(tableName).clear();
	// }
}
