package com.match.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.match.beans.Picture;
import com.match.beans.UserP;
import com.match.dao.interf.HomeDaoI01;
import com.match.util.SQLUtil2;



/**
 * @author lichenfei
 * @time 2018年7月14日下午8:40:29
 *
 *
 *
 */
public class HomeDaoE01 implements HomeDaoI01 {

	// 准备一个集合：
	List<UserP> lists = new ArrayList<>();

	@Override
	public List<UserP> show(int uid) {
		// 准备sql语句：
		String sql = "select * from user ,picture where user.uid = " + uid + " and user.uid=picture.uid";
		// 调用工具类方法：
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		// 遍历：
		try {
			while (rs.next()) {
				// 实例化实体类：
				UserP up = new UserP();
				up.setAddress(rs.getString("address"));
				up.setAge(rs.getInt("age"));
				up.setAnswer(rs.getString("answer"));
				up.setName(rs.getString("name"));
				up.setPsw(rs.getString("psw"));
				up.setSex(rs.getString("sex"));
				up.setUid(rs.getInt("uid"));
				// 实例化picture类：、
				Picture pic = new Picture();
				pic.setPaddress(rs.getString("paddress"));
				pic.setPid(rs.getInt("pid"));
				pic.setPname(rs.getString("pname"));
				pic.setUid(rs.getInt("uid"));
				up.setPicture(pic);
				// 添加到集合：
                lists.add(up);
				
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return lists;
	}

}
