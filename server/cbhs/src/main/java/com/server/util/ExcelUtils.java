package com.server.util;

import java.text.DecimalFormat;

import org.apache.poi.ss.usermodel.Cell;

public class ExcelUtils {
	@SuppressWarnings("unused")
	public static String getCellValue(Cell cell) {
		if (cell == null) {
			return "";
		}
		int cellType = cell.getCellType();
		String value = null;
		if (Cell.CELL_TYPE_NUMERIC == cellType) {
			System.out.println("数字");
			value = String.valueOf(cell.getNumericCellValue()) + "";
			if (value.lastIndexOf(".0") != -1) {
				value = value.substring(0, value.length() - 2);
			}
		} else if (Cell.CELL_TYPE_STRING == cellType) {
			System.out.println("字符串");
			value = cell.getStringCellValue();
		} else if (Cell.CELL_TYPE_FORMULA == cellType) {
			System.out.println("其他:" + cellType);
			value = getValueOfNumericCell(cell) + "";
		} else {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			value = cell.getStringCellValue();
		}
		System.out.println(value);
		return value;
	}

	// 获取数字类型的cell值
	private static Object getValueOfNumericCell(Cell cell) {
		// Double d = cell.getNumericCellValue();
		// BigDecimal b = new BigDecimal(d);
		// double f1 = b.setScale(4, BigDecimal.ROUND_HALF_UP).doubleValue();
		// return f1;
		String str = null;
		try {
			Double d = cell.getNumericCellValue();
			DecimalFormat df = new DecimalFormat("#.####");
			str = df.format(d);
		} catch (Exception e) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
			str = cell.getStringCellValue();
		}

		return str;
	}
}
