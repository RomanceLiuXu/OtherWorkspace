package com.lanou.service;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lanou.bean.User;
import com.lanou.dao.UserDao;
import com.lanou.dao.interf.UserDaoI;
import com.lanou.service.interf.UserServiceI;

/**
 *
 * @author LiuXu
 * @time2018年8月1日上午9:25:43
 **/
public class UserService implements UserServiceI {
	UserDaoI dao = new UserDao();

	@Override
	public String loginS(String name, String psw, int flag) {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if (flag == 1) {
			// 登录---调用dao层方法
			String res = dao.loginD(name, psw);
			// 如果session中已经存在指责需要删除
			if (session.getAttribute("name") != null) {
				session.removeAttribute("name");
			}
			return res;
		} else if (flag == 2) {
			// 保存登录--调用dao层方法并保存
			String res = dao.loginD(name, psw);
			if (res.equals("success")) {
				session.setAttribute("name", name);
			}
			return res;
		} else {
			// 操作错误
			return "error";
		}

	}

	@Override
	public List<User> homeUser(int pnum, int page) {
		pnum = 6;
		List<User> users = dao.homeUser(pnum, page);
		return users;
	}

	@Override
	public boolean deleteUser(int uid) {

		return dao.deleteUser(uid);
	}

	@Override
	public boolean addUser(User user) {
		boolean addUser = false;
		if (user != null) {
			addUser = dao.addUser(user);
		}
		return addUser;
	}

	@Override
	public boolean updateUser(User user) {
		boolean updateUser = false;
		if (user!=null) {
			 updateUser = dao.updateUser(user);
		}
		return updateUser;
	}

}
