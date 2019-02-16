package com.lanou.myTest;
/**
* 具体命令类
* @author mzy
* @time 2018年8月15日下午8:22:56
**/
public class ConcreteCommand extends AbstractCommand{
  private Adder adder=new Adder();
  private int value;
	@Override
	public int execute(int value) {
		this.value=value;
		return adder.add(value);		
	}

	@Override
	public int undo() {
		
		return adder.add(-value);
	}

}
