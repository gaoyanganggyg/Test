package com.gyg.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;


public class T1 {
	int a1 = 0;
	int s = a1++; 
	
	static int a = 5;
	int d = 4;
	{
		System.out.println(d + "  000");
	}
	
	public  T1() {
		System.out.println(a);
		System.out.println(d);
	}
	
	public static void main(String[] args) {
		//new T1();
		//t1();
		t2();
	}

	private static  void t1() {
		String a = "gao yangang";
		char[] b= a.toCharArray();
		int hash = 0;
		for (int i = 0; i < b.length; i++) {
			hash = 31 * hash + b[i];
		}
		System.out.println(hash);
		System.out.println("gao yangang".hashCode());
	}
	private static  void t2() {
		Class clazz = T1.class;
		System.out.println(clazz.isInterface());
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getSuperclass());
		
	}
	
}
