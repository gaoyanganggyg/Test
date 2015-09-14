package com.concurrent.test;

/**
 * ---------------- volatile ---------------------
 * 1、volatile修饰符用来标注一个字段，表明任何一个字段修改都必须能被随后的线程获取到，这个修饰符合同步无关。
 * 	    因此，volatile修饰的数据的可见性和synchronization类似，但是该修饰符只用于字段的读写操作。
 * 
 * 2、要使volatile变量提供线程安全，必须满足以下两个条件：
 * 	 (1)、对变量的写操作不依赖于当前值
 * 	 (2)、改变量没有包含在具有其他变量的不等式中
 * 
 * 3、 使用volatile修饰一个数组并不能让这个数组的每个元素拥有volatile特性，
 * 	    这种申明只是让这个数组reference具有volatile属性。数组被声明为AtomicIntegetArray类型，则能拥有类似
 *    volatile的特性
 * @author Administrator
 *
 */
public class VolatileTest implements Runnable {
	volatile boolean stop;

	void stopProcess() {
		stop = true;
	}

	@Override
	public void run() {
		while (false == stop) {
			System.out.println("stop is false");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("stop is true");
	}

	public static void main(String[] args) {
		VolatileTest test = new VolatileTest();
		test.run();
		
		test.stopProcess();
		
	}
}
