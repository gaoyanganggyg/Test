package com.concurrent.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1、在javaSE 5 中新添加了java.util.locks.Condition接口。Condition不仅在API中实现了wait/notify语义，而且提供了几个新的特性，例如：为每个Lock创建多个Condition、
 * 	  可中断的等待、访问统计信息等。Condition是通过Lock示例产生的
 * 	  
 * @author Administrator
 *
 */
public class ConcurrentConditionTest extends Thread {
	 ReentrantLock locks;
	Condition condition;
	volatile boolean flag;
	
	public ConcurrentConditionTest(ReentrantLock locks, Condition condition) {
		this.locks = locks;
		this.condition = condition;
	}
	
	@Override
	public void run() {
		//waitTillChange();
		change();
	}
	
	
	void waitTillChange(){
		locks.lock();
		try {
			System.out.println(flag);
			while(! flag){
				condition.await();
				System.out.println("wait finished");
			}
		} catch (InterruptedException e) {
			
		}finally{
			locks.unlock();
		}
	}
	
	void change(){
		locks.lock();
		flag = true;
		condition.notifyAll();
		locks.unlock();
	}
	
	public static void main(String[] args) {
		ReentrantLock l = new ReentrantLock();
		ConcurrentConditionTest test = new ConcurrentConditionTest(l, l.newCondition());
		
		test.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//test.change();
		
	}
	
}
