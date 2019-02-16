package com.match.dao;



import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.match.beans.Picture;
import com.match.beans.User;
import com.match.beans.UserP;
import com.match.beans.UserPp;
import com.match.dao.interf.SelectDaoI;
import com.match.util.SQLUtil2;



/**
 *
 * @author xxc
 * @time 2018年7月11日下午8:25:27
 **/
public class SelectDao implements SelectDaoI {
	List<UserPp> list = new ArrayList<>();
	/**
	 * 连接数据库，从数据库中获取相同城匹配的信息
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
	public UserP perMethod(int uid) {
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
				UserP userP = new UserP();
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
		} finally {
			SQLUtil2.myClose(rs);
		}

		return null;
	}


	/**
	 * 连接数据库，从数据库中获取相异城匹配的信息
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
	public List<UserPp> selectMethod2(int uid, int age, String sex, String address) {
		String sex1 = "'" + sex + "'";
		String adress1 = "'" + address + "%'";
		// 准备sql语句select user.*,picture.pname,picture.paddress from user,picture
		// where user.uid=picture.uid and not user.sex="女" and user.age>28-3 and
		// user.age<28+3 and user.address like "陕西西安%";
		String sql = "select user.*,picture.* from user,picture where user.uid=picture.uid and not user.sex="
				+ sex1 + " and user.age>=" + (age - 3) + " and user.age<=" + (age + 3) + " and user.address not like "
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

}
