package com.lanou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author LiuXu
 * @time2018年6月30日上午10:29:44
 **/
public class MyUtil {
	private Connection con;// 连接对象
	private PreparedStatement ps;// 预解析对象
	private ResultSet rs;// 结果集对象

	public MyUtil() {
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 获取连接的方法
	 * 
	 * @return
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
	 * 查找的方法
	 * 
	 * @param sql语句
	 * @return 结果集合
	 * 
	 */
	public List<Map<String, Object>> select(String sql) {
		// 判断连接是否成功
		if (!getCon()) {
			return null;
		}
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			// 获取预解析对象
			ps = con.prepareStatement(sql);
			// 获取结果集
			rs = ps.executeQuery();
			// 检索此ResultSet对象的列的数量、类型和属性
			ResultSetMetaData metaData = rs.getMetaData();
			// 获取字段的个数
			int n = metaData.getColumnCount();
			// 遍历结果集
			while (rs.next()) {
				Map<String, Object> map = new LinkedHashMap<>();
				for (int i = 1; i <= n; i++) {
					// 获取字段名称
					String key = metaData.getColumnName(i);
					// 获取字段对应的值
					Object val = rs.getObject(key);
					map.put(key, val);
				}
				list.add(map);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			sqlClose();
		}

		return list;

	}

	/**
	 * 修改的方法
	 */
	public boolean upDate(String sql) {
		if (!getCon()) {
			return false;
		}
		try {
			// 获取预解析对象
			ps = con.prepareStatement(sql);
			// 返回值为修改的行数
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return true;
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
