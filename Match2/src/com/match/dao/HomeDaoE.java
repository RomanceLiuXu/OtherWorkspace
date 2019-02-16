package com.match.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.match.beans.Picture;
import com.match.beans.User;
import com.match.beans.UserP;
import com.match.dao.interf.HomeDaoI;
import com.match.util.SQLUtil2;

/**
 * @author lichenfei
 * @time 2018年7月13日下午4:35:17
 *
 * 
 *
 */
public class HomeDaoE implements HomeDaoI {

	@Override
	public List<UserP> findAll(String sex) {
		// 实例化一个集合存放数据：
		List<UserP> lists = new ArrayList<>();
		// 准备sql语句：
		String sql = "select * from user,picture where user.sex='" + sex + "'" + " and Picture.uid=User.uid";
		System.out.println(sql);
		// 链接数据库获取数据：
		// 调用工具类的方法：返回结果集：
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		System.out.println(rs);
		// 遍历结果集,封装lists：
		try {
			while (rs.next()) {
				// 实例化UserP对象：
				UserP up = new UserP();
				// 获取字段值：
				up.setUid(rs.getInt("uid"));
				up.setName(rs.getString("name"));
				up.setSex(rs.getString("sex"));
				up.setAge(rs.getInt("age"));
				up.setAddress(rs.getString("address"));
				up.setAnswer(rs.getString("answer"));
				up.setPsw(rs.getString("psw"));
				// 实例化picture
				Picture pic = new Picture();
				pic.setPaddress(rs.getString("paddress"));
				pic.setPid(rs.getInt("pid"));
				pic.setPname(rs.getString("pname"));
				pic.setUid(rs.getInt("uid"));
				// 设置userp的picture属性：
				up.setPicture(pic);
				// 将对象添加到集合：
				lists.add(up);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			SQLUtil2.myClose(rs);
		}

		return lists;
	}

	@Override
	public List<UserP> pageFind(String sex, int pnum ,int page) {
		// 实例化一个集合存放数据：
		List<UserP> lists = new ArrayList<>();
		// 每页的开始位置
		int start = (page - 1) * pnum;
		// 准备sql语句：
		String sql = "select * from user,picture where user.sex='" + sex + "'" + " and user.uid=picture.uid limit "
				+ start + "," + pnum;
		System.out.println(sql);
		// 链接数据库获取数据：
		// 调用工具类的方法：返回结果集：
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		System.out.println(rs);
		// 遍历结果集,封装lists：
		try {
			while (rs.next()) {
				// 实例化UserP对象：
				UserP up = new UserP();
				// 获取字段值：
				up.setUid(rs.getInt("uid"));
				up.setName(rs.getString("name"));
				up.setSex(rs.getString("sex"));
				up.setAge(rs.getInt("age"));
				up.setAddress(rs.getString("address"));
				up.setAnswer(rs.getString("answer"));
				up.setPsw(rs.getString("psw"));
				// 实例化picture
				Picture pic = new Picture();
				pic.setPaddress(rs.getString("paddress"));
				pic.setPid(rs.getInt("pid"));
				pic.setPname(rs.getString("pname"));
				pic.setUid(rs.getInt("uid"));
				// 设置userp的picture属性：
				up.setPicture(pic);
				// 将对象添加到集合：
				lists.add(up);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			SQLUtil2.myClose(rs);
		}

		return lists;

	}

	public int allPage(String sex, int pnum) {
		// 准备sql语句
		String sql = "select count(*) from user,picture where user.sex='" + sex + "'" + " and user.uid=picture.uid";
		// 连接数据库
		// 调用方法
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		// 定义变量接收数据
		int num = 0;
		// 遍历结果集
		if (rs != null) {
			try {
				while (rs.next()) {
					// 返回查询的总个数
					num = rs.getInt("count(*)");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		if (num != 0 && pnum > 0) {
			if (num % pnum == 0) {
				num = num / pnum;
			} else {
				// 不能整除页数多加1
				num = num / pnum + 1;
			}

		}

		return num;
	}

}
