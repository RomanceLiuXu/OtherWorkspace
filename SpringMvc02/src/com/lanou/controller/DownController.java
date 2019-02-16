package com.lanou.controller;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author LiuXu
 * @time2018年9月10日下午8:03:05
 **/
@Controller
@RequestMapping("/myFile")
public class DownController {

	@RequestMapping("/download.do")
	public ResponseEntity<byte[]> download() throws IOException {
		String path = "/Users/xalo/Desktop/aa.jpg";
		// 指定文件
		File file = new File(path);
		// 设置HttpHeaders,让浏览器响应下载
		HttpHeaders headers = new HttpHeaders();
		// 处理文件名是中文的问题，存储的名称为原名称file.getName(),也可以自定义名称
		String fileName = new String(file.getName().getBytes("UTF-8"), "iso-8859-1");
		// 设置响应文件
		headers.setContentDispositionFormData("attachment", fileName);
		// 设置文件的mime-type,MediaType继承与MimeType,APPLICATION_OCTET_STREAM指的是字节流
		// 设置响应方式
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		// 将文件以二进制的形式写回
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file), headers, HttpStatus.CREATED);
	}

}
