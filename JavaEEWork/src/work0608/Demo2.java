package work0608;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.WindowConstants;

/**
 *
 * @author LiuXu
 * @time2018年6月8日下午7:39:57
 **/
public class Demo2 extends JFrame {
	JLabel jl1, jl2;// 文本显示框
	JCheckBox jbox1, jbox2, jbox3;// 复选框
	JRadioButton jrb1, jrb2;// 单选框
	JPanel jp1, jp2, jp3;// 面板
	JButton jb1, jb2;// 按钮
	ButtonGroup bgp;// 容器，用来存放单选框

	public static void main(String[] args) {
		new Demo2();
	}

	public Demo2() {
		// 实例化
		jp1 = new JPanel();
		jl1 = new JLabel("你喜欢的运动");
		jbox1 = new JCheckBox("足球");
		jbox2 = new JCheckBox("篮球");
		jbox3 = new JCheckBox("羽毛球");

		// 添加到面板1上
		jp1.add(jl1);
		jp1.add(jbox1);
		jp1.add(jbox2);
		jp1.add(jbox3);

		// 添加到窗体上
		this.add(jp1, BorderLayout.NORTH);

		// 实例化
		jp2 = new JPanel();
		jl2 = new JLabel("你的性别");
		jrb1 = new JRadioButton("男");
		jrb2 = new JRadioButton("女");
		bgp = new ButtonGroup();
		// 添加到容器中
		bgp.add(jrb1);
		bgp.add(jrb2);

		// 添加到面板2上
		jp2.add(jl2);
		jp2.add(jrb1);
		jp2.add(jrb2);

		// 添加到窗体上
		this.add(jp2, BorderLayout.CENTER);

		// 实例化
		jp3 = new JPanel();
		jb1 = new JButton("注册用户");
		jb2 = new JButton("取消注册");

		// 添加到面板3上
		jp3.add(jb1);
		jp3.add(jb2);

		// 添加到窗体上
		this.add(jp3, BorderLayout.SOUTH);

		// 设置其他属性
		this.setTitle("多种布局");
		this.setSize(300, 300);
		this.setLocation(200, 300);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
