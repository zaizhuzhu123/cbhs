package com.cbhs.gencode.api.task.process.url;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cbhs.gencode.api.task.api.ILevelObj;
import com.cbhs.gencode.api.task.api.IObjProcess;
import com.cbhs.gencode.api.task.entity.FileImpl;
import com.cbhs.gencode.api.task.entity.NewFieldObj;
import com.cbhs.gencode.api.task.entity.ProtoObj;
import com.cbhs.gencode.api.task.web.entity.SimpleWebCommandOperationInfo;
import com.cbhs.gencode.api.util.iterable.PrefetchingIterator;

public class UrlEntityFile implements ILevelObj {
	FileImpl file = null;

	public UrlEntityFile(SimpleWebCommandOperationInfo urlInfo, String fileName) throws Exception {

		file = new FileImpl();
		if (fileName != null) {
			file.setFileName(fileName);
		}
		String requestMsg = urlInfo.getMsgReaquest();
		String jsr303 = urlInfo.getJsr303Str();
		if (UrlUtil.isInnerBean(requestMsg)) {
			ProtoObj proto = new ProtoObj(UrlUtil.getInnerRequestBeanName(urlInfo.getUrl(), false));
			parseInnerBean(proto, requestMsg, jsr303, urlInfo.getReaquestDepict());
			file.add(proto);
		}
		String response = urlInfo.getMsgResponse();
		if (UrlUtil.isInnerBean(response)) {
			ProtoObj proto = new ProtoObj(UrlUtil.getInnerResponseBeanName(urlInfo.getUrl(), false));
			parseInnerBean(proto, response, jsr303, urlInfo.getResponseDepict());
			file.add(proto);
		}
	}

	@Override
	public Iterator<ILevelObj> process(IObjProcess process, int index) throws Exception {

		return new PrefetchingIterator<ILevelObj>() {
			private int index = 0;

			@Override
			protected ILevelObj fetchNextOrNull() {
				if (index == 0) {
					index++;
					return file;
				}
				return null;
			}

		};

	}

	@Override
	public void endprocess(IObjProcess process) throws Exception {
		// TODO Auto-generated method stub

	}

	private void parseInnerBean(ProtoObj proto, String msg, String jsr303, String fieldMsg) {
		if (msg.startsWith("{")) {
			JSONObject json = JSON.parseObject(msg);
			parseJson(proto, json);
		} else {
			parseNoJson(proto, msg, jsr303, fieldMsg);
		}
	}

	private void parseInnerBean(ProtoObj proto, String msg) {
		if (msg.startsWith("{")) {
			JSONObject json = JSON.parseObject(msg);
			parseJson(proto, json);
		} else {
			parseNoJson(proto, msg);
		}
	}

	private void parseJson(ProtoObj proto, JSONObject json) {
		Set<String> keyset = json.keySet();
		int i = 1;
		for (String key : keyset) {
			Object o = json.get(key);
			if (o instanceof JSONObject) {
				String tableName = proto.getTableName() + i++;
				ProtoObj innerProto = new ProtoObj(tableName);
				parseJson(innerProto, (JSONObject) o);
				file.add(innerProto);
				addField(proto, key, tableName);
			} else if (o instanceof JSONArray) {
				JSONArray array = (JSONArray) o;
				int size = array.size();
				if (size == 0) {
					System.err.println("error parse inner bean:" + proto.getTableName() + " msg:" + json.toJSONString());
				} else {
					Object subObject = array.get(0);
					if (subObject instanceof JSONObject) {
						String tableName = proto.getTableName() + i++;
						ProtoObj innerProto = new ProtoObj(tableName);
						parseJson(innerProto, (JSONObject) subObject);
						file.add(innerProto);
						addField(proto, key, tableName + "[]");
					} else {
						System.err.println("error parse inner bean:" + proto.getTableName() + " msg:" + json.toJSONString());
					}
				}
			} else if (o instanceof String) {
				addField(proto, key, (String) o);
			} else {
				System.err.println("error parse inner bean:" + proto.getTableName() + " msg:" + json.toJSONString());
			}
		}
	}

