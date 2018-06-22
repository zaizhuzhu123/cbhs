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
import com.server.common.BeanValidation;
import com.server.common.CbhsResUtils;
import com.server.common.DateObj;
import com.server.common.SheObject;
import com.server.common.TokenUtils;
import com.server.exception.ExceedException;
import com.server.exception.ExceptionResponse;
import com.server.exception.ServiceException;
import com.server.handler.CwApisService;
import com.server.jpa.MyJPAQuery;
import com.server.jpa.MyJPAQuery.PagerResult;
import com.server.jpa.MyQueryFactory;
import com.server.manager.ExaminerManager;
import com.server.pojo.bean.CbhsCbExaminer;
import com.server.pojo.bean.CbhsCbExaminerStep;
import com.server.pojo.bean.CbhsGclQdYs;
import com.server.pojo.bean.CbhsReim;
import com.server.pojo.bean.CbhsReimTerm;
import com.server.pojo.bean.CbhsSettleDown;
import com.server.pojo.bean.CbhsSettleUp;
import com.server.pojo.bean.QCbhsCbExaminer;
import com.server.pojo.bean.QCbhsCbExaminerStep;
import com.server.pojo.bean.QCbhsReim;
import com.server.pojo.bean.QCbhsSettleDown;
import com.server.pojo.bean.QCbhsSettleUp;
import com.server.pojo.bean.uiExceedInfo;
import com.server.pojo.url.cw.RequestReimDel;
import com.server.pojo.url.cw.RequestReimFetch;
import com.server.pojo.url.cw.RequestReimShe;
import com.server.pojo.url.cw.RequestSettlementDownAdd;
import com.server.pojo.url.cw.RequestSettlementDownDel;
import com.server.pojo.url.cw.RequestSettlementDownFetch;
import com.server.pojo.url.cw.RequestSettlementUpDel;
import com.server.pojo.url.cw.RequestSettlementUpFetch;
import com.server.pojo.url.cw.ResponseReimFetch;
import com.server.pojo.url.cw.ResponseSettlementDownFetch;
import com.server.pojo.url.cw.ResponseSettlementUpFetch;

