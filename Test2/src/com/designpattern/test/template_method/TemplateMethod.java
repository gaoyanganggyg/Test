package com.designpattern.test.template_method;
/**
 * 模板方法模式
 * 定义一个操作中算法的框架，而将进一步骤延迟到子类中，使得子类可以不改变算法的结构即可重定义算法中的某些步骤
 * @author Administrator
 *
 */
public class TemplateMethod {
	public static void main(String[] args) {
		Animal animal = new Dog();
		animal.hello();
		animal.show();
	}
}

abstract class Animal{
	abstract void hello();
	final void show(){
		System.out.println("Hello");
	}
}

class Dog extends Animal{
	@Override
	void hello() {
		System.out.println("Dog Hello");
	}
}