package com.cbhs.gencode.api.task.api;

import java.util.Iterator;

import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.FileImpl;
import com.cbhs.gencode.api.task.entity.ProtoObj;

public interface IObjProcess {

	public Iterator<ILevelObj> processFiled(FieldObj field, int index) throws Exception;

	public Iterator<ILevelObj> processProto(ProtoObj proto, int index) throws Exception;

	public Iterator<ILevelObj> processFile(FileImpl ifile, int index) throws Exception;

	public void endFiled(FieldObj field) throws Exception;

	public void endProto(ProtoObj proto) throws Exception;

	public void endFile(FileImpl ifile) throws Exception;

	public void finish() throws Exception;

}
