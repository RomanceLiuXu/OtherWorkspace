package com.match.service;

import com.match.beans.User;
import com.match.dao.RegisterDaoE;
import com.match.service.interf.RegisterServiceI;

/**
 *
 * @author keb
 * @tim2018年7月12日下午3:49:22
 **/
public class RegisterServiceE implements RegisterServiceI{

	@Override
	public int addMethod(User user) {
		//调用到层的方法;
		RegisterDaoE regdao = new RegisterDaoE();
		int num = regdao.addMethod(user);
		return num;
	}

}
