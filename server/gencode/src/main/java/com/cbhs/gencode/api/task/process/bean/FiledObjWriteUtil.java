/**
 * <p>鏂囦欢鍚嶇О: FiledObjWriteUtil.java </p>
 * <p>鏂囦欢鎻忚堪: 鐢熸垚bean瀵硅薄鐨勪唬鐮佸伐鍏风被</p>
 * <p>鐗堟潈鎵�鏈�: 鐗堟潈鎵�鏈�(C)2016-2026</p>
 * <p>鍏�    鍙�:  </p>
 * <p>鍐呭鎽樿: </p>
 * <p>鍏朵粬璇存槑: 鏃�</p>
 * <p>鍒涘缓鏃ユ湡锛�2017-4-28</p>
 * <p>瀹屾垚鏃ユ湡锛�2017-4-28</p>
 * <p>淇敼璁板綍1: // 淇敼鍘嗗彶璁板綍锛屽寘鎷慨鏀规棩鏈熴�佷慨鏀硅�呭強淇敼鍐呭</p>
 * <pre>
 *    淇敼鏃ユ湡锛� 
 *    鐗� 鏈� 鍙凤細
 *    淇� 鏀� 浜猴細
 *    淇敼鍐呭锛�
 * </pre>
 * <p>淇敼璁板綍2锛氣��</p>
 * @version 1.0
 * @author 琚佺憺瀹�
 */

package com.cbhs.gencode.api.task.process.bean;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.NewFieldObj;

public class FiledObjWriteUtil {

	public static void generatorPrivateByServerDaoBean(ArrayList<String> properties, FieldObj field) {
		String type = field.getType();
		String ListType = getWrapperType(type);
		boolean transienta = false;
		if (type.toLowerCase().equals("int32")) {
			type = "	private Integer " + field.getFieldName();

		} else if (type.toLowerCase().equals("int64")) {
			type = "	private Long " + field.getFieldName();

		} else if (type.toLowerCase().equals("string")) {
			type = "	private String " + field.getFieldName();

		} else if (type.toLowerCase().equals("double")) {
			type = "	private Double " + field.getFieldName();

		} else if (type.toLowerCase().equals("boolean")) {
			type = "	private Boolean " + field.getFieldName();

		} else if (type.toLowerCase().equals("byte[]")) {
			transienta = true;
			type = "	private  byte[] " + field.getFieldName();

		} else {
			transienta = true;
			type = "	private " + type + " " + field.getFieldName();
		}
		if (field.isList()) {
			transienta = true;
			type = "	private List<" + ListType + "> " + field.getFieldName() + "= new ArrayList<>();";
		}
		// dao
		if (field.getPrimaryKey().equals("t")) {
			// type ="@Id \n"+type;
		} else if (field.getPrimaryKey().equals("a")) {
			// type ="@Id \n"
			// + "@GeneratedValue(strategy = GenerationType.IDENTITY) \n"+type;
		}
		boolean errName = isStartTwoUpper(field.getFieldName());

		if (!field.isField() || transienta || (errName && properties.size() > 0)) {
			// type = "@Transient \n " + type;
		}
		properties.add(type + ";");

	}

