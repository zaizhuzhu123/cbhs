package com.cbhs.gencode.api.task.entity;

import java.util.ArrayList;
import java.util.Iterator;

import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.api.IParent;

public abstract class AbstractParent implements IParent {

	private ArrayList<ILevelObj> objs = new ArrayList<ILevelObj>();

	public void add(ILevelObj child) {

		this.objs.add(child);
	}

	public Iterator<ILevelObj> getChildren() {

		return objs.iterator();
	}

}
