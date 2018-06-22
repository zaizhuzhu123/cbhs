/**
 * <p>文件名称: OutPutAndroidBean.java </p>
 * <p>文件描述: 根据excel中定义的对象信息生成对应的andriod对象。</p>
 * <p>版权所有: 版权所有(C)2016-2026</p>
 * <p>公    司:  </p>
 * <p>内容摘要: </p>
 * <p>其他说明: 无</p>
 * <p>创建日期：2016-01-10</p>
 * <p>完成日期：2016-01-10</p>
 * <p>修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容</p>
 * <pre>
 *    修改日期： 2017-4-28
 *    版 本 号：  
 *    修 改 人：  袁瑞宏
 *    修改内容：  将根据属性生成相关代码的功能分拆出去。 (例如：  private  get和set方法)
 * </pre>
 * <p>修改记录2：…</p>
 * @version 1.0
 * @author 袁瑞宏
 */

package com.cbhs.gencode.api.task.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

import com.cbhs.gencode.api.task.MagicConstant;
import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.FileImpl;
import com.cbhs.gencode.api.task.entity.ProtoObj;
import com.cbhs.gencode.api.task.process.bean.FiledObjWriteUtil;
import com.cbhs.gencode.api.task.process.bm.LongCode;

public class OutPutAndroidBean extends AbstractProcess {

	private static final String androidModelDir = "..\\app\\Accounting\\libframe\\src\\main\\java\\com\\lgx\\libframe\\model";

	private ArrayList<String> getterSetter = new ArrayList<String>();
	private ArrayList<String> properties = new ArrayList<String>();
	private ArrayList<FieldObj> bmInfos = new ArrayList<FieldObj>();
	private String targetDir = null;
	private BufferedWriter bw = null;
	private String curFileName = null;
	protected boolean hasArray = false;
	// private boolean hasByteArray = false; //是否有byte[]的数据类型。
	private static int allindex = 0;
	protected int index = 0;
	protected List<Long> codeList = new ArrayList<Long>();
	private boolean isBean;

	public OutPutAndroidBean(String dir) throws IOException {

		File direc = new File(dir + androidModelDir);
		if (!direc.exists()) {
			direc.mkdir();
		}
		allindex++;
		this.targetDir = dir + androidModelDir;
		File dirFile = new File(targetDir);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
	}

	public Iterator<ILevelObj> processFile(final FileImpl ifile, int index) throws Exception {

		codeList = LongCode.longCodes.get(index + "");
		if (codeList == null) {
			codeList = LongCode.longCodes.get("1");
		}
		if (ifile.getFileName() != null && ifile.getFileName().indexOf("_Proto") != -1) {
			// packageName = fileName.substring(0, fileName.indexOf("_Proto"))
			// .toLowerCase();
			isBean = true;
		} else {
			// packageName = "url";
		}
		return super.processFile(ifile, index);

	}

