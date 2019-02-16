package com.lanou.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.lanou.bean.Person;
import com.opensymphony.xwork2.ActionContext;

/**
 * struts中访问servlet中api的方式一
 * 
 * @author LiuXu
 * @time2018年7月27日上午11:29:19
 **/
public class Test3Action {

	/**
	 * 使用ActionContext获取
	 * 
	 * @return
	 */
	public String method1() {
		// 获取ActionContext对象
		ActionContext ac = ActionContext.getContext();
		// 获取map集合的request
		Map<String, Object> request = (Map<String, Object>) ac.get("request");
		// 向request中添加值
		request.put("code", "lhl");
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("lixu", "nan", 20));
		// 添加对象
		request.put("per", persons);
		// 获取session对象
		Map<String, Object> session = ac.getSession();
		session.put("code", "lhl1");
		// 获取application
		Map<String, Object> application = ac.getApplication();
		application.put("code", "liuxu2");
		return "success";
	}

}
