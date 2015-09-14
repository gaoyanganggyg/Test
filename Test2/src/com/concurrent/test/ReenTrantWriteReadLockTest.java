package com.concurrent.test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ---------------- ReentrantWriteReadLock ---------------------
 * 
 * Java.utils.concurrent包中还有个ReadWriteLock接口(实现类是ReentrantWriteReadLock)，
 * 它定义一对锁：读锁，写锁，特征能够被并发的读取但每次只能有一个写操作。
 * @author Administrator
 *
 */
public class ReenTrantWriteReadLockTest implements Runnable{
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	int a;
	
	public static void main(String[] args) {
		ReenTrantWriteReadLockTest test = new ReenTrantWriteReadLockTest();
		test.run();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		test.run();
		test.run();
	}
	
	@Override
	public void run() {
		read();
		write();
	}

	void read() {
		lock.readLock().lock();
		System.out.println(a);
		lock.readLock().unlock();
	}

	void write() {
		lock.writeLock().lock();
		System.out.println(++a);
		lock.writeLock().unlock();
	}

}
