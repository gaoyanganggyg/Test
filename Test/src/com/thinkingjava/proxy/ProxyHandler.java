package com.thinkingjava.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
	private SayHello sayHello;
	public ProxyHandler(SayHello sayHello){
		this.sayHello = sayHello;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("Before invoke");
		Object object =  method.invoke(sayHello, args);
		System.out.println("After invoke");
		return object;
	}
}
