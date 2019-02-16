package com.lanou.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/**
*
* @author LiuXu
* @time2018年7月27日下午7:32:37
**/
public class LoginAction implements SessionAware{
 
	  private String code;
	  private String psw;
	  private String remember;//记住登录
	  private String message;//提示信息
	  private Map<String, Object> session;
	
	public String LoginCheck() {
		if ("liuxu".equals(code)&&"123456".equals(psw)) {
			if ("on".equals(remember)) {
				session.put("code", code);
			}
		}else {
			this.message = "账号或密码不匹配";
			return "error";
		}
		
		return "success";
	}
	
	@Override
	public void setSession(Map<String, Object> session) {
		 this.session = session;
	}
	


	public String getRemember() {
		return remember;
	}



	public void setRemember(String remember) {
		this.remember = remember;
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



	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}





	
	
	
	
}
