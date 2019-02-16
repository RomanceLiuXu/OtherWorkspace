package com.lanou.interceptor;

import java.util.Map;

import javax.jws.Oneway;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.opensymphony.xwork2.util.ValueStack;

/**
 *
 * @author LiuXu
 * @time2018年7月31日下午2:21:40
 **/
public class Test4Interceptor extends MethodFilterInterceptor {

	private String name1;

	// @Override
	// public String intercept(ActionInvocation invocation) throws Exception {
	//
	//// Map<String, Object> parameters =
	// invocation.getInvocationContext().getParameters();
	//
	//// for (Object object : parameters.keySet()) {
	//// System.out.print(object + "--" + parameters.get(object));
	//// }
	//
	// // 获取拦截器中param中的参数值
	//
	// System.out.println("拦截器的方法");
	//
	// return null;
	// }

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("doIntercept");
		// 获取前端传来内容
		Map<String, Object> params = (Map<String, Object>) invocation.getInvocationContext().getParameters();
         String[] code = (String[]) params.get("code");
		 System.out.println(code[0]);
		 
//       Result result = invocation.getResult();
//        System.out.println(result);
         HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
		 System.out.println(request.getParameter("code"));
         
		 String invoke = invocation.invoke();
		 System.out.println(invoke);
		return null;
	}

}
