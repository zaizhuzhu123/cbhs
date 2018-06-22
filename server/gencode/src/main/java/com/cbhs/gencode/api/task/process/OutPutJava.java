/**
 * <p>
 * 文件名称: OutPutJava.java
 * </p>
 * <p>
 * 文件描述: RM文件生成处理器
 * </p>
 * <p>
 * 版权所有: 版权所有(C)2016-2026
 * </p>
 * <p>
 * 公 司:
 * </p>
 * <p>
 * 内容摘要: 生成的对象，用于MDB模块使用实体bean时的直接引用。
 * </p>
 * <p>
 * 其他说明: 无
 * </p>
 * <p>
 * 创建日期：2016-11-8
 * </p>
 * <p>
 * 完成日期：2016-11-8
 * </p>
 * <p>
 * 修改记录1: // 修改历史记录，包括修改日期、修改者及修改内容
 * </p>
 * 
 * <pre>
 *    修改日期： 
 *    版 本 号：
 *    修 改 人：
 *    修改内容：
 * </pre>
 * <p>
 * 修改记录2：…
 * </p>
 * 
 * @version 1.0
 * @author 袁瑞宏
 */
package com.cbhs.gencode.api.task.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;

import com.cbhs.gencode.api.task.MagicConstant;
import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.FileImpl;
import com.cbhs.gencode.api.task.entity.ProtoObj;
import com.cbhs.gencode.api.util.Pair;
import com.cbhs.gencode.api.util.iterable.PrefetchingIterator;

public class OutPutJava extends AbstractProcess {
	private BufferedWriter bw = null;
	private ArrayList<String> dom = new ArrayList<String>();
	private StringBuffer curCode = null;
	// 为了生成的代码好看，每4列字段信息进行换行。
	private int columnCount = 0;
	private Pair<String, String> keyInfos = null;
	private static final String DIR = File.separator + "0.gen_code" + File.separator + "base_api" + File.separator + "src" + File.separator + "main" + File.separator + "java" + File.separator + "com" + File.separator + "myhz" + File.separator + "api" + File.separator + "r";

	public OutPutJava(String targetDir) throws IOException {
		File direc = new File(targetDir + DIR);
		if (!direc.exists()) {
			direc.mkdir();
		}
		String targetFile = targetDir + DIR + File.separator + "RM.java";
		File dir = new File(targetDir + DIR);
		if (!dir.exists()) {
			dir.mkdirs();
		}
		File sqlFile = new File(targetFile);
		if (!sqlFile.exists()) {
			sqlFile.createNewFile();
		}
		this.bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sqlFile), "UTF-8"));
	}

	public void finish() throws Exception {
		bw.write("}");
		bw.newLine();
		bw.write("	public   static   Pair<String,Boolean>   getBeanModelDesc(String name){");
		bw.newLine();
		bw.newLine();
		bw.newLine();
		for (String sb : dom) {
			bw.write(sb.toString());
			bw.newLine();
			bw.newLine();
		}
		bw.newLine();
		bw.write("return null;");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();
		bw.newLine();
		bw.newLine();
		bw.write("}");
		bw.write("");
		bw.close();
	}

	public Iterator<ILevelObj> processFile(final FileImpl ifile, int index) throws Exception {
		if (index == 0) {
			bw.write("package com.myhz.api.r;");
			bw.newLine();
			bw.write("import java.util.HashMap;");
			bw.newLine();
			bw.write("import com.myhz.api.util.Pair;");
			bw.newLine();
			bw.newLine();
			bw.write("public class RM {");
			bw.newLine();
			bw.newLine();
			bw.write("	public  static  final HashMap<String,Boolean>  tableInfos=new  HashMap();");
			bw.newLine();
			bw.write(" static{ ");
		}
		return new PrefetchingIterator<ILevelObj>() {
			Iterator<ILevelObj> iterator = ifile.getChildren();

			protected ILevelObj fetchNextOrNull() {
				while (iterator.hasNext()) {
					ProtoObj proto = (ProtoObj) iterator.next();
					if (proto.toString().startsWith("ui")) {
						continue;
					} else if (proto.toString().startsWith(MagicConstant.suffix_simpleRequest)) {
						continue;
					} else if (proto.toString().startsWith(MagicConstant.suffix_Farmer)) {
						continue;
					} else {
						return proto;
					}
				}
				return null;
			}
		};
	}

	@Override
	public Iterator<ILevelObj> processProto(ProtoObj proto, int index) throws Exception {
		columnCount = 0;
		keyInfos = new Pair<String, String>("", "");
		curCode = new StringBuffer();
		if (index == 0) {
			curCode.append("  	  if(name.equals(R.BeanNames.");
		} else {
			curCode.append("  	 else if(name.equals(R.BeanNames.");
		}
		curCode.append(proto.getTableName());
		curCode.append(")){\n");
		curCode.append(" return   new Pair(");
		curCode.append("\r\n");
		return super.processProto(proto, index);
	}

	@Override
	public void endProto(ProtoObj proto) throws Exception {
		String temp = curCode.toString();
		temp = temp.substring(0, temp.length() - 1);
		temp = temp + ";\"+\r\n";
		String keys = keyInfos.other();
		if (keys.length() > 0) {
			keys = keys.substring(0, keys.length() - 1);
			if (this.keyInfos.first().equals("a")) {
				temp = temp + "			        \"keyField=" + keys + "\",";
				bw.write("tableInfos.put(R.BeanNames." + proto.getTableName() + ",true);");
			} else {
				temp = temp + "			        \"keyField=" + keys + "\",";
				bw.write("tableInfos.put(R.BeanNames." + proto.getTableName() + ",false);");
			}
		}
		temp += "tableInfos.get(name));";
		temp += "\r\n }";
		dom.add(temp);
		bw.newLine();
	}

	@Override
	public Iterator<ILevelObj> processFiled(FieldObj field, int index) throws Exception {
		if (index == 0) {
			curCode.append("			\"fields=");
		}
		if (!field.isField()) {
			return super.processFiled(field, index);
		}
		if (columnCount < 4) {
			appendFiledInfo(field);
		} else {
			curCode.append("\"+");
			curCode.append("\r\n");
			columnCount = 0;
			curCode.append("			        \"");
			appendFiledInfo(field);
		}
		String first = null;
		String other = null;
		if (field.getPrimaryKey().equals("a")) {
			// 自增长主键
			first = this.keyInfos.first();
			first = "a";
			other = this.keyInfos.other();
			other = other + index + ",";
			keyInfos = new Pair(first, other);
		} else if (field.getPrimaryKey().equals("t")) {
			first = this.keyInfos.first();
			other = this.keyInfos.other();
			other = other + index + ",";
			keyInfos = new Pair(first, other);
		}
		columnCount++;
		return super.processFiled(field, index);
	}

	private void appendFiledInfo(FieldObj field) {
		String sqlType = null;
		String type = field.getType();
		if (type.toLowerCase().equals("int32")) {
			sqlType = "1";
		} else if (type.toLowerCase().equals("int64")) {
			sqlType = "4";
		} else if (type.toLowerCase().equals("string")) {
			sqlType = "0";
		} else if (type.toLowerCase().equals("double")) {
			sqlType = "2";
		} else {
			sqlType = type;
		}
		String bmInfo = field.getBmInfo();
		if (bmInfo.trim().length() == 0) {
			curCode.append(field.getFieldName() + "|" + field.toString() + "|" + sqlType + "|null,");
		} else {
			curCode.append(field.getFieldName() + "|" + field.toString() + "|" + sqlType + "|" + bmInfo + ",");
		}
	}
}