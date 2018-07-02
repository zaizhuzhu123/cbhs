package com.server.util;

import io.swagger.annotations.ApiModelProperty;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.server.common.BigDecimalUtils;
import com.server.exception.ExceedException;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsDaysFbGclTj;
import com.server.pojo.bean.CbhsDaysFbLjxmCb;
import com.server.pojo.bean.CbhsDaysGlfyYs;
import com.server.pojo.bean.CbhsDaysJjcb;
import com.server.pojo.bean.CbhsDaysZyCailiaoCb;
import com.server.pojo.bean.CbhsDaysZyJxCb;
import com.server.pojo.bean.CbhsDaysZyLxygCb;
import com.server.pojo.bean.CbhsDaysZyQtCb;
import com.server.pojo.bean.CbhsGclQdYs;
import com.server.pojo.bean.CbhsMonthFbGcCbYs;
import com.server.pojo.bean.CbhsMonthFbLjxmCbYs;
import com.server.pojo.bean.CbhsMonthGlfyYs;
import com.server.pojo.bean.CbhsMonthJjcbYs;
import com.server.pojo.bean.CbhsMonthZyCailiaoCbYs;
import com.server.pojo.bean.CbhsMonthZyJxCbYs;
import com.server.pojo.bean.CbhsMonthZyLxygCbYs;
import com.server.pojo.bean.CbhsMonthZyQtfyYs;
import com.server.pojo.bean.CbhsZytj;
import com.server.pojo.bean.CbhsZytjZC;
import com.server.pojo.bean.QCbhsDaysFbGclTj;
import com.server.pojo.bean.QCbhsDaysFbLjxmCb;
import com.server.pojo.bean.QCbhsDaysGclSr;
import com.server.pojo.bean.QCbhsDaysGlfyYs;
import com.server.pojo.bean.QCbhsDaysJjcb;
import com.server.pojo.bean.QCbhsDaysQtSr;
import com.server.pojo.bean.QCbhsDaysZyCailiaoCb;
import com.server.pojo.bean.QCbhsDaysZyJxCb;
import com.server.pojo.bean.QCbhsDaysZyLxygCb;
import com.server.pojo.bean.QCbhsDaysZyQtCb;
import com.server.pojo.bean.QCbhsGclQdYs;
import com.server.pojo.bean.QCbhsMonthFbCailiaoCbYs;
import com.server.pojo.bean.QCbhsMonthFbGcCbYs;
import com.server.pojo.bean.QCbhsMonthFbLjxmCbYs;
import com.server.pojo.bean.QCbhsMonthGlfyYs;
import com.server.pojo.bean.QCbhsMonthJjcbYs;
import com.server.pojo.bean.QCbhsMonthZyCailiaoCbYs;
import com.server.pojo.bean.QCbhsMonthZyJxCbYs;
import com.server.pojo.bean.QCbhsMonthZyLxygCbYs;
import com.server.pojo.bean.QCbhsMonthZyQtfyYs;
import com.server.pojo.bean.QCbhsZytj;
import com.server.pojo.bean.QCbhsZytjZC;
import com.server.pojo.bean.uiExceedInfo;
import com.server.pojo.url.monthMbYs.RequestMbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseMbYsFetch;

/**
 * 数据汇总工具类
 * 
 * @author Administrator
 *
 */
public class DataSummaryUtils {

	@SuppressWarnings({ "rawtypes" })
	private static boolean getExceedInfo(Object obj, List<uiExceedInfo> exceedInfos) throws IllegalArgumentException, IllegalAccessException {
		boolean flag = true;
		Class c = (Class) obj.getClass();
		Field[] fs = c.getDeclaredFields();
		for (int i = 0; i < fs.length; i++) {
			Field f = fs[i];
			f.setAccessible(true); // 设置些属性是可以访问的
			String type = f.getType().toString();
			ApiModelProperty an = f.getAnnotation(ApiModelProperty.class);
			if (an != null) {
				String paramName = an.value();
				if (type.endsWith("Integer")) {
					Integer value = (Integer) f.get(obj);
					if (value != null && value < 0) {
						uiExceedInfo info = new uiExceedInfo();
						info.setName(paramName);
						info.setValue(new BigDecimal(value).stripTrailingZeros());
						info.setUnit("元");
						exceedInfos.add(info);
						flag = false;
					}
				}
				if (type.endsWith("BigDecimal")) {
					BigDecimal value = (BigDecimal) f.get(obj);
					if (value != null && value.compareTo(BigDecimal.ZERO) < 0) {
						uiExceedInfo info = new uiExceedInfo();
						info.setName(paramName);
						info.setValue(value.stripTrailingZeros());
						info.setUnit("元");
						exceedInfos.add(info);
						flag = false;
					}
				}
				if (type.endsWith("Long")) {
					Long value = (Long) f.get(obj);
					if (value != null && value < 0) {
						uiExceedInfo info = new uiExceedInfo();
						info.setName(paramName);
						info.setValue(new BigDecimal(value).stripTrailingZeros());
						info.setUnit("元");
						exceedInfos.add(info);
						flag = false;
					}
				}
			}

		}
		return flag;
	}

	/**
	 * 获得总收入
	 * 
	 * @Title: getSr @Description: TODO(这里用一句话描述这个方法的作用) @param @param queryFactory @param @param dso @param @return 设定文件 @return BigDecimal 返回类型 @throws
	 */
	public static BigDecimal getSr(MyQueryFactory queryFactory, DataSummaryObj dso) {
		JPAQuery<BigDecimal> jqaquery = queryFactory
				.select(QCbhsDaysGclSr.cbhsDaysGclSr.total.sum())
				.from(QCbhsDaysGclSr.cbhsDaysGclSr)
				.where(QCbhsDaysGclSr.cbhsDaysGclSr.projectOid.eq(dso.getProjectOid()).and(QCbhsDaysGclSr.cbhsDaysGclSr.dateTimeStamp.goe(dso.getDt().getStartTime()))
						.and(QCbhsDaysGclSr.cbhsDaysGclSr.dateTimeStamp.loe(dso.getDt().getEndTime())));
		if (dso.getDeptOids() != null && dso.getDeptOids().size() > 0) {
			jqaquery.where(QCbhsDaysGclSr.cbhsDaysGclSr.deptOid.in(dso.getDeptOids()));
		}
		BigDecimal gcsrTotal = jqaquery.fetchFirst();
		jqaquery = queryFactory
				.select(QCbhsDaysQtSr.cbhsDaysQtSr.total.sum())
				.from(QCbhsDaysQtSr.cbhsDaysQtSr)
				.where(QCbhsDaysQtSr.cbhsDaysQtSr.projectOid.eq(dso.getProjectOid()).and(QCbhsDaysQtSr.cbhsDaysQtSr.dateTimeStamp.goe(dso.getDt().getStartTime()))
						.and(QCbhsDaysQtSr.cbhsDaysQtSr.dateTimeStamp.loe(dso.getDt().getEndTime())));
		if (dso.getDeptOids() != null && dso.getDeptOids().size() > 0) {
			jqaquery.where(QCbhsDaysQtSr.cbhsDaysQtSr.deptOid.in(dso.getDeptOids()));
		}
		BigDecimal qtSrTotal = jqaquery.fetchFirst();
		gcsrTotal = gcsrTotal != null ? gcsrTotal : new BigDecimal(0);
		qtSrTotal = qtSrTotal != null ? qtSrTotal : new BigDecimal(0);
		return gcsrTotal.add(qtSrTotal);
	}

