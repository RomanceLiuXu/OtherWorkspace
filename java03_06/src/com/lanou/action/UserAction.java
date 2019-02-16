package com.lanou.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lanou.bean.User;
import com.lanou.dao.UserDao;
import com.lanou.service.UserService;
import com.lanou.service.interf.UserServiceI;
import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author LiuXu
 * @time2018年8月1日上午9:15:40
 **/
public class UserAction {

	private String name;
	private String psw;
	private int uid;
	private User user;
	private int flag;

	UserServiceI service = new UserService();
	UserDao dao = new UserDao();

	public String login() {
		System.out.println("action:" + name + "--" + psw + "--" + flag);
		// service对象调方法
		String result = service.loginS(name, psw, flag);
		if (result.equals("success")) {
			initHome();
		}
		return result;
	}

	public String delete() {
		boolean is = service.deleteUser(uid);
		System.out.println("是否删除:" + is + "-" + uid);
		if (is) {
			initHome();
		}
		return "home";
	}

	public String add() {
		boolean addUser = service.addUser(user);
		System.out.println("是否添加:" + addUser);
		if (addUser) {
			initHome();
		}
		return "home";
	}

	// 注册
	public String reginster() {
		boolean addUser = service.addUser(user);
		if (addUser) {
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.setAttribute("user", user);
			return "success";
		}
	    return "error";
	}

	public String update() {
		boolean isUp = service.updateUser(user);
		System.out.println("是否修改:" + isUp);
		if (isUp) {
			initHome();
		}
		return "home";
	}

	// 页面初始化的方法
	public void initHome() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		// 主页面的初始化数据
		List<User> users = service.homeUser(6, 1);
		// 初始化数据页码
		int pageNum = dao.pageNum(6);
		session.setAttribute("users", users);
		session.setAttribute("pageNum", pageNum);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
