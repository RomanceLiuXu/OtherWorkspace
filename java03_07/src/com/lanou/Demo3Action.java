package com.lanou;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

/**
 *
 * @author LiuXu
 * @time2018年8月2日下午2:58:46
 **/
public class Demo3Action {
	private InputStream inputStream;//输入流对象
	private String filename;//前端传来的需下载的文件名称

	public String method1() {
		
		return "success";
	}

	public InputStream getInputStream() {
         System.out.println(filename);
		return ServletActionContext.getServletContext().getResourceAsStream("myimg/"+filename);
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

}
