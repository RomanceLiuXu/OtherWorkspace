package com.lanou.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.bean.User;

/**
 *
 * @author LiuXu
 * @time2018年9月12日上午11:07:37
 **/
@Controller
public class LoginController {

	@RequestMapping("/tologin.do")
	public String tologin() {

		return "login";
	}

	/**
	 * 处理用户登录请求 如果ajax提交的数据格式满足请求实体数据包中格式 key=value&key=value...,
	 * 可以直接在处理方法中通过方法的形参
	 * 进行接收或者对象接收
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("/login.do")
	@ResponseBody
	public String login(User user) {
		System.out.println(user.getUsername() + "--" + user.getPassword());
		return "hello";
	}

	/**
	 * 用户提交的数据是json字符串格式
	 * 在处理器方法实体对象前面添加@RequestBody注解
	 * json字符串中的key值要和实体类中属性名保持一致
	 * @param user
	 * @return
	 */
	@RequestMapping("/login1.do")
	@ResponseBody
	public String login1(@RequestBody User user) {
		System.out.println(user.getUsername() + "--" + user.getPassword());
		return "hello";
	}
}
