package com.thinkingjava.proxy;

public class SayHelloImpl implements SayHello {
	@Override
	public void sayHello() {
		System.out.println("Hello");
	}
}
