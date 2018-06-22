package com.server.util;

public class ExceptionConstant {
	public static final int baseCode = 20000;
	public static final int accountAlreadyExists = baseCode + 1;
	public static final int notOpen = baseCode + 2;
	public static final int accountNotFound = baseCode + 3;
	public static final int wrongPassword = baseCode + 4;
	public static final int fileCannotBeEmpty = baseCode + 5;
	public static final int fileFormatError = baseCode + 6;

	public static final int exceed = 30000; // 成本超过预算
}
