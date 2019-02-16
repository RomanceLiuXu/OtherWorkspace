package com.lanou.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lanou.bean.User;
import com.lanou.dao.UserDao;

/**
 *
 * @author LiuXu
 * @time2018年8月25日下午2:51:07
 **/
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public User findUser(User user) {
	
		return userDao.findUser(user);
	}

	@Override
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	public boolean checkUser(String username) {
		
		return userDao.checkUser(username);
	}


}
