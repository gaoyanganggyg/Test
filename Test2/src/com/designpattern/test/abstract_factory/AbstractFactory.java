package com.designpattern.test.abstract_factory;
/**
 * 抽象工厂模式
 * 为创建一组相关或相互依赖的对象提供一个接口，而且无需指定他们的具体类
 * @author Administrator
 *
 */
public class AbstractFactory {
	public static void main(String[] args) {
		Factory factory = new FactoryImlp();
		factory.creaProduct1().show();
		factory.creaProduct2().show();
	}
}

interface Factory{
	Product1 creaProduct1();
	Product2 creaProduct2();
}

interface Product1{
	void show();
}

interface Product2{
	void show();
}

class Product1Impl implements Product1{
	@Override
	public void show() {
		System.out.println("Product1Impl show");
	}
}

class Product2Impl implements Product2{
	@Override
	public void show() {
		System.out.println("Produce2Impl show");
	}
}

class FactoryImlp implements Factory{
	@Override
	public Product1 creaProduct1() {
		return new Product1Impl();
	}
	
	@Override
	public Product2 creaProduct2() {
		return new Product2Impl();
	}
}


