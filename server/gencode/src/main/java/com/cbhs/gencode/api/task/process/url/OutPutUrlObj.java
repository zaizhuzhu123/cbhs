package com.cbhs.gencode.api.task.process.url;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.FileImpl;
import com.cbhs.gencode.api.task.entity.NewFieldObj;
import com.cbhs.gencode.api.task.entity.ProtoObj;
import com.cbhs.gencode.api.task.process.AbstractProcess;
import com.cbhs.gencode.api.task.web.entity.SimpleWebCommandOperationInfo;

public class OutPutUrlObj extends AbstractProcess {

	private BufferedWriter javaBw = null;
	private BufferedWriter iosBw = null;
	private BufferedWriter androidBw = null;
	private BufferedWriter iosHBw = null;
	private static final String JAVA_DIR = File.separator + "\\cbhs\\src\\main\\java\\com\\server\\api\\static_";
	/*
	 * private static final String IOS_DIR = File.separator + "70.ios" + File.separator + "CommonFiles" + File.separator + "Utils" + File.separator + "GdbServer" + File.separator + "WebCommand";
	 */

	// private static final String IOS_DIR = File.separator +
	// "4.ios\\YiQuTong\\YiQuTong\\Model";
	//
	private static final String ANDROID_DIR = "..\\app\\Accounting\\libframe\\src\\main\\java\\com\\lgx\\libframe\\model";;

	private static final String iosTemplate = "#import \"HttpConstants.h\"   \r\n#import \"HttpObj.h\"   \r\n\nstatic NSMutableDictionary  *httpObjs =nil; ";
	private static final String iosHTemplateStart = "#import <Foundation/Foundation.h> " + "\n\n@class HttpObj;" + "\n@interface HttpConstants : NSObject" + "\n\n#define URL_GET @\"GET\" "
			+ "\n\n#define URL_POST @\"POST\"";
	private static final String iosHTemplateEnd = "\n+ (HttpObj *)httpObj:(int)msgCode;" + "\n\n@end";

	private List<SimpleWebCommandOperationInfo> commands = new ArrayList<SimpleWebCommandOperationInfo>();
	private String targetDir;
	// 只在一个文件中的url
	private List<SimpleWebCommandOperationInfo> oneFileCommands = new ArrayList<SimpleWebCommandOperationInfo>();
	private String fileName;
	private String descName;
	private String ignoreFileNames = "updown(上传下载)_url.xlsx";
	private boolean isIgnore = false;// 忽略生成Apis以及Service

