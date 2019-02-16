package com.lanou.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lanou.bean.User;
import com.lanou.service.UserService;

/**
 *
 * @author LiuXu
 * @time2018年8月27日上午11:14:33
 **/
@Controller("registerAction")
public class RegisterAction {
	@Autowired
	private UserService userService;
	private String username;
	private String password;
	private String phone;
	private String password_confirmation;
	private int result;

	public String reginster() {
		String[] parameters = { username, password, phone, password_confirmation };
		// 判空
		if (IsNull(parameters)) {
			// 两次密码是否一致
			if (password.equals(password_confirmation)) {
				this.result = 2;
			} else {
				// 用户名是否重复
				if (userService.checkUser(username)) {
					// 数据正确，插入数据
					userService.saveUser(new User(username, phone, password));
					this.result = 1;
				} else {
					this.result = 3;
				}
			}
		} else {
			this.result = 4;
		}
		return "success";
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword_confirmation() {
		return password_confirmation;
	}

	public void setPassword_confirmation(String password_confirmation) {
		this.password_confirmation = password_confirmation;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public boolean IsNull(String[] parameters) {
		for (String string : parameters) {
			if (string == null || "".equals(string)) {
				return false;
			}
		}
		return true;
	}

}
