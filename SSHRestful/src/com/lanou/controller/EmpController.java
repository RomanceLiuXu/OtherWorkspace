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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.lanou.bean.Emp;
import com.lanou.service.EmpService;

/**
 *
 * @author LiuXu
 * @time2018年9月9日下午2:18:33
 **/
@Controller
@RequestMapping
public class EmpController {

	@Autowired
	private EmpService empService;

	@RequestMapping("/toshow.do")
	public String toshow() {
		return "show";
	}

	@RequestMapping("/toUpdate.do")
	public String toUpate() {
		return "updateEmp";
	}

	@RequestMapping("/listAll")
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
	@ResponseBody
	public boolean addEmp(@RequestBody Emp emp, Exception ex) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// String string = null;
		// System.out.println(string.length());
		// Date date = sdf.parse(birth);
		// System.out.println("date=" + date);
		// try {
		// Date date = sdf.parse(birth);
		// System.out.println("date=" + date);
		// } catch (Exception e) {
		// // 如果出现异常，重定向到添加页面,返回异常信息
		// model.addAttribute("msg", "日期格式错误");
		// return "addEmp";
		// }
		// System.out.println("color=" + color);
		empService.addEmp(emp);
		return true;
	}

	@RequestMapping("/checkName.do")
	@ResponseBody
	public boolean checkName(String uname) {
		System.out.println(uname);
		Emp emp = empService.findEmpByName(uname);
		if (emp == null) {
			// 名称可用
			return false;
		} else {
			// 有重复名称，名称不可用
			return true;
		}
	}

	@RequestMapping(value = "deleteEmp/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	public boolean deleteEmp(@PathVariable("id") int id) {
		try {
			System.out.println("id=" + id);
			empService.deleteEmp(id);
		} catch (Exception e) {
			return false;
		}

		return true;
	}

	@RequestMapping(value="/updateEmp",method=RequestMethod.PUT)
	@ResponseBody
	public boolean udateEmp(@RequestBody Emp emp) {
		System.out.println("emp:" + emp.toString());
		empService.updateEmp(emp);
		return true;
	}

	@RequestMapping("/findPageAll")
	public String findPageAll(Integer pageIndex, Integer pageNum, HttpSession session) {
		System.out.println("页码:"+pageIndex+"----"+"每页的个数:"+pageNum);
		// 初始化的页码和每页显示的个数
		if (pageIndex == null) {
			pageIndex = 1;
		}
		if (pageNum == null) {
			pageNum = 6;
		}
		// 总记录数
		long all = empService.findAllNums();
		// 根据每页的条数查询总页数
		long allPage = all % pageNum == 0 ? all / pageNum : all / pageNum + 1;
		session.setAttribute("allPage", allPage);
		session.setAttribute("pageIndex", pageIndex);
		session.setAttribute("pageNum", pageNum);
		List<Emp> emps = empService.findPageAll(pageIndex, pageNum);
		session.setAttribute("emps", emps);
		return "show";
	}

	/**
	 * 局部异常处理器方法 处理当前controller其他方法中抛出的异常
	 * 
	 * @param e代表其他处理器方法抛出的异常
	 */
	// @ExceptionHandler
	// public String handleException(Exception e, HttpSession session) {
	// System.out.println("e:" + e);
	// session.setAttribute("msg", e);
	// if (e instanceof ParseException) {
	// return "parse";
	// } else if (e instanceof NullPointerException) {
	// return "null";
	// } else {
	// return "redirect:toAddEmp.do";
	// }
	// }

}
