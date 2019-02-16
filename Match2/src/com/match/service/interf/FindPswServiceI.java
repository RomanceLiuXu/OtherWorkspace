package com.match.service.interf;

/**
 * 用户修改密码
 * 
 * @author LiuXu
 * @time2018年7月13日下午8:22:39
 **/
public interface FindPswServiceI {

	/**
	 * 修改密码
	 * 
	 * @param name
	 *            用户名
	 * @param answer
	 *            密保答案
	 * @return 是否匹配
	 */
	boolean findPsw(String name, String answer);

}
