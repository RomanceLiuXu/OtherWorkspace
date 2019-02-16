package com.stu.mvc.beans;

/**
 *
 * @author LiuXu
 * @time2018年7月10日上午9:35:02
 **/
public class Common {

	private int code;
	private String msg;
	private Object content;

	public Common() {
		super();
	}

	public Common(int code, String msg, Object content) {
		super();
		this.code = code;
		this.msg = msg;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Common [code=" + code + ", msg=" + msg + ", content=" + content + "]";
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

}
