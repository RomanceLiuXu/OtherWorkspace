package com.lanou.myTest;
/**
*测试类
* @author mzy
* @time 2018年8月15日下午8:33:27
**/
public class Test {
   public static void main(String[] args) {
	
	   CalculatorForm form=new CalculatorForm();
	   AbstractCommand command=new ConcreteCommand();
	   //向发送者注入命令对象
	   form.setCommand(command);
	   form.comute(10);
	   form.comute(7);
	   form.undo();
}
}
