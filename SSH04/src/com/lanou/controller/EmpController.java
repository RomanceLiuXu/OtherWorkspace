package com.lanou.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	// 定义restful风格的访问路径
	@RequestMapping(value = "findAll", method = RequestMethod.GET)
	@ResponseBody
	public List<Emp> findAll() {
           List<Emp> emps = empService.findAll();
           System.out.println(emps);
           return emps;
	}
    
	/**
	 * 处理ajax发送的根据id查找emp对象请求
	 * {id}代表接收url路径上传过来的id参数
	 * @PathVariable("id")代表把从路径上接收的参数传给处理方法
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	@ResponseBody
    public Emp findEmpById(@PathVariable("id") int id){
    	    System.out.println("get:"+id);
    	    return new Emp(5, "ss", "男", 20);
    }
	
	/**
	 * 根据AJAX传过来的id删除一个资源
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	@ResponseBody
	 public boolean deleteEmpById(@PathVariable("id") int id){
 	    System.out.println("delete:"+id);
 	    return true;
 }

	@RequestMapping(value="/addEmp",method=RequestMethod.POST)
	@ResponseBody
	public boolean addEmp(Emp emp) {
		System.out.println("添加的emp:"+emp);
		return  true;
	}
	
	@RequestMapping(value="/updateEmp",method=RequestMethod.PUT)
	@ResponseBody
	public boolean updateEmp(Emp emp){
		System.out.println("修改的emp:"+emp);
		return true;
	}
	
}
