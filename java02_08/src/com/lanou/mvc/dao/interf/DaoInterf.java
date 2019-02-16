package com.lanou.mvc.dao.interf;

import com.lanou.mvc.beans.User;

/**
*
* @author LiuXu
* @time2018年7月9日下午5:07:59
**/
public interface DaoInterf {

	/**
	 *  判断数据库的表中是否存在对应的数据
	 * @param user 需要进行判断的user对象
	 * @return 判断数据库中是否存在
	 */
	boolean jumpLogin(User user);
	
}
