package com.lanou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

/**
 * 适配器
 * 
 * @author LiuXu
 * @time2018年9月9日下午12:41:15
 **/
public class RegisterController implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("注册");
	}

	
}
