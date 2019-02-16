package com.lanou.work;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务类
 * 
 * @author LiuXu
 * @time2018年7月3日下午9:03:18
 **/
public class UService {

	public static void main(String[] args) {

		// 实例化Users作为初始对象
		Users u1 = new Users("小王", "wang123456");
		Users u2 = new Users("小李", "li123456");
		Users u3 = new Users("周小", "zhou123456");

		// 新建集合存放users对象
		List<Users> uLists = new ArrayList<>();
		uLists.add(u1);
		uLists.add(u2);
		uLists.add(u3);

		// 实例化对象
		try {
			ServerSocket ss = new ServerSocket(12345);
			System.out.println("服务端正在监听...");
			// 监听
			Socket st = ss.accept();
			// 获取对象
			InputStream is = st.getInputStream();

			ObjectInputStream objIs = new ObjectInputStream(is);
			Users uU = (Users) objIs.readObject();
			// 定义字符串表示判断的结果
			String re = "";
			// 遍历集合
			for (Users users : uLists) {
				if (uU.getAccount().equals(users.getAccount()) && uU.getPsw().equals(users.getPsw())) {
					re = "登录成功";
					break;
				} else {
					re = "登录失败";
					break;
				}
			}

			// 返回给客户端结果
			OutputStream os = st.getOutputStream();
			PrintWriter pw = new PrintWriter(os,true);
			pw.println(re);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
