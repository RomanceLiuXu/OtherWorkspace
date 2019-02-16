package com.lanou;

import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 图形界面
 * 
 * @author LiuXu
 * @time2018年6月8日上午9:15:36
 **/
public class Demo1 {

	/*
	 * 主函数
	 */
	public static void main(String[] args) {

		// 实例化
		JFrame jf = new JFrame();
		// 设置窗体样式
		// 设置标题
		jf.setTitle("第一个窗体");
		// 设置大小
		jf.setSize(200, 200);
		// 设置窗体的位置
		jf.setLocation(200, 300);
		// 设置图标
		ImageIcon imageIcon = new ImageIcon("/Users/xalo/Documents/oneworkspaces/java02_01/img/气球.png");
		jf.setIconImage(imageIcon.getImage());
		// 退出时关闭
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// 设置禁止改变窗体
		jf.setResizable(false);

		// 显示窗体
		jf.setVisible(true);
		// 窗口的图标

	}
}
