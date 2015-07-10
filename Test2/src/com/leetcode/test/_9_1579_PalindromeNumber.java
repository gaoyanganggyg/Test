package com.leetcode.test;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author Administrator
 *
 */
public class _9_1579_PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome(11));
	}
	static boolean isPalindrome(int x){
		if(x <= -1) return false;
		int sum = 0;
		int temp = x;
		while(x > 0){
			sum = sum * 10  + x % 10;
			x /= 10;
		}
		if(sum == temp) return true;
		return false;
	}
}
