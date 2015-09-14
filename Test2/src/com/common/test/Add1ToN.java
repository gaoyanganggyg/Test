package com.common.test;

public class Add1ToN {
	public static void main(String[] args) {
		int result = iterator(100);
		System.out.println(result);
	}
	
	static int recursive(int n){
		return n <= 0 ? 0 : n + recursive(n - 1);
	}
	
	static int iterator(int n){
		int result = 0;
		for(int i = 1; i <= n; i++){
			result  += i;
		}
		return result;
	}
	
}
