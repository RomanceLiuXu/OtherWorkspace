package com.lanou.myTest;

/**
 * 计算器界面类：请求发送者
 * 
 * @author mzy
 * @time 2018年8月15日下午8:26:48
 **/
public class CalculatorForm {
	private AbstractCommand command;

	public AbstractCommand getCommand() {
		return command;
	}

	public void setCommand(AbstractCommand command) {
		this.command = command;
	}

	// 调用命令对象执行方法执行运算
	public void comute(int value) {
		int i = command.execute(value);
		System.out.println("执行运算，结果为 " + i);
	}
	// 调用命令对象撤销的方法
	public void  undo() {
		int i=command.undo();
		System.out.println("执行撤销，结果为"+i);
	}
}
