package com.server.common;

import com.alibaba.fastjson.JSONObject;

public class CbhsResUtils {
	public static JSONObject suc() {
		JSONObject jo = new JSONObject();
		jo.put("code", 0);
		jo.put("message", "操作成功!");
		return jo;
	}

	public static JSONObject fail() {
		JSONObject jo = new JSONObject();
		jo.put("code", -1);
		return jo;
	}
}
