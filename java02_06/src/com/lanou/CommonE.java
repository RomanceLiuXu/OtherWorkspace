package com.lanou;

/**
 *
 * @author LiuXu
 * @time2018年7月5日下午4:45:14
 **/
public class CommonE {

	private int code;// 接口返回的状态码
	private String msg;
	private Object content;

	@Override
	public String toString() {
		return "CommonE [code=" + code + ", msg=" + msg + ", content=" + content + "]";
	}

	public CommonE() {
		super();
	}

	public CommonE(int code, String msg, Object content) {
		super();
		this.code = code;
		this.msg = msg;
		this.content = content;
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
