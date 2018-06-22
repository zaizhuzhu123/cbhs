package com.cbhs.gencode.api.task.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

import org.apache.commons.lang3.StringUtils;

import com.cbhs.gencode.api.task.MagicConstant;
import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.FileImpl;
import com.cbhs.gencode.api.task.entity.NewFieldObj;
import com.cbhs.gencode.api.task.entity.ProtoObj;
import com.cbhs.gencode.api.task.process.bean.FiledObjWriteUtil;

public class OutPutJavaBean extends AbstractProcess {

	private static String javaModelDir = "\\cbhs\\src\\main\\java\\com\\server\\pojo\\";

	private ArrayList<String> getterSetter = new ArrayList<String>();
	private ArrayList<String> properties = new ArrayList<String>();
	private ArrayList<FieldObj> bmInfos = new ArrayList<FieldObj>();
	private String targetDir = null;
	private BufferedWriter bw = null;
	private String packageName = null;
	public String curFileName = null;
	public String descName = null;
	private boolean isBean;
	boolean dbBean = true;
	protected boolean hasArray = false;
	// private boolean hasByteArray = false; //是否有byte[]的数据类型。
	protected int index = 0;
	protected List<Long> codeList = new ArrayList<Long>();
	private String fileName;
	private String targetDir_proto = null;

