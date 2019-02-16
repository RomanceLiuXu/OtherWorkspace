package com.match.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.match.beans.Picture;
import com.match.beans.User;
import com.match.beans.UserPp;
import com.match.dao.interf.SelectDaoI;
import com.match.util.SQLUtil2;



/**
 *
 * @author xxc
 * @time 2018年7月11日下午8:25:27
 **/
public class SelectDao implements SelectDaoI {
	/**
	 * 连接数据库，从数据库中获取相匹配的信息
	 * 
	 * @param uid
	 *            登录用户id
	 * @param age
	 *            登录用户年龄
	 * @param sex
	 *            登录用户性别
	 * @param adress
	 *            登录用户的地址
	 * @return
	 */
	@Override
	public List<UserPp> selectMethod(int uid, int age, String sex, String address) {
		String sex1 = "'" + sex + "'";
		String adress1 = "'" + address + "%'";
		// 准备sql语句select user.*,picture.pname,picture.paddress from user,picture
		// where user.uid=picture.uid and not user.sex="女" and user.age>28-3 and
		// user.age<28+3 and user.address like "陕西西安%";
		String sql = "select user.*,picture.* from user,picture where user.uid=picture.uid and not user.sex="
				+ sex1 + " and user.age>=" + (age - 3) + " and user.age<=" + (age + 3) + " and user.address like "
				+ adress1;
		System.out.println(sql);
		// 调用方法返回结果
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		// 准备List集合容器
		List<UserPp> list = new ArrayList<>();
		// 循环添加
		try {
			while (rs.next()) {
				// 实例化UserP
				UserPp userp = new UserPp();
				// 获取user信息
				int id2 = rs.getInt("uid");
				String name2 = rs.getString("name");
				int age2 = rs.getInt("age");
				String sex2 = rs.getString("sex");
				String address2 = rs.getString("address");
				// 获取picture的信息
				String pname = rs.getString("pname");
				String paddress = rs.getString("paddress");
				int pid1 = rs.getInt("pid");
				// 给userp设置属性值
				userp.setAddress(address2);
				userp.setAge(age2);
				userp.setName(name2);
				userp.setSex(sex2);
				userp.setUid(id2);
				userp.setPname(pname);
				userp.setPaddress(paddress);
				userp.setPid(pid1);
				list.add(userp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLUtil2.myClose(rs);
		}
		return list;

	}

	/**
	 * 从数据库查询某个人的用户信息
	 * 
	 * @param 用户的id
	 */
	@Override
	public Map<User, Picture> perMethod(int uid) {
		// 准备sql语句
		String sql = "select user.*,picture.* from user,picture where user.uid=picture.uid and user.uid="
				+ uid;
		// 调取方法获取数据库的结果集
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		// 准备Map容器存放数据
		Map<User, Picture> maps = new HashMap<>();
		// 循环添加
		try {
			while (rs.next()) {
				// 实例化user
				User user = new User();
				// 获取user信息
				int id2 = rs.getInt("uid");
				String name2 = rs.getString("name");
				int age2 = rs.getInt("age");
				String sex2 = rs.getString("sex");
				String address2 = rs.getString("address");
				// 给user设置属性值
				user.setAddress(address2);
				user.setAge(age2);
				user.setName(name2);
				user.setSex(sex2);
				user.setUid(id2);
				// 实例化picture
				Picture p = new Picture();
				// 获取picture的信息
				String pname2 = rs.getString("pname");
				String paddress2 = rs.getString("paddress");
				int pid2 = rs.getInt("pid");
				int uid2 = rs.getInt("uid");
				// 给picture 设置属性值
				p.setPname(pname2);
				p.setPaddress(paddress2);
				p.setPid(pid2);
				p.setUid(uid2);
				maps.put(user, p);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLUtil2.myClose(rs);
		}

		return maps;
	}

}
