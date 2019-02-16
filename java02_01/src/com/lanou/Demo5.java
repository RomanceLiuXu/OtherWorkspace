package com.lanou;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 流失布局
 * 
 * @author LiuXu
 * @time2018年6月8日上午11:04:16
 **/
public class Demo5 extends JFrame {
	JButton[] jbs;// 按钮的数组

	/*
	 * 主函数
	 */
	public static void main(String[] args) {
		new Demo5();
	}

	/*
	 * 构造方法
	 */
	public Demo5() {
		// 定义数组
		jbs = new JButton[5];
		// for循环添加
		for (int i = 0; i < jbs.length; i++) {
			jbs[i] = new JButton(new String(i + "号按钮"));
			// 添加JButton到jf中
			this.add(jbs[i]);
		}

		// 设置窗体布局
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		// 设置窗体属性
		this.setTitle("流式布局窗体");
		this.setSize(500, 300);
		this.setLocation(300, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.green);
		this.setVisible(true);

	}
}
