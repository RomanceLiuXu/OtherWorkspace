package com.lanou.action;

import com.lanou.bean.User;
import com.lanou.service.UserService;
import com.lanou.service.interf.UserServiceI;

/**
 *
 * @author LiuXu
 * @time2018年7月30日上午10:08:08
 **/
public class LoginAction {

	private User user;

	public String LogAction() {
     String result ="";		
		if (IsNull(user)) {
			UserServiceI service = new UserService();
			 result = service.LoginCheck(user);
//			 System.out.println(user.getName()+":"+user.getPsw()+"---"+result);
		}
		return result;
	}
	
	
	public boolean IsNull(User user) {
		boolean flag = false;
		if (user.getName() != null&&!"".equals(user.getName()) && user.getPsw()!= null && !"".equals(user.getPsw())) {
			flag = true;
		}
		return flag;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
