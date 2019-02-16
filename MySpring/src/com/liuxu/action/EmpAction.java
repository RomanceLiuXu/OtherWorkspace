package com.liuxu.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.liuxu.bean.Emp;
import com.liuxu.service.EmpService;

/**
 *
 * @author LiuXu
 * @time2018年8月23日下午8:02:52
 **/
@Controller("empAction")
public class EmpAction {

	@Resource
	private EmpService empService;
	
	
	public String showAll(){
	  List<Emp> emps = empService.findAll();
	  for (Emp emp : emps) {
		System.out.println(emp);
	}
		return "success";
	}


	public EmpService getEmpService() {
		return empService;
	}


	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
	
	
	
}
