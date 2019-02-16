package com.lanou.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.lanou.bean.User;
import com.lanou.dao.interf.UserDaoI;
import com.lanou.util.SQLUtil2;

/**
 *
 * @author LiuXu
 * @time2018年7月30日上午9:56:37
 **/
public class UserDao implements UserDaoI {

	@Override
	public String LoginCheck(User user) {
		String result = "error";
		String sql = "select uid from user where name='" + user.getName() + "'and psw='" + user.getPsw()+"'";
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		try {
			if (rs.next()) {
				result = "success";
			}
		} catch (SQLException e) {
		}
        
		return result;
	}

}
