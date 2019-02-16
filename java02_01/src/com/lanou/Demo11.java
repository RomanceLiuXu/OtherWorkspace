package com.lanou;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * 点击事件
 * @author LiuXu
 * @time2018年6月8日下午4:49:15
 **/
public class Demo11 extends JFrame implements ActionListener {

	JButton jb1, jb2;// 按钮
	JFrame jf = this;

	public static void main(String[] args) {
		new Demo11();
	}

	public Demo11() {
		jb1 = new JButton("点我变色");
		jb2 = new JButton("点我跳转");
		this.add(jb1);
		this.add(jb2);
		// 给按钮绑定监听事件
		jb1.addActionListener(this);
		jb2.addActionListener(this);

		this.setTitle("点击事件");
		this.setSize(300, 200);
		this.setLocation(200, 300);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setVisible(true);

	}

	/**
	 * 接口的实现方法
	 * 
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton jButton = (JButton)e.getSource();
		if (jButton.getText().equals("点我变色")) {
			this.getContentPane().setBackground(Color.RED);
		}else{
			Demo10 demo10 = new Demo10();
			this.setVisible(false);
		}
		
	}

}
