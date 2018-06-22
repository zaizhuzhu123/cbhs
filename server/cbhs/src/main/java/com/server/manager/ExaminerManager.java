package com.server.manager;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.server.common.SheObject;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsCb;
import com.server.pojo.bean.CbhsCbExaminer;
import com.server.pojo.bean.CbhsCbExaminerRule;
import com.server.pojo.bean.CbhsCbExaminerStep;
import com.server.pojo.bean.CbhsDaysFbGclTj;
import com.server.pojo.bean.CbhsDaysFbLjxmCb;
import com.server.pojo.bean.CbhsDaysGlfyYs;
import com.server.pojo.bean.CbhsDaysJjcb;
import com.server.pojo.bean.CbhsDaysZyCailiaoCb;
import com.server.pojo.bean.CbhsDaysZyJxCb;
import com.server.pojo.bean.CbhsDaysZyLxygCb;
import com.server.pojo.bean.CbhsDaysZyQtCb;
import com.server.pojo.bean.CbhsSettleDown;
import com.server.pojo.bean.CbhsUser;
import com.server.pojo.bean.CbhsZytj;
import com.server.pojo.bean.QCbhsCb;
import com.server.pojo.bean.QCbhsCbExaminerRule;
import com.server.pojo.bean.QCbhsCbExaminerStep;
import com.server.pojo.bean.QCbhsDaysFbGclTj;
import com.server.pojo.bean.QCbhsDaysFbLjxmCb;
import com.server.pojo.bean.QCbhsDaysGlfyYs;
import com.server.pojo.bean.QCbhsDaysJjcb;
import com.server.pojo.bean.QCbhsDaysZyCailiaoCb;
import com.server.pojo.bean.QCbhsDaysZyJxCb;
import com.server.pojo.bean.QCbhsDaysZyLxygCb;
import com.server.pojo.bean.QCbhsDaysZyQtCb;
import com.server.pojo.bean.QCbhsReim;
import com.server.pojo.bean.QCbhsSettleDown;
import com.server.pojo.bean.QCbhsUser;
import com.server.pojo.bean.QCbhsZytj;

/**
 * 审核任务管理器
 * 
 * @author Administrator
 *
 */
public class ExaminerManager {

	@Autowired
	private PushManager pushManager;

	@Autowired
	private CbSrManager cbSrManager;

