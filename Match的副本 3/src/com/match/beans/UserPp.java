package com.match.beans;



import java.io.Serializable;

/**
 *
 * @author xxc
 * @time 2018年7月13日下午4:31:21
 **/
public class UserPp implements Serializable {
	private int pid;// 图片id
	private String pname;// 图片名字
	private String paddress;// 图片
	private int uid;// 用户序号
	private String name;// 姓名
	private int age;// 年龄
	private String sex;// 性别
	private String address;// 地址
	private String psw;// 密码
	private String answer;// 密保答案

	public UserPp() {
		super();
	}

	public UserPp(int pid, String pname, String paddress, int uid, String name, int age, String sex, String address,
			String psw, String answer) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.paddress = paddress;
		this.uid = uid;
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.address = address;
		this.psw = psw;
		this.answer = answer;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "UserPp [pid=" + pid + ", pname=" + pname + ", paddress=" + paddress + ", uid=" + uid + ", name=" + name
				+ ", age=" + age + ", sex=" + sex + ", address=" + address + ", psw=" + psw + ", answer=" + answer
				+ "]";
	}

}
