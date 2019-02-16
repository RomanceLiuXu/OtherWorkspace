package com.lanou.service.interf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* 登录的service层接口
* @author LiuXu
* @time2018年7月18日上午11:28:10
**/
public interface LoginServiceI {

	/**
	 * 
	 * @param username 用户名
	 * @param password 密码
	 * @param flag 是否保存登录的标示
	 * @return 是否登录成功
	 */
	boolean checkLogin(String username,String password,String flag,HttpServletRequest req, HttpServletResponse res);
	
}
