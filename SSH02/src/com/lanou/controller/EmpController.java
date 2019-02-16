package com.lanou.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lanou.bean.Emp;
import com.lanou.service.EmpService;

/**
 *
 * @author LiuXu
 * @time2018年9月9日下午2:18:33
 **/
@Controller
@RequestMapping("/emp")
public class EmpController {

	@Autowired
	private EmpService empService;

	@RequestMapping("/listAll.do")
	public String show(Model model) {
		List<Emp> emps = empService.findAll();
		model.addAttribute("emps", emps);
		return "show";
	}

	@RequestMapping("/toAddEmp.do")
	public String toAddEmp() {

		return "addEmp";
	}

	@RequestMapping("/addEmp.do")
	public String addEmp(Emp emp, String birth, String color, Model model, Exception ex) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// String string = null;
		// System.out.println(string.length());
		Date date = sdf.parse(birth);
		System.out.println("date=" + date);
		// try {
		// Date date = sdf.parse(birth);
		// System.out.println("date=" + date);
		// } catch (Exception e) {
		// // 如果出现异常，重定向到添加页面,返回异常信息
		// model.addAttribute("msg", "日期格式错误");
		// return "addEmp";
		// }
		System.out.println("color=" + color);
		empService.addEmp(emp);
		return "redirect:listAll.do";
	}

	/**
	 * 局部异常处理器方法 处理当前controller其他方法中抛出的异常
	 * 
	 * @param e代表其他处理器方法抛出的异常
	 */
	@ExceptionHandler
	public String handleException(Exception e, HttpSession session) {
		System.out.println("e:" + e);
		session.setAttribute("msg", e);
		if (e instanceof ParseException) {
			return "parse";
		} else if (e instanceof NullPointerException) {
			return "null";
		} else {
			return "redirect:toAddEmp.do";
		}
	}

}
