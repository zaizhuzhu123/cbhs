package com.server.handler.imp;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import com.querydsl.core.types.Projections;
import com.server.common.BeanValidation;
import com.server.common.CbhsResUtils;
import com.server.common.DateObj;
import com.server.common.TokenUtils;
import com.server.exception.ExceptionResponse;
import com.server.exception.ServiceException;
import com.server.handler.DaysSrApisService;
import com.server.jpa.MyJPAQuery;
import com.server.jpa.MyJPAQuery.PagerResult;
import com.server.jpa.MyQueryFactory;
import com.server.manager.CbSrManager;
import com.server.pojo.bean.CbhsCb;
import com.server.pojo.bean.CbhsDaysFbLjxmCb;
import com.server.pojo.bean.CbhsDaysGclSr;
import com.server.pojo.bean.CbhsDaysQtSr;
import com.server.pojo.bean.CbhsGclQdYs;
import com.server.pojo.bean.CbhsSr;
import com.server.pojo.bean.QCbhsCb;
import com.server.pojo.bean.QCbhsDaysGclSr;
import com.server.pojo.bean.QCbhsDaysQtSr;
import com.server.pojo.bean.QCbhsGclQdYs;
import com.server.pojo.bean.uiAbnormal;
import com.server.pojo.url.daysSr.RequestAbnormalFetch;
import com.server.pojo.url.daysSr.RequestGcsrAdd;
import com.server.pojo.url.daysSr.RequestGcsrDel;
import com.server.pojo.url.daysSr.RequestGcsrFetch;
import com.server.pojo.url.daysSr.RequestNewsrAddPrice;
import com.server.pojo.url.daysSr.RequestNewsrDel;
import com.server.pojo.url.daysSr.RequestNewsrFetch;
import com.server.pojo.url.daysSr.ResponseGcsrAdd;
import com.server.pojo.url.daysSr.ResponseGcsrFetch;
import com.server.pojo.url.daysSr.ResponseNewsrFetch;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class DaysSrApisServiceImp implements DaysSrApisService {
	@Autowired
	private MyQueryFactory queryFactory;

	@Autowired
	private CbSrManager cbSrManager;

	@Override
	public ResponseGcsrFetch gcsrFetch(RequestGcsrFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsDaysGclSr query_ = QCbhsDaysGclSr.cbhsDaysGclSr;
		// 查询对象
		MyJPAQuery<CbhsDaysGclSr> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getDaysStart(), query_.dateTimeStamp.goe(request.getDaysStart()));
		jpaquery.where(request.getDaysEnd(), query_.dateTimeStamp.loe(request.getDaysEnd()));
		jpaquery.where(request.getGlobalGclYsOid(), query_.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseGcsrFetch response = new ResponseGcsrFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsDaysGclSr gcsrUpdate(CbhsDaysGclSr ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "工程收入ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		Preconditions.checkArgument(ys.getGlobalGclYsOid() > 0, "工程量ID不能为空!");
		Preconditions.checkArgument(queryFactory.exists(QCbhsGclQdYs.cbhsGclQdYs, QCbhsGclQdYs.cbhsGclQdYs.oid.eq(ys.getGlobalGclYsOid())), "工程量项目不存在!");
		ys = queryFactory.saveOrUpdate(ys);
		cbSrManager.updateSr(queryFactory, 1, ys.getOid(), ys.getTotal());
		return ys;
	}

	@Override
	public JSONObject gcsrDel(RequestGcsrDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "工程收入ID不能为空!");
		queryFactory.delete(QCbhsDaysGclSr.cbhsDaysGclSr).where(QCbhsDaysGclSr.cbhsDaysGclSr.oid.in(request.getOids())).execute();
		cbSrManager.delSr(queryFactory, 1, request.getOids());
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseGcsrAdd gcsrAdd(RequestGcsrAdd request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		if (request.getSrs() != null && request.getSrs().size() > 0) {
			List<CbhsDaysGclSr> entitys = Lists.newArrayList();
			synchronized (this) {
				for (CbhsDaysGclSr ys : request.getSrs()) {
					BeanValidation bv = new BeanValidation(queryFactory);
					bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
					bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
					Preconditions.checkArgument(ys.getGlobalGclYsOid() > 0, "工程量ID不能为空!");
					Preconditions.checkArgument(queryFactory.exists(QCbhsGclQdYs.cbhsGclQdYs, QCbhsGclQdYs.cbhsGclQdYs.oid.eq(ys.getGlobalGclYsOid()).and(QCbhsGclQdYs.cbhsGclQdYs.projectOid.eq(ys.getProjectOid()))), "工程量项目不存在!");
					long time = ys.getDateTimeStamp() > 0 ? ys.getDateTimeStamp() : System.currentTimeMillis();
					DateTime dt = new DateTime(time);
					DateTime curDt = new DateTime(System.currentTimeMillis());
					ys.setDateStr(dt.toString("yyyy-MM-dd"));
					ys.setDateTimeStamp(time);
					ys.setMonthStr(dt.toString("yyyy-MM"));
					ys.setMonthTimeStamp(new DateObj(time, DateObj.type_month).getStartTime());
					ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
					ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
					ys.setOpTimeStr(curDt.toString("yyyy-MM-dd HH:mm:ss"));
					ys.setOpTime(curDt.getMillis());
					entitys.add(ys);
					ys = queryFactory.saveOrUpdate(ys);
					CbhsGclQdYs cbhsGclQdYs = queryFactory.findOne(CbhsGclQdYs.class, ys.getGlobalGclYsOid());
					if (cbhsGclQdYs.getCompleteCount().add(ys.getCount()).compareTo(cbhsGclQdYs.getCount()) > 0) {
						throw new ServiceException(new ExceptionResponse(-1, ys.getGlobalGclYsName() + "结算量已合计超过总工程清单总数量" + ys.getCount().stripTrailingZeros()));
					}
					queryFactory.update(QCbhsGclQdYs.cbhsGclQdYs).set(QCbhsGclQdYs.cbhsGclQdYs.completeCount, QCbhsGclQdYs.cbhsGclQdYs.completeCount.add(ys.getTotal())).where(QCbhsGclQdYs.cbhsGclQdYs.oid.eq(ys.getGlobalGclYsOid())).execute();
					CbhsSr sr = JSON.parseObject(JSON.toJSONString(ys), CbhsSr.class);
					sr.setCbOid(ys.getOid());
					sr.setType(1);
					sr.setOid(null);
					cbSrManager.createSr(queryFactory, sr);
				}
			}

		}
		ResponseGcsrAdd response = new ResponseGcsrAdd();
		response.setSrs(request.getSrs());
		return response;
	}

	@Override
	public ResponseNewsrFetch newsrFetch(RequestNewsrFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsDaysQtSr query_ = QCbhsDaysQtSr.cbhsDaysQtSr;
		// 查询对象
		MyJPAQuery<CbhsDaysQtSr> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getDaysStart(), query_.dateTimeStamp.goe(request.getDaysStart()));
		jpaquery.where(request.getDaysEnd(), query_.dateTimeStamp.loe(request.getDaysEnd()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseNewsrFetch response = new ResponseNewsrFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsDaysQtSr newsrUpdate(CbhsDaysQtSr ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "新增收入ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys = queryFactory.saveOrUpdate(ys);
		CbhsSr sr = JSON.parseObject(JSON.toJSONString(ys), CbhsSr.class);
		sr.setCbOid(ys.getOid());
		sr.setType(2);
		sr.setOid(null);
		cbSrManager.createSr(queryFactory, sr);
		return ys;
	}

	@Override
	public JSONObject newsrDel(RequestNewsrDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "新增收入ID不能为空!");
		queryFactory.delete(QCbhsDaysQtSr.cbhsDaysQtSr).where(QCbhsDaysQtSr.cbhsDaysQtSr.oid.in(request.getOids())).execute();
		cbSrManager.delSr(queryFactory, 2, request.getOids());
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsDaysQtSr newsrAddCount(CbhsDaysQtSr ys, HttpServletRequest httpServletRequest) throws Exception {
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		long time = ys.getDateTimeStamp() > 0 ? ys.getDateTimeStamp() : System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		DateTime curDt = new DateTime(System.currentTimeMillis());
		ys.setDateStr(dt.toString("yyyy-MM-dd"));
		ys.setDateTimeStamp(time);
		ys.setMonthStr(dt.toString("yyyy-MM"));
		ys.setMonthTimeStamp(new DateObj(time, DateObj.type_month).getStartTime());
		ys.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		ys.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		ys.setOpTimeStr(curDt.toString("yyyy-MM-dd HH:mm:ss"));
		ys.setOpTime(curDt.getMillis());
		ys.setUnitPrice(BigDecimal.ZERO);
		ys.setTotal(BigDecimal.ZERO);
		ys = queryFactory.saveOrUpdate(ys);
		CbhsSr sr = JSON.parseObject(JSON.toJSONString(ys), CbhsSr.class);
		sr.setCbOid(ys.getOid());
		sr.setType(2);
		sr.setOid(null);
		cbSrManager.createSr(queryFactory, sr);
		return ys;
	}

	@Override
	public CbhsDaysQtSr newsrAddPrice(RequestNewsrAddPrice request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getCbhsDaysQtSrOid() > 0, "收入ID不能为空!");
		CbhsDaysQtSr qtsr = queryFactory.findOne(CbhsDaysQtSr.class, request.getCbhsDaysQtSrOid());
		Preconditions.checkArgument(qtsr != null, "收入不存在!");
		qtsr.setUnitPrice(request.getUnitPrice());
		qtsr.setTotal(request.getPrice());
		CbhsSr sr = JSON.parseObject(JSON.toJSONString(qtsr), CbhsSr.class);
		sr.setCbOid(qtsr.getOid());
		sr.setType(2);
		sr.setOid(null);
		cbSrManager.createSr(queryFactory, sr);
		return qtsr;
	}

}
