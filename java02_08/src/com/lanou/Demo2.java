package com.lanou;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

/**
 * 连接数据库获取数据
 * 
 * @author LiuXu
 * @time2018年7月9日下午2:10:46
 **/
public class Demo2 {

	public String getData() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String res = "";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mywork?useUnicode=true&characterEncoding=UTF-8", "root", "123456");
			ps = con.prepareStatement("select * from student");
			rs = ps.executeQuery();

			while (rs.next()) {
				String id = rs.getString("s_id");
				String name = rs.getString("s_name");
				res += id + "--" + name;

			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return res;
	}

}
