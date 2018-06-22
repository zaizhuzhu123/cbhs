package com.cbhs.gencode.api.task.process.bm;

import java.util.ArrayList;
import java.util.List;

public class MyNewBM {

	private int bm = -1;
	private String name = null;
	private List<MyNewBM> childs = null;
	private String desc = null;

	public MyNewBM(int bm, String name, String des) {
		this.bm = bm;
		this.name = name;
		this.desc = des;
		this.childs = new ArrayList<MyNewBM>();
	}

	public String getDesc() {
		return this.desc;
	}

	public int getBm() {
		return this.bm;
	}

	public String getName() {
		return this.name;
	}

	public List<MyNewBM> getChilds() {
		return this.childs;
	}

	public String toString() {

		return this.bm + "  :" + this.name;
	}

}
