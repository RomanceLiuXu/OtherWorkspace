package com.lanou;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author LiuXu
 * @time2018年6月8日上午11:29:34
 **/
public class Demo7 extends JFrame {
	// 按钮控件
	JButton jb, jb1, jb2, jb3, jb4, jb5;
	// 面板控件
	JPanel jp1, jp2;

	public static void main(String[] args) {
		new Demo7();
	}

	/*
	 * 构造方法
	 */
	public Demo7() {
		// 实例化按钮
		jb = new JButton("a");
		jb1 = new JButton("f");
		// jb1.getParent().setVisible(false);
		// jb1.setBackground(Color.red);
		// jb1.setForeground(Color.RED);
		jb2 = new JButton("c");
		jb3 = new JButton("d");
		jb4 = new JButton("b");
		jb5 = new JButton("e");
		// 实例化面板
		jp1 = new JPanel();
		jp2 = new JPanel();
		// 设置面板颜色
		jp1.setBackground(Color.BLUE);
		jp2.setBackground(Color.RED);
		// jb.setBackground(Color.blue);
		// jb4.setBackground(Color.blue);
		//
		// jb4.setBackground(Color.blue);
		//
		// jb2.setBackground(Color.red);
		// jb3.setBackground(Color.red);
		// jb5.setBackground(Color.red);
		//

		// 将按键加入面板1
		jp1.add(jb);
		jp1.add(jb4);
		// 设置面板1的布局方式
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER));

		// 将按键加入面板2
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb5);
		// 设置面板2的布局方式
		jp2.setLayout(new FlowLayout(FlowLayout.CENTER));

		// 添加按钮到窗体中
		this.add(jp1, BorderLayout.NORTH);
		this.add(jb1, BorderLayout.CENTER);
		this.add(jp2, BorderLayout.SOUTH);
		// 其他属性
		this.setTitle("混合窗体");
		this.setSize(500, 300);
		this.setLocation(300, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.green);
		this.setVisible(true);
	}

}
