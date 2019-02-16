package com.lanou;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author LiuXu
 * @time2018年6月8日下午4:49:15
 **/
public class Demo12 extends JFrame {

	JButton jb1, jb2;// 按钮
	JFrame jf = this;

	public static void main(String[] args) {
		new Demo12();
	}

	public Demo12() {
		jb1 = new JButton("点我变色");
		/*
		 * 点击事件
		 */
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("点击了");
				jf.getContentPane().setBackground(Color.RED);

			}
		});

		jb2 = new JButton("点我跳转");
		jb2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 显示Demo10
				Demo10 demo10 = new Demo10();
                 jf.setVisible(false);
			}
		});

		this.add(jb1);
		this.add(jb2);
		this.setTitle("点击事件");
		this.setSize(300, 200);
		this.setLocation(200, 300);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setVisible(true);

	}

}
