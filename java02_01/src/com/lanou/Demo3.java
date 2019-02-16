package com.lanou;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.concurrent.ConcurrentHashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 边界布局
 * 
 * @author LiuXu
 * @time2018年6月8日上午10:13:42
 **/
public class Demo3 {
	JFrame jf;// 窗口
	JButton jb, jb1, jb2, jb3, jb4;// 按钮
	// JButton jb1;// 按钮
	// JButton jb2;// 按钮
	// JButton jb3;// 按钮
	// JButton jb4;// 按钮
	/*
	 * 主函数
	 */

	public static void main(String[] args) {

		Demo3 d3 = new Demo3();
	}

	public Demo3() {
		jf = new JFrame("边界布局");
		// 实例化按钮对象
		jb = new JButton("东");
		// 实例化按钮对象
		jb1 = new JButton("西");
		// 实例化按钮对象
		jb2 = new JButton("南");
		// 实例化按钮对象
		jb3 = new JButton("北");
		// 实例化按钮对象
		jb4 = new JButton("中");

		// 设置布局方式
		jf.add(jb, BorderLayout.EAST);
		jf.add(jb1, BorderLayout.WEST);
		jf.add(jb2, BorderLayout.SOUTH);
		jf.add(jb3, BorderLayout.NORTH);
		jf.add(jb4, BorderLayout.CENTER);

		// 窗体属性
		jf.setSize(500, 300);
		jf.setLocation(300, 200);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(Color.green);
		jf.setVisible(true);
	}

}
