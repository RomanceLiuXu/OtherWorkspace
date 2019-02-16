package com.lanou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author LiuXu
 * @time2018年6月29日上午11:19:06
 **/
public class Demo2 {

	private Connection con;// 连接对象
	private PreparedStatement ps;// 预解析对象
	private ResultSet rs;// 结果集

	private Statement st;// 获取statemant对象

	/**
	 * 构造方法
	 */

	public Demo2() {

		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			// 协议:子协议://ip:端口/数据库名?参数
			try {
				con = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/liuxudb2?useUnicode=true&characterEncoding=UTF-8", "root",
						"123456");
			} catch (SQLException e) {

				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}

	}

	/**
	 * 查询操作
	 */
	public void select() {
		try {
			// 创建连接
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/liuxudb2?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
			// 获取预解析对象
			ps = con.prepareStatement("select * from test2");
			// 执行sql语句
			rs = ps.executeQuery();
			// 遍历获取结果
			while (rs.next()) {
				// 根据字段名获取字段值
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id + "--" + name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 调用关闭的方法
			D2Close();
		}

	}

	public void select1() {

		try {
			// 创建连接
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/liuxudb2?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
			// 获取statement对象
			st = con.createStatement();
			// 执行sql语句
			rs = st.executeQuery("select * from test2");
			// 遍历
			while (rs.next()) {
				// 根据字段获取字段的值
				int id = rs.getInt("id");
				String name = rs.getString("name");
				System.out.println(id + "--" + name);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			D2Close();
		}
	}

	public void update() {
		try {
			// 创建连接
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/liuxudb2?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
			// 获取预解析对象
			// 修改
			// ps = con.prepareStatement("update test2 set name = 'hhh' where id
			// = 2");
			// 插入
			ps = con.prepareStatement("insert into test2 values(9,'dadadad')");
			// 删除
			// ps = con.prepareStatement("delete from test2 where id = 3");

			// 创建一张表（不推荐）
			// ps = con.prepareStatement("create table test8(id int primary key
			// ,type varchar(32))");

			// 执行修改的方法
			// 返回的int类型的数据 --- 非查询操作影响的函数
			int num = ps.executeUpdate();
			System.out.println(num);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			D2Close();
		}

	}

	/**
	 * 关闭的方法
	 */

	public void D2Close() {
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
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

	}

}
