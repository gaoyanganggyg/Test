package com.gyg.test;

import org.apache.log4j.Logger;

public class Test  extends Test11 {
	public  Animal hello() {
		return new Animal() {
			void eat() {
				System.out.println("eat");
			}
		};
	}

	public static void main(String[] args) {
		Logger logger = Logger.getLogger(Test.class);
		Test test = new Test();
		test.hello().eat();
		test.sayHello();
		test.hello().sleep();
	}
}
abstract class Animal{
	abstract void eat();
	void sleep(){
		System.out.println("sleep");
	}
}

class Test11{
	public void sayHello(){
		System.out.println("say Hello");
	}
}