	public static void generatorPrivateByServer(ArrayList<String> properties, FieldObj field) {
		NewFieldObj newField = (NewFieldObj) field;
		try {
			String fieldMsg = newField.getFielValue(9);
			String jsr303 = null;
			try {
				jsr303 = newField.getFielValue(10);
			} catch (Exception e) {

			}
			if (jsr303 != null && jsr303.trim().length() > 0) {
				if (jsr303.contains("@NotBlank") || jsr303.contains("@NotNull")) {
					properties.add("	" + "@ApiModelProperty(value = \"" + fieldMsg + "(蹇呭～)" + "\")");
				} else {
					properties.add("	" + "@ApiModelProperty(value = \"" + fieldMsg + "" + "\")");
				}
				JSONArray anArray = (JSONArray) JSON.parse(jsr303);
				if (anArray.size() > 0) {
					for (int i = 0; i < anArray.size(); i++) {
						String anno = anArray.getString(i);
						anno = anno.replace("\\", "\\\\");
						anno = anno.replace("'", "\"");
						properties.add("	" + anno);
					}
				}
			} else {
				properties.add("	" + "@ApiModelProperty(value = \"" + fieldMsg + "\")");
			}
		} catch (Exception e) {
			// e.printStackTrace();
		}
		String type = field.getType();
		String ListType = getWrapperType(type);
		if (type.toLowerCase().equals("int32")) {
			type = "	private Integer " + field.getFieldName() + "= 0";

		} else if (type.toLowerCase().equals("int64")) {
			type = "	private Long " + field.getFieldName() + "= 0L";

		} else if (type.toLowerCase().equals("string")) {
			type = "	private String " + field.getFieldName() + "= \"\"";

		} else if (type.toLowerCase().equals("double")) {
			type = "	private BigDecimal " + field.getFieldName() + "= new BigDecimal(0)";

		} else if (type.toLowerCase().equals("boolean")) {
			if (field.getFieldName().trim().equals("status")) {
				type = "	private Boolean " + field.getFieldName() + "=true";
			} else {
				type = "	private Boolean " + field.getFieldName();
			}

		} else if (type.toLowerCase().equals("byte[]")) {
			type = "	private Byte[] " + field.getFieldName();

		} else {
			type = "	private " + type + "  " + field.getFieldName();
		}
		if (field.isList()) {
			type = "	private List<" + ListType + "> " + field.getFieldName() + "= new ArrayList<>();";
		}
		properties.add(type + ";");
	}

