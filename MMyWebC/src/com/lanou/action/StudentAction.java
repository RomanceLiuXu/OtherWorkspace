package com.lanou.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lanou.bean.Student;
import com.lanou.service.StudentService;

/**
 *
 * @author LiuXu
 * @time2018年8月27日下午1:53:29
 **/
@Controller("studentAction")
public class StudentAction {

	@Autowired
	private StudentService stuService;
	private Student student;
	private List<Student> students;
	private int page;// 当前页
	private int pageCount;// 每页显示的个数
	private long allPage;// 总页数
	private Integer index;

	// 添加学生
	public String addStudent() {
		stuService.addStdent(student);
		return "add_success";
	}

	// 查询学生
	

	public String showStudent() {
		pageCount = 1;
		if (index==null) {
			this.page = 1;
			this.index = 1;
		} else {
			this.page = index;
		}
		long n = stuService.findStuNum();
		System.out.println(n);
		this.allPage = n % pageCount == 0 ? n / pageCount : n / pageCount + 1;
		students = stuService.findStudent(page, pageCount);
		System.out.println("-action:" + allPage);
		return "success";
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public long getAllPage() {
		return allPage;
	}

	public void setAllPage(long allPage) {
		this.allPage = allPage;
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

}
