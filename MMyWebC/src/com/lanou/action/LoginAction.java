package com.lanou.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.lanou.bean.User;
import com.lanou.service.UserService;
import com.opensymphony.xwork2.Action;

/**
 *
 * @author LiuXu
 * @time2018年8月25日下午2:56:11
 **/
@Controller("userAction")
public class LoginAction implements SessionAware{
	@Resource
	private UserService userService;
	private String username;
	private String password;
	private int result;
	private Map<String, Object> session;

	public String login() {
		System.out.println(username + ":" + password);
		User loginUser = userService.findUser(new User(username, password));
		if (loginUser != null) {
			session.put("user",loginUser);
			this.result = 1;
		}else{
			this.result = 0;
		}
		System.out.println("Action界面:" + result);
		return "success";
	}

	public String register() {
		userService.saveUser(new User(username, password));

		return "register_suc";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0; 
		
	}

}
