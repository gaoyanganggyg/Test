package com.concurrent.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
/**
 * 1、CyclicBarrier和CountDownLatch一样，都是关于线程的计数器
 *    
 * 
 * 2、使用场景是：保证线程同一时间开始执行相关代码
 * 
 * 3、CyclicBarrier具体使用步骤
 *    （1）、CyclicBarrier初始化时规定一个数目，然后计算调用CyclicBarrier.await（）进入等待线程数。当线程到达指定数目时，所有进入等待状态的线程将被唤醒继续
 *    （2）、CyclicBarrier初始化时还可以带一个Runnable参数，此Runnable任务在CyclicBarrier的数目到达到达后，所有线程唤醒前被执行
 *    
 * 4、需要指定一个计数才能初始化CountDownLatch。线程调用await（）方法进入等待状态直到计数器变为0。其他线程（或者同一线程）调用countDownLatch来减少计数。
 * 	  如果计数变为0后无法被重值。常用于当确定的操作完成后，触发数量不定的线程   
 * 
 * 
 * 5、Semaphore维护一个“许可”集，能够使用acquire（）方法检测这个“许可”集，在“许可”可用之前Semaphore会阻塞每一个acquire访问。线程能够调用release（）来返回一个许可。
 *   当Semaphore只有一个“许可”的时候，可当做一个互斥锁来使用
 *   
 * 6、线程在Exchange的exchange（）方法上进行交互，原子操作的方式交换数据。功能类似于数据可以双向传输的SynchronousQueue加强版
 * 
 * @author Administrator
 *
 */
public class CyclicBarrier_Test implements Runnable{
	CyclicBarrier cyclicBarrier;
	
	public CyclicBarrier_Test(CyclicBarrier cyclicBarrier) {
		this.cyclicBarrier = cyclicBarrier;
	}
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getId() + " starting!");
		try {
			cyclicBarrier.await();
			System.out.println(Thread.currentThread().getId() + " working!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		//CyclicBarrier==========================
		CyclicBarrier tBarrier = new CyclicBarrier(5, new Runnable() {
			@Override
			public void run() {
				System.out.println("all coming");
			}
		});
		
		CyclicBarrier_Test test = new CyclicBarrier_Test(tBarrier);
		for(int i = 0; i < 5; i++){
			Thread thread = new Thread(test);
			thread.start();
		}
		
		//CountDownLatch============================
		CountDownLatch latch = new CountDownLatch(5);
		for(int i = 0; i < 5; i++){
			CountDownLatchTest test2 = new CountDownLatchTest(latch);
			test2.start();
		}
		
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("all coming");
		
		//Semaphore============================
		for(int i = 0; i < 20; i++){
			SemaphoreTest test3 = new SemaphoreTest();
			Thread thread = new Thread(test3);
			thread.start();
		}
		
		
	}
}

//-----------------------CountDownLatch----------------------------------
class CountDownLatchTest extends Thread{
	CountDownLatch latch;
	
	public CountDownLatchTest(CountDownLatch latch){
		this.latch = latch;
	}
	
	@Override
	public void run() {
		System.out.println("正在减少");
		latch.countDown();
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}

//-----------------------Semaphore----------------------------------
class SemaphoreTest implements Runnable{
	Semaphore semaphore = new Semaphore(5);
	
	@Override
	public void run() {
		try {
			semaphore.acquire();
			
			System.out.println(Thread.currentThread().getId() + " access");
			
			Thread.sleep(2000);
			
			semaphore.release();
			
			System.out.println("avalible " + semaphore.availablePermits());
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}

