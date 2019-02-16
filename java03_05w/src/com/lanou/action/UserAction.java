package com.lanou.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lanou.bean.User;
import com.lanou.service.UserService;
import com.lanou.service.interf.UserServiceI;
import com.opensymphony.xwork2.ActionContext;

/**
 *
 * @author LiuXu
 * @time2018年7月30日上午10:08:08
 **/
public class UserAction {

	private User user;//登录的用户
	private String remember;//保存登录

	public String login() {
     String result ="";		
		if (IsNull(user)) {
			UserServiceI service = new UserService();
			 result = service.LoginCheck(user);
			 if (remember!=null) {
				 ActionContext.getContext().getSession().put("user", user);
			}
		}
		return result;
	}
	
	public String destroy() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Object object = session.getAttribute("user");
		if (object!=null&&!"".equals(object)) {
			session.removeAttribute("user");
		}
		return "login";
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


	public String getRemember() {
		return remember;
	}


	public void setRemember(String remember) {
		this.remember = remember;
	}

}
