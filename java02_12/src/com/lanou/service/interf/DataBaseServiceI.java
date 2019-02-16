package com.lanou.service.interf;

import java.util.List;

import com.lanou.bean.User;


/**
 * 数据库操作
 * 
 * @author LiuXu
 * @time2018年7月19日下午8:28:28
 **/
public interface DataBaseServiceI {
	/**
	 * 向数据库中添加数据
	 * 
	 * @param name
	 * @param sex
	 * @param psw
	 * @return 是否添加成功
	 */
	boolean addUser(String name, String sex, String psw);
	
	/**
	 * 修改数据库数据
	 * @param uid
	 * @param name
	 * @param sex
	 * @param psw
	 * @return
	 */
	boolean updateUser(int uid,String name,String sex,String psw);
	
	/**
	 * 删除数据库某条数据
	 * @param uid
	 * @param name
	 * @return
	 */
	boolean deleteUser(int uid);
	
	/**
	 * 查询数据库中的数据
	 * @return
	 */
	
	List<User> selectUser();
	
	List<User> pageFind( int pnum,int page);
	
}