	/**
	 * 创建审核任务
	 * 
	 * @param projectOid
	 * @param type
	 * @param cbOid
	 * @param deptOid
	 * @param deptName
	 * @param extStr
	 * @param title
	 * @param alert
	 * @param personOid
	 * @param personName
	 */
	public void createExaminer(MyQueryFactory queryFactory, Integer projectOid, Integer type, Integer cbOid, Integer deptOid, String deptName, String extStr, String title, String alert,
			Integer personOid, String personName) {
		// 创建审核任务
		CbhsCbExaminer cce = new CbhsCbExaminer();
		cce.setProjectOid(projectOid);
		cce.setType(type);
		cce.setCbOid(cbOid);
		cce.setDeptOid(deptOid);
		cce.setDeptName(deptName);
		cce.setExtStr(extStr);
		cce.setTitle(title);
		cce.setAlert(alert);
		cce.setPersonOid(personOid);
		cce.setPersonName(personName);
		cce.setCompleteState(1);
		long time = System.currentTimeMillis();
		DateTime dTime = new DateTime(time);
		cce.setCreateTime(time);
		cce.setCreateTimeStr(dTime.toString("yyyy-MM-dd HH:mm:ss"));
		cce = queryFactory.saveOrUpdate(cce);
		if (type == SheObject.shType_reim) {
			queryFactory.update(QCbhsReim.cbhsReim).set(QCbhsReim.cbhsReim.examOid, cce.getOid()).where(QCbhsReim.cbhsReim.oid.eq(cbOid)).execute();
		}
		// 创建步骤
		CbhsCbExaminerRule rule = queryFactory.select(QCbhsCbExaminerRule.cbhsCbExaminerRule).from(QCbhsCbExaminerRule.cbhsCbExaminerRule)
				.where(QCbhsCbExaminerRule.cbhsCbExaminerRule.projectOid.eq(projectOid)).where(QCbhsCbExaminerRule.cbhsCbExaminerRule.deptOid.eq(deptOid)).fetchFirst();
		if (rule != null) {
			List<Integer> personOidsList = Lists.newArrayList(rule.getPersonOid1(), rule.getPersonOid2());
			List<CbhsUser> personList = queryFactory.selectFrom(QCbhsUser.cbhsUser).where(QCbhsUser.cbhsUser.oid.in(personOidsList)).fetch();
			List<CbhsCbExaminerStep> entitySteps = Lists.newArrayList();
			for (int i = 0; i < personOidsList.size(); i++) {
				int this_personOid = personOidsList.get(i);
				CbhsCbExaminerStep step = new CbhsCbExaminerStep();
				step.setTaskOid(cce.getOid());
				step.setShPersonOid(this_personOid);
				for (CbhsUser p : personList) {
					if (p.getOid().intValue() == this_personOid) {
						step.setShPersonName(p.getName());
						break;
					}
				}
				step.setStepStatus(1);
				step.setShorder(i + 1);
				if (i == 0) {
					step.setStepStatus(2);
					cce.setShPersonOid(this_personOid);
					cce.setShorder(step.getShorder());
					cce = queryFactory.saveOrUpdate(cce);
					pushManager.pushExamMessage(Lists.newArrayList(this_personOid), cce.getPersonName() + "发起" + title + "审核请求", cce.getPersonName() + "发起" + title + "审核请求", cce.getPersonName()
							+ "发起审核请求", cce.getOid() + "");
				}
				entitySteps.add(step);
			}
			// 财务报销 中间增加一级财务审批
			if (type == SheObject.shType_reim) {
				List<CbhsCbExaminerStep> newSteps = Lists.newArrayList();
				newSteps.add(entitySteps.get(0));
				// 财务审批
				CbhsCbExaminerStep step = new CbhsCbExaminerStep();
				step.setTaskOid(cce.getOid());
				step.setShPersonOid(0);
				step.setStepStatus(1);
				step.setShorder((2));
				newSteps.add(step);
				newSteps.add(entitySteps.get(1));
				newSteps.get(2).setShorder(3);
				entitySteps = newSteps;
			}
			queryFactory.batchSaveOrUpdate(entitySteps);
		} else {
			// 未配置审核规则
			completeExaminer(queryFactory, cce, true);
		}
	}

	/**
	 * 继续下一步审核
	 * 
	 * @param examinerOid
	 */
	public void nextExaminer(MyQueryFactory queryFactory, Integer examinerOid, Integer stepStatus) {
		if (stepStatus == 3) { // 审核通过开始 下一级审核
			CbhsCbExaminerStep nextShe = queryFactory.selectFrom(QCbhsCbExaminerStep.cbhsCbExaminerStep)
					.where(QCbhsCbExaminerStep.cbhsCbExaminerStep.stepStatus.eq(1).and(QCbhsCbExaminerStep.cbhsCbExaminerStep.taskOid.eq(examinerOid)))
					.orderBy(QCbhsCbExaminerStep.cbhsCbExaminerStep.shorder.asc()).fetchFirst();
			CbhsCbExaminer examiner = queryFactory.findOne(CbhsCbExaminer.class, examinerOid);
			if (nextShe == null) {
				completeExaminer(queryFactory, examiner, true);
			} else {
				nextShe.setStepStatus(2);
				examiner.setShPersonOid(nextShe.getShPersonOid());
				examiner.setShorder(nextShe.getShorder());
				queryFactory.saveOrUpdate(nextShe);
				queryFactory.saveOrUpdate(examiner);
				pushManager.pushExamMessage(Lists.newArrayList(nextShe.getShPersonOid()), examiner.getPersonName() + "发起" + examiner.getTitle() + "审核请求",
						examiner.getPersonName() + "发起" + examiner.getTitle() + "审核请求", examiner.getPersonName() + "发起审核请求", examiner.getExtStr());
			}
		}
		if (stepStatus == 4) { // 审核失败
			CbhsCbExaminer examiner = queryFactory.findOne(CbhsCbExaminer.class, examinerOid);
			completeExaminer(queryFactory, examiner, false);
		}
	}

