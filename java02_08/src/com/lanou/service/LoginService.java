package com.lanou.service;

import com.lanou.dao.LoginDao;
import com.lanou.mvc.beans.User;
import com.lanou.mvc.dao.interf.DaoInterf;
import com.lanou.mvc.service.interf.LoginServiceI;
/**
 *
 * @author LiuXu
 * @time2018年7月9日下午5:13:58
 **/
public class LoginService implements LoginServiceI {

	// 实例化dao层对象
	LoginDao dao = new LoginDao();

	@Override
	public boolean logincheck(User user) {
		boolean boo = false;
		if (!user.getCode().equals("") && !user.getPsw().equals("")) {
			// 连接dao层--返回是否存在user
			boo = dao.jumpLogin(user);

		}
		return boo;

	}

}