	public static void generatorPrivateByMYHZ(ArrayList<String> properties, FieldObj field) {
		String id = field.getHibernateKey();
		String generatedValue = field.getHibernateGenerate();
		String length = field.getHibernateLength();
		String nullable = field.getHibernateNullable();
		String unique = field.getHibernateUnique();
		String transient_ = field.getHibernateTransient();
		String cascade = field.getfInfo3();
		String tableName = field.getTableName();
		String type = field.getType();
		String ListType = getWrapperType(type);
		boolean updateFalse = cascade.contains("|update=false|");
		boolean hidden = cascade.contains("|hidden=true|");
		boolean requireTrue = cascade.contains("|required=true|");
		boolean example = cascade.contains("|example=");
		String exampleValue = "";
		if (example) {
			String exampleAfter = cascade.substring(cascade.indexOf("|example=") + 1, cascade.length());
			exampleValue = exampleAfter.substring(exampleAfter.indexOf("=") + 1, exampleAfter.indexOf("|"));
		}
		if (!field.isField()) {
			properties.add("	@Transient");
		} else {
			if ("t".equals(id)) {
				properties.add("	@Id");
			}
			if (StringUtils.isNotBlank(cascade) && !updateFalse) {
				if (cascade.contains("OneToOne")) {
					if (cascade.contains("CascadeType.REMOVE")) {
						String value = "		@OneToOne(cascade=CascadeType.REMOVE, fetch = FetchType.LAZY";
						if (cascade.contains("mappedBy")) {
							// 鑾峰緱澶栭敭鍚嶇О
							String submappCIndex = cascade.substring(cascade.indexOf("mappedBy"));
							int endJoin = submappCIndex.indexOf(")");
							int startJoin = submappCIndex.indexOf("(");
							if (startJoin != -1 && endJoin != -1) {
								String name = submappCIndex.substring(startJoin + 1, endJoin);
								value += ",mappedBy=\"" + name + "\"";
							}
						}
						value += ")";
						properties.add(value);
					} else {
						String value = "	@OneToOne(fetch = FetchType.LAZY";
						if (cascade.contains("mappedBy")) {
							// 鑾峰緱澶栭敭鍚嶇О
							String submappCIndex = cascade.substring(cascade.indexOf("mappedBy"));
							int endJoin = submappCIndex.indexOf(")");
							int startJoin = submappCIndex.indexOf("(");
							if (startJoin != -1 && endJoin != -1) {
								String name = submappCIndex.substring(startJoin + 1, endJoin);
								value += ",mappedBy=\"" + name + "\"";
							}
						}
						value += ")";
						properties.add(value);
					}
					if (!cascade.contains("mappedBy")) {
						properties.add("	@JoinColumn(name = \"" + field.getFieldName() + "_oid" + "\", foreignKey = @ForeignKey(name = \"none\", value = ConstraintMode.NO_CONSTRAINT) )");
					}
					if (type.equals("CbhsUser")) {
						properties.add("	@Fetch(FetchMode.JOIN)");
					}
					if (cascade.contains("FetchMode.JOIN")) {
						properties.add("	@Fetch(FetchMode.JOIN)");
					}
				} else if (cascade.contains("OneToMany")) {
					String value = "	@OneToMany(fetch = FetchType.EAGER";
					value += getCasecadeParam(cascade);
					value += ")";
					properties.add(value);
					if (cascade.contains("JoinColumn")) {
						// 鑾峰緱澶栭敭鍚嶇О
						String subJoinCIndex = cascade.substring(cascade.indexOf("JoinColumn"));
						int endJoin = subJoinCIndex.indexOf(")");
						int startJoin = subJoinCIndex.indexOf("(");
						if (startJoin != -1 && endJoin != -1) {
							String name = subJoinCIndex.substring(startJoin + 1, endJoin);
							properties.add("	@JoinColumn(name = \"" + name + "\", foreignKey = @ForeignKey(name = \"none\", value = ConstraintMode.NO_CONSTRAINT) )");
						}
					}
				} else if (cascade.contains("ManyToOne")) {
					String value = "	@ManyToOne(fetch = FetchType.LAZY";
					value += getCasecadeParam(cascade);
					value += ")";
					properties.add(value);
					if (cascade.contains("JoinColumn")) {
						// 鑾峰緱澶栭敭鍚嶇О
						String subJoinCIndex = cascade.substring(cascade.indexOf("JoinColumn"));
						int endJoin = subJoinCIndex.indexOf(")");
						int startJoin = subJoinCIndex.indexOf("(");
						if (startJoin != -1 && endJoin != -1) {
							String name = subJoinCIndex.substring(startJoin + 1, endJoin);
							properties.add("	@JoinColumn(name = \"" + name + "\", foreignKey = @ForeignKey(name = \"" + name + "\", value = ConstraintMode.NO_CONSTRAINT)) ");
						}
					}
					properties.add("	@JSONField(serialize = false)");
				} else {
					if ("t".equals(generatedValue)) {
						properties.add("	@GeneratedValue(strategy = GenerationType.IDENTITY)");
					} else if ("uuid".equals(generatedValue)) {
						properties.add("	@GeneratedValue(generator = \"uuid\")");
						properties.add("	@GenericGenerator(name = \"uuid\", strategy = \"uuid\")");
					} else {
						properties.add("	@Column(name = \"" + field.getFieldName() + "\"" + (notNullAndBlank(length) ? ", length = " + length : "") + (updateFalse ? ",updatable = false" : "") + (type.trim().toLowerCase().equals("double") ? ",precision = 19, scale = 4, columnDefinition=\"decimal(19,4) default 0\"" : "") + ("f".equals(nullable) ? ", nullable = false" : ", nullable = true") + ("t".equals(unique) ? " ,unique = true" : ", unique = false") + (type.equals("int32") ? ",columnDefinition=\"Integer default 0\"" : "") + (type.equals("int64") ? ",columnDefinition=\"bigint default 0\"" : "") + (type.equals("float") ? ",columnDefinition=\"float(11) default 0\"" : "") + (type.equals("string") ? ",columnDefinition=\"varchar(" + ((length != null || length.length() == 0) ? length : "50") + ") default ''\"" : "") + "" + ")");
					}
				}
			} else {
				if ("t".equals(generatedValue)) {
					properties.add("	@GeneratedValue(strategy = GenerationType.IDENTITY)");
				} else if ("uuid".equals(generatedValue)) {
					properties.add("	@GeneratedValue(generator = \"uuid\")");
					properties.add("	@GenericGenerator(name = \"uuid\", strategy = \"uuid\")");
				} else {
					properties.add("	@Column(name = \"" + field.getFieldName() + "\"" + (notNullAndBlank(length) ? ", length = " + length : "") + (updateFalse ? ",updatable = false" : "") + (type.trim().toLowerCase().equals("double") ? ",precision = 19, scale = 4, columnDefinition=\"decimal(19,4) default 0\"" : "") + ("f".equals(nullable) ? ", nullable = false" : ", nullable = true") + ("t".equals(unique) ? " ,unique = true" : ", unique = false") + (type.equals("int32") ? ",columnDefinition=\"Integer default 0\"" : "") + (type.equals("int64") ? ",columnDefinition=\"bigint default 0\"" : "") + (type.equals("float") ? ",columnDefinition=\"float(11) default 0\"" : "") + (type.equals("string") ? ",columnDefinition=\"varchar(" + ((length != null || length.length() == 0) ? length : "50") + ") default ''\"" : "") + "" + ")");
				}
			}
		}
		properties.add("	@ApiModelProperty(value = \"" + field.getName() + "\"" + (hidden ? ",hidden=true" : "") + (requireTrue ? ",required=true" : ",required=false") + (example ? ",example=\"" + exampleValue + "\"" : "") + ")");
		if (type.toLowerCase().equals("int32")) {
			type = "	private Integer " + field.getFieldName() + "= 0";

		} else if (type.toLowerCase().equals("int64")) {
			type = "	private Long " + field.getFieldName() + "= 0L";

		} else if (type.toLowerCase().equals("string")) {
			type = "	private String " + field.getFieldName() + "= \"\"";

		} else if (type.toLowerCase().equals("double")) {
			type = "	private BigDecimal " + field.getFieldName() + "= new BigDecimal(0)";
		} else if (type.toLowerCase().equals("boolean")) {
			if (field.getFieldName().trim().equals("status")) {
				type = "	private Boolean " + field.getFieldName() + "=true";
			} else {
				type = "	private Boolean " + field.getFieldName();
			}

		} else if (type.toLowerCase().equals("byte[]")) {
			type = "	private Byte[] " + field.getFieldName();

		} else {
			type = "	private " + type + "  " + field.getFieldName();
		}
		if (field.isList()) {
			type = "	private List<" + ListType + "> " + field.getFieldName() + "= new ArrayList<>();";
		}
		properties.add(type + ";" + "// " + field.getName());
	}

