package com.leetcode.test;

import java.util.Arrays;
import java.util.Comparator;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Given two strings s and t, write a function to determine if t is an anagram
 * of s.
 * 
 * For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car",
 * return false.
 * 
 * Note: You may assume the string contains only lowercase alphabets.
 * 
 * @author Administrator
 *
 */
public class _242_1585_ValidAnagram {
	public static boolean isAnagram(String s, String t) {
		if(null == s || null == t) return false;
		
		char[] charArrayS = s.toCharArray();
		char[] charArrayT = t.toCharArray();
		
		Arrays.sort(charArrayS);
		Arrays.sort(charArrayT);

		int lengthS = charArrayS.length;
		int lengthT = charArrayT.length;
		if(lengthS != lengthT ) return false;
		
		for(int i = 0; i < lengthS; i++){
			if(charArrayS[i] != charArrayT[i]) return false;
		}
		return true;
	}
	 

	public static void main(String[] args) {
		System.out.println(isAnagram("angram", "nagaram"));
	}
}
