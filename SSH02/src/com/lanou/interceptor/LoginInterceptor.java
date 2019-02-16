package com.lanou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.lanou.util.Const;

/**
 * 登录的拦截器 用户在访问其他controller之前，判断是否登录过
 * 
 * @author LiuXu
 * @time2018年9月11日上午11:26:06
 **/
public class LoginInterceptor implements HandlerInterceptor {

	long t1 = 0;

	/**
	 * 请求进入controller处理器之前调用
	 * 
	 * @param obj:拦截器所拦截的处理请求的方法对象
	 * @return true:继续执行后续的逻辑 只有当返回值为true时，后面的两个方法才会得到执行 false:拦截请求
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// 记录请求到达时系统当前时间
	    t1 = System.currentTimeMillis();
		System.out.println("preHandle obj:" + obj.getClass().getName());
		// 从session中取出用户名
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username == null) {
			// 没有登陆过，重定向到登录页面
			response.sendRedirect(Const.BASE_URL + "user/tologin.do");
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 处理器中方法执行完请求之后调用 mav:是处理器中方法执行完请求后的返回值
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView mav)
			throws Exception {
		System.out.println("postHandle obj:" + obj.getClass().getName());
		// 获取处理中方法返回的视图名称和返回数据
		System.out.println("返回的视图名称:" + mav.getViewName());
		System.out.println("返回数据:" + mav.getModel());
		// 通过ModelAndView修改返回的视图
		// mav.setViewName("error");
	}

	/**
	 * 全部流程处理完成，视图返回给页面之前调用 一般该方法可以用来计算请求消耗时间，清理内存之类工作
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception ex)
			throws Exception {
		System.out.println("afterCompletion obj:" + obj.getClass().getName());
		// 在请求处理完成，响应返回给前段之前记录当前时间
		long t2 = System.currentTimeMillis();
		System.out.println("当前请求消耗时间:" + (t2 - t1));
	}

}
