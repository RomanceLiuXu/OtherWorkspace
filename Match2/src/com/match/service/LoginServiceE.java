package com.match.service;

import java.util.ArrayList;
import java.util.List;

import com.match.beans.User;
import com.match.beans.UserP;
import com.match.dao.LoginDaoE;
import com.match.service.interf.LoginServiceI;

/**
 *
 * @author LiuXu
 * @time2018年7月11日下午7:08:50
 **/
public class LoginServiceE implements LoginServiceI {

	// 实例化
	LoginDaoE loginDao = new LoginDaoE();

	@Override
	public User singleUser(String name, String psw) {
		if (!name.equals("") && !psw.equals("")) {
			// 调用dao层方法，返回集合
			List<User> users = loginDao.findUsers();
			// 遍历
			for (User user : users) {
				if (user.getName().equals(name) && user.getPsw().equals(psw)) {
					// 存在该用户
					System.out.println(user);
					return user;
				}
			}

		}

		return null;
	}

	@Override
	public UserP userLogin(String name, String psw) {
	
	 UserP userP = loginDao.userLogin(name, psw);
		
		return userP;
	}

}
