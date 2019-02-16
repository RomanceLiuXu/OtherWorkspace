package com.lanou.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.lanou.bean.Person;

/**
 * struts中访问servlet中api的方式二
 * 
 * @author LiuXu
 * @time2018年7月27日下午2:01:31
 **/
public class Test4Action implements RequestAware, SessionAware, ApplicationAware {
	private Map<String, Object> request;
	private Map<String, Object> session;
	private Map<String, Object> application;

	public String method1() {
		List<Person> lists = new ArrayList<>();
		// 给request设置值
		lists.add(new Person("aaa", "ss", 12));
		request.put("username", "lhl1");
		request.put("list", lists);
        session.put("username", "liuxu");
        application.put("password", "123456");
		return "success";
	}

	@Override
	public void setApplication(Map<String, Object> application) {
          this.application = application;
	}

	@Override
	public void setSession(Map<String, Object> session) {
       this.session = session;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		this.request = request;

	}

}
