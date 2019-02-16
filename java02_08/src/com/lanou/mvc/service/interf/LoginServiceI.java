package com.lanou.mvc.service.interf;

import com.lanou.mvc.beans.User;

/**
 *
 * @author LiuXu
 * @time2018年7月9日下午5:04:30
 **/
public interface LoginServiceI {

	/**
	 * 登录验证的方法
	 * @param user user对象(存放用户信息)
	 * @return 是否成功
	 */
	boolean logincheck(User user);
	
	
}
