package com.lanou.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.lanou.bean.Test3Entity;

/**
 * 自定义类型转换
 * 
 * @author LiuXu
 * @time2018年7月30日下午4:56:41
 **/
public class TestAction3 {

	private Test3Entity entity;

	public String method1() {
//		System.out.println(entity.getX() + ":" + entity.getY());
//		HttpSession session = ServletActionContext.getRequest().getSession();
//		session.setAttribute("entity", entity);
		return "success";
	}

	public Test3Entity getEntity() {
		return entity;
	}

	public void setEntity(Test3Entity entity) {
		this.entity = entity;
	}

}
