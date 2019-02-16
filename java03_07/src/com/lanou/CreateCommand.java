package com.lanou;

/**
 *
 * @author LiuXu
 * @time2018年8月23日下午2:20:19
 **/
public class CreateCommand extends Command {

	private Add1 add;
    private int value;
	@Override
	public int execute(int value) {
		add.add(value);
       return 0;
	}

	@Override
	public int update() {
	
		return 0;
	}

}
