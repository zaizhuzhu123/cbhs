package com.server.exception;

import java.util.List;

import com.server.pojo.bean.uiExceedInfo;

public class ExceedException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private ExceedExceptionObj info;

	public ExceedException(String errorMessage, List<uiExceedInfo> exceedInfos) {
		super();
		this.info = this.new ExceedExceptionObj(errorMessage, exceedInfos);
	}

	public ExceedExceptionObj getInfo() {
		return info;
	}

	public void setInfo(ExceedExceptionObj info) {
		this.info = info;
	}

	public class ExceedExceptionObj {
		private int errorCode = 30000;
		private String errorMessage;
		private List<uiExceedInfo> exceedInfos;

		public int getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(int errorCode) {
			this.errorCode = errorCode;
		}

		public String getErrorMessage() {
			return errorMessage;
		}

		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		public List<uiExceedInfo> getExceedInfos() {
			return exceedInfos;
		}

		public void setExceedInfos(List<uiExceedInfo> exceedInfos) {
			this.exceedInfos = exceedInfos;
		}

		public ExceedExceptionObj(String errorMessage, List<uiExceedInfo> exceedInfos) {
			super();
			this.errorMessage = errorMessage;
			this.exceedInfos = exceedInfos;
		}

	}
}
