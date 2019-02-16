package com.lanou.dao.interf;

import java.util.List;

import com.lanou.bean.User;

/**
*
* @author LiuXu
* @time2018年7月19日下午8:36:02
**/
public interface DataBaseDaoI {

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
	
	/**
	 * 查询数据库中的数据(分页)
	 * @return
	 */
	List<User> pageFind(int page,int pnum);
	
	/**
	 * 获取总页数
	 * @return
	 */
	int allPage(int pnum);
	
}
