package com.lanou.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lanou.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

import javassist.expr.NewArray;

/**
 * 值栈--压栈 （向栈中添加数据,先进后出）
 * 
 * @author LiuXu
 * @time2018年7月30日下午2:16:31
 **/
public class TestAction extends ActionSupport {

	private String name;
	private User user;
	private List<User> lists;

	@Override
	public String execute() throws Exception {

		name = "aaa";
		ActionContext ac = ActionContext.getContext();
		// Map<String, Object> request = (Map<String, Object>)
		// ac.get("request");
		// System.out.println(request.getClass());
		// HttpServletRequest request2 = ServletActionContext.getRequest();
		// System.out.println(request2.getClass());
		lists = new ArrayList<>();
		user = new User("liuxu", "1223");
		user = new User("liuxu1", "1223");
		lists.add(user);

		Map<String, Object> session = ac.getSession();
		session.put("myname", "aaa");
		session.put("suser", user);
		session.put("list", lists);

		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session2 = request.getSession();
		session2.setAttribute("uname", "哈哈");
		session2.setAttribute("ulist", lists);

		// 获取栈对象
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.setParameter("name", "bb");//name为已有属性值
		vs.set("cc", "dd");
    
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getLists() {
		return lists;
	}

	public void setLists(List<User> lists) {
		this.lists = lists;
	}

}
