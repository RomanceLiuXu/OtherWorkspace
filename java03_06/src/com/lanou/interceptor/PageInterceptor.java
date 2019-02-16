package com.lanou.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *
 * @author LiuXu
 * @time2018年8月1日下午8:33:53
 **/
public class PageInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
     
		HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
		String actionName = invocation.getProxy().getActionName();
		String page = request.getParameter("page");
		if (actionName.equals("page")) {
			if (page!=null&&!page.equals("")) {
				int p = Integer.parseInt(page);
				if (p>0) {
					invocation.invoke();
				}else {
					return "error";
				}
			}
		}else {
			return "error";
		}
		
		return null;
	}

}
