package com.lanou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * sql封装方式一
 * 
 * @author LiuXu
 * @time2018年6月29日下午2:21:07
 **/
public class SQLUtil1 {

	private Connection con;// 连接对象
	private PreparedStatement ps;// 预解析对象
	private ResultSet rs;// 结果集对象

	public SQLUtil1() {
		try {
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 获取连接的方法
	 * 
	 * @return 返回boolean true--代表连接成功 false--代表连接失败
	 */
	public boolean getCon() {
		// "jdbc:mysql://"+SQLOP.SQL_IP+":"+SQLOP.SQL_PORT+"/"+SQLOP.DB_NAME+"?useUnicode=true&ampcharacterEncoding=UTF-8";
		try {
			con = DriverManager
					.getConnection(
							"jdbc:mysql://" + SQLOP.SQL_IP + ":" + SQLOP.SQL_PORT + "/" + SQLOP.DB_NAME
									+ "?useUnicode=true&characterEncoding=UTF-8&useSSL=false",
							SQLOP.USER_NAME, SQLOP.USER_PSW);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * 查询的方法
	 * 
	 * @param sql
	 *            传入的sql语句
	 * @return list结果集
	 */
	public List<Map<String, Object>> exeQuery(String sql) {
		// 判断是否获取连接成功
		if (!getCon()) {
			return null;
		}
		// 实例化List
		List<Map<String, Object>> lists = new ArrayList<>();
		try {
			// 获取预解析对象
			ps = con.prepareStatement(sql);
			// 执行操作获取结果集
			rs = ps.executeQuery();
			// 获取ResultSetMetaData对象，检索此ResultSet对象的列的数量、类型和属性
			ResultSetMetaData data = rs.getMetaData();
			// 获取字段的个数
			int n = data.getColumnCount();
			// 遍历结果集
			while (rs.next()) {
				Map<String, Object> maps = new LinkedHashMap<>();
				// 遍历字段的个数
				for (int i = 1; i < n + 1; i++) {
					// 获取字段名
					String key = data.getColumnName(i);
					// 根据字段名获取字段对应的值
					Object val = rs.getObject(key);
					maps.put(key, val);

				}
				// 将map添加到list中
				lists.add(maps);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			sqlClose();
		}

		return lists;
	}

	/**
	 * 修改的方法
	 */
	public boolean exeUpdate(String sql) {
		// 判断连接是否成功
		if (!getCon()) {
			return false;
		}
		try {
			// 获取预解析对象
			ps = con.prepareStatement(sql);
			int s = ps.executeUpdate();
			if (s == -1) {
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

	/**
	 * 分页查询
	 * @param p--显示第几页的数据 s--每页显示数据的个数
	 */
	public List<Map<String, Object>> selectByPage(int p, int s) {
		// 判断连接
		if (!getCon()) {
			return null;
		}
		// 调用方法
		return exeQuery("select * from student limit " + (p - 1) * s + "," + s);

	}

	/**
	 * 关闭的方法
	 */
	public void sqlClose() {
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
