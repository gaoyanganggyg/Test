package com.common.test;
/**
 * 子类会继承父类的静态方法和静态成员变量
 * @author Administrator
 *
 */
public class Child extends Parent{
	public static void main(String[] args) {
		int a = 20;
		
		System.out.println(a);
		System.out.println(Parent.a);
		
		say();
	}
}
