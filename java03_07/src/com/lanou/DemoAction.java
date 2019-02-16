package com.lanou;

import com.opensymphony.xwork2.ActionSupport;

/**
 *
 * @author LiuXu
 * @time2018年8月2日上午9:56:28
 **/
public class DemoAction extends ActionSupport {

	private String code;

	@Override
	public String execute() throws Exception {

		// 获取国际化标签对应的value值
		code = getText("global.code");
		System.out.println(code);
		return "success";

	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}
