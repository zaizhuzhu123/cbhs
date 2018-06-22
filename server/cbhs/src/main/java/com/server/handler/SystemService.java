package com.server.handler;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

import com.querydsl.core.types.EntityPath;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.Predicate;
import com.server.pojo.bean.CbhsCbExaminer;
import com.server.pojo.bean.CbhsLog;
import com.server.pojo.bean.CbhsMessage;
import com.server.pojo.bean.CbhsPushMessage;

public interface SystemService {
	public void insertLog(CbhsLog log);

	public void insertLogs(List<CbhsLog> logs);
}
