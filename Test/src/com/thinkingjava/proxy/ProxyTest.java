package com.thinkingjava.proxy;

public class ProxyTest {
	public static void main(String[] args) {
		SayHello sayHello = new SayHelloImpl();
		Proxy1 proxy1 = new Proxy1(sayHello);
		proxy1.create().sayHello();
	}
}
