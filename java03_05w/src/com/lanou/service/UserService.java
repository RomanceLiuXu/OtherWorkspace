package com.lanou.service;

import com.lanou.bean.User;
import com.lanou.dao.UserDao;
import com.lanou.dao.interf.UserDaoI;
import com.lanou.service.interf.UserServiceI;

/**
 *
 * @author LiuXu
 * @time2018年7月30日上午9:58:01
 **/
public class UserService implements UserServiceI {
	UserDaoI dao = new UserDao();

	@Override
	public String LoginCheck(User user) {
		String result = "";
		if (IsNull(user)) {
			result = dao.LoginCheck(user);
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

	@Override
	public int Reginster(User user) {
	
		return 0;
	}
}
