package com.lanou.action;

import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author LiuXu
 * @time2018年7月27日下午4:05:03
 **/
public class Test8Action extends ActionSupport implements RequestAware{

	private String code;
	private String psw;
    private Map<String, Object> request;
 	
    
    
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

	public String method() {
		System.out.println("method");

		return "success";
	}

	/**
	 * 复写父类的方法(用来实现数据校验) 在执行接口方法之前会执行该方法
	 */
	@Override
	public void validate() {
		super.validate();
		System.out.println("validate");
		if (code != null && !code.equals("") && psw != null && !psw.equals("")) {
			System.out.println("执行方法");
		} else {
			System.out.println("不执行方法");
			request.put("message", "输入的账号或密码有误");
			addFieldError("message", "输入的账号或密码有误");
		
		}
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.request =arg0;
		
	}

}
