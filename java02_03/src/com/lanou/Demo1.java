package com.lanou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

/**
 *
 * @author LiuXu
 * @time2018年7月2日下午4:02:54
 **/
public class Demo1 {

	public static void main(String[] args) {
		// 执行事务1
		// MyCommit1();
		// 执行事务2
		// Mycommit2();
		// MyCommit3();
		myCommit4();
	}

	public static void MyCommit1() {
		// 获取连接对象
		Connection con = SQLUtil2.getCon();
		try {
			// 设置自动提交方式(开启事务)
			con.setAutoCommit(false);
			// 编写执行语句
			String sql1 = "update orders set price=price + 50 where id = 1";
			String sql2 = "update orders set price=price - 50 where id = 4";

			// 获取执行对象
			Statement st = con.createStatement();
			// 执行sql语句
			st.executeUpdate(sql1);

			// 使用预解析对象执行同样的操作
			// PreparedStatement ps = con.prepareStatement(sql1);
			// ps.executeUpdate();
			// 提交操作
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void Mycommit2() {
		// 获取连接对象
		Connection con = SQLUtil2.getCon();
		if (con != null) {
			try {
				con.setAutoCommit(false);
				String sql1 = "insert into orders values(5,'hhh',6000)";
				String sql2 = "insert into orders values(6,'xxx',2000)";

				Statement st = con.createStatement();
				st.executeUpdate(sql1);
				// 设置保存点
				Savepoint savepoint = con.setSavepoint("aa");
				st.executeUpdate(sql2);
				// 回滚到保存点
				con.rollback(savepoint);

				// 提交
				con.commit();

			} catch (SQLException e) {
				e.printStackTrace();
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		}

	}

	public static void MyCommit3() {
		// 获取连接对象
		Connection con = SQLUtil2.getCon();
		PreparedStatement ps = null;
		PreparedStatement ps1 = null;
		try {
			// 设置自动提交方式(开启事务)
			con.setAutoCommit(false);
			// 编写执行语句
			String sql1 = "update orders set price=price + 50 where id = 1";
			String sql2 = "update orders set price=price - 50 where id = 4";
			// 使用预解析对象执行同样的操作
			ps = con.prepareStatement(sql1);
			ps.executeUpdate();

			ps1 = con.prepareStatement(sql2);
			ps1.executeUpdate();
			// 提交操作
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			SQLUtil2.myClose(con);
			SQLUtil2.myClose(ps);
			SQLUtil2.myClose(ps1);
		}
	}

	public static void myCommit4() {
		// 获取连接对象
		Connection con = SQLUtil2.getCon();
		try {
			// 设置自动提交方式(开启事务)
			con.setAutoCommit(false);
			// 编写执行语句
			String sql1 = "update orders set price=price + 50 where id = ?";
			// String sql2 = "update orders set price=price - 50 where id = 4";

			// // 获取执行对象
			// Statement st = con.createStatement();
			// // 执行sql语句
			// st.executeUpdate(sql1);

			// 使用预解析对象执行同样的操作
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setInt(1, 4);
			ps.executeUpdate();
			ps.setInt(1, 5);
			ps.executeUpdate();
			// 提交操作
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
