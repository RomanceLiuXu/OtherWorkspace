package com.lanou.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.ast.TrueLiteral;

import com.lanou.mvc.beans.User;
import com.lanou.mvc.dao.interf.DaoInterf;
import com.lanou.test.SQLUtil2;

/**
 *
 * @author LiuXu
 * @time2018年7月9日下午5:11:51
 **/
public class LoginDao implements DaoInterf {

	@Override
	public boolean jumpLogin(User user) {

		boolean flag = false;
		// 连接数据库
		// 准备语句
		String sql = "select * from user";
		ResultSet rs = SQLUtil2.qureyMethod(sql, null);
		// 遍历
		try {
			while (rs.next()) {
				// 获取字段值
				String code = rs.getString("code");
				String psw = rs.getString("psw");
				// 判断字段值和输入的内容是否一致
				if (code.equals(user.getCode()) && psw.equals(user.getPsw())) {
					flag = true;
					break;
				}
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			SQLUtil2.myClose(rs);
		}

		return flag;
	}

}
