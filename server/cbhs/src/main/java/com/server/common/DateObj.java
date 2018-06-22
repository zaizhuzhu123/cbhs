package com.server.common;

import java.util.List;

import org.joda.time.DateTime;

import com.google.common.collect.Lists;

public class DateObj {

	private long startTime;

	private long endTime;

	public static final int type_month = 1;
	public static final int type_days = 2;

	public DateObj(long time, int type) {
		if (type == type_month) {
			DateTime dt = new DateTime(time);
			dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), 1, 0, 0, 0, 0);
			this.startTime = dt.getMillis();
			dt = dt.plusMonths(1);
			dt = dt.minusDays(1);
			dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59, 59, 999);
			this.endTime = dt.getMillis();
		}
		if (type == type_days) {
			DateTime dt = new DateTime(time);
			dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 0, 0, 0, 0);
			this.startTime = dt.getMillis();
			dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59, 59, 999);
			this.endTime = dt.getMillis();
		}
	}

	public DateObj(long startTime, long endTime) {
		DateTime dt = new DateTime(startTime);
		dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 0, 0, 0, 0);
		this.startTime = dt.getMillis();
		dt = new DateTime(endTime);
		dt = new DateTime(dt.getYear(), dt.getMonthOfYear(), dt.getDayOfMonth(), 23, 59, 59, 999);
		this.endTime = dt.getMillis();
	}

	public List<String> toDaysList() {
		List<String> daysList = Lists.newArrayList();
		if (endTime > startTime) {
			DateTime dTime = new DateTime(startTime);
			while (startTime <= endTime) {
				daysList.add(dTime.toString("yyyy-MM-dd"));
				dTime = dTime.plusDays(1);
				startTime = dTime.getMillis();
			}
		}
		return daysList;
	}

	public long getStartTime() {
		return startTime;
	}

	public long getEndTime() {
		return endTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(long endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "DateObj [startTime=" + startTime + ", endTime=" + endTime + "]";
	}

	public static void main(String[] args) {
		// System.out.println(new DateObj(System.currentTimeMillis()));
		// System.out.println(new DateObj(1525104000002L, 1527782399998L));

		DateObj doo = new DateObj(1522912440000l, 1527664440000l);
		System.out.println(doo.toDaysList().toString());
	}
}
