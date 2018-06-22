package com.cbhs.gencode.api.task.process.url;

import com.cbhs.gencode.api.task.entity.NewFieldObj;
import com.cbhs.gencode.api.task.web.entity.SimpleWebCommandOperationInfo;

public class UrlUtil {
	public static SimpleWebCommandOperationInfo processFiled(NewFieldObj newField, boolean changeInnerClass) throws Exception {
		SimpleWebCommandOperationInfo urlInfo = new SimpleWebCommandOperationInfo();
		try {
			urlInfo.setMsgCode(Integer.parseInt(newField.getFielValue(0)));
		} catch (Exception e) {
			// no thing
		}
		urlInfo.setDesc(newField.getFielValue(1));
		urlInfo.setUrl(newField.getFielValue(2));
		urlInfo.setMethod(newField.getFielValue(3));
		urlInfo.setOpCode(newField.getFielValue(4));
		urlInfo.setWorkClass(newField.getFielValue(5));
		urlInfo.setMsgReaquest(newField.getFielValue(6));
		urlInfo.setReaquestDepict(newField.getFielValue(7));
		urlInfo.setMsgResponse(newField.getFielValue(8));
		urlInfo.setResponseDepict(newField.getFielValue(9));
		urlInfo.setJsr303Str(newField.getFielValue(11));

		boolean isServerInterface = false;
		String isServerInterfaceStr = newField.getFielValue(10);// add hlj
																// Spring事务
		if (isServerInterfaceStr != null && isServerInterfaceStr.length() > 0) {
			if (isServerInterfaceStr.equalsIgnoreCase("y") || isServerInterfaceStr.equalsIgnoreCase("t")) {
				isServerInterface = true;
			}
		}
		urlInfo.setServerInterface(isServerInterface);

		boolean transation = false;
		String booleanStr = newField.getFielValue(11);// add hlj Spring事务
		if (booleanStr != null && booleanStr.length() > 0) {
			if (booleanStr.equalsIgnoreCase("y") || booleanStr.equalsIgnoreCase("t")) {
				transation = true;
			}
		} else {
			if (urlInfo.getMethod().equals("POST")) {
				transation = true;
			}
		}
		urlInfo.setTransation(transation);
		// 新增内部bean
		if (changeInnerClass) {
			if (isInnerBean(urlInfo.getMsgReaquest())) {
				urlInfo.setMsgReaquest(getInnerRequestBeanName(urlInfo.getUrl(), true));
				urlInfo.setHasInnerClass(true);
			}
			if (isInnerBean(urlInfo.getMsgResponse())) {
				urlInfo.setMsgResponse(getInnerResponseBeanName(urlInfo.getUrl(), true));
				urlInfo.setHasInnerClass(true);
			}
		}
		return urlInfo;
	}

	public static boolean isInnerBean(String classname) {
		if (classname != null && classname.contains(":")) {
			return true;
		}
		return false;
	}

	public static String getInnerRequestBeanName(String url, boolean needPackage) {
		String commandName = getCommandName(url);
		String modularName = getModularName(url);
		String beanName = "Request" + fistUpCase(commandName);
		if (needPackage) {
			beanName = "com.server.pojo.url." + modularName + "." + beanName;
		}
		return beanName;
	}

	public static String getInnerResponseBeanName(String url, boolean needPackage) {

		String commandName = getCommandName(url);
		String modularName = getModularName(url);
		String beanName = "Response" + fistUpCase(commandName);
		if (needPackage) {
			beanName = "com.server.pojo.url." + modularName + "." + beanName;
		}
		return beanName;
	}

	public static String getCommandName(String url) {
		url = url.replaceAll("-", "_");
		return url.substring(url.lastIndexOf("/") + 1, url.length());
	}

	public static String getModularName(String url) {
		url = url.replaceAll("-", "_");
		String modularName = url.substring(0, url.lastIndexOf("/"));
		modularName = modularName.substring(modularName.lastIndexOf("/") + 1, modularName.length());
		return modularName;
	}

	public static String fistUpCase(String s) {
		return s.substring(0, 1).toUpperCase() + s.substring(1, s.length());
	}
}
