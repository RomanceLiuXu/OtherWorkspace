package com.liuxu.myTest;

import java.awt.FlowLayout;

import javax.swing.JFrame;

/**
 *
 * @author LiuXu
 * @time2018年9月26日下午2:29:06
 **/
public class MyMain {

	public static void main(String[] args) {
		JFrame frame = new JFrame("统计图");
		frame.setLayout(new FlowLayout());
		frame.add(new myJfreechart().getChartPanel());
		frame.setBounds(50, 50, 800, 600);
		frame.setVisible(true);
		// ChartUtilities
	}
	
}