	/**
	 * 获取当月间接成本总预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @return
	 */
	public static CbhsMonthJjcbYs getThisMonthJjCbYsTotalDetails(MyQueryFactory queryFactory, DataSummaryObj dso) {
		// 间接成本
		ResponseMbYsFetch response = new ResponseMbYsFetch();
		CbhsMonthJjcbYs cbhsMonthJjcbYs = new CbhsMonthJjcbYs();
		JPAQuery<CbhsMonthJjcbYs> jqcbhsMonthJjcbYsTuple = queryFactory
				.select(Projections.bean(CbhsMonthJjcbYs.class, QCbhsMonthJjcbYs.cbhsMonthJjcbYs.total.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.total), QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_gz.sum()
						.as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_gz), QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_zjjf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_zjjf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_ghjf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_ghjf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_dwbx.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_dwbx),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_qt.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_qt),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_wp_gz.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_wp_gz),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_wp_zjjf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_wp_zjjf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_wp_ghjf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_wp_ghjf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_wp_qt.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.glry_wp_qt),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_gz.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_gz),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_zjjf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_zjjf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_ghjf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_ghjf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_dwbx.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_dwbx),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_qt.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_qt),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_wp_gz.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_wp_gz),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_wp_zjjf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_wp_zjjf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_wp_ghjf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_wp_ghjf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_wp_qt.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.scry_wp_qt),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.bg_bgyp.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.bg_bgyp),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.bg_txf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.bg_txf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.bg_dnhc.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.bg_dnhc),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.bg_qt.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.bg_qt),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_dxf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_dxf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_ybxlf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_ybxlf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_clf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_clf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_cailiaofei.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_cailiaofei),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_flf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_flf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_ywjf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_ywjf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_sdf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_sdf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_scf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_scf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_kyjf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_kyjf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_cljbxf.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_cljbxf),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_qt.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.xlf_qt),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.aqfy_ygsz.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.aqfy_ygsz),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.aqfy_ygsztc.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.aqfy_ygsztc),
						QCbhsMonthJjcbYs.cbhsMonthJjcbYs.aqfy_qt.sum().as(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.aqfy_qt)))
				.from(QCbhsMonthJjcbYs.cbhsMonthJjcbYs)
				.where(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.projectOid.eq(dso.getProjectOid()).and(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.monthTimeStamp.goe(dso.getDt().getStartTime()))
						.and(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.monthTimeStamp.loe(dso.getDt().getEndTime())));
		if (dso.getDeptOids().size() > 0) {
			jqcbhsMonthJjcbYsTuple.where(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.deptOid.in(dso.getDeptOids()));
		}
		cbhsMonthJjcbYs = jqcbhsMonthJjcbYsTuple.fetchOne();
		response.setJjcbTotal(cbhsMonthJjcbYs);
		return cbhsMonthJjcbYs;
	}

	/**
	 * 获取当月已提交的总间接成本
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @return
	 */
	public static CbhsDaysJjcb getThisMonthSubmitJjCbTotalDetails(MyQueryFactory queryFactory, DataSummaryObj dso) {
		// 间接成本
		CbhsDaysJjcb cbhsDaysJjcb = new CbhsDaysJjcb();
		JPAQuery<CbhsDaysJjcb> jqcbhsDaysJjcbTuple = queryFactory
				.select(Projections.bean(CbhsDaysJjcb.class, QCbhsDaysJjcb.cbhsDaysJjcb.total.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.total),
						QCbhsDaysJjcb.cbhsDaysJjcb.glry_gz.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.glry_gz), QCbhsDaysJjcb.cbhsDaysJjcb.glry_zjjf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.glry_zjjf),
						QCbhsDaysJjcb.cbhsDaysJjcb.glry_ghjf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.glry_ghjf), QCbhsDaysJjcb.cbhsDaysJjcb.glry_dwbx.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.glry_dwbx),
						QCbhsDaysJjcb.cbhsDaysJjcb.glry_qt.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.glry_qt), QCbhsDaysJjcb.cbhsDaysJjcb.glry_wp_gz.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.glry_wp_gz),
						QCbhsDaysJjcb.cbhsDaysJjcb.glry_wp_zjjf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.glry_wp_zjjf),
						QCbhsDaysJjcb.cbhsDaysJjcb.glry_wp_ghjf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.glry_wp_ghjf), QCbhsDaysJjcb.cbhsDaysJjcb.glry_wp_qt.sum()
								.as(QCbhsDaysJjcb.cbhsDaysJjcb.glry_wp_qt), QCbhsDaysJjcb.cbhsDaysJjcb.scry_gz.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.scry_gz), QCbhsDaysJjcb.cbhsDaysJjcb.scry_zjjf.sum()
								.as(QCbhsDaysJjcb.cbhsDaysJjcb.scry_zjjf), QCbhsDaysJjcb.cbhsDaysJjcb.scry_ghjf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.scry_ghjf), QCbhsDaysJjcb.cbhsDaysJjcb.scry_dwbx
								.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.scry_dwbx), QCbhsDaysJjcb.cbhsDaysJjcb.scry_qt.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.scry_qt), QCbhsDaysJjcb.cbhsDaysJjcb.scry_wp_gz
								.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.scry_wp_gz), QCbhsDaysJjcb.cbhsDaysJjcb.scry_wp_zjjf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.scry_wp_zjjf),
						QCbhsDaysJjcb.cbhsDaysJjcb.scry_wp_ghjf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.scry_wp_ghjf), QCbhsDaysJjcb.cbhsDaysJjcb.scry_wp_qt.sum()
								.as(QCbhsDaysJjcb.cbhsDaysJjcb.scry_wp_qt), QCbhsDaysJjcb.cbhsDaysJjcb.bg_bgyp.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.bg_bgyp), QCbhsDaysJjcb.cbhsDaysJjcb.bg_txf.sum()
								.as(QCbhsDaysJjcb.cbhsDaysJjcb.bg_txf), QCbhsDaysJjcb.cbhsDaysJjcb.bg_dnhc.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.bg_dnhc),
						QCbhsDaysJjcb.cbhsDaysJjcb.bg_qt.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.bg_qt), QCbhsDaysJjcb.cbhsDaysJjcb.xlf_dxf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.xlf_dxf),
						QCbhsDaysJjcb.cbhsDaysJjcb.xlf_ybxlf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.xlf_ybxlf), QCbhsDaysJjcb.cbhsDaysJjcb.xlf_clf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.xlf_clf),
						QCbhsDaysJjcb.cbhsDaysJjcb.xlf_cailiaofei.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.xlf_cailiaofei), QCbhsDaysJjcb.cbhsDaysJjcb.xlf_flf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.xlf_flf),
						QCbhsDaysJjcb.cbhsDaysJjcb.xlf_ywjf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.xlf_ywjf), QCbhsDaysJjcb.cbhsDaysJjcb.xlf_sdf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.xlf_sdf),
						QCbhsDaysJjcb.cbhsDaysJjcb.xlf_scf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.xlf_scf), QCbhsDaysJjcb.cbhsDaysJjcb.xlf_kyjf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.xlf_kyjf),
						QCbhsDaysJjcb.cbhsDaysJjcb.xlf_cljbxf.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.xlf_cljbxf), QCbhsDaysJjcb.cbhsDaysJjcb.xlf_qt.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.xlf_qt),
						QCbhsDaysJjcb.cbhsDaysJjcb.aqfy_ygsz.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.aqfy_ygsz), QCbhsDaysJjcb.cbhsDaysJjcb.aqfy_ygsztc.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.aqfy_ygsztc),
						QCbhsDaysJjcb.cbhsDaysJjcb.aqfy_qt.sum().as(QCbhsDaysJjcb.cbhsDaysJjcb.aqfy_qt)))
				.from(QCbhsDaysJjcb.cbhsDaysJjcb)
				.where(QCbhsDaysJjcb.cbhsDaysJjcb.projectOid.eq(dso.getProjectOid())
						.and(QCbhsDaysJjcb.cbhsDaysJjcb.dateTimeStamp.goe(dso.getDt().getStartTime()).and(QCbhsDaysJjcb.cbhsDaysJjcb.dateTimeStamp.loe(dso.getDt().getEndTime())))
						.and(QCbhsDaysJjcb.cbhsDaysJjcb.shStatus.eq(0)));
		if (dso.getDeptOids().size() > 0) {
			jqcbhsDaysJjcbTuple.where(QCbhsDaysJjcb.cbhsDaysJjcb.deptOid.in(dso.getDeptOids()));
		}
		cbhsDaysJjcb = jqcbhsDaysJjcbTuple.fetchOne();
		return cbhsDaysJjcb;
	}

	/**
	 * 校验当前提交的间接成本 是否已经累计超出本月的总预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @param jjcb
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static synchronized void checkJjCbIsExceed(MyQueryFactory queryFactory, DataSummaryObj dso, CbhsDaysJjcb jjcb) throws IllegalArgumentException, IllegalAccessException {
		CbhsMonthJjcbYs ys = getThisMonthJjCbYsTotalDetails(queryFactory, dso);
		CbhsDaysJjcb cb = getThisMonthSubmitJjCbTotalDetails(queryFactory, dso);
		CbhsDaysJjcb sub = new CbhsDaysJjcb();
		sub.setGlry_gz(BigDecimalUtils.getSub(ys.getGlry_gz(), cb.getGlry_gz(), jjcb.getGlry_gz()));
		sub.setGlry_zjjf(BigDecimalUtils.getSub(ys.getGlry_zjjf(), cb.getGlry_zjjf(), jjcb.getGlry_zjjf()));
		sub.setGlry_ghjf(BigDecimalUtils.getSub(ys.getGlry_ghjf(), cb.getGlry_ghjf(), jjcb.getGlry_ghjf()));
		sub.setGlry_dwbx(BigDecimalUtils.getSub(ys.getGlry_dwbx(), cb.getGlry_dwbx(), jjcb.getGlry_dwbx()));
		sub.setGlry_qt(BigDecimalUtils.getSub(ys.getGlry_qt(), cb.getGlry_qt(), jjcb.getGlry_qt()));
		sub.setGlry_wp_gz(BigDecimalUtils.getSub(ys.getGlry_wp_gz(), cb.getGlry_wp_gz(), jjcb.getGlry_wp_gz()));
		sub.setGlry_wp_zjjf(BigDecimalUtils.getSub(ys.getGlry_wp_zjjf(), cb.getGlry_wp_zjjf(), jjcb.getGlry_wp_zjjf()));
		sub.setGlry_wp_ghjf(BigDecimalUtils.getSub(ys.getGlry_wp_ghjf(), cb.getGlry_wp_ghjf(), jjcb.getGlry_wp_ghjf()));
		sub.setGlry_wp_qt(BigDecimalUtils.getSub(ys.getGlry_wp_qt(), cb.getGlry_wp_qt(), jjcb.getGlry_wp_qt()));
		sub.setScry_gz(BigDecimalUtils.getSub(ys.getScry_gz(), cb.getScry_gz(), jjcb.getScry_gz()));
		sub.setScry_zjjf(BigDecimalUtils.getSub(ys.getScry_zjjf(), cb.getScry_zjjf(), jjcb.getScry_zjjf()));
		sub.setScry_ghjf(BigDecimalUtils.getSub(ys.getScry_ghjf(), cb.getScry_ghjf(), jjcb.getScry_ghjf()));
		sub.setScry_dwbx(BigDecimalUtils.getSub(ys.getScry_dwbx(), cb.getScry_dwbx(), jjcb.getScry_dwbx()));
		sub.setScry_qt(BigDecimalUtils.getSub(ys.getScry_qt(), cb.getScry_qt(), jjcb.getScry_qt()));
		sub.setScry_wp_gz(BigDecimalUtils.getSub(ys.getScry_wp_gz(), cb.getScry_wp_gz(), jjcb.getScry_wp_gz()));
		sub.setScry_wp_zjjf(BigDecimalUtils.getSub(ys.getScry_wp_zjjf(), cb.getScry_wp_zjjf(), jjcb.getScry_wp_zjjf()));
		sub.setScry_wp_ghjf(BigDecimalUtils.getSub(ys.getScry_wp_ghjf(), cb.getScry_wp_ghjf(), jjcb.getScry_wp_ghjf()));
		sub.setScry_wp_qt(BigDecimalUtils.getSub(ys.getScry_wp_qt(), cb.getScry_wp_qt(), jjcb.getScry_wp_qt()));
		sub.setBg_bgyp(BigDecimalUtils.getSub(ys.getBg_bgyp(), cb.getBg_bgyp(), jjcb.getBg_bgyp()));
		sub.setBg_txf(BigDecimalUtils.getSub(ys.getBg_txf(), cb.getBg_txf(), jjcb.getBg_txf()));
		sub.setBg_dnhc(BigDecimalUtils.getSub(ys.getBg_dnhc(), cb.getBg_dnhc(), jjcb.getBg_dnhc()));
		sub.setBg_qt(BigDecimalUtils.getSub(ys.getBg_qt(), cb.getBg_qt(), jjcb.getBg_qt()));
		sub.setXlf_dxf(BigDecimalUtils.getSub(ys.getXlf_dxf(), cb.getXlf_dxf(), jjcb.getXlf_dxf()));
		sub.setXlf_ybxlf(BigDecimalUtils.getSub(ys.getXlf_ybxlf(), cb.getXlf_ybxlf(), jjcb.getXlf_ybxlf()));
		sub.setXlf_clf(BigDecimalUtils.getSub(ys.getXlf_clf(), cb.getXlf_clf(), jjcb.getXlf_clf()));
		sub.setXlf_cailiaofei(BigDecimalUtils.getSub(ys.getXlf_cailiaofei(), cb.getXlf_cailiaofei(), jjcb.getXlf_cailiaofei()));
		sub.setXlf_flf(BigDecimalUtils.getSub(ys.getXlf_flf(), cb.getXlf_flf(), jjcb.getXlf_flf()));
		sub.setXlf_ywjf(BigDecimalUtils.getSub(ys.getXlf_ywjf(), cb.getXlf_ywjf(), jjcb.getXlf_ywjf()));
		sub.setXlf_sdf(BigDecimalUtils.getSub(ys.getXlf_sdf(), cb.getXlf_sdf(), jjcb.getXlf_sdf()));
		sub.setXlf_scf(BigDecimalUtils.getSub(ys.getXlf_scf(), cb.getXlf_scf(), jjcb.getXlf_scf()));
		sub.setXlf_kyjf(BigDecimalUtils.getSub(ys.getXlf_kyjf(), cb.getXlf_kyjf(), jjcb.getXlf_kyjf()));
		sub.setXlf_cljbxf(BigDecimalUtils.getSub(ys.getXlf_cljbxf(), cb.getXlf_cljbxf(), jjcb.getXlf_cljbxf()));
		sub.setXlf_qt(BigDecimalUtils.getSub(ys.getXlf_qt(), cb.getXlf_qt(), jjcb.getXlf_qt()));
		sub.setAqfy_ygsz(BigDecimalUtils.getSub(ys.getAqfy_ygsz(), cb.getAqfy_ygsz(), jjcb.getAqfy_ygsz()));
		sub.setAqfy_ygsztc(BigDecimalUtils.getSub(ys.getAqfy_ygsztc(), cb.getAqfy_ygsztc(), jjcb.getAqfy_ygsztc()));
		sub.setAqfy_qt(BigDecimalUtils.getSub(ys.getAqfy_qt(), cb.getAqfy_qt(), jjcb.getAqfy_qt()));
		List<uiExceedInfo> exceedInfos = Lists.newArrayList();
		boolean isExceed = getExceedInfo(sub, exceedInfos);
		if (!isExceed) {
			throw new ExceedException("间接成本", exceedInfos);
		}
	}

	/**
	 * 获取当月的管理费用 总预算
	 * 
	 * @Title: getThisMonthGlfyYs
	 * 
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param @param queryFactory
	 * 
	 * @param @param request
	 * 
	 * @param @return 设定文件
	 * 
	 * @return CbhsMonthGlfyYs 返回类型 @throws
	 */
	public static CbhsMonthGlfyYs getThisMonthGlfyYs(MyQueryFactory queryFactory, DataSummaryObj dso) {
		CbhsMonthGlfyYs cbhsMonthGlfyYs = new CbhsMonthGlfyYs();
		JPAQuery<CbhsMonthGlfyYs> jqcbhsMonthGlfyYsTuple = queryFactory
				.select(Projections.bean(CbhsMonthGlfyYs.class, QCbhsMonthGlfyYs.cbhsMonthGlfyYs.p_sjgs.sum().as(QCbhsMonthGlfyYs.cbhsMonthGlfyYs.p_sjgs), QCbhsMonthGlfyYs.cbhsMonthGlfyYs.p_ztbfy
						.sum().as(QCbhsMonthGlfyYs.cbhsMonthGlfyYs.p_ztbfy), QCbhsMonthGlfyYs.cbhsMonthGlfyYs.p_sjzjjf.sum().as(QCbhsMonthGlfyYs.cbhsMonthGlfyYs.p_sjzjjf),
						QCbhsMonthGlfyYs.cbhsMonthGlfyYs.p_kdqqysds.sum().as(QCbhsMonthGlfyYs.cbhsMonthGlfyYs.p_kdqqysds),
						QCbhsMonthGlfyYs.cbhsMonthGlfyYs.total.sum().as(QCbhsMonthGlfyYs.cbhsMonthGlfyYs.total),
						QCbhsMonthGlfyYs.cbhsMonthGlfyYs.p_yhsjqtsj.sum().as(QCbhsMonthGlfyYs.cbhsMonthGlfyYs.p_yhsjqtsj)))
				.from(QCbhsMonthGlfyYs.cbhsMonthGlfyYs)
				.where(QCbhsMonthGlfyYs.cbhsMonthGlfyYs.projectOid.eq(dso.getProjectOid()).and(QCbhsMonthGlfyYs.cbhsMonthGlfyYs.monthTimeStamp.goe(dso.getDt().getStartTime()))
						.and(QCbhsMonthGlfyYs.cbhsMonthGlfyYs.monthTimeStamp.loe(dso.getDt().getStartTime())));
		if (dso.getDeptOids().size() > 0) {
			jqcbhsMonthGlfyYsTuple.where(QCbhsMonthGlfyYs.cbhsMonthGlfyYs.deptOid.in(dso.getDeptOids()));
		}
		cbhsMonthGlfyYs = jqcbhsMonthGlfyYsTuple.fetchOne();
		return cbhsMonthGlfyYs;
	}

	/**
	 * 获取当月已提交的管理费用成本
	 * 
	 * @Title: getThisMonthSubmitGlfyTotalDetails
	 * 
	 * @Description:TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param @param queryFactory
	 * 
	 * @param @param request
	 * 
	 * @param @return 设定文件
	 * 
	 * @return CbhsDaysGlfyYs
	 * 
	 *         返回类型 @throws
	 */
	public static CbhsDaysGlfyYs getThisMonthSubmitGlfyTotalDetails(MyQueryFactory queryFactory, DataSummaryObj dso) {
		CbhsDaysGlfyYs cbhsDaysGlfyYs = new CbhsDaysGlfyYs();
		JPAQuery<CbhsDaysGlfyYs> jqcbhsMonthGlfyYsTuple = queryFactory
				.select(Projections.bean(CbhsDaysGlfyYs.class, QCbhsDaysGlfyYs.cbhsDaysGlfyYs.p_sjgs.sum().as(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.p_sjgs),
						QCbhsDaysGlfyYs.cbhsDaysGlfyYs.p_ztbfy.sum().as(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.p_ztbfy),
						QCbhsDaysGlfyYs.cbhsDaysGlfyYs.p_sjzjjf.sum().as(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.p_sjzjjf),
						QCbhsDaysGlfyYs.cbhsDaysGlfyYs.p_kdqqysds.sum().as(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.p_kdqqysds),
						QCbhsDaysGlfyYs.cbhsDaysGlfyYs.p_yhsjqtsj.sum().as(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.p_yhsjqtsj)))
				.from(QCbhsDaysGlfyYs.cbhsDaysGlfyYs)
				.where(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.projectOid.eq(dso.getProjectOid())
						.and(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.dateTimeStamp.goe(dso.getDt().getStartTime()).and(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.dateTimeStamp.loe(dso.getDt().getEndTime())))
						.and(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.shStatus.eq(0)));
		cbhsDaysGlfyYs = jqcbhsMonthGlfyYsTuple.fetchOne();
		if (dso.getDeptOids().size() > 0) {
			jqcbhsMonthGlfyYsTuple.where(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.deptOid.in(dso.getDeptOids()));
		}
		return cbhsDaysGlfyYs;
	}

	/**
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 *             校验当前提交的管理费用 是否已超出当月预算总费用
	 * 
	 * @Title: checkGlfyIsExceed
	 * 
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * 
	 * @param @param queryFactory
	 * 
	 * @param @param request
	 * 
	 * @param @param glfy 设定文件
	 * 
	 * @return void 返回类型
	 * 
	 * @throws
	 */
	public static synchronized void checkGlfyIsExceed(MyQueryFactory queryFactory, DataSummaryObj dso, CbhsDaysGlfyYs glfy) throws IllegalArgumentException, IllegalAccessException {
		CbhsMonthGlfyYs ys = getThisMonthGlfyYs(queryFactory, dso);
		CbhsDaysGlfyYs cb = getThisMonthSubmitGlfyTotalDetails(queryFactory, dso);
		CbhsDaysGlfyYs sub = new CbhsDaysGlfyYs();
		sub.setP_sjzjjf(BigDecimalUtils.getSub(ys.getP_sjzjjf(), cb.getP_sjzjjf(), glfy.getP_sjzjjf()));
		if (glfy.getP_sjzjjf().compareTo(BigDecimal.ZERO) > 0 && !BigDecimalUtils.goe(sub.getP_sjzjjf(), 0)) {
			List<uiExceedInfo> exceedInfos = Lists.newArrayList();
			uiExceedInfo info = new uiExceedInfo();
			info.setName("职教经费、工会经费、三类人员费用");
			info.setValue(sub.getP_sjzjjf().stripTrailingZeros());
			info.setUnit("元");
			boolean isExceed = getExceedInfo(sub, exceedInfos);
			if (!isExceed) {
				throw new ExceedException("管理费用", exceedInfos);
			}
		}
	}

	/**
	 * 获取当月零星用工总预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @return
	 */
	public static CbhsMonthZyLxygCbYs getThisMonthZyLxygCbYs(MyQueryFactory queryFactory, DataSummaryObj dso) {
		JPAQuery<BigDecimal> jqp_zyLxygCb = queryFactory
				.select(QCbhsMonthZyLxygCbYs.cbhsMonthZyLxygCbYs.total.sum())
				.from(QCbhsMonthZyLxygCbYs.cbhsMonthZyLxygCbYs)
				.where(QCbhsMonthZyLxygCbYs.cbhsMonthZyLxygCbYs.projectOid.eq(dso.getProjectOid()).and(QCbhsMonthZyLxygCbYs.cbhsMonthZyLxygCbYs.monthTimeStamp.goe(dso.getDt().getStartTime()))
						.and(QCbhsMonthZyLxygCbYs.cbhsMonthZyLxygCbYs.monthTimeStamp.loe(dso.getDt().getEndTime())));
		if (dso.getDeptOids().size() > 0) {
			jqp_zyLxygCb.where(QCbhsMonthZyLxygCbYs.cbhsMonthZyLxygCbYs.deptOid.in(dso.getDeptOids()));
		}
		BigDecimal p_zyLxygCb = jqp_zyLxygCb.fetchOne();
		CbhsMonthZyLxygCbYs ys = new CbhsMonthZyLxygCbYs();
		ys.setTotal(p_zyLxygCb != null ? p_zyLxygCb : new BigDecimal(0));
		return ys;
	}

	/**
	 * 获取当月已提交的零星用工
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @return
	 */
	public static CbhsDaysZyLxygCb getThisMonthSubmitZyLxygCb(MyQueryFactory queryFactory, DataSummaryObj dso) {
		JPAQuery<BigDecimal> jqp_zyLxygCb = queryFactory
				.select(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb.total.sum())
				.from(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb)
				.where(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb.projectOid.eq(dso.getProjectOid())
						.and(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb.dateTimeStamp.goe(dso.getDt().getStartTime()).and(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb.dateTimeStamp.loe(dso.getDt().getEndTime())))
						.and(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb.shStatus.eq(0)));
		if (dso.getDeptOids().size() > 0) {
			jqp_zyLxygCb.where(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb.deptOid.in(dso.getDeptOids()));
		}
		BigDecimal p_zyLxygCb = jqp_zyLxygCb.fetchOne();
		CbhsDaysZyLxygCb ys = new CbhsDaysZyLxygCb();
		ys.setTotal(p_zyLxygCb != null ? p_zyLxygCb : new BigDecimal(0));
		return ys;
	}

	/**
	 * 校验当前增加的零星用工成本是否已经超标
	 * 
	 * @param queryFactory
	 * @param request
	 * @param lxyg
	 * @param deptOids
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static synchronized void checkZyLxygIsExceed(MyQueryFactory queryFactory, DataSummaryObj dso, CbhsDaysZyLxygCb lxyg) throws IllegalArgumentException, IllegalAccessException {
		CbhsMonthZyLxygCbYs ys = getThisMonthZyLxygCbYs(queryFactory, dso);
		CbhsDaysZyLxygCb cb = getThisMonthSubmitZyLxygCb(queryFactory, dso);
		CbhsDaysZyLxygCb sub = new CbhsDaysZyLxygCb();
		sub.setTotal(BigDecimalUtils.getSub(ys.getTotal(), cb.getTotal(), lxyg.getTotal()));
		if (lxyg.getTotal().compareTo(BigDecimal.ZERO) > 0 && !BigDecimalUtils.goe(sub.getTotal(), 0)) {
			List<uiExceedInfo> exceedInfos = Lists.newArrayList();
			uiExceedInfo info = new uiExceedInfo();
			info.setName("总费用");
			info.setValue(sub.getTotal().stripTrailingZeros());
			info.setUnit("元");
			boolean isExceed = getExceedInfo(sub, exceedInfos);
			if (!isExceed) {
				throw new ExceedException("零星用工", exceedInfos);
			}
		}
	}

	/**
	 * 获取当月其他费用总预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @return
	 */
	public static CbhsMonthZyQtfyYs getThisMonthZyQtCbYs(MyQueryFactory queryFactory, DataSummaryObj dso) {
		JPAQuery<BigDecimal> jqp_zyLxygCb = queryFactory
				.select(QCbhsMonthZyQtfyYs.cbhsMonthZyQtfyYs.total.sum())
				.from(QCbhsMonthZyQtfyYs.cbhsMonthZyQtfyYs)
				.where(QCbhsMonthZyQtfyYs.cbhsMonthZyQtfyYs.projectOid.eq(dso.getProjectOid()).and(QCbhsMonthZyQtfyYs.cbhsMonthZyQtfyYs.monthTimeStamp.goe(dso.getDt().getStartTime()))
						.and(QCbhsMonthZyQtfyYs.cbhsMonthZyQtfyYs.monthTimeStamp.loe(dso.getDt().getEndTime())));
		if (dso.getDeptOids().size() > 0) {
			jqp_zyLxygCb.where(QCbhsMonthZyQtfyYs.cbhsMonthZyQtfyYs.deptOid.in(dso.getDeptOids()));
		}
		BigDecimal p_zyLxygCb = jqp_zyLxygCb.fetchOne();
		CbhsMonthZyQtfyYs ys = new CbhsMonthZyQtfyYs();
		ys.setTotal(p_zyLxygCb != null ? p_zyLxygCb : new BigDecimal(0));
		return ys;
	}

	/**
	 * 获取当月已提交的其他费用
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @return
	 */
	public static CbhsDaysZyQtCb getThisMonthSubmitZyQtCb(MyQueryFactory queryFactory, DataSummaryObj dso) {
		JPAQuery<BigDecimal> jqp_zyLxygCb = queryFactory
				.select(QCbhsDaysZyQtCb.cbhsDaysZyQtCb.total.sum())
				.from(QCbhsDaysZyQtCb.cbhsDaysZyQtCb)
				.where(QCbhsDaysZyQtCb.cbhsDaysZyQtCb.projectOid.eq(dso.getProjectOid())
						.and(QCbhsDaysZyQtCb.cbhsDaysZyQtCb.dateTimeStamp.goe(dso.getDt().getStartTime()).and(QCbhsDaysZyQtCb.cbhsDaysZyQtCb.dateTimeStamp.loe(dso.getDt().getEndTime())))
						.and(QCbhsDaysZyQtCb.cbhsDaysZyQtCb.shStatus.eq(0)));
		if (dso.getDeptOids().size() > 0) {
			jqp_zyLxygCb.where(QCbhsDaysZyQtCb.cbhsDaysZyQtCb.deptOid.in(dso.getDeptOids()));
		}
		BigDecimal p_zyLxygCb = jqp_zyLxygCb.fetchOne();
		CbhsDaysZyQtCb ys = new CbhsDaysZyQtCb();
		ys.setTotal(p_zyLxygCb != null ? p_zyLxygCb : new BigDecimal(0));
		return ys;
	}

	/**
	 * 校验当前其他费用是否超出当月总预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @param lxyg
	 * @param deptOids
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static synchronized void checkZyQtCbIsExceed(MyQueryFactory queryFactory, DataSummaryObj dso, CbhsDaysZyQtCb lxyg) throws IllegalArgumentException, IllegalAccessException {
		CbhsMonthZyQtfyYs ys = getThisMonthZyQtCbYs(queryFactory, dso);
		CbhsDaysZyQtCb cb = getThisMonthSubmitZyQtCb(queryFactory, dso);
		CbhsDaysZyQtCb sub = new CbhsDaysZyQtCb();
		sub.setTotal(BigDecimalUtils.getSub(ys.getTotal(), cb.getTotal(), lxyg.getTotal()));
		if (lxyg.getTotal().compareTo(BigDecimal.ZERO) > 0 && !BigDecimalUtils.goe(sub.getTotal(), 0)) {
			List<uiExceedInfo> exceedInfos = Lists.newArrayList();
			uiExceedInfo info = new uiExceedInfo();
			info.setName("总费用");
			info.setValue(sub.getTotal().stripTrailingZeros());
			info.setUnit("元");
			boolean isExceed = getExceedInfo(sub, exceedInfos);
			if (!isExceed) {
				throw new ExceedException("其他费用", exceedInfos);
			}
		}
	}

	/**
	 * 获取当月机械成本的总预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @return
	 */
	public static CbhsMonthZyJxCbYs getThisMonthZyJxCbYs(MyQueryFactory queryFactory, DataSummaryObj dso) {
		JPAQuery<Tuple> jqcbhsMonthZyJxCbYsTuple = queryFactory
				.select(QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs.p_zjf.sum(), QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs.p_zpf.sum(), QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs.p_clysf.sum(),
						QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs.p_jxdxf.sum(), QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs.total.sum())
				.from(QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs)
				.where(QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs.projectOid.eq(dso.getProjectOid()).and(QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs.monthTimeStamp.goe(dso.getDt().getStartTime()))
						.and(QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs.monthTimeStamp.loe(dso.getDt().getEndTime())));
		if (dso.getDeptOids().size() > 0) {
			jqcbhsMonthZyJxCbYsTuple.where(QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs.deptOid.in(dso.getDeptOids()));
		}
		Tuple cbhsMonthZyJxCbYsTuple = jqcbhsMonthZyJxCbYsTuple.fetchOne();
		CbhsMonthZyJxCbYs cbhsMonthZyJxCbYs = new CbhsMonthZyJxCbYs();
		cbhsMonthZyJxCbYs.setP_zjf(cbhsMonthZyJxCbYsTuple.get(0, BigDecimal.class) != null ? cbhsMonthZyJxCbYsTuple.get(0, BigDecimal.class) : new BigDecimal(0.00));
		cbhsMonthZyJxCbYs.setP_zpf(cbhsMonthZyJxCbYsTuple.get(1, BigDecimal.class) != null ? cbhsMonthZyJxCbYsTuple.get(1, BigDecimal.class) : new BigDecimal(0.00));
		cbhsMonthZyJxCbYs.setP_clysf(cbhsMonthZyJxCbYsTuple.get(2, BigDecimal.class) != null ? cbhsMonthZyJxCbYsTuple.get(2, BigDecimal.class) : new BigDecimal(0.00));
		cbhsMonthZyJxCbYs.setP_jxdxf(cbhsMonthZyJxCbYsTuple.get(3, BigDecimal.class) != null ? cbhsMonthZyJxCbYsTuple.get(3, BigDecimal.class) : new BigDecimal(0.00));
		cbhsMonthZyJxCbYs.setTotal(cbhsMonthZyJxCbYsTuple.get(4, BigDecimal.class) != null ? cbhsMonthZyJxCbYsTuple.get(4, BigDecimal.class) : new BigDecimal(0.00));
		return cbhsMonthZyJxCbYs;
	}

	/**
	 * 获取当月已提交的机械成本
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @return
	 */
	public static CbhsDaysZyJxCb getThisMonthSubmitZyJxCbYs(MyQueryFactory queryFactory, DataSummaryObj dso) {
		JPAQuery<Tuple> jqcbhsMonthZyJxCbYsTuple = queryFactory
				.select(QCbhsDaysZyJxCb.cbhsDaysZyJxCb.p_zjf.sum(), QCbhsDaysZyJxCb.cbhsDaysZyJxCb.p_zpf.sum(), QCbhsDaysZyJxCb.cbhsDaysZyJxCb.p_clysf.sum(),
						QCbhsDaysZyJxCb.cbhsDaysZyJxCb.p_jxdxf.sum(), QCbhsDaysZyJxCb.cbhsDaysZyJxCb.total.sum())
				.from(QCbhsDaysZyJxCb.cbhsDaysZyJxCb)
				.where(QCbhsDaysZyJxCb.cbhsDaysZyJxCb.projectOid.eq(dso.getProjectOid())
						.and(QCbhsDaysZyJxCb.cbhsDaysZyJxCb.dateTimeStamp.goe(dso.getDt().getStartTime()).and(QCbhsDaysZyJxCb.cbhsDaysZyJxCb.dateTimeStamp.loe(dso.getDt().getEndTime())))
						.and(QCbhsDaysZyJxCb.cbhsDaysZyJxCb.shStatus.eq(0)));
		if (dso.getDeptOids().size() > 0) {
			jqcbhsMonthZyJxCbYsTuple.where(QCbhsDaysZyJxCb.cbhsDaysZyJxCb.deptOid.in(dso.getDeptOids()));
		}
		Tuple cbhsMonthZyJxCbYsTuple = jqcbhsMonthZyJxCbYsTuple.fetchOne();
		CbhsDaysZyJxCb cbhsDaysZyJxCb = new CbhsDaysZyJxCb();
		cbhsDaysZyJxCb.setP_zjf(cbhsMonthZyJxCbYsTuple.get(0, BigDecimal.class) != null ? cbhsMonthZyJxCbYsTuple.get(0, BigDecimal.class) : new BigDecimal(0.00));
		cbhsDaysZyJxCb.setP_zpf(cbhsMonthZyJxCbYsTuple.get(1, BigDecimal.class) != null ? cbhsMonthZyJxCbYsTuple.get(1, BigDecimal.class) : new BigDecimal(0.00));
		cbhsDaysZyJxCb.setP_clysf(cbhsMonthZyJxCbYsTuple.get(2, BigDecimal.class) != null ? cbhsMonthZyJxCbYsTuple.get(2, BigDecimal.class) : new BigDecimal(0.00));
		cbhsDaysZyJxCb.setP_jxdxf(cbhsMonthZyJxCbYsTuple.get(3, BigDecimal.class) != null ? cbhsMonthZyJxCbYsTuple.get(3, BigDecimal.class) : new BigDecimal(0.00));
		cbhsDaysZyJxCb.setTotal(cbhsMonthZyJxCbYsTuple.get(4, BigDecimal.class) != null ? cbhsMonthZyJxCbYsTuple.get(4, BigDecimal.class) : new BigDecimal(0.00));
		return cbhsDaysZyJxCb;
	}

	public static synchronized void checkZyJxCbIsExceed(MyQueryFactory queryFactory, DataSummaryObj dso, CbhsDaysZyJxCb zyJx) throws IllegalArgumentException, IllegalAccessException {
		CbhsMonthZyJxCbYs ys = getThisMonthZyJxCbYs(queryFactory, dso);
		CbhsDaysZyJxCb cb = getThisMonthSubmitZyJxCbYs(queryFactory, dso);
		CbhsDaysZyJxCb sub = new CbhsDaysZyJxCb();
		sub.setTotal(BigDecimalUtils.getSub(ys.getTotal(), cb.getTotal(), zyJx.getTotal()));
		if (zyJx.getTotal().compareTo(BigDecimal.ZERO) > 0 && !BigDecimalUtils.goe(sub.getTotal(), 0)) {
			List<uiExceedInfo> exceedInfos = Lists.newArrayList();
			uiExceedInfo info = new uiExceedInfo();
			info.setName("总费用");
			info.setValue(sub.getTotal().stripTrailingZeros());
			info.setUnit("元");
			boolean isExceed = getExceedInfo(sub, exceedInfos);
			if (!isExceed) {
				throw new ExceedException("机械费用", exceedInfos);
			}
		}
		if (zyJx.getRyOid() != null && zyJx.getRyOid() > 0 && zyJx.getRyUseCount() != null && zyJx.getRyUseCount().compareTo(BigDecimal.ZERO) > 0) {
			CbhsDaysZyCailiaoCb cailiaoCb = new CbhsDaysZyCailiaoCb();
			cailiaoCb.setCailiaoOid(zyJx.getRyOid());
			cailiaoCb.setCount(zyJx.getRyUseCount());
			cailiaoCb.setGlobalGclYsOid(zyJx.getGlobalGclYsOid());
			cailiaoCb.setDeptOid(zyJx.getDeptOid());
			cailiaoCb.setCailiaoName(zyJx.getRyName());
			List<CbhsDaysZyCailiaoCb> cailiaos = Lists.newArrayList();
			cailiaos.add(cailiaoCb);
			List<Integer> globalGclOids = Lists.newArrayList();
			globalGclOids.add(cailiaoCb.getGlobalGclYsOid());
			try {
				checkZyCailiaoCbIsExceed(queryFactory, dso, cailiaos);
			} catch (ExceedException e) {
				throw new ExceedException("机械费用燃油超出预算", e.getInfo().getExceedInfos());
			}
		}
	}

	/**
	 * 获取部门当月 各 工程量的材料使用量预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @param globalGclOids
	 * @return
	 */
	public static Map<String, CbhsMonthZyCailiaoCbYs> getThisMonthZyCailiaoCbYs(MyQueryFactory queryFactory, DataSummaryObj dso) {
		JPAQuery<CbhsMonthZyCailiaoCbYs> jqcbhsMonthZyCailiaoCbYsTuple = queryFactory
				.select(Projections.bean(CbhsMonthZyCailiaoCbYs.class, QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.globalGclYsOid.as(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.globalGclYsOid),
						QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.cailiaoOid.as(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.cailiaoOid), QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.count
								.sum().as(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.count)))
				.from(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs)
				.where(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.projectOid.eq(dso.getProjectOid())
						.and(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.monthTimeStamp.goe(dso.getDt().getStartTime()))
						.and(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.monthTimeStamp.loe(dso.getDt().getEndTime())));
		if (dso.getGlobalGclOids() != null && dso.getGlobalGclOids().size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.globalGclYsOid.in(dso.getGlobalGclOids()));
		}
		if (dso.getDeptOids() != null && dso.getDeptOids().size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.deptOid.in(dso.getDeptOids()));
		}
		jqcbhsMonthZyCailiaoCbYsTuple.groupBy(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.globalGclYsOid, QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.cailiaoOid);
		List<CbhsMonthZyCailiaoCbYs> list = jqcbhsMonthZyCailiaoCbYsTuple.fetch();
		Map<String, CbhsMonthZyCailiaoCbYs> map = Maps.uniqueIndex(list, new Function<CbhsMonthZyCailiaoCbYs, String>() {
			@Override
			public String apply(CbhsMonthZyCailiaoCbYs input) {
				return input.getGlobalGclYsOid().intValue() + "@" + input.getCailiaoOid().intValue();
			}
		});
		return map;
	}

	/**
	 * 获取部门当月 各 工程量的材料已提交的使用量
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @param globalGclOids
	 * @return
	 */
	public static Map<String, CbhsDaysZyCailiaoCb> getThisMonthSubmitZyCailiaoCb(MyQueryFactory queryFactory, DataSummaryObj dso) {
		JPAQuery<CbhsDaysZyCailiaoCb> jqcbhsMonthZyCailiaoCbYsTuple = queryFactory
				.select(Projections.bean(CbhsDaysZyCailiaoCb.class, QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.globalGclYsOid.as(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.globalGclYsOid),
						QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.cailiaoOid.as(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.cailiaoOid),
						QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.count.sum().as(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.count)))
				.from(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb)
				.where(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.projectOid
						.eq(dso.getProjectOid())
						.and(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.dateTimeStamp.goe(dso.getDt().getStartTime()).and(
								QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.dateTimeStamp.loe(dso.getDt().getEndTime()))).and(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.shStatus.eq(0)));
		if (dso.getGlobalGclOids() != null && dso.getGlobalGclOids().size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.globalGclYsOid.in(dso.getGlobalGclOids()));
		}
		if (dso.getDeptOids() != null && dso.getDeptOids().size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.deptOid.in(dso.getDeptOids()));
		}
		jqcbhsMonthZyCailiaoCbYsTuple.groupBy(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.globalGclYsOid, QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.cailiaoOid);
		List<CbhsDaysZyCailiaoCb> list = jqcbhsMonthZyCailiaoCbYsTuple.fetch();
		Map<String, CbhsDaysZyCailiaoCb> map = Maps.uniqueIndex(list, new Function<CbhsDaysZyCailiaoCb, String>() {
			@Override
			public String apply(CbhsDaysZyCailiaoCb input) {
				return input.getGlobalGclYsOid().intValue() + "@" + input.getCailiaoOid().intValue();
			}
		});
		return map;
	}

	/**
	 * 校验当前提交的材料 是否已经超出 部门在工程量下的预算量
	 * 
	 * @param queryFactory
	 * @param request
	 * @param cailiaos
	 * @param deptOids
	 * @param globalGclOids
	 */
	public static synchronized void checkZyCailiaoCbIsExceed(MyQueryFactory queryFactory, DataSummaryObj dso, List<CbhsDaysZyCailiaoCb> cailiaos) {
		Map<String, CbhsMonthZyCailiaoCbYs> ys = getThisMonthZyCailiaoCbYs(queryFactory, dso);
		Map<String, CbhsDaysZyCailiaoCb> cb = getThisMonthSubmitZyCailiaoCb(queryFactory, dso);
		boolean flag = true;
		List<uiExceedInfo> exceedInfos = Lists.newArrayList();
		if (cailiaos != null && cailiaos.size() > 0) {
			for (CbhsDaysZyCailiaoCb cailiao : cailiaos) {
				BigDecimal ysCount = null;
				if (ys.containsKey(cailiao.getGlobalGclYsOid() + "@" + cailiao.getCailiaoOid())) {
					ysCount = ys.get(cailiao.getGlobalGclYsOid() + "@" + cailiao.getCailiaoOid()).getCount();
				}
				ysCount = ysCount != null ? ysCount : BigDecimal.ZERO;
				BigDecimal cbCount = null;
				if (cb.containsKey(cailiao.getGlobalGclYsOid() + "@" + cailiao.getCailiaoOid())) {
					cbCount = cb.get(cailiao.getGlobalGclYsOid() + "@" + cailiao.getCailiaoOid()).getCount();
				}
				cbCount = cbCount != null ? cbCount : new BigDecimal(0);
				BigDecimal subJG = BigDecimalUtils.getSub(ysCount, cbCount, cailiao.getCount());
				if (BigDecimalUtils.gt(cailiao.getCount(), 0) && BigDecimalUtils.lt(subJG, 0)) {
					uiExceedInfo info = new uiExceedInfo();
					info.setName(cailiao.getCailiaoName());
					info.setValue(subJG.stripTrailingZeros());
					info.setUnit(cailiao.getUnit());
					exceedInfos.add(info);
					flag = false;
				}
			}
		}
		if (!flag) {
			throw new ExceedException("自营工程量材料", exceedInfos);
		}
	}

	/**
	 * 获取该月临建项目总预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @return
	 */
	public static Map<Integer, CbhsMonthFbLjxmCbYs> getThisMonthFbLjxmYs(MyQueryFactory queryFactory, RequestMbYsFetch request, CbhsDaysFbLjxmCb ljxm) {
		JPAQuery<CbhsMonthFbLjxmCbYs> jqcbhsMonthGlfyYsTuple = queryFactory
				.select(Projections.bean(CbhsMonthFbLjxmCbYs.class, QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.oid,
						QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.total.sum().as(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.total)))
				.from(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs)
				.where(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.projectOid.eq(request.getProjectOid()).and(
						QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.monthTimeStamp.eq(request.getMonth()).and(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.oid.eq(ljxm.getLjxmYsOid()))))
				.groupBy(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.oid);
		List<CbhsMonthFbLjxmCbYs> yss = jqcbhsMonthGlfyYsTuple.fetch();
		Map<Integer, CbhsMonthFbLjxmCbYs> maps = Maps.uniqueIndex(yss, new Function<CbhsMonthFbLjxmCbYs, Integer>() {
			@Override
			public Integer apply(CbhsMonthFbLjxmCbYs input) {
				// TODO Auto-generated method stub
				return input.getOid().intValue();
			}
		});
		return maps;
	}

	/**
	 * 获取该月临建项目预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @return
	 */
	public static CbhsMonthFbLjxmCbYs getThisFbLjxmYs(MyQueryFactory queryFactory, RequestMbYsFetch request, CbhsDaysFbLjxmCb ljxm) {
		CbhsMonthFbLjxmCbYs cbhsMonthFbLjxmCbYs = queryFactory.selectFrom(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs).where(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.oid.eq(ljxm.getLjxmYsOid()))
				.fetchFirst();
		return cbhsMonthFbLjxmCbYs;
	}

	/**
	 * 获取该月已提交的临建项目总成本
	 * 
	 * @param queryFactory
	 * @param request
	 * @return
	 */
	public static CbhsDaysFbLjxmCb getThisFbLjxmSubmitTotalDetails(MyQueryFactory queryFactory, RequestMbYsFetch request, CbhsDaysFbLjxmCb ljxm) {
		JPAQuery<CbhsDaysFbLjxmCb> jqcbhsMonthGlfyYsTuple = queryFactory
				.select(Projections.bean(CbhsDaysFbLjxmCb.class, QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.ljxmYsOid, QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.ljxmYsName, QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.total
						.sum().as(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.total), QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.count.sum().as(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.count)))
				.from(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb).where(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.ljxmYsOid.eq(ljxm.getLjxmYsOid()).and(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.shStatus.eq(0)));
		if (ljxm.getOid() > 0) { // 修改
			jqcbhsMonthGlfyYsTuple.where(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.oid.ne(ljxm.getOid()));
		}
		CbhsDaysFbLjxmCb cbs = jqcbhsMonthGlfyYsTuple.fetchFirst();
		return cbs;
	}

	/**
	 * 校验临建成本数量是否超标
	 * 
	 * @param queryFactory
	 * @param request
	 * @param ljxm
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static synchronized void checkFbLjxmCbCountIsExceed(MyQueryFactory queryFactory, RequestMbYsFetch request, CbhsDaysFbLjxmCb ljxm) throws IllegalArgumentException, IllegalAccessException {
		CbhsMonthFbLjxmCbYs ys = getThisFbLjxmYs(queryFactory, request, ljxm);
		CbhsDaysFbLjxmCb cb = getThisFbLjxmSubmitTotalDetails(queryFactory, request, ljxm);
		if (ys == null) {
			ys = new CbhsMonthFbLjxmCbYs();
		}
		if (cb == null) {
			cb = new CbhsDaysFbLjxmCb();
		}
		CbhsDaysFbLjxmCb sub = new CbhsDaysFbLjxmCb();
		sub.setCount(BigDecimalUtils.getSub(ys.getCount(), cb.getCount(), ljxm.getCount()));
		if (ljxm.getCount().compareTo(BigDecimal.ZERO) > 0 && !BigDecimalUtils.goe(sub.getCount(), 0)) {
			List<uiExceedInfo> exceedInfos = Lists.newArrayList();
			uiExceedInfo info = new uiExceedInfo();
			info.setName("总数量");
			info.setValue(sub.getCount().stripTrailingZeros());
			info.setUnit(ys.getUnit());
			exceedInfos.add(info);
			if (sub.getCount().compareTo(BigDecimal.ZERO) < 0) {
				throw new ExceedException("临建项目-" + ys.getName(), exceedInfos);
			}
		}
	}

	/**
	 * 校验临建成本价格是否超标
	 * 
	 * @param queryFactory
	 * @param request
	 * @param ljxm
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	public static synchronized void checkFbLjxmCbIsExceed(MyQueryFactory queryFactory, RequestMbYsFetch request, CbhsDaysFbLjxmCb ljxm) throws IllegalArgumentException, IllegalAccessException {
		CbhsMonthFbLjxmCbYs ys = getThisFbLjxmYs(queryFactory, request, ljxm);
		CbhsDaysFbLjxmCb cb = getThisFbLjxmSubmitTotalDetails(queryFactory, request, ljxm);
		if (ys == null) {
			ys = new CbhsMonthFbLjxmCbYs();
		}
		if (cb == null) {
			cb = new CbhsDaysFbLjxmCb();
		}
		CbhsDaysFbLjxmCb sub = new CbhsDaysFbLjxmCb();
		sub.setTotal(BigDecimalUtils.getSub(ys.getTotal(), cb.getTotal(), ljxm.getTotal()));
		if (ljxm.getTotal().compareTo(BigDecimal.ZERO) > 0 && !BigDecimalUtils.goe(sub.getTotal(), 0)) {
			List<uiExceedInfo> exceedInfos = Lists.newArrayList();
			uiExceedInfo info = new uiExceedInfo();
			info.setName("总费用");
			info.setValue(sub.getTotal().stripTrailingZeros());
			info.setUnit("元");
			exceedInfos.add(info);
			if (sub.getTotal().compareTo(BigDecimal.ZERO) < 0) {
				throw new ExceedException("临建项目-" + ys.getName(), exceedInfos);
			}
		}
	}

	/**
	 * 获取该月分包工程量总预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @param globalGclOids
	 * @return
	 */
	public static Map<Integer, CbhsGclQdYs> getGlobalGclCbYs(MyQueryFactory queryFactory, RequestMbYsFetch request, List<Integer> fbGclOids) {
		JPAQuery<CbhsGclQdYs> jqcbhsMonthZyCailiaoCbYsTuple = queryFactory
				.select(Projections.bean(CbhsGclQdYs.class, QCbhsGclQdYs.cbhsGclQdYs.oid, QCbhsGclQdYs.cbhsGclQdYs.count.sum().as(QCbhsGclQdYs.cbhsGclQdYs.count), QCbhsGclQdYs.cbhsGclQdYs.totaPrice
						.sum().as(QCbhsGclQdYs.cbhsGclQdYs.totaPrice))).from(QCbhsGclQdYs.cbhsGclQdYs).where(QCbhsGclQdYs.cbhsGclQdYs.projectOid.eq(request.getProjectOid()));
		if (fbGclOids != null & fbGclOids.size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsGclQdYs.cbhsGclQdYs.oid.in(fbGclOids));
		}
		jqcbhsMonthZyCailiaoCbYsTuple.groupBy(QCbhsGclQdYs.cbhsGclQdYs.oid);
		List<CbhsGclQdYs> list = jqcbhsMonthZyCailiaoCbYsTuple.fetch();
		Map<Integer, CbhsGclQdYs> map = Maps.uniqueIndex(list, new Function<CbhsGclQdYs, Integer>() {
			@Override
			public Integer apply(CbhsGclQdYs input) {
				return input.getOid().intValue();
			}
		});
		return map;
	}

	/**
	 * 获取该月已提交的分包工程量
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @param globalGclOids
	 * @return
	 */
	public static Map<Integer, CbhsDaysFbGclTj> getThisMonthSubmitFbGclCb(MyQueryFactory queryFactory, RequestMbYsFetch request, List<Integer> globalGclOids) {
		DateTime dt = new DateTime(request.getMonth());
		long startTime = dt.getMillis();
		long endTime = dt.plusMonths(1).getMillis();
		JPAQuery<CbhsDaysFbGclTj> jqcbhsMonthZyCailiaoCbYsTuple = queryFactory
				.select(Projections.bean(CbhsDaysFbGclTj.class, QCbhsDaysFbGclTj.cbhsDaysFbGclTj.fbGclYsOid, QCbhsDaysFbGclTj.cbhsDaysFbGclTj.count.sum().as(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.count),
						QCbhsDaysFbGclTj.cbhsDaysFbGclTj.total.sum().as(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.total)))
				.from(QCbhsDaysFbGclTj.cbhsDaysFbGclTj)
				.where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.projectOid.eq(request.getProjectOid())
						.and(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.dateTimeStamp.goe(startTime).and(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.dateTimeStamp.loe(endTime)))
						.and(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.shStatus.eq(0)));
		if (globalGclOids != null & globalGclOids.size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.fbGclYsOid.in(globalGclOids));
		}
		jqcbhsMonthZyCailiaoCbYsTuple.groupBy(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.fbGclYsOid);
		List<CbhsDaysFbGclTj> list = jqcbhsMonthZyCailiaoCbYsTuple.fetch();
		Map<Integer, CbhsDaysFbGclTj> map = Maps.uniqueIndex(list, new Function<CbhsDaysFbGclTj, Integer>() {
			@Override
			public Integer apply(CbhsDaysFbGclTj input) {
				// TODO Auto-generated method stub
				return input.getFbGclYsOid();
			}
		});
		return map;
	}

	/**
	 * 校验 分包队的分包工程量是否超出预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @param fbgcl
	 * @param globalGclOids
	 */
	public static synchronized void checkFbGclIsExceed(MyQueryFactory queryFactory, RequestMbYsFetch request, CbhsDaysFbGclTj fbgcl, List<Integer> globalGclOids) {
		Map<Integer, CbhsMonthFbGcCbYs> ys = getThisMonthFbGclCbYs(queryFactory, request, globalGclOids);
		Map<Integer, CbhsDaysFbGclTj> cb = getThisMonthSubmitFbGclCb(queryFactory, request, globalGclOids);
		CbhsMonthFbGcCbYs t_ys = ys.get(fbgcl.getFbGclYsOid());
		CbhsDaysFbGclTj t_cb = cb.get(fbgcl.getFbGclYsOid());
		BigDecimal company_gcl_ys = t_ys != null ? t_ys.getCount() : BigDecimal.ZERO;
		BigDecimal company_gcl_cb = t_cb != null ? t_cb.getCount() : BigDecimal.ZERO;
		BigDecimal _t = BigDecimalUtils.getSub(company_gcl_ys, company_gcl_cb, fbgcl.getCount());
		if (fbgcl.getCount().compareTo(BigDecimal.ZERO) > 0 && _t.compareTo(BigDecimal.ZERO) < 0) {
			List<uiExceedInfo> exceedInfos = Lists.newArrayList();
			uiExceedInfo info = new uiExceedInfo();
			info.setName(fbgcl.getFbCompanyName() + fbgcl.getFbGclYsName());
			info.setValue(_t.stripTrailingZeros());
			info.setUnit(fbgcl.getUnit());
			exceedInfos.add(info);
			throw new ExceedException("分包工程量", exceedInfos);
		}
	}

	/**
	 * 获取该月分包工程量总预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @param globalGclOids
	 * @return
	 */
	public static Map<String, BigDecimal> getThisMonthFbGclPriceCbYs(MyQueryFactory queryFactory, RequestMbYsFetch request, List<Integer> fbGclOids) {
		JPAQuery<Tuple> jqcbhsMonthZyCailiaoCbYsTuple = queryFactory
				.select(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.fbCompanyOid, QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.oid, QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.total.sum())
				.from(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs)
				.where(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.projectOid.eq(request.getProjectOid()).and(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.monthTimeStamp.eq(request.getMonth())));
		if (fbGclOids != null & fbGclOids.size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.oid.in(fbGclOids));
		}
		jqcbhsMonthZyCailiaoCbYsTuple.groupBy(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.fbCompanyOid, QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.oid);
		List<Tuple> list = jqcbhsMonthZyCailiaoCbYsTuple.fetch();
		Map<String, BigDecimal> map = Maps.newHashMap();
		if (list.size() > 0) {
			for (Tuple tp : list) {
				map.put(tp.get(0, Integer.class) + "@" + tp.get(1, Integer.class), tp.get(2, BigDecimal.class));
			}
		}
		return map;
	}

	public static Map<Integer, CbhsMonthFbGcCbYs> getThisMonthFbGclCbYs(MyQueryFactory queryFactory, RequestMbYsFetch request, List<Integer> fbGclOids) {
		JPAQuery<CbhsMonthFbGcCbYs> jqcbhsMonthZyCailiaoCbYsTuple = queryFactory
				.select(Projections.bean(CbhsMonthFbGcCbYs.class, QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.oid,
						QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.count.sum().as(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.count),
						QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.total.sum().as(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.total))).from(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs)
				.where(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.projectOid.eq(request.getProjectOid()).and(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.monthTimeStamp.eq(request.getMonth())));
		if (fbGclOids != null & fbGclOids.size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.oid.in(fbGclOids));
		}
		jqcbhsMonthZyCailiaoCbYsTuple.groupBy(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.oid);
		List<CbhsMonthFbGcCbYs> list = jqcbhsMonthZyCailiaoCbYsTuple.fetch();
		Map<Integer, CbhsMonthFbGcCbYs> map = Maps.uniqueIndex(list, new Function<CbhsMonthFbGcCbYs, Integer>() {
			@Override
			public Integer apply(CbhsMonthFbGcCbYs input) {
				return input.getOid().intValue();
			}
		});
		return map;
	}

	/**
	 * 获取该月已提交的分包工程量
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @param globalGclOids
	 * @return
	 */
	public static Map<String, BigDecimal> getThisMonthSubmitFbGclPriceCb(MyQueryFactory queryFactory, RequestMbYsFetch request, List<Integer> globalGclOids) {
		DateTime dt = new DateTime(request.getMonth());
		long startTime = dt.getMillis();
		long endTime = dt.plusMonths(1).getMillis();
		JPAQuery<Tuple> jqcbhsMonthZyCailiaoCbYsTuple = queryFactory
				.select(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.fbCompanyOid, QCbhsDaysFbGclTj.cbhsDaysFbGclTj.fbGclYsOid, QCbhsDaysFbGclTj.cbhsDaysFbGclTj.total.sum())
				.from(QCbhsDaysFbGclTj.cbhsDaysFbGclTj)
				.where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.projectOid.eq(request.getProjectOid())
						.and(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.dateTimeStamp.goe(startTime).and(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.dateTimeStamp.loe(endTime)))
						.and(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.shStatus.eq(0)));
		if (globalGclOids != null & globalGclOids.size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.fbGclYsOid.in(globalGclOids));
		}
		jqcbhsMonthZyCailiaoCbYsTuple.groupBy(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.fbCompanyOid, QCbhsDaysFbGclTj.cbhsDaysFbGclTj.fbGclYsOid);
		List<Tuple> list = jqcbhsMonthZyCailiaoCbYsTuple.fetch();
		Map<String, BigDecimal> map = Maps.newHashMap();
		if (list.size() > 0) {
			for (Tuple tp : list) {
				map.put(tp.get(0, Integer.class) + "@" + tp.get(1, Integer.class), tp.get(2, BigDecimal.class));
			}
		}
		return map;
	}

	/**
	 * 校验 分包队的分包工程量是否超出预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @param fbgcl
	 * @param globalGclOids
	 */
	public static synchronized void checkFbGclPriceIsExceed(MyQueryFactory queryFactory, RequestMbYsFetch request, CbhsDaysFbGclTj fbgcl, List<Integer> globalGclOids) {
		// Map<String, BigDecimal> ys = getThisMonthFbGclCbYs(queryFactory,
		// request, globalGclOids);
		// Map<String, BigDecimal> cb = getThisMonthSubmitFbGclCb(queryFactory,
		// request, globalGclOids);
		// BigDecimal company_gcl_ys = ys.get(fbgcl.getFbCompanyOid() + "@" +
		// fbgcl.getFbGclYsOid());
		// BigDecimal company_gcl_cb = cb.get(fbgcl.getFbCompanyOid() + "@" +
		// fbgcl.getFbGclYsOid());
		// company_gcl_ys = company_gcl_ys != null ? company_gcl_ys : new
		// BigDecimal(0);
		// company_gcl_cb = company_gcl_cb != null ? company_gcl_cb : new
		// BigDecimal(0);
		// Preconditions.checkArgument(fbgcl.getCount().compareTo(BigDecimal.ZERO)
		// == 0 ||
		// (company_gcl_ys.subtract(company_gcl_cb).compareTo(fbgcl.getCount())
		// > 0), "该分包队的分包工程量已超出当月预算!");
		Map<Integer, CbhsMonthFbGcCbYs> ys = getThisMonthFbGclCbYs(queryFactory, request, globalGclOids);
		Map<Integer, CbhsDaysFbGclTj> cb = getThisMonthSubmitFbGclCb(queryFactory, request, globalGclOids);
		CbhsMonthFbGcCbYs t_ys = ys.get(fbgcl.getFbGclYsOid());
		CbhsDaysFbGclTj t_cb = cb.get(fbgcl.getFbGclYsOid());
		BigDecimal company_gcl_ys = t_ys.getTotal();
		BigDecimal company_gcl_cb = t_cb.getTotal();
		company_gcl_ys = company_gcl_ys != null ? company_gcl_ys : new BigDecimal(0);
		company_gcl_cb = company_gcl_cb != null ? company_gcl_cb : new BigDecimal(0);

		// Map<String, BigDecimal> ys = getThisMonthFbGclCbYs(queryFactory,
		// request, globalGclOids);
		// Map<String, BigDecimal> cb = getThisMonthSubmitFbGclCb(queryFactory,
		// request, globalGclOids);
		// BigDecimal company_gcl_ys = ys.get(fbgcl.getFbCompanyOid() + "@" +
		// fbgcl.getFbGclYsOid());
		// BigDecimal company_gcl_cb = cb.get(fbgcl.getFbCompanyOid() + "@" +
		// fbgcl.getFbGclYsOid());
		// company_gcl_ys = company_gcl_ys != null ? company_gcl_ys : new
		// BigDecimal(0);
		// company_gcl_cb = company_gcl_cb != null ? company_gcl_cb : new
		// BigDecimal(0);
		BigDecimal _t = BigDecimalUtils.getSub(company_gcl_ys, company_gcl_cb, fbgcl.getTotal());
		if (fbgcl.getTotal().compareTo(BigDecimal.ZERO) > 0 && _t.compareTo(BigDecimal.ZERO) < 0) {
			List<uiExceedInfo> exceedInfos = Lists.newArrayList();
			uiExceedInfo info = new uiExceedInfo();
			info.setName(fbgcl.getFbCompanyName() + fbgcl.getFbGclYsName());
			info.setValue(_t.stripTrailingZeros());
			info.setUnit("元");
			exceedInfos.add(info);
			throw new ExceedException("分包工程量价格统计", exceedInfos);
		}
	}

	/**
	 * 获取部门当月 各 分包工程的材料使用量预算
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @param globalGclOids
	 * @return
	 */
	public static Map<String, BigDecimal> getThisMonthFbCailiaoCbYs(MyQueryFactory queryFactory, RequestMbYsFetch request, List<Integer> deptOids, List<Integer> fbGclOids) {
		JPAQuery<Tuple> jqcbhsMonthZyCailiaoCbYsTuple = queryFactory
				.select(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.globalGclYsOid, QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.cailiaoOid,
						QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.count.sum()).from(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs)
				.where(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.projectOid.eq(request.getProjectOid()).and(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.monthTimeStamp.eq(request.getMonth())));
		if (deptOids != null && deptOids.size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.deptOid.in(deptOids));
		}
		if (fbGclOids != null & fbGclOids.size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.globalGclYsOid.in(fbGclOids));
		}
		jqcbhsMonthZyCailiaoCbYsTuple.groupBy(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.globalGclYsOid, QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.cailiaoOid);
		List<Tuple> list = jqcbhsMonthZyCailiaoCbYsTuple.fetch();
		Map<String, BigDecimal> map = Maps.newHashMap();
		if (list.size() > 0) {
			for (Tuple tp : list) {
				map.put(tp.get(0, Integer.class) + "@" + tp.get(1, Integer.class), tp.get(2, BigDecimal.class));
			}
		}
		return map;
	}

	/**
	 * 获取部门当月 各 工程量的材料已提交的使用量
	 * 
	 * @param queryFactory
	 * @param request
	 * @param deptOids
	 * @param globalGclOids
	 * @return
	 */
	public static Map<String, BigDecimal> getThisMonthSubmitFbCailiaoCb(MyQueryFactory queryFactory, RequestMbYsFetch request, List<Integer> deptOids, List<Integer> globalGclOids) {
		DateTime dt = new DateTime(request.getMonth());
		long startTime = dt.getMillis();
		long endTime = dt.plusMonths(1).getMillis();
		JPAQuery<Tuple> jqcbhsMonthZyCailiaoCbYsTuple = queryFactory
				.select(QCbhsZytj.cbhsZytj.globalGclYsOid, QCbhsZytjZC.cbhsZytjZC.clOid, QCbhsZytjZC.cbhsZytjZC.clCount.sum())
				.from(QCbhsZytj.cbhsZytj, QCbhsZytjZC.cbhsZytjZC)
				.where(QCbhsZytjZC.cbhsZytjZC.zytjOid.eq(QCbhsZytj.cbhsZytj.oid))
				.where(QCbhsZytj.cbhsZytj.projectOid.eq(request.getProjectOid()).and(QCbhsZytj.cbhsZytj.dateTimeStamp.goe(startTime).and(QCbhsZytj.cbhsZytj.dateTimeStamp.loe(endTime)))
						.and(QCbhsZytj.cbhsZytj.shStatus.eq(0)));
		if (deptOids != null && deptOids.size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsZytj.cbhsZytj.deptOid.in(deptOids));
		}
		if (globalGclOids != null & globalGclOids.size() > 0) {
			jqcbhsMonthZyCailiaoCbYsTuple.where(QCbhsZytj.cbhsZytj.globalGclYsOid.in(globalGclOids));
		}
		jqcbhsMonthZyCailiaoCbYsTuple.groupBy(QCbhsZytj.cbhsZytj.globalGclYsOid, QCbhsZytjZC.cbhsZytjZC.clOid);
		List<Tuple> list = jqcbhsMonthZyCailiaoCbYsTuple.fetch();
		Map<String, BigDecimal> map = Maps.newHashMap();
		if (list.size() > 0) {
			for (Tuple tp : list) {
				map.put(tp.get(0, Integer.class) + "@" + tp.get(1, Integer.class), tp.get(2, BigDecimal.class));
			}
		}
		return map;
	}

	/**
	 * 校验当前提交的材料 是否已经超出 部门在工程量下的预算量
	 * 
	 * @param queryFactory
	 * @param request
	 * @param cailiaos
	 * @param deptOids
	 * @param globalGclOids
	 */
	public static synchronized void checkFbCailiaoCbIsExceed(MyQueryFactory queryFactory, RequestMbYsFetch request, CbhsZytj zytj, ArrayList<CbhsZytjZC> cailiaos, List<Integer> deptOids,
			List<Integer> globalGclOids) {
		Map<String, BigDecimal> ys = getThisMonthFbCailiaoCbYs(queryFactory, request, deptOids, globalGclOids);
		Map<String, BigDecimal> cb = getThisMonthSubmitFbCailiaoCb(queryFactory, request, deptOids, globalGclOids);
		boolean flag = true;
		List<uiExceedInfo> exceedInfos = Lists.newArrayList();
		if (cailiaos != null && cailiaos.size() > 0) {
			for (CbhsZytjZC cailiao : cailiaos) {
				BigDecimal ysCount = ys.get(globalGclOids.get(0) + "@" + cailiao.getClOid());
				ysCount = ysCount != null ? ysCount : new BigDecimal(0);
				BigDecimal cbCount = cb.get(globalGclOids.get(0) + "@" + cailiao.getClOid());
				cbCount = cbCount != null ? cbCount : new BigDecimal(0);
				BigDecimal subJG = BigDecimalUtils.getSub(ysCount, cbCount, cailiao.getClCount());
				if (BigDecimalUtils.gt(cailiao.getClCount(), 0) && BigDecimalUtils.lt(subJG, 0)) {
					uiExceedInfo info = new uiExceedInfo();
					info.setName(cailiao.getClName());
					info.setValue(subJG.stripTrailingZeros());
					info.setUnit(cailiao.getClUnit());
					exceedInfos.add(info);
					flag = false;
				}
			}
		}
		if (!flag) {
			throw new ExceedException("部门分包工程材料", exceedInfos);
		}
		if (zytj != null && zytj.getRyID() != null && zytj.getRyID() > 0 && zytj.getRyUseCount() != null && zytj.getRyUseCount().compareTo(BigDecimal.ZERO) > 0) {
			try {
				CbhsZytjZC zc = new CbhsZytjZC();
				zc.setClOid(zytj.getRyID());
				zc.setClName(zytj.getRyName());
				zc.setClCount(zytj.getRyUseCount());
				zc.setClUnit(zytj.getRyUnit());
				DataSummaryUtils.checkFbCailiaoCbIsExceed(queryFactory, request, null, Lists.newArrayList(zc), deptOids, globalGclOids);
			} catch (ExceedException e) {
				throw new ExceedException("部门分包工程燃油", e.getInfo().getExceedInfos());
			}
		}
	}
}
