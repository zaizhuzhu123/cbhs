package com.server.handler.imp;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Preconditions;
import com.querydsl.jpa.JPAExpressions;
import com.server.common.BeanValidation;
import com.server.common.CbhsResUtils;
import com.server.common.SheObject;
import com.server.common.TokenUtils;
import com.server.exception.ExceptionResponse;
import com.server.exception.ServiceException;
import com.server.handler.CbsheApisService;
import com.server.jpa.MyJPAQuery;
import com.server.jpa.MyJPAQuery.PagerResult;
import com.server.jpa.MyQueryFactory;
import com.server.manager.ExaminerManager;
import com.server.pojo.bean.CbhsCbExaminer;
import com.server.pojo.bean.CbhsCbExaminerRule;
import com.server.pojo.bean.CbhsCbExaminerStep;
import com.server.pojo.bean.QCbhsCbExaminer;
import com.server.pojo.bean.QCbhsCbExaminerRule;
import com.server.pojo.bean.QCbhsCbExaminerStep;
import com.server.pojo.bean.QCbhsReim;
import com.server.pojo.url.cbshe.RequestCancelExam;
import com.server.pojo.url.cbshe.RequestExamCb;
import com.server.pojo.url.cbshe.RequestExamMyCreateTaskFetch;
import com.server.pojo.url.cbshe.RequestExamTaskFetch;
import com.server.pojo.url.cbshe.RequestExamTaskStepFetch;
import com.server.pojo.url.cbshe.RequestExaminerRuleDel;
import com.server.pojo.url.cbshe.RequestExaminerRuleFetch;
import com.server.pojo.url.cbshe.ResponseExamMyCreateTaskFetch;
import com.server.pojo.url.cbshe.ResponseExamTaskFetch;
import com.server.pojo.url.cbshe.ResponseExamTaskStepFetch;
import com.server.pojo.url.cbshe.ResponseExaminerRuleFetch;

