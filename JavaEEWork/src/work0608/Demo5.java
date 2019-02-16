package work0608;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author LiuXu
 * @time2018年6月8日下午8:15:13
 **/
public class Demo5 extends JFrame {
	JLabel jl1;//文本显示框

	public static void main(String[] args) {
		new Demo5();

	}

	public Demo5() {


		jl1 = new JLabel();
		jl1.setText("<html><div style='font-size:20px'>登录失败</div></html>");
		this.add(jl1);
		// 设置其他属性
		this.setTitle("多种布局");
		this.setSize(300, 300);
		this.setLocation(200, 300);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setVisible(true);
	}
}