@SuppressWarnings({ "unchecked", "rawtypes" })
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class CwApisServiceImp implements CwApisService {

	@Autowired
	private MyQueryFactory queryFactory;

	@Autowired
	private ExaminerManager examinerManager;

	@Override
	public CbhsSettleUp settlementUpAdd(CbhsSettleUp request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getGlobalGclYsOid() > 0, "总工程量清单ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, request.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, request.getDeptOid());
		synchronized (this) {
			CbhsGclQdYs gclQdYs = queryFactory.findOne(CbhsGclQdYs.class, request.getGlobalGclYsOid());
			Preconditions.checkArgument(gclQdYs != null, "总工程量清单不存在!");
			QCbhsSettleUp query_ = QCbhsSettleUp.cbhsSettleUp;
			BigDecimal submitCount = queryFactory.select(query_.count.sum()).from(query_).where(query_.globalGclYsOid.eq(request.getGlobalGclYsOid())).fetchFirst();
			submitCount = submitCount != null ? submitCount : BigDecimal.ZERO;
			BigDecimal result = gclQdYs.getCount().subtract(submitCount).subtract(request.getCount());
			if (result.compareTo(BigDecimal.ZERO) < 0) {
				throw new ServiceException(new ExceptionResponse(-1, "工程量超过总预算 " + result.abs().stripTrailingZeros() + gclQdYs.getUnit() + " !"));
			}
			long time = request.getDateTimeStamp() > 0 ? request.getDateTimeStamp() : System.currentTimeMillis();
			DateTime dt = new DateTime(time);
			DateTime curDt = new DateTime(System.currentTimeMillis());
			request.setDateStr(dt.toString("yyyy-MM-dd"));
			request.setDateTimeStamp(time);
			request.setMonthStr(dt.toString("yyyy-MM"));
			request.setMonthTimeStamp(new DateObj(time, DateObj.type_month).getStartTime());
			request.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
			request.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
			request.setOpTimeStr(curDt.toString("yyyy-MM-dd HH:mm:ss"));
			request.setOpTime(curDt.getMillis());
			queryFactory.saveOrUpdate(request);
		}
		return request;
	}

	@Override
	public CbhsSettleUp settlementUpUpdate(CbhsSettleUp request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOid() > 0, "对上结算ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, request.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, request.getDeptOid());
		synchronized (this) {
			CbhsGclQdYs gclQdYs = queryFactory.findOne(CbhsGclQdYs.class, request.getGlobalGclYsOid());
			Preconditions.checkArgument(gclQdYs != null, "总工程量清单不存在!");
			QCbhsSettleUp query_ = QCbhsSettleUp.cbhsSettleUp;
			BigDecimal submitCount = queryFactory.select(query_.count.sum()).from(query_).where(query_.globalGclYsOid.eq(request.getGlobalGclYsOid()).and(query_.oid.ne(request.getOid())))
					.fetchFirst();
			submitCount = submitCount != null ? submitCount : BigDecimal.ZERO;
			BigDecimal result = gclQdYs.getCount().subtract(submitCount).subtract(request.getCount());
			if (result.compareTo(BigDecimal.ZERO) < 0) {
				throw new ServiceException(new ExceptionResponse(-1, "工程量超过总预算 " + result.abs().stripTrailingZeros() + gclQdYs.getUnit() + " !"));
			}
			queryFactory.saveOrUpdate(request);
		}
		return request;
	}

	@Override
	public JSONObject settlementUpDel(RequestSettlementUpDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "对上计算ID不能为空!");
		queryFactory.delete(QCbhsSettleUp.cbhsSettleUp).where(QCbhsSettleUp.cbhsSettleUp.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseSettlementUpFetch settlementUpFetch(RequestSettlementUpFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsSettleUp query_ = QCbhsSettleUp.cbhsSettleUp;
		// 查询对象
		MyJPAQuery<CbhsSettleUp> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getGlobalGclYsOid(), query_.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseSettlementUpFetch response = new ResponseSettlementUpFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsSettleDown settlementDownAdd(RequestSettlementDownAdd request, HttpServletRequest httpServletRequest) throws Exception {
		CbhsSettleDown settle = request.getSettle();
		Preconditions.checkArgument(settle.getGlobalGclYsOid() > 0, "总工程量清单ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, settle.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, settle.getDeptOid());
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, settle.getFbCompanyOid());
		synchronized (this) {
			CbhsSettleUp settleUp = queryFactory.findOne(CbhsSettleUp.class, settle.getCbhsSettleUpOid());
			Preconditions.checkArgument(settleUp != null, "对上结算不存在!");
			QCbhsSettleDown query_ = QCbhsSettleDown.cbhsSettleDown;
			BigDecimal submitCount = queryFactory.select(query_.count.sum()).from(query_).where(query_.cbhsSettleUpOid.eq(settle.getCbhsSettleUpOid())).fetchFirst();
			submitCount = submitCount != null ? submitCount : BigDecimal.ZERO;
			BigDecimal result = settleUp.getCount().subtract(submitCount).subtract(settle.getCount());
			String ext = null;
			ExceedException exception = null;
			long time = settle.getDateTimeStamp() > 0 ? settle.getDateTimeStamp() : System.currentTimeMillis();
			DateTime dt = new DateTime(time);
			DateTime curDt = new DateTime(System.currentTimeMillis());
			settle.setDateStr(dt.toString("yyyy-MM-dd"));
			settle.setDateTimeStamp(time);
			settle.setMonthStr(dt.toString("yyyy-MM"));
			settle.setMonthTimeStamp(new DateObj(time, DateObj.type_month).getStartTime());
			settle.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
			settle.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
			settle.setOpTimeStr(curDt.toString("yyyy-MM-dd HH:mm:ss"));
			settle.setOpTime(curDt.getMillis());
			if (result.compareTo(BigDecimal.ZERO) < 0) {
				List<uiExceedInfo> exceedInfos = Lists.newArrayList();
				uiExceedInfo uei = new uiExceedInfo();
				uei.setName("对下结算");
				uei.setValue(result);
				exceedInfos.add(uei);
				exception = new ExceedException("对下结算", exceedInfos);
				ext = JSON.toJSONString(exceedInfos);
				if (request.getSubmitType() == 0) {
					throw exception;
				} else {
					// 创建审核
					settle.setShStatus(1);
					settle = queryFactory.saveOrUpdate(settle);
					examinerManager.createExaminer(queryFactory, settle.getProjectOid(), SheObject.shType_ssd, settle.getOid(), settle.getDeptOid(), settle.getDeptName(), ext, exception.getInfo()
							.getErrorMessage(), exception.getInfo().getErrorMessage(), TokenUtils.getTokenInfo(httpServletRequest).getUserOid(), TokenUtils.getTokenInfo(httpServletRequest)
							.getUserName());
				}
			} else {
				queryFactory.saveOrUpdate(settle);
			}
		}
		return settle;
	}

	@Override
	public CbhsSettleDown settlementDownUpdate(CbhsSettleDown request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOid() > 0, "对下结算ID不能为空!");
		Preconditions.checkArgument(request.getGlobalGclYsOid() > 0, "总工程量清单ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, request.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, request.getDeptOid());
		bv.vali(BeanValidation.beanType.fbCompany, BeanValidation.valiType.all, request.getFbCompanyOid());
		synchronized (this) {
			CbhsSettleUp settleUp = queryFactory.findOne(CbhsSettleUp.class, request.getCbhsSettleUpOid());
			Preconditions.checkArgument(settleUp != null, "对上结算不存在!");
			queryFactory.saveOrUpdate(request);
		}
		return null;
	}

	@Override
	public JSONObject settlementDownDel(RequestSettlementDownDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "对下计算ID不能为空!");
		queryFactory.delete(QCbhsSettleDown.cbhsSettleDown).where(QCbhsSettleDown.cbhsSettleDown.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseSettlementDownFetch settlementDownFetch(RequestSettlementDownFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsSettleDown query_ = QCbhsSettleDown.cbhsSettleDown;
		// 查询对象
		MyJPAQuery<CbhsSettleDown> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getGlobalGclYsOid(), query_.globalGclYsOid.eq(request.getGlobalGclYsOid()));
		jpaquery.where(request.getCbhsSettleUpOid(), query_.cbhsSettleUpOid.eq(request.getCbhsSettleUpOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		// 查询总数
		ResponseSettlementDownFetch response = new ResponseSettlementDownFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public CbhsReim reimAdd(CbhsReim reim, HttpServletRequest httpServletRequest) throws Exception {
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, reim.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, reim.getDeptOid());
		long time = reim.getDateTimeStamp() > 0 ? reim.getDateTimeStamp() : System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		DateTime curDt = new DateTime(System.currentTimeMillis());
		reim.setDateStr(dt.toString("yyyy-MM-dd"));
		reim.setDateTimeStamp(time);
		reim.setMonthStr(dt.toString("yyyy-MM"));
		reim.setMonthTimeStamp(new DateObj(time, DateObj.type_month).getStartTime());
		reim.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		reim.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		reim.setOpTimeStr(curDt.toString("yyyy-MM-dd HH:mm:ss"));
		reim.setOpTime(curDt.getMillis());
		reim.setOrderOid(curDt.toString("YYYYMMddHHmmssSSS") + (1000 + (int) (9000 * Math.random())));
		// 创建审核
		reim.setShStatus(1);
		reim = queryFactory.saveOrUpdate(reim);
		examinerManager.createExaminer(queryFactory, reim.getProjectOid(), SheObject.shType_reim, reim.getOid(), reim.getDeptOid(), reim.getDeptName(), "", "财务报销", "财务报销",
				TokenUtils.getTokenInfo(httpServletRequest).getUserOid(), TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		return reim;
	}

	@Override
	public CbhsReim reimUpdate(CbhsReim reim, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(reim.getOid() > 0, "财务报销ID不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, reim.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, reim.getDeptOid());
		for (CbhsReimTerm term : reim.getTerms()) {
			term.setReimOid(term.getOid());
		}
		reim = queryFactory.saveOrUpdate(reim);
		return reim;
	}

	@Override
	public JSONObject reimDel(RequestReimDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "财务报销ID不能为空!");
		queryFactory.batchRemove(CbhsReim.class, request.getOids());
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseReimFetch reimFetch(RequestReimFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsReim query_ = QCbhsReim.cbhsReim;
		// 查询对象
		MyJPAQuery<CbhsReim> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getDeptOid(), query_.projectOid.eq(request.getDeptOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		if (request.getShStatus() != null && request.getShStatus() > 0) {
			switch (request.getShStatus()) {
			case 1:
				jpaquery.where(query_.shStatus.eq(1));
				break;
			case 2:
				jpaquery.where(query_.shStatus.eq(0));
				break;
			}
		}
		jpaquery.where(request.getProcess(), query_.process.eq(request.getProcess()));
		// 查询总数
		ResponseReimFetch response = new ResponseReimFetch();
		PagerResult prResult = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(prResult.getTotal());
		response.setResult(prResult.getResult());
		return response;
	}

	@Override
	public JSONObject reimShe(RequestReimShe request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOid() > 0, "工程项目ID不能为空!");
		if (request.getShStatus() == 1) {
			Preconditions.checkArgument(request.getCwTotal().compareTo(BigDecimal.ZERO) > 0, "批准金额必须大于0!");
		}
		synchronized (this) {
			CbhsReim reim = queryFactory.findOne(CbhsReim.class, request.getOid());
			Preconditions.checkArgument(reim != null, "未找到报销记录!");
			Preconditions.checkArgument(reim.getProcess() == 1, "当前不能进行财务审批!");
			if (request.getShStatus() == 1) {
				reim.setCwTotal(request.getCwTotal());
				reim.setCwPersonName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
				reim.setProcess(2);
				queryFactory.saveOrUpdate(reim);
			} else {
				reim.setCwTotal(request.getCwTotal());
				reim.setCwPersonName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
				reim.setProcess(3);
				queryFactory.saveOrUpdate(reim);
			}
			CbhsCbExaminer task = queryFactory.selectFrom(QCbhsCbExaminer.cbhsCbExaminer)
					.where(QCbhsCbExaminer.cbhsCbExaminer.cbOid.eq(request.getOid()).and(QCbhsCbExaminer.cbhsCbExaminer.type.eq(SheObject.shType_reim))).fetchFirst();
			Preconditions.checkArgument(task != null, "未找到审核请求");
			CbhsCbExaminerStep step = queryFactory.selectFrom(QCbhsCbExaminerStep.cbhsCbExaminerStep)
					.where(QCbhsCbExaminerStep.cbhsCbExaminerStep.taskOid.eq(task.getOid()).and(QCbhsCbExaminerStep.cbhsCbExaminerStep.shorder.eq(task.getShorder()))).fetchFirst();
			Preconditions.checkArgument(step != null, "未找到审核请求");
			Preconditions.checkArgument(task.getCompleteState() == 1, "请求已结束");
			Preconditions.checkArgument(step.getStepStatus() == 2, "已审核");
			step.setShPersonOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
			step.setShPersonName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
			if (request.getShStatus() == 1) {
				step.setStepStatus(3);
			} else {
				step.setStepStatus(4);
			}
			long time = System.currentTimeMillis();
			DateTime dt = new DateTime(time);
			step.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
			step.setOpTime(time);
			queryFactory.saveOrUpdate(step);
			examinerManager.nextExaminer(queryFactory, step.getTaskOid(), step.getStepStatus());
		}

		return CbhsResUtils.suc();
	}

}
