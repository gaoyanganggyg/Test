package com.common.test;



public class Type_Test {
	public static void main(String[] args) {
		System.out.println("Byte " + Byte.MIN_VALUE + "~" + Byte.MAX_VALUE);
		System.out.println("Character " + Character.MIN_VALUE + "~" + Character.MAX_VALUE);
		System.out.println("Short " + Short.MIN_VALUE + "~" + Short.MAX_VALUE);
		System.out.println("Integer " + Integer.MIN_VALUE + "~" + Integer.MAX_VALUE);
		System.out.println("Long " + Long.MIN_VALUE + "~" + Long.MAX_VALUE);
		
		byte a = 10;
		short b = 5;
		int c = a + a;
		
		int d = -2;
		int e = d >> 1;
		System.out.println(Integer.toBinaryString(e));
		
		
		Integer integer = 10;
		int f = 10;
		System.out.println(integer == f);
		
	}
}
