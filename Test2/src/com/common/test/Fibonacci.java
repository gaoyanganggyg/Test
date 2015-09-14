package com.common.test;

public class Fibonacci {
	public static void main(String[] args) {
		int result = iterator(10);
		System.out.println(result);
	}
	
	static int recursive(int n){
		if(n <= 0) return 0;
		if(n == 1) return 1;
		return recursive(n - 1) + recursive(n - 2);
	}
	
	static int iterator(int n){
		if(n <= 0) return 0;
		if(n == 1) return 1;
		int numOne = 0;
		int numTwo = 1;
		for(int i = 2; i <= n; i++){
			int temp = numTwo;
			numTwo = numOne + numTwo;
			numOne = temp;
		}
		return numTwo;
	}
	
}