	/**
	 * 完成审核
	 * 
	 * @param message
	 * @param success
	 */
	public void completeExaminer(MyQueryFactory queryFactory, CbhsCbExaminer message, boolean success) {
		queryFactory.delete(QCbhsCb.cbhsCb).where(QCbhsCb.cbhsCb.cbOid.eq(message.getCbOid()).and(QCbhsCb.cbhsCb.type.eq(message.getType())));
		if (message.getType().intValue() == SheObject.shType_Jjcb) { // 间接成本
			queryFactory.update(QCbhsDaysJjcb.cbhsDaysJjcb).set(QCbhsDaysJjcb.cbhsDaysJjcb.shStatus, success ? 0 : 2).where(QCbhsDaysJjcb.cbhsDaysJjcb.oid.eq(message.getCbOid())).execute();
			String title = "间接成本审核" + (success ? "成功" : "失败");
			pushManager.pushExamMessage(Lists.newArrayList(message.getPersonOid()), title, title, title, message.getOid() + "");
			if (success) {
				CbhsDaysJjcb ys = queryFactory.selectFrom(QCbhsDaysJjcb.cbhsDaysJjcb).where(QCbhsDaysJjcb.cbhsDaysJjcb.oid.eq(message.getCbOid())).fetchFirst();
				CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
				cb.setOid(null);
				cb.setType(SheObject.shType_Jjcb);
				cb.setCbOid(ys.getOid());
				cbSrManager.createCb(queryFactory, cb);
			}
		}
		if (message.getType().intValue() == SheObject.shType_glfycb) { // 管理费用
			queryFactory.update(QCbhsDaysGlfyYs.cbhsDaysGlfyYs).set(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.shStatus, success ? 0 : 2).where(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.oid.eq(message.getCbOid()))
					.execute();
			String title = "管理费用审核" + (success ? "成功" : "失败");
			pushManager.pushExamMessage(Lists.newArrayList(message.getPersonOid()), title, title, title, message.getOid() + "");
			if (success) {
				CbhsDaysGlfyYs ys = queryFactory.selectFrom(QCbhsDaysGlfyYs.cbhsDaysGlfyYs).where(QCbhsDaysGlfyYs.cbhsDaysGlfyYs.oid.eq(message.getCbOid())).fetchFirst();
				CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
				cb.setOid(null);
				cb.setType(SheObject.shType_glfycb);
				cb.setCbOid(ys.getOid());
				cbSrManager.createCb(queryFactory, cb);
			}
		}
		if (message.getType().intValue() == SheObject.shType_qtcb) { // 其他成本
			queryFactory.update(QCbhsDaysZyQtCb.cbhsDaysZyQtCb).set(QCbhsDaysZyQtCb.cbhsDaysZyQtCb.shStatus, success ? 0 : 2).where(QCbhsDaysZyQtCb.cbhsDaysZyQtCb.oid.eq(message.getCbOid()))
					.execute();
			String title = "其他成本审核" + (success ? "成功" : "失败");
			pushManager.pushExamMessage(Lists.newArrayList(message.getPersonOid()), title, title, title, message.getOid() + "");
			if (success) {
				CbhsDaysZyQtCb ys = queryFactory.selectFrom(QCbhsDaysZyQtCb.cbhsDaysZyQtCb).where(QCbhsDaysZyQtCb.cbhsDaysZyQtCb.oid.eq(message.getCbOid())).fetchFirst();
				CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
				cb.setOid(null);
				cb.setType(SheObject.shType_qtcb);
				cb.setCbOid(ys.getOid());
				cbSrManager.createCb(queryFactory, cb);
			}
		}
		if (message.getType().intValue() == SheObject.shType_zylxyg) { // 零星用工
			queryFactory.update(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb).set(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb.shStatus, success ? 0 : 2)
					.where(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb.oid.eq(message.getCbOid())).execute();
			String title = "零星用工审核" + (success ? "成功" : "失败");
			pushManager.pushExamMessage(Lists.newArrayList(message.getPersonOid()), title, title, title, message.getOid() + "");
			if (success) {
				CbhsDaysZyLxygCb ys = queryFactory.selectFrom(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb).where(QCbhsDaysZyLxygCb.cbhsDaysZyLxygCb.oid.eq(message.getCbOid())).fetchFirst();
				CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
				cb.setOid(null);
				cb.setType(SheObject.shType_zylxyg);
				cb.setCbOid(ys.getOid());
				cbSrManager.createCb(queryFactory, cb);
			}
		}
		if (message.getType().intValue() == SheObject.shType_zycailiaocb) { // 自营材料成本
			queryFactory.update(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb).set(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.shStatus, success ? 0 : 2)
					.where(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.oid.eq(message.getCbOid())).execute();
			String title = "自营材料成本审核" + (success ? "成功" : "失败");
			pushManager.pushExamMessage(Lists.newArrayList(message.getPersonOid()), title, title, title, message.getOid() + "");
			if (success) {
				CbhsDaysZyCailiaoCb ys = queryFactory.selectFrom(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb).where(QCbhsDaysZyCailiaoCb.cbhsDaysZyCailiaoCb.oid.eq(message.getCbOid())).fetchFirst();
				CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
				cb.setOid(null);
				cb.setType(SheObject.shType_zycailiaocb);
				cb.setCbOid(ys.getOid());
				cbSrManager.createCb(queryFactory, cb);
			}
		}
		if (message.getType().intValue() == SheObject.shType_zyjxcb) { // 自营机械成本
			queryFactory.update(QCbhsDaysZyJxCb.cbhsDaysZyJxCb).set(QCbhsDaysZyJxCb.cbhsDaysZyJxCb.shStatus, success ? 0 : 2).where(QCbhsDaysZyJxCb.cbhsDaysZyJxCb.oid.eq(message.getCbOid()))
					.execute();
			String title = "自营机械成本审核" + (success ? "成功" : "失败");
			pushManager.pushExamMessage(Lists.newArrayList(message.getPersonOid()), title, title, title, message.getOid() + "");
			if (success) {
				CbhsDaysZyJxCb ys = queryFactory.selectFrom(QCbhsDaysZyJxCb.cbhsDaysZyJxCb).where(QCbhsDaysZyJxCb.cbhsDaysZyJxCb.oid.eq(message.getCbOid())).fetchFirst();
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
		}
		if (message.getType().intValue() == SheObject.shType_fbljxm) { // 分包临建项目
			queryFactory.update(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb).set(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.shStatus, success ? 0 : 2)
					.where(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.oid.eq(message.getCbOid())).execute();
			String title = "分包临建项目审核" + (success ? "成功" : "失败");
			pushManager.pushExamMessage(Lists.newArrayList(message.getPersonOid()), title, title, title, message.getOid() + "");
			if (success) {
				CbhsDaysFbLjxmCb ys = queryFactory.selectFrom(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb).where(QCbhsDaysFbLjxmCb.cbhsDaysFbLjxmCb.oid.eq(message.getCbOid())).fetchFirst();
				CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
				cb.setOid(null);
				cb.setType(SheObject.shType_fbljxm);
				cb.setCbOid(ys.getOid());
				cbSrManager.createCb(queryFactory, cb);
			}
		}
		if (message.getType().intValue() == SheObject.shType_fbgcl) { // 分包工程量
			queryFactory.update(QCbhsDaysFbGclTj.cbhsDaysFbGclTj).set(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.shStatus, success ? 0 : 2).where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.oid.eq(message.getCbOid()))
					.execute();
			String title = "分包工程量审核" + (success ? "成功" : "失败");
			pushManager.pushExamMessage(Lists.newArrayList(message.getPersonOid()), title, title, title, message.getOid() + "");
			if (success) {
				CbhsDaysFbGclTj ys = queryFactory.selectFrom(QCbhsDaysFbGclTj.cbhsDaysFbGclTj).where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.oid.eq(message.getCbOid())).fetchFirst();
				CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
				cb.setOid(null);
				cb.setType(SheObject.shType_fbgcl);
				cb.setCbOid(ys.getOid());
				cbSrManager.createCb(queryFactory, cb);
			}
		}
		if (message.getType().intValue() == SheObject.shType_zytj) { // 资源统计
			queryFactory.update(QCbhsZytj.cbhsZytj).set(QCbhsZytj.cbhsZytj.shStatus, success ? 0 : 2).where(QCbhsZytj.cbhsZytj.oid.eq(message.getCbOid())).execute();
			String title = "资源统计审核" + (success ? "成功" : "失败");
			pushManager.pushExamMessage(Lists.newArrayList(message.getPersonOid()), title, title, title, message.getOid() + "");
			if (success) {
				CbhsZytj ys = queryFactory.selectFrom(QCbhsZytj.cbhsZytj).where(QCbhsZytj.cbhsZytj.oid.eq(message.getCbOid())).fetchFirst();
				CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
				cb.setOid(null);
				cb.setType(SheObject.shType_zytj);
				cb.setCbOid(ys.getOid());
				cbSrManager.createCb(queryFactory, cb);
				if (ys.getRyPrice().compareTo(BigDecimal.ZERO) > 0) {
					CbhsCb shType_zytjry = JSON.parseObject(JSON.toJSONString(cb), CbhsCb.class);
					shType_zytjry.setOid(null);
					shType_zytjry.setType(SheObject.shType_zytjry);
					shType_zytjry.setTotal(ys.getRyPrice());
					shType_zytjry.setCbOid(ys.getOid());
					cbSrManager.createCb(queryFactory, shType_zytjry);
				}
				if (ys.getZcTotal().compareTo(BigDecimal.ZERO) > 0) {
					CbhsCb shType_zytjzc = JSON.parseObject(JSON.toJSONString(cb), CbhsCb.class);
					shType_zytjzc.setOid(null);
					shType_zytjzc.setType(SheObject.shType_zytjzc);
					shType_zytjzc.setTotal(ys.getZcTotal());
					shType_zytjzc.setCbOid(ys.getOid());
					cbSrManager.createCb(queryFactory, shType_zytjzc);
				}
			}
		}
		if (message.getType().intValue() == SheObject.shType_fbgcljg) { // 分包工程量价格
			queryFactory.update(QCbhsDaysFbGclTj.cbhsDaysFbGclTj).set(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.shStatus, success ? 0 : 2).where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.oid.eq(message.getCbOid()))
					.execute();
			String title = "分包工程量价格审核" + (success ? "成功" : "失败");
			pushManager.pushExamMessage(Lists.newArrayList(message.getPersonOid()), title, title, title, message.getOid() + "");
			if (success) {
				CbhsDaysFbGclTj ys = queryFactory.selectFrom(QCbhsDaysFbGclTj.cbhsDaysFbGclTj).where(QCbhsDaysFbGclTj.cbhsDaysFbGclTj.oid.eq(message.getCbOid())).fetchFirst();
				CbhsCb cb = JSON.parseObject(JSON.toJSONString(ys), CbhsCb.class);
				cb.setOid(null);
				cb.setType(SheObject.shType_fbgcljg);
				cb.setCbOid(ys.getOid());
				cbSrManager.createCb(queryFactory, cb);
			}
		}
		if (message.getType().intValue() == SheObject.shType_ssd) { // 对下结算
			queryFactory.update(QCbhsSettleDown.cbhsSettleDown).set(QCbhsSettleDown.cbhsSettleDown.shStatus, success ? 0 : 2).where(QCbhsSettleDown.cbhsSettleDown.oid.eq(message.getCbOid()))
					.execute();
			String title = "对下结算审核" + (success ? "成功" : "失败");
			pushManager.pushExamMessage(Lists.newArrayList(message.getPersonOid()), title, title, title, message.getOid() + "");
		}
		if (message.getType().intValue() == SheObject.shType_reim) { // 财务报销
			queryFactory.update(QCbhsReim.cbhsReim).set(QCbhsReim.cbhsReim.shStatus, success ? 0 : 2).where(QCbhsReim.cbhsReim.oid.eq(message.getCbOid())).execute();
			String title = "财务报销审核" + (success ? "成功" : "失败");
			pushManager.pushExamMessage(Lists.newArrayList(message.getPersonOid()), title, title, title, message.getOid() + "");
		}
		message.setCompleteState(success ? 2 : 3);
		queryFactory.saveOrUpdate(message);
	}

}