@SuppressWarnings({ "rawtypes", "unchecked" })
@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class CbsheApisServiceImp implements CbsheApisService {

	@Autowired
	private MyQueryFactory queryFactory;

	@Autowired
	private ExaminerManager examinerManager;

	@Override
	public CbhsCbExaminerRule examinerRuleAdd(CbhsCbExaminerRule request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getDeptOid() > 0, "部门ID不能为空!");
		Preconditions.checkArgument(request.getPersonOid1() > 0, "审核人1不能为空!");
		Preconditions.checkArgument(request.getPersonOid2() > 0, "审核人2不能为空!");
		BeanValidation bv = new BeanValidation(queryFactory);
		bv.vali(BeanValidation.beanType.project, BeanValidation.valiType.all, request.getProjectOid());
		bv.vali(BeanValidation.beanType.dept, BeanValidation.valiType.all, request.getDeptOid());
		Preconditions.checkArgument(!queryFactory.exists(QCbhsCbExaminerRule.cbhsCbExaminerRule, QCbhsCbExaminerRule.cbhsCbExaminerRule.deptOid.eq(request.getDeptOid())), "该部门已配置过审核信息!");
		long time = System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		request.setOpUserOid(TokenUtils.getTokenInfo(httpServletRequest).getUserOid());
		request.setOpUserName(TokenUtils.getTokenInfo(httpServletRequest).getUserName());
		request.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		request.setOpTime(time);
		queryFactory.saveOrUpdate(request);
		return request;
	}

	@Override
	public CbhsCbExaminerRule examinerRuleUpdate(CbhsCbExaminerRule rule, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(rule.getOid() > 0, "规则ID不能为空!");
		rule = queryFactory.saveOrUpdate(rule);
		return rule;
	}

	@Override
	public JSONObject examinerRuleDel(RequestExaminerRuleDel request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getOids().size() > 0, "需要删除的规则ID不能为空!");
		queryFactory.delete(QCbhsCbExaminerRule.cbhsCbExaminerRule).where(QCbhsCbExaminerRule.cbhsCbExaminerRule.oid.in(request.getOids())).execute();
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseExaminerRuleFetch examinerRuleFetch(RequestExaminerRuleFetch request, HttpServletRequest httpServletRequest) throws Exception {
		QCbhsCbExaminerRule query_ = QCbhsCbExaminerRule.cbhsCbExaminerRule;
		// 查询对象
		MyJPAQuery<CbhsCbExaminerRule> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getDeptOid(), query_.deptOid.eq(request.getDeptOid()));
		jpaquery.where(request.getPersonOid(), query_.personOid1.eq(request.getPersonOid()).or(query_.personOid2.eq(request.getPersonOid())));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		jpaquery.orderBy(query_.oid.desc());
		// 查询总数
		ResponseExaminerRuleFetch response = new ResponseExaminerRuleFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	public JSONObject examCb(RequestExamCb request, HttpServletRequest httpServletRequest) throws Exception {
		CbhsCbExaminer task = queryFactory.selectFrom(QCbhsCbExaminer.cbhsCbExaminer).where(QCbhsCbExaminer.cbhsCbExaminer.oid.eq(request.getExamOid())).fetchFirst();
		Preconditions.checkArgument(task != null, "未找到审核请求");
		CbhsCbExaminerStep step = queryFactory.selectFrom(QCbhsCbExaminerStep.cbhsCbExaminerStep)
				.where(QCbhsCbExaminerStep.cbhsCbExaminerStep.taskOid.eq(task.getOid()).and(QCbhsCbExaminerStep.cbhsCbExaminerStep.shorder.eq(task.getShorder()))).fetchFirst();
		Preconditions.checkArgument(step != null, "未找到审核请求");
		Preconditions.checkArgument(task.getCompleteState() == 1, "请求已结束");
		if (step.getShPersonOid() != TokenUtils.getTokenInfo(httpServletRequest).getUserOid()) {
			throw new ServiceException(new ExceptionResponse(-1, "你不是当前审核人，不能审核"));
		}
		Preconditions.checkArgument(step.getStepStatus() == 2, "已审核");
		step.setRemark(request.getRemark());
		if (request.getShStatus() == 1) { // 批准
			step.setStepStatus(3);
			// 兼容财务三级审核
			if (task.getType() == SheObject.shType_reim) {
				if (step.getShorder() == 1) { // 部门主管批准同意
					queryFactory.update(QCbhsReim.cbhsReim).set(QCbhsReim.cbhsReim.process, 1).where(QCbhsReim.cbhsReim.oid.eq(task.getCbOid())).execute();
				} else if (step.getShorder() == 1) { // 项目经理批准同意
					queryFactory.update(QCbhsReim.cbhsReim).set(QCbhsReim.cbhsReim.process, 3).where(QCbhsReim.cbhsReim.oid.eq(task.getCbOid())).execute();
				}
			}
		} else {
			step.setStepStatus(4);
			queryFactory.update(QCbhsReim.cbhsReim).set(QCbhsReim.cbhsReim.process, 3).where(QCbhsReim.cbhsReim.oid.eq(task.getCbOid())).execute();
		}
		long time = System.currentTimeMillis();
		DateTime dt = new DateTime(time);
		step.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		step.setOpTime(time);
		queryFactory.saveOrUpdate(step);
		examinerManager.nextExaminer(queryFactory, step.getTaskOid(), step.getStepStatus());
		return CbhsResUtils.suc();
	}

	@Override
	public ResponseExamTaskFetch examTaskFetch(RequestExamTaskFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsCbExaminer query_ = QCbhsCbExaminer.cbhsCbExaminer;
		// 查询对象
		MyJPAQuery<CbhsCbExaminer> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getOid(), query_.oid.eq(request.getOid()));
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(request.getStartOid(), query_.oid.gt(request.getStartOid()));
		Integer personOid = TokenUtils.getTokenInfo(httpServletRequest).getUserOid();
		if (request.getType() == 1) {
			// 轮到用户自己审核的
			jpaquery.where(query_.oid.in(JPAExpressions.select(QCbhsCbExaminerStep.cbhsCbExaminerStep.taskOid).from(QCbhsCbExaminerStep.cbhsCbExaminerStep)
					.where(QCbhsCbExaminerStep.cbhsCbExaminerStep.shPersonOid.eq(personOid).and(QCbhsCbExaminerStep.cbhsCbExaminerStep.stepStatus.eq(2)))));
		} else if (request.getType() == 2) {
			// 审核完成的
			jpaquery.where(query_.oid.in(
					JPAExpressions.select(QCbhsCbExaminerStep.cbhsCbExaminerStep.taskOid).from(QCbhsCbExaminerStep.cbhsCbExaminerStep)
							.where(QCbhsCbExaminerStep.cbhsCbExaminerStep.shPersonOid.eq(personOid))).and(query_.completeState.goe(2)));
		} else {
			// 用户所有参与的审核
			jpaquery.where(query_.oid.in(JPAExpressions.select(QCbhsCbExaminerStep.cbhsCbExaminerStep.taskOid).from(QCbhsCbExaminerStep.cbhsCbExaminerStep)
					.where(QCbhsCbExaminerStep.cbhsCbExaminerStep.shPersonOid.eq(personOid))));
		}
		// 查询总数
		ResponseExamTaskFetch response = new ResponseExamTaskFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	public ResponseExamTaskStepFetch examTaskStepFetch(RequestExamTaskStepFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getExamOid() > 0, "审核请求ID不能为空!");
		QCbhsCbExaminerStep query_ = QCbhsCbExaminerStep.cbhsCbExaminerStep;
		// 查询对象
		MyJPAQuery<CbhsCbExaminerStep> jpaquery = queryFactory.selectFrom(query_);
		jpaquery.where(query_.taskOid.eq(request.getExamOid()));
		// 查询总数
		ResponseExamTaskStepFetch response = new ResponseExamTaskStepFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	public ResponseExamMyCreateTaskFetch examMyCreateTaskFetch(RequestExamMyCreateTaskFetch request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		QCbhsCbExaminer query_ = QCbhsCbExaminer.cbhsCbExaminer;
		// 查询对象
		MyJPAQuery<CbhsCbExaminer> jpaquery = queryFactory.selectFrom(query_);
		// 条件组合
		jpaquery.where(request.getProjectOid(), query_.projectOid.eq(request.getProjectOid()));
		jpaquery.where(query_.personOid.eq(TokenUtils.getTokenInfo(httpServletRequest).getUserOid()));
		// 查询总数
		ResponseExamMyCreateTaskFetch response = new ResponseExamMyCreateTaskFetch();
		PagerResult pr = jpaquery.fetchPager(request.getPageNum(), request.getPageSize());
		response.setTotal(pr.getTotal());
		response.setResult(pr.getResult());
		return response;
	}

	@Override
	public JSONObject cancelExam(RequestCancelExam request, HttpServletRequest httpServletRequest) throws Exception {
		CbhsCbExaminer task = queryFactory.selectFrom(QCbhsCbExaminer.cbhsCbExaminer).where(QCbhsCbExaminer.cbhsCbExaminer.oid.eq(request.getExamOid())).fetchFirst();
		Preconditions.checkArgument(task != null, "未找到审核请求");
		Preconditions.checkArgument(task.getCompleteState() == 1, "请求已结束");
		if (task.getPersonOid() != TokenUtils.getTokenInfo(httpServletRequest).getUserOid()) {
			throw new ServiceException(new ExceptionResponse(-1, "你不是请求发起人，不能撤销"));
		}
		task.setCompleteState(4);
		queryFactory.saveOrUpdate(task);
		return CbhsResUtils.suc();
	}

}
