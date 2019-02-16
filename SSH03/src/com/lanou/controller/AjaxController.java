package com.lanou.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.bean.User;

/**
 *
 * @author LiuXu
 * @time2018年9月11日下午4:50:57
 **/
@Controller
public class AjaxController {

	/** 访问ajax页面 */
	@RequestMapping("/toAjax.do")
	public String toAjax() {

		return "ajax";
	}

	/**
	 * 处理ajax发送过来的请求 如果请求发起方如果是ajax，那么在返回字符串的时候，会把字符串当做是视图名称拿到视图解析器中做匹配，
	 * 找到相应的jsp页面，解析出jsp页面的源代码内容，返回给ajax
	 * 当添加@ResponseBody这个注解，返回的字符串不会去和视图解析器做匹配，而是直接返回给Ajax，注解可以
	 * 直接加载在方法上面，也可以加在返回值类型面前
	 */
	@RequestMapping("/ajax1.do")
	@ResponseBody
	public String ajax1() {

		return "hello";
	}

	/**
	 * 给前段ajax返回boolean值类型 会被前端解析为boolean类型
	 * 
	 * @return
	 */
	@RequestMapping("/ajax2.do")
	@ResponseBody
	public boolean ajax2() {
		return true;
	}

	/**
	 * 给前段返回数值类型 会被前端解析为Number类型
	 * 
	 * @return
	 */
	@RequestMapping("/ajax3.do")
	@ResponseBody
	public double ajax3() {

		return 2.23;
	}

	/**
	 * 给前段返回一个bean对象类型 bean对象会被js解析为一个JSON对象
	 * 
	 * @return
	 */
	@RequestMapping("/ajax4.do")
	@ResponseBody
	public User ajax4() {

		return new User(3, "小花", "1234");
	}

	/**
	 * 给前段ajax返回list集合数据
	 * list集合会被前端解析为Array数组
	 * @return
	 */
	@RequestMapping("/ajax5.do")
	@ResponseBody
	public List<User> ajax5() {
		List<User> users = new ArrayList<>();
//		users.add("啦啦啦啦");
//		users.add(30);
		users.add(new User(2, "ss", "123"));
		users.add(new User(3, "aa", "123"));
		return users;
	}

	/**
	 * 给前段ajax返回一个map集合类型
	 * map会被前端JS解析为JSON对象
	 * @return
	 */
	@RequestMapping("/ajax6.do")
	@ResponseBody
	public Map<String, Object> ajax6() {
		Map<String, Object> maps = new HashMap<>();
		maps.put("msg", "来自springmvc的数据");
		maps.put("user", new User(3, "ee", "1223"));
		return maps;
	}

}
