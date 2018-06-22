package com.server.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenManager {

	private static Map<String, String> all_tokes = new ConcurrentHashMap<>();

	private static Map<String, String> checktokens = new ConcurrentHashMap<>();

	private static TokenManager single = null;

	public void addToken(String accountKey, String token) {
		String oldToken = all_tokes.get(accountKey);
		if (oldToken != null) {
			checktokens.remove(oldToken);
		}
		all_tokes.put(accountKey, token);
		checktokens.put(token, "");
	}

	public void removeToken(String accountKey) {
		String token = all_tokes.get(accountKey);
		if (token != null) {
			checktokens.remove(token);
		}
		all_tokes.remove(accountKey);
	}

	public static synchronized TokenManager getInstance() {
		if (single == null) {
			single = new TokenManager();
		}
		return single;
	}

	public boolean checkToken(String token) {
		return checktokens.get(token) != null;
	}
}
