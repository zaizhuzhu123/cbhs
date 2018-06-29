package com.server.manager;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;
import com.server.jpa.MyQueryFactory;
import com.server.pojo.bean.CbhsVersion;
import com.server.pojo.bean.QCbhsAccount;
import com.server.util.JiguangPush;

/**
 * 推送管理器
 * 
 * @author Administrator
 *
 */
public class PushManager {

	@Autowired
	private MyQueryFactory queryFactory;

	private ExecutorService executor = Executors.newFixedThreadPool(10);

	/**
	 * 推送消息
	 * 
	 * @Title: pushMessage @Description: TODO(这里用一句话描述这个方法的作用) @param personOids @param title @param alert @param message @param ext 设定文件 @return void 返回类型 @throws
	 */
	public void pushExamMessage(List<Integer> personOids, String title, String alert, String message, String ext) {
		List<String> registrationIds = queryFactory.select(QCbhsAccount.cbhsAccount.ryToken).from(QCbhsAccount.cbhsAccount)
				.where(QCbhsAccount.cbhsAccount.user.oid.in(personOids).and(QCbhsAccount.cbhsAccount.ryToken.isNotNull()).and(QCbhsAccount.cbhsAccount.ryToken.isNotEmpty())).fetch();
		if (registrationIds != null && registrationIds.size() > 0) {
			JiguangPush jp = new JiguangPush();
			executor.submit(new Runnable() {
				@Override
				public void run() {
					jp.jiguangPush(registrationIds, JiguangPush.type_exam, title, alert, message, "examOid", ext);
				}
			});
		}
	}

	public void pushUpgradeMessage(CbhsVersion version) {
		JiguangPush jp = new JiguangPush();
		List<String> registrationIds = queryFactory.select(QCbhsAccount.cbhsAccount.ryToken).from(QCbhsAccount.cbhsAccount)
				.where(QCbhsAccount.cbhsAccount.ryToken.isNotNull().and(QCbhsAccount.cbhsAccount.ryToken.isNotEmpty())).fetch();
		executor.submit(new Runnable() {
			@Override
			public void run() {
				jp.jiguangPush(registrationIds, JiguangPush.type_upgrade, version.getPushtitle(), version.getPushAlert(), version.getPushAlert(), "versionInfo", JSON.toJSONString(version));
			}
		});
	}

	public void pushAllMessage(String title, int type, String alert, String ext) {
		JiguangPush jp = new JiguangPush();
		List<String> registrationIds = queryFactory.select(QCbhsAccount.cbhsAccount.ryToken).from(QCbhsAccount.cbhsAccount)
				.where(QCbhsAccount.cbhsAccount.ryToken.isNotNull().and(QCbhsAccount.cbhsAccount.ryToken.isNotEmpty())).fetch();
		executor.submit(new Runnable() {
			@Override
			public void run() {
				jp.jiguangPush(registrationIds, type, title, alert, alert, "", "");
			}
		});
	}
}