	private static boolean isStartTwoUpper(String s) {
		if (s == null || s.length() < 2) {
			return false;
		}
		if (Character.isUpperCase(s.charAt(1))) {
			// System.err.println("***鍓�2涓瓧绗﹀ぇ鍐欓敊璇細" + s);
			return true;
		}
		return false;
	}

	public static void generatorPrivateByAndriodUrl(ArrayList<String> properties, FieldObj field) {
		NewFieldObj newField = (NewFieldObj) field;
		String type = field.getType();
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
		String ListType = getWrapperType(type);
		if (type.toLowerCase().equals("int32")) {
			type = "private int " + field.getFieldName();

		} else if (type.toLowerCase().equals("int64")) {
			type = "private long " + field.getFieldName();

		} else if (type.toLowerCase().equals("string")) {
			type = "private String  " + field.getFieldName();

		} else if (type.toLowerCase().equals("double")) {
			type = "private double " + field.getFieldName();

		} else if (type.toLowerCase().equals("boolean")) {
			type = "private  boolean " + field.getFieldName();

		} else if (type.toLowerCase().equals("byte[]")) {
			type = "private  String " + field.getFieldName();

		} else {
			type = "private  " + type + "  " + field.getFieldName();
		}
		if (field.isList()) {

			type = "private List<" + ListType + "> " + field.getFieldName() + ";";
		}
		properties.add(type + ";" + (fieldMsg != null ? ("// " + fieldMsg) : ("")) + (isRequired ? "(蹇呭～)" : ""));

	}

