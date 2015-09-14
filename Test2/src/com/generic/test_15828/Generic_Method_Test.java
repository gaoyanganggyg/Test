package com.generic.test_15828;
/**
 * 泛型方法
 * @author Administrator
 *
 */
public class Generic_Method_Test {
	
	static <T extends Object> T create(T t){
		return t;
	}
	
	static <T> void add(T num1, T num2){
		System.out.println(num1 + " + " + num2);
	}
	
	public static void main(String[] args) {
		System.out.println(create(10));
		System.out.println(create("hello"));
		
		add(10, "hello");

	}

}
