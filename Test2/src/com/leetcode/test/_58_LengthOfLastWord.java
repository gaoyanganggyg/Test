package com.leetcode.test;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space
 * characters ' ', return the length of last word in the string.
 * 
 * If the last word does not exist, return 0.
 * 
 * Note: A word is defined as a character sequence consists of non-space
 * characters only.
 * 
 * For example, Given s = "Hello World", return 5.
 * 
 * @author Administrator
 *
 */
public class _58_LengthOfLastWord {
	public static int lengthOfLastWord(String s) {
		if(null == s || "".equals(s.trim())) return 0;
		int LastWordlength = 0;
		s = s.trim();
		int start = s.length() - 1;
		while(start >= 0 && ' ' != s.charAt(start)){
			start--;
			LastWordlength++;
		}
		return LastWordlength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("  "));
	}
}
