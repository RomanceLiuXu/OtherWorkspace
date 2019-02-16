package com.lanou.controller;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author LiuXu
 * @time2018年9月10日下午1:49:13
 **/
public class FileTypeInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = true;
		// 判断是否为文件上传请求
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
			Map<String, MultipartFile> files = multipartHttpServletRequest.getFileMap();
			Iterator<String> iterator = files.keySet().iterator();
			// 对多部件请求资源进行遍历
			while (iterator.hasNext()) {
				String formKey = iterator.next();
				MultipartFile multipartFile = multipartHttpServletRequest.getFile(formKey);
				String filename = multipartFile.getOriginalFilename();
				// 判断是否为限制文件类型
				if (!checkFile(filename)) {
					request.setAttribute("errormessage", "不支持的文件类型");
					request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
					flag = false;
				}
			}
		}

		return flag;
	}

	private boolean checkFile(String fileName) {
		// 设置允许上传的文件类型
		String suffixList = "gif,png,ico,bmp,jpeg";
		// 获取文件后缀
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length());
		if (suffixList.contains(suffix.trim().toLowerCase())) {
			return true;
		}
		return false;
	}

}
