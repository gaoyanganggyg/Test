package com.concurrent.test;

import java.util.List;

/**
 * 1、start（）：启动一个新的线程，新的线程会执run（）方法。start（）不能被重复调用
 * 2、run（）：就和普通 的成员方法一样，可以重复被调用。单独调用run（）方法会在当前线程中调用run（）方法，而不会启动新线程
 * 
 * 
 * 3、thread.join 把指定的线程加入到当前线程当中，可以将两个交替执行的线程合并为顺序执行的线程。比如在线程B中调用了线程A的join（）方法，
 * 		直到线程A结束后才继续执行线程B
 * 4、join（）作用：让“主线程”等待“子线程”结束后才能继续运行
 * 
 * 5、抛出InterruptedException和Thread.interrupted（）检查是否发生了中断
 *		（1）、 在阻塞操作是中断，如Thread.sleep（）时会抛出InterruptedException
 * 	 		  （注意：进行不能中断的IO操作而阻塞和要获取对象锁，调用synchronized方法而阻塞时不会抛出InterruptException）
 * 		（2）、Thread.interrupted（）检查是否发生中断。Thread.interrupted()能显示线程是否发生了中断，并清除中断标记，所以程序不会两次通知发生中断
 * 	 
 * @author Administrator
 *
 */
public class Thread_Join_Start_Run_Interrupt_Test implements Runnable {
	public static void main(String[] args) {
		Thread_Join_Start_Run_Interrupt_Test test = new Thread_Join_Start_Run_Interrupt_Test();
		
		Thread t1 = new Thread(test);
		
		t1.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//System.out.println(t1.isInterrupted());
		t1.interrupt();
		System.out.println("t1 is interrupted");
		//System.out.println(t1.isInterrupted());
	}
	
	@Override
	public void run() {
		int k = 0;
//		try {
//			for(int i = 0; i < 5; i++){
//				System.out.println(++k);
//				Thread.sleep(500);
//			}
//			
//		} catch (InterruptedException e) {
//			System.out.println("occur");
//		}
		
		boolean isInterrupted = false;
		while( ! (isInterrupted = Thread.interrupted())){
			System.out.println(++k);
			System.out.println(isInterrupted ? "-----true-----" : "false");
		}
	}
}
