package com.server.handler.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.server.common.DateObj;
import com.server.common.SheObject;
import com.server.handler.CommonApisService;
import com.server.handler.TjbbApisService;
import com.server.jpa.MyJPAQuery;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsCb;
import com.server.pojo.bean.CbhsDaysGlfyYs;
import com.server.pojo.bean.CbhsDaysJjcb;
import com.server.pojo.bean.QCbhsCb;
import com.server.pojo.bean.QCbhsDaysFbGclTj;
import com.server.pojo.bean.QCbhsDaysGlfyYs;
import com.server.pojo.bean.QCbhsDaysJjcb;
import com.server.pojo.bean.QCbhsSr;
import com.server.pojo.bean.QCbhsZdgxhs;
import com.server.pojo.bean.uiAbnormal;
import com.server.pojo.bean.uiCbAnalyze;
import com.server.pojo.bean.uiCbSrTj;
import com.server.pojo.bean.uiDaysCbDetailTj;
import com.server.pojo.bean.uiDeptGrandTotalTj;
import com.server.pojo.bean.uiGrandTotalTj;
import com.server.pojo.url.tjbb.RequestAbnormalFetch;
import com.server.pojo.url.tjbb.RequestCbAnalyze;
import com.server.pojo.url.tjbb.RequestCbsrbb;
import com.server.pojo.url.tjbb.RequestDaysDetails;
import com.server.pojo.url.tjbb.RequestGrandTotal;
import com.server.pojo.url.tjbb.RequestZybb;
import com.server.pojo.url.tjbb.RequestZybbAbnormalFetch;
import com.server.pojo.url.tjbb.ResponseCbsrbb;
import com.server.pojo.url.tjbb.ResponseZybb;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
// 分包商结算产值收入 ， 是直接成本中的分包成本。 分包商直接成本，是资源统计中的总金额
public class TjbbApisServiceImp implements TjbbApisService {

	@Autowired
	private MyQueryFactory queryFactory;
	@Autowired
	private CommonApisService commonApisService;

