package com.testWebsocket;

import java.util.Date;
import java.util.List;

/**
 *
 * @author LiuXu
 * @time2018年9月13日下午2:24:13
 **/
public class FromSerMsg {

	private String alert;// 展示用户登录或者退出
	private List<String> names;// 所有用户的信息
	private String sendMsg;// 发送的消息
	private String fromWho;// 谁发的消息
	private String date;// 发送消息的时间

	public FromSerMsg(String alert, List<String> names, String sendMsg, String fromWho, String date) {
		super();
		this.alert = alert;
		this.names = names;
		this.sendMsg = sendMsg;
		this.fromWho = fromWho;
		this.date = date;
	}

	public FromSerMsg() {
		super();
	}

	public String getAlert() {
		return alert;
	}

	public void setAlert(String alert) {
		this.alert = alert;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public String getSendMsg() {
		return sendMsg;
	}

	public void setSendMsg(String sendMsg) {
		this.sendMsg = sendMsg;
	}

	public String getFromWho() {
		return fromWho;
	}

	public void setFromWho(String fromWho) {
		this.fromWho = fromWho;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
