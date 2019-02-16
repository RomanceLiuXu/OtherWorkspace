package com.lanou.test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LiuXu
 * @time2018年7月9日下午4:10:40
 **/
public class LoginJDBC {

	/**
	 * 
	 * @param code
	 *            用户名
	 * @param password
	 *            密码
	 * @return 是否登录成功
	 */
	public boolean jumpLogin(String code, String password) {
		// 定义一个标示
		boolean is = false;
//		准备sql语句
		String sql = "select * from student";
//		调用工具类中查询的方法
		ResultSet rs = SQLUtil2.qureyMethod(sql, null);
		try {
			while (rs.next()) {
				String p1 = rs.getString("s_id");
				String c1 = rs.getString("s_name");
				if (code.equals(c1)&&password.equals(p1)) {
					is = true;
					break;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		

		return is;
	}

}
