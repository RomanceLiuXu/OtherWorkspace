package com.match.service.interf;

import java.util.List;

import com.match.beans.User;

/**
 *
 * @author LiuXu
 * @time2018年7月11日下午7:09:17
 **/
public interface LoginServiceI {

	/**
	 * 返回存在在数据库中的单个用户
	 * 
	 * @param name
	 *            用户名
	 * @param psw
	 *            用户密码
	 * @return 用户对象
	 */
	User singleUser(String name, String psw);

}
