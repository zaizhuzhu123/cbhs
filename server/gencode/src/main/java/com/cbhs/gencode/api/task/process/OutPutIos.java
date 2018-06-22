package com.cbhs.gencode.api.task.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.regex.Matcher;

import com.cbhs.gencode.api.task.MagicConstant;
import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.FileImpl;
import com.cbhs.gencode.api.task.entity.NewFieldObj;
import com.cbhs.gencode.api.task.entity.ProtoObj;

/***
 * 生成excel中定义的每个对象其对应的ios对象。
 * 
 * @author 袁瑞宏
 *
 */
public class OutPutIos extends AbstractProcess {

	public static final String iosBeanDir = File.separator + "4.ios\\YiQuTong\\YiQuTong\\Model";

	public static final String iosModelDir = File.separator + "4.ios\\YiQuTong\\YiQuTong\\Model";

	private static final String template = "#import \"*.h\"    \r\n@implementation  *    \n";

	private ArrayList<String> imports = new ArrayList<String>();
	private ArrayList<String> properties = new ArrayList<String>();
	private ArrayList<FieldObj> bmInfos = new ArrayList<FieldObj>();
	private ArrayList<String> calssNames = new ArrayList<String>();
	private ArrayList<String> propertieNames = new ArrayList<String>();
	private String targetDir = null;
	private BufferedWriter bwH = null;
	private BufferedWriter bwM = null;
	private String curFileName = null;
	private int arrayCount = 0;
	private boolean isBean;

	public OutPutIos(String dir) throws IOException {

		File direc = new File(dir + iosBeanDir);
		if (!direc.exists()) {
			direc.mkdir();
		}

		this.targetDir = dir + iosBeanDir;
		File dirFile = new File(targetDir);
		if (!dirFile.exists()) {
			dirFile.mkdirs();
		}
	}

