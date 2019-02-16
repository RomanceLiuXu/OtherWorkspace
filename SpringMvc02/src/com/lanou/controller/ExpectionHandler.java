package com.lanou.controller;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author LiuXu
 * @time2018年9月10日上午10:52:03
 **/
@Controller
public class ExpectionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj,
			Exception ex) {
		ModelAndView mav = new ModelAndView();
		// 判断异常
		if (ex instanceof MaxUploadSizeExceededException) {
			// 文件大小超出限制
			System.out.println("异常:MaxUploadSizeExceededException,上传的文件大小超出限制");
			// 设置（存储）给前段要传的信息
			mav.addObject("errormessage", "上传文件过大");
			// 设置视图名称，跳转到error.jsp页面
			mav.setViewName("error");
			try {
				// 将异常信息写入日志
				PrintWriter pw = new PrintWriter("/Users/xalo/Desktop/uploadException.txt");
				// 格式化日期
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 	HH:mm:ss");
				// 写入异常产生的时间
				pw.print("异常产生时间:" + sdf.format(new Date()));
				// 写入异常产生的类型
				pw.println("异常的类型:" + ex.getClass().getName());
				pw.println("------------------------------异常详情--------------------------");
				// 打印异常堆栈信息
				ex.printStackTrace(pw);
				pw.flush();
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}

		}
		return mav;
	}

}
