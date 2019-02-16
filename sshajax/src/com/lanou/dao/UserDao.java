package com.lanou.dao;

import com.lanou.bean.User;

/**
 *
 * @author LiuXu
 * @time2018年9月10日上午11:30:46
 **/
public interface UserDao {

	/**
	 * 登录
	 * @param username
	 * @param password
	 * @return
	 */
	public User findUserByUsernameAndPassword(String username,String password);
	
}
