package com.lanou;

/**
 *
 * @author LiuXu
 * @time2018年8月23日下午2:14:24
 **/
public abstract class Command {
	
	// 命令执行的方法
	public abstract int execute(int value);

	// 命令取消的方法

	public abstract int update();

}
