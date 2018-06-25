package com.server.handler.imp;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.server.common.BeanValidation;
import com.server.common.CbhsResUtils;
import com.server.common.DateObj;
import com.server.common.SheObject;
import com.server.common.TokenUtils;
import com.server.exception.ExceedException;
import com.server.exception.ExceptionResponse;
import com.server.exception.ServiceException;
import com.server.handler.DaysCbApisService;
import com.server.jpa.MyJPAQuery;
import com.server.jpa.MyJPAQuery.PagerResult;
import com.server.jpa.MyQueryFactory;
import com.server.manager.CbSrManager;
import com.server.manager.ExaminerManager;
import com.server.pojo.bean.CbhsCailiao;
import com.server.pojo.bean.CbhsCb;
import com.server.pojo.bean.CbhsDaysFbGclTj;
import com.server.pojo.bean.CbhsDaysFbLjxmCb;
import com.server.pojo.bean.CbhsDaysGlfyYs;
import com.server.pojo.bean.CbhsDaysJjcb;
import com.server.pojo.bean.CbhsDaysZyCailiaoCb;
import com.server.pojo.bean.CbhsDaysZyJxCb;
import com.server.pojo.bean.CbhsDaysZyLxygCb;
import com.server.pojo.bean.CbhsDaysZyQtCb;
import com.server.pojo.bean.CbhsGlfyRule;
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
import com.server.pojo.bean.QCbhsGlfyRule;
import com.server.pojo.bean.QCbhsMonthFbGcCbYs;
import com.server.pojo.bean.QCbhsMonthFbLjxmCbYs;
import com.server.pojo.url.daysCb.RequestFbGclTjCbAdd;
import com.server.pojo.url.daysCb.RequestFbGclTjCbDel;
import com.server.pojo.url.daysCb.RequestFbGclTjCbFetch;
import com.server.pojo.url.daysCb.RequestFbJgAdd;
import com.server.pojo.url.daysCb.RequestFbJgUpdate;
import com.server.pojo.url.daysCb.RequestFbLjxmCbAddCount;
import com.server.pojo.url.daysCb.RequestFbLjxmCbAddJg;
import com.server.pojo.url.daysCb.RequestFbLjxmCbDel;
import com.server.pojo.url.daysCb.RequestFbLjxmCbFetch;
import com.server.pojo.url.daysCb.RequestFbLjxmCbUpdateJg;
import com.server.pojo.url.daysCb.RequestGlfyAdd;
import com.server.pojo.url.daysCb.RequestGlfyDel;
import com.server.pojo.url.daysCb.RequestGlfyFetch;
import com.server.pojo.url.daysCb.RequestJjcbAdd;
import com.server.pojo.url.daysCb.RequestJjcbDel;
import com.server.pojo.url.daysCb.RequestJjcbFetch;
import com.server.pojo.url.daysCb.RequestTodayFetch;
import com.server.pojo.url.daysCb.RequestZyCailiaoCbAdd;
import com.server.pojo.url.daysCb.RequestZyCailiaoCbDel;
import com.server.pojo.url.daysCb.RequestZyCailiaoCbFetch;
import com.server.pojo.url.daysCb.RequestZyJxCbAdd;
import com.server.pojo.url.daysCb.RequestZyJxCbDel;
import com.server.pojo.url.daysCb.RequestZyJxCbFetch;
import com.server.pojo.url.daysCb.RequestZyLxygCbAdd;
import com.server.pojo.url.daysCb.RequestZyLxygCbDel;
import com.server.pojo.url.daysCb.RequestZyLxygCbFetch;
import com.server.pojo.url.daysCb.RequestZyQtCbAdd;
import com.server.pojo.url.daysCb.RequestZyQtCbDel;
import com.server.pojo.url.daysCb.RequestZyQtCbFetch;
import com.server.pojo.url.daysCb.ResponseFbGclTjCbFetch;
import com.server.pojo.url.daysCb.ResponseFbLjxmCbFetch;
import com.server.pojo.url.daysCb.ResponseGlfyFetch;
import com.server.pojo.url.daysCb.ResponseJjcbFetch;
import com.server.pojo.url.daysCb.ResponseZyCailiaoCbAdd;
import com.server.pojo.url.daysCb.ResponseZyCailiaoCbFetch;
import com.server.pojo.url.daysCb.ResponseZyJxCbFetch;
import com.server.pojo.url.daysCb.ResponseZyLxygCbFetch;
import com.server.pojo.url.daysCb.ResponseZyQtCbFetch;
import com.server.pojo.url.monthMbYs.RequestMbYsFetch;
import com.server.util.DataSummaryObj;
import com.server.util.DataSummaryUtils;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class DaysCbApisServiceImp implements DaysCbApisService {
	@Autowired
	private MyQueryFactory queryFactory;

	@Autowired
	private ExaminerManager examinerManager;

	@Autowired
	private CbSrManager cbSrManager;

	@Override
	public ResponseJjcbFetch jjcbFetch(RequestJjcbFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsDaysJjcb query_ = QCbhsDaysJjcb.cbhsDaysJjcb;
		// 查询对象
		MyJPAQuery<CbhsDaysJjcb> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getDaysStart(), query_.dateTimeStamp.goe(request.getDaysStart()));
		if (request.getDaysEnd() != null && request.getDaysEnd() > 0) {
			DateTime dt = new DateTime(request.getDaysEnd());
			dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59, 59, 999);
			request.setDaysEnd(dt.getMillis());
		}
		jpaquery.where(request.getDaysEnd(), query_.dateTimeStamp.loe(request.getDaysEnd()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseJjcbFetch response = new ResponseJjcbFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	public CbhsDaysJjcb jjcbUpdate(CbhsDaysJjcb ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "修改项的ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys = queryFactory.saveOrUpdate(ys);
		cbSrManager.updateCb(queryFactory, SheObject.shType_Jjcb, ys.getOid(), ys.getTotal());
		return ys;
	}

	@Override
	public JSONObject jjcbDel(RequestJjcbDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "间接成本ID不能为空!");
		queryFactory.delete(QCbhsDaysJjcb.cbhsDaysJjcb).where(QCbhsDaysJjcb.cbhsDaysJjcb.oid.in(request.getOids())).execute();
		cbSrManager.delCb(queryFactory, SheObject.shType_Jjcb, request.getOids());
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsDaysJjcb jjcbAdd(RequestJjcbAdd request, HttpServletRequest httpServletRequest) throws Exception {
		CbhsDaysJjcb ys = request.getCb();
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys.setShStatus(0);
		String ext = null;
		ExceedException exception = null;
		long time = ys.getDateTimeStamp() > 0 ? ys.getDateTimeStamp() : System.currentTimeMillis();
		// 监测是否超出总预算
		try {
			DataSummaryObj dsObj = new DataSummaryObj();
			dsObj.setProjectOid(ys.getProjectOid());
			dsObj.setDeptOids(Lists.newArrayList(ys.getDeptOid()));
			dsObj.setDt(new DateObj(time, DateObj.type_month));
			DataSummaryUtils.checkJjCbIsExceed(queryFactory, dsObj, ys);
		} catch (ExceedException e) {
			if (request.getSubmitType() == 0) { // 默认提交
				throw e;
			} else {
				ext = JSON.toJSONString(e.getInfo().getExceedInfos());
				ys.setShStatus(1);
				exception = e;
			}
		}
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
		ys = queryFactory.saveOrUpdate(ys);
		if (ys.getShStatus() == 1) { // 审核提交 需要向审核者发送推送消息
			examinerManager.createExaminer(queryFactory, ys.getProjectOid(), SheObject.shType_Jjcb, ys.getOid(), ys.getDeptOid(), ys.getDeptName(), ext, exception.getInfo().getErrorMessage(), exception.getInfo().getErrorMessage(), TokenUtils.getTokenInfo(httpServletRequest).getUserOid(), TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		} else {
			CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
			cb.setOid(null);
			cb.setType(SheObject.shType_Jjcb);
			cb.setCbOid(ys.getOid());
			cbSrManager.createCb(queryFactory, cb);
		}
		return ys;
	}

	@Override
	public ResponseGlfyFetch glfyFetch(RequestGlfyFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsDaysGlfyYs query_ = QCbhsDaysGlfyYs.cbhsDaysGlfyYs;
		// 查询对象
		MyJPAQuery<CbhsDaysGlfyYs> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getDaysStart(), query_.dateTimeStamp.goe(request.getDaysStart()));
		if (request.getDaysEnd() != null && request.getDaysEnd() > 0) {
			DateTime dt = new DateTime(request.getDaysEnd());
			dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59, 59, 999);
			request.setDaysEnd(dt.getMillis());
		}
		jpaquery.where(request.getDaysEnd(), query_.dateTimeStamp.loe(request.getDaysEnd()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseGlfyFetch response = new ResponseGlfyFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	public CbhsDaysGlfyYs glfyUpdate(CbhsDaysGlfyYs ys, HttpServletRequest httpServletRequest) throws Exception {
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys = queryFactory.saveOrUpdate(ys);
		cbSrManager.updateCb(queryFactory, SheObject.shType_glfycb, ys.getOid(), ys.getTotal());

		return ys;
	}

	@Override
	public JSONObject glfyDel(RequestGlfyDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "管理费用ID不能为空!");
		queryFactory.delete(QCbhsDaysGlfyYs.cbhsDaysGlfyYs).where(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.oid.in(request.getOids())).execute();
		cbSrManager.delCb(queryFactory, SheObject.shType_glfycb, request.getOids());
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsDaysGlfyYs glfyAdd(RequestGlfyAdd request, HttpServletRequest httpServletRequest) throws Exception {
		CbhsDaysGlfyYs ys = request.getCb();
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys.setShStatus(0);
		// 监测是否超出总预算
		String ext = null;
		ExceedException exception = null;
		long time = ys.getDateTimeStamp() > 0 ? ys.getDateTimeStamp() : System.currentTimeMillis();
		try {
			DataSummaryObj dsObj = new DataSummaryObj();
			dsObj.setProjectOid(ys.getProjectOid());
			dsObj.setDeptOids(Lists.newArrayList());
			dsObj.setDt(new DateObj(time, DateObj.type_month));
			DataSummaryUtils.checkGlfyIsExceed(queryFactory, dsObj, ys);
		} catch (ExceedException e) {
			if (request.getSubmitType() == 0) { // 默认提交
				throw e;
			} else {
				ext = JSON.toJSONString(e.getInfo().getExceedInfos());
				ys.setShStatus(1);
				exception = e;
			}
		}
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
		ys = queryFactory.saveOrUpdate(ys);
		if (ys.getShStatus() == 1) { // 审核提交 需要向审核者发送推送消息
			examinerManager.createExaminer(queryFactory, ys.getProjectOid(), SheObject.shType_glfycb, ys.getOid(), ys.getDeptOid(), ys.getDeptName(), ext, exception.getInfo().getErrorMessage(), exception.getInfo().getErrorMessage(), TokenUtils.getTokenInfo(httpServletRequest).getUserOid(), TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		} else {
			CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
			cb.setOid(null);
			cb.setType(SheObject.shType_glfycb);
			cb.setCbOid(ys.getOid());
			cbSrManager.createCb(queryFactory, cb);
		}
		return ys;
	}

	@Override
	public ResponseZyLxygCbFetch zyLxygCbFetch(RequestZyLxygCbFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsDaysZyLxygCb query_ = QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb;
		// 查询对象
		MyJPAQuery<CbhsDaysZyLxygCb> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getDaysStart(), query_.dateTimeStamp.goe(request.getDaysStart()));
		if (request.getDaysEnd() != null && request.getDaysEnd() > 0) {
			DateTime dt = new DateTime(request.getDaysEnd());
			dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59, 59, 999);
			request.setDaysEnd(dt.getMillis());
		}
		jpaquery.where(request.getDaysEnd(), query_.dateTimeStamp.loe(request.getDaysEnd()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseZyLxygCbFetch response = new ResponseZyLxygCbFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	public CbhsDaysZyLxygCb zyLxygCbUpdate(CbhsDaysZyLxygCb ys, HttpServletRequest httpServletRequest) throws Exception {
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys = queryFactory.saveOrUpdate(ys);
		cbSrManager.updateCb(queryFactory, SheObject.shType_zylxyg, ys.getOid(), ys.getTotal());

		return ys;
	}

	@Override
	public JSONObject zyLxygCbDel(RequestZyLxygCbDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "零星用工ID不能为空!");
		queryFactory.delete(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb).where(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb.oid.in(request.getOids())).execute();
		cbSrManager.delCb(queryFactory, SheObject.shType_zylxyg, request.getOids());

		return CbhsResUtils.suc();
	}

	@Override
	public CbhsDaysZyLxygCb zyLxygCbAdd(RequestZyLxygCbAdd request, HttpServletRequest httpServletRequest) throws Exception {
		CbhsDaysZyLxygCb ys = request.getCb();
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys.setShStatus(0);
		// 监测是否超出总预算
		String ext = null;
		ExceedException exception = null;
		long time = ys.getDateTimeStamp() > 0 ? ys.getDateTimeStamp() : System.currentTimeMillis();
		try {
			DataSummaryObj dsObj = new DataSummaryObj();
			dsObj.setProjectOid(ys.getProjectOid());
			dsObj.setDeptOids(Lists.newArrayList(ys.getDeptOid()));
			dsObj.setDt(new DateObj(time, DateObj.type_month));
			DataSummaryUtils.checkZyLxygIsExceed(queryFactory, dsObj, ys);
		} catch (ExceedException e) {
			if (request.getSubmitType() == 0) { // 默认提交
				throw e;
			} else {
				ext = JSON.toJSONString(e.getInfo().getExceedInfos());
				ys.setShStatus(1);
				exception = e;
			}
		}
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
		ys = queryFactory.saveOrUpdate(ys);
		if (ys.getShStatus() == 1) { // 审核提交 需要向审核者发送推送消息
			examinerManager.createExaminer(queryFactory, ys.getProjectOid(), SheObject.shType_zylxyg, ys.getOid(), ys.getDeptOid(), ys.getDeptName(), ext, exception.getInfo().getErrorMessage(), exception.getInfo().getErrorMessage(), TokenUtils.getTokenInfo(httpServletRequest).getUserOid(), TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		} else {
			CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
			cb.setOid(null);
			cb.setType(SheObject.shType_zylxyg);
			cb.setCbOid(ys.getOid());
			cbSrManager.createCb(queryFactory, cb);
		}
		return ys;
	}

	@Override
	public ResponseZyJxCbFetch zyJxCbFetch(RequestZyJxCbFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsDaysZyJxCb query_ = QCbhsDaysZyJxCb.cbhsDaysZyJxCb;
		// 查询对象
		MyJPAQuery<CbhsDaysZyJxCb> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getDaysStart(), query_.dateTimeStamp.goe(request.getDaysStart()));
		jpaquery.where(request.getMachineryOid(), query_.machineryOid.eq(request.getMachineryOid()));
		jpaquery.where(request.getGlobalGclYsOid(), query_.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		if (request.getDaysEnd() != null && request.getDaysEnd() > 0) {
			DateTime dt = new DateTime(request.getDaysEnd());
			dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59, 59, 999);
			request.setDaysEnd(dt.getMillis());
		}
		jpaquery.where(request.getDaysEnd(), query_.dateTimeStamp.loe(request.getDaysEnd()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseZyJxCbFetch response = new ResponseZyJxCbFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsDaysZyJxCb zyJxCbUpdate(CbhsDaysZyJxCb ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "机械成本ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys = queryFactory.saveOrUpdate(ys);
		CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
		cb.setOid(null);
		cb.setType(SheObject.shType_zyjxcb);
		cb.setCbOid(ys.getOid());
		cbSrManager.createCb(queryFactory, cb);
		if (ys.getRyPrice().compareTo(BigDecimal.ZERO) > 0) {
			CbhsCb shType_zyjxcbry = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
			shType_zyjxcbry.setOid(null);
			shType_zyjxcbry.setType(SheObject.shType_zyjxcbry);
			shType_zyjxcbry.setTotal(ys.getRyPrice());
			shType_zyjxcbry.setCbOid(ys.getOid());
			cbSrManager.createCb(queryFactory, cb);
		}
		return ys;
	}

	@Override
	public JSONObject zyJxCbDel(RequestZyJxCbDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "自营机械成本ID不能为空!");
		queryFactory.delete(QCbhsDaysZyJxCb.cbhsDaysZyJxCb).where(QCbhsDaysZyJxCb.cbhsDaysZyJxCb.oid.in(request.getOids())).execute();
		cbSrManager.delCb(queryFactory, SheObject.shType_zyjxcb, request.getOids());
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsDaysZyJxCb zyJxCbAdd(RequestZyJxCbAdd request, HttpServletRequest httpServletRequest) throws Exception {
		CbhsDaysZyJxCb ys = request.getCb();
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys.setShStatus(0);
		// 监测是否超出总预算
		String ext = null;
		ExceedException exception = null;
		long time = ys.getDateTimeStamp() > 0 ? ys.getDateTimeStamp() : System.currentTimeMillis();
		try {
			DataSummaryObj dsObj = new DataSummaryObj();
			dsObj.setProjectOid(ys.getProjectOid());
			dsObj.setDeptOids(Lists.newArrayList(ys.getDeptOid()));
			dsObj.setDt(new DateObj(time, DateObj.type_month));
			dsObj.setGlobalGclOids(Lists.newArrayList(ys.getGlobalGclYsOid()));
			DataSummaryUtils.checkZyJxCbIsExceed(queryFactory, dsObj, request.getCb());
		} catch (ExceedException e) {
			if (request.getSubmitType() == 0) { // 默认提交
				throw e;
			} else {
				ext = JSON.toJSONString(e.getInfo().getExceedInfos());
				ys.setShStatus(1);
				exception = e;
			}
		}
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
		if (ys.getRyOid() != null && ys.getRyOid() > 0) {
			CbhsCailiao ryCailiao = queryFactory.findOne(CbhsCailiao.class, ys.getRyOid());
			if (ryCailiao != null) {
				ys.setRyKemuName(ryCailiao.getKemuName());
				ys.setRyStyle(ryCailiao.getStyle());
			}
		}
		ys = queryFactory.saveOrUpdate(ys);
		if (ys.getShStatus() == 1) { // 审核提交 需要向审核者发送推送消息
			examinerManager.createExaminer(queryFactory, ys.getProjectOid(), SheObject.shType_zyjxcb, ys.getOid(), ys.getDeptOid(), ys.getDeptName(), ext, exception.getInfo().getErrorMessage(), exception.getInfo().getErrorMessage(), TokenUtils.getTokenInfo(httpServletRequest).getUserOid(), TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		} else {
			CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
			cb.setOid(null);
			cb.setType(SheObject.shType_zyjxcb);
			cb.setCbOid(ys.getOid());
			cbSrManager.createCb(queryFactory, cb);
			if (ys.getRyPrice().compareTo(BigDecimal.ZERO) > 0) {
				CbhsCb shType_zyjxcbry = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
				shType_zyjxcbry.setOid(null);
				shType_zyjxcbry.setType(SheObject.shType_zyjxcbry);
				shType_zyjxcbry.setTotal(ys.getRyPrice());
				shType_zyjxcbry.setCbOid(ys.getOid());
				cbSrManager.createCb(queryFactory, cb);
			}
		}
		return ys;
	}

	@Override
	public ResponseZyQtCbFetch zyQtCbFetch(RequestZyQtCbFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsDaysZyQtCb query_ = QCbhsDaysZyQtCb.cbhsDaysZyQtCb;
		// 查询对象
		MyJPAQuery<CbhsDaysZyQtCb> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getDaysStart(), query_.dateTimeStamp.goe(request.getDaysStart()));
		if (request.getDaysEnd() != null && request.getDaysEnd() > 0) {
			DateTime dt = new DateTime(request.getDaysEnd());
			dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59, 59, 999);
			request.setDaysEnd(dt.getMillis());
		}
		jpaquery.where(request.getDaysEnd(), query_.dateTimeStamp.loe(request.getDaysEnd()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseZyQtCbFetch response = new ResponseZyQtCbFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsDaysZyQtCb zyQtCbUpdate(CbhsDaysZyQtCb ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "其他成本ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys = queryFactory.saveOrUpdate(ys);
		cbSrManager.updateCb(queryFactory, SheObject.shType_qtcb, ys.getOid(), ys.getTotal());

		return ys;
	}

	@Override
	public JSONObject zyQtCbDel(RequestZyQtCbDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "其他成本ID不能为空!");
		queryFactory.delete(QCbhsDaysZyQtCb.cbhsDaysZyQtCb).where(QCbhsDaysZyQtCb.cbhsDaysZyQtCb.oid.in(request.getOids())).execute();
		cbSrManager.delCb(queryFactory, SheObject.shType_qtcb, request.getOids());

		return CbhsResUtils.suc();
	}

	@Override
	public CbhsDaysZyQtCb zyQtCbAdd(RequestZyQtCbAdd request, HttpServletRequest httpServletRequest) throws Exception {
		CbhsDaysZyQtCb ys = request.getCb();
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		ys.setShStatus(0);

		// 监测是否超出总预算
		String ext = null;
		ExceedException exception = null;
		long time = ys.getDateTimeStamp() > 0 ? ys.getDateTimeStamp() : System.currentTimeMillis();
		try {
			DataSummaryObj dsObj = new DataSummaryObj();
			dsObj.setProjectOid(ys.getProjectOid());
			dsObj.setDeptOids(Lists.newArrayList(ys.getDeptOid()));
			dsObj.setDt(new DateObj(time, DateObj.type_month));
			DataSummaryUtils.checkZyQtCbIsExceed(queryFactory, dsObj, ys);
		} catch (ExceedException e) {
			if (request.getSubmitType() == 0) { // 默认提交
				throw e;
			} else {
				ext = JSON.toJSONString(e.getInfo().getExceedInfos());
				ys.setShStatus(1);
				exception = e;
			}
		}
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
		ys = queryFactory.saveOrUpdate(ys);
		if (ys.getShStatus() == 1) { // 审核提交 需要向审核者发送推送消息
			examinerManager.createExaminer(queryFactory, ys.getProjectOid(), SheObject.shType_qtcb, ys.getOid(), ys.getDeptOid(), ys.getDeptName(), ext, exception.getInfo().getErrorMessage(), exception.getInfo().getErrorMessage(), TokenUtils.getTokenInfo(httpServletRequest).getUserOid(), TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		} else {
			CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
			cb.setOid(null);
			cb.setType(SheObject.shType_qtcb);
			cb.setCbOid(ys.getOid());
			cbSrManager.createCb(queryFactory, cb);
		}
		return ys;
	}

	@Override
	public ResponseZyCailiaoCbFetch zyCailiaoCbFetch(RequestZyCailiaoCbFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsDaysZyCailiaoCb query_ = QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb;
		// 查询对象
		MyJPAQuery<CbhsDaysZyCailiaoCb> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getDaysStart(), query_.dateTimeStamp.goe(request.getDaysStart()));
		if (request.getDaysEnd() != null && request.getDaysEnd() > 0) {
			DateTime dt = new DateTime(request.getDaysEnd());
			dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59, 59, 999);
			request.setDaysEnd(dt.getMillis());
		}
		jpaquery.where(request.getDaysEnd(), query_.dateTimeStamp.loe(request.getDaysEnd()));
		jpaquery.where(request.getGlobalGclYsOid(), query_.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseZyCailiaoCbFetch response = new ResponseZyCailiaoCbFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsDaysZyCailiaoCb zyCailiaoCbUpdate(CbhsDaysZyCailiaoCb ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "自营材料成本ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		Preconditions.checkArgument(ys.getGlobalGclYsOid() > 0, "工程量ID不能为空!");
		Preconditions.checkArgument(queryFactory.exists(QCbhsGclQdYs.cbhsGclQdYs, QCbhsGclQdYs.cbhsGclQdYs.oid.eq(ys.getGlobalGclYsOid())), "工程量项目不存在!");
		ys = queryFactory.saveOrUpdate(ys);
		cbSrManager.updateCb(queryFactory, SheObject.shType_zycailiaocb, ys.getOid(), ys.getTotal());

		return ys;
	}

	@Override
	public JSONObject zyCailiaoCbDel(RequestZyCailiaoCbDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "自营材料成本ID不能为空!");
		queryFactory.delete(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb).where(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.oid.in(request.getOids())).execute();
		cbSrManager.delCb(queryFactory, SheObject.shType_zycailiaocb, request.getOids());

		return CbhsResUtils.suc();
	}

	@Override
	public ResponseZyCailiaoCbAdd zyCailiaoCbAdd(RequestZyCailiaoCbAdd request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		if (request.getYss() != null && request.getYss().size() > 0) {
			List<CbhsDaysZyCailiaoCb> entitys = Lists.newArrayList();
			ExceedException exception = null;
			if (request.getSubmitType() == 0) {
				for (CbhsDaysZyCailiaoCb ys : request.getYss()) {
					ys.setOid(null);
					BeanValidation bv = new BeanValidation(queryFactory);
					bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
					bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
					bv.vali(BeanValidation.beanType.cailiao, BeanValidation.valiType.all, ys.getCailiaoOid());
					Preconditions.checkArgument(ys.getGlobalGclYsOid() > 0, "工程量ID不能为空!");
					Preconditions.checkArgument(queryFactory.exists(QCbhsGclQdYs.cbhsGclQdYs, QCbhsGclQdYs.cbhsGclQdYs.oid.eq(ys.getGlobalGclYsOid())), "工程量项目不存在!");
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
				}
				// 监测是否超出总预算

				try {
					DataSummaryObj dsObj = new DataSummaryObj();
					dsObj.setProjectOid(entitys.get(0).getProjectOid());
					dsObj.setDeptOids(Lists.newArrayList(entitys.get(0).getDeptOid()));
					dsObj.setDt(new DateObj(entitys.get(0).getDateTimeStamp(), DateObj.type_month));
					dsObj.setGlobalGclOids(Lists.newArrayList(entitys.get(0).getGlobalGclYsOid()));
					DataSummaryUtils.checkZyCailiaoCbIsExceed(queryFactory, dsObj, entitys);
				} catch (ExceedException e) {
					throw e;
				}
				queryFactory.batchSaveOrUpdate(entitys);
			}
			if (request.getSubmitType() == 1) {
				for (CbhsDaysZyCailiaoCb ys : request.getYss()) {
					ys.setOid(null);
					BeanValidation bv = new BeanValidation(queryFactory);
					bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
					bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
					bv.vali(BeanValidation.beanType.cailiao, BeanValidation.valiType.all, ys.getCailiaoOid());
					Preconditions.checkArgument(ys.getGlobalGclYsOid() > 0, "工程量ID不能为空!");
					Preconditions.checkArgument(queryFactory.exists(QCbhsGclQdYs.cbhsGclQdYs, QCbhsGclQdYs.cbhsGclQdYs.oid.eq(ys.getGlobalGclYsOid())), "工程量项目不存在!");
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
					// 监测是否超出总预算
					String ext = null;
					try {
						DataSummaryObj dsObj = new DataSummaryObj();
						dsObj.setProjectOid(ys.getProjectOid());
						dsObj.setDeptOids(Lists.newArrayList(ys.getDeptOid()));
						dsObj.setDt(new DateObj(System.currentTimeMillis(), DateObj.type_month));
						dsObj.setGlobalGclOids(Lists.newArrayList(ys.getGlobalGclYsOid()));
						DataSummaryUtils.checkZyCailiaoCbIsExceed(queryFactory, dsObj, Lists.newArrayList(ys));
					} catch (ExceedException e) {
						ext = JSON.toJSONString(e.getInfo().getExceedInfos());
						ys.setShStatus(1);
						exception = e;
					}
					ys = queryFactory.saveOrUpdate(ys);
					if (ys.getShStatus() == 1) {
						examinerManager.createExaminer(queryFactory, ys.getProjectOid(), SheObject.shType_zycailiaocb, ys.getOid(), ys.getDeptOid(), ys.getDeptName(), ext, exception.getInfo().getErrorMessage(), exception.getInfo().getErrorMessage(), TokenUtils.getTokenInfo(httpServletRequest).getUserOid(), TokenUtils.getTokenInfo(httpServletRequest).getUserName());
					} else {
						CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
						cb.setOid(null);
						cb.setType(SheObject.shType_zycailiaocb);
						cb.setCbOid(ys.getOid());
						cbSrManager.createCb(queryFactory, cb);
					}
				}
			}
		}
		ResponseZyCailiaoCbAdd response = new ResponseZyCailiaoCbAdd();
		response.setYss(request.getYss());
		return response;
	}

	@Override
	public ResponseFbGclTjCbFetch fbGclTjCbFetch(RequestFbGclTjCbFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsDaysFbGclTj query_ = QCbhsDaysFbGclTj.cbhsDaysFbGclTj;
		// 查询对象
		MyJPAQuery<CbhsDaysFbGclTj> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getDaysStart(), query_.dateTimeStamp.goe(request.getDaysStart()));
		if (request.getDaysEnd() != null && request.getDaysEnd() > 0) {
			DateTime dt = new DateTime(request.getDaysEnd());
			dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59, 59, 999);
			request.setDaysEnd(dt.getMillis());
		}
		jpaquery.where(request.getDaysEnd(), query_.dateTimeStamp.loe(request.getDaysEnd()));
		jpaquery.where(request.getFbGclYsOid(), query_.fbGclYsOid.eq(request.getFbGclYsOid()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		jpaquery.where(request.getHtID(), query_.htOid.eq(request.getHtID()));
		jpaquery.where(request.getHtName(), query_.htName.containsIgnoreCase(request.getHtName()));
		jpaquery.where(request.getFbCompanyOid(), query_.fbCompanyOid.eq(request.getFbCompanyOid()));
		jpaquery.where(request.getFbCompanyName(), query_.fbCompanyName.containsIgnoreCase(request.getFbCompanyName()));
		jpaquery.where(request.getFbGclYsName(), query_.fbGclYsName.containsIgnoreCase(request.getFbGclYsName()));
		if (request.getShStatus() != null && request.getShStatus() > 0) {
			if (request.getShStatus() == 1) {
				jpaquery.where(query_.shStatus.eq(0));
			}
		}
		// 查询总数
		ResponseFbGclTjCbFetch response = new ResponseFbGclTjCbFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsDaysFbGclTj fbGclTjCbUpdate(CbhsDaysFbGclTj ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "分包工程量统计ID不能为空!");
		ys.setTotal(new BigDecimal(0));
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, ys.getFbCompanyOid());
		Preconditions.checkArgument(ys.getFbGclYsOid() > 0, "分包工程量ID不能为空!");
		Preconditions.checkArgument(queryFactory.exists(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs, QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.oid.eq(ys.getFbGclYsOid())), "分包工程量项目不存在!");
		ys = queryFactory.saveOrUpdate(ys);
		cbSrManager.updateCb(queryFactory, SheObject.shType_fbgcl, ys.getOid(), ys.getTotal());

		return ys;
	}

	@Override
	public JSONObject fbGclTjCbDel(RequestFbGclTjCbDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "分包工程量统计ID不能为空!");
		queryFactory.delete(QCbhsDaysFbGclTj.cbhsDaysFbGclTj).where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.oid.in(request.getOids())).execute();
		cbSrManager.delCb(queryFactory, SheObject.shType_fbgcl, request.getOids());
		cbSrManager.delCb(queryFactory, SheObject.shType_fbgcljg, request.getOids());
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsDaysFbGclTj fbGclTjCbAdd(RequestFbGclTjCbAdd request, HttpServletRequest httpServletRequest) throws Exception {
		CbhsDaysFbGclTj ys = request.getCb();
		ys.setTotal(new BigDecimal(0));
		Preconditions.checkArgument(ys.getFbGclYsOid() > 0, "分包工程量ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, ys.getFbCompanyOid());
		bv.vali(BeanValidation.beanType.ht, BeanValidation.valiType.all, ys.getHtOid());
		Preconditions.checkArgument(queryFactory.exists(QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs, QCbhsMonthFbGcCbYs.cbhsMonthFbGcCbYs.oid.eq(ys.getFbGclYsOid())), "分包工程量项目不存在!");
		ys.setShStatus(0);
		// 监测是否超出总预算
		long time = ys.getDateTimeStamp() > 0 ? ys.getDateTimeStamp() : System.currentTimeMillis();
		RequestMbYsFetch r1 = new RequestMbYsFetch();
		r1.setProjectOid(ys.getProjectOid());
		r1.setDeptOid(ys.getDeptOid());
		r1.setMonth(new SimpleDateFormat("yyyy-MM-01").parse(new SimpleDateFormat("yyyy-MM-01").format(new Date(time))).getTime());
		try {
			List<Integer> globalGclOids = Lists.newArrayList();
			globalGclOids.add(ys.getFbGclYsOid());
			DataSummaryUtils.checkFbGclIsExceed(queryFactory, r1, ys, globalGclOids);
		} catch (ExceedException e) {
			throw new ServiceException(new ExceptionResponse(-1, ys.getFbGclYsName() + "已超出本月预算总量" + e.getInfo().getExceedInfos().get(0).getValue().abs() + e.getInfo().getExceedInfos().get(0).getUnit()));
		}
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
		ys = queryFactory.saveOrUpdate(ys);
		// if (ys.getShStatus() == 1) { // 审核提交 需要向审核者发送推送消息
		// examinerManager.createExaminer(queryFactory, ys.getProjectOid(),
		// SheObject.shType_fbgcl, ys.getOid(), ys.getDeptOid(),
		// ys.getDeptName(), ext, exception.getInfo().getErrorMessage(),
		// exception.getInfo().getErrorMessage(),
		// TokenUtils.getTokenInfo(httpServletRequest).getUserOid(),
		// TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		// }
		return ys;
	}

	@Override
	public ResponseFbLjxmCbFetch fbLjxmCbFetch(RequestFbLjxmCbFetch request, HttpServletRequest httpServletRequest) throws Exception {
		// TODO Auto-generated method stub
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsDaysFbLjxmCb query_ = QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb;
		// 查询对象
		MyJPAQuery<CbhsDaysFbLjxmCb> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getDaysStart(), query_.dateTimeStamp.goe(request.getDaysStart()));
		if (request.getDaysEnd() != null && request.getDaysEnd() > 0) {
			DateTime dt = new DateTime(request.getDaysEnd());
			dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59, 59, 999);
			request.setDaysEnd(dt.getMillis());
		}
		jpaquery.where(request.getDaysEnd(), query_.dateTimeStamp.loe(request.getDaysEnd()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseFbLjxmCbFetch response = new ResponseFbLjxmCbFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsDaysFbLjxmCb fbLjxmCbUpdate(CbhsDaysFbLjxmCb ys, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(ys.getOid() > 0, "分包零星用工ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, ys.getFbCompanyOid());
		ys = queryFactory.saveOrUpdate(ys);
		cbSrManager.updateCb(queryFactory, SheObject.shType_fbljxm, ys.getOid(), ys.getTotal());

		return ys;
	}

	@Override
	public JSONObject fbLjxmCbDel(RequestFbLjxmCbDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "分包工程量统计ID不能为空!");
		queryFactory.delete(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb).where(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.oid.in(request.getOids())).execute();
		cbSrManager.delCb(queryFactory, SheObject.shType_fbljxm, request.getOids());
		cbSrManager.delCb(queryFactory, SheObject.shType_fbljxmcount, request.getOids());
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsDaysFbLjxmCb fbLjxmCbAddCount(RequestFbLjxmCbAddCount request, HttpServletRequest httpServletRequest) throws Exception {
		CbhsDaysFbLjxmCb ys = request.getCb();
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, ys.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, ys.getDeptOid());
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, ys.getFbCompanyOid());
		Preconditions.checkArgument(request.getCb().getLjxmYsOid() > 0, "临建项目ID不能为空!");
		Preconditions.checkArgument(queryFactory.exists(QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs, QCbhsMonthFbLjxmCbYs.cbhsMonthFbLjxmCbYs.oid.eq(request.getCb().getLjxmYsOid())), "临建项目不存在!");
		ys.setShStatus(0);
		String ext = null;
		ExceedException exception = null;
		ys.setUnitPrice(BigDecimal.ZERO);
		ys.setTotal(BigDecimal.ZERO);
		long time = ys.getDateTimeStamp() > 0 ? ys.getDateTimeStamp() : System.currentTimeMillis();
		try {
			RequestMbYsFetch r1 = new RequestMbYsFetch();
			r1.setProjectOid(ys.getProjectOid());
			r1.setDeptOid(ys.getDeptOid());
			r1.setMonth(new SimpleDateFormat("yyyy-MM-01").parse(new SimpleDateFormat("yyyy-MM-01").format(new Date(time))).getTime());
			DataSummaryUtils.checkFbLjxmCbCountIsExceed(queryFactory, r1, ys);
		} catch (ExceedException e) {
			if (request.getSubmitType() == 0) { // 默认提交
				throw e;
			} else {
				ext = JSON.toJSONString(e.getInfo().getExceedInfos());
				ys.setShStatus(1);
				exception = e;
			}
		}
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
		ys = queryFactory.saveOrUpdate(ys);
		if (ys.getShStatus() == 1) { // 审核提交 需要向审核者发送推送消息
			examinerManager.createExaminer(queryFactory, ys.getProjectOid(), SheObject.shType_fbljxmcount, ys.getOid(), ys.getDeptOid(), ys.getDeptName(), ext, exception.getInfo().getErrorMessage(), exception.getInfo().getErrorMessage(), TokenUtils.getTokenInfo(httpServletRequest).getUserOid(), TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		} else {
			CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
			cb.setOid(null);
			cb.setType(SheObject.shType_fbljxmcount);
			cb.setCbOid(ys.getOid());
			cbSrManager.createCb(queryFactory, cb);
		}
		return ys;
	}

	@Override
	public CbhsDaysGlfyYs todayFetch(RequestTodayFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		CbhsGlfyRule rule = queryFactory.selectFrom(QCbhsGlfyRule.cbhsGlfyRule).where(QCbhsGlfyRule.cbhsGlfyRule.projectOid.eq(request.getProjectOid())).fetchFirst();
		Preconditions.checkArgument(rule != null, "未配置管理费用上缴公式!");
		DateTime dt = new DateTime(System.currentTimeMillis());
		String dateStr = dt.toString("yyyy-MM-dd");
		BigDecimal gcSrTotal = queryFactory.select(QCbhsDaysGclSr.cbhsDaysGclSr.total.sum()).from(QCbhsDaysGclSr.cbhsDaysGclSr).where(QCbhsDaysGclSr.cbhsDaysGclSr.projectOid.eq(request.getProjectOid()).and(QCbhsDaysGclSr.cbhsDaysGclSr.dateStr.eq(dateStr))).fetchFirst();
		gcSrTotal = gcSrTotal == null ? new BigDecimal(0) : gcSrTotal;
		BigDecimal qtSrTotal = queryFactory.select(QCbhsDaysQtSr.cbhsDaysQtSr.total.sum()).from(QCbhsDaysQtSr.cbhsDaysQtSr).where(QCbhsDaysQtSr.cbhsDaysQtSr.projectOid.eq(request.getProjectOid()).and(QCbhsDaysQtSr.cbhsDaysQtSr.dateStr.eq(dateStr))).fetchFirst();
		qtSrTotal = qtSrTotal == null ? new BigDecimal(0) : qtSrTotal;
		BigDecimal todayTotal = gcSrTotal.add(qtSrTotal);
		CbhsDaysGlfyYs ys = new CbhsDaysGlfyYs();
		ys.setP_sjgs(todayTotal.multiply(rule.getP_sjgs_rule().divide(new BigDecimal(100))));
		ys.setP_ztbfy(todayTotal.multiply(rule.getP_ztbfy_rule().divide(new BigDecimal(100))));
		ys.setP_kdqqysds(todayTotal.multiply(rule.getP_kdqqysds_rule().divide(new BigDecimal(100))));
		ys.setP_yhsjqtsj(todayTotal.multiply(rule.getP_yhsjqtsj_rule().divide(new BigDecimal(100))));
		return ys;
	}

	@Override
	public JSONObject fbJgUpdate(RequestFbJgUpdate request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getFbGclOid() > 0, "分包价格统计ID不能为空!");
		queryFactory.update(QCbhsDaysFbGclTj.cbhsDaysFbGclTj).set(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.total, request.getFbPrice()).set(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.unitPrice, request.getFbUnitPrice()).where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.oid.eq(request.getFbGclOid())).execute();
		cbSrManager.updateCb(queryFactory, SheObject.shType_fbgcljg, request.getFbGclOid(), request.getFbPrice());
		return CbhsResUtils.suc();
	}

	@Override
	public CbhsDaysFbGclTj fbJgAdd(RequestFbJgAdd request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getFbGclOid() > 0, "分包价格统计ID不能为空!");
		CbhsDaysFbGclTj gclTj = queryFactory.findOne(CbhsDaysFbGclTj.class, request.getFbGclOid());
		Preconditions.checkArgument(gclTj != null, "分包工程量不存在!");
		Preconditions.checkArgument(gclTj.getShStatus() == 0, "分包工程量正在审核中!");
		// 监测是否超出总预算
		String ext = null;
		RequestMbYsFetch r1 = new RequestMbYsFetch();
		r1.setProjectOid(gclTj.getProjectOid());
		r1.setDeptOid(gclTj.getDeptOid());
		r1.setMonth(new SimpleDateFormat("yyyy-MM-01").parse(new SimpleDateFormat("yyyy-MM-01").format(new Date(gclTj.getDateTimeStamp()))).getTime());
		ExceedException exception = null;
		gclTj.setTotal(request.getFbPrice());
		gclTj.setUnitPrice(request.getFbUnitPrice());
		try {
			DataSummaryUtils.checkFbGclPriceIsExceed(queryFactory, r1, gclTj, Lists.newArrayList(gclTj.getFbGclYsOid()));
		} catch (ExceedException e) {
			if (request.getSubmitType() == 0) { // 默认提交
				throw e;
			} else {
				ext = JSON.toJSONString(e.getInfo().getExceedInfos());
				gclTj.setShStatus(1);
				exception = e;
			}
		}
		gclTj = queryFactory.saveOrUpdate(gclTj);
		if (gclTj.getShStatus() == 1) { // 审核提交 需要向审核者发送推送消息
			queryFactory.update(QCbhsDaysFbGclTj.cbhsDaysFbGclTj).set(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.shStatus, 1).where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.oid.eq(gclTj.getOid())).execute();
			examinerManager.createExaminer(queryFactory, gclTj.getProjectOid(), SheObject.shType_fbgcljg, gclTj.getOid(), gclTj.getDeptOid(), gclTj.getDeptName(), ext, exception.getInfo().getErrorMessage(), exception.getInfo().getErrorMessage(), TokenUtils.getTokenInfo(httpServletRequest).getUserOid(), TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		} else {
			CbhsCb cb = JSON.parseObject(JSON.toJSONString(gclTj), CbhsCb.class);
			cb.setOid(null);
			cb.setType(SheObject.shType_fbgcljg);
			cb.setCbOid(gclTj.getOid());
			cbSrManager.createCb(queryFactory, cb);
		}
		return gclTj;
	}

	@Override
	public CbhsDaysFbLjxmCb fbLjxmCbAddJg(RequestFbLjxmCbAddJg request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getDaysFbLjxmCbOid() > 0, "临建项目订单ID不能为空!");
		CbhsDaysFbLjxmCb ljxm = queryFactory.findOne(CbhsDaysFbLjxmCb.class, request.getDaysFbLjxmCbOid());
		Preconditions.checkArgument(ljxm != null, "临建项目订单不存在!");
		Preconditions.checkArgument(ljxm.getShStatus() == 0, "临建项目订单数量正在审核中!");
		// 监测是否超出总预算
		String ext = null;
		RequestMbYsFetch r1 = new RequestMbYsFetch();
		r1.setProjectOid(ljxm.getProjectOid());
		r1.setDeptOid(ljxm.getDeptOid());
		r1.setMonth(new SimpleDateFormat("yyyy-MM-01").parse(new SimpleDateFormat("yyyy-MM-01").format(new Date(ljxm.getDateTimeStamp()))).getTime());
		ExceedException exception = null;
		ljxm.setTotal(request.getFbPrice());
		ljxm.setUnitPrice(request.getFbUnitPrice());
		try {
			DataSummaryUtils.checkFbLjxmCbIsExceed(queryFactory, r1, ljxm);
		} catch (ExceedException e) {
			if (request.getSubmitType() == 0) { // 默认提交
				throw e;
			} else {
				ext = JSON.toJSONString(e.getInfo().getExceedInfos());
				ljxm.setShStatus(1);
				exception = e;
			}
		}
		ljxm = queryFactory.saveOrUpdate(ljxm);
		if (ljxm.getShStatus() == 1) { // 审核提交 需要向审核者发送推送消息
			queryFactory.update(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb).set(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.shStatus, 1).where(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.oid.eq(ljxm.getOid())).execute();
			examinerManager.createExaminer(queryFactory, ljxm.getProjectOid(), SheObject.shType_fbljxmcount, ljxm.getOid(), ljxm.getDeptOid(), ljxm.getDeptName(), ext, exception.getInfo().getErrorMessage(), exception.getInfo().getErrorMessage(), TokenUtils.getTokenInfo(httpServletRequest).getUserOid(), TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		} else {
			CbhsCb cb = JSON.parseObject(JSON.toJSONString(ljxm), CbhsCb.class);
			cb.setOid(null);
			cb.setType(SheObject.shType_fbljxmcount);
			cb.setCbOid(ljxm.getOid());
			cbSrManager.createCb(queryFactory, cb);
		}
		return ljxm;
	}

	@Override
	public JSONObject fbLjxmCbUpdateJg(RequestFbLjxmCbUpdateJg request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getDaysFbLjxmCbOid() > 0, "临建项目ID不能为空!");
		queryFactory.update(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb).set(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.total, request.getFbPrice()).set(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.unitPrice, request.getFbUnitPrice()).where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.oid.eq(request.getDaysFbLjxmCbOid())).execute();
		cbSrManager.updateCb(queryFactory, SheObject.shType_fbljxm, request.getDaysFbLjxmCbOid(), request.getFbPrice());
		return CbhsResUtils.suc();
	}
}
