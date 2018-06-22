package com.cbhs.gencode.api.task;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.api.IObjProcess;
import com.cbhs.gencode.api.task.process.OutPutAndroidBean;
import com.cbhs.gencode.api.task.process.OutPutIos;
import com.cbhs.gencode.api.task.process.OutPutJavaBean;
import com.cbhs.gencode.api.task.process.bm.BmAndriodOut;
import com.cbhs.gencode.api.task.process.bm.BmIosOut;
import com.cbhs.gencode.api.task.process.bm.BmOut;
import com.cbhs.gencode.api.task.process.menu.MenuAndroidOut;
import com.cbhs.gencode.api.task.process.menu.MenuJavaOut;
import com.cbhs.gencode.api.task.process.menu.MenuWebOut;
import com.cbhs.gencode.api.task.process.url.OutPutBeanInUrl;
import com.cbhs.gencode.api.task.process.url.OutPutUrlObj;

public class AllManager {
	public static String targetPath = null;
	private String path = null;
	String xlsxPath = null;

	public AllManager(String inputPath) throws Exception {
		System.out.println("");
		System.out.println("--------------------------------------------------------------------------------");
		System.out.println("gen code begin...." + inputPath);
		if (inputPath != null && inputPath.length() > 0) {
			path = inputPath;
		} else {
			path = this.getClass().getResource(File.separator).getPath();
		}
		targetPath = path.substring(0, path.indexOf("gencode"));
		// excel 路径
		xlsxPath = File.separator + "excel";
		// 生成Bean对象文件
		// ,
		IObjProcess[] processes = new IObjProcess[] { new OutPutJavaBean(targetPath), new OutPutAndroidBean(targetPath) };
		try {
			for (IObjProcess process : processes) {
				excute(new EntityFile(targetPath + xlsxPath), process, 0);
				process.finish();
			}
			// // 生成URL 接口
			processes = new IObjProcess[] { new OutPutBeanInUrl(), new OutPutUrlObj(targetPath) };
			for (IObjProcess process : processes) {
				excute(new UrlCommandFile(targetPath + xlsxPath), process, 0);
				process.finish();
			}
			// // Menu菜单 接口
			//
			processes = new IObjProcess[] { new MenuJavaOut(targetPath), new MenuAndroidOut(targetPath), new MenuWebOut(targetPath) };
			for (IObjProcess process : processes) {
				excute(new MenuFile(targetPath + xlsxPath), process, 0);
				process.finish();
			}
			System.out.println("gen code success!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("gen code fail!!!!!");
			System.out.println("********************");
		}
	}

	public static void excute(ILevelObj levelObj, IObjProcess process, int index) throws Exception {
		int count = 0;
		for (Iterator<ILevelObj> i = levelObj.process(process, index); i.hasNext();) {
			ILevelObj nextObj = i.next();
			excute(nextObj, process, count++);
		}
		levelObj.endprocess(process);
	}

	/**
	 * @param args
	 * @throws IOException
	 * @throws MdbException
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AllManager manager = null;
		try {
			if (args != null && args.length > 0) {
				manager = new AllManager(args[0]);
			} else {
				manager = new AllManager(null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