	private void parseNoJson(ProtoObj proto, String msg, String jsr303, String fieldMsg) {
		String[] fields = msg.split(",");
		String[] fieldMsgs = fieldMsg.split(",");
		for (int i = 0; i < fields.length; i++) {
			String field = fields[i];
			String[] attributes = field.split(":");
			String name = attributes[0].trim();
			String type = null;
			try {
				type = attributes[1].trim();
			} catch (Exception e) {
				System.out.println(msg);
			}
			String fieldsMsg = null;
			if (fieldMsgs.length == fields.length) {
				fieldsMsg = fieldMsgs[i];
			}
			addField(proto, name, type, jsr303, fieldsMsg);
		}
	}

	private void parseNoJson(ProtoObj proto, String msg) {
		String[] fields = msg.split(",");
		for (String field : fields) {
			String[] attributes = field.split(":");
			String name = attributes[0].trim();
			String type = attributes[1].trim();
			addField(proto, name, type);
		}
	}

	private void addField(ProtoObj proto, String name, String type) {
		int arrayIndex = -1;
		if (!type.equals("byte[]")) {
			arrayIndex = type.indexOf("[]");
			if (arrayIndex != -1) {
				type = type.substring(0, arrayIndex);
			}
		}

		List<String> values = new ArrayList<String>();
		values.add(name);// 0
		values.add("");// 1
		values.add("");// 2
		values.add(convertTypeToProto(type));// 3
		values.add("");// 4
		values.add("");// 5
		if (arrayIndex != -1) {
			values.add("t");// 6
		} else {
			values.add("");// 6
		}
		values.add("");// 7
		values.add("");// 8
		NewFieldObj fidldObj = new NewFieldObj(values, proto.getTableName());
		proto.add(fidldObj);
	}

	private void addField(ProtoObj proto, String name, String type, String jsr303, String fieldMsg) {
		int arrayIndex = -1;
		if (!type.equals("byte[]")) {
			arrayIndex = type.indexOf("[]");
			if (arrayIndex != -1) {
				type = type.substring(0, arrayIndex);
			}
		}

		List<String> values = new ArrayList<String>();
		values.add(name);// 0
		values.add("");// 1
		values.add("");// 2
		values.add(convertTypeToProto(type));// 3
		values.add("");// 4
		values.add("");// 5
		if (arrayIndex != -1) {
			values.add("t");// 6
		} else {
			values.add("");// 6
		}
		values.add("");// 7
		values.add("");// 8

		if (fieldMsg != null) {
			values.add(fieldMsg);// 9
		} else {
			values.add("");// 9
		}
		if (jsr303 != null && jsr303.trim().length() > 0) {
			System.out.println(jsr303);
			JSONObject jo = (JSONObject) JSON.parse(jsr303);
			JSONArray jarray = jo.getJSONArray(name);
			if (jarray != null) {
				values.add(jarray.toJSONString());// 10
			}
		} else {
			values.add("");// 10
		}
		NewFieldObj fidldObj = new NewFieldObj(values, proto.getTableName());
		proto.add(fidldObj);
	}

	private String convertTypeToProto(String type) {
		if (type.toLowerCase().equals("int")) {
			return "int32";
		} else if (type.toLowerCase().equals("long")) {
			return "int64";
		} else if (type.toLowerCase().equals("string")) {
			return "string";
		} else if (type.toLowerCase().equals("double")) {
			return "double";
		}
		// else if (type.toLowerCase().equals("boolean")) {
		// return "bool";
		// }
		else {
			return type;
		}
	}

	public static void main(String[] args) {
		String s = "{\"hws\":[{\"name\":\"String\",\"online\":\"boolean\"}]}";
		JSONObject json = JSON.parseObject(s);
		System.out.println(json);
	}

	public class UrlEntityFile12 {

	}

}
