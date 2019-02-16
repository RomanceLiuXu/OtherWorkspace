package com.lanou.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

/**
 *  保存登录状态
 * @author LiuXu
 * @time2018年7月27日下午2:46:54
 **/
public class Test6Action implements SessionAware{

	private String code;
	private String psw;
	private Map<String, Object> session;
	
	public String saveMethod() {
		if (code!=null&&!"".equals(code)) {
			session.put("usercode", code);
		}
		return "success";
	}
	
	
	
	public Map<String, Object> getSession() {
		return session;
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
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	
}
