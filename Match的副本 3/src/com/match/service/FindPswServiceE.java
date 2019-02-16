package com.match.service;

import java.util.List;

import com.match.beans.User;
import com.match.dao.LoginDaoE;
import com.match.service.interf.FindPswServiceI;

/**
 * 修改密码
 * 
 * @author LiuXu
 * @time2018年7月13日下午9:17:26
 **/
public class FindPswServiceE implements FindPswServiceI {

	LoginDaoE logindao = new LoginDaoE();

	public boolean findPsw(String name, String answer) {
		if (name != null && name != "" && answer != null && answer != "") {
			// 调用dao层的数据
			List<User> users = logindao.findUsers();
			// 遍历
			for (User user : users) {
				if (user.getName().equals(name) && user.getAnswer().equals(answer)) {
					System.out.println(user.toString());
					return true;
				}
			}
		}

		return false;
	}

}
