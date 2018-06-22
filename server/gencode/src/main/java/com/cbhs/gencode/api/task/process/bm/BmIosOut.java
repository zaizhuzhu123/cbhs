package com.cbhs.gencode.api.task.process.bm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.FileImpl;
import com.cbhs.gencode.api.task.entity.ProtoObj;
import com.cbhs.gencode.api.task.process.AbstractProcess;
import com.cbhs.gencode.api.task.process.OutPutIos;

public class BmIosOut extends AbstractProcess {

	private BufferedWriter bw = null;

	private ArrayList<BmObject> bmObjects = new ArrayList<BmObject>();

	private BmObject curTable = null;

	private String targetDir = null;

	public BmIosOut(String targetDir) throws IOException {
		File direc = new File(targetDir + OutPutIos.iosModelDir);
		if (!direc.exists()) {
			direc.mkdir();
		}

		this.targetDir = targetDir + OutPutIos.iosModelDir;
	}

	public void finish() throws Exception {

		bw.write("@interface YqtBmConstants:NSObject");
		bw.newLine();
		for (BmObject bmObj : bmObjects) {
			String name = bmObj.getName();
			bw.write("  +(" + name + "*)  " + name + ";");
			bw.newLine();
			// 这是取码表名的方法。
			bw.write("  +(NSString*)  bm_" + name + ";");
			bw.newLine();
			bw.newLine();

		}

		bw.newLine();
		bw.write("  +(NSString *)getBmValueWithName:(NSString *)name keyPath:(NSArray *)keyPath;");
		bw.newLine();
		bw.write("  +(NSArray *)getBmTableWithName:(NSString *)name keyPath:(NSMutableArray *)keyPath;");

		bw.newLine();
		bw.write("@end");
		bw.newLine();
		bw.close();

		// 生成m文件：
		String targetFile = targetDir + File.separator + "YqtBmConstants";
		File mFile = new File(targetFile + ".m");
		if (!mFile.exists()) {
			mFile.createNewFile();
		}
		this.bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mFile), "UTF-8"));

		bw.write("#import <Foundation/Foundation.h>");
		bw.newLine();
		bw.write("#import \"YqtBmConstants.h\"");
		bw.newLine();
		bw.write("#import \"YqtBm.h\"");
		bw.newLine();

		String[] codes = new String[] { "@interface YqtBmConstants ()", "+ (NSArray *)getChildArrayWithBm:(YqtBm *)bmTable keyPath:(NSArray *)keyPath index:(int)index;", "@end" };
		bw.newLine();
		for (String code : codes) {
			bw.newLine();
			bw.write(code);
		}
		bw.newLine();

		bw.newLine();
		bw.write("@implementation YqtBmConstants");
		bw.newLine();

		bw.newLine();
		bw.write("	static NSMutableDictionary *bmTableDic;");
		bw.newLine();
		for (BmObject bmObj : bmObjects) {
			String name = bmObj.getName();
			bw.write("	static " + name + " *" + name.toLowerCase() + ";");
			bw.newLine();
		}

		// 一、生成编码表记录集合,生成的代码较多，专门用了一个方法。
		bw.newLine();
		fillBmDic();
		bw.newLine();

		// 二、生成得到码表对象的静态方法。
		for (BmObject bmObj : bmObjects) {
			String name = bmObj.getName();
			String lName = name.toLowerCase();
			bw.write("	+(" + name + " *)  " + name + "{");
			bw.newLine();
			bw.write("       if(" + lName + "==nil){");
			bw.newLine();
			bw.write("          " + lName + "=[[" + name + " alloc]init];");
			bw.newLine();
			bw.write("       }");
			bw.newLine();
			bw.write("       return " + lName + ";");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.newLine();
		}

		// 三、生成得到码表名字的静态方法
		for (BmObject bmObj : bmObjects) {
			String name = bmObj.getName();
			bw.write("	+(NSString*)  bm_" + name + "{");
			bw.newLine();
			bw.write("       return @\"" + name + "\";");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.newLine();
		}

		// 四、生成RC对象的相应实例方法。
		codes = new String[] { "	+ (NSString *)getBmValueWithName:(NSString *)name keyPath:(NSArray *)keyPath{", "	    if (keyPath == nil || keyPath.count == 0) {", "	        return nil;", "	    } else {", "          [YqtBmConstants initBmTable]; ", "	        long count = keyPath.count - 1;", "	        NSMutableArray *keys = [NSMutableArray array];", "	        for (int i = 0; i < count; i++) {", "	            keys[i] = keyPath[i];", "	        }", "	        int key = [keyPath[count]intValue];", "	        NSArray * array = [YqtBmConstants getBmTableWithName:name keyPath:keys];", "	        for (YqtBm *record in array) {", "	            if (record.bh == key) {", "	                return record.name;", "	            }", "	        }", "	        return @\"\";", "	    }", "	}", "", "	+ (NSArray *)getBmTableWithName:(NSString *)name keyPath:(NSMutableArray *)keyPath{", "      [YqtBmConstants initBmTable]; ", "	    NSArray *records = bmTableDic[name];",
				"	    if (keyPath == nil || keyPath.count == 0) {", "	        return records;", "	    } else {", "	        int key = [keyPath[0]intValue];", "	        for (YqtBm *record in records) {", "	            if (record.bh == key) {", "	                return [YqtBmConstants getChildArrayWithBm:record keyPath:keyPath index:1];", "	            }", "	        }", "	    }", "	    return [NSArray array];", "	}", "", "	+ (NSArray *)getChildArrayWithBm:(YqtBm *)bmTable keyPath:(NSArray *)keyPath index:(int)index{", "	    if (keyPath.count == index) {", "	        return bmTable.childs;", "	    }", "	    int code = [keyPath[index]intValue];", "	    for (YqtBm *child in bmTable.childs) {", "	        if (child.bh == code) {", "	            return [YqtBmConstants getChildArrayWithBm:child keyPath:keyPath index:++index];", "	        }", "	    }", "	    return [NSArray array];", "	}"

		};
		for (String code : codes) {
			bw.newLine();
			bw.write(code);
		}
		bw.newLine();

		bw.newLine();
		bw.write("@end");
		bw.newLine();

		// 五、码表对象实例化(非RC对象，注意上边的代码，已经有RC的@end)。
		bw.newLine();
		bw.newLine();
		for (BmObject bmObj : bmObjects) {
			String name = bmObj.getName();
			bw.write("@implementation " + name);
			bw.newLine();
			bw.write("    -(id)init{");
			bw.newLine();
			bw.write("       if(self==[super init]){");
			bw.newLine();
			for (MyNewBM record : bmObj.getRecords()) {
				bw.write("          self." + record.getDesc() + "=" + record.getBm() + ";");
				bw.newLine();
				if (name.contains("YqtFileDir")) {
					bw.write("          self." + record.getDesc() + "_dir=@\"" + record.getBm() + "\";");
					bw.newLine();
				}
				for (MyNewBM child1 : record.getChilds()) {
					bw.write("          self." + child1.getDesc() + "=" + child1.getBm() + ";");
					bw.newLine();
					if (name.contains("YqtFileDir")) {
						bw.write("          self." + child1.getDesc() + "_dir=@\"" + record.getBm() + "," + child1.getBm() + "\";");
						bw.newLine();
					}
				}
			}
			bw.write("       }");
			bw.newLine();
			bw.write("       return self;");
			bw.newLine();
			bw.write("	}");
			bw.newLine();
			bw.write("@end");
			bw.newLine();
			bw.newLine();
		}

		bw.newLine();

		bw.close();

	}

	public Iterator<ILevelObj> processFile(final FileImpl ifile, int index) throws Exception {

		String targetFile = targetDir + File.separator + "YqtBmConstants";

		// 一、先生成h文件：
		File mFile = new File(targetFile + ".h");
		if (!mFile.exists()) {
			mFile.createNewFile();
		}
		this.bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(mFile), "UTF-8"));

		if (index == 0) {
			bw.write("#import <Foundation/Foundation.h>");
			bw.newLine();
		}
		return super.processFile(ifile, index);
	}

	@Override
	public Iterator<ILevelObj> processProto(ProtoObj proto, int index) throws Exception {

		String name = proto.toString().trim();
		bw.write("@interface " + name + " :NSObject");
		bw.newLine();

		curTable = new BmObject(name);
		return super.processProto(proto, index);
	}

	@Override
	public void endProto(ProtoObj proto) throws Exception {
		bw.write("@end");
		bw.newLine();
		bw.newLine();
		bw.newLine();

		bmObjects.add(curTable);

	}

	@Override
	public Iterator<ILevelObj> processFiled(FieldObj field, int index) throws Exception {
		String key = field.getFieldName().trim();
		MyNewBM record = this.curTable.addRecord(key, field.toString(), field.getField3());

		bw.write("	  @property(nonatomic) int  " + record.getDesc() + ";");
		bw.newLine();
		if (field.getTableName().contains("YqtFileDir")) {
			bw.write("	  @property(nonatomic,strong) NSString  *" + record.getDesc() + "_dir;");
			bw.newLine();
		}
		return super.processFiled(field, index);
	}

	@Override
	public void endFiled(FieldObj field) throws Exception {
		bw.newLine();
	}

	/***
	 * 生成编码表记录的集合部份。 因为这部份相对比较复杂，生成的代码也多，所以专门抽成一个方法，由finish调用。
	 * 
	 * @throws IOException
	 */
	private void fillBmDic() throws IOException {

		bw.newLine();
		bw.write("    +(void)initBmTable{");
		bw.newLine();
		bw.write("	  if (bmTableDic == nil) {");
		bw.newLine();
		bw.write("	      bmTableDic = [NSMutableDictionary dictionary];");
		bw.newLine();

		// 先定义100个编码记录变量出来，应该用不完。
		for (int i = 0; i < 100; i++) {
			bw.newLine();
			bw.write("	      YqtBm *bm" + i + "=nil;");
		}
		bw.newLine();
		for (int i = 0; i < 20; i++) {
			bw.newLine();
			bw.write("	      YqtBm *bm0" + i + "=nil;");
		}
		bw.newLine();
		for (int i = 0; i < 20; i++) {
			bw.newLine();
			bw.write("	      YqtBm *bm00" + i + "=nil;");
		}
		bw.newLine();

		for (BmObject bmObj : bmObjects) {
			ArrayList<MyNewBM> records = bmObj.getRecords();
			int count = records.size();
			for (int i = 0; i < count; i++) {
				MyNewBM child = records.get(i);
				String[] temps = new String[] { "	      bm" + i + "=[[YqtBm alloc]init];", "	      bm" + i + ".bh=" + child.getBm() + ";", "	      bm" + i + ".name=@\"" + child.getName() + "\";"

				};
				for (String code : temps) {
					bw.newLine();
					bw.write(code);
				}

				this.fillChild("bm" + i, child, 1);

			}

			String temp = null;
			for (int i = 0; i < count; i++) {
				if (i == 0) {
					temp = "bm" + i;
				} else {
					temp = temp + ",bm" + i;
				}
			}

			bw.newLine();
			String bmName = bmObj.getName();
			bw.write("	      [bmTableDic  setValue:[NSArray arrayWithObjects:" + temp + ",nil]  forKey:@\"" + bmName + "\"];");
			bw.newLine();

		}
		bw.write("      }");
		bw.newLine();
		bw.write("    }");

	}

	/**
	 * 递归调用，生成每个编码对象的子编码对象。
	 * 
	 * @throws IOException
	 */
	private void fillChild(String name, MyNewBM parent, int index) throws IOException {

		if (parent.getChilds().size() == 0)
			return;
		// 根据层次，决定代码前边的退格。
		String temp = "";
		for (int i = 0; i < index; i++) {
			temp = temp + "		";
		}

		String prefix = "";
		for (int i = 0; i < index; i++) {
			prefix = prefix + "0";
		}

		List<MyNewBM> records = parent.getChilds();
		int count = records.size();
		for (int i = 0; i < count; i++) {
			MyNewBM child = records.get(i);
			String[] temps = new String[] { temp + "	      bm" + prefix + i + "=[[YqtBm alloc]init];", temp + "	      bm" + prefix + i + ".bh=" + child.getBm() + ";", temp + "	      bm" + prefix + i + ".name=@\"" + child.getName() + "\";" };
			for (String code : temps) {
				bw.newLine();
				bw.write(code);
			}
			this.fillChild("bm" + prefix + i, child, index + 1);
		}

		String childNames = null;
		for (int i = 0; i < count; i++) {
			if (i == 0) {
				childNames = "bm" + prefix + i;
			} else {
				childNames = childNames + ",bm" + prefix + i;
			}
		}

		bw.newLine();
		bw.write(temp + "	      " + name + ".childs=[NSMutableArray arrayWithObjects:" + childNames + ",nil];");
		bw.newLine();

	}

}