	public Iterator<ILevelObj> processFile(final FileImpl ifile, int index) throws Exception {
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

		curFileName = proto.getTableName();

		String targetFile = targetDir + File.separator + curFileName;

		// 一、先生成m文件：
		File mFile = new File(targetFile + ".m");
		if (!mFile.exists()) {
			mFile.createNewFile();
		}
		this.bwM = new BufferedWriter(new FileWriter(mFile));
		String temp = template.replace("*", curFileName);
		bwM.write(temp);

		// 二、再生成h头文件：
		File hFile = new File(targetFile + ".h");
		if (!hFile.exists()) {
			hFile.createNewFile();
		}
		this.bwH = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(hFile), "UTF-8"));

		return super.processProto(proto, index);

	}

	@Override
	public void endFiled(FieldObj field) throws Exception {

		String type = field.getType();
		String sourceType = "";
		String className = "";
		// 这种类型不用处理。
		if (type.equals("FClntEnvData"))
			return;

		String importInfo = null;
		if (type.toLowerCase().equals("int32")) {
			type = "@property (nonatomic,assign) int " + field.getFieldName();
			sourceType = "NSNumber";
		} else if (type.toLowerCase().equals("int64")) {
			type = "@property (nonatomic,assign) long long " + field.getFieldName();
			sourceType = "NSNumber";
		} else if (type.toLowerCase().equals("string")) {
			type = "@property (nonatomic,strong) NSString  *" + field.getFieldName();
			sourceType = "NSString";
		} else if (type.toLowerCase().equals("double")) {
			type = "@property (nonatomic,assign) double " + field.getFieldName();
			sourceType = "NSNumber";
		} else if (type.toLowerCase().equals("float")) { // 20170717
															// 增加，因为以前没有针对float的处理。
			type = "@property (nonatomic,assign) float " + field.getFieldName();
			sourceType = "NSNumber";
		} else if (type.toLowerCase().equals("boolean")) {
			type = "@property (nonatomic,assign) bool " + field.getFieldName();
			sourceType = "NSNumber";
		} else if (type.toLowerCase().equals("byte[]")) {
			type = "@property (nonatomic,strong) NSString  *" + field.getFieldName();
			sourceType = "NSString";
		} else {
			// importInfo = "#import \"" + type + ".h\"";
			importInfo = "@class  " + type + ";";
			sourceType = type;
			// className = "+(id)" + field.getFieldName() + "_class{\n" +
			// "return [" + type + " class];\n" + "}";
			className = "		@\"" + field.getFieldName() + "\"" + " : @\"" + type + "\"";
			type = "@property (nonatomic,strong)  " + type + "  *" + field.getFieldName();

		}
		// 做了这么多，如果是一个数组，则上边的都白做了，因为ios没有java哪样的范型.
		if (field.isList()) {
			type = "@property (nonatomic,strong) NSMutableArray *" + field.getFieldName();

			// importInfo="#import \""+sourceType+".h\"";

			// bwM.write("+(id)" + field.getFieldName() + "_class{\n" + "return
			// [" + sourceType + " class];\n" + "}");
			// bwM.write("- (NSDictionary *)objectClassInDictionary{return
			// @{@\"" + field.getFieldName() + "\" : @\"" + sourceType +
			// "\"};}");
			calssNames.add(className);
		} else if (className.length() > 0) {
			calssNames.add(className);
		}
		if (isBean) {
			properties.add(type + ";" + "// " + field.getName());
		} else {
			NewFieldObj newField = (NewFieldObj) field;
			String fieldMsg = null;
			try {
				fieldMsg = newField.getFielValue(9);
			} catch (Exception e) {
			}
			boolean isRequired = false;
			try {
				String jsr303 = newField.getFielValue(10);
				if (jsr303.contains("@NotBlank") || jsr303.contains("@NotNull")) {
					isRequired = true;
				}
			} catch (Exception e) {
			}
			properties.add(type + ";" + (fieldMsg != null ? ("// " + fieldMsg) : ("")) + (isRequired ? "(必填)" : ""));
		}
		propertieNames.add(field.getFieldName());

		if (importInfo != null) {
			this.imports.add(importInfo);
		}

		String bmInfo = field.getBmInfo();
		if (bmInfo != null) {
			if (bmInfo.trim().length() > 0) {
				this.bmInfos.add(field);
			}
		}

	}

	@Override
	public void endProto(ProtoObj proto) throws Exception {
		// 处理编码信息，因为其有可能加上import信息。
		for (FieldObj field : bmInfos) {
			this.addBmField(field);
		}
		bmInfos.clear();

		bwH.newLine();
		bwH.write("#import \"BaseObj.h\"");
		for (String importString : imports) {
			bwH.newLine();
			bwH.write(importString);
		}
		imports.clear();

		bwH.newLine();
		bwH.newLine();
		bwH.write("@interface " + curFileName + " :BaseObj");
		bwH.newLine();

		for (String property : properties) {
			bwH.newLine();
			bwH.write(property);
		}
		properties.clear();

		bwH.newLine();

		bwH.newLine();
		bwH.write("@end");
		bwH.close();
		if (calssNames != null && calssNames.size() > 0) {
			bwM.write("- (NSDictionary *)objectClassInDictionary{");
			bwM.newLine();
			bwM.write("		return @{");
			// for (int i = 0; i < propertieNames.size(); i++) {
			// String propertyName = propertieNames.get(i);
			// bwM.write(propertyName);
			// if (i == propertieNames.size() - 1) {
			// bwM.write(";");
			// } else {
			// bwM.write(",");
			// }
			// }
			bwM.newLine();
			for (int i = 0; i < calssNames.size(); i++) {
				boolean islast = (i == calssNames.size() - 1);
				String calssName = calssNames.get(i);
				bwM.write("		" + calssName + (!islast ? "," : ""));
				bwM.newLine();
			}
			bwM.write("		};");
			bwM.newLine();
			bwM.write(" }");
			// for (int i = 0; i < calssNames.size(); i++) {
			// String calssName = calssNames.get(i);
			// bwM.write(calssName);
			// bwM.newLine();
			// }
			bwM.newLine();
		}

		/*
		 * if(arrayCount>0){ bwM.write("+(id)NSMutableArray+_class{\n" +
		 * "return [NSMutableArray class];\n" +"}");
		 * http://ios.china.ios-store.com/app/save.asp?u=a@qq.com&p=vv }
		 */

		calssNames.clear();
		propertieNames.clear();

		bwM.write("@end");
		bwM.close();
	}

	@Override
	public void finish() throws Exception {

	}

	/***
	 * 生成增加的编码proto字段。
	 * 
	 * @param field
	 * @throws IOException
	 */
	private void addBmField(FieldObj field) throws IOException {

		String bmInfo = field.getBmInfo().trim();
		StringBuffer sb = new StringBuffer();

		Matcher mm = MagicConstant.InfoPattern.matcher(bmInfo);
		if (mm.find()) {
			// 说明是关联表
			String beanName = mm.group(1);
			String fieldName = mm.group(2);
			fieldName = field.getFieldName() + MagicConstant.suffix_descript;
			sb.append("@property (nonatomic,strong) NSString  *" + fieldName);

		} else {
			mm = MagicConstant.relatinTablePattern.matcher(bmInfo);
			if (mm.find()) {
				// 说明是关联表
				String beanName = mm.group(1);
				String viewField = mm.group(2);
				// sb.append(" optional "+beanName+" "+viewField);
				sb.append("@property (nonatomic,strong) " + beanName + "   *" + viewField);

				String importInfo = "#import \"" + beanName + ".h\"";
				this.imports.add(importInfo);

			} else {
				// 说明是码表。
				String fieldName = field.getFieldName() + MagicConstant.suffix_descript;
				sb.append("@property (nonatomic,strong) NSString  *" + fieldName);

			}
		}

		this.properties.add(sb.toString() + ";");

	}

}
