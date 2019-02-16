package com.match.dao.interf;

import java.util.List;

import com.match.beans.User;
import com.match.beans.UserP;

/**
 *
 * @author LiuXu
 * @time2018年7月11日下午7:06:57
 **/
public interface LoginDaoI {

	/**
	 * 查询所有用户
	 * 
	 * @return
	 */
	List<User> findUsers();
	
	
	public UserP userLogin(String name,String psw);
}
