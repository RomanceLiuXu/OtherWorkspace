package com.lanou.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lanou.bean.User;
import com.lanou.dao.LoginDaoE;
import com.lanou.dao.interf.LoginDaoI;
import com.lanou.service.interf.LoginServiceI;

/**
 *
 * @author LiuXu
 * @time2018年7月18日上午11:31:23
 **/
public class LoginServiceE implements LoginServiceI {

	// 实例化
	LoginDaoI dao = new LoginDaoE();
	boolean boo = false;

	@Override
	public boolean checkLogin(String username, String password, String flag, HttpServletRequest req,
			HttpServletResponse res) {

		if (jumpString(username) && jumpString(password)) {
			// 非空
			User user = new User();
			user.setName(username);
			user.setPsw(password);
			// 调用dao层方法
			boo = dao.checkLogin(user);
			if (boo) {
				if ("on".equals(flag)) {
					// 保存登录----成功则保存登录状态
					HttpSession session = req.getSession();
					session.setAttribute("user", user);
				}
			}

		}

		return boo;
	}

	public boolean jumpString(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		return true;
	}

}
