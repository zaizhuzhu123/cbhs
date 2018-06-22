package com.server.handler.imp;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.server.handler.ClhxApisService;
import com.server.jpa.MyJPAQuery;
import com.server.jpa.MyJPAQuery.PagerResult;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsGclQdYs;
import com.server.pojo.bean.QCbhsDaysZyCailiaoCb;
import com.server.pojo.bean.QCbhsDaysZyJxCb;
import com.server.pojo.bean.QCbhsGclQdYs;
import com.server.pojo.bean.QCbhsMonthFbCailiaoCbYs;
import com.server.pojo.bean.QCbhsMonthZyCailiaoCbYs;
import com.server.pojo.bean.QCbhsZytj;
import com.server.pojo.bean.QCbhsZytjZC;
import com.server.pojo.bean.uiClhxTj;
import com.server.pojo.url.clhx.RequestFbClhxFetch;
import com.server.pojo.url.clhx.RequestFbGclFetch;
import com.server.pojo.url.clhx.RequestZyClhxFetch;
import com.server.pojo.url.clhx.RequestZyGclFetch;
import com.server.pojo.url.clhx.ResponseFbClhxFetch;
import com.server.pojo.url.clhx.ResponseFbGclFetch;
import com.server.pojo.url.clhx.ResponseZyClhxFetch;
import com.server.pojo.url.clhx.ResponseZyGclFetch;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class ClhxApisServiceImp implements ClhxApisService {

	@Autowired
	private MyQueryFactory queryFactory;

	@Override
	public ResponseZyGclFetch zyGclFetch(RequestZyGclFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsGclQdYs query_ = QCbhsGclQdYs.cbhsGclQdYs;
		QCbhsMonthZyCailiaoCbYs query_zyCailiao = QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs;
		QCbhsDaysZyCailiaoCb query_zydaysCailiao = QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb;
		QCbhsDaysZyJxCb query_zyjxcb = QCbhsDaysZyJxCb.cbhsDaysZyJxCb;

		// 查询对象
		MyJPAQuery<CbhsGclQdYs> jpaquery = (MyJPAQuery<CbhsGclQdYs>) queryFactory.selectFrom(query_);
		JPQLQuery<Integer> globalOids = JPAExpressions.select(query_zyCailiao.globalGclYsOid).from(query_zyCailiao);
		JPQLQuery<Integer> zydaysglobalOids = JPAExpressions.select(query_zydaysCailiao.globalGclYsOid).from(query_zydaysCailiao);
		JPQLQuery<Integer> zyjxglobalOids = JPAExpressions.select(query_zyjxcb.globalGclYsOid).from(query_zyjxcb);

		// 条件组合
		if (request.getProjectOid() > 0) {
			globalOids.where(query_zyCailiao.projectOid.eq(request.getProjectOid()));
			zydaysglobalOids.where(query_zydaysCailiao.projectOid.eq(request.getProjectOid()));
			zyjxglobalOids.where(query_zyjxcb.projectOid.eq(request.getProjectOid()));

		}
		if (request.getDeptOid() > 0) {
			globalOids.where(query_zyCailiao.deptOid.eq(request.getDeptOid()));
			zydaysglobalOids.where(query_zydaysCailiao.deptOid.eq(request.getDeptOid()));
			zyjxglobalOids.where(query_zyjxcb.deptOid.eq(request.getDeptOid()));

		}
		if (request.getMonthStart() > 0) {
			globalOids.where(query_zyCailiao.monthTimeStamp.goe(request.getMonthStart()));
			zydaysglobalOids.where(query_zydaysCailiao.monthTimeStamp.goe(request.getMonthStart()));
			zyjxglobalOids.where(query_zyjxcb.monthTimeStamp.goe(request.getMonthStart()));
		}
		if (request.getMonthEnd() > 0) {
			globalOids.where(query_zyCailiao.monthTimeStamp.loe(request.getMonthEnd()));
			zydaysglobalOids.where(query_zydaysCailiao.monthTimeStamp.loe(request.getMonthEnd()));
			zyjxglobalOids.where(query_zyjxcb.monthTimeStamp.loe(request.getMonthEnd()));
		}
		globalOids.groupBy(query_zyCailiao.globalGclYsOid);
		jpaquery.where(query_.oid.in(globalOids).or(query_.oid.in(zydaysglobalOids)).or(query_.oid.in(zyjxglobalOids))).distinct();
		// 查询总数
		ResponseZyGclFetch response = new ResponseZyGclFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public ResponseZyClhxFetch zyClhxFetch(RequestZyClhxFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		// 查询预算
		QCbhsMonthZyCailiaoCbYs query_zyCailiaoys = QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs;
		MyJPAQuery<uiClhxTj> jpaquery_ys = (MyJPAQuery<uiClhxTj>) queryFactory.select(
				Projections.bean(uiClhxTj.class, query_zyCailiaoys.monthStr.as("monthStr"), query_zyCailiaoys.globalGclYsOid.as("gclOid"), query_zyCailiaoys.globalGclYsName.as("gclName"),
						query_zyCailiaoys.cailiaoKemuName.as("cailiaoKemuName"), query_zyCailiaoys.cailiaoOid.as("cailiaoOid"), query_zyCailiaoys.cailiaoName.as("cailiaoName"),
						query_zyCailiaoys.style.as("style"), query_zyCailiaoys.unit.as("unit"), query_zyCailiaoys.count.sum().as("ysCount"))).from(query_zyCailiaoys);
		jpaquery_ys.where(request.getProjectOid(), query_zyCailiaoys.projectOid.eq(request.getProjectOid()));
		jpaquery_ys.where(request.getDeptOid(), query_zyCailiaoys.deptOid.eq(request.getDeptOid()));
		jpaquery_ys.where(request.getMonthStart(), query_zyCailiaoys.monthTimeStamp.goe(request.getMonthStart()));
		jpaquery_ys.where(request.getMonthEnd(), query_zyCailiaoys.monthTimeStamp.loe(request.getMonthEnd()));

		jpaquery_ys.where(request.getGlobalGclYsOid(), query_zyCailiaoys.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery_ys.groupBy(query_zyCailiaoys.monthStr, query_zyCailiaoys.globalGclYsOid, query_zyCailiaoys.cailiaoOid);
		jpaquery_ys.orderBy(query_zyCailiaoys.monthStr.asc());
		List<uiClhxTj> monthYsTj = jpaquery_ys.fetch();
		Map<String, uiClhxTj> monthYsTjMapTT = Maps.uniqueIndex(monthYsTj, new Function<uiClhxTj, String>() {
			public String apply(uiClhxTj from) {
				return from.getMonthStr() + "@" + from.getGclOid() + "@" + from.getCailiaoOid();
			}
		});
		Map<String, uiClhxTj> monthYsTjMap = Maps.newHashMap(monthYsTjMapTT);
		// 查询机械成本中燃油的材料成本
		QCbhsDaysZyJxCb query_zyJxCb = QCbhsDaysZyJxCb.cbhsDaysZyJxCb;
		MyJPAQuery<uiClhxTj> jpaquery_jxcb = (MyJPAQuery<uiClhxTj>) queryFactory.select(
				Projections.bean(uiClhxTj.class, query_zyJxCb.monthStr.as("monthStr"), query_zyJxCb.globalGclYsOid.as("gclOid"), query_zyJxCb.globalGclYsName.as("gclName"),
						query_zyJxCb.ryKemuName.as("cailiaoKemuName"), query_zyJxCb.ryOid.as("cailiaoOid"), query_zyJxCb.ryName.as("cailiaoName"), query_zyJxCb.ryStyle.as("style"),
						query_zyJxCb.ryUnit.as("unit"), query_zyJxCb.ryUseCount.sum().as("cbCount"))).from(query_zyJxCb);
		jpaquery_jxcb.where(request.getProjectOid(), query_zyJxCb.projectOid.eq(request.getProjectOid()));
		jpaquery_jxcb.where(request.getDeptOid(), query_zyJxCb.deptOid.eq(request.getDeptOid()));
		jpaquery_jxcb.where(request.getMonthStart(), query_zyJxCb.monthTimeStamp.goe(request.getMonthStart()));
		jpaquery_jxcb.where(request.getMonthEnd(), query_zyJxCb.monthTimeStamp.loe(request.getMonthEnd()));
		jpaquery_jxcb.where(request.getGlobalGclYsOid(), query_zyJxCb.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery_jxcb.where(query_zyJxCb.shStatus.eq(0));
		jpaquery_jxcb.groupBy(query_zyJxCb.monthStr, query_zyJxCb.globalGclYsOid, query_zyJxCb.ryOid);
		jpaquery_jxcb.orderBy(query_zyJxCb.monthStr.asc());
		List<uiClhxTj> zyJxCbTj = jpaquery_jxcb.fetch();
		Map<String, uiClhxTj> zyJxCbTjMap = Maps.uniqueIndex(zyJxCbTj, new Function<uiClhxTj, String>() {
			public String apply(uiClhxTj from) {
				return from.getMonthStr() + "@" + from.getGclOid() + "@" + from.getCailiaoOid();
			}
		});
		// 查询自营材料成本
		QCbhsDaysZyCailiaoCb query_zyccCb = QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb;
		MyJPAQuery<uiClhxTj> jpaquery_zycccb = (MyJPAQuery<uiClhxTj>) queryFactory.select(
				Projections.bean(uiClhxTj.class, query_zyccCb.monthStr.as("monthStr"), query_zyccCb.globalGclYsOid.as("gclOid"), query_zyccCb.globalGclYsName.as("gclName"),
						query_zyccCb.cailiaoKemuName.as("cailiaoKemuName"), query_zyccCb.cailiaoOid.as("cailiaoOid"), query_zyccCb.cailiaoName.as("cailiaoName"), query_zyccCb.style.as("style"),
						query_zyccCb.unit.as("unit"), query_zyccCb.count.sum().as("cbCount"))).from(query_zyccCb);
		jpaquery_zycccb.where(request.getProjectOid(), query_zyccCb.projectOid.eq(request.getProjectOid()));
		jpaquery_zycccb.where(request.getDeptOid(), query_zyccCb.deptOid.eq(request.getDeptOid()));
		jpaquery_zycccb.where(request.getMonthStart(), query_zyccCb.monthTimeStamp.goe(request.getMonthStart()));
		jpaquery_zycccb.where(request.getMonthEnd(), query_zyccCb.monthTimeStamp.loe(request.getMonthEnd()));
		jpaquery_zycccb.where(request.getGlobalGclYsOid(), query_zyccCb.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery_zycccb.where(query_zyccCb.shStatus.eq(0));
		jpaquery_zycccb.groupBy(query_zyccCb.monthStr, query_zyccCb.globalGclYsOid, query_zyccCb.cailiaoOid);
		jpaquery_zycccb.orderBy(query_zyccCb.monthStr.asc());
		List<uiClhxTj> zyCailiaoCbTj = jpaquery_zycccb.fetch();
		Map<String, uiClhxTj> zyCailiaoCbTjMap = Maps.uniqueIndex(zyCailiaoCbTj, new Function<uiClhxTj, String>() {
			public String apply(uiClhxTj from) {
				return from.getMonthStr() + "@" + from.getGclOid() + "@" + from.getCailiaoOid();
			}
		});
		// 整理统计数据
		if (zyJxCbTjMap.size() > 0) {
			for (Entry<String, uiClhxTj> entry : zyJxCbTjMap.entrySet()) {
				uiClhxTj value = entry.getValue();
				String key = entry.getKey();
				if (monthYsTjMap.containsKey(key)) {
					uiClhxTj tj = monthYsTjMap.get(key);
					tj.setCbCount(tj.getCbCount().add(value.getCbCount()));
				} else {
					monthYsTjMap.put(key, value);
					monthYsTj.add(value);
				}
			}
		}
		if (zyCailiaoCbTjMap.size() > 0) {
			for (Entry<String, uiClhxTj> entry : zyCailiaoCbTjMap.entrySet()) {
				uiClhxTj value = entry.getValue();
				String key = entry.getKey();
				if (monthYsTjMap.containsKey(key)) {
					uiClhxTj tj = monthYsTjMap.get(key);
					tj.setCbCount(tj.getCbCount().add(value.getCbCount()));
				} else {
					monthYsTjMap.put(key, value);
					monthYsTj.add(value);
				}
			}
		}
		Ordering<uiClhxTj> _ordering = Ordering.from(new Comparator<uiClhxTj>() {
			@Override
			public int compare(uiClhxTj o1, uiClhxTj o2) {
				// TODO Auto-generated method stub
				return o2.getMonthStr().compareTo(o1.getMonthStr());
			}
		});
		Collections.sort(monthYsTj, _ordering);

		long total = monthYsTj.size();
		int pageNum_ = request.getPageNum() == null || request.getPageNum() == 0 ? 1 : request.getPageNum();
		int pageSize_ = request.getPageSize() == null || request.getPageSize() == 0 ? 9999999 : request.getPageSize();
		int start = (pageNum_ - 1) * pageSize_ + 1;
		int end = pageSize_ * pageNum_;
		ResponseZyClhxFetch response = new ResponseZyClhxFetch();
		response.setTotal(total);
		response.setResult(monthYsTj);
		if (total > 0) {
			int count = 1;
			Iterator<uiClhxTj> it = monthYsTj.iterator();
			while (it.hasNext()) {
				it.next();
				if (count >= start && count <= end) {
				} else {
					it.remove();
				}
				count++;
			}
		}
		return response;
	}

	@Override
	public ResponseFbGclFetch fbGclFetch(RequestFbGclFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsGclQdYs query_ = QCbhsGclQdYs.cbhsGclQdYs;
		QCbhsMonthFbCailiaoCbYs query_fbCailiao = QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs;
		QCbhsZytj query_zytj = QCbhsZytj.cbhsZytj;
		// 查询对象
		MyJPAQuery<CbhsGclQdYs> jpaquery = (MyJPAQuery<CbhsGclQdYs>) queryFactory.selectFrom(query_);
		JPQLQuery<Integer> fbgcOids = JPAExpressions.select(query_fbCailiao.globalGclYsOid).from(query_fbCailiao);
		JPQLQuery<Integer> zytjgcOids = JPAExpressions.select(query_zytj.globalGclYsOid).from(query_zytj);
		// 条件组合
		if (request.getProjectOid() > 0) {
			fbgcOids.where(query_fbCailiao.projectOid.eq(request.getProjectOid()));
			zytjgcOids.where(query_zytj.projectOid.eq(request.getProjectOid()));
		}
		if (request.getDeptOid() > 0) {
			fbgcOids.where(query_fbCailiao.deptOid.eq(request.getDeptOid()));
			zytjgcOids.where(query_zytj.deptOid.eq(request.getDeptOid()));

		}
		if (request.getMonthStart() > 0) {
			fbgcOids.where(query_fbCailiao.monthTimeStamp.goe(request.getMonthStart()));
			zytjgcOids.where(query_zytj.monthTimeStamp.goe(request.getMonthStart()));
		}
		if (request.getMonthEnd() > 0) {
			fbgcOids.where(query_fbCailiao.monthTimeStamp.loe(request.getMonthEnd()));
			zytjgcOids.where(query_zytj.monthTimeStamp.loe(request.getMonthEnd()));
		}
		fbgcOids.groupBy(query_fbCailiao.globalGclYsOid);
		jpaquery.where(query_.oid.in(fbgcOids).or(query_.oid.in(zytjgcOids))).distinct();
		// 查询总数
		ResponseFbGclFetch response = new ResponseFbGclFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public ResponseFbClhxFetch fbClhxFetch(RequestFbClhxFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		// 查询预算
		QCbhsMonthFbCailiaoCbYs query_fbCailiaoys = QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs;
		MyJPAQuery<uiClhxTj> jpaquery_ys = (MyJPAQuery<uiClhxTj>) queryFactory.select(
				Projections.bean(uiClhxTj.class, query_fbCailiaoys.monthStr.as("monthStr"), query_fbCailiaoys.globalGclYsOid.as("gclOid"), query_fbCailiaoys.globalGclYsName.max().as("gclName"),
						query_fbCailiaoys.cailiaoKemuName.max().as("cailiaoKemuName"), query_fbCailiaoys.cailiaoOid.as("cailiaoOid"), query_fbCailiaoys.cailiaoName.max().as("cailiaoName"),
						query_fbCailiaoys.style.max().as("style"), query_fbCailiaoys.unit.max().as("unit"), query_fbCailiaoys.count.sum().as("ysCount"))).from(query_fbCailiaoys);
		jpaquery_ys.where(request.getProjectOid(), query_fbCailiaoys.projectOid.eq(request.getProjectOid()));
		jpaquery_ys.where(request.getDeptOid(), query_fbCailiaoys.deptOid.eq(request.getDeptOid()));
		jpaquery_ys.where(request.getMonthStart(), query_fbCailiaoys.monthTimeStamp.goe(request.getMonthStart()));
		jpaquery_ys.where(request.getMonthEnd(), query_fbCailiaoys.monthTimeStamp.loe(request.getMonthEnd()));
		jpaquery_ys.where(request.getGlobalGclYsOid(), query_fbCailiaoys.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery_ys.groupBy(query_fbCailiaoys.monthStr, query_fbCailiaoys.globalGclYsOid, query_fbCailiaoys.cailiaoOid);
		jpaquery_ys.orderBy(query_fbCailiaoys.monthStr.asc());
		List<uiClhxTj> monthYsTj = jpaquery_ys.fetch();
		ImmutableMap<String, uiClhxTj> monthYsTjMapIm = Maps.uniqueIndex(monthYsTj, new Function<uiClhxTj, String>() {
			public String apply(uiClhxTj from) {
				return from.getMonthStr() + "@" + from.getGclOid() + "@" + from.getCailiaoOid();
			}
		});
		// ImmutableMap无法修改 此时只能用hashmap
		Map<String, uiClhxTj> monthYsTjMap = Maps.newHashMap(monthYsTjMapIm);
		// 资源统计 燃油成本
		QCbhsZytj query_zytj = QCbhsZytj.cbhsZytj;
		MyJPAQuery<uiClhxTj> jpaquery_rycb = (MyJPAQuery<uiClhxTj>) queryFactory.select(
				Projections.bean(uiClhxTj.class, query_zytj.monthStr.as("monthStr"), query_zytj.globalGclYsOid.as("gclOid"), query_zytj.globalGclYsName.max().as("gclName"), query_zytj.ryKemuName
						.max().as("cailiaoKemuName"), query_zytj.ryID.as("cailiaoOid"), query_zytj.ryName.max().as("cailiaoName"), query_zytj.ryStyle.max().as("style"),
						query_zytj.ryUnit.max().as("unit"), query_zytj.ryUseCount.sum().as("cbCount"))).from(query_zytj);
		jpaquery_rycb.where(request.getProjectOid(), query_zytj.projectOid.eq(request.getProjectOid()));
		jpaquery_rycb.where(request.getDeptOid(), query_zytj.deptOid.eq(request.getDeptOid()));
		jpaquery_rycb.where(request.getMonthStart(), query_zytj.monthTimeStamp.goe(request.getMonthStart()));
		jpaquery_rycb.where(request.getMonthEnd(), query_zytj.monthTimeStamp.loe(request.getMonthEnd()));

		jpaquery_rycb.where(request.getGlobalGclYsOid(), query_zytj.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery_rycb.where(query_zytj.shStatus.eq(0));
		jpaquery_rycb.groupBy(query_zytj.monthStr, query_zytj.globalGclYsOid, query_zytj.ryID);
		jpaquery_rycb.orderBy(query_zytj.monthStr.asc());
		List<uiClhxTj> monthRycbTj = jpaquery_rycb.fetch();
		Map<String, uiClhxTj> monthRycbTjMap = Maps.uniqueIndex(monthRycbTj, new Function<uiClhxTj, String>() {
			public String apply(uiClhxTj from) {
				return from.getMonthStr() + "@" + from.getGclOid() + "@" + from.getCailiaoOid();
			}
		});
		// 资源统计 主材成本
		QCbhsZytjZC query_zytjzc = QCbhsZytjZC.cbhsZytjZC;
		MyJPAQuery<uiClhxTj> jpaquery_zccb = (MyJPAQuery<uiClhxTj>) queryFactory.select(
				Projections.bean(uiClhxTj.class, query_zytj.monthStr.as("monthStr"), query_zytj.globalGclYsOid.as("gclOid"), query_zytj.globalGclYsName.max().as("gclName"), query_zytjzc.clKemuName
						.max().as("cailiaoKemuName"), query_zytjzc.clOid.as("cailiaoOid"), query_zytjzc.clName.max().as("cailiaoName"), query_zytjzc.clStyle.max().as("style"), query_zytjzc.clUnit
						.max().as("unit"), query_zytjzc.clCount.sum().as("cbCount"))).from(query_zytj, query_zytjzc);
		jpaquery_zccb.where(request.getProjectOid(), query_zytj.projectOid.eq(request.getProjectOid()));
		jpaquery_zccb.where(request.getDeptOid(), query_zytj.deptOid.eq(request.getDeptOid()));
		jpaquery_zccb.where(request.getMonthStart(), query_zytj.monthTimeStamp.goe(request.getMonthStart()));
		jpaquery_zccb.where(request.getMonthEnd(), query_zytj.monthTimeStamp.loe(request.getMonthEnd()));

		jpaquery_zccb.where(request.getGlobalGclYsOid(), query_zytj.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery_zccb.where(query_zytj.shStatus.eq(0));
		jpaquery_zccb.groupBy(query_zytj.monthStr, query_zytj.globalGclYsOid, query_zytjzc.clOid);
		jpaquery_zccb.orderBy(query_zytj.monthStr.asc());
		List<uiClhxTj> monthZccbTj = jpaquery_rycb.fetch();
		Map<String, uiClhxTj> monthZccbTjMap = Maps.uniqueIndex(monthZccbTj, new Function<uiClhxTj, String>() {
			public String apply(uiClhxTj from) {
				return from.getMonthStr() + "@" + from.getGclOid() + "@" + from.getCailiaoOid();
			}
		});
		// 整理统计数据
		if (monthRycbTjMap.size() > 0) {
			for (Entry<String, uiClhxTj> entry : monthRycbTjMap.entrySet()) {
				uiClhxTj value = entry.getValue();
				String key = entry.getKey();
				if (monthYsTjMap.containsKey(key)) {
					uiClhxTj tj = monthYsTjMap.get(key);
					tj.setCbCount(tj.getCbCount().add(value.getCbCount()));
				} else {
					monthYsTjMap.put(key, value);
					monthYsTj.add(value);
				}
			}
		}
		if (monthZccbTjMap.size() > 0) {
			for (Entry<String, uiClhxTj> entry : monthZccbTjMap.entrySet()) {
				uiClhxTj value = entry.getValue();
				String key = entry.getKey();
				if (monthYsTjMap.containsKey(key)) {
					uiClhxTj tj = monthYsTjMap.get(key);
					tj.setCbCount(tj.getCbCount().add(value.getCbCount()));
				} else {
					monthYsTjMap.put(key, value);
					monthYsTj.add(value);
				}
			}
		}
		Ordering<uiClhxTj> _ordering = Ordering.from(new Comparator<uiClhxTj>() {
			@Override
			public int compare(uiClhxTj o1, uiClhxTj o2) {
				// TODO Auto-generated method stub
				return o2.getMonthStr().compareTo(o1.getMonthStr());
			}
		});
		Collections.sort(monthYsTj, _ordering);
		long total = monthYsTj.size();
		int pageNum_ = request.getPageNum() == null || request.getPageNum() == 0 ? 1 : request.getPageNum();
		int pageSize_ = request.getPageSize() == null || request.getPageSize() == 0 ? 9999999 : request.getPageSize();
		int start = (pageNum_ - 1) * pageSize_ + 1;
		int end = pageSize_ * pageNum_;
		ResponseFbClhxFetch response = new ResponseFbClhxFetch();
		response.setTotal(total);
		response.setResult(monthYsTj);
		if (total > 0) {
			int count = 1;
			Iterator<uiClhxTj> it = monthYsTj.iterator();
			while (it.hasNext()) {
				it.next();
				if (count >= start && count <= end) {
				} else {
					it.remove();
				}
				count++;
			}
		}
		return response;
	}
}
