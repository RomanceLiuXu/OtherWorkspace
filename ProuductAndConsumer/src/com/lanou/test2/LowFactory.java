package com.lanou.test2;

/**
 *
 * @author LiuXu
 * @time2018年8月7日上午10:09:15
 **/
public class LowFactory implements CarFactory{

	@Override
	public Engine engine() {
	
		return new LowEngine();
	}

	@Override
	public Seat seat() {
	
		return new LowSeat();
	}

}
