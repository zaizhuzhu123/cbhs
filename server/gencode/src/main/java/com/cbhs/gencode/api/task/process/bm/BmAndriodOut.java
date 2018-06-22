package com.cbhs.gencode.api.task.process.bm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.FileImpl;
import com.cbhs.gencode.api.task.entity.ProtoObj;
import com.cbhs.gencode.api.task.process.AbstractProcess;

public class BmAndriodOut extends AbstractProcess {

	private BufferedWriter bw = null;

	private ArrayList<List<MyNewBM>> tables = new ArrayList<List<MyNewBM>>();

	private ArrayList<String> tableNames = new ArrayList<String>();

	private ArrayList<MyNewBM> curTable = null;
	private HashMap<String, MyNewBM> uiSdjsBms = new HashMap<String, MyNewBM>();

	private static final String androidDir = "3.android\\BaseFrame\\src\\main\\java\\com\\team\\baseframe\\model";

	public BmAndriodOut(String targetDir) throws IOException {
		File direc = new File(targetDir + androidDir);
		if (!direc.exists()) {
			direc.mkdir();
		}
		String targetFile = targetDir + androidDir + File.separator + "YqtBmConstants.java";

		File sqlFile = new File(targetFile);
		if (!sqlFile.exists()) {
			sqlFile.createNewFile();
		}
		this.bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(sqlFile), "UTF-8"));
	}

	public void finish() throws Exception {

		bw.newLine();
		bw.write("	static{");
		bw.newLine();

		boolean isFirst = true;
		for (int i = 0; i < tables.size(); i++) {

			if (i == 0) {
				bw.write("		List<YqtBm> bmTable = new ArrayList<YqtBm>();");
				bw.newLine();
				bw.write("		List<YqtBm>  childs1=null;");
				bw.newLine();
				bw.write("		List<YqtBm>  childs2=null;");
				bw.newLine();
				// bw.write(" List<uiSdjsBm> childs3=null;");
			} else {
				bw.write("		bmTable = new ArrayList<YqtBm>();");
			}

			bw.newLine();

			List<MyNewBM> list = tables.get(i);

			for (MyNewBM kValue : list) {

				if (isFirst) {
					bw.write("		YqtBm   bm=new YqtBmConstants().new YqtBm();");
					isFirst = false;
				} else {
					bw.write("		bm=new YqtBmConstants().new YqtBm();");
				}
				bw.newLine();
				bw.write("		bm.setBh(" + kValue.getBm() + ");");
				bw.newLine();
				bw.write("		bm.setName(\"" + kValue.getName() + "\");");
				bw.newLine();
				bw.write("		bmTable.add(bm);");
				bw.newLine();

				addChildBm(kValue, 1);

			}
			bw.write("		bmTables.put(" + tableNames.get(i) + ", bmTable);");
			bw.newLine();
			bw.newLine();
			bw.newLine();

		}

		bw.newLine();
		bw.write("	}");
		bw.newLine();

		bw.newLine();
		bw.newLine();
		bw.write("	public static List<YqtBm> getBmTable(String name,int[] keyPath) {");
		bw.newLine();
		bw.write("	   List<YqtBm>   records=bmTables.get(name);");
		bw.newLine();
		bw.write("	   if(keyPath==null || keyPath.length==0  ){");
		bw.newLine();
		bw.write("	     	return records;");
		bw.newLine();
		bw.write("	   }else{");
		bw.newLine();
		bw.write("	   //取第一层的key值");
		bw.newLine();
		bw.write("	   	int  key=keyPath[0];");
		bw.newLine();
		bw.write("	   	for(YqtBm  record:records){");
		bw.newLine();
		bw.write("	   	   if(record.getBh()==key){");
		bw.newLine();
		bw.write("	   	     return  getChilds(record,keyPath,1);");
		bw.newLine();
		bw.write("	   	   }");
		bw.newLine();
		bw.write("	   	}");
		bw.newLine();
		bw.write("	   }");
		bw.newLine();
		bw.write("	   return new ArrayList<YqtBm>();");
		bw.newLine();
		bw.write("	}");
		bw.newLine();
		bw.newLine();

		bw.write("	private  static  List<YqtBm>  getChilds(YqtBm  bmTable,int[] keyPath,int index){");
		bw.newLine();
		bw.write("		 if(keyPath.length==index){");
		bw.newLine();
		bw.write("				 return  bmTable.getChildsList();");
		bw.newLine();
		bw.write("		 }");
		bw.newLine();
		bw.write("	     int  code=keyPath[index];");
		bw.newLine();
		bw.write("		 for(YqtBm child: bmTable.getChildsList()){");
		bw.newLine();
		bw.write("			     if(child.getBh()==code){");
		bw.newLine();
		bw.write("			      		 return   getChilds(child,keyPath,++index);");
		bw.newLine();
		bw.write("			      	 }");
		bw.newLine();
		bw.write("		 }");
		bw.newLine();
		bw.write("		 return new ArrayList<YqtBm>();");
		bw.newLine();
		bw.write("	}");
		bw.newLine();

		bw.newLine();
		bw.newLine();
		bw.write("    public static  String getBmValue(String name,int[]  keyPath) {");
		bw.newLine();
		bw.write("    	if(keyPath==null || keyPath.length==0  ) return null;");
		bw.newLine();
		bw.write("    	int count=keyPath.length-1;");
		bw.newLine();
		bw.write("    	int[] keys=new int[count];");
		bw.newLine();
		bw.write("    	for(int i=0;i<count;i++){");
		bw.newLine();
		bw.write("    		keys[i]=keyPath[i];");
		bw.newLine();
		bw.write("    	}");
		bw.newLine();
		bw.write("    	int  key=keyPath[count];");
		bw.newLine();
		bw.write("    	for(YqtBm  record:getBmTable(name,keys)){");
		bw.newLine();
		bw.write("    		if(record.getBh()==key){");
		bw.newLine();
		bw.write("    			return record.getName();");
		bw.newLine();
		bw.write("    		}");
		bw.newLine();
		bw.write("    	}");
		bw.newLine();
		bw.write("    	return \"\";");
		bw.newLine();
		bw.write("	 }");
		bw.newLine();

		bw.write("	class YqtBm {");
		bw.newLine();
		bw.write("		private int bh = -1;");
		bw.newLine();
		bw.write("		private String name = null;");
		bw.newLine();
		bw.write("		private List<YqtBm> childs = null;");
		bw.newLine();
		bw.write("		public Integer getBh() {");
		bw.newLine();
		bw.write("			return this.bh;");
		bw.newLine();
		bw.write("		}");
		bw.newLine();

		bw.write("		public void setBh(Integer bh) {");
		bw.newLine();
		bw.write("			this.bh = bh;");
		bw.newLine();
		bw.write("		}");
		bw.newLine();

		bw.write("		public String getName() {");
		bw.newLine();
		bw.write("			return this.name;");
		bw.newLine();
		bw.write("		}");
		bw.newLine();

		bw.write("		public void setName(String name) {");
		bw.newLine();
		bw.write("			this.name = name;");
		bw.newLine();
		bw.write("		}");
		bw.newLine();

		bw.write("		public List<YqtBm> getChildsList() {");
		bw.newLine();
		bw.write("			if (this.childs == null) {childs = new ArrayList();}");
		bw.newLine();
		bw.write("				return this.childs;");
		bw.newLine();
		bw.write("			}");
		bw.newLine();
		bw.write("		}");
		bw.newLine();

		bw.newLine();
		bw.newLine();
		bw.write("}");
		bw.write("");

		bw.close();

	}

	/***
	 * 增加下级编码:
	 * 
	 * @throws IOException
	 */
	private void addChildBm(MyNewBM parent, int index) throws IOException {

		String temp = "";
		for (int i = 0; i < index; i++) {
			temp = temp + "		";
		}

		if (parent.getChilds().size() == 0)
			return;
		bw.newLine();
		bw.write(temp + "		childs" + index + "=bm.getChildsList();");
		bw.newLine();
		for (MyNewBM child : parent.getChilds()) {

			bw.write(temp + "		bm=new YqtBmConstants().new YqtBm();");
			bw.newLine();
			bw.write(temp + "		bm.setBh(" + child.getBm() + ");");
			bw.newLine();
			bw.write(temp + "		bm.setName(\"" + child.getName() + "\");");
			bw.newLine();
			bw.write(temp + "		childs" + index + ".add(bm);");
			bw.newLine();

			this.addChildBm(child, index + 1);

		}

	}

	public Iterator<ILevelObj> processFile(final FileImpl ifile, int index) throws Exception {

		if (index == 0) {
			bw.write("package com.team.baseframe.model;");
			bw.newLine();
			bw.write("import java.util.ArrayList;");
			bw.newLine();
			bw.write("import java.util.HashMap;");
			bw.newLine();
			bw.write("import java.util.List;");
			bw.newLine();

			bw.newLine();
			bw.write("public class YqtBmConstants {");
			bw.newLine();
			bw.newLine();
			bw.write("	private static final HashMap<String, List<YqtBm>> bmTables = new HashMap<String, List<YqtBm>>();");
			bw.newLine();

		}

		return super.processFile(ifile, index);

	}

	@Override
	public Iterator<ILevelObj> processProto(ProtoObj proto, int index) throws Exception {

		String tableName = "bm_" + proto.toString().trim();

		bw.write("	public  static   final String ");
		// bw.write( proto.toString().toUpperCase() );
		bw.write(tableName);
		bw.write("=\"");
		bw.write(proto.toString());
		bw.write("\";");
		bw.newLine();

		curTable = new ArrayList<MyNewBM>();
		tableNames.add(tableName);

		bw.write("    public   static  final  class " + proto.toString().trim() + "  {");
		bw.newLine();
		return super.processProto(proto, index);
	}

	@Override
	public void endProto(ProtoObj proto) throws Exception {
		bw.newLine();
		bw.write("    }");
		bw.newLine();
		bw.newLine();
		bw.newLine();
		tables.add(curTable);

		uiSdjsBms.clear();

	}

	private MyNewBM curBmObj = null;

	@Override
	public Iterator<ILevelObj> processFiled(FieldObj field, int index) throws Exception {

		String key = field.getFieldName().trim();
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

		curBmObj = new MyNewBM(codes[pathCount - 1], field.toString(), field.getField3());

		if (uiSdjsBms.get(fKey) == null) {
			curTable.add(curBmObj);
		} else {
			uiSdjsBms.get(fKey).getChilds().add(curBmObj);
		}

		uiSdjsBms.put(key, curBmObj);

		return super.processFiled(field, index);
	}

	@Override
	public void endFiled(FieldObj field) throws Exception {

		int bmCode = curBmObj.getBm();
		// String des=field.getField3();
		String des = curBmObj.getDesc();
		bw.write("       public  static final int  " + des + "=" + bmCode + ";");
		bw.newLine();
		if (field.getTableName().contains("YqtFileDir")) {
			bw.write("       public  static final String  " + des + "_dir=\"" + field.getFieldName() + "\";");
			bw.newLine();
		}
	}

}