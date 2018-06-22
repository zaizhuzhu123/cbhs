package com.server.common;

import java.io.Serializable;

public class CbhsTokenInfos implements Serializable {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1L;
	private Integer userOid;
	private String accountKey;
	private Long timestamp;
	private String userName;

	public Integer getUserOid() {
		return userOid;
	}

	public void setUserOid(Integer userOid) {
		this.userOid = userOid;
	}

	public String getAccountKey() {
		return accountKey;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public void setAccountKey(String accountKey) {
		this.accountKey = accountKey;
	}

	@Override
	public String toString() {
		return "CbhsTokenInfos [userOid=" + userOid + ", accountKey=" + accountKey + ", timestamp=" + timestamp + ", userName=" + userName + "]";
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
