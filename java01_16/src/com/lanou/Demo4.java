package com.lanou;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * 
 * @author LiuXu
 * @time2018年6月5日下午4:03:04
 **/
public class Demo4 {

	/*
	 * 主函数
	 */
	public static void main(String[] args) {
		// 线程池:我们只要将我们需要执行的任务交给线程池，它就会帮我们分配或者创建线程来执行，不需要我们手动处理
		// 分类：
		// 1.缓存线程池 newCachedThreadPool
		// 2.指定最大并发数的线程池newFixedThreadPool
		// 3.执行周期:newScheduledThreadPool线程池不光能指定最大并发数，并且还可以指定延时时刻，才能执行下一个任务
		//    3.1scheduleWithFixedDelay:等上一个任务结束了，才开始计时间隔时间，间隔时间一到，才能执行下一个任务
		//    3.2scheduleAtFixedRate:任务一开始就计算间隔时间，如果任务时间少于间隔时间，按间隔时常，如果大于，就是任务的执行时间
		// 4.单个线程池newFixedThreadPool
 
		// 获取缓存线程池对象
		ExecutorService es = Executors.newCachedThreadPool();
		// 循环添加任务
		for (int i = 0; i < 10; i++) {
			// 使用缓存线程池执行任务
			es.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName() + "我是缓存线程池，正在执行任务");

				}
			});
		}
		// 使用自己创建的线程执行任务
		es.execute(new Test());
		es.execute(new Test());
		es.execute(new Test());
		es.execute(new Test());
		es.execute(new Test());
		// 关闭线程池
		es.shutdown();

		// // 指定并发数线程池
		// ExecutorService es = Executors.newFixedThreadPool(5);
		// for (int i = 0; i < 6; i++) {
		// es.execute(new Runnable() {
		// @Override
		// public void run() {
		// System.out.println(Thread.currentThread().getName() + "正在执行任务");
		// }
		// });
		// }
		// es.shutdown();

		ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
		// 参数：
		// command：Runable类型的对象--要执行的任务
		// initialDelay :第一次执行任务间隔的时间
		// period:每次间隔的时间(在执行任务开始时计时)
		// unit:时间的单位
		// ses.scheduleAtFixedRate(new Runnable() {
		// // 标示，记录循环的次数
		// int n = 0;
		//
		// @Override
		// public void run() {
		// n++;
		// if (n > 10) {
		// ses.shutdown();
		// }
		// try {
		// Thread.sleep(2000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }
		// System.out.println(Thread.currentThread().getName() + "执行任务");
		// }
		// }, 0, 1, TimeUnit.SECONDS);

		// 参数：
		// command：Runable类型的对象--要执行的任务
		// initialDelay :第一次执行任务间隔的时间
		// period:每次间隔的时间
		// unit:时间的单位
		// ses.scheduleWithFixedDelay(new Runnable() {
		// int n = 0;
		//
		// @Override
		// public void run() {
		// n++;
		// if (n > 9) {
		// ses.shutdown();
		// }
		// System.out.println(Thread.currentThread().getName() + "执行任务");
		//
		// }
		// }, 0, 1, TimeUnit.SECONDS);

		// // 单个线程池
		// ExecutorService es = Executors.newFixedThreadPool(1);
		// for (int i = 0; i < 6; i++) {
		// es.execute(new Runnable() {
		// @Override
		// public void run() {
		// System.out.println(Thread.currentThread().getName() + "正在执行任务");
		// }
		// });
		// }
		// es.shutdown();

	}
}

class Test implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + "执行任务");

	}

}