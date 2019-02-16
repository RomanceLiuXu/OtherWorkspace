package work0608;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

/**
 *
 * @author LiuXu
 * @time2018年6月8日下午8:15:13
 **/
public class Demo4 extends JFrame {
	JLabel jl1;//文本显示框

	public static void main(String[] args) {
		new Demo4();

	}

	public Demo4() {

		jl1 = new JLabel();
		if (Demo3.is) {
			jl1.setText("<html><div style='font-size:20px'>登录成功</div></html>");
		}else{
			jl1.setText("<html><div style='font-size:20px'>登录失败</div></html>");
		}
		
		this.add(jl1,BorderLayout.CENTER);
		// 设置其他属性
		this.setTitle("多种布局");
		this.setSize(300, 300);
		this.setLocation(200, 300);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setVisible(true);
	}
}
