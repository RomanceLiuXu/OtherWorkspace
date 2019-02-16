package com.lanou.service.interf;

import java.util.List;

import com.lanou.bean.User;

/**
*
* @author LiuXu
* @time2018年8月1日上午9:22:56
**/
public interface UserServiceI {

	public String loginS(String name,String psw,int flag);
		
	public List<User> homeUser(int pnum,int page); 	
	
	public boolean deleteUser(int uid);
	
	public boolean addUser(User user);
	
	public boolean updateUser(User user);
}
