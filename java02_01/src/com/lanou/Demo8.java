package com.lanou;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 * 常用的控件
 * 
 * @author LiuXu
 * @time2018年6月8日下午2:33:56
 **/
public class Demo8 extends JFrame {
	// 文本显示框
	JLabel jl1;
	// 文本输入框
	JTextField jt1;
//	密码输入框
	JPasswordField jpf;

	/*
	 * 主函数
	 */
	public static void main(String[] args) {
		new Demo8();

	}

	/*
	 * 空的构造方法
	 */
	public Demo8() {
		// 实例化
		jl1 = new JLabel();
		// 设置显示的文本
		// jl1.setText("蓝鸥科技");
		// 添加显示文本到窗体
		jl1.setText("<html><div style='font-size:10px'>蓝鸥科技</div></html>");
		// jl1.setText("<html><a></a></html>");
		// 实例化
		jt1 = new JTextField();
		// 实例化文本输入框
		jt1.setSize(300, 100);
		jt1.setPreferredSize(new Dimension(100, 50));

		this.add(jt1);
		this.add(jl1);
		
		jpf = new JPasswordField();
		jpf.setPreferredSize(new Dimension(100, 25));

		// 其他属性
		this.setTitle("常用控件");
		this.setLocation(200, 300);
		this.setSize(300, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setVisible(true);
	}

}
