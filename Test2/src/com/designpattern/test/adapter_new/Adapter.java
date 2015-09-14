package com.designpattern.test.adapter_new;
/**
 * 适配器模式（Adapter）
 * 
 * 将一个类的接口装换为客户端希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的类可以一起工作
 * @author Administrator
 *
 */
public class Adapter {
	public static void main(String[] args) {
		Target target = new Adapter1(new Adaptee());
		target.adapterMethod();
	}
}

interface Target{
	void adapterMethod();
}

class Adapter1 implements Target{
	private Adaptee adaptee;
	
	public Adapter1(Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	
	@Override
	public void adapterMethod() {
		System.out.println("Adaptor Method");
		adaptee.adapteeMethod();
	}
}

class Adaptee{
	void adapteeMethod(){
		System.out.println("Adaptee Method");
	}
}
