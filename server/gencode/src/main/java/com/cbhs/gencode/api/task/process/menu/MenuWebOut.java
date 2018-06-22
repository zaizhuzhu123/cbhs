package com.cbhs.gencode.api.task.process.menu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.entity.FieldObj;
import com.cbhs.gencode.api.task.entity.NewFieldObj;
import com.cbhs.gencode.api.task.entity.ProtoObj;
import com.cbhs.gencode.api.task.process.AbstractProcess;

public class MenuWebOut extends AbstractProcess {

	private static String javaModelDir = "..\\web";

	private BufferedWriter javaBw = null;

	private List<String> protoNames = new ArrayList<String>();

	private List<Map<String, MenuObj>> rowDatas = new ArrayList<Map<String, MenuObj>>();

	private Map<String, List<MenuObj>> allMenus = new HashMap<String, List<MenuObj>>();

	public MenuWebOut(String dir) throws IOException {
		File direc = new File(dir + javaModelDir);
		if (!direc.exists()) {
			direc.mkdir();
		}
		String javaTargetFilePath = dir + javaModelDir + File.separator + "Menus.json";

		File targetfile = new File(javaTargetFilePath);
		if (!targetfile.exists()) {
			targetfile.createNewFile();
		}
		this.javaBw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetfile), "UTF-8"));
	}

	@Override
	public Iterator<ILevelObj> processProto(ProtoObj proto, int index) throws Exception {
		this.protoNames.add(proto.getTableName());
		Map<String, MenuObj> menusMap = new HashMap<String, MenuObj>();
		rowDatas.add(menusMap);
		List<MenuObj> menus = new ArrayList<MenuObj>();
		allMenus.put(proto.getTableName(), menus);
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
			menu.setChidren(new ArrayList<MenuObj>());
			rowDatas.get(rowDatas.size() - 1).put(menu.getMenuId(), menu);
		}
		return super.processFiled(field, index);
	}

	public void finish() throws Exception {
		// 生成BaseC

		for (int i = 0; i < protoNames.size(); i++) {
			String protoName = protoNames.get(i);
			Map<String, MenuObj> menuObjs = rowDatas.get(i);
			for (String key : menuObjs.keySet()) {
				MenuObj m = menuObjs.get(key);
				if (m.getMenuId().indexOf(",") == -1) {
					allMenus.get(protoName).add(m);
				} else {
					System.out.println(m.getParentMenuId());
					menuObjs.get(m.getParentMenuId()).getChidren().add(m);
				}
			}
		}
		String jsonString = JSON.toJSONString(allMenus, SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat);
		this.javaBw.write(jsonString);
		this.javaBw.close();
	}

}
