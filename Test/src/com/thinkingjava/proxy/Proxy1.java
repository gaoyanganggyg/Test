package com.thinkingjava.proxy;

import java.lang.reflect.Proxy;

public class Proxy1 {
	private SayHello sayHello;
	 public Proxy1(SayHello sayHello) {
		 this.sayHello = sayHello;
	 }
	public SayHello  create() {
		SayHello sayHelloObj = (SayHello)Proxy.newProxyInstance(
				SayHello.class.getClassLoader(), 
				new Class<?>[]{SayHello.class}, 
				new ProxyHandler(sayHello));
		return sayHelloObj;
	}
}
