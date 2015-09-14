package com.designpattern.test.facade;
/**
 * 外观模式（Facade）
 * 
 * 为将系统中的一组接口提供一个统一的界面，此模式定义了一个高层接口，这个接口使得这一子系统更加容易使用
 * @author Administrator
 *
 */
public class Facade {
	public static void main(String[] args) {
		Face1 face1 = new Face1();
		face1.methodA();
		face1.methodB();
	}
}

class Face1{
	private Service1 service1;
	private Serivce2 serivce2;
	
	public Face1() {
		service1 = new Service1();
		serivce2 = new Serivce2();
	}

	void methodA(){
		service1.methodA();
	}
	
	void methodB(){
		serivce2.methodB();
	}
}


class Service1{
	void methodA(){
		System.out.println("Method A");
	}
}

class Serivce2{
	void methodB(){
		System.out.println("Method B");
	}
}