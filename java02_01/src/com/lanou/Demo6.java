package com.lanou;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 网格布局
 * 
 * @author LiuXu
 * @time2018年6月8日上午11:18:40
 **/
public class Demo6 extends JFrame {
	List<JButton> jbs;

	public static void main(String[] args) {
		new Demo6();
	}

	public Demo6() {
		// 实例化
		jbs = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			// 实例化按钮添加到集合中
			jbs.add(new JButton("" + (i + 1)));

		}
		// 循环添加到窗体
		for (JButton jButton : jbs) {
			this.add(jButton);
		}

		// 设置布局
		this.setLayout(new GridLayout(3, 3));
		// 设置其他属性
		this.setTitle("网格布局窗体");
		this.setSize(500, 300);
		this.setLocation(300, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(Color.green);
		this.setVisible(true);
	}

}
