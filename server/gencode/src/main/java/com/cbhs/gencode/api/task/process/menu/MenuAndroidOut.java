package com.cbhs.gencode.api.task.process.menu;

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
import com.cbhs.gencode.api.task.entity.NewFieldObj;
import com.cbhs.gencode.api.task.entity.ProtoObj;
import com.cbhs.gencode.api.task.process.AbstractProcess;

public class MenuAndroidOut extends AbstractProcess {

	private static String javaModelDir = "..\\app\\Accounting\\libframe\\src\\main\\java\\com\\lgx\\libframe\\model";

	private BufferedWriter javaBw = null;

	private List<String> protoNames = new ArrayList<String>();

	private List<List<MenuObj>> rowDatas = new ArrayList<List<MenuObj>>();

	public MenuAndroidOut(String dir) throws IOException {
		File direc = new File(dir + javaModelDir);
		if (!direc.exists()) {
			direc.mkdir();
		}
		String javaTargetFilePath = dir + javaModelDir + File.separator + "Menus.java";

		File targetfile = new File(javaTargetFilePath);
		if (!targetfile.exists()) {
			targetfile.createNewFile();
		}
		this.javaBw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetfile), "UTF-8"));
	}

	@Override
	public Iterator<ILevelObj> processProto(ProtoObj proto, int index) throws Exception {
		this.protoNames.add(proto.getTableName());
		List<MenuObj> menus = new ArrayList<MenuObj>();
		rowDatas.add(menus);
		return super.processProto(proto, index);
	}

	@Override
	public Iterator<ILevelObj> processFiled(FieldObj field, int index) throws Exception {
		if (index > 0) {
			NewFieldObj newField = (NewFieldObj) field;
			MenuObj menu = new MenuObj();
			menu.setMenuId(newField.getFielValue(0));
			menu.setMenuName(newField.getFielValue(1));
			menu.setMenuOpName(newField.getFielValue(2));
			menu.setAction(newField.getFielValue(3));
			menu.setIcon(newField.getFielValue(4));
			int lastIndex = menu.getMenuId().lastIndexOf(",");
			if (lastIndex == -1) {
				menu.setParentMenuId("0");
			} else {
				menu.setParentMenuId(menu.getMenuId().substring(0, lastIndex));
			}
			rowDatas.get(rowDatas.size() - 1).add(menu);
		}
		return super.processFiled(field, index);
	}

	public void finish() throws Exception {
		// 生成BaseC
		javaBw.write("package com.lgx.libframe.model;");
		javaBw.newLine();
		javaBw.write("import java.util.ArrayList;");
		javaBw.newLine();
		javaBw.write("import java.util.HashMap;");
		javaBw.newLine();
		javaBw.write("import java.util.List;");
		javaBw.newLine();
		javaBw.write("import java.util.Map;");
		javaBw.newLine();
		javaBw.newLine();
		javaBw.write("public class Menus {");
		javaBw.newLine();
		for (int i = 0; i < protoNames.size(); i++) {
			javaBw.write("	public static String " + protoNames.get(i) + " = \"" + protoNames.get(i) + "\";");
			javaBw.newLine();
		}
		javaBw.write("	public static Map<String, List<MenuObj>> allMenus = new HashMap<String, List<MenuObj>>();");
		javaBw.newLine();
		javaBw.write("	static {");
		javaBw.newLine();
		for (int i = 0; i < protoNames.size(); i++) {
			String protoName = protoNames.get(i);
			javaBw.write("		List<MenuObj> " + protoName + "_menuList = new ArrayList<MenuObj>();");
			javaBw.newLine();
			javaBw.write("		Menus.allMenus.put(" + protoName + ", " + protoName + "_menuList);");
			javaBw.newLine();
			List<MenuObj> menuObjs = rowDatas.get(i);
			for (int j = 0; j < menuObjs.size(); j++) {
				MenuObj m = menuObjs.get(j);
				String menuIdReplace = m.getMenuId().replace(",", "_");
				javaBw.write("		MenuObj " + protoName + "_menu" + menuIdReplace + " = new MenuObj();");
				javaBw.newLine();
				javaBw.write("		" + protoName + "_menu" + menuIdReplace + ".setMenuId(\"" + m.getMenuId() + "\");");
				javaBw.newLine();
				javaBw.write("		" + protoName + "_menu" + menuIdReplace + ".setMenuName(\"" + m.getMenuName() + "\");");
				javaBw.newLine();
				javaBw.write("		" + protoName + "_menu" + menuIdReplace + ".setMenuOpName(\"" + m.getMenuOpName() + "\");");
				javaBw.newLine();
				javaBw.write("		" + protoName + "_menu" + menuIdReplace + ".setAction(\"" + m.getAction() + "\");");
				javaBw.newLine();
				javaBw.write("		" + protoName + "_menu" + menuIdReplace + ".setIcon(\"" + m.getIcon() + "\");");
				javaBw.newLine();
				javaBw.write("		" + protoName + "_menu" + menuIdReplace + ".setParentMenuId(\"" + m.getParentMenuId() + "\");");
				javaBw.newLine();
				if (m.getMenuId().indexOf(",") == -1) {
					javaBw.write("		" + protoName + "_menu" + menuIdReplace + ".setChidren(new ArrayList<MenuObj>());");
					javaBw.newLine();
					javaBw.write("		" + protoName + "_menuList.add(" + protoName + "_menu" + menuIdReplace + ");");
				} else {
					javaBw.write("		" + protoName + "_menu" + m.getParentMenuId().replace(",", "_") + ".getChidren().add(" + protoName + "_menu" + menuIdReplace + ");");
				}
				javaBw.newLine();
			}
		}

		javaBw.write("	}");
		javaBw.newLine();
		javaBw.write("}");
		javaBw.newLine();
		javaBw.close();
	}

}
