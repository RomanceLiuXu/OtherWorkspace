package com.lanou.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * SQL工具类--封装方式二
 * 
 * @author LiuXu
 * @time2018年7月2日上午11:29:18
 **/
public class SQLUtil2 {
	static Connection con = null;// 连接对象
	static PreparedStatement ps = null;// 预编译对象
	static ResultSet rs = null;// 结果集

	// "insert into test8 values("+i+",'lhl+(i+1)+'");
	// 静态代码块，加载驱动
	static {
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询的方法
	 */
	public static boolean myUdate(String tableName, String[] parm) {
		// 获取连接
		con = getCon();
		// 判断
		if (con == null) {
			return false;
		}
		// 准备sql语句
		String sql = "update " + tableName + " set name = ? where id = ?";
		try {
			// 获取预解析对象
			ps = con.prepareStatement(sql);
			// 遍历
			for (int i = 0; i < parm.length; i++) {
				ps.setString(i + 1, parm[i]);
			}
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}finally {
			SQLUtil2.myClose(con);
			SQLUtil2.myClose(ps);
		}

		return true;
	}

	/**
	 * 查询的方法
	 */
	public static ResultSet mySelect(String tableName, String[] parm) {
		// 获取连接
		con = getCon();
		// 判断
		if (con == null) {
			return null;
		}
		// 准备sql语句
		String sql = "select * from " + tableName + " where id = ?";
		try {
			// 获取预解析对象
			ps = con.prepareStatement(sql);
			// 遍历
			for (int i = 0; i < parm.length; i++) {
				ps.setString(i + 1, parm[i]);
			}
			// 获取结果集
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			SQLUtil2.myClose(con);
			SQLUtil2.myClose(ps);
			SQLUtil2.myClose(rs);
		}

		return rs;
	}

	/**
	 * delete from orders where id = ?; 删除的方法
	 */
	public static boolean myDelete(String sql, String[] parm) {
		// 获取连接
		con = getCon();
		// 判断
		if (con == null) {
			return false;
		}
		// 获取预解析对象
		try {
			ps = con.prepareStatement(sql);
			// 遍历
			for (int i = 0; i < parm.length; i++) {
				// 给占位符设置对应的值
				ps.setString(i + 1, parm[i]);
			}
			// 获取结果集
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 关闭
			SQLUtil2.myClose(con);
			SQLUtil2.myClose(ps);
		}

		return true;
	}

	/**
	 * 查询的方法
	 * 
	 * @param sql
	 * @param parm
	 * @return
	 */
	public static ResultSet qureyMethod(String sql, String[] parm) {
		// 获取连接
		con = getCon();
		// 判断
		if (con == null) {
			return null;
		}
		try {
			// 获取预解析对象
			ps = con.prepareStatement(sql);
			if (parm != null) {
				// 遍历数组
				for (int i = 0; i < parm.length; i++) {
					// 将数组中的数据赋值给占位符
					ps.setString(i + 1, parm[i]);
				}
			}

			// 获取结果集
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

		return rs;
	}

	/**
	 * 添加的方法 insert into 表名 values(值1，值2，...);
	 * 
	 * @param tableName
	 *            表名
	 * @param parm
	 *            需要添加的数据的数组
	 */
	public static boolean insertMethod(String tableName, String[] parm) {
		con = getCon();
		if (con == null) {
			return false;
		}
		String str = "";
		// 遍历
		for (int i = 0; i < parm.length; i++) {
			if (i != parm.length - 1) {
				str += parm[i] + ",";
			} else {
				str += parm[parm.length - 1];
			}
		}
		System.out.println("参数为:" + str);
		String sql = "insert into " + tableName + " values(" + str + ")";
		try {
			// 获取预解析对象
			ps = con.prepareStatement(sql);
			// 执行操作
			int n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 修改的方法
	 * 
	 * @param sql含有占位符的sql语句
	 * @param parm
	 *            占位符对应的数据数组
	 * @return boolean 是否修改成功
	 */
	public static boolean updateMethod(String sql, String[] parm) {

		// 获取连接
		con = getCon();
		// 判断
		if (con == null) {
			// 如果为null，则直接返回false
			return false;
		}
		try {
			// 获取预解析对象
			ps = con.prepareStatement(sql);
			// 遍历数组
			for (int i = 0; i < parm.length; i++) {
				// 将数组中的数据赋值给占位符
				ps.setString(i + 1, parm[i]);
			}
			// 执行操作
			int n = ps.executeUpdate();
			// 判断n的值
			if (n < 0) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			sqlClose();
		}

		return true;
	}

	/*
	 * 获取连接的方法
	 * 
	 */
	public static Connection getCon() {
		try {
			con = DriverManager
					.getConnection(
							"jdbc:mysql://" + SQLOP.SQL_IP + ":" + SQLOP.SQL_PORT + "/" + SQLOP.DB_NAME
									+ "?useUnicode=true&characterEncoding=UTF-8&useSSL=false",
							SQLOP.USER_NAME, SQLOP.USER_PSW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	/*
	 * 关闭的方法
	 */
	public static void sqlClose() {
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

	/**
	 * 关闭的方法
	 * 
	 * @param as
	 *            含有close方法的接口类型的对象
	 */
	public static void myClose(AutoCloseable as) {
		if (as != null) {
			try {
				as.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
