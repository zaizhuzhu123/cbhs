package com.server.handler;

import java.util.List;

import com.server.pojo.bean.CbhsLog;

public interface SystemService {
	public void insertLog(CbhsLog log);

	public void insertLogs(List<CbhsLog> logs);
}
