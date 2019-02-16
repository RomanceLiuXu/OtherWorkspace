package work0608;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author LiuXu
 * @time2018年6月8日下午6:58:56
 **/
public class Demo1 extends JFrame {
	JLabel jl1, jl2;// 文本显示框
	JPanel jp1, jp2;// 面板
	JCheckBox jbox;// 复选框
	JList<String> jList;// 列表框
	JScrollPane jsp;// 滚动条
	JComboBox<String> jcBox;// 下拉框

	public static void main(String[] args) {
		new Demo1();

	}

	public Demo1() {

		// 实例化
		jp1 = new JPanel();
		jl1 = new JLabel("你的籍贯");
		String[] strings = { "陕西", "山西", "广东", "四川" };
		jcBox = new JComboBox<>(strings);

		// 添加到面板1上
		jp1.add(jl1);
		jp1.add(jcBox);
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER));

		// 添加到窗体上
		this.add(jp1, BorderLayout.NORTH);

		// 实例化
		jp2 = new JPanel();
		jl2 = new JLabel("你喜欢的地方");
		String[] str = { "三亚", "九寨沟", "兵马俑", "华清池" };
		jList = new JList<>(str);
		jsp = new JScrollPane(jList);

		jList.setVisibleRowCount(2);

		// 添加到面板上
		jp2.add(jl2);
		jp2.add(jsp);

		// 添加到窗体上
		this.add(jp2, BorderLayout.SOUTH);

		// 设置其他属性
		this.setTitle("多种布局");
		this.setSize(300,300);
		this.setLocation(200,300);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setVisible(true);

	}

}
