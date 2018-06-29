package com.server.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.server.handler.SystemService;
import com.server.handler.TjbbApisService;
import com.server.handler.imp.SystemServiceImp;
import com.server.jpa.MyQueryFactory;
import com.server.manager.PushManager;
import com.server.pojo.bean.CbhsLog;
import com.server.pojo.bean.CbhsProject;
import com.server.pojo.bean.QCbhsProject;
import com.server.pojo.bean.uiAbnormal;
import com.server.pojo.url.tjbb.RequestAbnormalFetch;
import com.server.pojo.url.tjbb.RequestZybbAbnormalFetch;
import com.server.util.JiguangPush;

@Component
public class QuartzService {

	private Logger logger = LoggerFactory.getLogger(QuartzService.class);

	public static LinkedBlockingQueue<CbhsLog> quene = new LinkedBlockingQueue<CbhsLog>();

	@Autowired
	private MyQueryFactory queryFactory;

	@Autowired
	private TjbbApisService tjbbApisService;

	private String mysqlPath;

	@Value("${spring.datasource.username}")
	private String userName;

	@Value("${spring.datasource.password}")
	private String password;

	@Autowired
	private PushManager pushManager;

	private int port = 3370;

	// 每5分钟启动
	@Scheduled(cron = "0 0/2 * * * ?")
	public void timerToNow() {
		if (quene.size() > 0) {
			logger.info("启动日志定时写入任务------>");
			List<CbhsLog> logs = new ArrayList<>();
			CbhsLog log = null;
			while ((log = quene.poll()) != null) {
				logs.add(log);
			}
			SystemService ls = (SystemService) BeanTools.getBean(SystemServiceImp.class);
			try {
				ls.insertLogs(logs);
			} catch (Exception e) {
				System.out.println("日志保存失败!");
			}
			logger.info("<-------日志定时写入任务完成");
		}

	}

	// 每天下午6点 统计当天的成本收入 以及资源成本
	@Scheduled(cron = "0 0 18 * * ?")
	public void tjcbsr() throws Exception {
		List<CbhsProject> projects = queryFactory.selectFrom(QCbhsProject.cbhsProject).where(QCbhsProject.cbhsProject.status.eq(true).and(QCbhsProject.cbhsProject.state.ne(2))).fetch();
		if (projects != null && projects.size() > 0) {
			RequestAbnormalFetch r1 = new RequestAbnormalFetch();
			RequestZybbAbnormalFetch r2 = new RequestZybbAbnormalFetch();
			for (int i = 0; i < projects.size(); i++) {
				CbhsProject p = projects.get(i);
				r1.setProjectOid(p.getOid());
				uiAbnormal abn = tjbbApisService.abnormalFetch(r1, null);
				if (abn.getAbnormal()) {
					pushManager.pushAllMessage(p.getName() + "-今日成本收入结果异常", JiguangPush.type_abnormal, "今日收入:" + abn.getSrTotal() + ",今日支出:" + abn.getCbTotal(), "");
				}
				r2.setProjectOid(p.getOid());
				uiAbnormal abn2 = tjbbApisService.zybbAbnormalFetch(r2, null);
				if (abn2.getAbnormal()) {
					pushManager.pushAllMessage(p.getName() + "-今日资源统计结果异常", JiguangPush.type_abnormal, "今日收入:" + abn2.getSrTotal() + ",今日支出:" + abn2.getCbTotal(), "");
				}
			}
		}
	}

	// 每12小时备份一次数据库
	// @Scheduled(cron = "0 0 0/6 * * ?")
	@Scheduled(cron = "0 0 0/6 * * ?")
	public void backDatabase() throws IOException, InterruptedException, SQLException {
		synchronized (this) {
			if (mysqlPath == null) {
				initMysqlPath();
				if (!mysqlPath.endsWith("\\")) {
					mysqlPath = mysqlPath + "\\";
				}
				mysqlPath = mysqlPath.replace("\\", "\\\\") + "bin\\\\";
				logger.info("mysql安装路径:" + mysqlPath);
			}
		}
		File saveFile = new File("../../../backupDatabase");
		if (!saveFile.exists()) {// 如果目录不存在
			saveFile.mkdirs();// 创建文件夹
		}
		File file = new File(saveFile.getCanonicalPath() + "/" + new DateTime(System.currentTimeMillis()).toString("yyyyMMddHHmmss") + ".sql");
		if (!file.exists()) {
			file.createNewFile();
		}
		PrintWriter printWriter = null;
		BufferedReader bufferedReader = null;
		try {
			printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream(file), "utf8"));
			Process process = Runtime.getRuntime().exec(mysqlPath + "mysqldump -P " + port + " -u" + userName + " -p" + password + " --set-charset=UTF8 cbhs");
			InputStreamReader inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
			bufferedReader = new BufferedReader(inputStreamReader);
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				printWriter.println(line);
			}
			printWriter.flush();
			if (process.waitFor() == 0) {// 0 表示线程正常终止。
				logger.info("数据库备份成功," + file.getCanonicalPath());
			}
			process = Runtime.getRuntime().exec(mysqlPath + "mysqladmin -P " + port + " -u" + userName + " -p" + password + " flush-logs");
			inputStreamReader = new InputStreamReader(process.getInputStream(), "utf8");
			bufferedReader = new BufferedReader(inputStreamReader);
			while ((line = bufferedReader.readLine()) != null) {
				printWriter.println(line);
			}
			printWriter.flush();
			if (process.waitFor() == 0) {// 0 表示线程正常终止。
				logger.info("日志刷新成功," + file.getCanonicalPath());
			}
		} catch (Exception e) {
			logger.error("Capturing an exception", e);
			logger.info("数据库备份失败," + file.getCanonicalPath());
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
				if (printWriter != null) {
					printWriter.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void initMysqlPath() throws SQLException {
		mysqlPath = (String) queryFactory.getSqlRunner().query("select @@basedir as basePath from dual", new ScalarHandler<String>("basePath"));
	}
}