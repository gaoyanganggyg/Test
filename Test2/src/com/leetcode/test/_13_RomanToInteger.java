package com.leetcode.test;

/**
 * Given a roman numeral, convert it to an integer.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @author Administrator
 *
 */
public class _13_RomanToInteger {
	public static int romanToInt(String s) {
		if(null == s || "".equals(s.trim())) return -1;
		char[] characterArray = new char[]{'a'};
		for (int i = s.length() - 1; i >= 0; i--) {
			char characterI = s.charAt(i);
			
		}
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(romanToInt(""));
	}
}
