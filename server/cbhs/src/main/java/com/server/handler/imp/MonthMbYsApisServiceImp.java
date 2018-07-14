package com.server.handler.imp;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQuery;
import com.querydsl.jpa.impl.JPAQuery;
import com.server.common.BeanValidation;
import com.server.common.CbhsResUtils;
import com.server.common.DateObj;
import com.server.common.TokenUtils;
import com.server.handler.MonthMbYsApisService;
import com.server.jpa.MyJPAQuery;
import com.server.jpa.MyJPAQuery.PagerResult;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsCailiao;
import com.server.pojo.bean.CbhsDept;
import com.server.pojo.bean.CbhsFbCompany;
import com.server.pojo.bean.CbhsHt;
import com.server.pojo.bean.CbhsMonthFbCailiaoCbYs;
import com.server.pojo.bean.CbhsMonthFbGcCbYs;
import com.server.pojo.bean.CbhsMonthFbLjxmCbYs;
import com.server.pojo.bean.CbhsMonthGlfyYs;
import com.server.pojo.bean.CbhsMonthJjcbYs;
import com.server.pojo.bean.CbhsMonthZyCailiaoCbYs;
import com.server.pojo.bean.CbhsMonthZyJxCbYs;
import com.server.pojo.bean.CbhsMonthZyLxygCbYs;
import com.server.pojo.bean.CbhsMonthZyQtfyYs;
import com.server.pojo.bean.QCbhsCailiao;
import com.server.pojo.bean.QCbhsCailiaoKemu;
import com.server.pojo.bean.QCbhsDept;
import com.server.pojo.bean.QCbhsFbCompany;
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
import com.server.pojo.bean.uiCbhsFbGcGlobalXm;
import com.server.pojo.bean.uiCbhsMonthWebTotal;
import com.server.pojo.bean.uiCbhsMonthZjCbTotal;
import com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsAdd;
import com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsCailiaoFetch;
import com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsDel;
import com.server.pojo.url.monthMbYs.RequestFbCailiaoCbYsFetch;
import com.server.pojo.url.monthMbYs.RequestFbGcCbYsAdd;
import com.server.pojo.url.monthMbYs.RequestFbGcCbYsDel;
import com.server.pojo.url.monthMbYs.RequestFbGcCbYsFetch;
import com.server.pojo.url.monthMbYs.RequestFbGcFbCompanyFetch;
import com.server.pojo.url.monthMbYs.RequestFbGcGlobalXmFetch;
import com.server.pojo.url.monthMbYs.RequestFbLjxmCbYsDel;
import com.server.pojo.url.monthMbYs.RequestFbLjxmCbYsFetch;
import com.server.pojo.url.monthMbYs.RequestGlfyYsDel;
import com.server.pojo.url.monthMbYs.RequestGlfyYsFetch;
import com.server.pojo.url.monthMbYs.RequestJjcbYsDel;
import com.server.pojo.url.monthMbYs.RequestJjcbYsFetch;
import com.server.pojo.url.monthMbYs.RequestMbYsFetch;
import com.server.pojo.url.monthMbYs.RequestMbYsTotalFetch;
import com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsAdd;
import com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsCailiaoFetch;
import com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsDel;
import com.server.pojo.url.monthMbYs.RequestZyCailiaoCbYsFetch;
import com.server.pojo.url.monthMbYs.RequestZyJxCbYsDel;
import com.server.pojo.url.monthMbYs.RequestZyJxCbYsFetch;
import com.server.pojo.url.monthMbYs.RequestZyLxygCbYsDel;
import com.server.pojo.url.monthMbYs.RequestZyLxygCbYsFetch;
import com.server.pojo.url.monthMbYs.RequestZyQtfyYsDel;
import com.server.pojo.url.monthMbYs.RequestZyQtfyYsFetch;
import com.server.pojo.url.monthMbYs.ResponseFbCailiaoCbYsAdd;
import com.server.pojo.url.monthMbYs.ResponseFbCailiaoCbYsCailiaoFetch;
import com.server.pojo.url.monthMbYs.ResponseFbCailiaoCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseFbGcCbYsAdd;
import com.server.pojo.url.monthMbYs.ResponseFbGcCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseFbGcFbCompanyFetch;
import com.server.pojo.url.monthMbYs.ResponseFbGcGlobalXmFetch;
import com.server.pojo.url.monthMbYs.ResponseFbLjxmCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseGlfyYsFetch;
import com.server.pojo.url.monthMbYs.ResponseJjcbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseMbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseMbYsTotalFetch;
import com.server.pojo.url.monthMbYs.ResponseZyCailiaoCbYsAdd;
import com.server.pojo.url.monthMbYs.ResponseZyCailiaoCbYsCailiaoFetch;
import com.server.pojo.url.monthMbYs.ResponseZyCailiaoCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseZyJxCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseZyLxygCbYsFetch;
import com.server.pojo.url.monthMbYs.ResponseZyQtfyYsFetch;
import com.server.util.DataSummaryObj;
import com.server.util.DataSummaryUtils;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class MonthMbYsApisServiceImp implements MonthMbYsApisService {

	@Autowired
	private MyQueryFactory queryFactory;

	@Override
	public ResponseJjcbYsFetch jjcbYsFetch(RequestJjcbYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsMonthJjcbYs query_ = QCbhsMonthJjcbYs.cbhsMonthJjcbYs;
		// 查询对象
		MyJPAQuery<CbhsMonthJjcbYs> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getMonth(), query_.monthTimeStamp.eq(request.getMonth()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseJjcbYsFetch response = new ResponseJjcbYsFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		// 查询合计对象
		CbhsMonthJjcbYs jjcbTotal = queryFactory.select(Projections.bean(CbhsMonthJjcbYs.class, query_.total.sum().as(query_.total), query_.glry_gz.sum().as(query_.glry_gz), query_.glry_zjjf.sum().as(query_.glry_zjjf), query_.glry_ghjf.sum().as(query_.glry_ghjf), query_.glry_dwbx.sum().as(query_.glry_dwbx), query_.glry_qt.sum().as(query_.glry_qt), query_.glry_wp_gz.sum().as(query_.glry_wp_gz), query_.glry_wp_zjjf.sum().as(query_.glry_wp_zjjf), query_.glry_wp_ghjf.sum().as(query_.glry_wp_ghjf), query_.glry_wp_qt.sum().as(query_.glry_wp_qt), query_.scry_gz.sum().as(query_.scry_gz), query_.scry_zjjf.sum().as(query_.scry_zjjf), query_.scry_ghjf.sum().as(query_.scry_ghjf), query_.scry_dwbx.sum().as(query_.scry_dwbx), query_.scry_qt.sum().as(query_.scry_qt), query_.scry_wp_gz.sum().as(query_.scry_wp_gz), query_.scry_wp_zjjf.sum().as(query_.scry_wp_zjjf), query_.scry_wp_ghjf.sum().as(query_.scry_wp_ghjf), query_.scry_wp_qt.sum().as(query_.scry_wp_qt), query_.bg_bgyp.sum().as(query_.bg_bgyp),
				query_.bg_txf.sum().as(query_.bg_txf), query_.bg_dnhc.sum().as(query_.bg_dnhc), query_.bg_qt.sum().as(query_.bg_qt), query_.xlf_dxf.sum().as(query_.xlf_dxf), query_.xlf_ybxlf.sum().as(query_.xlf_ybxlf), query_.xlf_clf.sum().as(query_.xlf_clf), query_.xlf_cailiaofei.sum().as(query_.xlf_cailiaofei), query_.xlf_flf.sum().as(query_.xlf_flf), query_.xlf_ywjf.sum().as(query_.xlf_ywjf), query_.xlf_sdf.sum().as(query_.xlf_sdf), query_.xlf_scf.sum().as(query_.xlf_scf), query_.xlf_kyjf.sum().as(query_.xlf_kyjf), query_.xlf_cljbxf.sum().as(query_.xlf_cljbxf), query_.xlf_bhfy.sum().as(query_.xlf_bhfy), query_.xlf_gzzrx.sum().as(query_.xlf_gzzrx), query_.xlf_qt.sum().as(query_.xlf_qt), query_.aqfy_ygsz.sum().as(query_.aqfy_ygsz), query_.aqfy_ygsztc.sum().as(query_.aqfy_ygsztc), query_.aqfy_qt.sum().as(query_.aqfy_qt))).from(query_).where(jpaquery.getMetadata().getWhere()).fetchFirst();
		response.setJjcbTotal(jjcbTotal);
		return response;
	}

	@Override
	public CbhsMonthJjcbYs jjcbYsUpdate(CbhsMonthJjcbYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "修改项的ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public JSONObject jjcbYsDel(RequestJjcbYsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "间接成本ID不能为空!");
		queryFactory.delete(QCbhsMonthJjcbYs.cbhsMonthJjcbYs).where(QCbhsMonthJjcbYs.cbhsMonthJjcbYs.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsMonthJjcbYs jjcbYsAdd(CbhsMonthJjcbYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		long time = System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		ys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		ys.setOpTime(time);
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public ResponseGlfyYsFetch glfyYsFetch(RequestGlfyYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsMonthGlfyYs query_ = QCbhsMonthGlfyYs.cbhsMonthGlfyYs;
		// 查询对象
		MyJPAQuery<CbhsMonthGlfyYs> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getMonth(), query_.monthTimeStamp.eq(request.getMonth()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		// 查询总数
		ResponseGlfyYsFetch response = new ResponseGlfyYsFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	public CbhsMonthGlfyYs glfyYsUpdate(CbhsMonthGlfyYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public JSONObject glfyYsDel(RequestGlfyYsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "管理费用ID不能为空!");
		queryFactory.delete(QCbhsMonthGlfyYs.cbhsMonthGlfyYs).where(QCbhsMonthGlfyYs.cbhsMonthGlfyYs.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsMonthGlfyYs glfyYsAdd(CbhsMonthGlfyYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		Preconditions.checkArgument(!queryFactory.exists(QCbhsMonthGlfyYs.cbhsMonthGlfyYs, QCbhsMonthGlfyYs.cbhsMonthGlfyYs.projectOid.eq(ys.getProjectOid()).and(QCbhsMonthGlfyYs.cbhsMonthGlfyYs.monthStr.eq(ys.getMonthStr()))), "该月已录入管理费用，不能重复录入!");
		long time = System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		ys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		ys.setOpTime(time);
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public ResponseZyCailiaoCbYsFetch zyCailiaoCbYsFetch(RequestZyCailiaoCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsMonthZyCailiaoCbYs query_ = QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs;
		// 查询对象
		MyJPAQuery<CbhsMonthZyCailiaoCbYs> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getMonth(), query_.monthTimeStamp.eq(request.getMonth()));
		jpaquery.where(request.getGlobalGclYsOid(), query_.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseZyCailiaoCbYsFetch response = new ResponseZyCailiaoCbYsFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public ResponseZyCailiaoCbYsCailiaoFetch zyCailiaoCbYsCailiaoFetch(RequestZyCailiaoCbYsCailiaoFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsMonthZyCailiaoCbYs query_ = QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs;
		// 查询对象
		MyJPAQuery<Integer> jpaquery = (MyJPAQuery<Integer>) queryFactory.select(query_.cailiaoOid).from(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getMonth(), query_.monthTimeStamp.eq(request.getMonth()));
		jpaquery.where(request.getGlobalGclYsOid(), query_.globalGclYsOid.eq(request.getGlobalGclYsOid()));

		jpaquery.groupBy(query_.cailiaoOid);
		List<Integer> cailiaoOids = jpaquery.fetch();
		List<CbhsCailiao> cailiaos = Lists.newArrayList();
		ResponseZyCailiaoCbYsCailiaoFetch response = new ResponseZyCailiaoCbYsCailiaoFetch();
		if (cailiaoOids != null && cailiaoOids.size() > 0) {
			MyJPAQuery<CbhsCailiao> jpaquery2 = queryFactory.selectFrom(QCbhsCailiao.cbhsCailiao);
			jpaquery2.where(QCbhsCailiao.cbhsCailiao.oid.in(cailiaoOids).and(QCbhsCailiao.cbhsCailiao.status.eq(true)));
			Integer isRy = request.getIsRy();
			if (isRy != null && isRy > 0) {
				jpaquery2.where(isRy, QCbhsCailiao.cbhsCailiao.kemuOid.in(JPAExpressions.select(QCbhsCailiaoKemu.cbhsCailiaoKemu.oid).from(QCbhsCailiaoKemu.cbhsCailiaoKemu).where(QCbhsCailiaoKemu.cbhsCailiaoKemu.isRy.eq(isRy == 1 ? true : false))));
			}
			// 查询总数
			PagerResult prResult = jpaquery2.fetchPager(request.getPageNum(), request.getPageSize());
			response.setTotal(prResult.getTotal());
			response.setResult(prResult.getResult());
		} else {
			response.setResult(cailiaos);
			response.setTotal(0L);
		}
		return response;
	}

	@Override
	public CbhsMonthZyCailiaoCbYs zyCailiaoCbYsUpdate(CbhsMonthZyCailiaoCbYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "自营材料成本ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		bv.vali(BeanValidation.beanType.cailiao, BeanValidation.valiType.all, ys.getCailiaoOid());
		ys.setDeptName(queryFactory.findOne(CbhsDept.class, ys.getDeptOid()).getName());
		ys.setCailiaoName(queryFactory.findOne(CbhsCailiao.class, ys.getCailiaoOid()).getName());
		Preconditions.checkArgument(ys.getGlobalGclYsOid() > 0, "工程量ID不能为空!");
		Preconditions.checkArgument(queryFactory.exists(QCbhsGclQdYs.cbhsGclQdYs, QCbhsGclQdYs.cbhsGclQdYs.oid.eq(ys.getGlobalGclYsOid())), "工程量项目不存在!");
		queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public JSONObject zyCailiaoCbYsDel(RequestZyCailiaoCbYsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "自营材料成本ID不能为空!");
		queryFactory.delete(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs).where(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseZyCailiaoCbYsAdd zyCailiaoCbYsAdd(RequestZyCailiaoCbYsAdd request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		if (request.getYss() != null && request.getYss().size() > 0) {
			List<CbhsMonthZyCailiaoCbYs> entitys = Lists.newArrayList();
			for (CbhsMonthZyCailiaoCbYs ys : request.getYss()) {
				ys.setOid(null);
				Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
				Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
				BeanValidation bv = new BeanValidation(queryFactory);
				bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
				bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
				bv.vali(BeanValidation.beanType.cailiao, BeanValidation.valiType.all, ys.getCailiaoOid());
				ys.setDeptName(queryFactory.findOne(CbhsDept.class, ys.getDeptOid()).getName());
				ys.setCailiaoName(queryFactory.findOne(CbhsCailiao.class, ys.getCailiaoOid()).getName());
				Preconditions.checkArgument(ys.getGlobalGclYsOid() > 0, "工程量ID不能为空!");
				Preconditions.checkArgument(queryFactory.exists(QCbhsGclQdYs.cbhsGclQdYs, QCbhsGclQdYs.cbhsGclQdYs.oid.eq(ys.getGlobalGclYsOid())), "工程量项目不存在!");
				long time = System.currentTimeMillis();
				DateTime dt = new DateTime(time);
				ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
				ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
				ys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
				ys.setOpTime(time);
				entitys.add(ys);
			}
			queryFactory.batchSaveOrUpdate(entitys);
		}
		ResponseZyCailiaoCbYsAdd response = new ResponseZyCailiaoCbYsAdd();
		response.setYss(request.getYss());
		return response;
	}

	@Override
	public ResponseZyLxygCbYsFetch zyLxygCbYsFetch(RequestZyLxygCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsMonthZyLxygCbYs query_ = QCbhsMonthZyLxygCbYs.cbhsMonthZyLxygCbYs;
		// 查询对象
		MyJPAQuery<CbhsMonthZyLxygCbYs> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getMonth(), query_.monthTimeStamp.eq(request.getMonth()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseZyLxygCbYsFetch response = new ResponseZyLxygCbYsFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsMonthZyLxygCbYs zyLxygCbYsUpdate(CbhsMonthZyLxygCbYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "零星用工ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public JSONObject zyLxygCbYsDel(RequestZyLxygCbYsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "零星用工ID不能为空!");
		queryFactory.delete(QCbhsMonthZyLxygCbYs.cbhsMonthZyLxygCbYs).where(QCbhsMonthZyLxygCbYs.cbhsMonthZyLxygCbYs.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsMonthZyLxygCbYs zyLxygCbYsAdd(CbhsMonthZyLxygCbYs ys, HttpServletRequest httpServletRequest) throws Exception {
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		long time = System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		ys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		ys.setOpTime(time);
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public ResponseZyJxCbYsFetch zyJxCbYsFetch(RequestZyJxCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsMonthZyJxCbYs query_ = QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs;
		// 查询对象
		MyJPAQuery<CbhsMonthZyJxCbYs> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getMonth(), query_.monthTimeStamp.eq(request.getMonth()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseZyJxCbYsFetch response = new ResponseZyJxCbYsFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsMonthZyJxCbYs zyJxCbYsUpdate(CbhsMonthZyJxCbYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "机械成本ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public JSONObject zyJxCbYsDel(RequestZyJxCbYsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "自营机械成本ID不能为空!");
		queryFactory.delete(QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs).where(QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsMonthZyJxCbYs zyJxCbYsAdd(CbhsMonthZyJxCbYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		long time = System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		ys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		ys.setOpTime(time);
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public ResponseZyQtfyYsFetch zyQtfyYsFetch(RequestZyQtfyYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsMonthZyQtfyYs query_ = QCbhsMonthZyQtfyYs.cbhsMonthZyQtfyYs;
		// 查询对象
		MyJPAQuery<CbhsMonthZyQtfyYs> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getMonth(), query_.monthTimeStamp.eq(request.getMonth()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseZyQtfyYsFetch response = new ResponseZyQtfyYsFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsMonthZyQtfyYs zyQtfyYsUpdate(CbhsMonthZyQtfyYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "其他费用ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public JSONObject zyQtfyYsDel(RequestZyQtfyYsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "其他费用ID不能为空!");
		queryFactory.delete(QCbhsMonthZyQtfyYs.cbhsMonthZyQtfyYs).where(QCbhsMonthZyQtfyYs.cbhsMonthZyQtfyYs.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsMonthZyQtfyYs zyQtfyYsAdd(CbhsMonthZyQtfyYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		long time = System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		ys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		ys.setOpTime(time);
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public ResponseFbLjxmCbYsFetch fbLjxmCbYsFetch(RequestFbLjxmCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsMonthFbLjxmCbYs query_ = QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs;
		// 查询对象
		MyJPAQuery<CbhsMonthFbLjxmCbYs> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getMonth(), query_.monthTimeStamp.eq(request.getMonth()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		// 查询总数
		ResponseFbLjxmCbYsFetch response = new ResponseFbLjxmCbYsFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsMonthFbLjxmCbYs fbLjxmCbYsUpdate(CbhsMonthFbLjxmCbYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "临建项目ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public JSONObject fbLjxmCbYsDel(RequestFbLjxmCbYsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "临建项目ID不能为空!");
		queryFactory.delete(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs).where(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsMonthFbLjxmCbYs fbLjxmCbYsAdd(CbhsMonthFbLjxmCbYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		long time = System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		ys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		ys.setOpTime(time);
		ys = queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public ResponseFbGcCbYsFetch fbGcCbYsFetch(RequestFbGcCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsMonthFbGcCbYs query_ = QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs;
		// 查询对象
		MyJPAQuery<CbhsMonthFbGcCbYs> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getMonth(), query_.monthTimeStamp.eq(request.getMonth()));
		jpaquery.where(request.getGlobalGclYsOid(), query_.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		jpaquery.where(request.getFbCompanyOid(), query_.fbCompanyOid.eq(request.getFbCompanyOid()));
		jpaquery.where(request.getHtOid(), query_.htOid.eq(request.getHtOid()));
		// 查询总数
		BigDecimal priceTotal = queryFactory.select(query_.total.sum()).from(query_).where(jpaquery.getQueryMixin().getMetadata().getWhere()).fetchFirst();
		ResponseFbGcCbYsFetch response = new ResponseFbGcCbYsFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		response.setPriceTotal(priceTotal);
		return response;
	}

	@Override
	public CbhsMonthFbGcCbYs fbGcCbYsUpdate(CbhsMonthFbGcCbYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "分包工程成本ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		if (StringUtils.isBlank(ys.getPNodeId())) {
			ys.setPNodeId("0");
		}
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, ys.getFbCompanyOid());
		Preconditions.checkArgument(ys.getGlobalGclYsOid() > 0, "工程量ID不能为空!");
		Preconditions.checkArgument(queryFactory.exists(QCbhsGclQdYs.cbhsGclQdYs, QCbhsGclQdYs.cbhsGclQdYs.oid.eq(ys.getGlobalGclYsOid())), "工程量项目不存在!");
		Preconditions.checkArgument(!queryFactory.exists(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs, QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.projectOid.eq(ys.getProjectOid()).and(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.monthStr.eq(ys.getMonthStr())).and(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.fbCompanyOid.eq(ys.getFbCompanyOid())).and(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.name.eq(ys.getName()).or(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.nodeId.eq(ys.getNodeId()))).and(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.oid.ne(ys.getOid()))), "分包商在本月已创建过同名或同编号的分包工程");
		queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public JSONObject fbGcCbYsDel(RequestFbGcCbYsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "分包工程ID不能为空!");
		queryFactory.delete(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs).where(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseFbGcCbYsAdd fbGcCbYsAdd(RequestFbGcCbYsAdd request, HttpServletRequest httpServletRequest) throws Exception {
		ResponseFbGcCbYsAdd response = new ResponseFbGcCbYsAdd();
		if (request.getYss() != null && request.getYss().size() > 0) {
			List<CbhsMonthFbGcCbYs> entitys = Lists.newArrayList();
			for (CbhsMonthFbGcCbYs ys : request.getYss()) {
				ys.setOid(null);
				Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
				Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
				if (StringUtils.isBlank(ys.getPNodeId())) {
					ys.setPNodeId("0");
				}
				BeanValidation bv = new BeanValidation(queryFactory);
				bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
				bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, ys.getFbCompanyOid());
				bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
				bv.vali(BeanValidation.beanType.ht, BeanValidation.valiType.all, ys.getHtOid());
				ys.setDeptName(queryFactory.findOne(CbhsDept.class, ys.getDeptOid()).getName());
				ys.setHtName(queryFactory.findOne(CbhsHt.class, ys.getHtOid()).getHtName());
				ys.setFbCompanyName(queryFactory.findOne(CbhsFbCompany.class, ys.getFbCompanyOid()).getName());
				Preconditions.checkArgument(ys.getGlobalGclYsOid() > 0, "工程量ID不能为空!");
				Preconditions.checkArgument(queryFactory.exists(QCbhsGclQdYs.cbhsGclQdYs, QCbhsGclQdYs.cbhsGclQdYs.oid.eq(ys.getGlobalGclYsOid())), "工程量项目不存在!");
				Preconditions.checkArgument(!queryFactory.exists(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs, QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.projectOid.eq(ys.getProjectOid()).and(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.monthStr.eq(ys.getMonthStr())).and(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.fbCompanyOid.eq(ys.getFbCompanyOid())).and(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.name.eq(ys.getName()).or(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.nodeId.eq(ys.getNodeId())))), "分包商在本月已创建过同名或同编号的分包工程");
				long time = System.currentTimeMillis();
				DateTime dt = new DateTime(time);
				ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
				ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
				ys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
				ys.setOpTime(time);
				entitys.add(ys);
			}
			queryFactory.batchSaveOrUpdate(entitys);
			response.setYss(entitys);
		}
		return response;
	}

	@Override
	public ResponseFbCailiaoCbYsFetch fbCailiaoCbYsFetch(RequestFbCailiaoCbYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsMonthFbCailiaoCbYs query_ = QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs;
		// 查询对象
		MyJPAQuery<CbhsMonthFbCailiaoCbYs> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getMonth(), query_.monthTimeStamp.eq(request.getMonth()));
		jpaquery.where(request.getGlobalGclYsOid(), query_.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery.where(request.getFbCompanyOid(), query_.fbCompanyOid.eq(request.getFbCompanyOid()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseFbCailiaoCbYsFetch response = new ResponseFbCailiaoCbYsFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsMonthFbCailiaoCbYs fbCailiaoCbYsUpdate(CbhsMonthFbCailiaoCbYs ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "分包材料成本ID不能为空!");
		Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
		Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		bv.vali(BeanValidation.beanType.cailiao, BeanValidation.valiType.all, ys.getCailiaoOid());
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, ys.getFbCompanyOid());
		ys.setDeptName(queryFactory.findOne(CbhsDept.class, ys.getDeptOid()).getName());
		ys.setCailiaoName(queryFactory.findOne(CbhsCailiao.class, ys.getCailiaoOid()).getName());
		ys.setFbCompanyName(queryFactory.findOne(CbhsFbCompany.class, ys.getFbCompanyOid()).getName());
		Preconditions.checkArgument(ys.getGlobalGclYsOid() > 0, "工程量ID不能为空!");
		Preconditions.checkArgument(queryFactory.exists(QCbhsGclQdYs.cbhsGclQdYs, QCbhsGclQdYs.cbhsGclQdYs.oid.eq(ys.getGlobalGclYsOid())), "工程量项目不存在!");
		Preconditions.checkArgument(!queryFactory.exists(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs, QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.projectOid.eq(ys.getProjectOid()).and(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.monthStr.eq(ys.getMonthStr())).and(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.deptOid.eq(ys.getDeptOid())).and(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.cailiaoOid.eq(ys.getCailiaoOid())).and(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.globalGclYsOid.eq(ys.getGlobalGclYsOid())).and(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.oid.ne(ys.getOid()))), "部门本月在该工程下已创建过这个材料的预算!");

		queryFactory.saveOrUpdate(ys);
		return ys;
	}

	@Override
	public JSONObject fbCailiaoCbYsDel(RequestFbCailiaoCbYsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "分包材料成本ID不能为空!");
		queryFactory.delete(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs).where(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseFbCailiaoCbYsAdd fbCailiaoCbYsAdd(RequestFbCailiaoCbYsAdd request, HttpServletRequest httpServletRequest) throws Exception {
		if (request.getYss() != null && request.getYss().size() > 0) {
			List<CbhsMonthFbCailiaoCbYs> entitys = Lists.newArrayList();
			for (CbhsMonthFbCailiaoCbYs ys : request.getYss()) {
				ys.setOid(null);
				BeanValidation bv = new BeanValidation(queryFactory);
				bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
				bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
				bv.vali(BeanValidation.beanType.cailiao, BeanValidation.valiType.all, ys.getCailiaoOid());
				bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, ys.getFbCompanyOid());
				ys.setDeptName(queryFactory.findOne(CbhsDept.class, ys.getDeptOid()).getName());
				ys.setCailiaoName(queryFactory.findOne(CbhsCailiao.class, ys.getCailiaoOid()).getName());
				ys.setFbCompanyName(queryFactory.findOne(CbhsFbCompany.class, ys.getFbCompanyOid()).getName());
				Preconditions.checkArgument(ys.getGlobalGclYsOid() != null && ys.getGlobalGclYsOid() > 0, "工程量ID不能为空!");
				Preconditions.checkArgument(queryFactory.exists(QCbhsGclQdYs.cbhsGclQdYs, QCbhsGclQdYs.cbhsGclQdYs.oid.eq(ys.getGlobalGclYsOid())), "工程量项目不存在!");
				Preconditions.checkArgument(StringUtils.isNotBlank(ys.getMonthStr()), "月份不能为空!");
				Preconditions.checkArgument(ys.getMonthTimeStamp() > 0, "月份时间戳不能为空!");
				Preconditions.checkArgument(!queryFactory.exists(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs, QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.projectOid.eq(ys.getProjectOid()).and(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.monthStr.eq(ys.getMonthStr())).and(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.deptOid.eq(ys.getDeptOid())).and(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.cailiaoOid.eq(ys.getCailiaoOid())).and(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.globalGclYsOid.eq(ys.getGlobalGclYsOid()))), "部门本月在该工程下已创建过这个材料的预算!");
				long time = System.currentTimeMillis();
				DateTime dt = new DateTime(time);
				ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
				ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
				ys.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
				ys.setOpTime(time);
				entitys.add(ys);
			}
			queryFactory.batchSaveOrUpdate(entitys);
		}
		ResponseFbCailiaoCbYsAdd response = new ResponseFbCailiaoCbYsAdd();
		response.setYss(request.getYss());
		return response;
	}

	@Override
	public ResponseMbYsFetch mbYsFetch(RequestMbYsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		Preconditions.checkArgument(request.getMonth() > 0, "月份时间戳不能为空!");
		List<Integer> deptOids = null;
		if (request.getDeptOid() == 0) {
			deptOids = queryFactory.select(QCbhsDept.cbhsDept.oid).from(QCbhsDept.cbhsDept).where(QCbhsDept.cbhsDept.status.eq(true)).fetch();
		} else {
			deptOids = Lists.newArrayList(request.getDeptOid());
		}
		// 间接成本
		ResponseMbYsFetch response = new ResponseMbYsFetch();
		DataSummaryObj dsObj = new DataSummaryObj();
		dsObj.setProjectOid(request.getProjectOid());
		dsObj.setDeptOids(deptOids);
		dsObj.setDt(new DateObj(request.getMonth(), DateObj.type_month));
		CbhsMonthJjcbYs cbhsMonthJjcbYs = DataSummaryUtils.getThisMonthJjCbYsTotalDetails(queryFactory, dsObj);
		response.setJjcbTotal(cbhsMonthJjcbYs);
		// 管理费用
		CbhsMonthGlfyYs cbhsMonthGlfyYs = DataSummaryUtils.getThisMonthGlfyYs(queryFactory, dsObj);
		response.setGlfyTotal(cbhsMonthGlfyYs);
		// 直接成本-自营材料费
		uiCbhsMonthZjCbTotal uicbhsMonthZjCbTotal = new uiCbhsMonthZjCbTotal();
		JPAQuery<BigDecimal> jqp_zyCailiaoCb = queryFactory.select(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.total.sum()).from(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs).where(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.projectOid.eq(request.getProjectOid()).and(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.monthTimeStamp.eq(request.getMonth())));
		if (request.getDeptOid() > 0) {
			jqp_zyCailiaoCb.where(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.deptOid.eq(request.getDeptOid()));
		} else {
			jqp_zyCailiaoCb.where(QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs.deptOid.in(deptOids));
		}
		BigDecimal p_zyCailiaoCb = jqp_zyCailiaoCb.fetchOne();
		uicbhsMonthZjCbTotal.setP_zyCailiaoCb(p_zyCailiaoCb != null ? p_zyCailiaoCb : new BigDecimal(0));
		// 直接成本-机械成本
		CbhsMonthZyJxCbYs cbhsMonthZyJxCbYs = DataSummaryUtils.getThisMonthZyJxCbYs(queryFactory, dsObj);
		uicbhsMonthZjCbTotal.setP_zyJxCb_zjf(cbhsMonthZyJxCbYs.getP_zjf());
		uicbhsMonthZjCbTotal.setP_zyJxCb_zpf(cbhsMonthZyJxCbYs.getP_zpf());
		uicbhsMonthZjCbTotal.setP_zyJxCb_clysf(cbhsMonthZyJxCbYs.getP_clysf());
		uicbhsMonthZjCbTotal.setP_zyJxCb_jxdxf(cbhsMonthZyJxCbYs.getP_jxdxf());
		uicbhsMonthZjCbTotal.setP_zyJxCb(cbhsMonthZyJxCbYs.getTotal());
		// 直接成本-零星用工
		CbhsMonthZyLxygCbYs lxygYs = DataSummaryUtils.getThisMonthZyLxygCbYs(queryFactory, dsObj);
		uicbhsMonthZjCbTotal.setP_zyLxygCb(lxygYs.getTotal());
		// 直接成本-其他直接费用
		CbhsMonthZyQtfyYs cbhsMonthZyQtfyYs = DataSummaryUtils.getThisMonthZyQtCbYs(queryFactory, dsObj);
		uicbhsMonthZjCbTotal.setP_zyQtfyCb(cbhsMonthZyQtfyYs.getTotal());
		// 直接成本-分包成本
		BigDecimal p_fbGcCb = queryFactory.select(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.total.sum()).from(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs).where(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.projectOid.eq(request.getProjectOid()).and(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.monthTimeStamp.eq(request.getMonth()).and(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.deptOid.in(deptOids)))).fetchOne();
		uicbhsMonthZjCbTotal.setP_fbGcCb(p_fbGcCb != null ? p_fbGcCb : new BigDecimal(0));
		// 直接成本-分包材料成本
		JPAQuery<BigDecimal> jqp_fbCailiaoCb = queryFactory.select(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.total.sum()).from(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs).where(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.projectOid.eq(request.getProjectOid()).and(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.monthTimeStamp.eq(request.getMonth())));
		if (request.getDeptOid() > 0) {
			jqp_fbCailiaoCb.where(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.deptOid.eq(request.getDeptOid()));
		} else {
			jqp_fbCailiaoCb.where(QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs.deptOid.in(deptOids));
		}
		BigDecimal p_fbCailiaoCb = jqp_fbCailiaoCb.fetchOne();
		uicbhsMonthZjCbTotal.setP_fbCailiaoCb(p_fbCailiaoCb != null ? p_fbCailiaoCb : new BigDecimal(0));
		// 直接成本-临建项目
		BigDecimal p_fbLjxmCb = queryFactory.select(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.total.sum()).from(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs).where(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.projectOid.eq(request.getProjectOid()).and(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.monthTimeStamp.eq(request.getMonth()).and(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.deptOid.in(deptOids)))).fetchOne();
		uicbhsMonthZjCbTotal.setP_fbLjxmCb(p_fbLjxmCb != null ? p_fbLjxmCb : new BigDecimal(0));
		response.setZjcbTotal(uicbhsMonthZjCbTotal);
		return response;
	}

	@Override
	public ResponseMbYsTotalFetch mbYsTotalFetch(RequestMbYsTotalFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		Preconditions.checkArgument(request.getMonth() > 0, "月份不能为空!");
		QCbhsMonthJjcbYs query_jjcb = QCbhsMonthJjcbYs.cbhsMonthJjcbYs; // 间接成本
		List<Integer> deptOids = queryFactory.select(QCbhsDept.cbhsDept.oid).from(QCbhsDept.cbhsDept).where(QCbhsDept.cbhsDept.status.eq(true)).fetch();
		JPAQuery<Tuple> jpaquery_jjcb = queryFactory.select(query_jjcb.monthStr, query_jjcb.deptOid, query_jjcb.deptName, query_jjcb.total.sum()).from(query_jjcb).where(query_jjcb.projectOid.eq(request.getProjectOid())).where(query_jjcb.deptOid.in(deptOids));

		QCbhsMonthFbCailiaoCbYs query_fbcc = QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs; // 分包材料
		JPAQuery<Tuple> jpaquery_fbcc = queryFactory.select(query_fbcc.monthStr, query_fbcc.deptOid, query_fbcc.deptName, query_fbcc.total.sum()).from(query_fbcc).where(query_fbcc.projectOid.eq(request.getProjectOid())).where(query_fbcc.deptOid.in(deptOids));

		QCbhsMonthZyCailiaoCbYs query_zycc = QCbhsMonthZyCailiaoCbYs.cbhsMonthZyCailiaoCbYs;// 自营材料
		JPAQuery<Tuple> jpaquery_zycc = queryFactory.select(query_zycc.monthStr, query_zycc.deptOid, query_zycc.deptName, query_zycc.total.sum()).from(query_zycc).where(query_zycc.projectOid.eq(request.getProjectOid())).where(query_zycc.deptOid.in(deptOids));

		QCbhsMonthZyLxygCbYs query_zylxyg = QCbhsMonthZyLxygCbYs.cbhsMonthZyLxygCbYs;// 自营零星工程
		JPAQuery<Tuple> jpaquery_zylxyg = queryFactory.select(query_zylxyg.monthStr, query_zylxyg.deptOid, query_zylxyg.deptName, query_zylxyg.total.sum()).from(query_zylxyg).where(query_zylxyg.projectOid.eq(request.getProjectOid())).where(query_zylxyg.deptOid.in(deptOids));

		QCbhsMonthZyJxCbYs query_zyjx = QCbhsMonthZyJxCbYs.cbhsMonthZyJxCbYs;// 自营机械成本
		JPAQuery<Tuple> jpaquery_zyjx = queryFactory.select(query_zyjx.monthStr, query_zyjx.deptOid, query_zyjx.deptName, query_zyjx.total.sum()).from(query_zyjx).where(query_zyjx.projectOid.eq(request.getProjectOid())).where(query_zyjx.deptOid.in(deptOids));

		QCbhsMonthZyQtfyYs query_zyqtfy = QCbhsMonthZyQtfyYs.cbhsMonthZyQtfyYs;// 自营其他成本
		JPAQuery<Tuple> jpaquery_zyqtfy = queryFactory.select(query_zyqtfy.monthStr, query_zyqtfy.deptOid, query_zyqtfy.deptName, query_zyqtfy.total.sum()).from(query_zyqtfy).where(query_zyqtfy.projectOid.eq(request.getProjectOid())).where(query_zyqtfy.deptOid.in(deptOids));

		QCbhsMonthGlfyYs query_glfy = QCbhsMonthGlfyYs.cbhsMonthGlfyYs;// 管理费用
		JPAQuery<Tuple> jpaquery_glfy = queryFactory.select(query_glfy.monthStr, query_glfy.deptOid, query_glfy.deptName, query_glfy.total.sum()).from(query_glfy).where(query_glfy.projectOid.eq(request.getProjectOid()).and(query_glfy.deptOid.in(deptOids)));

		QCbhsMonthFbGcCbYs query_fbgc = QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs; // 分包工程
		JPAQuery<Tuple> jpaquery_fbgc = queryFactory.select(query_fbgc.monthStr, query_fbgc.deptOid, query_fbgc.deptName, query_fbgc.total.sum()).from(query_fbgc).where(query_fbgc.projectOid.eq(request.getProjectOid()).and(query_fbgc.deptOid.in(deptOids)));

		QCbhsMonthFbLjxmCbYs query_fbljxm = QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs;// 分包临建项目
		JPAQuery<Tuple> jpaquery_fbljxm = queryFactory.select(query_fbljxm.monthStr, query_fbljxm.deptOid, query_fbljxm.deptName, query_fbljxm.total.sum()).from(query_fbljxm).where(query_fbljxm.projectOid.eq(request.getProjectOid()).and(query_fbljxm.deptOid.in(deptOids)));

		boolean hasDeptOid = request.getDeptOid() > 0;
		// boolean hasMonth = request.getMonth() > 0;

		jpaquery_jjcb.where(query_jjcb.projectOid.eq(request.getProjectOid())).groupBy(query_jjcb.deptOid, query_jjcb.deptName, query_jjcb.monthStr).orderBy(query_jjcb.deptOid.asc(), query_jjcb.monthStr.asc());
		jpaquery_fbcc.where(query_fbcc.projectOid.eq(request.getProjectOid())).groupBy(query_fbcc.deptOid, query_fbcc.deptName, query_fbcc.monthStr).orderBy(query_fbcc.deptOid.asc(), query_fbcc.monthStr.asc());
		jpaquery_zycc.where(query_zycc.projectOid.eq(request.getProjectOid())).groupBy(query_zycc.deptOid, query_zycc.deptName, query_zycc.monthStr).orderBy(query_zycc.deptOid.asc(), query_zycc.monthStr.asc());
		jpaquery_zylxyg.where(query_zylxyg.projectOid.eq(request.getProjectOid())).groupBy(query_zylxyg.deptOid, query_zylxyg.deptName, query_zylxyg.monthStr).orderBy(query_zylxyg.deptOid.asc(), query_zylxyg.monthStr.asc());
		jpaquery_zyjx.where(query_zyjx.projectOid.eq(request.getProjectOid())).groupBy(query_zyjx.deptOid, query_zyjx.deptName, query_zyjx.monthStr).orderBy(query_zyjx.deptOid.asc(), query_zyjx.monthStr.asc());
		jpaquery_zyqtfy.where(query_zyqtfy.projectOid.eq(request.getProjectOid())).groupBy(query_zyqtfy.deptOid, query_zyqtfy.deptName, query_zyqtfy.monthStr).orderBy(query_zyqtfy.deptOid.asc(), query_zyqtfy.monthStr.asc());
		jpaquery_glfy.where(query_glfy.projectOid.eq(request.getProjectOid())).groupBy(query_glfy.deptOid, query_glfy.deptName, query_glfy.monthStr).orderBy(query_glfy.monthStr.asc());
		jpaquery_fbgc.where(query_fbgc.projectOid.eq(request.getProjectOid())).groupBy(query_fbgc.deptOid, query_fbgc.deptName, query_fbgc.monthStr).orderBy(query_fbgc.monthStr.asc());
		jpaquery_fbljxm.where(query_fbljxm.projectOid.eq(request.getProjectOid())).groupBy(query_fbljxm.deptOid, query_fbljxm.deptName, query_fbljxm.monthStr).orderBy(query_fbljxm.monthStr.asc());

		// if (hasDeptOid && hasMonth) {
		// jpaquery_jjcb.where(query_jjcb.deptOid.eq(request.getDeptOid())).where(query_jjcb.monthTimeStamp.eq(request.getMonth()));
		// jpaquery_fbcc.where(query_fbcc.deptOid.eq(request.getDeptOid())).where(query_fbcc.monthTimeStamp.eq(request.getMonth()));
		// jpaquery_zycc.where(query_zycc.deptOid.eq(request.getDeptOid())).where(query_zycc.monthTimeStamp.eq(request.getMonth()));
		// jpaquery_zylxyg.where(query_zylxyg.deptOid.eq(request.getDeptOid())).where(query_zylxyg.monthTimeStamp.eq(request.getMonth()));
		// jpaquery_zyjx.where(query_zyjx.deptOid.eq(request.getDeptOid())).where(query_zyjx.monthTimeStamp.eq(request.getMonth()));
		// jpaquery_zyqtfy.where(query_zyqtfy.deptOid.eq(request.getDeptOid())).where(query_zyqtfy.monthTimeStamp.eq(request.getMonth()));
		// jpaquery_fbgc.where(query_fbgc.monthTimeStamp.eq(request.getMonth()));
		// jpaquery_fbljxm.where(query_fbljxm.monthTimeStamp.eq(request.getMonth()));
		// jpaquery_glfy.where(query_glfy.monthTimeStamp.eq(request.getMonth()));
		// } else if (hasDeptOid) {
		// jpaquery_jjcb.where(query_jjcb.deptOid.eq(request.getDeptOid()));
		// jpaquery_fbcc.where(query_fbcc.deptOid.eq(request.getDeptOid()));
		// jpaquery_zycc.where(query_zycc.deptOid.eq(request.getDeptOid()));
		// jpaquery_zylxyg.where(query_zylxyg.deptOid.eq(request.getDeptOid()));
		// jpaquery_zyjx.where(query_zyjx.deptOid.eq(request.getDeptOid()));
		// jpaquery_zyqtfy.where(query_zyqtfy.deptOid.eq(request.getDeptOid()));
		// } else if (hasMonth) {
		jpaquery_jjcb.where(query_jjcb.monthTimeStamp.eq(request.getMonth()));
		jpaquery_fbgc.where(query_fbgc.monthTimeStamp.eq(request.getMonth()));
		jpaquery_fbcc.where(query_fbcc.monthTimeStamp.eq(request.getMonth()));
		jpaquery_fbljxm.where(query_fbljxm.monthTimeStamp.eq(request.getMonth()));
		jpaquery_zycc.where(query_zycc.monthTimeStamp.eq(request.getMonth()));
		jpaquery_zylxyg.where(query_zylxyg.monthTimeStamp.eq(request.getMonth()));
		jpaquery_zyjx.where(query_zyjx.monthTimeStamp.eq(request.getMonth()));
		jpaquery_zyqtfy.where(query_zyqtfy.monthTimeStamp.eq(request.getMonth()));
		jpaquery_glfy.where(query_glfy.monthTimeStamp.eq(request.getMonth()));
		// }
		List<Tuple> tup_jjcb = jpaquery_jjcb.fetch();
		List<Tuple> tup_fbgc = jpaquery_fbgc.fetch();
		List<Tuple> tup_fbcc = jpaquery_fbcc.fetch();
		List<Tuple> tup_fbljxm = jpaquery_fbljxm.fetch();
		List<Tuple> tup_zycc = jpaquery_zycc.fetch();
		List<Tuple> tup_zylxyg = jpaquery_zylxyg.fetch();
		List<Tuple> tup_zyjx = jpaquery_zyjx.fetch();
		List<Tuple> tup_zyqtfy = jpaquery_zyqtfy.fetch();
		List<Tuple> tup_glfy = jpaquery_glfy.fetch();
		System.out.println(JSON.toJSON(tup_jjcb));
		long resulttotal = 0;
		List<uiCbhsMonthWebTotal> result = Lists.newArrayList();
		Map<String, Map<Integer, uiCbhsMonthWebTotal>> monthsMaps = Maps.newHashMap();
		BigDecimal monthYsTotal = BigDecimal.ZERO;
		// 间接成本
		for (int i = 0; i < tup_jjcb.size(); i++) {
			Tuple tup = tup_jjcb.get(i);
			String monthStr = tup.get(query_jjcb.monthStr);
			String deptName = tup.get(query_jjcb.deptName);
			BigDecimal total = tup.get(query_jjcb.total.sum());
			Integer deptOid = tup.get(query_jjcb.deptOid);
			if (!monthsMaps.containsKey(monthStr)) {
				monthsMaps.put(monthStr, Maps.newHashMap());
			}
			if (!hasDeptOid || (hasDeptOid && deptOid.intValue() == request.getDeptOid().intValue())) {
				if (!monthsMaps.get(monthStr).containsKey(deptOid.intValue())) {
					uiCbhsMonthWebTotal ui_ = new uiCbhsMonthWebTotal();
					ui_.setDeptName(deptName);
					ui_.setMonthStr(monthStr);
					ui_.setDeptOid(deptOid);
					monthsMaps.get(monthStr).put(deptOid.intValue(), ui_);
					result.add(ui_);
					resulttotal++;
				}
				uiCbhsMonthWebTotal uitotal = monthsMaps.get(monthStr).get(deptOid.intValue());
				uitotal.setJjcbTotal(uitotal.getJjcbTotal().add(total));
				uitotal.setDeptYsTotal(uitotal.getDeptYsTotal().add(total));
			}
			monthYsTotal = monthYsTotal.add(total);
		}
		// 分包材料
		for (int i = 0; i < tup_fbcc.size(); i++) {
			Tuple tup = tup_fbcc.get(i);
			String monthStr = tup.get(query_fbcc.monthStr);
			String deptName = tup.get(query_fbcc.deptName);
			BigDecimal total = tup.get(query_fbcc.total.sum());
			Integer deptOid = tup.get(query_fbcc.deptOid);
			if (!monthsMaps.containsKey(monthStr)) {
				monthsMaps.put(monthStr, Maps.newHashMap());
			}
			if (!hasDeptOid || (hasDeptOid && deptOid.intValue() == request.getDeptOid().intValue())) {

				if (!monthsMaps.get(monthStr).containsKey(deptOid.intValue())) {
					uiCbhsMonthWebTotal ui_ = new uiCbhsMonthWebTotal();
					ui_.setDeptName(deptName);
					ui_.setMonthStr(monthStr);
					ui_.setDeptOid(deptOid);
					monthsMaps.get(monthStr).put(deptOid.intValue(), ui_);
					result.add(ui_);
					resulttotal++;
				}
				uiCbhsMonthWebTotal uitotal = monthsMaps.get(monthStr).get(deptOid.intValue());
				uitotal.setFbcailiaoCbTotal(uitotal.getFbcailiaoCbTotal().add(total));
				uitotal.setDeptYsTotal(uitotal.getDeptYsTotal().add(total));
			}
			monthYsTotal = monthYsTotal.add(total);
		}

		// 自营材料
		for (int i = 0; i < tup_zycc.size(); i++) {
			Tuple tup = tup_zycc.get(i);
			String monthStr = tup.get(query_zycc.monthStr);
			String deptName = tup.get(query_zycc.deptName);
			BigDecimal total = tup.get(query_zycc.total.sum());
			Integer deptOid = tup.get(query_zycc.deptOid);
			if (!monthsMaps.containsKey(monthStr)) {
				monthsMaps.put(monthStr, Maps.newHashMap());
			}
			if (!hasDeptOid || (hasDeptOid && deptOid.intValue() == request.getDeptOid().intValue())) {

				if (!monthsMaps.get(monthStr).containsKey(deptOid.intValue())) {
					uiCbhsMonthWebTotal ui_ = new uiCbhsMonthWebTotal();
					ui_.setDeptName(deptName);
					ui_.setMonthStr(monthStr);
					ui_.setDeptOid(deptOid);
					monthsMaps.get(monthStr).put(deptOid.intValue(), ui_);
					result.add(ui_);
					resulttotal++;
				}
				uiCbhsMonthWebTotal uitotal = monthsMaps.get(monthStr).get(deptOid.intValue());
				uitotal.setZycailiaoCbTotal(uitotal.getZycailiaoCbTotal().add(total));
				uitotal.setDeptYsTotal(uitotal.getDeptYsTotal().add(total));
			}
			monthYsTotal = monthYsTotal.add(total);
		}

		// 自营零星工程
		for (int i = 0; i < tup_zylxyg.size(); i++) {
			Tuple tup = tup_zylxyg.get(i);
			String monthStr = tup.get(query_zylxyg.monthStr);
			String deptName = tup.get(query_zylxyg.deptName);
			BigDecimal total = tup.get(query_zylxyg.total.sum());
			Integer deptOid = tup.get(query_zylxyg.deptOid);
			if (!monthsMaps.containsKey(monthStr)) {
				monthsMaps.put(monthStr, Maps.newHashMap());
			}
			if (!hasDeptOid || (hasDeptOid && deptOid.intValue() == request.getDeptOid().intValue())) {

				if (!monthsMaps.get(monthStr).containsKey(deptOid.intValue())) {
					uiCbhsMonthWebTotal ui_ = new uiCbhsMonthWebTotal();
					ui_.setDeptName(deptName);
					ui_.setMonthStr(monthStr);
					ui_.setDeptOid(deptOid);
					monthsMaps.get(monthStr).put(deptOid.intValue(), ui_);
					result.add(ui_);
					resulttotal++;
				}
				uiCbhsMonthWebTotal uitotal = monthsMaps.get(monthStr).get(deptOid.intValue());
				uitotal.setZylxygTotal(uitotal.getZylxygTotal().add(total));
				uitotal.setDeptYsTotal(uitotal.getDeptYsTotal().add(total));
			}
			monthYsTotal = monthYsTotal.add(total);
		}

		// 自营机械成本
		for (int i = 0; i < tup_zyjx.size(); i++) {
			Tuple tup = tup_zyjx.get(i);
			String monthStr = tup.get(query_zyjx.monthStr);
			String deptName = tup.get(query_zyjx.deptName);
			BigDecimal total = tup.get(query_zyjx.total.sum());
			Integer deptOid = tup.get(query_zyjx.deptOid);
			if (!monthsMaps.containsKey(monthStr)) {
				monthsMaps.put(monthStr, Maps.newHashMap());
			}
			if (!hasDeptOid || (hasDeptOid && deptOid.intValue() == request.getDeptOid().intValue())) {

				if (!monthsMaps.get(monthStr).containsKey(deptOid.intValue())) {
					uiCbhsMonthWebTotal ui_ = new uiCbhsMonthWebTotal();
					ui_.setDeptName(deptName);
					ui_.setMonthStr(monthStr);
					ui_.setDeptOid(deptOid);
					monthsMaps.get(monthStr).put(deptOid.intValue(), ui_);
					result.add(ui_);
					resulttotal++;
				}
				uiCbhsMonthWebTotal uitotal = monthsMaps.get(monthStr).get(deptOid.intValue());
				uitotal.setZyjxcbTotal(uitotal.getZyjxcbTotal().add(total));
				uitotal.setDeptYsTotal(uitotal.getDeptYsTotal().add(total));
			}
			monthYsTotal = monthYsTotal.add(total);
		}

		// 其他成本
		for (int i = 0; i < tup_zyqtfy.size(); i++) {
			Tuple tup = tup_zyqtfy.get(i);
			String monthStr = tup.get(query_zyqtfy.monthStr);
			String deptName = tup.get(query_zyqtfy.deptName);
			BigDecimal total = tup.get(query_zyqtfy.total.sum());
			Integer deptOid = tup.get(query_zyqtfy.deptOid);
			if (!monthsMaps.containsKey(monthStr)) {
				monthsMaps.put(monthStr, Maps.newHashMap());
			}
			if (!hasDeptOid || (hasDeptOid && deptOid.intValue() == request.getDeptOid().intValue())) {
				if (!monthsMaps.get(monthStr).containsKey(deptOid.intValue())) {
					uiCbhsMonthWebTotal ui_ = new uiCbhsMonthWebTotal();
					ui_.setDeptName(deptName);
					ui_.setMonthStr(monthStr);
					ui_.setDeptOid(deptOid);
					monthsMaps.get(monthStr).put(deptOid.intValue(), ui_);
					result.add(ui_);
					resulttotal++;
				}
				uiCbhsMonthWebTotal uitotal = monthsMaps.get(monthStr).get(deptOid.intValue());
				uitotal.setQtfy(uitotal.getQtfy().add(total));
				uitotal.setDeptYsTotal(uitotal.getDeptYsTotal().add(total));
			}
			monthYsTotal = monthYsTotal.add(total);
		}
		// 管理费用
		for (int i = 0; i < tup_glfy.size(); i++) {
			Tuple tup = tup_glfy.get(i);
			String monthStr = tup.get(query_glfy.monthStr);
			String deptName = tup.get(query_glfy.deptName);
			BigDecimal total = tup.get(query_glfy.total.sum());
			Integer deptOid = tup.get(query_glfy.deptOid);
			if (!hasDeptOid || (hasDeptOid && deptOid.intValue() == request.getDeptOid().intValue())) {
				if (!monthsMaps.get(monthStr).containsKey(deptOid.intValue())) {
					uiCbhsMonthWebTotal ui_ = new uiCbhsMonthWebTotal();
					ui_.setDeptName(deptName);
					ui_.setMonthStr(monthStr);
					ui_.setDeptOid(deptOid);
					monthsMaps.get(monthStr).put(deptOid.intValue(), ui_);
					result.add(ui_);
					resulttotal++;
				}
				uiCbhsMonthWebTotal uitotal = monthsMaps.get(monthStr).get(deptOid.intValue());
				uitotal.setGlfy(uitotal.getGlfy().add(total));
				uitotal.setDeptYsTotal(uitotal.getDeptYsTotal().add(total));
			}
			monthYsTotal = monthYsTotal.add(total);
		}
		// 分包工程
		for (int i = 0; i < tup_fbgc.size(); i++) {
			Tuple tup = tup_fbgc.get(i);
			String monthStr = tup.get(query_fbgc.monthStr);
			String deptName = tup.get(query_fbgc.deptName);
			BigDecimal total = tup.get(query_fbgc.total.sum());
			Integer deptOid = tup.get(query_fbgc.deptOid);
			if (!hasDeptOid || (hasDeptOid && deptOid.intValue() == request.getDeptOid().intValue())) {
				if (!monthsMaps.get(monthStr).containsKey(deptOid.intValue())) {
					uiCbhsMonthWebTotal ui_ = new uiCbhsMonthWebTotal();
					ui_.setDeptName(deptName);
					ui_.setMonthStr(monthStr);
					ui_.setDeptOid(deptOid);
					monthsMaps.get(monthStr).put(deptOid.intValue(), ui_);
					result.add(ui_);
					resulttotal++;
				}
				uiCbhsMonthWebTotal uitotal = monthsMaps.get(monthStr).get(deptOid.intValue());
				uitotal.setFbgcTotal(uitotal.getFbgcTotal().add(total));
				uitotal.setDeptYsTotal(uitotal.getDeptYsTotal().add(total));
			}
			monthYsTotal = monthYsTotal.add(total);
		}
		// 分包临建项目
		for (int i = 0; i < tup_fbljxm.size(); i++) {
			Tuple tup = tup_fbljxm.get(i);
			String monthStr = tup.get(query_fbljxm.monthStr);
			String deptName = tup.get(query_fbljxm.deptName);
			BigDecimal total = tup.get(query_fbljxm.total.sum());
			Integer deptOid = tup.get(query_fbljxm.deptOid);
			if (!hasDeptOid || (hasDeptOid && deptOid.intValue() == request.getDeptOid().intValue())) {
				if (!monthsMaps.get(monthStr).containsKey(deptOid.intValue())) {
					uiCbhsMonthWebTotal ui_ = new uiCbhsMonthWebTotal();
					ui_.setDeptName(deptName);
					ui_.setMonthStr(monthStr);
					ui_.setDeptOid(deptOid);
					monthsMaps.get(monthStr).put(deptOid.intValue(), ui_);
					result.add(ui_);
					resulttotal++;
				}
				uiCbhsMonthWebTotal uitotal = monthsMaps.get(monthStr).get(deptOid.intValue());
				uitotal.setFbljxmTotal(uitotal.getFbljxmTotal().add(total));
				uitotal.setDeptYsTotal(uitotal.getDeptYsTotal().add(total));
			}
			monthYsTotal = monthYsTotal.add(total);
		}
		Ordering<uiCbhsMonthWebTotal> _ordering = Ordering.from(new Comparator<uiCbhsMonthWebTotal>() {
			@Override
			public int compare(uiCbhsMonthWebTotal o1, uiCbhsMonthWebTotal o2) {
				// TODO Auto-generated method stub
				return o1.getMonthStr().compareTo(o2.getMonthStr());
			}
		});
		Collections.sort(result, _ordering);
		ResponseMbYsTotalFetch response = new ResponseMbYsTotalFetch();
		response.setTotal(resulttotal);
		response.setResult(result);
		response.setMonthYsTotal(monthYsTotal);
		return response;
	}

	@Override
	public ResponseFbGcGlobalXmFetch fbGcGlobalXmFetch(RequestFbGcGlobalXmFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsMonthFbGcCbYs query_ = QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs;
		// 查询对象
		MyJPAQuery<uiCbhsFbGcGlobalXm> jpaquery = (MyJPAQuery<uiCbhsFbGcGlobalXm>) queryFactory.select(Projections.bean(uiCbhsFbGcGlobalXm.class, // 返回自定义实体的类型
				query_.globalGclYsOid.as("oid"), query_.globalGclYsName.as("name"))).from(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getMonth(), query_.monthTimeStamp.eq(request.getMonth()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseFbGcGlobalXmFetch response = new ResponseFbGcGlobalXmFetch();
		PagerResult prResult = jpaquery.fetchPagerGroupBy(request.getPageNum(), request.getPageSize(), query_.globalGclYsOid);
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public ResponseFbCailiaoCbYsCailiaoFetch fbCailiaoCbYsCailiaoFetch(RequestFbCailiaoCbYsCailiaoFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsMonthFbCailiaoCbYs query_ = QCbhsMonthFbCailiaoCbYs.cbhsMonthFbCailiaoCbYs;
		// 查询对象
		MyJPAQuery<Integer> jpaquery = (MyJPAQuery<Integer>) queryFactory.select(query_.cailiaoOid).from(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getMonth(), query_.monthTimeStamp.eq(request.getMonth()));
		jpaquery.where(request.getFbGclYsOid(), query_.globalGclYsOid.eq(request.getFbGclYsOid()));
		jpaquery.groupBy(query_.cailiaoOid);
		List<Integer> cailiaoOids = jpaquery.fetch();
		List<CbhsCailiao> cailiaos = Lists.newArrayList();
		ResponseFbCailiaoCbYsCailiaoFetch response = new ResponseFbCailiaoCbYsCailiaoFetch();
		if (cailiaoOids != null && cailiaoOids.size() > 0) {
			MyJPAQuery<CbhsCailiao> jpaquery2 = queryFactory.selectFrom(QCbhsCailiao.cbhsCailiao);
			jpaquery2.where(QCbhsCailiao.cbhsCailiao.oid.in(cailiaoOids).and(QCbhsCailiao.cbhsCailiao.status.eq(true)));
			Integer isRy = request.getIsRy();
			if (isRy != null && isRy > 0) {
				jpaquery2.where(isRy, QCbhsCailiao.cbhsCailiao.kemuOid.in(JPAExpressions.select(QCbhsCailiaoKemu.cbhsCailiaoKemu.oid).from(QCbhsCailiaoKemu.cbhsCailiaoKemu).where(QCbhsCailiaoKemu.cbhsCailiaoKemu.isRy.eq(isRy == 1 ? true : false))));
			}
			// 查询总数
			PagerResult prResult = jpaquery2.fetchPager(request.getPageNum(), request.getPageSize());
			response.setTotal(prResult.getTotal());
			response.setResult(prResult.getResult());
		} else {
			response.setResult(cailiaos);
			response.setTotal(0L);
		}
		return response;
	}

	@Override
	public ResponseFbGcFbCompanyFetch fbGcFbCompanyFetch(RequestFbGcFbCompanyFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsFbCompany query_ = QCbhsFbCompany.cbhsFbCompany;
		QCbhsMonthFbGcCbYs query_fbgc = QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs;
		// 查询对象
		MyJPAQuery<CbhsFbCompany> jpaquery = (MyJPAQuery<CbhsFbCompany>) queryFactory.selectFrom(query_).where(query_.status.eq(true));
		JPQLQuery<Integer> jpaExpressions = JPAExpressions.select(query_fbgc.fbCompanyOid).from(query_fbgc);
		// 条件组合
		if (request.getProjectOid() > 0) {
			jpaExpressions.where(query_fbgc.projectOid.eq(request.getProjectOid()));
		}
		if (request.getMonth() > 0) {
			jpaExpressions.where(query_fbgc.monthTimeStamp.eq(request.getMonth()));
		}
		if (request.getDeptOid() > 0) {
			jpaExpressions.where(query_fbgc.deptOid.eq(request.getDeptOid()));
		}
		jpaExpressions.groupBy(query_fbgc.fbCompanyOid);
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		jpaquery.where(query_.oid.in(jpaExpressions));
		jpaquery.orderBy(query_.oid.asc());
		// 查询总数
		ResponseFbGcFbCompanyFetch response = new ResponseFbGcFbCompanyFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}
}
