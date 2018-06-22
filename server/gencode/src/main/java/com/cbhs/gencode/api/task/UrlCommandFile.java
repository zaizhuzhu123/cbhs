package com.cbhs.gencode.api.task;

import java.io.File;
import java.util.Iterator;

import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.api.IObjProcess;
import com.cbhs.gencode.api.task.entity.FileImpl;
import com.cbhs.gencode.api.util.iterable.PrefetchingIterator;

public class UrlCommandFile implements ILevelObj {

	private File rootFile = null;

	public UrlCommandFile(String path) throws Exception {
		path = path + "\\url";
		rootFile = new File(path);
		System.setProperty("javax.xml.parsers.DocumentBuilderFactory", "com.sun.org.apache.xerces.internal.jaxp.DocumentBuilderFactoryImpl");
	}

	@Override
	public Iterator<ILevelObj> process(IObjProcess process, int index) throws Exception {

		return new PrefetchingIterator<ILevelObj>() {
			private File[] files = rootFile.listFiles();
			private int index = 0;

			@Override
			protected ILevelObj fetchNextOrNull() {
				while (index < files.length) {

					if (files[index].getName().endsWith("_url.xlsx")) {
						FileImpl excelFile = null;
						try {
							excelFile = new FileImpl(files[index], 1, 12);
							excelFile.setFileName(files[index].getName());
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
							index++;
						}
						return excelFile;
					} else {
						index++;
					}
				}
				return null;
			}

		};

	}

	@Override
	public void endprocess(IObjProcess process) throws Exception {
		// TODO Auto-generated method stub

	}

}