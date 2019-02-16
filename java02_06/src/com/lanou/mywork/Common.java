package com.lanou.mywork;

/**
 *
 * @author LiuXu
 * @time2018年7月5日下午7:10:10
 **/
public class Common {

	private int code;
	private String msg;
	private Object data;

	public Common() {
		super();
	}

	public Common(int code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	@Override
	public String toString() {
		return "Common [code=" + code + ", msg=" + msg + ", data=" + data + "]";
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