	@Override
	public ResponseCbsrbb cbsrbb(RequestCbsrbb request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		Preconditions.checkArgument(request.getDaysStart() > 0, "起始日期不能为空!");
		Preconditions.checkArgument(request.getDaysEnd() > 0, "结束日期不能为空!");
		DateObj doo = new DateObj(request.getDaysStart(), request.getDaysEnd());
		Preconditions.checkArgument(doo.getEndTime() >= doo.getStartTime(), "开始时间不能大于结束时间!");
		QCbhsCb query_cb = QCbhsCb.cbhsCb;
		List<uiCbSrTj> cbs = queryFactory.select(Projections.bean(uiCbSrTj.class, query_cb.dateStr, query_cb.total.sum().as("total"))).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.dateTimeStamp.goe(doo.getStartTime())).and(query_cb.dateTimeStamp.loe(doo.getEndTime()))).groupBy(query_cb.dateStr).fetch();
		QCbhsSr query_sr = QCbhsSr.cbhsSr;
		List<uiCbSrTj> srs = queryFactory.select(Projections.bean(uiCbSrTj.class, query_sr.dateStr, query_sr.total.sum().as("total"))).from(query_sr).where(query_sr.projectOid.eq(request.getProjectOid()).and(query_sr.dateTimeStamp.goe(doo.getStartTime())).and(query_sr.dateTimeStamp.loe(doo.getEndTime()))).groupBy(query_sr.dateStr).fetch();
		List<String> daysList = doo.toDaysList();
		Map<String, uiCbSrTj> cbsMap = Maps.uniqueIndex(cbs, new Function<uiCbSrTj, String>() {
			public String apply(uiCbSrTj from) {
				return from.getDateStr();
			}
		});
		Map<String, uiCbSrTj> srsMap = Maps.uniqueIndex(srs, new Function<uiCbSrTj, String>() {
			public String apply(uiCbSrTj from) {
				return from.getDateStr();
			}
		});
		if (daysList.size() > 0) {
			for (String daysStr : daysList) {
				if (!cbsMap.containsKey(daysStr)) {
					uiCbSrTj cb = new uiCbSrTj();
					cb.setDateStr(daysStr);
					cb.setTotal(new BigDecimal(0));
					cbs.add(cb);
				}
				if (!srsMap.containsKey(daysStr)) {
					uiCbSrTj sr = new uiCbSrTj();
					sr.setDateStr(daysStr);
					sr.setTotal(new BigDecimal(0));
					srs.add(sr);
				}
			}
		}
		Ordering<uiCbSrTj> _ordering = Ordering.from(new Comparator<uiCbSrTj>() {
			@Override
			public int compare(uiCbSrTj o1, uiCbSrTj o2) {
				// TODO Auto-generated method stub
				return o1.getDateStr().compareTo(o2.getDateStr());
			}
		});
		Collections.sort(cbs, _ordering);
		Collections.sort(srs, _ordering);
		ResponseCbsrbb response = new ResponseCbsrbb();
		response.setCbs(cbs);
		response.setSrs(srs);
		return response;
	}

	@Override
	public ResponseZybb zybb(RequestZybb request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		Preconditions.checkArgument(request.getDaysStart() > 0, "起始日期不能为空!");
		Preconditions.checkArgument(request.getDaysEnd() > 0, "结束日期不能为空!");
		DateObj doo = new DateObj(request.getDaysStart(), request.getDaysEnd());
		Preconditions.checkArgument(doo.getEndTime() >= doo.getStartTime(), "开始时间不能大于结束时间!");
		QCbhsZdgxhs query_cb = QCbhsZdgxhs.cbhsZdgxhs;
		MyJPAQuery<uiCbSrTj> jpaQuery_cb = (MyJPAQuery<uiCbSrTj>) queryFactory.select(Projections.bean(uiCbSrTj.class, query_cb.dateStr, query_cb.total.sum().as("total"))).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.dateTimeStamp.goe(doo.getStartTime())).and(query_cb.dateTimeStamp.loe(doo.getEndTime()))).groupBy(query_cb.dateStr);
		jpaQuery_cb.where(request.getFbCompanyOid(), query_cb.fbcompanyOid.eq(request.getFbCompanyOid()));
		List<uiCbSrTj> cbs = jpaQuery_cb.fetch();
		QCbhsDaysFbGclTj query_sr = QCbhsDaysFbGclTj.cbhsDaysFbGclTj;
		MyJPAQuery<uiCbSrTj> jpaQuery_sr = (MyJPAQuery<uiCbSrTj>) queryFactory.select(Projections.bean(uiCbSrTj.class, query_sr.dateStr, query_sr.total.sum().as("total"))).from(query_sr).where(query_sr.projectOid.eq(request.getProjectOid()).and(query_sr.shStatus.eq(0)).and(query_sr.dateTimeStamp.goe(doo.getStartTime())).and(query_sr.dateTimeStamp.loe(doo.getEndTime()))).groupBy(query_sr.dateStr);
		jpaQuery_sr.where(request.getFbCompanyOid(), query_sr.fbCompanyOid.eq(request.getFbCompanyOid()));
		List<uiCbSrTj> srs = jpaQuery_sr.fetch();
		List<String> daysList = doo.toDaysList();
		Map<String, uiCbSrTj> cbsMap = Maps.uniqueIndex(cbs, new Function<uiCbSrTj, String>() {
			public String apply(uiCbSrTj from) {
				return from.getDateStr();
			}
		});
		Map<String, uiCbSrTj> srsMap = Maps.uniqueIndex(srs, new Function<uiCbSrTj, String>() {
			public String apply(uiCbSrTj from) {
				return from.getDateStr();
			}
		});
		if (daysList.size() > 0) {
			for (String daysStr : daysList) {
				if (!cbsMap.containsKey(daysStr)) {
					uiCbSrTj cb = new uiCbSrTj();
					cb.setDateStr(daysStr);
					cb.setTotal(new BigDecimal(0));
					cbs.add(cb);
				}
				if (!srsMap.containsKey(daysStr)) {
					uiCbSrTj sr = new uiCbSrTj();
					sr.setDateStr(daysStr);
					sr.setTotal(new BigDecimal(0));
					srs.add(sr);
				}
			}
		}
		Ordering<uiCbSrTj> _ordering = Ordering.from(new Comparator<uiCbSrTj>() {
			@Override
			public int compare(uiCbSrTj o1, uiCbSrTj o2) {
				// TODO Auto-generated method stub
				return o1.getDateStr().compareTo(o2.getDateStr());
			}
		});
		Collections.sort(cbs, _ordering);
		Collections.sort(srs, _ordering);
		ResponseZybb response = new ResponseZybb();
		response.setCbs(cbs);
		response.setSrs(srs);
		return response;
	}

	@Override
	public uiDaysCbDetailTj daysDetails(RequestDaysDetails request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		Integer deptOid = request.getDeptOid();
		DateObj doo = new DateObj(request.getDaysTimeStamp(), DateObj.type_days);
		uiDaysCbDetailTj response = new uiDaysCbDetailTj();
		// 总收入成本汇总
		QCbhsCb query_cb = QCbhsCb.cbhsCb;
		MyJPAQuery<BigDecimal> cbJpaQuery = (MyJPAQuery<BigDecimal>) queryFactory.select(query_cb.total.sum()).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.dateTimeStamp.goe(doo.getStartTime())).and(query_cb.dateTimeStamp.loe(doo.getEndTime())));
		QCbhsSr query_sr = QCbhsSr.cbhsSr;
		MyJPAQuery<BigDecimal> srJpaQuery = (MyJPAQuery<BigDecimal>) queryFactory.select(query_sr.total.sum().nullif(new BigDecimal(0))).from(query_sr).where(query_sr.projectOid.eq(request.getProjectOid()).and(query_sr.dateTimeStamp.goe(doo.getStartTime())).and(query_sr.dateTimeStamp.loe(doo.getEndTime())));
		if (deptOid > 0) {
			cbJpaQuery.where(query_cb.deptOid.eq(deptOid));
			srJpaQuery.where(query_sr.deptOid.eq(deptOid));
		}
		BigDecimal cbTotal = cbJpaQuery.fetchFirst();
		BigDecimal srTotal = srJpaQuery.fetchFirst();
		response.setCbTotal(cbTotal != null ? cbTotal : BigDecimal.ZERO);
		response.setSrTotal(srTotal != null ? srTotal : BigDecimal.ZERO);
		response.setYkTotal(response.getSrTotal().subtract(response.getCbTotal()));
		// 成本明细汇总
		MyJPAQuery<Tuple> detailJpaQuery = (MyJPAQuery<Tuple>) queryFactory.select(query_cb.type, query_cb.total.sum().nullif(new BigDecimal(0))).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.dateTimeStamp.goe(doo.getStartTime())).and(query_cb.dateTimeStamp.loe(doo.getEndTime()))).groupBy(query_cb.type);
		if (deptOid > 0) {
			detailJpaQuery.where(query_cb.deptOid.eq(deptOid));
		}
		List<Tuple> detailList = detailJpaQuery.fetch();
		for (int i = 0; i < detailList.size(); i++) {
			Tuple tu = detailList.get(i);
			int type = tu.get(0, Integer.class);
			BigDecimal total = tu.get(1, BigDecimal.class);
			switch (type) {
			case SheObject.shType_Jjcb:
				response.setJjcb(total);
				break;
			case SheObject.shType_glfycb:
				response.setGlfy(total);
				break;
			case SheObject.shType_zylxyg:
				response.setLxyg(total);
				break;
			case SheObject.shType_zyjxcb:
				response.setZyjxcb(total);
				break;
			case SheObject.shType_qtcb:
				response.setQtfy(total);
				break;
			case SheObject.shType_zycailiaocb:
				response.setZycailiaocb(total);
				break;
			case SheObject.shType_fbljxm:
				response.setLjxm(total);
				break;
			case SheObject.shType_fbgcljg:
				response.setFbcb(total);
				break;
			case SheObject.shType_zytj:
				response.setFbcailiaocb(total);
				break;
			case SheObject.shType_zyjxcbry:
				response.setZycailiaocb(total);
				break;
			default:
				break;
			}
		}
		return response;
	}

	@Override
	public uiGrandTotalTj grandTotal(RequestGrandTotal request, HttpServletRequest httpServletRequest) throws Exception {

		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		DateObj doo = new DateObj(request.getDaysStart(), request.getDaysEnd());
		Preconditions.checkArgument(doo.getEndTime() >= doo.getStartTime(), "开始时间不能大于结束时间!");
		uiGrandTotalTj response = new uiGrandTotalTj();
		// 总收入成本汇总
		QCbhsCb query_cb = QCbhsCb.cbhsCb;
		MyJPAQuery<BigDecimal> cbJpaQuery = (MyJPAQuery<BigDecimal>) queryFactory.select(query_cb.total.sum()).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.dateTimeStamp.goe(doo.getStartTime())).and(query_cb.dateTimeStamp.loe(doo.getEndTime())));
		QCbhsSr query_sr = QCbhsSr.cbhsSr;
		MyJPAQuery<BigDecimal> srJpaQuery = (MyJPAQuery<BigDecimal>) queryFactory.select(query_sr.total.sum().nullif(new BigDecimal(0))).from(query_sr).where(query_sr.projectOid.eq(request.getProjectOid()).and(query_sr.dateTimeStamp.goe(doo.getStartTime())).and(query_sr.dateTimeStamp.loe(doo.getEndTime())));
		BigDecimal cbTotal = cbJpaQuery.fetchFirst();
		BigDecimal srTotal = srJpaQuery.fetchFirst();
		response.setCbTotal(cbTotal != null ? cbTotal : BigDecimal.ZERO);
		response.setSrTotal(srTotal != null ? srTotal : BigDecimal.ZERO);
		response.setYkTotal(response.getSrTotal().subtract(response.getCbTotal()));
		// // 查询各部门明细
		String sql = "select d.oid deptOid,d.name deptName,count(u.oid) personCount  from cbhs_dept d left join cbhs_user u on u.dept_oid=d.oid  and u.status=1 and u.is_admin=0 where d.status=1 group by d.oid";
		// 返回查询值
		ArrayList<uiDeptGrandTotalTj> depts = (ArrayList<uiDeptGrandTotalTj>) queryFactory.getSqlRunner().query(sql, new BeanListHandler<>(uiDeptGrandTotalTj.class));
		if (depts.size() > 0) {
			List<uiDeptGrandTotalTj> cbs = queryFactory.select(Projections.bean(uiDeptGrandTotalTj.class, query_cb.deptOid, query_cb.total.sum().as("cbTotal"))).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.dateTimeStamp.goe(doo.getStartTime())).and(query_cb.dateTimeStamp.loe(doo.getEndTime()))).groupBy(query_cb.deptOid).fetch();
			if (cbs.size() > 0) {
				for (uiDeptGrandTotalTj cb : cbs) {
					for (uiDeptGrandTotalTj dept : depts) {
						if (cb.getDeptOid().intValue() == dept.getDeptOid().intValue()) {
							dept.setCbTotal(cb.getCbTotal());
						}
					}
				}
			}
		}
		response.setDeptGrandTotals(depts);
		return response;
	}

	@Override
	public uiAbnormal abnormalFetch(RequestAbnormalFetch request, HttpServletRequest httpServletRequest) throws Exception {
		long curTime = System.currentTimeMillis();
		DateTime ddt = new DateTime(curTime);
		DateObj dobj = new DateObj(curTime, DateObj.type_days);
		long todayStart = dobj.getStartTime();
		DateTime dt = new DateTime(todayStart);
		dt = dt.minusDays(5);
		long startTime = dt.getMillis();
		RequestCbsrbb requestCbsrbb = new RequestCbsrbb();
		requestCbsrbb.setProjectOid(request.getProjectOid());
		requestCbsrbb.setDaysStart(startTime);
		requestCbsrbb.setDaysEnd(dobj.getEndTime());
		ResponseCbsrbb response = cbsrbb(requestCbsrbb, httpServletRequest);
		float before5days = 0;
		float effectiveDays = 0;
		List<uiCbSrTj> cbs = response.getCbs();
		List<uiCbSrTj> srs = response.getSrs();
		for (int i = 0; i < 5; i++) {
			uiCbSrTj cb = cbs.get(i);
			uiCbSrTj sr = srs.get(i);
			if (cb.getTotal().compareTo(BigDecimal.ZERO) == 0) {
				// before5days += 999;
			} else {
				before5days += (sr.getTotal().divide(cb.getTotal(), 2, RoundingMode.HALF_UP).floatValue());
				effectiveDays += 1;
			}
		}
		uiAbnormal ui = new uiAbnormal();
		ui.setTjTime(curTime);
		ui.setCbTotal(cbs.get(5).getTotal());
		ui.setSrTotal(srs.get(5).getTotal());
		ui.setAbnormal(false);
		float avg = 0; // 前5天 收入/支出 平均比例
		if (effectiveDays > 0) {
			avg = before5days / effectiveDays;
		}
		float today = ui.getCbTotal().compareTo(BigDecimal.ZERO) > 0 ? ui.getSrTotal().divide(ui.getCbTotal(), 2, RoundingMode.HALF_UP).floatValue() : 999999999;
		if (today - avg > 0.05f || today - avg < -0.05f || ui.getCbTotal().compareTo(BigDecimal.ZERO) == 0 || ui.getSrTotal().compareTo(BigDecimal.ZERO) == 0) {
			if (ddt.getHourOfDay() >= 18) {
				ui.setAbnormal(true);
			}
		}
		return ui;
	}

	@Override
	public uiAbnormal zybbAbnormalFetch(RequestZybbAbnormalFetch request, HttpServletRequest httpServletRequest) throws Exception {
		long curTime = System.currentTimeMillis();
		DateTime ddt = new DateTime(curTime);
		DateObj dobj = new DateObj(curTime, DateObj.type_days);
		long todayStart = dobj.getStartTime();
		DateTime dt = new DateTime(todayStart);
		dt = dt.minusDays(5);
		long startTime = dt.getMillis();
		RequestZybb requestCbsrbb = new RequestZybb();
		requestCbsrbb.setProjectOid(request.getProjectOid());
		requestCbsrbb.setDaysStart(startTime);
		requestCbsrbb.setDaysEnd(dobj.getEndTime());
		requestCbsrbb.setFbCompanyOid(request.getFbCompanyOid());
		ResponseZybb response = zybb(requestCbsrbb, httpServletRequest);
		float before5days = 0;
		float effectiveDays = 0;
		List<uiCbSrTj> cbs = response.getCbs();
		List<uiCbSrTj> srs = response.getSrs();
		for (int i = 0; i < 5; i++) {
			uiCbSrTj cb = cbs.get(i);
			uiCbSrTj sr = srs.get(i);
			if (cb.getTotal().compareTo(BigDecimal.ZERO) == 0) {
				// before5days += 999;
			} else {
				before5days += (sr.getTotal().divide(cb.getTotal(), 2, RoundingMode.HALF_UP).floatValue());
				effectiveDays += 1;
			}
		}
		uiAbnormal ui = new uiAbnormal();
		ui.setTjTime(curTime);
		ui.setCbTotal(cbs.get(5).getTotal());
		ui.setSrTotal(srs.get(5).getTotal());
		ui.setAbnormal(false);
		float avg = 0; // 前5天 收入/支出 平均比例
		if (effectiveDays > 0) {
			avg = before5days / effectiveDays;
		}
		float today = ui.getCbTotal().compareTo(BigDecimal.ZERO) > 0 ? ui.getSrTotal().divide(ui.getCbTotal(), 2, RoundingMode.HALF_UP).floatValue() : 999999999;
		if (today - avg > 0.05f || today - avg < -0.05f || ui.getCbTotal().compareTo(BigDecimal.ZERO) == 0 || ui.getSrTotal().compareTo(BigDecimal.ZERO) == 0) {
			if (ddt.getHourOfDay() >= 18) {
				ui.setAbnormal(true);
			}
		}
		return ui;
	}

	@Override
	public uiCbAnalyze cbAnalyze(RequestCbAnalyze request, HttpServletRequest httpServletRequest) throws Exception {
		Preconditions.checkArgument(request.getProjectOid() > 0, "工程项目ID不能为空!");
		uiCbAnalyze response = new uiCbAnalyze();
		Preconditions.checkArgument(request.getMonthStart() != null && request.getMonthStart() > 0, "开始月份不能为空!");
		if (request.getMonthEnd() == null || request.getMonthEnd() == 0) {
			request.setMonthEnd(new DateObj(System.currentTimeMillis(), DateObj.type_month).getEndTime());
		} else {
			request.setMonthEnd(new DateObj(request.getMonthEnd(), DateObj.type_month).getEndTime());
		}
		request.setMonthStart(new DateObj(request.getMonthStart(), DateObj.type_month).getStartTime());
		Preconditions.checkArgument(request.getMonthEnd() >= request.getMonthStart(), "开始月份不能大于结束月份!");
		// 总收入成本汇总
		QCbhsCb query_cb = QCbhsCb.cbhsCb;
		MyJPAQuery<BigDecimal> cbJpaQuery = (MyJPAQuery<BigDecimal>) queryFactory.select(query_cb.total.sum()).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.dateTimeStamp.goe(request.getMonthStart())).and(query_cb.dateTimeStamp.loe(request.getMonthEnd())));
		QCbhsSr query_sr = QCbhsSr.cbhsSr;
		MyJPAQuery<BigDecimal> srJpaQuery = (MyJPAQuery<BigDecimal>) queryFactory.select(query_sr.total.sum().nullif(new BigDecimal(0))).from(query_sr).where(query_sr.projectOid.eq(request.getProjectOid()).and(query_sr.dateTimeStamp.goe(request.getMonthStart())).and(query_sr.dateTimeStamp.loe(request.getMonthEnd())));
		BigDecimal cbTotal = cbJpaQuery.fetchFirst();
		BigDecimal srTotal = srJpaQuery.fetchFirst();
		response.setCbTotal(cbTotal != null ? cbTotal : BigDecimal.ZERO);
		response.setSrTotal(srTotal != null ? srTotal : BigDecimal.ZERO);
		// 成本明细汇总
		List<CbhsCb> cbs = queryFactory.selectFrom(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.dateTimeStamp.goe(request.getMonthStart())).and(query_cb.dateTimeStamp.loe(request.getMonthEnd()))).fetch();
		Map<Integer, List<Integer>> typeListsMap = Maps.newHashMap();
		if (cbs != null && cbs.size() > 0) {
			for (int i = 0; i < cbs.size(); i++) {
				CbhsCb cb = cbs.get(i);
				if (!typeListsMap.containsKey(cb.getType().intValue())) {
					typeListsMap.put(cb.getType().intValue(), Lists.newArrayList());
				}
				typeListsMap.get(cb.getType().intValue()).add(cb.getCbOid());
			}
			for (Entry<Integer, List<Integer>> entry : typeListsMap.entrySet()) {
				Integer type = entry.getKey();
				List<Integer> oids = entry.getValue();
				switch (type) {
				case SheObject.shType_Jjcb:
					QCbhsDaysJjcb query = QCbhsDaysJjcb.cbhsDaysJjcb;
					List<CbhsDaysJjcb> jjcbs = queryFactory.selectFrom(query).where(query.oid.in(oids)).fetch();
					if (jjcbs.size() > 0) {
						for (CbhsDaysJjcb jjcb : jjcbs) {
							// 人力
							response.setRlTotal(jjcb.getScry_gz().add(response.getRlTotal()));
							response.setRlTotal(jjcb.getScry_zjjf().add(response.getRlTotal()));
							response.setRlTotal(jjcb.getScry_ghjf().add(response.getRlTotal()));
							response.setRlTotal(jjcb.getScry_dwbx().add(response.getRlTotal()));
							response.setRlTotal(jjcb.getScry_qt().add(response.getRlTotal()));
							response.setRlTotal(jjcb.getScry_wp_gz().add(response.getRlTotal()));
							response.setRlTotal(jjcb.getScry_wp_zjjf().add(response.getRlTotal()));
							response.setRlTotal(jjcb.getScry_wp_ghjf().add(response.getRlTotal()));
							response.setRlTotal(jjcb.getScry_wp_qt().add(response.getRlTotal()));
							// 人员工资
							response.setRygztotal(jjcb.getGlry_gz().add(response.getRygztotal()));
							response.setRygztotal(jjcb.getGlry_zjjf().add(response.getRygztotal()));
							response.setRygztotal(jjcb.getGlry_ghjf().add(response.getRygztotal()));
							response.setRygztotal(jjcb.getGlry_dwbx().add(response.getRygztotal()));
							response.setRygztotal(jjcb.getGlry_qt().add(response.getRygztotal()));
							response.setRygztotal(jjcb.getGlry_wp_gz().add(response.getRygztotal()));
							response.setRygztotal(jjcb.getGlry_wp_zjjf().add(response.getRygztotal()));
							response.setRygztotal(jjcb.getGlry_wp_ghjf().add(response.getRygztotal()));
							response.setRygztotal(jjcb.getGlry_wp_qt().add(response.getRygztotal()));
							response.setRygztotal(jjcb.getAqfy_ygsz().add(response.getRygztotal()));
							response.setRygztotal(jjcb.getAqfy_ygsztc().add(response.getRygztotal()));
							// 差旅费
							response.setClftotal(jjcb.getXlf_clf().add(response.getClftotal()));
							// 办公费
							response.setBgftotal(jjcb.getBg_bgyp().add(response.getBgftotal()));
							response.setBgftotal(jjcb.getBg_txf().add(response.getBgftotal()));
							response.setBgftotal(jjcb.getBg_dnhc().add(response.getBgftotal()));
							response.setBgftotal(jjcb.getBg_qt().add(response.getBgftotal()));
							// 业务经费
							response.setYwjftotal(jjcb.getXlf_ywjf().add(response.getYwjftotal()));
							// 修理费
							response.setXlftotal(jjcb.getXlf_dxf().add(response.getXlftotal()));
							response.setXlftotal(jjcb.getXlf_ybxlf().add(response.getXlftotal()));
							// 其他费用
							response.setQtfytotal(jjcb.getAqfy_qt().add(response.getQtfytotal()));
							response.setQtfytotal(jjcb.getXlf_cailiaofei().add(response.getQtfytotal()));
							response.setQtfytotal(jjcb.getXlf_flf().add(response.getQtfytotal()));
							response.setQtfytotal(jjcb.getXlf_sdf().add(response.getQtfytotal()));
							response.setQtfytotal(jjcb.getXlf_scf().add(response.getQtfytotal()));
							response.setQtfytotal(jjcb.getXlf_kyjf().add(response.getQtfytotal()));
							response.setQtfytotal(jjcb.getXlf_cljbxf().add(response.getQtfytotal()));
							response.setQtfytotal(jjcb.getXlf_qt().add(response.getQtfytotal()));
							response.setQtfytotal(jjcb.getXlf_bhfy().add(response.getQtfytotal()));
							response.setQtfytotal(jjcb.getXlf_gzzrx().add(response.getQtfytotal()));
						}
					}
					break;
				case SheObject.shType_glfycb:
					QCbhsDaysGlfyYs query2 = QCbhsDaysGlfyYs.cbhsDaysGlfyYs;
					List<CbhsDaysGlfyYs> glfys = queryFactory.selectFrom(query2).where(query2.oid.in(oids)).fetch();
					if (glfys.size() > 0) {
						for (CbhsDaysGlfyYs glfy : glfys) {
							// 企业管理费用
							response.setQyjgfytotal(glfy.getP_sjgs().add(response.getQyjgfytotal()));
							response.setQyjgfytotal(glfy.getP_ztbfy().add(response.getQyjgfytotal()));
							response.setQyjgfytotal(glfy.getP_sjzjjf().add(response.getQyjgfytotal()));
							// 税金
							response.setSjtotal(glfy.getP_kdqqysds().add(response.getSjtotal()));
							response.setSjtotal(glfy.getP_yhsjqtsj().add(response.getSjtotal()));
						}
					}
					break;
				}
			}
		}
		// 零星用工人力
		BigDecimal lxyg = queryFactory.select(query_cb.total.sum()).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.type.in(Lists.newArrayList(SheObject.shType_zylxyg))).and(query_cb.dateTimeStamp.goe(request.getMonthStart())).and(query_cb.dateTimeStamp.loe(request.getMonthEnd()))).fetchFirst();
		response.setRlTotal(lxyg != null ? lxyg.add(response.getRlTotal()) : response.getRlTotal());
		if (response.getCbTotal().compareTo(BigDecimal.ZERO) > 0) {
			response.setRlSpecific(response.getRlTotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
			response.setRygzSpecific(response.getRygztotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
			response.setClfSpecific(response.getClftotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
			response.setBgfSpecific(response.getBgftotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
			response.setYwjfSpecific(response.getYwjftotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
			response.setXlfSpecific(response.getXlftotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
			response.setQtfySpecific(response.getQtfytotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
			response.setQyjgfySpecific(response.getQyjgfytotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
			response.setSjSpecific(response.getSjtotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
		}
		// 自营材料成本
		BigDecimal zycailiao = queryFactory.select(query_cb.total.sum()).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.type.in(Lists.newArrayList(SheObject.shType_zycailiaocb, SheObject.shType_zyjxcbry))).and(query_cb.dateTimeStamp.goe(request.getMonthStart())).and(query_cb.dateTimeStamp.loe(request.getMonthEnd()))).fetchFirst();
		response.setCailiaoTotal(zycailiao != null ? zycailiao : BigDecimal.ZERO);
		if (response.getCbTotal().compareTo(BigDecimal.ZERO) > 0) {
			response.setCailiaoSpecific(response.getCailiaoTotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
		}
		// 自营机械成本
		BigDecimal zyjx = queryFactory.select(query_cb.total.sum()).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.type.in(Lists.newArrayList(SheObject.shType_zyjxcb))).and(query_cb.dateTimeStamp.goe(request.getMonthStart())).and(query_cb.dateTimeStamp.loe(request.getMonthEnd()))).fetchFirst();
		response.setJxTotal(zyjx != null ? zyjx : BigDecimal.ZERO);
		if (response.getCbTotal().compareTo(BigDecimal.ZERO) > 0) {
			response.setJxSpecific(response.getJxTotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
		}
		// 其他成本
		BigDecimal qt = queryFactory.select(query_cb.total.sum()).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.type.in(Lists.newArrayList(SheObject.shType_qtcb))).and(query_cb.dateTimeStamp.goe(request.getMonthStart())).and(query_cb.dateTimeStamp.loe(request.getMonthEnd()))).fetchFirst();
		response.setQttotal(qt != null ? qt : BigDecimal.ZERO);
		if (response.getCbTotal().compareTo(BigDecimal.ZERO) > 0) {
			response.setQtSpecific(response.getQttotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
		}
		// 分包工程费
		BigDecimal fbgc = queryFactory.select(query_cb.total.sum()).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.type.in(Lists.newArrayList(SheObject.shType_fbgcl, SheObject.shType_fbgcljg))).and(query_cb.dateTimeStamp.goe(request.getMonthStart())).and(query_cb.dateTimeStamp.loe(request.getMonthEnd()))).fetchFirst();
		response.setFbgctotal(fbgc != null ? fbgc : BigDecimal.ZERO);
		if (response.getCbTotal().compareTo(BigDecimal.ZERO) > 0) {
			response.setFbgcSpecific(response.getFbgctotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
		}
		// 临建项目
		BigDecimal fbljxm = queryFactory.select(query_cb.total.sum()).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.type.in(Lists.newArrayList(SheObject.shType_fbljxm, SheObject.shType_fbljxmcount))).and(query_cb.dateTimeStamp.goe(request.getMonthStart())).and(query_cb.dateTimeStamp.loe(request.getMonthEnd()))).fetchFirst();
		response.setFbljxmtotal(fbljxm != null ? fbljxm : BigDecimal.ZERO);
		if (response.getCbTotal().compareTo(BigDecimal.ZERO) > 0) {
			response.setFbljxmSpecific(response.getFbljxmtotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
		}
		// 分包商统计
		BigDecimal fbstj = queryFactory.select(query_cb.total.sum()).from(query_cb).where(query_cb.projectOid.eq(request.getProjectOid()).and(query_cb.type.in(Lists.newArrayList(SheObject.shType_zytjry, SheObject.shType_zytjzc))).and(query_cb.dateTimeStamp.goe(request.getMonthStart())).and(query_cb.dateTimeStamp.loe(request.getMonthEnd()))).fetchFirst();
		response.setFbstjtotal(fbstj != null ? fbstj : BigDecimal.ZERO);
		if (response.getCbTotal().compareTo(BigDecimal.ZERO) > 0) {
			response.setFbstjSpecific(response.getFbstjtotal().divide(response.getCbTotal(), 4, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)));
		}
		return response;
	}
}
