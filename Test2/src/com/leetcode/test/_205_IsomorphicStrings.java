package com.leetcode.test;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * For example, Given "egg", "add", return true.
 * 
 * Given "foo", "bar", return false.
 * 
 * Given "paper", "title", return true.
 * 
 * Note: You may assume both s and t have the same length.
 * 
 * @author Administrator
 *
 */
public class _205_IsomorphicStrings {
	public static boolean isIsomorphic(String s, String t) {
		if(null == s || null == t) return false;
		HashMap<Character, Character> mapS = new HashMap<>();
		HashMap<Character, Character> mapT = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char sChar = s.charAt(i);
			char tChar = t.charAt(i);
			if(mapS.containsKey(sChar) && mapS.get(sChar) != tChar){
				return false;
			}
			if(mapT.containsKey(tChar) && mapT.get(tChar) != sChar){
				return false;
			}
			mapS.put(sChar, tChar);
			mapT.put(tChar, sChar);
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic("ab", "aa"));
	}
}
