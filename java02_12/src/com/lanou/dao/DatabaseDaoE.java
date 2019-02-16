package com.lanou.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import com.lanou.bean.User;
import com.lanou.dao.interf.DataBaseDaoI;
import com.lanou.utils.SQLUtil2;

/**
 *
 * @author LiuXu
 * @time2018年7月19日下午8:36:31
 **/
public class DatabaseDaoE implements DataBaseDaoI {

	@Override
	public boolean addUser(String name, String sex, String psw) {
		// 连接数据库
		// 准备sql语句
		String sql = "insert into user(name,sex,psw) values('" + name + "','" + sex + "'" + ",'" + psw + "')";
		boolean isAdd = SQLUtil2.add(sql);

		return isAdd;
	}

	@Override
	public boolean updateUser(int uid, String name, String sex, String psw) {
		String sql = "update user set name=?,sex=?,psw=? where uid=?";
		// 给占位符设置值
		String[] parm = { name, sex, psw, uid + "" };
		boolean isUpdate = SQLUtil2.updateMethod(sql, parm);

		return isUpdate;
	}

	@Override
	public boolean deleteUser(int uid) {
		String sql = "delete from user where uid=" + uid;
		System.out.println(sql);
		boolean isDelete = SQLUtil2.myDelete(sql, null);
		return isDelete;
	}

	@Override
	public List<User> selectUser() {
		List<User> users = new ArrayList<User>();
		String sql = "select * from user";
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		if (rs!=null) {
			try {
				while (rs.next()) {
					User user = new User();
					user.setUid(rs.getInt("uid"));
					user.setName(rs.getString("name"));
					user.setSex(rs.getString("sex"));
					user.setPsw(rs.getString("psw"));
					users.add(user);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return users;
	}

	@Override
	public List<User> pageFind(int pnum, int page) {
		// 实例化一个集合存放数据：
				List<User> lists = new ArrayList<>();
				// 每页的开始位置
				int start = (page - 1) * pnum;
				// 准备sql语句：
				String sql = "select * from user limit "+ start + "," + pnum;
				System.out.println(sql);
				// 链接数据库获取数据：
				// 调用工具类的方法：返回结果集：
				ResultSet rs = SQLUtil2.queryMethod(sql, null);
				System.out.println(rs);
				// 遍历结果集,封装lists：
				try {
					while (rs.next()) {
						// 实例化UserP对象：
						User up = new User();
						// 获取字段值：
						up.setUid(rs.getInt("uid"));
					    up.setName(rs.getString("name"));
						up.setSex(rs.getString("sex"));
						up.setPsw(rs.getString("psw"));
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
	public int allPage(int pnum) {
		// 准备sql语句
				String sql = "select count(*) from user";
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
