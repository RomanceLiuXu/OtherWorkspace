package com.lanou.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 *
 * @author LiuXu
 * @time2018年9月9日上午11:52:39
 **/
public class HelloController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("hello");
		Map<String, Object> map = mav.getModel();
		map.put("username", "123");
		
		ModelMap map2 = mav.getModelMap();
		map2.addAttribute("user", "456");
		return mav;
	}

}