	public static void generatorPrivateByAndriodBean(ArrayList<String> properties, FieldObj field) {

		String type = field.getType();
		String ListType = getWrapperType(type);
		if (type.toLowerCase().equals("int32")) {
			type = "private int " + field.getFieldName();

		} else if (type.toLowerCase().equals("int64")) {
			type = "private long " + field.getFieldName();

		} else if (type.toLowerCase().equals("string")) {
			type = "private String  " + field.getFieldName();

		} else if (type.toLowerCase().equals("double")) {
			type = "private double " + field.getFieldName();

		} else if (type.toLowerCase().equals("boolean")) {
			type = "private  boolean " + field.getFieldName();

		} else if (type.toLowerCase().equals("byte[]")) {
			type = "private  String " + field.getFieldName();

		} else {
			type = "private  " + type + "  " + field.getFieldName();
		}
		if (field.isList()) {

			type = "private List<" + ListType + "> " + field.getFieldName() + ";";
		}
		properties.add(type + ";" + "// " + field.getName());

	}

	private static String getType(String type) {

		String ListType = null;
		if (type.toLowerCase().equals("int32")) {

			ListType = "int";

		} else if (type.toLowerCase().equals("int64")) {

			ListType = "long";
		} else if (type.toLowerCase().equals("string")) {

			ListType = "String";
		} else if (type.toLowerCase().equals("double")) {

			ListType = "double";
		} else if (type.toLowerCase().equals("boolean")) {

			ListType = "boolean";
		} else if (type.toLowerCase().equals("byte[]")) {

			ListType = "byte[]";
		} else {
			ListType = type;

		}

		return ListType;

	}

	private static String getTypeByServer(String type) {

		String ListType = null;
		if (type.toLowerCase().equals("int32")) {

			ListType = "Integer";

		} else if (type.toLowerCase().equals("int64")) {

			ListType = "Long";
		} else if (type.toLowerCase().equals("string")) {

			ListType = "String";
		} else if (type.toLowerCase().equals("double")) {

			ListType = "Double";
		} else if (type.toLowerCase().equals("boolean")) {

			ListType = "Boolean";
		} else if (type.toLowerCase().equals("byte[]")) {

			ListType = "Byte[]";
		} else {
			ListType = type;

		}

		return ListType;

	}

	private static String getWrapperType(String type) {

		String ListType = null;
		if (type.toLowerCase().equals("int32")) {

			ListType = "Integer";

		} else if (type.toLowerCase().equals("int64")) {

			ListType = "Long";
		} else if (type.toLowerCase().equals("string")) {

			ListType = "String";
		} else if (type.toLowerCase().equals("double")) {

			ListType = "Double";
		} else if (type.toLowerCase().equals("boolean")) {

			ListType = "Boolean";
		} else if (type.toLowerCase().equals("byte[]")) {

			ListType = "byte[]";
		} else {
			ListType = type;

		}

		return ListType;

	}

	/**
	 * 
	 * @param type
	 * @param fieldName
	 * @param filedNameFistUpCase
	 * @param isList
	 * @return 鏄惁鏈夋暟缁勩��
	 */

	public static void generatorGetAndSetByServer(ArrayList<String> getterSetter, FieldObj field, boolean dbBean) {

		String fieldName = field.getFieldName();
		System.out.println(fieldName);
		String filedNameFistUpCase = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());

		String GSInfo = null;
		if (fieldName.equalsIgnoreCase("subTypedescript")) {
			// System.out.println(type);
		}

