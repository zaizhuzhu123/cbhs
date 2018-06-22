package com.cbhs.gencode.api.task.process;

import java.util.Iterator;

import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.api.IObjProcess;
import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.FileImpl;
import com.cbhs.gencode.api.task.entity.ProtoObj;
import com.cbhs.gencode.api.util.iterable.PrefetchingIterator;

public abstract class AbstractProcess implements IObjProcess {

	public String fileName;

	@Override
	public Iterator<ILevelObj> processFile(final FileImpl ifile, int index) throws Exception {

		this.fileName = ifile.getFileName();
		return new PrefetchingIterator<ILevelObj>() {
			Iterator<ILevelObj> iterator = ifile.getChildren();

			protected ILevelObj fetchNextOrNull() {
				if (iterator.hasNext()) {
					return iterator.next();
				} else {
					return null;
				}
			}
		};

	}

	private void aaa() {
	};

	@Override
	public Iterator<ILevelObj> processProto(final ProtoObj proto, int index) throws Exception {
		return new PrefetchingIterator<ILevelObj>() {
			Iterator<ILevelObj> iterator = proto.getChildren();

			protected ILevelObj fetchNextOrNull() {
				if (iterator.hasNext()) {
					return iterator.next();
				} else {
					return null;
				}
			}
		};

	}

	@Override
	public Iterator<ILevelObj> processFiled(FieldObj field, int index) throws Exception {
		return getNullIterator();
	}

	@Override
	public void endFiled(FieldObj field) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void endProto(ProtoObj proto) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void endFile(FileImpl ifile) throws Exception {
		// TODO Auto-generated method stub
		this.fileName = ifile.getFileName();

	}

	@Override
	public void finish() throws Exception {
		// TODO Auto-generated method stub

	}

	protected Iterator<ILevelObj> getNullIterator() {

		return new PrefetchingIterator<ILevelObj>() {
			protected ILevelObj fetchNextOrNull() {
				return null;
			}
		};
	}

}
