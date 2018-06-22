package com.cbhs.gencode.api.task.process.url;

import java.io.IOException;

import com.cbhs.gencode.api.task.AllManager;
import com.cbhs.gencode.api.task.api.IObjProcess;
import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.NewFieldObj;
import com.cbhs.gencode.api.task.process.AbstractProcess;
import com.cbhs.gencode.api.task.process.OutPutAndroidBean;
import com.cbhs.gencode.api.task.process.OutPutJavaBean;
import com.cbhs.gencode.api.task.web.entity.SimpleWebCommandOperationInfo;

public class OutPutBeanInUrl extends AbstractProcess {

	public OutPutBeanInUrl() throws IOException {

	}

	@Override
	public void endFiled(FieldObj field) throws Exception {
		SimpleWebCommandOperationInfo urlInfo = UrlUtil.processFiled((NewFieldObj) field, false);
		if (UrlUtil.isInnerBean(urlInfo.getMsgReaquest()) || UrlUtil.isInnerBean(urlInfo.getMsgResponse())) {
			String targetPath = AllManager.targetPath;
			// 只生成android,java,ios的bean，另外Proto生成出来作为过渡阶段用
			IObjProcess[] processes = new IObjProcess[] { new OutPutAndroidBean(targetPath), new OutPutJavaBean(targetPath) };

			for (IObjProcess process : processes) {
				// null请用field的字段值来解决出来。
				AllManager.excute(new UrlEntityFile(urlInfo, this.fileName), process, 0);
				process.finish();
			}
		}
	}

}
