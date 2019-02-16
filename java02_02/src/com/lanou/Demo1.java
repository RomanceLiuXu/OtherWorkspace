package com.lanou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

/**
 * JDBC连接数据库
 * 
 * @author LiuXu
 * @time2018年6月29日上午9:03:58
 **/
public class Demo1 {

	public static void main(String[] args) {
		// 步骤
		// 1.加载驱动
		// 2.获取连接
		// 3.获取预解析对象
		// 4.执行操作，返回结果
		// 5.操作结果
		// 6.关闭
		//
		// try {
		// // 实例化Driver类
		// Driver d = new Driver();
		// // 加载驱动
		// DriverManager.registerDriver(d);
		// } catch (SQLException e) {
		//
		// e.printStackTrace();
		// }

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			// 协议:子协议://ip:端口/数据库名?参数
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/liuxudb2?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
			// 方式一、获取预解析对象
			// ps = con.prepareStatement("select * from test2 where id = 1");
			// ?指的是占位符---方便接下来填充值
			// ps = con.prepareStatement("select * from test2 where id =? and
			// name = ?");
			// // 给占位符进行赋值操作(从1开始)
			// ps.setInt(1, 1);
			// ps.setString(2, "lhl1");

			// ps = con.prepareStatement("select * from test2 where id = ?");
//			 ps.setString(1, "1 or 1 = 1");

			//  方式二、通过连接对象获取Statement对象 (没有防止sql注入)
			Statement st = con.createStatement();
			// 调用执行操作的方法并获取结果集
			rs = st.executeQuery("select * from test2 where id = 1 or 1 = 1");
			// 执行sql语句
			// 查询 返回查询结果集
			// rs = ps.executeQuery();
			// 非查询操作，无返回结果
			// ps.executeUpdate();
			// 遍历
			while (rs.next()) {
				// 取值
				// 获取name字段的值
				String name = rs.getString("name");
				// 获取id字段的值
				int id = rs.getInt("id");
				System.out.println(name + ":" + id);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			// 关闭con,ps,rs 先判断是否为null 不为null则关闭
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		}

	}

}
