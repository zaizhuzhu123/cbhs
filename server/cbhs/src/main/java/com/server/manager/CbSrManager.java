package com.server.manager;

import java.math.BigDecimal;
import java.util.List;

import org.joda.time.DateTime;

import com.server.common.SheObject;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsCb;
import com.server.pojo.bean.CbhsSr;
import com.server.pojo.bean.QCbhsCb;
import com.server.pojo.bean.QCbhsSr;

public class CbSrManager {

	public void createCb(MyQueryFactory queryFactory, CbhsCb cb) {
		queryFactory.delete(QCbhsCb.cbhsCb).where(QCbhsCb.cbhsCb.type.eq(cb.getType()).and(QCbhsCb.cbhsCb.cbOid.eq(cb.getCbOid()))).execute();
		if (cb.getType() == SheObject.shType_zyjxcb) {
			queryFactory.delete(QCbhsCb.cbhsCb).where(QCbhsCb.cbhsCb.type.eq(SheObject.shType_zyjxcbry).and(QCbhsCb.cbhsCb.cbOid.eq(cb.getCbOid()))).execute();
		}
		if (cb.getType() == SheObject.shType_zytj) {
			queryFactory.delete(QCbhsCb.cbhsCb).where(QCbhsCb.cbhsCb.type.in(SheObject.shType_zytjry, SheObject.shType_zytjzc).and(QCbhsCb.cbhsCb.cbOid.eq(cb.getCbOid()))).execute();
		}
		DateTime dTime = new DateTime(cb.getDateTimeStamp());
		cb.setMonthStr(dTime.toString("yyyy-MM"));
		queryFactory.saveOrUpdate(cb);
	}

	public void delCb(MyQueryFactory queryFactory, Integer type, List<Integer> cbOids) {
		queryFactory.delete(QCbhsCb.cbhsCb).where(QCbhsCb.cbhsCb.type.eq(type).and(QCbhsCb.cbhsCb.cbOid.in(cbOids))).execute();
		if (type == SheObject.shType_zyjxcb) {
			queryFactory.delete(QCbhsCb.cbhsCb).where(QCbhsCb.cbhsCb.type.eq(SheObject.shType_zyjxcbry).and(QCbhsCb.cbhsCb.cbOid.in(cbOids))).execute();
		}
		if (type == SheObject.shType_zytj) {
			queryFactory.delete(QCbhsCb.cbhsCb).where(QCbhsCb.cbhsCb.type.in(SheObject.shType_zytjry, SheObject.shType_zytjzc).and(QCbhsCb.cbhsCb.cbOid.in(cbOids))).execute();
		}
	}

	public void updateCb(MyQueryFactory queryFactory, Integer type, Integer cbOid, BigDecimal total) {
		queryFactory.update(QCbhsCb.cbhsCb).set(QCbhsCb.cbhsCb.total, total).where(QCbhsCb.cbhsCb.type.eq(type).and(QCbhsCb.cbhsCb.cbOid.eq(cbOid))).execute();
	}

	public void createSr(MyQueryFactory queryFactory, CbhsSr sr) {
		DateTime dt = new DateTime(sr.getDateTimeStamp());
		sr.setOpTimeStr(dt.toString("yyyy-MM-dd HH:mm:ss"));
		sr.setOpTime(dt.getMillis());
		sr.setMonthStr(dt.toString("yyyy-MM"));
		queryFactory.saveOrUpdate(sr);
	}

	public void delSr(MyQueryFactory queryFactory, Integer type, List<Integer> cbOids) {
		queryFactory.delete(QCbhsSr.cbhsSr).where(QCbhsSr.cbhsSr.type.eq(type).and(QCbhsSr.cbhsSr.cbOid.in(cbOids))).execute();
	}

	public void updateSr(MyQueryFactory queryFactory, Integer type, Integer cbOid, BigDecimal total) {
		queryFactory.update(QCbhsSr.cbhsSr).set(QCbhsSr.cbhsSr.total, total).where(QCbhsSr.cbhsSr.type.eq(type).and(QCbhsSr.cbhsSr.cbOid.eq(cbOid))).execute();
	}

}
