package com.lanou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 *
 * @author LiuXu
 * @time2018年6月29日下午10:32:40
 **/
public class My {

	// 步骤
	// 1.加载驱动
	// 2.获取连接
	// 3.获取预解析对象
	// 4.执行操作，返回结果
	// 5.操作结果
	// 6.关闭

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 1. 加载驱动方式一
			Class.forName("com.mysql.jdbc.Driver");
			// 方式二
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			// 获取连接
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/liuxudb2?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
			// DriverManager.getConnection("jdbc:mysql://localhost:3306/liuxudb2?useUnicode=true&characterEnconding=utf-8",
			// "root", "password");
			
			// 获取预解析对象（防止了sql注入）
			ps = con.prepareStatement("select * from test2");
			// 获取结果集
			rs = ps.executeQuery();
			
			
			// 方式二(没有防止sql注入)
			Statement st = con.createStatement();
			// 获取结果集
			rs = st.executeQuery("select * from test2");

			// 操作结果 遍历打印
			while (rs.next()) {
				// 取值
				// 获取name字段的值
				String name = rs.getString("name");
				// 获取id字段的值
				int id = rs.getInt("id");

			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 关闭
			if (con != null) {
				con.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}

		}

	}

}
