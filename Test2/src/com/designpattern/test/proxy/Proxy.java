package com.designpattern.test.proxy;
/**
 * 代理模式（Proxy）
 * 
 * 为其他对象提供一种代理以控制对这个对象的访问
 * @author Administrator
 *
 */
public class Proxy {
	public static void main(String[] args) {
		ProxyObject proxy = new ProxyObject();
		proxy.action();
	}
}

interface ITarget{
	void action();
}

class Target implements ITarget{
	@Override
	public void action() {
		System.out.println("targeted class");
	}
}

class ProxyObject{
	Target target;
	
	public ProxyObject() {
		System.out.println("this is proxy class");
		target = new Target();
	}
	
	void action(){
		System.out.println("before proxy");
		target.action();
		System.out.println("after proxy");
	}
}



