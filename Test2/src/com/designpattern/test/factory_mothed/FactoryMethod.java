package com.designpattern.test.factory_mothed;
/**
 * 工厂方法模式
 * 定义一个用于创建对象的接口，让子类决定实例化哪一个类，工厂方法使一个类的实例化延迟到其子类
 * @author Administrator
 *
 */
public class FactoryMethod {
	public static void main(String[] args) {
		Factory factory = new FactoryImpl();
		Product product = factory.createProduct(TYPE.CAR);
		product.sayHello();
	}
}

enum TYPE{
	CAR,BYCICLE	
}

interface Factory{
	public  Product createProduct(TYPE type);
}

class FactoryImpl implements Factory{
	@Override
	public  Product createProduct(TYPE type) {
		if(TYPE.BYCICLE == type)
			return new ProductImpl1();
		else
			return new ProductImpl2();
	}
}

interface Product{
	void sayHello();
}

class ProductImpl1 implements Product{
	@Override
	public void sayHello() {
		System.out.println("ProductImpl1 Hello");
	}
}

class ProductImpl2 implements Product{
	@Override
	public void sayHello() {
		System.out.println("ProductImpl2  Hello");
	}
}