	public OutPutUrlObj(String targetDir) throws IOException {
		this.targetDir = targetDir;
		File direc = new File(targetDir + JAVA_DIR);
		if (!direc.exists()) {
			direc.mkdirs();
		}
		String javaTargetFilePath = targetDir + JAVA_DIR + File.separator + "HttpConstants.java";

		File targetfile = new File(javaTargetFilePath);
		if (!targetfile.exists()) {
			targetfile.createNewFile();
		}
		this.javaBw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetfile), "UTF-8"));

		/*****************************************************/
		// File iosDirec = new File(targetDir + IOS_DIR);
		// if (!iosDirec.exists()) {
		// iosDirec.mkdir();
		// }
		// String iosTargetFilePath = targetDir + IOS_DIR + File.separator +
		// "HttpConstants.m";
		//
		// File iosTargetfile = new File(iosTargetFilePath);
		// if (!iosTargetfile.exists()) {
		// iosTargetfile.createNewFile();
		// }
		// iosBw = new BufferedWriter(new OutputStreamWriter(new
		// FileOutputStream(iosTargetfile), "UTF-8"));
		//
		// String iosHTargetFilePath = targetDir + IOS_DIR + File.separator +
		// "HttpConstants.h";
		//
		// File iosHTargetfile = new File(iosHTargetFilePath);
		// if (!iosHTargetfile.exists()) {
		// iosHTargetfile.createNewFile();
		// }
		// iosHBw = new BufferedWriter(new OutputStreamWriter(new
		// FileOutputStream(iosHTargetfile), "UTF-8"));
		// //
		// // /*****************************************************/
		// //
		File androidDirec = new File(targetDir + ANDROID_DIR);
		if (!androidDirec.exists()) {
			androidDirec.mkdir();
		}
		String androidTargetFilePath = targetDir + ANDROID_DIR + File.separator + "HttpConstants.java";

		File androidTargetfile = new File(androidTargetFilePath);
		if (!androidTargetfile.exists()) {
			androidTargetfile.createNewFile();
		}
		this.androidBw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(androidTargetfile), "UTF-8"));
	}

	public void finish() throws Exception {
		// createIosFile();
		createJavaFile();
		createAndroidFile();
	}

	public Iterator<ILevelObj> processFile(final FileImpl ifile, int index) throws Exception {
		if (ignoreFileNames.contains(ifile.getFileName())) {
			isIgnore = true;
		}
		this.fileName = ifile.getFileName().substring(0, ifile.getFileName().indexOf("("));
		if (ifile.getFileName().indexOf("(") != -1 && ifile.getFileName().indexOf(")") != -1) {
			this.descName = ifile.getFileName().substring(ifile.getFileName().indexOf("(") + 1, ifile.getFileName().indexOf(")"));
		}
		return super.processFile(ifile, index);

	}

	@Override
	public Iterator<ILevelObj> processProto(ProtoObj proto, int index) throws Exception {
		return super.processProto(proto, index);
	}

	@Override
	public void endProto(ProtoObj proto) throws Exception {
		if (oneFileCommands.size() > 0 && !isIgnore) {
			String fileName = this.fileName + "Apis";
			String sfileName = this.fileName + "ApisService";
			String fileNameFistUpCase = fileName.substring(0, 1).toUpperCase() + fileName.substring(1, fileName.length());
			String sfileNameFistUpCase = sfileName.substring(0, 1).toUpperCase() + sfileName.substring(1, sfileName.length());
			String controllerFile = targetDir + "\\cbhs\\src\\main\\java\\com\\server\\apis\\" + fileNameFistUpCase;
			String serviceFile = targetDir + "\\cbhs\\src\\main\\java\\com\\server\\handler\\" + sfileNameFistUpCase;
			File mmmmFile = new File(targetDir + "\\cbhs\\src\\main\\java\\com\\server\\apis\\");
			if (!mmmmFile.exists()) {
				mmmmFile.mkdirs();
			}
			File serviceMFile = new File(targetDir + "\\cbhs\\src\\main\\java\\com\\server\\handler");
			if (!serviceMFile.exists()) {
				serviceMFile.mkdirs();
			}
			File mFile = new File(controllerFile + ".java");
			if (!mFile.exists()) {
				mFile.createNewFile();
			}
			File sFile = new File(serviceFile + ".java");
			if (!sFile.exists()) {
				sFile.createNewFile();
			}
			// 生成BaseC
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mFile), "UTF-8"));
			bw.write("package com.server.apis;");
			bw.newLine();
			bw.newLine();
			bw.write("import com.server.pojo.url.*;");
			bw.newLine();
			bw.write("import javax.servlet.http.HttpServletRequest;");
			bw.newLine();
			bw.write("import com.alibaba.fastjson.JSONObject;");
			bw.newLine();
			bw.write("import org.springframework.http.HttpStatus;");
			bw.newLine();
			bw.write("import org.springframework.http.MediaType;");
			bw.newLine();
			bw.write("import org.springframework.validation.annotation.Validated;");
			bw.newLine();
			bw.write("import org.springframework.web.bind.annotation.RequestBody;");
			bw.newLine();
			bw.write("import org.springframework.web.bind.annotation.RequestMapping;");
			bw.newLine();
			bw.write("import org.springframework.web.bind.annotation.RequestMethod;");
			bw.newLine();
			bw.write("import org.springframework.web.bind.annotation.ResponseBody;");
			bw.newLine();
			bw.write("import org.springframework.web.bind.annotation.ResponseStatus;");
			bw.newLine();
			bw.write("import org.springframework.web.bind.annotation.RestController;");
			bw.newLine();
			bw.write("import org.springframework.beans.factory.annotation.Autowired;");
			bw.newLine();
			bw.write("import io.swagger.annotations.Api;");
			bw.newLine();
			bw.write("import io.swagger.annotations.ApiOperation;");
			bw.newLine();
			bw.write("import io.swagger.annotations.ApiResponse;");
			bw.newLine();
			bw.write("import io.swagger.annotations.ApiImplicitParam;");
			bw.newLine();
			bw.write("import io.swagger.annotations.ApiImplicitParams;");
			bw.newLine();
			bw.write("import org.springframework.web.bind.annotation.RequestParam;");
			bw.newLine();
			bw.write("import org.springframework.web.multipart.MultipartFile;");
			bw.newLine();
			bw.write("import com.server.handler." + sfileNameFistUpCase + ";");
			bw.newLine();

			List<String> importClass = new ArrayList<>();
			for (SimpleWebCommandOperationInfo command : oneFileCommands) {
				if (!importClass.contains(command.getMsgReaquest())) {
					if (command.getMsgReaquest().contains("MultipartFile")) {
						continue;
					}
					bw.write("import " + command.getMsgReaquest() + ";");
					bw.newLine();
					importClass.add(command.getMsgReaquest());
				}
				if (!importClass.contains(command.getMsgResponse())) {
					if (!command.getMsgResponse().contains("JSONObject")) {
						bw.write("import " + command.getMsgResponse() + ";");
						bw.newLine();
						importClass.add(command.getMsgResponse());
					}
				}
			}
			bw.newLine();
			bw.write("@Api(tags = { \"" + this.descName + "接口\" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)");
			bw.newLine();
			bw.write("@RestController");
			bw.newLine();
			bw.write("public class " + fileNameFistUpCase + " {");
			bw.newLine();
			bw.write("	@Autowired");
			bw.newLine();
			bw.write("	private " + sfileNameFistUpCase + " " + sfileName + ";");
			bw.newLine();
			bw.newLine();
			bw.newLine();
			for (SimpleWebCommandOperationInfo command : oneFileCommands) {
				String url = command.getUrl().replaceAll("-", "_");
				String commandName = url.substring(url.lastIndexOf("/") + 1, url.length());
				String modularName = url.substring(0, url.lastIndexOf("/"));
				String logResource = command.getWorkClass();
				String responseName = command.getMsgResponse().substring(command.getMsgResponse().lastIndexOf(".") + 1, command.getMsgResponse().length());
				String requestName = command.getMsgReaquest().substring(command.getMsgReaquest().lastIndexOf(".") + 1, command.getMsgReaquest().length());
				String desc = command.getDesc();
				modularName = modularName.substring(modularName.lastIndexOf("/") + 1, modularName.length());
				// if (!modularName.equals(proto.getTableName())) {
				// System.err.println("modul name error " + url + " in " +
				// proto.getTableName() + "_url.xlsx");
				// continue;
				// }
				if ("MultipartFile".equals(requestName)) {
					bw.write("	@RequestMapping(value = \"" + command.getUrl()
							+ "\", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)");
				} else {
					bw.write("	@RequestMapping(value = \"" + command.getUrl()
							+ "\", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)");
				}
				bw.newLine();
				bw.write("	@ResponseStatus(code = HttpStatus.OK)");
				bw.newLine();
				if (!"-1".equals(command.getOpCode())) { // -1为无需登录的api接口 例如注册
					bw.write("	@ApiImplicitParams({");
					bw.newLine();
					// if ("MultipartFile".equals(requestName)) {
					// bw.write(" @ApiImplicitParam(name = \"file\", value =
					// \"文件流对象\", required = true, dataType =
					// \"MultipartFile\"),");
					// }
					bw.write("		@ApiImplicitParam(name = \"token\", value = \"鉴权信息\", required = true, dataType = \"String\", paramType = \"header\"),");
					bw.newLine();
					bw.write("	})");
					bw.newLine();
				}
				if ("MultipartFile".equals(requestName)) {
					bw.write("	@ApiOperation(value = \"" + desc + "\", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)");
				} else {
					bw.write("	@ApiOperation(value = \"" + desc + "\", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)");
				}
				bw.newLine();
				bw.write("	@ApiResponse(code = 200, message = \"操作成功后返回的视图\")");
				bw.newLine();
				bw.write("	@ResponseBody");
				bw.newLine();
				if ("MultipartFile".equals(requestName)) {
					bw.write("	public " + responseName + " " + commandName + "(@RequestParam(name = \"file\", required = true) MultipartFile request,Integer projectOid");
				} else {
					bw.write("	public " + responseName + " " + commandName + "(@Validated @RequestBody " + requestName + " request");
				}
				if (!"-1".equals(command.getOpCode())) { // -1为无需登录的api接口 例如注册
					bw.write(", HttpServletRequest httpServletRequest");
				}
				bw.write(") throws Exception{");
				bw.newLine();
				if (requestName.equals("MultipartFile")) {
					bw.write("		return " + sfileName + "." + commandName + "(request,projectOid" + (!"-1".equals(command.getOpCode()) ? ", httpServletRequest" : "") + ");");
				} else {
					bw.write("		return " + sfileName + "." + commandName + "(request" + (!"-1".equals(command.getOpCode()) ? ", httpServletRequest" : "") + ");");
				}
				bw.newLine();
				bw.write("	}");
				bw.newLine();
				bw.newLine();
				bw.newLine();
			}
			bw.write("}");
			bw.newLine();
			bw.close();
			// 生成BaseService
			BufferedWriter bws = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sFile), "UTF-8"));
			bws.write("package com.server.handler;");
			bws.newLine();
			bws.newLine();
			bws.write("import com.server.pojo.url.*;");
			bws.newLine();
			bws.write("import javax.servlet.http.HttpServletRequest;");
			bws.newLine();
			bws.write("import org.springframework.web.multipart.MultipartFile;");
			bws.newLine();
			// bws.write("import com.server.pojo.bean.YqtHttpResponse;");
			// bws.newLine();
			for (SimpleWebCommandOperationInfo command : oneFileCommands) {
				if (command.getMsgReaquest().contains("MultipartFile")) {
					continue;
				}
				if (!importClass.contains(command.getMsgReaquest())) {
					importClass.add(command.getMsgReaquest());
				}
				if (!command.getMsgReaquest().contains("YqtHttpResponse")) {
					bws.write("import " + command.getMsgReaquest() + ";");
					bws.newLine();
				}

				if (!importClass.contains(command.getMsgResponse())) {
					if (!command.getMsgResponse().contains("YqtHttpResponse")) {
						importClass.add(command.getMsgResponse());
					}
				}
				if (!command.getMsgResponse().contains("YqtHttpResponse")) {
					bws.write("import " + command.getMsgResponse() + ";");
					bws.newLine();
				}
			}
			bws.newLine();
			bws.write("public interface " + sfileNameFistUpCase + " {");
			bws.newLine();
			bws.newLine();
			for (SimpleWebCommandOperationInfo command : oneFileCommands) {
				String url = command.getUrl().replaceAll("-", "_");
				String commandName = url.substring(url.lastIndexOf("/") + 1, url.length());
				String modularName = url.substring(0, url.lastIndexOf("/"));
				String logResource = command.getWorkClass();
				String responseName = command.getMsgResponse().substring(command.getMsgResponse().lastIndexOf(".") + 1, command.getMsgResponse().length());
				String requestName = command.getMsgReaquest().substring(command.getMsgReaquest().lastIndexOf(".") + 1, command.getMsgReaquest().length());
				String desc = command.getDesc();
				if (requestName.equals("MultipartFile")) {
					bws.write("	public " + responseName + " " + commandName + "(" + requestName + " request,Integer projectOid");
				} else {
					bws.write("	public " + responseName + " " + commandName + "(" + requestName + " request");
				}
				if (!"-1".equals(command.getOpCode())) { // -1为无需登录的api接口 例如注册
					bws.write(", HttpServletRequest httpServletRequest");
				}
				bws.write(") throws Exception;");
				bws.newLine();
				bws.newLine();
			}
			bws.write("}");
			bws.newLine();
			bws.close();
			oneFileCommands.clear();
		}
	}

	@Override
	public Iterator<ILevelObj> processFiled(FieldObj field, int index) throws Exception {

		if (index > 0) {
			SimpleWebCommandOperationInfo urlInfo = UrlUtil.processFiled((NewFieldObj) field, true);
			if (null != urlInfo.getUrl() && !"".equals(urlInfo.getUrl())) {
				// 命令码不为空，并且actor的workclass为空,就是新Spring方式
				if (urlInfo.getMsgCode() != 0) {
					urlInfo.setMsgReaquest(addPackage(urlInfo.getMsgReaquest(), "com.server.pojo.bean."));
					urlInfo.setMsgResponse(addPackage(urlInfo.getMsgResponse(), "com.server.pojo.bean."));
					// // String url=urlInfo.getUrl().replaceAll("-", "_");
					// String commandName=url.substring(url.lastIndexOf("/")+1,
					// url.length());
					// String modularName=url.substring(0,
					// url.lastIndexOf("/"));
					// modularName=modularName.substring(modularName.lastIndexOf("/")+1,
					// modularName.length());
					// String commandNameFistUpCase = commandName.substring(0,
					// 1)
					// .toUpperCase() + commandName.substring(1,
					// commandName.length());
					// urlInfo.setRestClass("com.farmer."+UrlUtil.getModularName(urlInfo.getUrl())+".rest."+UrlUtil.fistUpCase(UrlUtil.getCommandName(urlInfo.getUrl())));
					urlInfo.setRestClass(UrlUtil.getCommandName(urlInfo.getUrl()));
					oneFileCommands.add(urlInfo);
				} else {
					// 老的actor方式
					// urlInfo.setMsgReaquest(addPackage(urlInfo.getMsgReaquest(),
					// "com.sdjs.api.proto.mdb."));
					// urlInfo.setMsgResponse(addPackage(urlInfo.getMsgResponse(),
					// "com.sdjs.api.proto.mdb."));
				}
				commands.add(urlInfo);
			}
		}

		return super.processFiled(field, index);
	}

	private String addPackage(String s, String packageName) {
		if (s.contains("JSONObject")) {
			return "com.alibaba.fastjson.JSONObject";
		}
		if (s.indexOf(".") == -1) {
			if (s.trim().endsWith("Wrapper")) {
				return "com.aws.api.frame.msg." + s;// Wrapper一定是老的
			}
			return packageName + s;
		} else {
			return s;
		}
	}

	@Override
	public void endFiled(FieldObj field) throws Exception {

	}

	/*
	 * 输出ios类文件
	 */
	private void createIosFile() throws Exception {
		iosBw.write(iosTemplate);
		iosHBw.write(iosHTemplateStart);
		iosHBw.newLine();
		iosHBw.newLine();
		// iosHBw.write("#define FILE_UPLOAD 99901");
		// iosHBw.newLine();
		// iosHBw.newLine();
		// iosHBw.write("#define FILE_DOWNLOAD 99902");
		// iosHBw.newLine();
		for (int i = 0; i < commands.size(); i++) {
			SimpleWebCommandOperationInfo command = commands.get(i);
			if (command.getMsgCode() == 0) {
				continue;
			}
			String url = command.getUrl().replaceAll("-", "_");
			iosHBw.newLine();

			try {
				String commandName = url.substring(url.lastIndexOf("/") + 1, url.length());
				String modularName = url.substring(0, url.lastIndexOf("/"));
				modularName = modularName.substring(modularName.lastIndexOf("/") + 1, modularName.length());
				iosHBw.write("#define  " + modularName.toUpperCase() + "_" + commandName.toUpperCase() + " " + command.getMsgCode());
				iosHBw.newLine();
			} catch (Exception e) {
				System.out.println(1);
			}
		}
		iosHBw.write(iosHTemplateEnd);
		iosHBw.close();

		iosBw.write("\r\n\r\n@implementation  HttpConstants\r\n\n+ (HttpObj *)httpObj:(int) msgCode {");
		iosBw.newLine();
		iosBw.write("  @synchronized(self) {");
		iosBw.newLine();
		iosBw.write("      if(httpObjs ==nil){");
		iosBw.newLine();
		iosBw.write("            httpObjs=[[NSMutableDictionary alloc]init];");
		iosBw.newLine();
		iosBw.write("      }");
		iosBw.newLine();
		for (SimpleWebCommandOperationInfo command : commands) {
			if (command.getMsgCode() == 0) {
				continue;
			}
			String url = command.getUrl();
			StringBuffer sb = new StringBuffer();
			sb.append("      [httpObjs setValue: [[HttpObj alloc] initHttpObj:@\"");
			sb.append(url);
			sb.append("\" withMethod:");

			String method = "URL_" + command.getMethod();
			sb.append(method);
			sb.append(" withRespObj:@\"");
			int methodPosition = command.getMsgResponse().lastIndexOf(".");
			String returnClass = command.getMsgResponse().substring(methodPosition + 1);
			if (returnClass.equals("JSONObject")) {
				sb.append("JSONObj");
			} else {
				sb.append(returnClass);
			}
			sb.append("\"] forKey:");
			String tempUrl = command.getUrl().replaceAll("-", "_");
			String commandName = tempUrl.substring(tempUrl.lastIndexOf("/") + 1, tempUrl.length());
			String modularName = tempUrl.substring(0, tempUrl.lastIndexOf("/"));
			modularName = modularName.substring(modularName.lastIndexOf("/") + 1, modularName.length());
			sb.append("[NSString stringWithFormat:@\"%d\"," + modularName.toUpperCase() + "_" + commandName.toUpperCase() + "]");
			sb.append("];");
			iosBw.write(sb.toString());
			iosBw.newLine();
		}
		iosBw.newLine();
		iosBw.write("  }");

		iosBw.newLine();
		iosBw.write("    return [httpObjs objectForKey:[NSString stringWithFormat:@\"%d\",  msgCode]];");
		iosBw.newLine();
		iosBw.write("}");
		iosBw.newLine();
		iosBw.write("@end");

		iosBw.close();
	}

	private void createJavaFile() throws IOException {
		javaBw.write("package com.server.api.static_;");
		javaBw.newLine();
		javaBw.write("import java.util.HashMap;");
		javaBw.newLine();
		javaBw.write("public class HttpConstants {");
		javaBw.newLine();
		javaBw.newLine();
		javaBw.write("	public static HashMap<String,SimpleWebCommandOperationInfo> webCommands = new HashMap<String,SimpleWebCommandOperationInfo>();");
		javaBw.newLine();
		javaBw.write("	private static HashMap<Integer,SimpleWebCommandOperationInfo> codeOpMap = new HashMap<Integer,SimpleWebCommandOperationInfo>();");
		javaBw.newLine();

		for (int i = 0; i < commands.size(); i++) {
			SimpleWebCommandOperationInfo command = commands.get(i);
			// if (command.getMsgCode() == 0 || !command.isServerInterface()) {
			// continue;
			// }
			String url = command.getUrl().replaceAll("-", "_");
			String commandName = url.substring(url.lastIndexOf("/") + 1, url.length());
			String modularName = url.substring(0, url.lastIndexOf("/"));
			modularName = modularName.substring(modularName.lastIndexOf("/") + 1, modularName.length());
			javaBw.newLine();

			javaBw.write("    public static Integer " + modularName.toUpperCase() + "_" + firstLowCase(commandName) + "=" + command.getMsgCode() + ";");
			javaBw.newLine();
		}

		javaBw.newLine();
		javaBw.write("	public static SimpleWebCommandOperationInfo getOperation(String url){\n" + "		return webCommands.get(url);\n" + "	}\n");
		javaBw.newLine();
		javaBw.write("	public static SimpleWebCommandOperationInfo getOperation(int cmd){\n" + "		return codeOpMap.get(cmd);\n" + "	}\n");
		javaBw.newLine();
		javaBw.write("      static{ ");

		for (int i = 0; i < commands.size(); i++) {
			SimpleWebCommandOperationInfo command = commands.get(i);
			javaBw.newLine();
			javaBw.write("    SimpleWebCommandOperationInfo urlInfo" + i + "= new SimpleWebCommandOperationInfo();");
			javaBw.newLine();
			javaBw.write("    urlInfo" + i + ".setMsgCode(" + command.getMsgCode() + ");");
			javaBw.newLine();
			javaBw.write("    urlInfo" + i + ".setUrl(\"/cbhs" + command.getUrl() + "\");");
			javaBw.newLine();
			javaBw.write("    urlInfo" + i + ".setOpCode(\"" + command.getOpCode() + "\");");
			javaBw.newLine();
			javaBw.write("    urlInfo" + i + ".setWorkClass(\"" + command.getWorkClass() + "\");");
			javaBw.newLine();
			javaBw.write("    urlInfo" + i + ".setMsgReaquest(\"" + command.getMsgReaquest() + "\");");
			javaBw.newLine();
			javaBw.write("    urlInfo" + i + ".setReaquestDepict(\"" + command.getReaquestDepict() + "\");");
			javaBw.newLine();
			javaBw.write("    urlInfo" + i + ".setMsgResponse(\"" + command.getMsgResponse() + "\");");
			javaBw.newLine();
			javaBw.write("    urlInfo" + i + ".setResponseDepict(\"" + command.getResponseDepict() + "\");");
			javaBw.newLine();
			javaBw.write("    urlInfo" + i + ".setTransation(" + command.isTransation() + ");");
			javaBw.newLine();
			javaBw.write("    urlInfo" + i + ".setRestClass(\"" + command.getRestClass() + "\");");
			javaBw.newLine();
			javaBw.write("    webCommands.put(urlInfo" + i + ".getUrl(),urlInfo" + i + ");");
			javaBw.newLine();
			javaBw.write("    codeOpMap.put(urlInfo" + i + ".getMsgCode(),urlInfo" + i + ");");
			javaBw.newLine();
		}

		javaBw.newLine();
		javaBw.write("   }");
		javaBw.newLine();
		javaBw.write("}");
		javaBw.close();

	}

	private void createAndroidFile() throws IOException {
		androidBw.write("package com.lgx.libframe.model;");
		androidBw.newLine();
		androidBw.write("import java.util.HashMap;");
		androidBw.newLine();
		androidBw.write("import java.util.Map;");
		androidBw.newLine();
		androidBw.write("public class HttpConstants {");
		androidBw.newLine();
		androidBw.newLine();
		androidBw.write("	public static HashMap<Integer,HttpObj> httpObjs = new HashMap<Integer,HttpObj>();");
		androidBw.newLine();
		// androidBw.write(" public static Integer FILE_UPLOAD=99901;");
		// androidBw.newLine();
		// androidBw.write(" public static Integer FILE_DOWNLOAD=99902;");
		// androidBw.newLine();
		for (int i = 0; i < commands.size(); i++) {

			SimpleWebCommandOperationInfo command = commands.get(i);
			if (command.getMsgCode() == 0) {
				continue;
			}
			String url = command.getUrl().replaceAll("-", "_");
			String commandName = url.substring(url.lastIndexOf("/") + 1, url.length());
			String modularName = url.substring(0, url.lastIndexOf("/"));
			modularName = modularName.substring(modularName.lastIndexOf("/") + 1, modularName.length());
			androidBw.newLine();

			androidBw.write("    public static Integer " + modularName.toUpperCase() + "_" + commandName.toUpperCase() + "=" + command.getMsgCode() + ";");
			androidBw.newLine();
		}
		androidBw.write("      static{ ");

		for (int i = 0; i < commands.size(); i++) {
			SimpleWebCommandOperationInfo command = commands.get(i);
			if (command.getMsgCode() == 0) {
				continue;
			}
			androidBw.newLine();
			androidBw.write("    HttpObj httpObj" + i + "= new HttpObj();");
			androidBw.newLine();
			// androidBw.write(" httpObj" + i + ".setMsgCode("
			// + command.getMsgCode() + ");");
			// androidBw.newLine();
			androidBw.write("    httpObj" + i + ".setUrl(\"" + command.getUrl() + "\");");
			androidBw.newLine();
			androidBw.write("    httpObj" + i + ".setReqMethod(\"" + command.getMethod() + "\");");
			androidBw.newLine();
			// androidBw.write(" urlInfo" + i + ".setOpCode(\""
			// + command.getOpCode() + "\");");
			// androidBw.newLine();
			// androidBw.write(" urlInfo" + i + ".setWorkClass(\""
			// + command.getWorkClass() + "\");");
			// androidBw.newLine();
			String oldRequestClass = command.getMsgReaquest();
			if (oldRequestClass != null && oldRequestClass.length() > 0) {
				String requestClass = "";
				if (requestClass.indexOf("Wrapper") != -1) {
					requestClass = getWrapperBean(requestClass);
				} else {
					requestClass = "com.lgx.libframe.model" + oldRequestClass.substring(oldRequestClass.lastIndexOf("."), oldRequestClass.length());
				}

				androidBw.write("    httpObj" + i + ".setReqObjName(\"" + requestClass + "\");");
			}
			androidBw.newLine();
			// androidBw.write(" urlInfo" + i + ".setRespObjName(\""
			// + command.getReaquestDepict() + "\");");
			// androidBw.newLine();
			String oldRespClass = command.getMsgResponse();
			if (oldRespClass != null && oldRespClass.length() > 0) {
				String respClass = "";
				if (oldRespClass.indexOf("Wrapper") != -1) {
					respClass = getWrapperBean(oldRespClass);
				} else {
					respClass = "com.lgx.libframe.model" + oldRespClass.substring(oldRespClass.lastIndexOf("."), oldRespClass.length());
				}
				if (respClass.contains("JSONObject")) {
					androidBw.write("    httpObj" + i + ".setRespObjName(\"com.lgx.libframe.model.BaseObj\");");
				} else {
					androidBw.write("    httpObj" + i + ".setRespObjName(\"" + respClass + "\");");
				}

			}
			androidBw.newLine();
			// androidBw.write(" urlInfo" + i + ".setResponseDepict(\""
			// + command.getResponseDepict() + "\");");
			// androidBw.newLine();
			String url = command.getUrl().replaceAll("-", "_");
			String commandName = url.substring(url.lastIndexOf("/") + 1, url.length());
			String modularName = url.substring(0, url.lastIndexOf("/"));
			modularName = modularName.substring(modularName.lastIndexOf("/") + 1, modularName.length());
			androidBw.write("    httpObjs.put(" + modularName.toUpperCase() + "_" + commandName.toUpperCase() + ",httpObj" + i + ");");
			androidBw.newLine();
		}

		androidBw.newLine();
		androidBw.write("   }");
		androidBw.newLine();
		androidBw.write("}");
		androidBw.close();
	}

	private String getWrapperBean(String wrapperName) {
		if (wrapperName.contains("FBooleanArrayWrapper")) {
			return "com.farmer.api.bean." + "GbooleanList";
		} else if (wrapperName.contains("FBooleanWrapper")) {
			return "com.farmer.api.bean." + "Gboolean";
		} else if (wrapperName.contains("FIntArrayWrapper")) {
			return "com.farmer.api.bean." + "GintList";
		} else if (wrapperName.contains("FIntWrapper")) {
			return "com.farmer.api.bean." + "Gint";
		} else if (wrapperName.contains("FLongArrayWrapper")) {
			return "com.farmer.api.bean." + "GlongList";
		} else if (wrapperName.contains("FLongWrapper")) {
			return "com.farmer.api.bean." + "Glong";
		} else if (wrapperName.contains("FStringArrayWrapper")) {
			return "com.farmer.api.bean." + "GStringList";
		} else if (wrapperName.contains("StringWrapper")) {
			return "com.farmer.api.bean." + "GString";
		}
		return wrapperName;
	}

	private String firstLowCase(String word) {

		return word.substring(0, 1).toLowerCase() + word.substring(1);
	}

}
