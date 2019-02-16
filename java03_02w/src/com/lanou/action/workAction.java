package com.lanou.action;

import java.sql.ResultSet;
import java.util.List;

import com.lanou.bean.Student;
import com.lanou.utils.SQLUtil2;

/**
 *
 * @author LiuXu
 * @time2018年7月26日下午7:22:13
 **/
public class workAction {

	private String code;// 账号
	private String psw;// 密码
	private List<Student> students;//学生集合

	public String loginCheck() {
		if ("liuxu".equals(code) && "123456".equals(psw)) {
			// 登录成功,连接数据库查询所有的成员并跳转主页面
			// 实例化
			sqlService sq = new sqlService();
			//调用方法
			students = sq.selectAll();
			return "success";

		}

		return "error";
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

}
