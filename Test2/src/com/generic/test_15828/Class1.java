package com.generic.test_15828;
/**
 * 泛型类
 * @author Administrator
 *
 * @param <T>
 */
public class Class1<T extends Object> {
	T a;
	void sing(T t){
		System.out.println(t.hashCode());
		a = t;
	}
	
	public static void main(String[] args) {
		Class1<Integer> clazz = new Class1<>();
		
		clazz.sing(100);
		
		System.out.println(clazz.a);
	}
	
	
}
