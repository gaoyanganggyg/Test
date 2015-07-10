package com.leetcode.test;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * @author Administrator
 *
 */
public class _7_ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse(1534236469));
	}

	public static int reverse(int x) {
		if(x == 0) return 0;
		int temp = x;
		boolean lessZero =  x > 0 ? false : true;
		if(lessZero) temp = -x;
		long result = 0;
		while(temp > 0){
			int temp1 = temp % 10;
			result  = (long)result * 10 + temp1;
			temp /= 10;
		}
		if(result > Integer.MAX_VALUE) return 0;
		if(lessZero) return -(int)result;
		return (int)result;
	}
}
