package com.lanou;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * java图形界面规范写法
 * 
 * @author LiuXu
 * @time2018年6月8日上午9:51:13
 **/
public class Demo2 {
	JFrame jf;

	public static void main(String[] args) {
		Demo2 d2 = new Demo2();

	}

	/*
	 * 空的构造方法
	 */
	public Demo2() {
		// 实例化
		jf = new JFrame("规范窗体");
		// 设置大小
		jf.setSize(300, 300);
		// 设置窗体的位置
		jf.setLocation(200, 300);
		// 设置图标
		ImageIcon imageIcon = new ImageIcon("/Users/xalo/Documents/oneworkspaces/java02_01/img/气球.png");
		jf.setIconImage(imageIcon.getImage());
		// 退出时关闭
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// 设置禁止改变窗体
		jf.setResizable(true);

		// 设置窗体的背景色
		jf.setBackground(new Color(0, 0, 255));
		// 设置内容面板不显示
		jf.getContentPane().setVisible(false);
		// 设置内容区域面板的背景色
		// jf.getContentPane().setBackground(Color.RED);

		// 显示窗体
		jf.setVisible(true);

	}
}