	public OutPutJavaBean(String dir) throws IOException {
		File direc = new File(dir + javaModelDir);
		if (!direc.exists()) {
			direc.mkdir();
		}
		// allindex++;
		this.targetDir_proto = dir + javaModelDir;
		File dirFile = new File(targetDir_proto);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}

	}

	public Iterator<ILevelObj> processFile(final FileImpl ifile, int index) throws Exception {
		this.targetDir = this.targetDir_proto;
		String fileName = ifile.getFileName();
		if (fileName != null && fileName.indexOf("_Proto") != -1) {
			// packageName = fileName.substring(0, fileName.indexOf("_Proto"))
			// .toLowerCase();
			isBean = true;
		} else {
			// packageName = "url";
		}
		// targetDir += packageName;
		if (isBean) {
			packageName = "bean";
			targetDir += packageName;
		} else {
			if (ifile.getFileName() != null && ifile.getFileName().contains("_url")) {
				this.fileName = ifile.getFileName().substring(0, ifile.getFileName().indexOf("("));
			}
			packageName = "url";
			targetDir += packageName + (this.fileName != null ? (File.separator + this.fileName) : "");
		}

		return super.processFile(ifile, index);

	}

	public Iterator<ILevelObj> processProto(final ProtoObj proto, int index) throws Exception {
		String tableName = proto.getTableName();
		descName = null;
		curFileName = tableName;
		if (tableName.indexOf("(") != -1) {
			curFileName = tableName.substring(0, tableName.indexOf("("));
			descName = tableName.substring(tableName.indexOf("(") + 1, tableName.indexOf(")"));
		}
		if (curFileName.startsWith("G") || curFileName.startsWith("ui") || curFileName.startsWith("Farmer") || curFileName.startsWith("Request") || curFileName.startsWith("Response")) {
			dbBean = false;
		} else {
			dbBean = true;
		}
		File dirFile = new File(targetDir);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
		String targetFile = targetDir + File.separator + curFileName;

		File mFile = new File(targetFile + ".java");
		if (!mFile.exists()) {
			mFile.createNewFile();
		}
		hasArray = false;
		// hasByteArray=false;
		this.bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mFile), "UTF-8"));
		if (isBean) {
			bw.write("package com.server.pojo." + packageName + ";");
		} else {
			bw.write("package com.server.pojo." + packageName + "." + this.fileName + ";");
		}

		bw.newLine();

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
		// if(field.getType().equals("byte[]")){
		// this.hasByteArray=true;
		// }
		if (isBean) {
			FiledObjWriteUtil.generatorPrivateByMYHZ(properties, field);
		} else {
			if (dbBean) {
				FiledObjWriteUtil.generatorPrivateByServerDaoBean(properties, field);
			} else {
				FiledObjWriteUtil.generatorPrivateByServer(properties, field);
			}
		}
		FiledObjWriteUtil.generatorGetAndSetByServer(getterSetter, field, dbBean);

		/*
		 * String filedName = field.getFieldName(); String filedNameFistUpCase = filedName.substring(0, 1).toUpperCase() + filedName.substring(1, filedName.length()); String smalllType = ""; String
		 * objType = ""; if (type.toLowerCase().equals("int32")) { smalllType = "int"; objType = "Integer"; } else if (type.toLowerCase().equals("int64")) { smalllType = "long"; objType = "Long"; }
		 * else if (type.toLowerCase().equals("string")) { smalllType = "String"; objType = "String"; } else if (type.toLowerCase().equals("double")) { smalllType = "double"; objType = "Double"; }else
		 * if (type.toLowerCase().equals("boolean")) { smalllType = "boolean"; objType = "Boolean"; }else { smalllType = type; objType = type; } if (field.isList()) {
		 * properties.add("private List<"+objType+ "> "+ filedName+ ";"); }else{ properties.add("private "+smalllType+ " "+ filedName+ ";"); }
		 * 
		 * 
		 * createGetAndSet(smalllType, objType,field.getFieldName(), filedNameFistUpCase, field.isList());
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
		// if (hasArray) {
		// bw.write("import java.util.List;");
		// bw.write("import java.util.ArrayList;");
		// }
		bw.write("import java.util.List;");
		bw.newLine();
		bw.write("import java.util.ArrayList;");
		bw.newLine();
		bw.write("import java.io.Serializable;");
		bw.newLine();
		bw.write("import io.swagger.annotations.ApiModelProperty;");
		if (isBean) {

			bw.newLine();
			bw.write("import com.server.pojo.bean.*;");
			bw.newLine();
			bw.write("import javax.persistence.*;");
			bw.newLine();
			bw.write("import java.math.BigDecimal;");
			bw.newLine();
			bw.write("import org.hibernate.annotations.Fetch;");
			bw.newLine();
			bw.write("import org.hibernate.annotations.FetchMode;");
			bw.newLine();
			bw.write("import org.hibernate.annotations.GenericGenerator;");
			bw.newLine();
			bw.write("import com.fasterxml.jackson.annotation.JsonIgnoreProperties;");
			bw.newLine();
			bw.write("import com.fasterxml.jackson.databind.annotation.JsonSerialize;");
			bw.newLine();
			bw.write("import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;");
			bw.newLine();
			bw.write("import com.alibaba.fastjson.annotation.JSONField;");
			bw.newLine();
			bw.write("import org.hibernate.annotations.DynamicUpdate;");
			bw.newLine();
			bw.write("import org.hibernate.annotations.DynamicInsert;");
			bw.newLine();
			bw.write("import io.swagger.annotations.ApiModelProperty;");
			bw.newLine();
			bw.write("import io.swagger.annotations.ApiModel;");

			/*
			 * if(hasByteArray){ bw.write("import java.io.IOException;"); bw.newLine(); bw.write("import sun.misc.BASE64Decoder;"); bw.newLine(); }
			 */
			if (curFileName.startsWith("G") || curFileName.startsWith("ui") || curFileName.startsWith("Farmer") || curFileName.startsWith("Request") || curFileName.startsWith("Response")) {
			} else {
				bw.newLine();
				bw.newLine();
				bw.write("@DynamicUpdate");
				bw.newLine();
				bw.write("@DynamicInsert");
				bw.newLine();
				bw.write("@Entity");
				bw.newLine();
				bw.write("@Table(name = \"" + curFileName + "\")");
				bw.newLine();
				bw.write("@JsonIgnoreProperties({\"hibernateLazyInitializer\", \"handler\"})");
			}
			if (StringUtils.isNoneBlank(descName)) {
				bw.newLine();
				bw.write("@ApiModel(value=\"" + descName + "对象\",description=\"" + descName + "对象\")");
			}
		} else {
			bw.newLine();
			bw.write("import com.server.pojo.bean.*;");
			bw.newLine();
			bw.write("import javax.validation.constraints.*;");
			bw.newLine();
			bw.write("import java.math.BigDecimal;");
			bw.newLine();
			bw.write("import org.hibernate.validator.constraints.*;");
		}
		bw.newLine();
		bw.write("public class " + curFileName + " implements Serializable {");
		bw.newLine();
		bw.write("	private static final long serialVersionUID = 1L;");
		// 处理编码信息，因为其有可能加上import信息。
		for (FieldObj field : bmInfos) {
			this.addBmField(field);
		}
		bmInfos.clear();
		for (String property : properties) {
			bw.newLine();
			bw.write(property);
		}
		properties.clear();
		bw.newLine();
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
			// sb.append(" \nprivate String " + fieldName);
			sb.append("\r\n");
			sb.append("	private String " + fieldName);
			String filedName = fieldName;
			String filedNameFistUpCase = filedName.substring(0, 1).toUpperCase() + filedName.substring(1, filedName.length());
			createGetAndSet("String", "String", fieldName, filedNameFistUpCase, false);
		} else {
			mm = MagicConstant.relatinTablePattern.matcher(bmInfo);
			if (mm.find()) {
				// 说明是关联表
				String beanName = mm.group(1);
				String viewField = mm.group(2);
				sb.append("\r\n");
				sb.append("	private " + beanName + " " + viewField);

				String filedName = viewField;
				String filedNameFistUpCase = filedName.substring(0, 1).toUpperCase() + filedName.substring(1, filedName.length());
				createGetAndSet(beanName, beanName, viewField, filedNameFistUpCase, false);
			} else {
				// 说明是码表。
				String fieldName = field.getFieldName() + MagicConstant.suffix_descript;
				// sb.append("@Transient \nprivate String " + fieldName);
				sb.append("\r\n");
				sb.append("	private String  " + fieldName);
				String filedName = fieldName;
				String filedNameFistUpCase = filedName.substring(0, 1).toUpperCase() + filedName.substring(1, filedName.length());
				createGetAndSet("String", "String", filedName, filedNameFistUpCase, false);

			}
		}

		this.properties.add(sb.toString() + ";");

	}

	protected void createGetAndSet(String type, String objType, String fieldName, String filedNameFistUpCase, boolean isList) {
		String GSInfo = null;
		if (fieldName.equalsIgnoreCase("subTypedescript")) {
			System.out.println(type);
		}

		GSInfo = "	public void set" + filedNameFistUpCase + "(" + type + " " + fieldName + "){\n" + "    this." + fieldName + "=" + fieldName + ";\n" + "	}\n\n";
		if (isList) {
			hasArray = true;
			GSInfo = "	public void set" + filedNameFistUpCase + "(List<" + objType + "> " + fieldName + "){\n" + "    this." + fieldName + "=" + fieldName + ";\n" + "	}\n\n";
			GSInfo += "	public List<" + objType + ">" + "  get" + filedNameFistUpCase + "(){\n" + "    return this." + fieldName + ";\n" + "	}\n";
		} else {
			GSInfo += "	public " + type + "  get" + filedNameFistUpCase + "(){ \n" + "    return this." + fieldName + ";\n" + "	}\n";
		}
		if (GSInfo != null) {
			this.getterSetter.add(GSInfo);
		}
	}

	private String getJSONMethodName(String type, String getPrefix) {
		if (type.equals("int")) {
			return getPrefix + ".getIntValue";

		} else if (type.equals("long")) {
			return getPrefix + ".getLongValue";
		} else if (type.equals("String")) {
			return getPrefix + ".getString";
		} else if (type.equals("double")) {
			return getPrefix + ".getDoubleValue";
		} else if (type.equals("boolean")) {
			return getPrefix + ".getBooleanValue";
		} else {
			return "(" + type + ")" + getPrefix + ".get";
		}
	}

}
