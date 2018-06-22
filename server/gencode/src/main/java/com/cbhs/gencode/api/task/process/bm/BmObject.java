package com.cbhs.gencode.api.task.process.bm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BmObject {

	private String name = null;

	private ArrayList<MyNewBM> curTable = new ArrayList<MyNewBM>();
	private HashMap<String, MyNewBM> uiSdjsBms = new HashMap<String, MyNewBM>();

	public BmObject(String n) {
		this.name = n;
	}

	public ArrayList<MyNewBM> getRecords() {
		return this.curTable;
	}

	/***
	 * 以SdjsCity为例,高新区的key为“1,1,1”。
	 * 
	 * @param key
	 * @param record
	 */
	public MyNewBM addRecord(String key, String fName, String desc) {

		String[] temps = key.split(",");
		int pathCount = temps.length;
		int[] codes = new int[pathCount];
		for (int i = 0; i < pathCount; i++) {
			codes[i] = Integer.valueOf(temps[i]);
		}

		String fKey = "";
		for (int i = 0; i < pathCount - 1; i++) {
			if (i == pathCount - 2) {
				fKey = fKey + codes[i];
			} else {
				fKey = fKey + codes[i] + ",";
			}
		}

		MyNewBM record = new MyNewBM(codes[pathCount - 1], fName, desc);

		if (uiSdjsBms.get(fKey) == null) {
			curTable.add(record);
		} else {
			uiSdjsBms.get(fKey).getChilds().add(record);
		}
		uiSdjsBms.put(key, record);

		return record;

	}

	public String getName() {
		return name;
	}

}
