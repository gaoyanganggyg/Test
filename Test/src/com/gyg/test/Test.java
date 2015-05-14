package com.gyg.test;

import org.apache.log4j.Logger;

/**
 * 
 * @author root
 *@see Test15
 */
public  class Test  extends Test11 {
	int a = 10;
	public void test() {
		super.name ++;
		System.out.println( "this.name    " + this.name);
		System.out.println("super.name  " + super.name);
	}
	 
	public Test(){
		System.out.println("Test");
	}
	public static void main(String[] args) {
		 Logger logger = Logger.getLogger(Test.class);
		Test test = new Test();
		test.new Test12();
		
		//test.test();
		
//		test.hello().eat();
//		test.sayHello();
//		test.hello().sleep();
	}
}
abstract class Animal{
	abstract void eat();
	void sleep(){
		System.out.println("sleep");
	}
}

class Test11{
	public Test11() {
		System.out.println("Test11");
	}
	class Test12{
		 public Test12() {
			 System.out.println("Test12");
		 }
	 }
	public  Animal hello() {
		return new Animal() {
			void eat() {
				System.out.println("eat");
			}
		};
	}
	protected int name = 3;
	public void sayHello(){
		System.out.println("say Hello");
	}
}

// class Test13 extends Test.Test12{
//public Test13(Test test) {
//	test.
//}}







