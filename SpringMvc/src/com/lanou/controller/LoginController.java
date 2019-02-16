package com.lanou.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author LiuXu
 * @time2018年9月9日上午11:52:39
 **/
public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
	  ModelAndView mav = new ModelAndView();
	  mav.setViewName("login");
	  return mav;
	}

	

	

	


}
