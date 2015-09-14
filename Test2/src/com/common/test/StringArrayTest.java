package com.common.test;

public class StringArrayTest {
	public static void main(String[] args) {
		test();
		
		test1();
	}
	
	public static void test() {
		String str = "hello";
		char[] c = {'h', 'e', 'l', 'l', 'o' };
		
		char[] ch = str.toCharArray();
		
		if(ch == c){
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		if(ch.equals(c)){
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}
	
	public static void test1() {
		String str = "2015-04-15 02:31:04"; 
		String str2 = "";
		String[] result = str.split("[^0-9]");
		for(String str3 : result){
			str2 += str3;
		}
		System.out.println(str2);
	}
	

}
