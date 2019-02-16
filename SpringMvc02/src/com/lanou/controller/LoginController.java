package com.lanou.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.lanou.bean.User;

/**
 *
 * @author LiuXu
 * @time2018年9月9日下午1:02:05
 **/
@Controller
@RequestMapping("/emp")//一级路径
public class LoginController {
     
	@RequestMapping("/login.do")
	public ModelAndView handleRequest(){
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}
	
	@RequestMapping("tologin.do")
	public String myTest() {
		
		return "login";
	}
	
	@RequestMapping("login1.do")
	public String login1(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		request.setCharacterEncoding("UTF-8");
//		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+":"+password);
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		return "show";
	}
	
	@RequestMapping("login2.do")
	public String login2(String username,String password,HttpSession session) {
		System.out.println(username+":"+password);
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		return "show";
	}
	
	@RequestMapping("login3.do")
	public String login3(@RequestParam(value="username",defaultValue="aaa")String user,@RequestParam("password")String psw,Model model) {
		System.out.println(user+":"+psw);
		model.addAttribute("user", user);
		model.addAttribute("psw", psw);
		return "show";
	}
	
	@RequestMapping("login4.do")
	public String login4(User user){
		System.out.println(user.getUsername());
		return "show";
	}
}
