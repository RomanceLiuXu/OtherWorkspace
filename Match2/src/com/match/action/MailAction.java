package com.match.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.match.util.VerificationUtil;

/**
 *
 * @author LiuXu
 * @time2018年8月11日下午4:07:03
 **/
public class MailAction {

	private String mail;
	private String vcode;
	private String message;
	HttpSession session = ServletActionContext.getRequest().getSession();

	public String emailSend() {
		// 生成验证码并发送
		String validateCode = VerificationUtil.createnNum(4);
		boolean IsSend = VerificationUtil.sendEmail(mail, validateCode);
		if (IsSend) {
			session.setAttribute("vcode", validateCode);
			System.out.println("生成的验证码:" + validateCode);
			this.message = "success";
		} else {
			this.message = "error";
		}
		return "success";
	}

	public String emailCheck() {
		String str = (String) session.getAttribute("vcode");
		if (str != null) {
			System.out.println("session中的验证码:" + str);
			if (str.equalsIgnoreCase(vcode)) {
				return "success";
			}
		}
		return "error";
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

}
