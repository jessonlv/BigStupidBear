package com.lv.service.utils;

/**
 * @Title: StatusCode.java
 * @Package com.momentcam.service.utils
 * @Description: TODO(用一句话描述该文件做什么)
 * @author jessonlv okstack@gmail.com
 * @date 24Oct.,2016 6:04:03 pm
 * @version V1.0
 */

public enum StatusCode {
	
	SUCCESS(0, "SUCCESS"), FAIL(1, "FAIL"), SYS_ERROR(11111, "Sys Error"), DB_ERROR(99999,
			"DB Error");

	private int code;

	private String codeMsg;

	StatusCode(int code, String codeMsg) {
		this.code = code;
		this.codeMsg = codeMsg;
	}

	public int getCode() {
		return code;
	}

	private void setCode(int code) {
		this.code = code;
	}

	public String getCodeMsg() {
		return codeMsg;
	}

	private void setCodeMsg(String codeMsg) {
		this.codeMsg = codeMsg;
	}
}
