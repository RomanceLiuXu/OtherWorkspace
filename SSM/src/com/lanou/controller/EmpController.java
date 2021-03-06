package com.lanou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lanou.bean.Emp;
import com.lanou.service.EmpService;

/**
 *
 * @author LiuXu
 * @time2018年9月20日上午9:53:40
 **/
@Controller
@RequestMapping("/emp")
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String tolist(Model model){
		List<Emp> emps = empService.findAll();
		model.addAttribute("emps", emps);
		for (Emp emp : emps) {
			System.out.println(emp);
		}
		return "list";
	}
	
	
}
