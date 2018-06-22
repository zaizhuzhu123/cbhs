package com.cbhs.gencode.api.task.entity;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.api.IObjProcess;

public class ProtoObj extends AbstractParent implements ILevelObj {

	private String name = null;

	private String tableName = null;

	private static Pattern pattern = Pattern.compile("(?i)Sdjs(\\w*)");

	public ProtoObj(String name) {
		this.name = name;
		this.tableName = name;
	}

	public String getTableName() {
		return this.tableName;
	}

	public void parse(BufferedReader br) throws Exception {
		while (true) {
			String temp = null;
			try {
				temp = br.readLine();
				if (temp.contains("}")) {
					// 说明该proto文件定义结束了。
					break;
				}
				this.add(new FieldObj(temp));
			} catch (Exception e) {
				// throw new MdbException(Constant.ERROR_PROTO_PARSE,"proto文件解析生成sql失败");
				System.out.println(e);
			}
		}
	}

	public void parseExcelRow(XSSFSheet sheet, int column) throws Exception {
		for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {
			// if(j==0) continue;
			XSSFRow row = sheet.getRow(j);

			try {
				List<String> values = new ArrayList<String>();
				for (int i = 0; i < column; i++) {
					values.add(getCell(row, i));
				}
				this.add(new NewFieldObj(values, sheet.getSheetName()));

			} catch (Exception e) {
				throw new Exception("读取的行号:" + j + ",有可能是添加了空行.", e);
			}
		}

	}

	public void parseExcel(XSSFSheet sheet) throws Exception {

		for (int j = 0; j < sheet.getLastRowNum() + 1; j++) {

			if (j == 0)
				continue;

			XSSFRow row = sheet.getRow(j);

			try {
				String filedName = getCell(row, 0);

				String viewName = getCell(row, 1);
				String fInfo3 = getCell(row, 2);
				String type = getCell(row, 3);
				String isPrimaryKey = null;
				try {
					isPrimaryKey = getCell(row, 4);
				} catch (Exception e) {
					isPrimaryKey = "f";
				}
				boolean isField = true;
				if (getCell(row, 5).equals("f")) {
					isField = false;
				}

				boolean isArray = false;
				if (getCell(row, 6).equals("t")) {
					isArray = true;
				}
				String bmInfo = getCell(row, 7);
				String id = getCell(row, 8);
				String generatedValue = getCell(row, 9);
				String length = getCell(row, 10);
				String nullable = getCell(row, 11);
				String unique = getCell(row, 12);
				String transient_ = getCell(row, 13);
				String tableName = sheet.getSheetName();
				this.add(new FieldObj(filedName, type, fInfo3, isArray, isPrimaryKey, viewName, isField, bmInfo, tableName,id,generatedValue,length,nullable,unique,transient_));

			} catch (Exception e) {
				throw new Exception("读取的行号:" + j + ",有可能是添加了空行.", e);
			}
		}

	}

	private String getCell(XSSFRow row, int i) {
		XSSFCell cell = row.getCell(i);
		String value = "";
		if (cell != null) {

			try {
				value = cell.getRichStringCellValue().getString();
			} catch (Exception e) {

				int temp = (int) cell.getNumericCellValue();
				value = String.valueOf(temp);
			}

		}
		return value;

	}

	public String toString() {

		return this.name;
	}

	@Override
	public Iterator<ILevelObj> process(IObjProcess process, int index) throws Exception {
		return process.processProto(this, index);
	}

	@Override
	public void endprocess(IObjProcess process) throws Exception {
		process.endProto(this);
	}

}
