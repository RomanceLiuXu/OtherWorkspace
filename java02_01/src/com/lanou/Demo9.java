package com.lanou;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author LiuXu
 * @time2018年6月8日下午3:12:49
 **/
public class Demo9 extends JFrame {
	// 面板
	JPanel jp1, jp2, jp3;
	// 文本显示框
	JLabel jl1, jl2;
	// 文本输入栏
	JTextField jt1, jt2;
	// 按钮
	JButton jb1, jb2;

	public static void main(String[] args) {
		new Demo9();
	}

	/*
	 * 空的构造函数
	 */
	public Demo9() {

		// 实例化面板对象
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();

		// 实例化文本显示框
		jl1 = new JLabel("用户名");
		jl2 = new JLabel("密码");
		
		// 实例化文本输入栏
		jt1 = new JTextField();
		jt2 = new JTextField();
		
		// 设置文本输入栏大小
		jt1.setPreferredSize(new Dimension(100, 25));
		jt2.setPreferredSize(new Dimension(100, 25));
		
		// 实例化按钮
		jb1 = new JButton("登录");
		jb2 = new JButton("注册");

		// 在jp1上添加文本显示框和文本输入栏
		jp1.add(jl1);
		jp1.add(jt1);

		// 在jp2上添加文本显示框和文本输入栏
		jp2.add(jl2);
		jp2.add(jt2);

		// 在JP3面板上添加按钮
		jp3.add(jb1);
		jp3.add(jb2);

		// 设置格式
		this.add(jp1, BorderLayout.NORTH);
		this.add(jp2, BorderLayout.CENTER);
		this.add(jp3, BorderLayout.SOUTH);

		// 设置其他属性
		this.setTitle("多种布局");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
