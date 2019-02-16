package com.lanou.dao;

import com.lanou.bean.User;

/**
 *
 * @author LiuXu
 * @time2018年8月25日下午2:16:27
 **/
public interface UserDao {

	/** 用户登录*/
	public User findUser(User user);
	
	/**用户注册*/
	public void saveUser(User user);
	
	
	public boolean checkUser(String username);
	
}
