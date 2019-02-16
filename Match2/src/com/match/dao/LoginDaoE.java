package com.match.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.match.beans.Picture;
import com.match.beans.User;
import com.match.beans.UserP;
import com.match.dao.interf.LoginDaoI;
import com.match.util.SQLUtil2;

/**
 *
 * @author LiuXu
 * @time2018年7月11日下午7:06:08
 **/
public class LoginDaoE implements LoginDaoI {

	List<User> users = new ArrayList<>();

	@Override
	public List<User> findUsers() {
		// 连接数据库，获取所有用户的信息，返回一个集合
		String sql = "select * from user";
		System.out.println("--" + sql);
		// 获取返回的结果集
		ResultSet rs = SQLUtil2.qureyMethod(sql, null);
		if (rs != null) {
			try {
				while (rs.next()) {
					User user = new User();
					user.setUid(rs.getInt("uid"));
					user.setName(rs.getString("name"));
					user.setSex(rs.getString("sex"));
					user.setAge(rs.getInt("age"));
					user.setPsw(rs.getString("psw"));
					user.setAddress(rs.getString("address"));
					// 改过
					user.setAnswer(rs.getString("answer"));
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return users;
	}

	@Override
	public UserP userLogin(String name, String psw) {
		String sql = "select * from user,picture where name='" + name + "'and psw='" + psw + "'and user.uid=picture.uid";
		System.out.println(sql);
        ResultSet rs = SQLUtil2.queryMethod(sql, null);
         try {
			if (rs.next()) {
				UserP  userP =  new UserP();
				userP.setUid(rs.getInt("uid"));
				userP.setName(rs.getString("name"));
				userP.setSex(rs.getString("sex"));
				userP.setAge(rs.getInt("age"));
				userP.setPsw(rs.getString("psw"));
				userP.setAddress(rs.getString("address"));
				userP.setAnswer(rs.getString("answer"));
				// 实例化picture类
				Picture pic = new Picture();
				pic.setPaddress(rs.getString("paddress"));
				pic.setPid(rs.getInt("pid"));
				pic.setPname(rs.getString("pname"));
				pic.setUid(rs.getInt("uid"));
				userP.setPicture(pic);
				return userP;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
