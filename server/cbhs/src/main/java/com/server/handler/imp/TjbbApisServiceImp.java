package com.server.handler.imp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

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
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.server.common.DateObj;
import com.server.common.SheObject;
import com.server.handler.CommonApisService;
import com.server.handler.TjbbApisService;
import com.server.jpa.MyJPAQuery;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsCb;
import com.server.pojo.bean.QCbhsCb;
import com.server.pojo.bean.QCbhsDaysFbGclTj;
import com.server.pojo.bean.QCbhsSr;
import com.server.pojo.bean.QCbhsZytj;
import com.server.pojo.bean.uiAbnormal;
import com.server.pojo.bean.uiCbSrTj;
import com.server.pojo.bean.uiDaysCbDetailTj;
import com.server.pojo.bean.uiDeptGrandTotalTj;
import com.server.pojo.bean.uiGrandTotalTj;
import com.server.pojo.url.tjbb.RequestAbnormalFetch;
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
		QCbhsZytj query_cb = QCbhsZytj.cbhsZytj;
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
}
