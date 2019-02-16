package com.lanou.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lanou.bean.User;
import com.lanou.service.UserService;
import com.lanou.service.interf.UserServiceI;

/**
 *
 * @author LiuXu
 * @time2018年8月1日上午11:58:15
 **/
public class HomeAction {

	private int page;
	private List<User> users;

	public String showHome() {

		return "home";
	}
     
	public String showPage() {
		UserServiceI service = new UserService();
		 users = service.homeUser(6, page);
		if (users!=null) {
		   return "home";
		}
		return "error";
	}
	
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
