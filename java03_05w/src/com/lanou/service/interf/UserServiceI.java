package com.lanou.service.interf;

import com.lanou.bean.User;

/**
*
* @author LiuXu
* @time2018年7月30日上午9:53:10
**/
public interface UserServiceI {

	public String LoginCheck(User user);
	
	public int Reginster(User user);
	
}
