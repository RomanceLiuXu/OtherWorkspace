package com.match.action;

import com.match.dao.FindPswDaoE;
import com.match.service.FindPswServiceE;

/**
 *
 * @author LiuXu
 * @time2018年8月5日下午2:40:38
 **/
public class PasswordAction {

	private String name;
	private String answer;

	public String checkPsw() {
//     实例化
		FindPswServiceE find = new FindPswServiceE();
		boolean IsFind = find.findPsw(name, answer);
		if (IsFind) {
			return "equal";
		}
		return "notequal";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
