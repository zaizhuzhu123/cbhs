package com.cbhs.gencode.api.task.entity;

import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.api.IObjProcess;
import com.cbhs.gencode.api.task.process.OutPutJavaBean;

public class FieldObj implements ILevelObj {

	private static final Pattern InfoPattern = Pattern
			.compile("(optional|repeated)\\s*(\\S*)\\s*(\\S*)");
	/**
	 * 
	 */
	private String fieldName = null;
	private String type = null;
	private boolean isList = false;
	private String primaryKey = null;
	private String name = null;
	private boolean isField = false;
	/** 2015-12-3 增加字段对应的码表功能 **/
	private String bmInfo = null;
	private String fInfo3 = null;
	private String tableName = null;
	private String hibernateKey = null;
	private String hibernateGenerate = null;
	private String hibernateLength = null;
	private String hibernateNullable = null;
	private String hibernateUnique = null;
	private String hibernateTransient = null;

	public FieldObj() {

	}

	public FieldObj(String f1, String f2, String f, boolean f3, String f4,
			String f5, boolean f6, String f7, String tableName, String f8,
			String f9, String f10, String f11, String f12,String f13) throws Exception {
		this.fieldName = f1;
		this.type = f2;
		this.isList = f3;
		this.primaryKey = f4;
		this.hibernateKey = f8;
		this.hibernateGenerate = f9;
		this.hibernateLength = f10;
		this.hibernateNullable = f11;
		this.hibernateUnique = f12;
		this.hibernateTransient=f13;
		if (f5.length() == 0) {
			name = fieldName;
		} else {
			name = f5;
		}
		this.isField = f6;
		this.bmInfo = f7;
		this.fInfo3 = f;
		this.tableName = tableName;
	}

	public String toString() {
		return this.name;
	}

	public String getField3() {
		return this.fInfo3;
	}

	public FieldObj(String info) throws Exception {

		Matcher m = InfoPattern.matcher(info);
		while (m.find()) {
			String repeated = m.group(1);
			if (repeated.equals("repeated")) {
				isList = true;
			}
			String type = m.group(2);
			fieldName = m.group(3);
		}

		if (fieldName == null) {
			// throw new
			// MdbException(Constant.ERROR_PROTO_PARSE,"proto文件解析生成sql失败");
			throw new Exception("proto文件解析生成sql失败,field解析失败");
		}
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getPrimaryKey() {
		return this.primaryKey;
	}

	public String getType() {
		return type;
	}

	public boolean isList() {
		return isList;
	}

	public boolean isField() {
		return this.isField;
	}

	public String getBmInfo() {
		return this.bmInfo;
	}

	@Override
	public Iterator<ILevelObj> process(IObjProcess process, int index)
			throws Exception {
		return process.processFiled(this, index);
	}

	public void endprocess(IObjProcess process) throws Exception {
		if (process instanceof OutPutJavaBean) {
			String filename = ((OutPutJavaBean) process).curFileName;
			String b = filename;
		}
		process.endFiled(this);

	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getfInfo3() {
		return fInfo3;
	}

	public void setfInfo3(String fInfo3) {
		this.fInfo3 = fInfo3;
	}

	public String getHibernateKey() {
		return hibernateKey;
	}

	public void setHibernateKey(String hibernateKey) {
		this.hibernateKey = hibernateKey;
	}

	public String getHibernateGenerate() {
		return hibernateGenerate;
	}

	public void setHibernateGenerate(String hibernateGenerate) {
		this.hibernateGenerate = hibernateGenerate;
	}

	public String getHibernateLength() {
		return hibernateLength;
	}

	public void setHibernateLength(String hibernateLength) {
		this.hibernateLength = hibernateLength;
	}

	public String getHibernateNullable() {
		return hibernateNullable;
	}

	public void setHibernateNullable(String hibernateNullable) {
		this.hibernateNullable = hibernateNullable;
	}

	public String getHibernateUnique() {
		return hibernateUnique;
	}

	public void setHibernateUnique(String hibernateUnique) {
		this.hibernateUnique = hibernateUnique;
	}

	public static Pattern getInfopattern() {
		return InfoPattern;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setList(boolean isList) {
		this.isList = isList;
	}

	public void setPrimaryKey(String primaryKey) {
		this.primaryKey = primaryKey;
	}

	public void setField(boolean isField) {
		this.isField = isField;
	}

	public void setBmInfo(String bmInfo) {
		this.bmInfo = bmInfo;
	}

	public String getHibernateTransient() {
		return hibernateTransient;
	}

	public void setHibernateTransient(String hibernateTransient) {
		this.hibernateTransient = hibernateTransient;
	}
	
}
