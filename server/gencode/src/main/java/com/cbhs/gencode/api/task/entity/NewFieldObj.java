package com.cbhs.gencode.api.task.entity;

import java.util.List;

public class NewFieldObj extends FieldObj {

	private List<String> values = null;

	private String tableName;

	public NewFieldObj(List<String> _values, String tableName) {
		this.values = _values;
		this.tableName = tableName;
	}

	public String getFielValue(int index) {
		return values.get(index);
	}

	public boolean getFieldValueBool(int index) {
		String value = values.get(index);
		return Boolean.valueOf(value);
	}

	/**
	 * 取第一个字段.
	 */
	public String getFieldName() {
		return getFielValue(0);
	}

	/***
	 * 取第二个字段
	 */
	public String toString() {
		String name = getFielValue(1);
		if (name.length() == 0) {
			name = getFielValue(0);
		}
		return name;
	}

	/***
	 * 取第三个字段
	 */
	public String getField3() {
		return getFielValue(2);
	}

	/***
	 * 取第四个字段
	 */
	public String getType() {
		return getFielValue(3);
	}

	/**
	 * 取第五个字段
	 */
	public String getPrimaryKey() {

		String isPrimaryKey = "f";
		try {
			isPrimaryKey = getFielValue(4);
		} catch (Exception e) {

		}
		return isPrimaryKey;
	}

	/***
	 * 取第六个字段
	 */
	public boolean isField() {
		boolean isField = true;
		if (getFielValue(5).equals("f")) {
			isField = false;
		}
		return isField;
	}

	/***
	 * 取第七个字段
	 */
	public boolean isList() {

		boolean isArray = false;
		if (getFielValue(6).equals("t")) {
			isArray = true;
		}
		return isArray;
	}

	/***
	 * 取第八个字段
	 */
	public String getBmInfo() {
		return getFielValue(7);
	}

	public String getTableName() {
		return tableName;
	}

	

}
