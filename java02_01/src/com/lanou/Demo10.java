package com.lanou;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

/**
 * 常用控件2
 * 
 * @author LiuXu
 * @time2018年6月8日下午3:57:47
 **/
public class Demo10 extends JFrame {
	// 复选框
	JCheckBox jcb1, jcb2;
	// 单选框
	JRadioButton jrb1, jrb2;
	// 存放单选按钮的容器
	ButtonGroup bg1;
	JComboBox<String> jbox1;//下拉框
	
	JList<String> jList;//列表框

	JScrollPane jsp;//滚动条
	
	public static void main(String[] args) {
		new Demo10();
	}

	public Demo10() {
		// 实例化复选框
		jcb1 = new JCheckBox();
		jcb1.setText("选项一");
		this.add(jcb1);
		jcb2 = new JCheckBox();
		jcb2.setText("选项二");
		this.add(jcb2);
		// 实例化单选框
		jrb1 = new JRadioButton("男");
		jrb2 = new JRadioButton("女");
		// 将单选加入到容器中
		bg1 = new ButtonGroup();
		bg1.add(jrb1);
		bg1.add(jrb2);
		this.add(jrb1);
		this.add(jrb2);
		
		String[] strs = {"西安","渭南","宝鸡","临潼","咸阳"}; 
		jbox1 = new JComboBox<>(strs);
		this.add(jbox1);

		jList = new JList<>(strs);
		this.add(jList);
		
		jsp = new JScrollPane(jList);
//		jsp.setVisible(true);
		jList.setVisibleRowCount(3);
		this.add(jsp);
		// 设置其他属性
		this.setTitle("多种布局");
		this.setSize(300, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.setVisible(true);

	}
}
