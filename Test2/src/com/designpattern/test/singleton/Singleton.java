package com.designpattern.test.singleton;

public class Singleton {
	public static void main(String[] args) {
		Singleton1 singleton1 = Singleton1.getInstance();
		singleton1.sayHello("hello");
		
		Singleton2 singleton2 = Singleton2.getInStance();
		singleton2.sayHello("hello");
	}
}

interface Hello {
	void sayHello(String str);
}

/**
 * 饿汉模式
 * 
 * @author Administrator
 *
 */
class Singleton1 implements Hello {
	private static Singleton1 singleton = new Singleton1();

	public Singleton1() {
	}

	public static Singleton1 getInstance() {
		return singleton;
	}

	@Override
	public void sayHello(String str) {
		System.out.println("Singleton1 " + str);
	}
}

/**
 * 懒汉模式
 * 
 * @author Administrator
 *
 */
class Singleton2 implements Hello {
	private static Singleton2 singleton2;

	public Singleton2() {
	}

	public synchronized static Singleton2 getInStance() {
		if (null == singleton2) {
			synchronized (Singleton2.class) {
				if (null == singleton2)
					singleton2 = new Singleton2();
			}
		}
		return singleton2;
	}

	@Override
	public void sayHello(String str) {
		System.out.println("Singleton2 " + str);
	}
}