package com.lanou.service;

import com.lanou.bean.User;

/**
 *
 * @author LiuXu
 * @time2018年8月25日下午2:47:13
 **/

public interface UserService {

	/** 登录用户*/
	public User findUser(User user);
	
	/** 注册用户*/
	public void saveUser(User user);
	
    /** 用户名验证*/
	public boolean checkUser(String username);
	
	
	
}
