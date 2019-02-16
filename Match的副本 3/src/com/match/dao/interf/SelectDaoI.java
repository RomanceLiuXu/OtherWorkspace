package com.match.dao.interf;



import java.util.List;
import java.util.Map;


import com.match.beans.Picture;
import com.match.beans.User;
import com.match.beans.UserPp;

/**
 *
 * @author xxc
 * @time 2018年7月11日下午8:25:54
 **/
public interface SelectDaoI {
	/**
	 * 连接数据库，从数据库中获取相匹配的信息
	 * @param uid 登录用户id
	 * @param age 登录用户年龄
	 * @param sex 登录用户性别
	 * @param adress 登录用户的地址
	 * @return
	 */
	public List<UserPp> selectMethod(int uid, int age, String sex, String adress);
	
	/**
	 * 连接数据库，从数据库中查找某个人的信息
	 * @param uid
	 * @return
	 */
	public Map<User,Picture> perMethod(int uid);
}
