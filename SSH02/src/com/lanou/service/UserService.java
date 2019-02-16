package com.lanou.service;

import com.lanou.bean.User;

/**
 *
 * @author LiuXu
 * @time2018年9月10日上午11:39:21
 **/
public interface UserService {

	/**
	 * 处理用户登录
	 * @param loginUser：封装用户填写的账号和密码
	 * @return 登录成功为true 失败为false
	 */
	public boolean login(User loginUser);
	
}
