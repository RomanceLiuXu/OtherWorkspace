package com.lanou.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.lanou.bean.Emp;
import com.lanou.service.EmpService;

/**
 *
 * @author LiuXu
 * @time2018年8月23日上午11:33:09
 **/
@Controller("empAction")
public class EmpAction {

	@Resource
	private EmpService empService;

	public String execute() {
		// 放入session,返回给前段页面显示
		List<Emp> emps = empService.listAll();
		System.out.println("结果集:"+emps);
		return "success";
	}

	public EmpService getEmpService() {
		return empService;
	}

	public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

}
