package com.lanou.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.User;
import com.lanou.dao.interf.UserDaoI;
import com.lanou.util.SQLUtil2;

/**
 *
 * @author LiuXu
 * @time2018年8月1日上午9:33:27
 **/
public class UserDao implements UserDaoI {

	@Override
	public String loginD(String name, String psw) {
		String result = "error";
		// sql语句
		String sql = "select uid from user where name='" + name + "'and psw='" + psw + "'";
		System.out.println(sql);
		// 查询是否存在用户
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		try {
			if (rs.next()) {
				result = "success";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return result;
		} finally {
			SQLUtil2.myClose(rs);
		}
		return result;
	}

	@Override
	public List<User> homeUser(int pnum, int page) {
		List<User> users = new ArrayList<>();
		int start = (page - 1) * pnum;
		String sql = "select * from user limit " + start + "," + pnum;
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		try {
			while (rs.next()) {
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setName(rs.getString("name"));
				u.setPsw(rs.getString("psw"));
				u.setSex(rs.getString("sex"));
				users.add(u);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int pageNum(int pnum) {
		String sql = "select count(*) from user";
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		int num = -1;
		try {
			if (rs.next()) {
				num = rs.getInt("count(*)");
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if (num % pnum == 0) {
			num = num / pnum;
		} else {
			num = num / pnum + 1;
		}
		System.out.println("num的值:" + num);

		return num;
	}

	@Override
	public boolean deleteUser(int uid) {
		String sql = "delete from user where uid=" + uid;
		System.out.println(sql);
		boolean IsDelete = SQLUtil2.updateMethod(sql, null);
		return IsDelete;
	}

	@Override
	public boolean addUser(User user) {
		String sql = "insert into user(uid,name,psw,sex) values(?,?,?,?)";
		String[] parm = { 0 + "", user.getName(), user.getPsw(), user.getSex() };
		boolean IsAdd = SQLUtil2.updateMethod(sql, parm);
		return IsAdd;
	}

	@Override
	public boolean updateUser(User user) {
		String sql = "update user set name='" + user.getName() + "' where uid=" + user.getUid();
		System.out.println(sql);
        boolean IsUp = SQLUtil2.updateMethod(sql, null);
		return IsUp;
	}
	
//	@Override
//	public int Reginster(User user) {
//		String sql = "insert into user(uid,name,psw,sex) values(?,?,?,?)";
//		String[] parm = { 0 + "", user.getName(), user.getPsw(), user.getSex() };
//		boolean IsAdd = SQLUtil2.updateMethod(sql, parm);
//      if (IsAdd) {
//		String sql1 = "select uid from user where name='" + user.getName() + "'";
//		}
//		return 1;
//	}

}
