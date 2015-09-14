package com.concurrent.test;

/**
 * 
 * ---------------- synchronized---------------------
 * 
 * 1、 用Synchronized修饰一个对象时，当修改对象的一个字段，Synchronized能保证其他线程对该对象的读写操作能够获取修改后的值。
 * 	    需要注意的是修改同步块以外的数据或者Synchronized没有修饰当前被修改的对象，那么不能保证其他线程读到这些最新数据
 * 
 * 2、 Synchronized能修饰一个对象实例中的函数或者。
 * 	    在一个非静态方法中this关键字表示表示当前实体对象，在一个Synchronized修饰的静态方法中，这个方法所在的类使用Class对象作为实例对象
 * 
 * 3、 Synchronized锁住的是括号里面的对象，而不是代码
 * 
 * 4、 即使两个不同的代码段，都要锁住同一个对象，那么两个代码段也不能在多线程环境下通时运行
 * 
 * 5、Synchronized(T1.class)实现了全局锁的效果
 * @author Administrator
 *
 */
public class ConcurrentTest {
	
	public static void main(String[] args) {
		T1 t1 = new T1();
		for(int i = 0; i < 5; i++){
			Threads threads = new Threads(t1);
			threads.run();
		}
	}

}

class Threads implements Runnable{
	T1 t1;
	
	public Threads(T1 t1) {
		this.t1 = t1;
	}
	
	@Override
	public void run() {
		t1.test();
	}
}

class T1{
	void test(){
		synchronized (this) {
			System.out.println("start...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("finished...");
		}
	}
}



