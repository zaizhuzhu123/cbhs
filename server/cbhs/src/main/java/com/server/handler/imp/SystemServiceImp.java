package com.server.handler.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.server.handler.SystemService;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsLog;

@Service
@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRES_NEW, timeout = 60)
public class SystemServiceImp implements SystemService {

	@Autowired
	private MyQueryFactory queryFactory;

	@Override
	public void insertLog(CbhsLog log) {
		queryFactory.saveOrUpdate(log);
	}

	@Override
	public void insertLogs(List<CbhsLog> logs) {
		queryFactory.batchSaveOrUpdate(logs);
	}
}
