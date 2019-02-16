package com.lanou.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author LiuXu
 * @time2018年9月9日下午4:44:53
 **/
@Controller
public class UploadController {

	@RequestMapping("toUp.do")
	public String fileUp() {

		return "fileUps";
	}

	@RequestMapping("/upload.do")
	public String upload(MultipartFile uploadFile, HttpSession session) throws IllegalStateException, IOException {
		// 获取文件名
		String fileName = uploadFile.getOriginalFilename();
		String realPath = session.getServletContext().getRealPath("image");
		System.out.println("realPath:" + realPath);
		System.out.println("文件名:" + fileName);
		File file = new File(realPath, fileName);
		uploadFile.transferTo(file);
		return "show";
	}
	
	@RequestMapping("/uploads.do")
	public String uploads(@RequestParam("uploadFiles") MultipartFile[] uploadFiles, HttpSession session) throws IllegalStateException, IOException {
		for (int i = 0; i < uploadFiles.length; i++) {
			// 获取文件名
			String fileName = uploadFiles[i].getOriginalFilename();
			String realPath = session.getServletContext().getRealPath("image");
			System.out.println("realPath:" + realPath);
			System.out.println("文件名:" + fileName);
			File file = new File(realPath, fileName);
			uploadFiles[i].transferTo(file);
		}
		System.out.println("dada");
		return "show";
	}

}