	public Iterator<ILevelObj> processProto(final ProtoObj proto, int index) throws Exception {
		String tableName = proto.getTableName();
		curFileName = tableName;
		if (tableName.indexOf("(") != -1) {
			curFileName = tableName.substring(0, tableName.indexOf("("));
		}

		String targetFile = targetDir + File.separator + curFileName;

		File mFile = new File(targetFile + ".java");
		if (!mFile.exists()) {
			mFile.createNewFile();
		}
		hasArray = false;

		this.bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mFile), "UTF-8"));
		bw.write("package com.lgx.libframe.model;");
		bw.newLine();

		this.index = index;
		return super.processProto(proto, index);

	}

	@Override
	public void endFiled(FieldObj field) throws Exception {

		String type = field.getType();
		// 这种类型不用处理。
		if (type.equals("FClntEnvData"))
			return;
		if (type.contains("MultipartFile"))
			return;
		if (field.isList()) {
			this.hasArray = true;
		}

		if (isBean) {
			FiledObjWriteUtil.generatorPrivateByAndriodBean(properties, field);
		} else {
			FiledObjWriteUtil.generatorPrivateByAndriodUrl(properties, field);
		}
		FiledObjWriteUtil.generatorGetAndSetByAndriod(getterSetter, field);

		/*
		 * String ListType = ""; if (type.toLowerCase().equals("int32")) { type = "private int " + field.getFieldName(); ListType = "Integer";
		 * 
		 * } else if (type.toLowerCase().equals("int64")) { type = "private long " + field.getFieldName(); ListType = "Long"; } else if (type.toLowerCase().equals("string")) { type =
		 * "private String  " + field.getFieldName(); ListType = "String"; } else if (type.toLowerCase().equals("double")) { type = "private double " + field.getFieldName(); ListType = "Double"; }
		 * else if (type.toLowerCase().equals("boolean")) { type = "private  boolean " + field.getFieldName(); ListType = "Boolean"; } else if (type.toLowerCase().equals("byte[]")) { type =
		 * "private  String " + field.getFieldName(); ListType = "byte[]"; }else { ListType = type; type = "private  " + type + "  " + field.getFieldName();
		 * 
		 * } if (field.isList()) { type = "private List<" + ListType + ">" + field.getFieldName() + "= new ArrayList<" + ListType + ">();"; } properties.add(type + ";");
		 * 
		 * String filedName = field.getFieldName(); String filedNameFistUpCase = filedName.substring(0, 1).toUpperCase() + filedName.substring(1, filedName.length()); createGetAndSet(ListType,
		 * field.getFieldName(), filedNameFistUpCase, field.isList());
		 */

		String bmInfo = field.getBmInfo();
		if (bmInfo != null) {
			if (bmInfo.trim().length() > 0) {
				this.bmInfos.add(field);
			}
		}

	}

	@Override
	public void endProto(ProtoObj proto) throws Exception {
		if (hasArray) {
			bw.newLine();
			bw.write("import java.util.*;");
		}
		bw.write("import java.util.List;");
		bw.newLine();
		bw.write("import java.util.ArrayList;");
		bw.newLine();
		bw.newLine();
		bw.write("import java.io.Serializable;");
		bw.newLine();
		bw.write("import com.lgx.libframe.*;");
		bw.newLine();
		bw.write("public class " + curFileName + " implements Serializable{");
		bw.newLine();
		bw.write("private static final long serialVersionUID = " + codeList.get(index) + "L;");
		// 处理编码信息，因为其有可能加上import信息。
		for (FieldObj field : bmInfos) {
			this.addBmField(field);
		}
		bmInfos.clear();

		bw.newLine();

		for (String property : properties) {
			bw.newLine();
			bw.write(property);
		}
		properties.clear();

		for (String GSString : getterSetter) {
			if (GSString.indexOf("subTypedescript") != -1) {
				System.out.println(GSString);
			}
			bw.newLine();
			bw.write(GSString);
		}
		getterSetter.clear();

		bw.newLine();

		bw.newLine();
		bw.write("}");
		bw.close();
	}

	@Override
	public void finish() throws Exception {
		index++;
	}

	/***
	 * 生成增加的编码proto字段。
	 * 
	 * @param field
	 * @throws IOException
	 */
	protected void addBmField(FieldObj field) throws IOException {

		String bmInfo = field.getBmInfo().trim();
		StringBuffer sb = new StringBuffer();

		Matcher mm = MagicConstant.InfoPattern.matcher(bmInfo);
		if (mm.find()) {
			// 说明是关联表
			String beanName = mm.group(1);
			String fieldName = mm.group(2);
			fieldName = field.getFieldName() + MagicConstant.suffix_descript;
			sb.append("private String   " + fieldName);

			String filedName = fieldName;
			String filedNameFistUpCase = filedName.substring(0, 1).toUpperCase() + filedName.substring(1, filedName.length());
			createGetAndSet("String", fieldName, filedNameFistUpCase, false);
		} else {
			mm = MagicConstant.relatinTablePattern.matcher(bmInfo);
			if (mm.find()) {
				// 说明是关联表
				String beanName = mm.group(1);
				String viewField = mm.group(2);
				sb.append("private  " + beanName + "   " + viewField);

				String filedName = viewField;
				String filedNameFistUpCase = filedName.substring(0, 1).toUpperCase() + filedName.substring(1, filedName.length());
				createGetAndSet(beanName, viewField, filedNameFistUpCase, false);
			} else {
				// 说明是码表。
				String fieldName = field.getFieldName() + MagicConstant.suffix_descript;
				sb.append("private String  " + fieldName);

				String filedName = fieldName;
				String filedNameFistUpCase = filedName.substring(0, 1).toUpperCase() + filedName.substring(1, filedName.length());
				createGetAndSet("String", filedName, filedNameFistUpCase, false);

			}
		}

		this.properties.add(sb.toString() + ";");

	}

	protected void createGetAndSet(String type, String fieldName, String filedNameFistUpCase, boolean isList) {
		String GSInfo = null;
		if (fieldName.equalsIgnoreCase("subTypedescript")) {
			System.out.println(type);
		}

		GSInfo = "public " + type + "  get" + filedNameFistUpCase + "(){ \n" + "    return this." + fieldName + ";\n" + "}\n";
		GSInfo += "public void set" + filedNameFistUpCase + "(" + type + " " + fieldName + "){\n" + "    this." + fieldName + "=" + fieldName + ";\n" + "}\n";

		if (isList) {

			GSInfo = "public List<" + type + ">" + "  get" + filedNameFistUpCase + "(){\n" + "    return this." + fieldName + ";\n" + "}\n";
			GSInfo += "public void set" + filedNameFistUpCase + "(List<" + type + "> " + fieldName + "){\n" + "    this." + fieldName + "=" + fieldName + ";\n" + "}\n";
		}
		if (GSInfo != null) {
			this.getterSetter.add(GSInfo);
		}

	}

}
