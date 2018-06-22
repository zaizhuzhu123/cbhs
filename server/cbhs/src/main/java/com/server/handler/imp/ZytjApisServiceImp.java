package com.server.handler.imp;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.server.common.BeanValidation;
import com.server.common.CbhsResUtils;
import com.server.common.DateObj;
import com.server.common.SheObject;
import com.server.common.TokenUtils;
import com.server.exception.ExceedException;
import com.server.handler.ZytjApisService;
import com.server.jpa.MyJPAQuery;
import com.server.jpa.MyJPAQuery.PagerResult;
import com.server.jpa.MyQueryFactory;
import com.server.manager.CbSrManager;
import com.server.manager.ExaminerManager;
import com.server.pojo.bean.CbhsCb;
import com.server.pojo.bean.CbhsZdgxhs;
import com.server.pojo.bean.CbhsZdgxhsFC;
import com.server.pojo.bean.CbhsZdgxhsGZ;
import com.server.pojo.bean.CbhsZdgxhsZC;
import com.server.pojo.bean.CbhsZytj;
import com.server.pojo.bean.CbhsZytjFC;
import com.server.pojo.bean.CbhsZytjGZ;
import com.server.pojo.bean.CbhsZytjZC;
import com.server.pojo.bean.QCbhsZdgxhs;
import com.server.pojo.bean.QCbhsZdgxhsFC;
import com.server.pojo.bean.QCbhsZdgxhsGZ;
import com.server.pojo.bean.QCbhsZdgxhsZC;
import com.server.pojo.bean.QCbhsZytj;
import com.server.pojo.bean.QCbhsZytjFC;
import com.server.pojo.bean.QCbhsZytjGZ;
import com.server.pojo.bean.QCbhsZytjZC;
import com.server.pojo.url.monthMbYs.RequestMbYsFetch;
import com.server.pojo.url.zytj.RequestZdgxhsDel;
import com.server.pojo.url.zytj.RequestZdgxhsFetch;
import com.server.pojo.url.zytj.RequestZytjAdd;
import com.server.pojo.url.zytj.RequestZytjDel;
import com.server.pojo.url.zytj.RequestZytjFetch;
import com.server.pojo.url.zytj.ResponseZdgxhsFetch;
import com.server.pojo.url.zytj.ResponseZytjFetch;
import com.server.util.DataSummaryUtils;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class ZytjApisServiceImp implements ZytjApisService {

	@Autowired
	private MyQueryFactory queryFactory;

	@Autowired
	private ExaminerManager examinerManager;

	@Autowired
	private CbSrManager cbSrManager;

	@Override
	public ResponseZytjFetch zytjFetch(RequestZytjFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsZytj query_ = QCbhsZytj.cbhsZytj;
		// 查询对象
		MyJPAQuery<CbhsZytj> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getDaysStart(), query_.dateTimeStamp.goe(request.getDaysStart()));
		jpaquery.where(request.getDaysEnd(), query_.dateTimeStamp.loe(request.getDaysEnd()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		jpaquery.where(request.getGlobalGclYsOid(), query_.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery.where(request.getFbCompanyOid(), query_.fbcompanyOid.eq(request.getFbCompanyOid()));
		// 查询总数
		ResponseZytjFetch response = new ResponseZytjFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		// 补入主材 工种 辅材
		if (pr.getTotal() > 0) {
			List<Integer> zytjOids = Lists.newArrayList();
			for (CbhsZytj zytj : response.getResult()) {
				zytj.setGzs(Lists.newArrayList());
				zytj.setZcs(Lists.newArrayList());
				zytj.setFcs(Lists.newArrayList());
				zytjOids.add(zytj.getOid());
			}
			Map<Integer, CbhsZytj> cbsMap = Maps.uniqueIndex(response.getResult(), new Function<CbhsZytj, Integer>() {
				public Integer apply(CbhsZytj from) {
					return from.getOid();
				}
			});
			// 所有工种
			List<CbhsZytjGZ> gzs = queryFactory.selectFrom(QCbhsZytjGZ.cbhsZytjGZ).where(QCbhsZytjGZ.cbhsZytjGZ.zytjOid.in(zytjOids)).fetch();
			if (gzs.size() > 0) {
				for (CbhsZytjGZ gz : gzs) {
					cbsMap.get(gz.getZytjOid()).getGzs().add(gz);
				}
			}
			// 所有主材
			List<CbhsZytjZC> zcs = queryFactory.selectFrom(QCbhsZytjZC.cbhsZytjZC).where(QCbhsZytjZC.cbhsZytjZC.zytjOid.in(zytjOids)).fetch();
			if (zcs.size() > 0) {
				for (CbhsZytjZC zc : zcs) {
					cbsMap.get(zc.getZytjOid()).getZcs().add(zc);
				}
			}
			// 所有辅材
			List<CbhsZytjFC> fcs = queryFactory.selectFrom(QCbhsZytjFC.cbhsZytjFC).where(QCbhsZytjFC.cbhsZytjFC.zytjOid.in(zytjOids)).fetch();
			if (fcs.size() > 0) {
				for (CbhsZytjFC fc : fcs) {
					cbsMap.get(fc.getZytjOid()).getFcs().add(fc);
				}
			}
		}
		return response;
	}

	@Override
	public CbhsZytj zytjUpdate(CbhsZytj zytj, HttpServletRequest httpServletRequest) throws Exception {
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, zytj.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, zytj.getDeptOid());
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, zytj.getFbcompanyOid());
		queryFactory.saveOrUpdate(zytj);
		queryFactory.delete(QCbhsZytjGZ.cbhsZytjGZ).where(QCbhsZytjGZ.cbhsZytjGZ.zytjOid.in(zytj.getOid())).execute();
		queryFactory.delete(QCbhsZytjZC.cbhsZytjZC).where(QCbhsZytjZC.cbhsZytjZC.zytjOid.in(zytj.getOid())).execute();
		queryFactory.delete(QCbhsZytjFC.cbhsZytjFC).where(QCbhsZytjFC.cbhsZytjFC.zytjOid.in(zytj.getOid())).execute();
		if (zytj.getGzs() != null && zytj.getGzs().size() > 0) {
			for (CbhsZytjGZ gz : zytj.getGzs()) {
				gz.setZytjOid(zytj.getOid());
			}
			queryFactory.batchSaveOrUpdate(zytj.getGzs());
		}
		if (zytj.getZcs() != null && zytj.getZcs().size() > 0) {
			for (CbhsZytjZC zc : zytj.getZcs()) {
				zc.setZytjOid(zytj.getOid());
			}
			queryFactory.batchSaveOrUpdate(zytj.getZcs());
		}
		if (zytj.getFcs() != null && zytj.getFcs().size() > 0) {
			for (CbhsZytjFC fc : zytj.getFcs()) {
				fc.setZytjOid(zytj.getOid());
			}
			queryFactory.batchSaveOrUpdate(zytj.getFcs());
		}
		cbSrManager.updateCb(queryFactory, SheObject.shType_zytj, zytj.getOid(), zytj.getTotal());
		return zytj;
	}

	@Override
	public JSONObject zytjDel(RequestZytjDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "资源统计ID不能为空!");
		queryFactory.delete(QCbhsZytj.cbhsZytj).where(QCbhsZytj.cbhsZytj.oid.in(request.getOids())).execute();
		queryFactory.delete(QCbhsZytjGZ.cbhsZytjGZ).where(QCbhsZytjGZ.cbhsZytjGZ.zytjOid.in(request.getOids())).execute();
		queryFactory.delete(QCbhsZytjZC.cbhsZytjZC).where(QCbhsZytjZC.cbhsZytjZC.zytjOid.in(request.getOids())).execute();
		queryFactory.delete(QCbhsZytjFC.cbhsZytjFC).where(QCbhsZytjFC.cbhsZytjFC.zytjOid.in(request.getOids())).execute();
		cbSrManager.delCb(queryFactory, SheObject.shType_zytj, request.getOids());
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsZytj zytjAdd(RequestZytjAdd request, HttpServletRequest httpServletRequest) throws Exception {
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, request.getCb().getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, request.getCb().getDeptOid());
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, request.getCb().getFbcompanyOid());
		CbhsZytj cb = request.getCb();
		cb.setShStatus(0);
		if (request.getSubmitType() == 0) {
			if (cb.getZcs() != null && cb.getZcs().size() > 0) {
				for (CbhsZytjZC c : cb.getZcs()) {
					bv.vali(BeanValidation.beanType.cailiao, BeanValidation.valiType.all, c.getClOid());
				}
				// 监测是否超出总预算
				RequestMbYsFetch r1 = new RequestMbYsFetch();
				r1.setProjectOid(cb.getProjectOid());
				r1.setDeptOid(cb.getDeptOid());
				r1.setMonth(new SimpleDateFormat("yyyy-MM-01").parse(new SimpleDateFormat("yyyy-MM-01").format(new Date(cb.getDateTimeStamp()))).getTime());
				try {
					DataSummaryUtils.checkFbCailiaoCbIsExceed(queryFactory, r1, cb, cb.getZcs(), Lists.newArrayList(cb.getDeptOid()), Lists.newArrayList(cb.getGlobalGclYsOid()));
				} catch (ExceedException e) {
					throw e;
				}
			}
			long time = cb.getDateTimeStamp() > 0 ? cb.getDateTimeStamp() : System.currentTimeMillis();
			DateTime dt = new DateTime(time);
			DateTime curDt = new DateTime(System.currentTimeMillis());
			cb.setDateStr(dt.toString("yyyy-MM-dd"));
			cb.setDateTimeStamp(time);
			cb.setMonthStr(dt.toString("yyyy-MM"));
			cb.setMonthTimeStamp(new DateObj(time, DateObj.type_month).getStartTime());
			cb.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
			cb.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
			cb.setOpTimeStr(curDt.toString("yyyy-MM-dd HH:mm:ss"));
			cb.setOpTime(curDt.getMillis());
			int cbOid = queryFactory.saveOrUpdate(cb).getOid();
			cb.setOid(cbOid);
			if (cb.getGzs() != null && cb.getGzs().size() > 0) {
				for (CbhsZytjGZ gz : cb.getGzs()) {
					gz.setZytjOid(cbOid);
				}
				queryFactory.batchSaveOrUpdate(cb.getGzs());
			}
			if (cb.getZcs() != null && cb.getZcs().size() > 0) {
				for (CbhsZytjZC zc : cb.getZcs()) {
					zc.setZytjOid(cbOid);
				}
				queryFactory.batchSaveOrUpdate(cb.getZcs());
			}
			if (cb.getFcs() != null && cb.getFcs().size() > 0) {
				for (CbhsZytjFC fc : cb.getFcs()) {
					fc.setZytjOid(cbOid);
				}
				queryFactory.batchSaveOrUpdate(cb.getFcs());
			}
			CbhsCb cb_ = JSON.parseObject(JSON.toJSONString(cb), CbhsCb.class);
			cb_.setOid(null);
			cb_.setType(SheObject.shType_zytj);
			cb_.setCbOid(cb.getOid());
			cbSrManager.createCb(queryFactory, cb_);
			if (cb.getRyPrice().compareTo(BigDecimal.ZERO) > 0) {
				CbhsCb shType_zytjry = JSON.parseObject(JSON.toJSONString(cb), CbhsCb.class);
				shType_zytjry.setOid(null);
				shType_zytjry.setType(SheObject.shType_zytjry);
				shType_zytjry.setTotal(cb.getRyPrice());
				shType_zytjry.setCbOid(cbOid);
				cbSrManager.createCb(queryFactory, shType_zytjry);
			}
			if (cb.getZcTotal().compareTo(BigDecimal.ZERO) > 0) {
				CbhsCb shType_zytjzc = JSON.parseObject(JSON.toJSONString(cb), CbhsCb.class);
				shType_zytjzc.setOid(null);
				shType_zytjzc.setType(SheObject.shType_zytjzc);
				shType_zytjzc.setTotal(cb.getZcTotal());
				shType_zytjzc.setCbOid(cbOid);
				cbSrManager.createCb(queryFactory, shType_zytjzc);
			}
		} else {
			ExceedException exception = null;
			String ext = null;
			if (cb.getZcs() != null && cb.getZcs().size() > 0) {
				for (CbhsZytjZC c : cb.getZcs()) {
					bv.vali(BeanValidation.beanType.cailiao, BeanValidation.valiType.all, c.getClOid());
				}
				// 监测是否超出总预算
				RequestMbYsFetch r1 = new RequestMbYsFetch();
				r1.setProjectOid(cb.getProjectOid());
				r1.setDeptOid(cb.getDeptOid());
				r1.setMonth(new SimpleDateFormat("yyyy-MM-01").parse(new SimpleDateFormat("yyyy-MM-01").format(new Date(System.currentTimeMillis()))).getTime());
				try {
					DataSummaryUtils.checkFbCailiaoCbIsExceed(queryFactory, r1, cb, cb.getZcs(), Lists.newArrayList(cb.getDeptOid()), Lists.newArrayList(cb.getGlobalGclYsOid()));
				} catch (ExceedException e) {
					ext = JSON.toJSONString(e.getInfo().getExceedInfos());
					cb.setShStatus(1);
					exception = e;
				}
			}
			long time = cb.getDateTimeStamp() > 0 ? cb.getDateTimeStamp() : System.currentTimeMillis();
			DateTime dt = new DateTime(time);
			DateTime curDt = new DateTime(System.currentTimeMillis());
			cb.setDateStr(dt.toString("yyyy-MM-dd"));
			cb.setDateTimeStamp(time);
			cb.setMonthStr(dt.toString("yyyy-MM"));
			cb.setMonthTimeStamp(new DateObj(time, DateObj.type_month).getStartTime());
			cb.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
			cb.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
			cb.setOpTimeStr(curDt.toString("yyyy-MM-dd HH:mm:ss"));
			cb.setOpTime(curDt.getMillis());
			int cbOid = queryFactory.saveOrUpdate(cb).getOid();
			cb.setOid(cbOid);
			if (cb.getGzs() != null && cb.getGzs().size() > 0) {
				for (CbhsZytjGZ gz : cb.getGzs()) {
					gz.setZytjOid(cbOid);
				}
				queryFactory.batchSaveOrUpdate(cb.getGzs());
			}
			if (cb.getZcs() != null && cb.getZcs().size() > 0) {
				for (CbhsZytjZC zc : cb.getZcs()) {
					zc.setZytjOid(cbOid);
				}
				queryFactory.batchSaveOrUpdate(cb.getZcs());
			}
			if (cb.getFcs() != null && cb.getFcs().size() > 0) {
				for (CbhsZytjFC fc : cb.getFcs()) {
					fc.setZytjOid(cbOid);
				}
				queryFactory.batchSaveOrUpdate(cb.getFcs());
			}
			if (cb.getShStatus() == 1) {
				examinerManager.createExaminer(queryFactory, cb.getProjectOid(), SheObject.shType_zytj, cb.getOid(), cb.getDeptOid(), cb.getDeptName(), ext, exception.getInfo().getErrorMessage(), exception.getInfo().getErrorMessage(), TokenUtils.getTokenInfo(httpServletRequest).getUserOid(), TokenUtils.getTokenInfo(httpServletRequest).getUserName());
			} else {
				CbhsCb cb_ = JSON.parseObject(JSON.toJSONString(cb), CbhsCb.class);
				cb_.setOid(null);
				cb_.setType(SheObject.shType_zytj);
				cb_.setCbOid(cb.getOid());
				cbSrManager.createCb(queryFactory, cb_);
				if (cb.getRyPrice().compareTo(BigDecimal.ZERO) > 0) {
					CbhsCb shType_zytjry = JSON.parseObject(JSON.toJSONString(cb), CbhsCb.class);
					shType_zytjry.setOid(null);
					shType_zytjry.setType(SheObject.shType_zytjry);
					shType_zytjry.setTotal(cb.getRyPrice());
					shType_zytjry.setCbOid(cbOid);
					cbSrManager.createCb(queryFactory, shType_zytjry);
				}
				if (cb.getZcTotal().compareTo(BigDecimal.ZERO) > 0) {
					CbhsCb shType_zytjzc = JSON.parseObject(JSON.toJSONString(cb), CbhsCb.class);
					shType_zytjzc.setOid(null);
					shType_zytjzc.setType(SheObject.shType_zytjzc);
					shType_zytjzc.setTotal(cb.getZcTotal());
					shType_zytjzc.setCbOid(cbOid);
					cbSrManager.createCb(queryFactory, shType_zytjzc);
				}
			}
		}
		return request.getCb();
	}

	@Override
	public ResponseZdgxhsFetch zdgxhsFetch(RequestZdgxhsFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsZdgxhs query_ = QCbhsZdgxhs.cbhsZdgxhs;
		// 查询对象
		MyJPAQuery<CbhsZdgxhs> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getDaysStart(), query_.dateTimeStamp.goe(request.getDaysStart()));
		jpaquery.where(request.getDaysEnd(), query_.dateTimeStamp.loe(request.getDaysEnd()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		jpaquery.where(request.getFbGclYsOid(), query_.fbGclYsOid.eq(request.getFbGclYsOid()));
		jpaquery.where(request.getFbCompanyOid(), query_.fbcompanyOid.eq(request.getFbCompanyOid()));
		// 查询总数
		ResponseZdgxhsFetch response = new ResponseZdgxhsFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		// 补入主材 工种 辅材
		if (pr.getTotal() > 0) {
			List<Integer> zytjOids = Lists.newArrayList();
			for (CbhsZdgxhs zytj : response.getResult()) {
				zytj.setGzs(Lists.newArrayList());
				zytj.setZcs(Lists.newArrayList());
				zytj.setFcs(Lists.newArrayList());
				zytjOids.add(zytj.getOid());
			}
			Map<Integer, CbhsZdgxhs> cbsMap = Maps.uniqueIndex(response.getResult(), new Function<CbhsZdgxhs, Integer>() {
				public Integer apply(CbhsZdgxhs from) {
					return from.getOid();
				}
			});
			// 所有工种
			List<CbhsZdgxhsGZ> gzs = queryFactory.selectFrom(QCbhsZdgxhsGZ.cbhsZdgxhsGZ).where(QCbhsZdgxhsGZ.cbhsZdgxhsGZ.zytjOid.in(zytjOids)).fetch();
			if (gzs.size() > 0) {
				for (CbhsZdgxhsGZ gz : gzs) {
					cbsMap.get(gz.getZytjOid()).getGzs().add(gz);
				}
			}
			// 所有主材
			List<CbhsZdgxhsZC> zcs = queryFactory.selectFrom(QCbhsZdgxhsZC.cbhsZdgxhsZC).where(QCbhsZdgxhsZC.cbhsZdgxhsZC.zytjOid.in(zytjOids)).fetch();
			if (zcs.size() > 0) {
				for (CbhsZdgxhsZC zc : zcs) {
					cbsMap.get(zc.getZytjOid()).getZcs().add(zc);
				}
			}
			// 所有辅材
			List<CbhsZdgxhsFC> fcs = queryFactory.selectFrom(QCbhsZdgxhsFC.cbhsZdgxhsFC).where(QCbhsZdgxhsFC.cbhsZdgxhsFC.zytjOid.in(zytjOids)).fetch();
			if (fcs.size() > 0) {
				for (CbhsZdgxhsFC fc : fcs) {
					cbsMap.get(fc.getZytjOid()).getFcs().add(fc);
				}
			}
		}
		return response;
	}

	@Override
	public CbhsZdgxhs zdgxhsUpdate(CbhsZdgxhs zdgxhs, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(zdgxhs.getOid() > 0, "修改项的ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, zdgxhs.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, zdgxhs.getDeptOid());
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, zdgxhs.getFbcompanyOid());
		queryFactory.saveOrUpdate(zdgxhs);
		queryFactory.delete(QCbhsZdgxhsGZ.cbhsZdgxhsGZ).where(QCbhsZdgxhsGZ.cbhsZdgxhsGZ.zytjOid.in(zdgxhs.getOid())).execute();
		queryFactory.delete(QCbhsZdgxhsZC.cbhsZdgxhsZC).where(QCbhsZdgxhsZC.cbhsZdgxhsZC.zytjOid.in(zdgxhs.getOid())).execute();
		queryFactory.delete(QCbhsZdgxhsFC.cbhsZdgxhsFC).where(QCbhsZdgxhsFC.cbhsZdgxhsFC.zytjOid.in(zdgxhs.getOid())).execute();
		if (zdgxhs.getGzs() != null && zdgxhs.getGzs().size() > 0) {
			for (CbhsZdgxhsGZ gz : zdgxhs.getGzs()) {
				gz.setZytjOid(zdgxhs.getOid());
			}
			queryFactory.batchSaveOrUpdate(zdgxhs.getGzs());
		}
		if (zdgxhs.getZcs() != null && zdgxhs.getZcs().size() > 0) {
			for (CbhsZdgxhsZC zc : zdgxhs.getZcs()) {
				zc.setZytjOid(zdgxhs.getOid());
			}
			queryFactory.batchSaveOrUpdate(zdgxhs.getZcs());
		}
		if (zdgxhs.getFcs() != null && zdgxhs.getFcs().size() > 0) {
			for (CbhsZdgxhsFC fc : zdgxhs.getFcs()) {
				fc.setZytjOid(zdgxhs.getOid());
			}
			queryFactory.batchSaveOrUpdate(zdgxhs.getFcs());
		}
		return zdgxhs;
	}

	@Override
	public JSONObject zdgxhsDel(RequestZdgxhsDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "重点工序核算ID不能为空!");
		queryFactory.delete(QCbhsZdgxhs.cbhsZdgxhs).where(QCbhsZdgxhs.cbhsZdgxhs.oid.in(request.getOids())).execute();
		queryFactory.delete(QCbhsZdgxhsGZ.cbhsZdgxhsGZ).where(QCbhsZdgxhsGZ.cbhsZdgxhsGZ.zytjOid.in(request.getOids())).execute();
		queryFactory.delete(QCbhsZdgxhsZC.cbhsZdgxhsZC).where(QCbhsZdgxhsZC.cbhsZdgxhsZC.zytjOid.in(request.getOids())).execute();
		queryFactory.delete(QCbhsZdgxhsFC.cbhsZdgxhsFC).where(QCbhsZdgxhsFC.cbhsZdgxhsFC.zytjOid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsZdgxhs zdgxhsAdd(CbhsZdgxhs zdgxhs, HttpServletRequest httpServletRequest) throws Exception {
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, zdgxhs.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, zdgxhs.getDeptOid());
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, zdgxhs.getFbcompanyOid());
		long time = zdgxhs.getDateTimeStamp() > 0 ? zdgxhs.getDateTimeStamp() : System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		DateTime curDt = new DateTime(System.currentTimeMillis());
		zdgxhs.setDateStr(dt.toString("yyyy-MM-dd"));
		zdgxhs.setDateTimeStamp(time);
		zdgxhs.setMonthStr(dt.toString("yyyy-MM"));
		zdgxhs.setMonthTimeStamp(new DateObj(time, DateObj.type_month).getStartTime());
		zdgxhs.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		zdgxhs.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		zdgxhs.setOpTimeStr(curDt.toString("yyyy-MM-dd HH:mm:ss"));
		zdgxhs.setOpTime(curDt.getMillis());
		int cbOid = queryFactory.saveOrUpdate(zdgxhs).getOid();
		if (zdgxhs.getGzs() != null && zdgxhs.getGzs().size() > 0) {
			for (CbhsZdgxhsGZ gz : zdgxhs.getGzs()) {
				gz.setZytjOid(cbOid);
			}
			queryFactory.batchSaveOrUpdate(zdgxhs.getGzs());
		}
		if (zdgxhs.getZcs() != null && zdgxhs.getZcs().size() > 0) {
			for (CbhsZdgxhsZC zc : zdgxhs.getZcs()) {
				zc.setZytjOid(cbOid);
			}
			queryFactory.batchSaveOrUpdate(zdgxhs.getZcs());
		}
		if (zdgxhs.getFcs() != null && zdgxhs.getFcs().size() > 0) {
			for (CbhsZdgxhsFC fc : zdgxhs.getFcs()) {
				fc.setZytjOid(cbOid);
			}
			queryFactory.batchSaveOrUpdate(zdgxhs.getFcs());
		}
		return zdgxhs;
	}

}
