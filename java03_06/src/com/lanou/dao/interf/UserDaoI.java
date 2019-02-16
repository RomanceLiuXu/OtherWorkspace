package com.lanou.dao.interf;

import java.util.List;

import com.lanou.bean.User;

/**
 *
 * @author LiuXu
 * @time2018年8月1日上午9:23:31
 **/
public interface UserDaoI {

	// 登录验证
	public String loginD(String name, String psw);

	// 主页数据
	public List<User> homeUser(int pnum, int page);

	// 总页码
	public int pageNum(int pnum);

	// 删除
	public boolean deleteUser(int uid);

	// 添加数据
	public boolean addUser(User user);

	// 修改数据
	public boolean updateUser(User user);

	// 注册
	// public int Reginster(User user);
}
