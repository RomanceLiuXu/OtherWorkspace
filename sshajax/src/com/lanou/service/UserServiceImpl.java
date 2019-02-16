package com.lanou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.bean.User;
import com.lanou.dao.UserDao;

/**
 *
 * @author LiuXu
 * @time2018年9月10日上午11:41:31
 **/
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Override
	public boolean login(User loginUser) {
		User user = userDao.findUserByUsernameAndPassword(loginUser.getUsername(), loginUser.getPassword());
		if (user==null) {
			return false;
		}else{
			return true;
		}
	}

}
