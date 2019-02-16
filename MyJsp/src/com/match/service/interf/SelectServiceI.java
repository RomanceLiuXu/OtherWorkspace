package com.match.service.interf;



import java.util.List;
import java.util.Map;

import com.match.beans.Picture;
import com.match.beans.User;
import com.match.beans.UserPp;



/**
 *
 * @author xxc
 * @time 2018年7月11日下午8:17:54
 **/
public interface SelectServiceI {

	/**
	 * 查询与用户匹配的同城信息
	 * 
	 * @param uid
	 *            用户id
	 * @param age
	 *            用户年龄
	 * @param sex
	 *            用户性别
	 * @param adress
	 *            用户住址
	 * @return 返回与客户匹配的所有成员的信息及图片信息
	 */
	public List<UserPp> selectMethod(int uid, int age, String sex, String address);
	
	
	
	/**
	 * 查询与用户匹配的同城信息
	 * 
	 * @param uid
	 *            用户id
	 * @param age
	 *            用户年龄
	 * @param sex
	 *            用户性别
	 * @param adress
	 *            用户住址
	 * @return 返回与客户匹配的所有成员的信息及图片信息
	 */
	public List<UserPp> selectMethod2(int uid, int age, String sex, String address);
	

	/**
	 * 查询用户的所有信息
	 * 
	 * @param id用户的id
	 * @return 返回用户信息的集合
	 */
	public Map<User, Picture> perMethod(int id);
}
