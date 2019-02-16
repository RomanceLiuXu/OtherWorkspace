package com.lanou.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lanou.bean.Person;

/**
 * struts中访问servlet中api的方式三
 * 
 * @author LiuXu
 * @time2018年7月27日下午2:22:37
 **/
public class Test5Action {

	public String method1() {
		// 通过ServletActionContext获取HttpServletRequest对象
		HttpServletRequest request = ServletActionContext.getRequest();
		// HttpServletResponse response = ServletActionContext.getResponse();
		// 获取ServletContext对象
		ServletContext application = request.getServletContext();
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("lixu", "nan", 20));
		// 向request中设置值
		request.setAttribute("user", "liuxu");
		request.setAttribute("person", persons);
		HttpSession session = request.getSession();
		session.setAttribute("age", 10);
		application.setAttribute("age", 20);
		return "success";
	}

}
