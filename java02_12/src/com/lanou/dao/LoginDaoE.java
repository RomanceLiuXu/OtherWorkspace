package com.lanou.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lanou.bean.User;
import com.lanou.dao.interf.LoginDaoI;
import com.lanou.utils.SQLUtil2;

/**
 * 登录dao层实现类
 * 
 * @author LiuXu
 * @time2018年7月18日上午11:53:32
 **/
public class LoginDaoE implements LoginDaoI {

	@Override
	public boolean checkLogin(User user) {
		// 准备sql语句
		String sql = "select uid from user where name=? and psw=?";
		// 占位符对应的数组
		String[] parm = { user.getName(), user.getPsw() };
		ResultSet rs = SQLUtil2.queryMethod(sql, parm);
		boolean next = false;
		// 判断
		try {
			 next = rs.next();
			// if (next) {
			// // 需要uid则判断
			// }
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			SQLUtil2.myClose(rs);
		}
		return next;
	}

}
