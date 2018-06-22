package com.server.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileFormatUtils {

	public final static String excelReg = "^.*?\\.(xls|xlsx)$";

	public static boolean format(String reg, String str) {
		Pattern pattern = Pattern.compile(reg);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

	public static void main(String[] args) {
		// System.out.println(FileFormatUtils.format(FileFormatUtils.excelReg,
		// "asdasd.xls"));
	}
}
