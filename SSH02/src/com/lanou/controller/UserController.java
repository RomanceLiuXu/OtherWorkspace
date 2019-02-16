package com.lanou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lanou.bean.User;
import com.lanou.service.UserService;

/**
 * springmvc中的重定向和转发
 * 
 * @author LiuXu
 * @time2018年9月10日上午11:44:31
 **/
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * 访问登录页面
	 * 
	 * @return
	 */
	@RequestMapping("/tologin.do")
	public String tologin() {
		return "login";
	}

	/**
	 * 处理用户登录请求 返回值类型为string
	 * 
	 * @return
	 */
	@RequestMapping("/login.do")
	public String login(User user, HttpSession session) {
		boolean result = userService.login(user);
		if (result) {
			 // 将登录的用户名存入session
			 session.setAttribute("username", user.getUsername());
			// 登录成功，重定向到显示列表
			return "redirect:/emp/listAll.do";
			// 转发(目标是一个url地址，而不是一个视图页面)
			// return "forward:/emp/listAll.do";
		} else {
			session.setAttribute("msg", "账号或密码错误");
			return "redirect:tologin.do";
		}
	}

	/**
	 * 处理用户登录请求 返回值类型为ModelAndView
	 * 
	 * @return
	 */
	// @RequestMapping("/login.do")
	// public ModelAndView login(User user, HttpSession session,
	// HttpServletRequest request) {
	// boolean result = userService.login(user);
	// System.out.println("uri:" + request.getRequestURI());// 资源名称
	// System.out.println("url:" + request.getRequestURL());// 资源路径
	// ModelAndView mav = new ModelAndView();
	// if (result) {
	// // 登录成功
	// // 重定向方式
	// // mav.setViewName("redirect:/emp/listAll.do");
	// // 方式二 利用view
	// // View view = new RedirectView("/SSH02/emp/listAll.do");
	// // mav.setView(view);
	//
	// // 将登录的用户名存入session
	// session.setAttribute("username", user.getUsername());
	// // 转发
	// mav.setViewName("forward:/emp/listAll.do");
	// } else {
	// // 登录失败
	// session.setAttribute("msg", "账号或密码错误");
	// mav.setViewName("redirect:tologin.do");
	// }
	//
	// return mav;
	// }

}
