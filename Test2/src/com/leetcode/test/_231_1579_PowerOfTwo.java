package com.leetcode.test;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author Administrator
 *
 */
public class _231_1579_PowerOfTwo {
	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(1));
	}

	public static boolean isPowerOfTwo(int n) {
		if (n <= 0)
			return false;
		while (n % 2 == 0) {
			n /= 2;
		}
		if (n == 1)
			return true;
		return false;
	}
}
