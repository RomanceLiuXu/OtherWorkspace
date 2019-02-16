package com.lanou.test2;

/**
 *
 * @author LiuXu
 * @time2018年8月7日上午9:54:42
 **/
public class HighFactory implements CarFactory{

	@Override
	public Engine engine() {
		
		return new HighEngine();
	}

	@Override
	public Seat seat() {
	
		return new HighSeat();
	}

}
