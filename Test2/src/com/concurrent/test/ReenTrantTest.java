package com.concurrent.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 
 * ---------------- ReentrantLock ---------------------
 * 
 *Java.util.concurrent.locks 包中有个Lock接口。ReentrantLock实现了Lock接口，它完全拥有synchronized
 *的特性，同时还提供了新的功能：获取Lock的状态，非阻塞获取锁的方法tryLock()、可中断Lock
 * @author Administrator
 *
 */

public class ReenTrantTest implements Runnable {
	Lock lock = new ReentrantLock();
	int value;
	
	public static void main(String[] args) {
		ReenTrantTest t = new ReenTrantTest();
		for(int i = 0; i < 5; i++){
			t.run();
		}
	}
	
	@Override
	public void run() {
		increment();
	}
	
	void increment(){
		lock.lock();
		 System.out.println(++value);
		 lock.unlock();
	}
}
