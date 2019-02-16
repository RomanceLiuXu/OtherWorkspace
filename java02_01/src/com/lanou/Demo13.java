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
 * 点我连续变色
 * 
 * @author LiuXu
 * @time2018年6月8日下午4:49:15
 **/
public class Demo13 extends JFrame {

	JButton jb1;// 按钮
	JFrame jf = this;

	public static void main(String[] args) {
		new Demo13();
	}

	public Demo13() {
		jb1 = new JButton("点我变色");
		/*
		 * 点击事件
		 */
		jb1.addActionListener(new ActionListener() {
			int i = 1;

			@Override
			public void actionPerformed(ActionEvent e) {
				if (i % 2 == 1) {
					jf.getContentPane().setBackground(Color.RED);

				} else {
					jf.getContentPane().setBackground(Color.BLUE);
				}
				i++;
			}
		});

		this.add(jb1);

		this.setTitle("点击事件");
		this.setSize(300, 200);
		this.setLocation(200, 300);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setVisible(true);

	}

}
