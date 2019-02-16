package com.lanou.action;

/**
 *
 * @author LiuXu
 * @time2018年7月26日下午4:49:13
 **/
public class Test2Action {

	private String code;
	private String psw;
	private String message;

	public String method() {

		System.out.println(code + "" + psw);
		return "success";
	}

	public String loginMethod() {
		// if (this.getCode().equals("liuxu")&&this.getPsw().equals("123456")) {
		if (code.equals("liuxu") && psw.equals("123456")) {
			this.setMessage("登录成功");
			return "success";
		} else

		{
			this.setMessage("用户名或密码不匹配");
			return "error";
		}

	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

}
