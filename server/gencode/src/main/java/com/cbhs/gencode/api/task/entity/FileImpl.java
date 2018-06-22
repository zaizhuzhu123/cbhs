package com.cbhs.gencode.api.task.entity;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.api.IObjProcess;

public class FileImpl extends AbstractParent implements ILevelObj {

	private String fileName = null;

	public FileImpl(File file) throws Exception {
		this.setFileName(file.getName());
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
		for (int i = 0; i < wb.getNumberOfSheets(); i++) {
			XSSFSheet sheet = wb.getSheetAt(i);
			String protoName = sheet.getSheetName();
			ProtoObj protoObj = new ProtoObj(protoName);
			try {
				protoObj.parseExcel(sheet);
			} catch (Exception e) {

				System.out.println("prto解析有错：" + protoObj.toString());
				e.printStackTrace();

			}
			add(protoObj);
		}
	}

	/***
	 * 2016/07/18 为了解析安全的操作码文件专门增加的一种解析。
	 * 在标准解析的基础上进行了扩展，通过参数控制解析几个tab页和每个tab页中可以读取的列数。
	 * 
	 * @param file
	 * @param tabCount
	 *            指定解析几个tab页。
	 * @param column
	 *            指定解析的列的数量。
	 * @throws Exception
	 */
	public FileImpl(File file, int tabCount, int column) throws Exception {
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));
		for (int i = 0; i < tabCount; i++) {
			XSSFSheet sheet = wb.getSheetAt(i);
			String protoName = sheet.getSheetName();
			ProtoObj protoObj = new ProtoObj(protoName);
			try {
				protoObj.parseExcelRow(sheet, column);
			} catch (Exception e) {

				System.out.println("prto解析有错：" + protoObj.toString());
				e.printStackTrace();

			}

			add(protoObj);
		}
	}

	/**
	 * 嵌入式的bean
	 */
	public FileImpl() {

	}

	@Override
	public Iterator<ILevelObj> process(IObjProcess process, int index) throws Exception {
		return process.processFile(this, index);
	}

	@Override
	public void endprocess(IObjProcess process) throws Exception {
		process.endFile(this);

	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
