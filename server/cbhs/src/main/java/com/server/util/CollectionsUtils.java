package com.server.util;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;

/**
 * 
 * @ClassName: CollectionsUtils
 * @Description: TODO(集合封装类)
 * @author 青明锋
 * @date 2018年3月10日 下午11:53:58
 * 
 * @param <T>
 */
public class CollectionsUtils {
	public static List<Integer> listStr2Int(List<String> strList) {
		List<Integer> ints = Lists.newArrayList();
		if (strList != null && strList.size() > 0) {
			for (String str : strList) {
				if (StringUtils.isNumeric(str.trim())) {
					ints.add(Integer.parseInt(str.trim()));
				}
			}
		}
		return ints;
	}
}
