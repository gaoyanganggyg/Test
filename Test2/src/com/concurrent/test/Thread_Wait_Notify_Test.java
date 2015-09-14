package com.concurrent.test;
/**
 * 1、wait,notify,notifyAll 必须在synchronized修饰的代码块中执行，否则会在运行的时候抛出IllagalMonitorStateException异常
 * 
 * 2、在循环语句wait的时候一定要设定循环的条件，这样可以避免wait开始之前，线程所需的条件已被其他线程提供了却依然开始此线程的时间消耗。
 * 	  同时，这种办法能保证代码不被虚假的信息唤醒
 * 
 * 3、总是需保证调用notify和notifyAll之前，能够提供符合线程退出等待的条件。否则会出现即使线程接收到通知信息，却不能退出循环等待的情况
 * 
 * @author Administrator
 *
 */
public class Thread_Wait_Notify_Test extends Thread{
	Object object = new Object();
	volatile boolean flag = false;
	void waitTillChange(){
		synchronized (object) {
			while(!flag){
				System.out.println(flag);
				try {
					object.wait();
					System.out.println("wait finished");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("flage is true");
		}
	}
	
	@Override
	public void run() {
		waitTillChange();
	}
	
	void change(){
		synchronized (object) {
			flag = true;
			System.out.println(flag);
			object.notifyAll();
		}
	}
	
	public static void main(String[] args) {
		Thread_Wait_Notify_Test test = new Thread_Wait_Notify_Test();
		
		test.start();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		test.change();
		
	}
}
