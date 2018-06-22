package com.cbhs.gencode.api.task.api;

import java.util.Iterator;

public interface ILevelObj {

	public Iterator<ILevelObj> process(IObjProcess process, int index) throws Exception;

	public void endprocess(IObjProcess process) throws Exception;

}
