package com.lanou.action;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.Student;
import com.lanou.utils.SQLUtil2;

/**
 * 数据库操作
 * 
 * @author LiuXu
 * @time2018年7月26日下午7:34:31
 **/
public class sqlService {

	/**
	 * 连接数据库返回所有的学生信息
	 * 
	 * @return
	 */
	public List<Student> selectAll() {
		List<Student> students = new ArrayList<>();
		String sql = "select * from student";
		ResultSet rs = SQLUtil2.queryMethod(sql, null);
		if (rs != null) {
			try {
				while (rs.next()) {
					Student student = new Student();
					student.setId(rs.getInt("id"));
					student.setName(rs.getString("name"));
					student.setSex(rs.getString("sex"));
					student.setAge(rs.getInt("age"));
					student.setMathScore(rs.getInt("mathscore"));
					student.setChineseScore(rs.getInt("chinesescore"));
					students.add(student);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}

		}

		return students;

	}

}
