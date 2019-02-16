package com.lanou.dao.interf;

import com.lanou.bean.User;

/**
* 登录dao层接口
* @author LiuXu
* @time2018年7月18日上午11:53:05
**/
public interface LoginDaoI {
    /**
     * 检查登录
     * @param user
     * @return
     */
	boolean checkLogin(User user);
	
	
	
}
