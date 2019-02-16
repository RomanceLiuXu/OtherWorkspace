package work0608;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author LiuXu
 * @time2018年6月8日下午8:00:20
 **/
public class Demo3 extends JFrame implements ActionListener {
	
	static boolean is = false;
	// 文本显示框
	JLabel jl1, jl2;
	// 文本输入框
	JTextField jtf1, jtf2;
	// 面板
	JPanel jp1, jp2, jp3;
	// 按钮
	JButton jb1, jb2;
	String user = "liuxu";
	String password = "123";

	public static void main(String[] args) {

		new Demo3();
	}

	public Demo3() {
		// 实例化
		jl1 = new JLabel("用户名");
		jl2 = new JLabel("密码");
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jb1 = new JButton("登录");
		jb2 = new JButton("退出");

		// 面板1操作
		jtf1.setPreferredSize(new Dimension(100, 25));
		jp1.add(jl1);
		jp1.add(jtf1);

		this.add(jp1, BorderLayout.NORTH);

		// 面板2操作
		jtf2.setPreferredSize(new Dimension(100, 25));
		jp2.add(jl2);
		jp2.add(jtf2);

		this.add(jp2, BorderLayout.CENTER);

		// 面板3操作
		jp3.add(jb1);
		jp3.add(jb2);

		this.add(jp3, BorderLayout.SOUTH);

		// 设置其他属性
		this.setTitle("多种布局");
		this.setSize(300, 300);
		this.setLocation(200, 300);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);

		// 监视
		jb1.addActionListener(this);
		jb2.addActionListener(this);

	}

	/**
	 * 重写父类的方法
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		JButton jButton = (JButton) e.getSource();
		if (jButton.getText().equals("登录")) {
			if (jtf1.getText().equals(user) && jtf2.getText().equals(password)) {
				is = true;
				Demo4 demo4 = new Demo4();
				this.setVisible(false);
			}else {
				Demo4 demo4 = new Demo4();
				this.setVisible(false);
			}
			
		}

	}

}
