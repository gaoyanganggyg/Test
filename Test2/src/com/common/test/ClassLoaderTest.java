package com.common.test;

public class ClassLoaderTest {
	public static void main(String[] args) {
//		t0();
//		t1();
		t2();
		t4();
	}
	
	static void t0(){
		try {
			@SuppressWarnings("unchecked")
			Class<String> clazz = (Class<String>) ClassLoader.getSystemClassLoader().loadClass("java.lang.String");
			System.out.println(clazz.hashCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		try {
			@SuppressWarnings("unchecked")
			Class<String> clazz0 = (Class<String>) Class.forName("java.lang.String");
			System.out.println(clazz0.hashCode());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	static void t1(){
		char han = '汉';
		System.out.format("%x", (short)han);
	}
	
	static void t2(){
		int j = 0;
		for(int i = 0; i < 100; i++){
			j = j++;
		}
		System.out.println(j);
	}
	
	@SuppressWarnings("unused")
	static void t3(){
		int i = 012;
		int j = 077;
		short a = 1;
		a = (short)(a + 1);
		a += 1;
	}
	
	static void t4(){
		assert (1 > 0);
		for(int i = 0 ; i <= 10; i++)
			new Integer(i);
		System.out.println("Hello World");
		
	}
	
	
	
	
	
	
}