		if (field.isList()) {
			String type = getWrapperType(field.getType());
			GSInfo = "	public List<" + type + ">" + " get" + filedNameFistUpCase + "() {\n" + "    	return this." + fieldName + ";\n" + "	}\n";
			GSInfo += "	public void set" + filedNameFistUpCase + "(List<" + type + "> " + fieldName + ") {\n" + "    this." + fieldName + " =" + fieldName + ";\n" + "	}\n";
			getterSetter.add(GSInfo);

		} else {
			// 1銆乬et鏂规硶锛�
			String type = getTypeByServer(field.getType());
			if (dbBean) {
				type = getWrapperType(field.getType());// java bean閮芥敼鎴愬寘瑁呯被鍨�
			}
			if (type.toLowerCase().trim().equals("double")) {
				getterSetter.add("	public BigDecimal get" + filedNameFistUpCase + "() { \n");
			} else {
				getterSetter.add("	public " + type + " get" + filedNameFistUpCase + "() { \n");
			}
			getterSetter.add("    	return this." + fieldName + ";\n");
			getterSetter.add("	}\n");

			// 2銆乻et鏂规硶锛�
			if (type.toLowerCase().trim().equals("double")) {
				getterSetter.add("	public void set" + filedNameFistUpCase + "(BigDecimal " + fieldName + ") {\n ");
			} else {
				getterSetter.add("	public void set" + filedNameFistUpCase + "(" + type + " " + fieldName + ") {\n ");
			}
			/*
			 * if(type.equals("byte[]")){ getterSetter.add("        this." +
			 * fieldName + "=new sun.misc.BASE64Encoder().encode("
			 * +fieldName+");\n"); }else{ getterSetter.add("        this." +
			 * fieldName + "="+ fieldName + ";\n"); }
			 */
			getterSetter.add("        this." + fieldName + " = " + fieldName + ";\n");
			getterSetter.add("	}\n");
		}

	}

	private static boolean isWrapperType(String type) {
		if (type.equals("Integer") || type.equals("Long") || type.equals("Double") || type.equals("Float") || type.equals("Boolean")) {
			return true;
		}
		return false;
	}

	public static void generatorGetAndSetByAndriod(ArrayList<String> getterSetter, FieldObj field) {

		String fieldName = field.getFieldName();
		String filedNameFistUpCase = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());

		String GSInfo = null;
		if (fieldName.equalsIgnoreCase("subTypedescript")) {
			// System.out.println(type);
		}

		if (field.isList()) {

			String type = getWrapperType(field.getType());

			GSInfo = "public List<" + type + ">" + "  get" + filedNameFistUpCase + "(){\n" + "    return this." + fieldName + ";\n" + "}\n";
			GSInfo += "public void set" + filedNameFistUpCase + "(List<" + type + "> " + fieldName + "){\n" + "    this." + fieldName + "=" + fieldName + ";\n" + "}\n";
			getterSetter.add(GSInfo);

		} else {
			String type = getType(field.getType());
			// 1銆乬et鏂规硶锛�
			getterSetter.add("public " + type + "  get" + filedNameFistUpCase + "(){ \n");
			if (type.equals("byte[]")) {
				getterSetter.add("    return  android.util.Base64.decode(this." + fieldName + ", android.util.Base64.NO_WRAP); \n");
			} else {
				getterSetter.add("    return this." + fieldName + ";\n");
			}
			// getterSetter.add(" return this." + fieldName + ";\n");
			getterSetter.add("}\n");

			// 2銆乻et鏂规硶锛�
			getterSetter.add("public void set" + filedNameFistUpCase + "(" + type + " " + fieldName + "){\n ");

			if (type.equals("byte[]")) {
				getterSetter.add("        this." + fieldName + "=android.util.Base64.encodeToString(" + fieldName + ", android.util.Base64.NO_WRAP);\n");
			} else {
				getterSetter.add("        this." + fieldName + "=" + fieldName + ";\n");
			}
			// getterSetter.add(" this." + fieldName + "="+ fieldName +
			// ";\n");
			getterSetter.add("}\n");
		}

	}

	public static boolean notNullAndBlank(String str) {
		if (str == null) {
			return false;
		} else {
			if (str.trim().length() == 0) {
				return false;
			} else {
				return true;
			}
		}
	}

	public static String getCasecadeParam(String casecade) {
		String value = "";
		if (casecade.contains("CascadeType.REMOVE")) {
			value += ",cascade=CascadeType.REMOVE";
		} else {
			value += ",cascade=CascadeType.ALL";
		}
		if (casecade.contains("mappedBy")) {
			// 鑾峰緱澶栭敭鍚嶇О
			String submappCIndex = casecade.substring(casecade.indexOf("mappedBy"));
			int endJoin = submappCIndex.indexOf(")");
			int startJoin = submappCIndex.indexOf("(");
			if (startJoin != -1 && endJoin != -1) {
				String name = submappCIndex.substring(startJoin + 1, endJoin);
				value += ",mappedBy=\"" + name + "\"";
			}
		}
		return value;
	}
}
