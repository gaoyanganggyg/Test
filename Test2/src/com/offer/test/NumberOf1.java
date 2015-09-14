package com.offer.test;
/**
 * 二进制中1的个数
 * @author Administrator
 *
 */
public class NumberOf1 {
	public static void main(String[] args) {
		System.out.println(NumberOf(-10));
		System.out.println(numOf1(-10));
	}

	static int NumberOf(int n) {
		int flag = 1;
		int count = 0;
		while (flag != 0) {
			if ((n & flag) != 0)
				count++;
			flag <<= 1;
		}
		return count;
	}
	
	static int numOf1(int n){
		int count = 0;
		while(n != 0){
			count++;
			n = (n - 1) & n;
		}
		return count;
	}
	
}
