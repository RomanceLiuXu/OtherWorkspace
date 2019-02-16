package com.match.hibernateI;

import java.util.List;

import com.liuxu.beans.User;

/**
 *  登录的接口
 * @author LiuXu
 * @time2018年8月18日下午5:28:19
 **/
public interface UserHibernateI {

	/**
	 * 登录的验证
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 主页面的数据
	 * @return
	 */
	public List<User> findAllUsers(User user);
	
	
	/**
	 * 注册
	 * @return
	 */
	public boolean register(User user);
	
	/*
	 * 同城匹配
	 */
	public List<User> sameCity(User user);
	
	
	/*
	 * 异城匹配
	 */
	public List<User> notSameCity(User user);
	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 */
	public boolean updatePsw(User user,String newPsw);
	
	/**
	 * 检验密保
	 * @param user
	 * @return
	 */
	public User checkPsw(String name,String answer);
	
	
}
