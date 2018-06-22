package com.cbhs.gencode.api.task;

import java.util.regex.Pattern;

public class MagicConstant {

	public static final String suffix_descript = "descript";

	public static final Pattern InfoPattern = Pattern.compile("(\\S+)\\((\\w+)\\)");

	// 关联表的格式
	public static final Pattern relatinTablePattern = Pattern.compile("(\\S+)\\{(\\w+)\\}");

	public static final String suffix_simpleRequest = "G";

	public static final String suffix_Farmer = "Farmer";

}
