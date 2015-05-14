package com.sort.test;

public class T2 {
	public static void main(String[] args) {
		int temp = 101;
		int sum = 0;
		while(temp > 0){
			sum = sum * 10 + temp % 10;
			temp /= 10;
		}
		System.out.println(sum);
	}
}
